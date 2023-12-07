package b.softuni.surfApp.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "camp_locations")
public class CampLocationEntity extends BaseEntity {

    private String country;
    private String city;
    private String address;

    public CampLocationEntity() {}

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
