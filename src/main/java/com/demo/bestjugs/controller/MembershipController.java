package com.demo.bestjugs.controller;

import com.demo.bestjugs.dto.GymDto;
import com.demo.bestjugs.dto.MembershipDto;
import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.model.Membership;
import com.demo.bestjugs.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
@ControllerAdvice
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PostMapping("/createMembership")
    public ResponseEntity<Membership> createMembership(@Valid @RequestBody MembershipDto membershipDto){
        Membership membership = membershipService.createMembership(membershipDto);
        return new ResponseEntity<>(membership, HttpStatus.CREATED);
    }
}
