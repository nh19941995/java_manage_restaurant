package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "dish", schema = "restaurant_manager", catalog = "")
public class DishEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "dish_name", nullable = false, length = 500)
    private String dishName;
    @Basic
    @Column(name = "price", nullable = false)
    private int price;
    @Basic
    @Column(name = "date_creat", nullable = false)
    private Timestamp dateCreat;
    @Basic
    @Column(name = "date_update", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @org.hibernate.annotations.UpdateTimestamp
    private Timestamp dateUpdate;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;
    @Basic
    @Column(name = "dish_type_id", nullable = false)
    private int dishTypeId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public int getDishTypeId() {
        return dishTypeId;
    }

    public void setDishTypeId(int dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public DishEntity() {
    }

    public DishEntity(String dishName, int price, String dateCreat, String dateUpdate, int flag, int dishTypeId) {
        this.dishName = dishName;
        this.price = price;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.dateUpdate = Timestamp.valueOf(dateUpdate);
        this.flag = flag;
        this.dishTypeId = dishTypeId;
    }

    @Override
    public String toString() {
        return "DishEntity{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", dateCreat=" + dateCreat +
                ", dateUpdate=" + dateUpdate +
                ", flag=" + flag +
                ", dishTypeId=" + dishTypeId +
                '}';
    }
}
