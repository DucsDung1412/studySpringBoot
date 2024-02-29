package vn.DungVipPro.securityJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import vn.DungVipPro.securityJPA.dao.UsersDAO;
import vn.DungVipPro.securityJPA.model.Authorities;
import vn.DungVipPro.securityJPA.model.Users;

import java.util.ArrayList;
import java.util.Collection;

public class UsersService implements UserDetailsService {
    private UsersDAO usersDAO;

    @Autowired
    public UsersService(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = this.usersDAO.findById(username).get();
        if(users == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        Collection<Authorities> collection = new ArrayList<>();
        collection.add(users.getAuthorities());
        return new User(users.getUserName(), users.getPassword(), (Collection<? extends GrantedAuthority>) collection);
    }

}
