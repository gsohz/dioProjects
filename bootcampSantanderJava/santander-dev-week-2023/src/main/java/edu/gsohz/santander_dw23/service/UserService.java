package edu.gsohz.santander_dw23.service;

import edu.gsohz.santander_dw23.domain.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}