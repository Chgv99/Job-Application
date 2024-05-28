package com.chgvcode.firstjobapp.job;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<CLASS, PRIMARY KEY TYPE>
public interface JobRepository extends JpaRepository<Job, Long> /*CrudRepository*/ {

}
