package ru.shabaev.zhezha.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.shabaev.zhezha.spring.library.models.Book;
import ru.shabaev.zhezha.spring.library.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.findOne(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/new";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findOne(id));
        return "books/edit";
    }

    @GetMapping("/search")
    public String searchPage() {
        return "books/search";
    }

    @PostMapping("/search")
    public String makeSearch(Model model, @RequestParam(name = "name") String name) {
        model.addAttribute("books", bookService.searchByName(name));
        return "books/search";
    }

    @PostMapping()
    public String create(@ModelAttribute Book book) {
        bookService.save(book);
        return "redirect:/home";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/home";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute Book book,@PathVariable("id") int id) {
        bookService.update(id, book);
        return "redirect:/home";
    }
}
