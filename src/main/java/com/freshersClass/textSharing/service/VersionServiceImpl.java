package com.freshersClass.textSharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freshersClass.textSharing.entity.Version;
import com.freshersClass.textSharing.repository.VersionRepository;

@Service
public class VersionServiceImpl implements VersionService {

    @Autowired
    private VersionRepository versionRepository;

    @Override
    public Version saveVersion(Version version) {
        return versionRepository.save(version);
    }

    @Override
    public String openUrl(String url) {
         return versionRepository.findByUrl(url);
    }
}
