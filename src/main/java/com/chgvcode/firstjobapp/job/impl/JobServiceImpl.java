package com.chgvcode.firstjobapp.job.impl;

import com.chgvcode.firstjobapp.job.Job;
import com.chgvcode.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<Job>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId((long) jobs.size() + 1);
        jobs.add(job);
    }
}
