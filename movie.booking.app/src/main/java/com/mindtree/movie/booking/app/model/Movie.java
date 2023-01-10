package com.mindtree.movie.booking.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "movie")
public class Movie {

	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "movie_id")
	 private Long movieId;
	 
	 @Column(name = "title")
	 private String title;
	 
	 @Column(name = "genere")
	 private String genere;
	 
	 @Column(name = "duration")
	 private String duration; 
	 
	 @OneToOne(mappedBy = "movie")
	 @JoinColumn(name = "fk_movie_id", referencedColumnName = "movie_id")
	 @JsonBackReference
	 private Screening  screening;
}
