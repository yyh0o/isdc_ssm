package isdc.isdcssm.service;

import java.util.List;

import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.User;


public interface UserService {

    boolean signUp(User user);

    List<UserResponse> listAll();

    UserResponse login(String email, String password);

    UserResponse auth(String accessToken);

    boolean adminAuth(String accessToken);

    boolean isMember(String accessToken);
}
