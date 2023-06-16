package fr.diginamic.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

@MappedSuperclass
public class ABaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Transient
    private boolean isNew = true;

    public ABaseEntity() {
    }

    public ABaseEntity(Integer id) {
        this.id = id;
    }

    public void trackNotNew() {
        this.isNew = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return isNew;
    }
}
