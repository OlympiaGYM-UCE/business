package com.gym.olympia.repository;

import com.gym.olympia.entity.Bussines;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BussinesRepository extends JpaRepository<Bussines, Long> {
}