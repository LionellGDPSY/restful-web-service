package com.example.restfulwebservice.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    //GET /users/1 or /users/10 -> String 문자형태로 서버로 전달되지만 파라미터에서 int로 convert해서
    //사용가능하다.
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        //변수로 뽑아내기 단축키: Ctrl + Alt + V
        User user = service.findOne(id);

        if (user == null ){
            throw new UserNotFoundException(String.format("ID[%s] Not found.", id));
        }

        return user;
    }

    //xml 또는 json  데이터같은 오브젝트 데이터를 받기 위해서는 @RequestBody 어노테이션을 사용한다.
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){

        User savedUser = service.save(user);

        //응답코드값 uri를 제어하는 방법
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] Not found.", id));
        }
    }

}
