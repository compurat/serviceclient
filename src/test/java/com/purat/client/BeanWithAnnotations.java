package com.purat.client;

import com.purat.client.annotation.ConnectionName;
import com.purat.client.annotation.FieldName;

/**
 * Created by compurat on 21-6-15.
 */
@ConnectionName(connectionName = "vxz")
public class BeanWithAnnotations {
    @FieldName(fieldName = "name")
    private String name;
    @FieldName(fieldName = "last")
    private String lastName;
    @FieldName(fieldName = "adress")
    private String addres;
    @FieldName(fieldName = "city")
    private String city;
    @FieldName(fieldName = "fullAge")
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
