package com.chgvcode.firstjobapp.job.impl;

import com.chgvcode.firstjobapp.job.Job;
import com.chgvcode.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();

    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    public Job getJobById(Long id){
        for (Job job : jobs){ //return jobs.get(id);
            if (job.getId().equals(id)) return job;
        }
        return null;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++); //job.setId((long) jobs.size() + 1);
        jobs.add(job);
    }

    @Override
    public boolean deleteJobById(Long id) {
        return jobs.remove(getJobById(id));
    }
}
