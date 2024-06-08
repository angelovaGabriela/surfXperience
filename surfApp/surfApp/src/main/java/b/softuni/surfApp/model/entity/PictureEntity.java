package b.softuni.surfApp.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "pictures")
public class PictureEntity extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String title;

    @Column(nullable = false)
    private String url;

    public PictureEntity() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PictureEntity that = (PictureEntity) o;
        return getTitle().equals(that.getTitle()) && getUrl().equals(that.getUrl());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getUrl());
    }
}
