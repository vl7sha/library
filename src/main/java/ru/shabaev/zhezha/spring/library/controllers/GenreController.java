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

import ru.shabaev.zhezha.spring.library.models.Genre;
import ru.shabaev.zhezha.spring.library.services.GenreService;

@Controller
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService authorService) {
        this.genreService = authorService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("genres", genreService.findAll());
        return "authors/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.findOne(id));
        return "authors/show";
    }

    @GetMapping("/new")
    public String newAuthor(Model model) {
        model.addAttribute("genre", new Genre());
        return "authors/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("genre", genreService.findOne(id));
        return "authors/edit";
    }

    @PostMapping()
    public String create(@ModelAttribute Genre genre) {
        genreService.save(genre);
        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        genreService.delete(id);
        return "redirect:/home";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Genre genre, @PathVariable("id") int id) {
        genreService.update(id, genre);
        return "redirect:/home";
    }
}
