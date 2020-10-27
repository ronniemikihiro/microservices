package com.example.rest.commons.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class Product implements AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false, length = 100)
	private String name;

}
