package by.kazakevich.restbooks.security;

import by.kazakevich.restbooks.domain.Role;
import by.kazakevich.restbooks.domain.User;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

  private final User user;
  Collection<? extends GrantedAuthority> authorities;

  public UserPrincipal(
      Long id,
      String email,
      String password,
      Role role,
      Collection<? extends GrantedAuthority> authorities
  ) {
    this.user = User.builder()
        .id(id)
        .email(email)
        .password(password)
        .role(role)
        .build();
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public Long getId() {
    return user.getId();
  }
}
