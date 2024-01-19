package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.BoulderingSessionDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.model.*;
import com.demo.bestjugs.repository.BoulderingProblemRepository;
import com.demo.bestjugs.repository.BoulderingSessionRepository;
import com.demo.bestjugs.repository.GymRepository;
import com.demo.bestjugs.repository.UserRepository;
import com.demo.bestjugs.service.BoulderingSessionService;
import com.demo.bestjugs.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("test_qualifier_boulderingSessionServiceImpl")
@Transactional
public class BoulderingSessionServiceImpl implements BoulderingSessionService {

    private final BoulderingSessionRepository boulderingSessionRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final UserService userService;
    private final GymRepository gymRepository;
    private final BoulderingProblemRepository boulderingProblemRepository;


    public BoulderingSessionServiceImpl(BoulderingSessionRepository boulderingSessionRepository, ModelMapper modelMapper, UserRepository userRepository, UserService userService, GymRepository gymRepository, BoulderingProblemRepository boulderingProblemRepository) {
        this.boulderingSessionRepository = boulderingSessionRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.userService = userService;
        this.gymRepository = gymRepository;
        this.boulderingProblemRepository = boulderingProblemRepository;
    }


    @Override
    public BoulderingSession createSession(BoulderingSessionDto boulderingSessionDto, Long gymId) {
        BoulderingSession boulderingSession = modelMapper.map(boulderingSessionDto, BoulderingSession.class);
        User user = userRepository.findById(boulderingSessionDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", boulderingSessionDto.getUser().getId()));
        boulderingSession.setUser(user);


        if(!userService.hasMembership(user.getId(), gymId)){
            throw new RuntimeException("User does not have a membership at this gym");
        }


        List<Long> selectedShoesIds = Optional.ofNullable(boulderingSessionDto.getShoes())
                .orElse(Collections.emptyList())
                .stream()
                .map(Shoe::getId)
                .toList();


        if (selectedShoesIds.isEmpty()) {
            Shoe rentalShoes = new Shoe();
            rentalShoes.setBrand("Ocun");
            rentalShoes.setModel("Rental");
            rentalShoes.setSize("Standard");
            rentalShoes.setPurchaseDate(LocalDate.now());

            boulderingSession.setShoes(Collections.singletonList(rentalShoes));
        } else {
            List<Shoe> selectedShoes = user.getShoes().stream()
                    .filter(shoe -> selectedShoesIds.contains(shoe.getId()))
                    .toList();

            boulderingSession.setShoes(selectedShoes);
        }

        List<Long> selectedBoulderingProblemsIds = Optional.ofNullable(boulderingSessionDto.getBoulderingProblems())
                .orElse(Collections.emptyList())
                .stream()
                .map(BoulderingProblem::getId)
                .toList();

        Gym gym = gymRepository.findById(gymId)
                .orElseThrow(() -> new ResourceNotFoundException("Gym", "gymId", gymId));

        List<BoulderingProblem> gymProblems = gym.getBoulderingProblems();

        List<BoulderingProblem> selectedProblems = selectedBoulderingProblemsIds.stream()
                .map(id -> boulderingProblemRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("BoulderingProblem", "id", id)))
                .filter(gymProblems::contains)
                .toList();

        boulderingSession.setBoulderingProblems(selectedProblems);




        return boulderingSessionRepository.save(boulderingSession);
    }
}
