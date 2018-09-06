package isdc.isdcssm.service.Impl;

import isdc.isdcssm.dao.UserDAO;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.UserService;
import isdc.isdcssm.support.TokenAuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserDAO userDAO, ModelMapper modelMapper){
        this.userDAO = userDAO;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean signUp(User user) {
        if (userDAO.selectByEmail(user.getEmail()) == null) {
            userDAO.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserResponse> listAll() {
        return userDAO.selectAll().stream().map(p -> modelMapper.map(p,UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse login(String email, String password) {
        User userByEmail = userDAO.selectByEmail(email);
        if (userByEmail != null && userByEmail.getPassword().equals(password)) {
            userByEmail.setAccessToken(TokenAuthenticationService.addAuthentication(String.valueOf(userByEmail.getId())));
            return modelMapper.map(userByEmail, UserResponse.class);
        }
        return null;
    }

    @Override
    public UserResponse auth(String accessToken) {
        return modelMapper.map(userDAO.selectByAccessToken(accessToken), UserResponse.class);
    }
}
