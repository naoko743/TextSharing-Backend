package com.freshersClass.textSharing.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.freshersClass.textSharing.entity.Version;

public interface VersionRepository extends CrudRepository<Version, Long> {

    @Query("SELECT v FROM Version v WHERE v.url = ?1")
    Version findByUrl(String url);

    @Query("SELECT max(v.numberVersion) FROM Version v WHERE v.file.idfile = ?1")
    Integer findVersionById(Long id);

}
