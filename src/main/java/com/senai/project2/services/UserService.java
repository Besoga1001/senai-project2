package com.senai.project2.services;

import com.senai.project2.dtos.request.UserRequestDto;
import com.senai.project2.dtos.response.UserResponseDto;
import com.senai.project2.models.UserModel;
import com.senai.project2.repositories.UserRepository;
import com.senai.project2.utils.UserExtensions;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository _userRepository;

    public UserService(UserRepository userRepository) {
        _userRepository = userRepository;
    }

    public UserResponseDto Insert(UserRequestDto userRequestDTO)  {
        UserModel userModel = _userRepository.save(UserExtensions.toEntity(userRequestDTO));
        return UserExtensions.toDto(userModel);
    }

    public List<UserResponseDto> GetAll() {
        List<UserModel> userList = _userRepository.findAll();
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        for (UserModel userModel : userList) {
            userResponseDtoList.add(UserExtensions.toDto(userModel));
        }
        return userResponseDtoList;
    }

    public String GetAuth(String login, String password) {
        List<UserModel> listUserModel = _userRepository.findAll();
        Optional<UserModel> userModel = listUserModel
                .stream()
                .filter(x -> x.getLogin().equals(login) && x.getPassword().equals(password))
                .findFirst();

        if (userModel.isPresent()) {
            return "Authenticated";
        }
        return "Not Authenticated";

    }

}
