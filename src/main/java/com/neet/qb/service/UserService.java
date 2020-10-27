package com.neet.qb.service;

import com.neet.qb.model.User;

public interface UserService {

  /**
   * Service method to create new user.
   *
   * @param user User information object.
   */
  void create(User user);

  /**
   * Method to fetch user {@see User} by id.
   *
   * @param id User ID.
   * @return {@code User} User object.
   */
  User getById(String id);
}
