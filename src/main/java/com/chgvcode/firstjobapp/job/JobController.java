package com.chgvcode.firstjobapp.job;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    private List<Job> jobs = new ArrayList<Job>();

    @GetMapping("/jobs")
    public List<Job> findAll(){
        return jobs;
    }

    /*@GetMapping("/jobs/{id}")
    public Job getJob(@RequestBody String id){
        return job;
    }*/

    @PostMapping("/jobs")
    public String createJob(@RequestBody Job job){
        jobs.add(job);
        return "Job added successfully";
    }
}
