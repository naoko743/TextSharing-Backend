package com.freshersClass.textSharing.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.entity.File;
import com.freshersClass.textSharing.entity.Version;
import com.freshersClass.textSharing.service.FileService;
import com.freshersClass.textSharing.service.VersionService;
import com.google.common.hash.Hashing;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    VersionService versionService;

    Date date = new Date();

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String createFile(@RequestBody File file) {

        file.setDateCreation(new Timestamp(date.getTime()));
        System.out.println(" *** SHA *** : " + generateUrl(file.getContent()));
        System.out.println("Contenido: " + file.getContent() + "Hora: " + file.getDateCreation());
        // fileService.createFile(file);
        Version version = createVersion(file);
        // versionService.saveVersion(version);
        return "estaeslaSHA976976767ds6f7d6767";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public void openFile(@RequestBody Version version) {
        System.out.println(" URL : " + version.getUrl());
        String verFind = versionService.openUrl(version.getUrl());
         System.out.println(" CONTENIDO URL : " + verFind);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public boolean editFile(@RequestBody Version version) {
        versionService.saveVersion(version);
        return true;
    }

    private Version createVersion(File file) {
        Version version = new Version();
        version.setContent(file.getContent());
        version.setDate(new Timestamp(date.getTime()));
        version.setNumberVersion(1);
        version.setUrl(generateUrl(file.getContent()));
        return version;
    }

    /**
     *
     * @param content
     * @return SHA256 Google Guava Library
     */
    private String generateUrl(String content) {

        String sha256hex = Hashing.sha256()
                .hashString(content, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

}
