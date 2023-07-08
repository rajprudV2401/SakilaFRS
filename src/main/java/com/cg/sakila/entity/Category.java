package com.cg.sakila.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "TINYINT")
	private Byte categoryId;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="last_update")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categories")
	private Set<Film> films = new HashSet<>();
}
