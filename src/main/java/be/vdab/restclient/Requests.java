package be.vdab.restclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

interface Requests {
    @GetExchange("{id}")
    UserResponse findById(@PathVariable long id);
    @GetExchange
    UserResponse[] findAll();
}
