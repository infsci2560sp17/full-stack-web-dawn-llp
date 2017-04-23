package edu.infsci2560;

////import edu.infsci2560.LiUserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.AuthorityUtils;
import java.util.Collection;

import edu.infsci2560.models.LipicUsers;
import edu.infsci2560.repositories.UsersRepository;
import java.util.List;

@Component
public class LiAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UsersRepository repository;
    
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        
        System.out.println(username);
        System.out.println(password);

/*        
        if (repository.findByName(username) == null) {
            System.out.println("User Not Found!");
            throw new UsernameNotFoundException("User Not Found");
            }
        
*/
        try{
            LipicUsers userInfo = repository.findByName(username).get(0);  //name is unique;
            
            if (password.equals(userInfo.getPassword())){
            
                User user = new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            
                if (!userInfo.getIsAdmin()){
                    System.out.println("ROLE_ADMIN!");
                    user = new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));   // logon success return userdetail info
                } else {
                    System.out.println("ROLE_USER!");
                    user = new User(username,password,AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
                }
            
                Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
                return new UsernamePasswordAuthenticationToken(user, password, authorities);
                
            } else {
                //System.out.println("Wrong Password! PW is:" + userInfo.getPassword());
                throw new BadCredentialsException("Bad Credentials");            
        }
        
        } catch(Exception e) {
            throw new UsernameNotFoundException("User Not Found");
        }

        
        
        
//        UserDetails userDetials = userService.loadUserByUsername(username);
        


    }
    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }
}

