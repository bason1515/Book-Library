package com.bookLibrary.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookLibrary.model.Author;
import com.bookLibrary.model.Item;
import com.bookLibrary.model.Library;
import com.bookLibrary.model.VolumeInfo;
import com.bookLibrary.service.MapperService;

@RestController
public class RatingController {

    @Autowired
    MapperService mapperService;

    @RequestMapping("/rating")
    public ResponseEntity<ArrayList<Author>> autorsByRating() throws IOException {
        String jsonData = new String(Files.readAllBytes(Paths.get("books.json")));
        Library library = mapperService.fromJson(jsonData, Library.class);
        ArrayList<Author> authors = new ArrayList<Author>();
        for (Item book : library.getItems()) {
            if (book.getVolumeInfo().getAverageRating() != 0.0) {
                for (String a : book.getVolumeInfo().getAuthors()) {
                    VolumeInfo volume = book.getVolumeInfo();
                    if(!authors.contains(a)) {
                        Author newAuthor = new Author(a, volume.getAverageRating(), volume.getRatingsCount());
                        authors.add(newAuthor);
                    }else {
                        Author author = authors.get(authors.indexOf(a));
                        author.calculateAverage(volume.getAverageRating(), volume.getRatingsCount());
                    }
                }
            }
        }
        Collections.sort(authors);
        return ResponseEntity.ok().body(authors);
    }
}
