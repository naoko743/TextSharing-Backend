package com.freshersClass.textSharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.entity.File;
import com.freshersClass.textSharing.entity.Version;
import com.freshersClass.textSharing.service.FileService;
import com.freshersClass.textSharing.service.VersionService;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    VersionService versionService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public boolean createFile(@RequestBody File file) {
        System.out.println("Contenido: " + file.getContent() + " Date: " + file.getDateCreation());

       // fileService.createFile(file);
       // versionService.saveVersion(createVersion(file));
        return true;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/open")
    public String openFile(@RequestBody String url) {
        return versionService.openUrl(url).getContent();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public boolean editFile(@RequestBody Version version) {
        versionService.saveVersion(version);
        return true;
    }

    private Version createVersion(File file){
        Version version = new Version();
        version.setContent(file.getContent());
        //version.setDate();
        //version.setUrl();
        version.setUrl(generateUrl(file.getContent()));
        return version;
    }

    private String generateUrl(String content){

        //TODO Generar URL con SHA
        return "";
    }

}
