package isdc.isdcssm.service.Impl;

import isdc.isdcssm.dao.UserMapper;
import isdc.isdcssm.dto.Response.UserResponse;
import isdc.isdcssm.model.User;
import isdc.isdcssm.model.UserExample;
import isdc.isdcssm.service.UserService;
import isdc.isdcssm.support.TokenAuthenticationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final ModelMapper modelMapper;
    @Autowired
    public UserServiceImpl(UserMapper userMapper, ModelMapper modelMapper){
        this.userMapper = userMapper;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean signUp(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(user.getEmail());
        if (userMapper.selectByExample(userExample).size() == 0) {
            userMapper.insert(user);
            return true;
        }
        return false;
    }

    @Override
    public List<UserResponse> listAll() {
        return userMapper.selectByExample(new UserExample()).stream().map(p -> modelMapper.map(p,UserResponse.class)).collect(Collectors.toList());
    }

    @Override
    public UserResponse login(String email, String password) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andEmailEqualTo(email).andPasswordEqualTo(password);
        List<User> users = userMapper.selectByExample(userExample);
        User userByEmail = users.size()==0?null:users.get(0);
        if (userByEmail!=null) {
            userByEmail.setAccessToken(TokenAuthenticationService.addAuthentication(String.valueOf(userByEmail.getId())));
            return modelMapper.map(userByEmail, UserResponse.class);
        }
        return null;
    }

    @Override
    public UserResponse auth(String accessToken) {
        return null;
    }
}
