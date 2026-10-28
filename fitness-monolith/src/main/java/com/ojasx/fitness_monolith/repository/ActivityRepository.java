package com.ojasx.fitness_monolith.repository;

import com.ojasx.fitness_monolith.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,String> {

}
