package com.sample.serviceImpl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface SampleService {

	public String excelDataConvertion(MultipartFile file) throws IOException;

	public String readByColumnName(MultipartFile file);

}
