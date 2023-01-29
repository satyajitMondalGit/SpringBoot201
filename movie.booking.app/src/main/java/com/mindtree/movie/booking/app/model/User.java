package com.mindtree.movie.booking.app.model;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
@ToString
@Entity
@Table(name = "user")
public class User implements Comparable<User> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_name", unique = true)
	private String userName;

	@Column(name = "mobile", unique = true)
	private String mobileNumber;

	@Column(name = "email")
	private String email;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
//	@JsonManagedReference
	private Set<Booking> bookings;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userId == other.getUserId() && userName.equals(other.getUserName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, mobileNumber, userId, userName);
	}

	@Override
	public int compareTo(User o) {

		return Comparator.comparingLong(User::getUserId).thenComparing(User::getUserName)
				.thenComparing(User::getMobileNumber).thenComparing(User::getEmail).compare(this, o);
	}

}
