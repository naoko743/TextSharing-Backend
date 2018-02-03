package com.freshersClass.textSharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshersClass.textSharing.entity.File;
import com.freshersClass.textSharing.repository.FileRepository;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Override
    public File createFile(File file) {
        return fileRepository.save(file);
    }

    @Override
    public File findVersionById(Long idFile) {
        return fileRepository.findOne(idFile);
    }
}
