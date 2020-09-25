package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.domain.SampleDomain;

@Repository
public interface SampleRepo extends JpaRepository<SampleDomain, String> {



}
