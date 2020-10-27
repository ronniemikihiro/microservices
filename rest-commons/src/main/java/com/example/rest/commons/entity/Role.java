package com.example.rest.commons.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Role implements /*GrantedAuthority,*/ AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description", nullable = false)
	private String description;

//	@Override
//	public String getAuthority() {
//		return this.description;
//	}

}
