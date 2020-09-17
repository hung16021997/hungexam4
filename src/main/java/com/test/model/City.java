package com.test.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "countryId")
    private Country country;

    @NotBlank(message = "Must not be blank & not consist of digits")
    @Size(min = 3, max = 15)
    private String name;

    @NotNull(message = "Must not be null")
    @Min(value = 1)
    private double area;

    @NotNull(message = "Must not be null")
    @Min(value = 1)
    private double population;

    @NotNull(message = "Must not be null")
    @Min(value = 1)
    private double gdp;


    @NotBlank
    @Size(max = 255)
    private String description;

    public City() {
    }

    public City(Country country, String name, double area, double population, double gdp,String description) {
        this.country = country;
        this.name = name;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
