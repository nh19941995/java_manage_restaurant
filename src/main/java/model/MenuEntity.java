package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "menu", schema = "restaurant_manager", catalog = "")
public class MenuEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "menu_name_id", nullable = false)
    private int menuNameId;
    @Basic
    @Column(name = "dish_id", nullable = false)
    private int dishId;
    @Basic
    @Column(name = "quantity", nullable = false)
    private int quantity;
    @Basic
    @Column(name = "unit_price", nullable = false)
    private int unitPrice;
    @Basic
    @Column(name = "date_creat", nullable = false)
    private Timestamp dateCreat;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuNameId() {
        return menuNameId;
    }

    public void setMenuNameId(int menuNameId) {
        this.menuNameId = menuNameId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Timestamp getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Timestamp dateCreat) {
        this.dateCreat = dateCreat;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public MenuEntity() {
    }

    public MenuEntity(int menuNameId, int dishId, int quantity, int unitPrice, String dateCreat, int flag) {
        this.menuNameId = menuNameId;
        this.dishId = dishId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "id=" + id +
                ", menuNameId=" + menuNameId +
                ", dishId=" + dishId +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", dateCreat=" + dateCreat +
                ", flag=" + flag +
                '}';
    }
}
