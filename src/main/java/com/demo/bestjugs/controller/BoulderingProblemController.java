package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.BoulderingProblemDto;
import com.demo.bestjugs.model.BoulderingProblem;
import com.demo.bestjugs.service.BoulderingProblemService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class BoulderingProblemController {
    private final BoulderingProblemService boulderingProblemService;


    public BoulderingProblemController(BoulderingProblemService boulderingProblemService) {
        this.boulderingProblemService = boulderingProblemService;
    }


    @PostMapping("/createProblem")
    public ResponseEntity<BoulderingProblem> createBoulderingProblem(@RequestBody @Valid BoulderingProblemDto boulderingProblemDto){
        BoulderingProblem boulderingProblem = boulderingProblemService.addProblem(boulderingProblemDto);
        return new ResponseEntity<>(boulderingProblem, HttpStatus.CREATED);
    }

    @GetMapping("/getByGrade")
    public ResponseEntity<List<BoulderingProblem>> getByGrade(@RequestParam String grade){
        List<BoulderingProblem> boulderingProblems = boulderingProblemService.findByGrade(grade);
        return new ResponseEntity<>(boulderingProblems, HttpStatus.OK);
    }
}
