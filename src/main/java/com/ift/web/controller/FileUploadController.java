package com.ift.web.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ift.domain.SatelliteJson;
import com.ift.services.StorageService;
import com.ift.services.ZeroMQService;
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
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by chen3 on 4/19/17.
 */

@RestController
public class FileUploadController {


    private final StorageService storageService;
    private final ZeroMQService zeroMQService;

    @Autowired
    public FileUploadController(StorageService storageService, ZeroMQService zeroMQService) {
        this.storageService = storageService;
        this.zeroMQService = zeroMQService;
    }


    /*
    Read file and do send to MQ Server.
     */
    @PostMapping("/upload_config_file")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes){

        // Parse JSON file
        Type jsonArrayType = new TypeToken<List<SatelliteJson>>(){}.getType();
        Gson gson = new GsonBuilder().create();
        try {
            JsonReader jsonReader = new JsonReader(new BufferedReader(new FileReader(multipartToFile(file))));
            List<SatelliteJson> satelliteJsonDataList = gson.fromJson(jsonReader, jsonArrayType);

            // Send data to zero mq
            zeroMQService.sendData(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        storageService.store(file);

        return new ResponseEntity("Successfully uploaded - " +
                file.getOriginalFilename(), new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Convert MultipartFile to File
     * @param multipart
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException
    {
        File convFile = new File(multipart.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(multipart.getBytes());
        fos.close();
        return convFile;
    }
}
