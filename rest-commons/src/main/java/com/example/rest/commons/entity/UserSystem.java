package com.example.rest.commons.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserSystem implements /*UserDetails,*/ AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", unique = true, nullable = false)
	private String name;

	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", nullable = false)
	@ToString.Exclude
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_system_role", joinColumns = { @JoinColumn(name="id_user_system") }, inverseJoinColumns = { @JoinColumn(name="id_role")})
	private List<Role> roles;

	/*@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}

	public List<String> getRolesString() {
		return roles == null ? null : roles.stream().map(Role::getDescription).collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return email;
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
	}*/
}






