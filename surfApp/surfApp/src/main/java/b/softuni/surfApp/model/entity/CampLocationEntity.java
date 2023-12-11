package b.softuni.surfApp.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "camp_locations")
public class CampLocationEntity extends BaseEntity {

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;
    @OneToMany
    private Set<CampEntity> camps;

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

    public Set<CampEntity> getCamps() {
        return camps;
    }

    public void setCamps(Set<CampEntity> camps) {
        this.camps = camps;
    }

}
