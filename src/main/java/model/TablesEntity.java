package model;

import javax.persistence.*;

@Entity
@Table(name = "tables", schema = "restaurant_manager", catalog = "")
public class TablesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "seating_capacity", nullable = false)
    private int seatingCapacity;
    @Basic
    @Column(name = "type", nullable = false)
    private int type;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public TablesEntity() {
    }

    public TablesEntity(int seatingCapacity, int type, int flag) {
        this.seatingCapacity = seatingCapacity;
        this.type = type;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TablesEntity{" +
                "id=" + id +
                ", seatingCapacity=" + seatingCapacity +
                ", type=" + type +
                ", flag=" + flag +
                '}';
    }
}
