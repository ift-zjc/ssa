package com.ift.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;

/**
 * Created by chen3 on 4/19/17.
 */
public interface StorageService {

    void init();

    void store(MultipartFile file);
    void store(String file, FileAttribute<?> attribute) throws IOException;

    Stream<Path> loadAll();

    Path load(String filename);

    Resource loadAsResource(String filename);

    void deleteAll();
}
