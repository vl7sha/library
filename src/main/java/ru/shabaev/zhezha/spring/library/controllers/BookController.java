package ru.shabaev.zhezha.spring.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String index(Model model){
        return null;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        return null;
    }
}
