package trabajo.arqweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trabajo.arqweb.Security.JwtUtilService;
import trabajo.arqweb.Security.UserSecurity;
import trabajo.arqweb.dtos.DTOToken;
import trabajo.arqweb.dtos.DTOUser;
import trabajo.arqweb.entities.User;
import trabajo.arqweb.services.UserService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtilService jwtUtilService;


    @PostMapping("/users")
    public ResponseEntity<User> insertarUser(@RequestBody User user) {
        User newUser =userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PostMapping("users/login")
    public ResponseEntity<DTOToken> login(@RequestBody User user) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );

        UserSecurity userSecurity = (UserSecurity)userDetailsService.loadUserByUsername(user.getUsername());

        String jwt = jwtUtilService.generateToken(userSecurity);
        Long id = userSecurity.getUser().getId();
        String authorities = userSecurity.getUser().getAuthorities()
                .stream()
                .map( a-> a.getName())
                .collect(Collectors.joining(";","",""));

        return new ResponseEntity<>(new DTOToken(jwt,id, authorities), HttpStatus.OK);
    }
    @PostMapping("/users/register")
    public ResponseEntity<DTOUser> registerUser(@RequestBody DTOUser dtoUser) {
        User newUser=userService.addUser(dtoUser);
        dtoUser.setPassword("no visible");
        dtoUser.setId(newUser.getId());
        return new ResponseEntity<>(dtoUser, HttpStatus.CREATED);
    }
}
