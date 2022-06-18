package com.practical.services;

import com.practical.models.GenderModel;
import com.practical.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderService {

    @Autowired
    GenderRepository genderRepository;

    public boolean ExistGender(Integer id) {
        return genderRepository.existsById(id);
    }

    public GenderModel findGender(Integer id){
        return genderRepository.findById(id).get();
    }
}
