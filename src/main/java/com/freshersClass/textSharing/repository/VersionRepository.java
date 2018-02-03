package com.freshersClass.textSharing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.freshersClass.textSharing.entity.Version;

public interface VersionRepository extends CrudRepository<Version, Long> {

    @Query("SELECT v FROM Version v WHERE v.url = ?1")
    Version findByUrl(String url);

}
