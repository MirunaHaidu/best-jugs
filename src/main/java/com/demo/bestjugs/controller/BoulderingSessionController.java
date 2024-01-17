package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.BoulderingSessionDto;
import com.demo.bestjugs.model.BoulderingSession;
import com.demo.bestjugs.service.BoulderingSessionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class BoulderingSessionController {
    private final BoulderingSessionService boulderingSessionService;

    public BoulderingSessionController(BoulderingSessionService boulderingSessionService) {
        this.boulderingSessionService = boulderingSessionService;
    }

    @PostMapping("/createSession")
    public ResponseEntity<BoulderingSession> createSession(@RequestBody @Valid BoulderingSessionDto boulderingSessionDto){
        BoulderingSession boulderingSession = boulderingSessionService.createSession(boulderingSessionDto);
        return new ResponseEntity<>(boulderingSession, HttpStatus.CREATED);
    }
}
