package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "permissions", schema = "restaurant_manager", catalog = "")
public class PermissionsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "permission_name", nullable = false, length = 300)
    private String permissionName;
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

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
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

    public PermissionsEntity() {
    }

    public PermissionsEntity(String permissionName, String dateCreat, String dateUpdate, int flag) {
        this.permissionName = permissionName;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.dateUpdate = Timestamp.valueOf(dateUpdate);
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "PermissionsEntity{" +
                "id=" + id +
                ", permissionName='" + permissionName + '\'' +
                ", dateCreat=" + dateCreat +
                ", dateUpdate=" + dateUpdate +
                ", flag=" + flag +
                '}';
    }
}
