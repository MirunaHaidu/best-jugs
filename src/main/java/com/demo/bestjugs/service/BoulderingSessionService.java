package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.BoulderingSessionDto;
import com.demo.bestjugs.model.BoulderingSession;

public interface BoulderingSessionService {

    BoulderingSession createSession(BoulderingSessionDto boulderingSessionDto, Long gymId);
}
