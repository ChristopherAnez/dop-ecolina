package dop.service;

import dop.domain.User;

public interface LoginVerificationService {

    void sendVerificationCode(User user);

}
