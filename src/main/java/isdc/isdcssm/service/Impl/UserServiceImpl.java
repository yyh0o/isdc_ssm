package isdc.isdcssm.service.Impl;

import isdc.isdcssm.dao.UserDao;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.User;
import isdc.isdcssm.service.UserService;
import isdc.isdcssm.support.TokenAuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserDao userDao, ModelMapper modelMapper){
        this.userDao = userDao;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean signUp(User user) {
        if (userDao.selectByEmail(user.getEmail()) == null) {
            userDao.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserResponse> listAll() {
        return userDao.selectAll().stream().map(p -> modelMapper.map(p,UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse login(String email, String password) {
        User userByEmail = userDao.selectByEmail(email);
        if (userByEmail != null && userByEmail.getPassword().equals(password)) {
            userByEmail.setAccessToken(TokenAuthenticationService.addAuthentication(String.valueOf(userByEmail.getId())));
            return modelMapper.map(userByEmail, UserResponse.class);
        }
        return null;
    }

    @Override
    public UserResponse auth(String accessToken) {

        return modelMapper.map(userDao.selectByAccessToken(accessToken), UserResponse.class);
    }
}
