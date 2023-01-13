package com.mindtree.movie.booking.app.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

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
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "movie_id")
	 private Long movieId;
	 
	 @Column(name = "title")
	 private String title;
	 
	 @JsonFormat(pattern = "yyyy-mm-dd", shape = Shape.STRING)
	 @Column(name = "release_date")
	 private String releaseDate;
	 
	 @Column(name = "genere")
	 private String genere;
	 
	 @Column(name = "duration")
	 private String duration; 
	 
	 
	 
	 @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL )
	 @JsonBackReference
	 private List<Screening>  screenings;
}
