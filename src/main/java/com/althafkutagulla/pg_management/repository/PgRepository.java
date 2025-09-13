package com.althafkutagulla.pg_management.repository;

import com.althafkutagulla.pg_management.entity.Pg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PgRepository extends JpaRepository<Pg, Integer> {
}
