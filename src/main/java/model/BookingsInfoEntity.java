package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bookings_info", schema = "restaurant_manager", catalog = "")
public class BookingsInfoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Basic
    @Column(name = "info", nullable = false, length = 500)
    private String info;
    @Basic
    @Column(name = "date_creat", nullable = false)
    private Timestamp dateCreat;
    @Basic
    @Column(name = "start", nullable = false)
    private Timestamp start;
    @Basic
    @Column(name = "end", nullable = false)
    private Timestamp end;
    @Basic
    @Column(name = "deposit", nullable = false, precision = 0)
    private double deposit;
    @Basic
    @Column(name = "flag", nullable = false)
    private int flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Timestamp getDateCreat() {
        return dateCreat;
    }

    public void setDateCreat(Timestamp dateCreat) {
        this.dateCreat = dateCreat;
    }

    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public BookingsInfoEntity() {
    }

    public BookingsInfoEntity(int personId, String info, String dateCreat, String start, String end, double deposit, int flag) {
        this.personId = personId;
        this.info = info;
        this.dateCreat = Timestamp.valueOf(dateCreat);
        this.start = Timestamp.valueOf(start);
        this.end = Timestamp.valueOf(end);
        this.deposit = deposit;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "BookingsInfoEntity{" +
                "id=" + id +
                ", personId=" + personId +
                ", info='" + info + '\'' +
                ", dateCreat=" + dateCreat +
                ", start=" + start +
                ", end=" + end +
                ", deposit=" + deposit +
                ", flag=" + flag +
                '}';
    }
}
