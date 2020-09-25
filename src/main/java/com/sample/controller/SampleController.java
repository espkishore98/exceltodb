package com.sample.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sample.serviceImpl.SampleService;

@RestController
public class SampleController {
	@Autowired
	SampleService sampleService;

	@PostMapping("/sampleData")
	public String sample(MultipartFile file) throws IOException {
		return sampleService.excelDataConvertion(file);
	}
	@PostMapping("/getCol")
	public String sampleCol(MultipartFile file) throws IOException {
		return sampleService.readByColumnName(file);
	}

}
