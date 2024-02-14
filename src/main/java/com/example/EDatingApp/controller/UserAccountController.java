package com.example.EDatingApp.controller;

import com.example.EDatingApp.entity.Interest;
import com.example.EDatingApp.entity.UserAccount;
import com.example.EDatingApp.repo.InterestRepository;
import com.example.EDatingApp.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAccountController {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Autowired
    InterestRepository interestRepository;
    @PostMapping("/users/register-user")
    public UserAccount register(@RequestBody UserAccount userAccount){
        return userAccountRepository.save(userAccount);
    }

    @PostMapping("/interests/update")
    public Interest updateInterest(@RequestBody Interest interest){
        UserAccount userAccount = userAccountRepository.findById(interest.getUserAccountId()).get();
        interest.setUserAccount(userAccount);

        return interestRepository.save(interest);
    }

    @GetMapping("/users/get/all")
    public List<UserAccount> getAllUserAccount(){
        return userAccountRepository.findAll();
    }

    @DeleteMapping("/users/delete/{id}")
    public void deleteInterst(@PathVariable int id){
        interestRepository.deleteById(id);
    }

    @GetMapping("/users/matches/{id}")
    public List<UserAccount> findMatches(@PathVariable int id){
        UserAccount userAccount = userAccountRepository.findById(id).get();

        return userAccountRepository.findMatches(userAccount.getAge(),userAccount.getCity(),userAccount.getCountry(),userAccount.getId());
    }
}
