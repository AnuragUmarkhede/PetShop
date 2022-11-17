package com.cybage.services;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	public String getImageData(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		if (fileName.contains("..")) {
			System.out.println("not a valid file");
		}
		try {
			return (Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
	}
}
