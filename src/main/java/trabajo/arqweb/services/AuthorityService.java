package trabajo.arqweb.services;

import trabajo.arqweb.entities.Authority;

public interface AuthorityService {
    public Authority addAuthority(Authority authority);
    public Authority findByName(String authorityName);
}
