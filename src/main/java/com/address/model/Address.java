package com.address.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//this annotations serves the purpose that: if new property gets added to our json file, then our application won't crush, means
//there will be no exception

@JsonIgnoreProperties(ignoreUnknown = true)

public class Address {

    private int id;
    private String name;
    private String email;
    private String gender;
    private String city;

    public Address(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
    @JsonIgnore
    public String[] getCities() {
        return cities;
    }

    private String[]cities;

    public Address(){
        cities= new String[]{"Lahore", "Islamabad", "Sialkot"};
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
