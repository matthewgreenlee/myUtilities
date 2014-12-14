package com.goldenpond.http;

import java.io.File;
import java.util.List;

/**
 * This program demonstrates a usage of the MultipartUtility class.
 * @author www.codejava.net
 *
 */
public class MultipartFileUploader {

	public static void main(String[] args) throws Exception {
        String charset = "UTF-8";
        File uploadFile1 = new File("C:/Users/t/Desktop/images.jpg");
        File uploadFile2 = new File("C:/Users/t/Desktop/doodle.jpg");
        String requestURL = "http://localhost:8080/ssm/v1/pic/upload.do";
        try {
                MultipartUtility multipart = new MultipartUtility(requestURL, charset);
                
                multipart.addHeaderField("User-Agent", "CodeJava");
                multipart.addHeaderField("Test-Header", "Header-Value");
                
                multipart.addFormField("pid", "001");
                multipart.addFormField("pid", "007");

                multipart.addFormField("type", "avatar");
                multipart.addFormField("type", "product");
                
                multipart.addFilePart("pic", uploadFile1);
                multipart.addFilePart("pic", uploadFile2);

                List<String> response = multipart.finish();
                
                System.out.println("SERVER REPLIED:");
                
                for (String line : response) {
                    System.out.println(line);
                }
        }
        finally {
        	
        }
    }
}