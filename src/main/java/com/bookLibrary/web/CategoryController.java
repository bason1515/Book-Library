package com.bookLibrary.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookLibrary.model.Item;
import com.bookLibrary.model.Library;
import com.bookLibrary.model.VolumeInfo;
import com.bookLibrary.service.MapperService;

@RestController
public class CategoryController {

    @Autowired
    MapperService mapperService;

    @RequestMapping(value = "/category/{category}")
    public ResponseEntity<ArrayList<VolumeInfo>> booksByCategory(@PathVariable("category") String category)
            throws IOException {
        String jsonData = new String(Files.readAllBytes(Paths.get("books.json")));
        Library library = mapperService.fromJson(jsonData, Library.class);
        ArrayList<VolumeInfo> result = new ArrayList<VolumeInfo>();
        for (Item book : library.getItems()) {
            if (book.getVolumeInfo().getCategories() != null) {
                for (String bookCategory : book.getVolumeInfo().getCategories()) {
                    if (bookCategory.equals(category)) {
                        result.add(book.getVolumeInfo());
                        System.out.println("Added: " + book.getVolumeInfo().getTitle());
                        break;
                    }
                }
            }
        }
        if (!result.isEmpty())
            return ResponseEntity.ok(result);
        return ResponseEntity.notFound().build();
    }
}