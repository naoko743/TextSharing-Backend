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
     * @return
     */
    Version openUrl(String url);

}
