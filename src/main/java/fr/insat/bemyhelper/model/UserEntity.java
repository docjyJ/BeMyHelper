package fr.insat.bemyhelper.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "User", schema = "projet_gei_030")
public class UserEntity {
    @Basic
    @Column(name = "FirstName", nullable = false)
    private String firstName;
    @Basic
    @Column(name = "LastName", nullable = false)
    private String lastName;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "UserName", nullable = false)
    private String userName;
    @Basic
    @Column(name = "Password", nullable = false)
    private String password;
    @OneToOne(mappedBy = "userByUserName", cascade = CascadeType.MERGE)
    private HelperEntity helperByUserName;
    @OneToOne(mappedBy = "userByUserName", cascade = CascadeType.MERGE)
    private NeederEntity neederByUserName;
    @OneToOne(mappedBy = "userByUserName", cascade = CascadeType.MERGE)
    private ValiderEntity validerByUserName;

    public UserEntity(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    public UserEntity() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (!Objects.equals(firstName, that.firstName)) return false;
        if (!Objects.equals(lastName, that.lastName)) return false;
        if (!Objects.equals(userName, that.userName)) return false;
        if (!Objects.equals(password, that.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    public HelperEntity getHelperByUserName() {
        return helperByUserName;
    }

    public void setHelperByUserName(HelperEntity helperByUserName) {
        this.helperByUserName = helperByUserName;
    }

    public NeederEntity getNeederByUserName() {
        return neederByUserName;
    }

    public void setNeederByUserName(NeederEntity neederByUserName) {
        this.neederByUserName = neederByUserName;
    }

    public ValiderEntity getValiderByUserName() {
        return validerByUserName;
    }

    public void setValiderByUserName(ValiderEntity validerByUserName) {
        this.validerByUserName = validerByUserName;
    }
}
