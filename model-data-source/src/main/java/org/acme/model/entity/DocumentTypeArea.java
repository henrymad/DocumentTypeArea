package org.acme.model.entity;

import javax.persistence.*;

@Entity
@Table(name="document_type_area")
public class DocumentTypeArea {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String name;

    @Column(name="active", columnDefinition = "TINYINT(1)")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
