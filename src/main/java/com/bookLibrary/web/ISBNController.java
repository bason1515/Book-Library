package com.bookLibrary.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookLibrary.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ISBNController {

    @RequestMapping(value = "/isbn/{isbn}")
    public Book booksByISBN(@PathVariable("isbn") String isbn) throws IOException {
        byte[] jsonData = Files.readAllBytes(Paths.get("books.json"));
        JsonNode books = new ObjectMapper().readTree(jsonData).path("items");
        for (JsonNode book : books) {
            Iterator<JsonNode> idIter = book.path("volumeInfo").path("industryIdentifiers").iterator();
            while (idIter.hasNext()) {
                String bookISBN = idIter.next().get("identifier").toString().replaceAll("\"", "");
                if (bookISBN.equals(isbn)) { 
                    Book result = new ObjectMapper().readValue(book.path("volumeInfo").toString(), Book.class);
                    result.setIsbn(isbn);
                    return result;
                }
            }
        }
        return null;
    }

}
