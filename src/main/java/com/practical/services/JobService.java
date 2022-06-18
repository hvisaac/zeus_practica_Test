package com.practical.services;

import com.practical.models.JobModel;
import com.practical.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    JobRepository jobRepository;

    public boolean ExistJob(int id){
        return jobRepository.existsById(id);
    }

    public JobModel findJob(Integer id){
        return jobRepository.findById(id).get();
    }
}
