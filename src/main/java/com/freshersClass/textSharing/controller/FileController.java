package com.freshersClass.textSharing.controller;

import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.freshersClass.textSharing.entity.File;
import com.freshersClass.textSharing.entity.User;
import com.freshersClass.textSharing.entity.Version;
import com.freshersClass.textSharing.service.FileService;
import com.freshersClass.textSharing.service.UserService;
import com.freshersClass.textSharing.service.VersionService;
import com.google.common.hash.Hashing;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    VersionService versionService;

    @Autowired
    UserService userService;

    Date date = new Date();

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public Version createFile(@RequestBody File file) {

        file.setDateCreation(new Timestamp(date.getTime()));
        File newFile = fileService.createFile(file);
        Version version = createVersion(newFile);
        return versionService.saveVersion(version);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/search")
    public Version openFile(@RequestBody String url) {
        Version version = versionService.openUrl(url);
        return version != null ? version : new Version();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public Version editFile(@CookieValue(value = "currentUser", defaultValue = "")
            String username, @RequestBody Version version) {

        Version newVersion = new Version();
        newVersion.setNumberVersion(updateVersion(version.getFile().getIdfile()));
        newVersion.setContent(version.getContent());
        newVersion.setDate(new Timestamp(date.getTime()));
        newVersion.setUser(userService.findUserByUsername(username));
        newVersion.setUrl(generateUrl(version.getContent()));
        newVersion.setFile(version.getFile());
        return versionService.saveVersion(newVersion);
    }

    private Version createVersion(File file) {
        Version version = new Version();
        version.setContent(file.getContent());
        version.setDate(new Timestamp(date.getTime()));
        version.setNumberVersion(1);
        version.setUrl(generateUrl(file.getContent()));
        version.setFile(fileService.findVersionById(file.getIdfile()));
        version.setUser(userService.findUserById(2L));
        return version;
    }

    /**
     * @param content
     * @return SHA256 Google Guava Library
     */
    private String generateUrl(String content) {

        String sha256hex = Hashing.sha256()
                .hashString(content, StandardCharsets.UTF_8)
                .toString();
        return sha256hex;
    }

    private Integer updateVersion(Long idFile){
        return versionService.findNumberOfVersion(idFile) + 1;
    }

}
