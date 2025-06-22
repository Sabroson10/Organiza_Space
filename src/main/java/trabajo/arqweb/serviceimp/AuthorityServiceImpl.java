package trabajo.arqweb.serviceimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trabajo.arqweb.entities.Authority;
import trabajo.arqweb.repositories.AuthorityRepository;
import trabajo.arqweb.services.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;
    @Override
    public Authority addAuthority(Authority authority) {
        return authorityRepository.save(authority);
    }

    @Override
    public Authority findByName(String authorityName) {
        return authorityRepository.findByName(authorityName);
    }
}
