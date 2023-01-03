package com.msag.securityinfo.persistence.repository;

import com.msag.securityinfo.persistence.data.VideoNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface VideoNewsRepository extends JpaRepository<VideoNewsEntity, Long> {
}
