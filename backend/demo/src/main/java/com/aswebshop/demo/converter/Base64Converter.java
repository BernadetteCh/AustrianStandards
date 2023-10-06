package com.aswebshop.demo.converter;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Service
public class Base64Converter {

    public String convertImgToBase64String(String filepath) throws IOException {
        byte[] fileContent = FileUtils.readFileToByteArray(new File(filepath));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;

    }
}
