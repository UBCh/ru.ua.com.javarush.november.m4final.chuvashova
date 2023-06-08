package com.javarush.entities.H2DB;

import com.javarush.entities.entitiesTables.Country;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "cityH2DB")

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CityH2DB {



	@Id
	private Long id;

    @Column(length = 20)
	private String name;

	@Column(name = "country_id", length = 5)
	private Long countryId;

    @Column(length = 54)
	private String district;

    @Column(length = 10)
    private Long population;





    }

