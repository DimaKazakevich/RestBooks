package by.kazakevich.restbooks.security;

import by.kazakevich.restbooks.domain.User;
import by.kazakevich.restbooks.repository.UserRepository;
import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserPrincipalDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public UserPrincipalDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByEmail(username);

    if (user.isEmpty()) {
      throw new UsernameNotFoundException(username + " was not found");
    }

    return UserFactory.create(user.get());
  }
}
