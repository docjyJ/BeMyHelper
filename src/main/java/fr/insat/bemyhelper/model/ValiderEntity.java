package fr.insat.bemyhelper.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Valider", schema = "projet_gei_030", catalog = "")
public class ValiderEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UserName", insertable=false, updatable=false)
    private String userName;
    @OneToOne
    @JoinColumn(name = "UserName", referencedColumnName = "UserName", nullable = false)
    private UserEntity userByUserName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValiderEntity that = (ValiderEntity) o;

        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    public UserEntity getUserByUserName() {
        return userByUserName;
    }

    public void setUserByUserName(UserEntity userByUserName) {
        this.userByUserName = userByUserName;
    }
}
