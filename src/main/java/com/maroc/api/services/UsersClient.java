package com.maroc.api.services;


import com.maroc.api.entities.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;


//client call these points instead using API directly

@FeignClient(name="usersService", url="http://localhost:8080")
public interface UsersClient {

    @GetMapping("/service/users")
    List<Users> listUsers(@RequestHeader("X-Auth-Token") String authHeader);
}
