package fr.insat.bemyhelper.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Request", schema = "projet_gei_030", catalog = "")
public class RequestEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "NeederUserName", insertable=false, updatable=false)
    private String neederUserName;
    @Basic
    @Column(name = "Description")
    private String description;
    @Basic
    @Column(name = "State")
    private int state;
    @ManyToOne
    @JoinColumn(name = "NeederUserName", referencedColumnName = "UserName")
    private NeederEntity needer;

    public RequestEntity() {}

    public RequestEntity(String description, NeederEntity needer) {
        this.description = description;
        this.needer = needer;
        this.neederUserName = needer.getUserName();
    }

    public String getNeederUserName() {
        return neederUserName;
    }

    public void setNeederUserName(String neederUserName) {
        this.neederUserName = neederUserName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RequestEntity that = (RequestEntity) o;

        if (id != that.id) return false;
        if (state != that.state) return false;
        if (!Objects.equals(neederUserName, that.neederUserName))return false;
        if (!Objects.equals(description, that.description)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = neederUserName != null ? neederUserName.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + state;
        return result;
    }

    public NeederEntity getNeeder() {
        return needer;
    }

    public void setNeeder(NeederEntity needer) {
        this.needer = needer;
    }
}
