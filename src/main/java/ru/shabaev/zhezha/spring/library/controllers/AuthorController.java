package ru.shabaev.zhezha.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.shabaev.zhezha.spring.library.models.Author;
import ru.shabaev.zhezha.spring.library.services.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("authors", authorService.findAll());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorService.findOne(id));
        return "authors/show";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authors/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("author", authorService.findOne(id));
        return "authors/edit";
    }

    @PostMapping()
    public String create(@ModelAttribute Author author) {
        authorService.save(author);
        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        authorService.delete(id);
        return "redirect:/home";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Author author,@PathVariable("id") int id) {
        authorService.update(id, author);
        return "redirect:/home";
    }
}
