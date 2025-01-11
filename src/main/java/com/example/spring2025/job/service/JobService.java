package com.example.spring2025.job.service;

import java.util.List;

import com.example.spring2025.job.data.Job;

public interface JobService {
    List<Job> getJobs();
    void addJob(Job job);
    Job getJobById(Long id);
    boolean deleteJob(Long id);
    boolean updateJob(Long id, Job job_updated);
}
