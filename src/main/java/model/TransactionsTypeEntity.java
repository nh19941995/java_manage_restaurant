package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions_type", schema = "restaurant_manager", catalog = "")
public class TransactionsTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "type", nullable = false, length = 500)
    private String type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public TransactionsTypeEntity() {
    }

    public TransactionsTypeEntity(String type, String dateCreat, String dateUpdate, int flag) {
        this.type = type;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.dateUpdate = Timestamp.valueOf(dateUpdate);
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TransactionsTypeEntity{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", dateCreat=" + dateCreat +
                ", dateUpdate=" + dateUpdate +
                ", flag=" + flag +
                '}';
    }
}
