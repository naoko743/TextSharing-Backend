package com.freshersClass.textSharing.service;

import com.freshersClass.textSharing.entity.Version;

public interface VersionService {

    /**
     *
     * @param version
     * @return
     */
    Version saveVersion(Version version);

    /**
     *
     * @param url
     * @return Feld Content for Version
     */
    String openUrl(String url);

}
