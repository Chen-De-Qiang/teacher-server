package com.cdq.teacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
public class FileUploadController {

    SimpleDateFormat sdf=new SimpleDateFormat("yyy/MM/dd/");

    @Autowired
    private AppConfig config;

    @PostMapping("/upload3")
    public String upload (MultipartFile uploadFile, HttpServletRequest req) throws IOException {
//        String realPath2=req.getSession().getServletContext().getRealPath("/uploadFile/");
       String realPath="C:\\Users\\27847\\Desktop\\uploadFile\\";
        String format = sdf.format (new Date());
        File folder = new File(realPath + format) ;
        if (!folder.isDirectory()){
            folder.mkdirs();
        }
        String oldName = uploadFile .getOriginalFilename() ;
        String newName = UUID. randomUUID().toString() +oldName.substring (oldName.lastIndexOf("."),oldName.length());
            try {
                uploadFile.transferTo(new File(folder,newName));
                String filePath ="http://127.0.0.1:8088/image/"+format+newName;
                return filePath;
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败!";
            }
        }


    private String getFileName(MultipartFile file) {
        String name = file.getOriginalFilename();
        StringBuilder sb = new StringBuilder();
        Date date = new Date();
        sb.append(date.getTime());
        sb.append(name.substring(name.indexOf(".")));
        return sb.toString();
    }
}
