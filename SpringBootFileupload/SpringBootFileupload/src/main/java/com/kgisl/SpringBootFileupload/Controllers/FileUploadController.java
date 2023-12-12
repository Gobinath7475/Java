package com.kgisl.SpringBootFileupload.Controllers;

import com.kgisl.SpringBootFileupload.Entity.FileEntity;
import com.kgisl.SpringBootFileupload.Repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
// import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileUploadController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping("/")
    public String home() {
        return "upload";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file ) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File must be provided");
            }
            // model.addAttribute("fileName", file.getOriginalFilename());

            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileData(file.getBytes());
            fileEntity.setFilename(file.getOriginalFilename()); // 

            fileRepository.save(fileEntity);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("File uploaded and stored in the database successfully");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error processing the file");
        }
    }

    @GetMapping("/list")
    public String fileList(Model model) {
        List<FileEntity> fileList = fileRepository.findAll();
        model.addAttribute("files", fileList);
        return "fileList";
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long fileId) {

        // Retrieve the file from the database using fileId
        FileEntity fileEntity = fileRepository.findById(fileId)
                .orElseThrow(() -> new RuntimeException("File not found"));

        // Set up the response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDisposition(ContentDisposition.builder("attachment")
                .filename("downloaded_file.txt")
                .build());
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(fileEntity.getFileData(), headers, HttpStatus.OK);
    }
}




