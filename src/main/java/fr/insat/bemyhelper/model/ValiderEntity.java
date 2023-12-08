package fr.insat.bemyhelper.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Valider", schema = "projet_gei_030")
public class ValiderEntity {
    @Id
    @Column(name = "UserName", insertable=false, updatable=false)
    private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserName", referencedColumnName = "UserName", nullable = false)
    private UserEntity user;

    public ValiderEntity(UserEntity user) {
            this.user = user;
            this.userName = user.getUserName();
        }

    public ValiderEntity() {}

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

        return Objects.equals(userName, that.userName);
    }

    @Override
    public int hashCode() {
        return userName != null ? userName.hashCode() : 0;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
