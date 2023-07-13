package model;

import javax.persistence.*;

@Entity
@Table(name = "dish_type", schema = "restaurant_manager", catalog = "")
public class DishTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "type", nullable = false, length = 500)
    private String type;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public DishTypeEntity() {
    }

    public DishTypeEntity(String type, int flag) {
        this.type = type;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DishTypeEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", flag=" + flag +
                '}';
    }
}
