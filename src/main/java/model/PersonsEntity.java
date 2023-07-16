package model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "persons", schema = "restaurant_manager", catalog = "")
public class PersonsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Basic
    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;
    @Basic
    @Column(name = "address", nullable = false, length = 300)
    private String address;
    @Basic
    @Column(name = "username", nullable = false, length = 150)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 150)
    private String password;
    @Basic
    @Column(name = "permission", nullable = false)
    private int permission;
    @Basic
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Basic
    @Column(name = "date_creat", nullable = false)
    private Timestamp dateCreat;
    @Basic
    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Timestamp dateCreat) {
        this.dateCreat = dateCreat;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public PersonsEntity() {
    }

    public PersonsEntity(String name, String dateOfBirth, String address, String username, String password, int permission, String email, String dateCreat, String dateUpdate, int flag) {
        this.name = name;
        this.dateOfBirth = Date.valueOf(dateOfBirth);
        this.address = address;
        this.username = username;
        this.password = password;
        this.permission = permission;
        this.email = email;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.dateUpdate = Timestamp.valueOf(dateUpdate);
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "PersonsEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                ", email='" + email + '\'' +
                ", dateCreat=" + dateCreat +
                ", dateUpdate=" + dateUpdate +
                ", flag=" + flag +
                '}';
    }
}
