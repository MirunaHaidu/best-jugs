package com.demo.bestjugs.service;

import com.demo.bestjugs.dto.MembershipDto;
import com.demo.bestjugs.model.Membership;

public interface MembershipService {
    Membership createMembership(MembershipDto membershipDto);
}
