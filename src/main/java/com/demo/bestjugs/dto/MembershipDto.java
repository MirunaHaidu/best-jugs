package com.demo.bestjugs.dto;

import com.demo.bestjugs.model.Gym;
import com.demo.bestjugs.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MembershipDto {
    private Long id;
    private User user;
    private Gym gym;
}
