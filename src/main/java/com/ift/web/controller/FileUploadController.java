package com.ift.web.controller;

import com.ift.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by chen3 on 4/19/17.
 */

@RestController
public class FileUploadController {


    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }


    @PostMapping("/upload_config_file")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes){

        storageService.store(file);

        return new ResponseEntity("Successfully uploaded - " +
                file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }
}
