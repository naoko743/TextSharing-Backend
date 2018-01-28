package com.freshersClass.textSharing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.freshersClass.textSharing.entity.Version;

public interface VersionRepository extends CrudRepository<Version, Long> {

    @Query("SELECT v.content FROM Version v WHERE v.url=:url")
    String findByUrl(@Param("url") String url);

}
