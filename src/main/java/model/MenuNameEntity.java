package model;

import javax.persistence.*;

@Entity
@Table(name = "menu_name", schema = "restaurant_manager", catalog = "")
public class MenuNameEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 500)
    private String name;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public MenuNameEntity() {
    }

    public MenuNameEntity(String name, int flag) {
        this.name = name;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MenuNameEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", flag=" + flag +
                '}';
    }
}
