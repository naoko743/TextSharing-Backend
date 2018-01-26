package com.freshersClass.textSharing.repository;

import org.springframework.data.repository.CrudRepository;

import com.freshersClass.textSharing.entity.Version;

public interface VersionRepository extends CrudRepository<Version, Long> {

    Version findByUrl(String url);
}
