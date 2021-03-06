package com.github.hardlolmaster.module2.homework4.shell;


import com.github.hardlolmaster.module2.homework4.dao.AuthorRepository;
import com.github.hardlolmaster.module2.homework4.domain.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigInteger;

@ShellComponent
public class AuthorCommands {

    private final AuthorRepository managerAuthor;

    @Autowired
    public AuthorCommands(AuthorRepository managerAuthor) {
        this.managerAuthor = managerAuthor;
    }

    @ShellMethod(value = "Insert author in db", key = "insert-author")
    public void insertAuthor(@ShellOption String name,
                             @ShellOption String lastName) {
        Author object = new Author();
        object.setLastName(lastName);
        object.setName(name);
        managerAuthor.save(object);
        System.out.println(object);
    }

    @ShellMethod(value = "Get all authors from db", key = "get-all-authors")
    public void getAllAuthors() {
        System.out.println(managerAuthor.findAll());
    }

    @ShellMethod(value = "Get author from db", key = "get-author")
    public void getAuthorById(@ShellOption long id) {
        System.out.println(managerAuthor.findById(BigInteger.valueOf(id)));
    }

}
