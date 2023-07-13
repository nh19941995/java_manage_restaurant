package model;

import javax.persistence.*;

@Entity
@Table(name = "bookings", schema = "restaurant_manager", catalog = "")
public class BookingsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "info_id", nullable = false)
    private int infoId;
    @Basic
    @Column(name = "table_id", nullable = false)
    private int tableId;
    @Basic
    @Column(name = "menu_name_id", nullable = false)
    private int menuNameId;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public int getTableId() {
        return tableId;
    }

    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getMenuNameId() {
        return menuNameId;
    }

    public void setMenuNameId(int menuNameId) {
        this.menuNameId = menuNameId;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public BookingsEntity() {
    }

    public BookingsEntity(int infoId, int tableId, int menuNameId, int flag) {
        this.infoId = infoId;
        this.tableId = tableId;
        this.menuNameId = menuNameId;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BookingsEntity{" +
                "id=" + id +
                ", infoId=" + infoId +
                ", tableId=" + tableId +
                ", menuNameId=" + menuNameId +
                ", flag=" + flag +
                '}';
    }
}
