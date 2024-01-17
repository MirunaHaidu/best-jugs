package com.demo.bestjugs.service.impl;

import com.demo.bestjugs.dto.ShoeDto;
import com.demo.bestjugs.exception.ResourceNotFoundException;
import com.demo.bestjugs.exception.UserNotFoundException;
import com.demo.bestjugs.model.Shoe;
import com.demo.bestjugs.model.User;
import com.demo.bestjugs.repository.ShoeRepository;
import com.demo.bestjugs.repository.UserRepository;
import com.demo.bestjugs.service.ShoeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("test_qualifier_shoeServiceImpl")
@Transactional
public class ShoeServiceImpl implements ShoeService {
    private final ShoeRepository shoeRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ShoeServiceImpl(ShoeRepository shoeRepository, ModelMapper modelMapper, UserRepository userRepository) {
        this.shoeRepository = shoeRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }


    @Override
    public Shoe addShoe(ShoeDto shoeDto) {
        Shoe shoe = modelMapper.map(shoeDto, Shoe.class);

        User owner = userRepository.findById(shoeDto.getOwner().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", shoeDto.getOwner().getId()));

        shoe.setOwner(owner);

        return shoeRepository.save(shoe);
    }


}
