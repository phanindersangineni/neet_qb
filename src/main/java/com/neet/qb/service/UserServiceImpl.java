package com.neet.qb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neet.qb.annotation.LogExecutionTime;
import com.neet.qb.model.User;
import com.neet.qb.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory
			.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public void create(User user) {
		Set<String> strRoles = user.getRoles();
		Set<String> roles = new HashSet<>();
		strRoles.forEach(role -> {
			System.out.println("RRR"+role);
			roles.add(role);
		});
		//roles.add("ROLE_USER");
		user.setRoles(roles);
		user.setCreatedAt(new Date());
		user.setActive(true);
		userRepository.save(user);
	}

	@Override
	@LogExecutionTime
	public User getById(String id) {
		return userRepository.findOneById(id);
	}
}
