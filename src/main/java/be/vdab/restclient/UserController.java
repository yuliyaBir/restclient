package be.vdab.restclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }
    @GetMapping("{id}")
    User findById(@PathVariable long id){
        return userClient.findById(id).orElseThrow(UserNotFoundException::new);
    }
    @GetMapping
    List<User> findAll(){
        return userClient.findAll();
    }
}
