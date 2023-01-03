package com.msag.securityinfo.persistence.repository;

import com.msag.securityinfo.persistence.data.GeneralNewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface GeneralNewsRepository extends JpaRepository<GeneralNewsEntity, Long> {
}
