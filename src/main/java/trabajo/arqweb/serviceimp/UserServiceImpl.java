package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import trabajo.arqweb.dtos.DTOUser;
import trabajo.arqweb.entities.Authority;
import trabajo.arqweb.entities.User;
import trabajo.arqweb.repositories.UserRepository;
import trabajo.arqweb.services.AuthorityService;
import trabajo.arqweb.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityService authorityService;
    @Override
    public User findById(Long id) {
        User userFound = userRepository.findById(id).orElse(null);
        return userFound;
    }

    @Override
    public User findByUsername(String username) {
        User userFound = userRepository.findByUsername(username);
        return userFound;
    }

    @Override
    public User addUser(User user) {
        User userFound = userRepository.findByUsername(user.getUsername());


        //Paso 1: Validar si el username y el password cumplen con los requisitos: minimo, maximo, tipos carecteres

        //Paso 2: Encriptar el password
        user.setPassword( new BCryptPasswordEncoder().encode(user.getPassword())  );

        //Paso 3: Actualizar los campos adicionales segun tu logica de negocio
        user.setEnabled(true);

        return userRepository.save(user);
    }
    private List<Authority> authoritiesFromString(String authorities) {
        List<Authority> authoritiesList = new ArrayList<>();
        List<String> authoritiesStringList = Arrays.stream(authorities.split(",")).toList();
        for(String authorityString : authoritiesStringList) {
            Authority authority = authorityService.findByName(authorityString);
            if(authority != null) {
                authoritiesList.add(authority);
            }
        }
        return authoritiesList;
    }
    @Override
    public User addUser(DTOUser dtoUser) {
        User newUser = new User(
                null,
                dtoUser.getUsername(),
                dtoUser.getPassword(),
                true,
                null
        );
        List<Authority> authorityList =authoritiesFromString(dtoUser.getAuthorities());//convertir este strnig a una lista de authorities;

        newUser.setAuthorities(authorityList);

        return addUser(newUser);
    }

}
