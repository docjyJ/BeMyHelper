package fr.insat.bemyhelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Request", schema = "projet_gei_030", catalog = "")
public class RequestEntity {
    @Basic
    @Column(name = "NeederUserName", insertable=false, updatable=false)
    private String neederUserName;
    @Basic
    @Column(name = "Description")
    private String description;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID")
    private int id;
    @Basic
    @Column(name = "State")
    private int state;
    @ManyToOne
    @JoinColumn(name = "NeederUserName", referencedColumnName = "UserName")
    private NeederEntity neederByNeederUserName;

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
        if (neederUserName != null ? !neederUserName.equals(that.neederUserName) : that.neederUserName != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

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

    public NeederEntity getNeederByNeederUserName() {
        return neederByNeederUserName;
    }

    public void setNeederByNeederUserName(NeederEntity neederByNeederUserName) {
        this.neederByNeederUserName = neederByNeederUserName;
    }
}
