package com.aswebshop.demo.reader;

import com.aswebshop.demo.io.FileReader;
import java.util.List;

import java.io.IOException;


public class DataReader {

    private final FileReader fileReader;
    public DataReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public <E> List<E> read(String path, DataTransformer<E> dataTransformer) {
        return fileReader.read(path)
                .skip(1)
                .map(line -> {
                    try {
                        return dataTransformer.transform(line);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .toList();
    }
}
