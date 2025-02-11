package com.anurag.cleanindiabackend.controllers;

import com.anurag.cleanindiabackend.exceptions.NotFoundException;
import com.anurag.cleanindiabackend.models.User;
import com.anurag.cleanindiabackend.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @PutMapping("/")
    public ResponseEntity<?> updateUserProfile(@RequestBody User user){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(userProfileService.updateUserProfile(user));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
