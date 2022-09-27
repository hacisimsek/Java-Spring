package com.springpostgreSQLexample.springpostgreSQLexample.service.impl;

import com.springpostgreSQLexample.springpostgreSQLexample.entity.Adress;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.springpostgreSQLexample.springpostgreSQLexample.dto.UserDto;
import com.springpostgreSQLexample.springpostgreSQLexample.entity.Kisi;
import com.springpostgreSQLexample.springpostgreSQLexample.repo.UserRepository;
import com.springpostgreSQLexample.springpostgreSQLexample.service.UserService;
import com.springpostgreSQLexample.springpostgreSQLexample.repo.AdressRepository;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AdressRepository adressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        //Assert.isNull(userDto.getName(), "Name cannot be null");

        Kisi user = new Kisi();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final Kisi userDb = userRepository.save(user);

        List<Adress> adressList = new ArrayList<>();

        userDto.getAdressList().forEach(adress -> {
            Adress adress1 = new Adress();
            adress1.setAdress(adress);
            adress1.setAdressType(Adress.AdressType.HOME);
            adress1.setAdressActive(true);
            adress1.setUser(userDb);
            adressList.add(adress1);
        });
        adressRepository.saveAll(adressList);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

   @Override
   public List<UserDto> getAll() {
         List<Kisi> userList = userRepository.findAll();
         List<UserDto> userDtoList = new ArrayList<>();

         userList.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setAdressList(user.getAdressList().stream().map(Adress::getAdress).collect(Collectors.toList()));
            userDtoList.add(userDto);
         });
        return userDtoList;
   }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
