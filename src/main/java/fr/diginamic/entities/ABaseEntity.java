package fr.diginamic.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class ABaseEntity {
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

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

    @Override
    public String toString() {
        return "ABaseEntity{" +
                "id=" + id +
                '}';
    }
}
