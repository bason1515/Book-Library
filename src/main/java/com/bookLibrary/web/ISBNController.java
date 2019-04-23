package com.bookLibrary.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookLibrary.model.Item;
import com.bookLibrary.model.Library;
import com.bookLibrary.model.VolumeInfo;
import com.bookLibrary.service.MapperService;

@RestController
public class ISBNController {

    @Autowired
    MapperService mapperService;

    @RequestMapping(value = "/isbn/{isbn}")
    public ResponseEntity<VolumeInfo> booksByISBN(@PathVariable("isbn") String isbn) throws IOException {
        String jsonData = new String(Files.readAllBytes(Paths.get("books.json")));
        Library library = mapperService.fromJson(jsonData, Library.class);
        for (Item book : library.getItems()) {
            if (book.haveISBN(isbn)) {
                return new ResponseEntity<VolumeInfo>(book.getVolumeInfo(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}