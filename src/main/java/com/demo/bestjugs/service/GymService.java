package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.GymDto;
import com.demo.bestjugs.model.Gym;

public interface GymService {
    Gym createGym(GymDto gymDto);
}
