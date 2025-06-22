package trabajo.arqweb.services;

import trabajo.arqweb.dtos.DTOUser;
import trabajo.arqweb.entities.User;

public interface UserService {
    public User findById (Long id);
    public User findByUsername(String username);

    public User addUser(User user);
    public User addUser(DTOUser dtoUser);
}
