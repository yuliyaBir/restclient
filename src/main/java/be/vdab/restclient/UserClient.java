package be.vdab.restclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Component
class UserClient {
    private final Requests requests;

    public UserClient(Requests requests) {
        this.requests = requests;
    }
    Optional<User> findById(long id){
        try {
            var response = requests.findById(id);
            var user = new User(response.id(), response.name(), response.address().city());
            return Optional.of(user);
        } catch (HttpClientErrorException.NotFound ex){
            return Optional.empty();

        }
    }
}
