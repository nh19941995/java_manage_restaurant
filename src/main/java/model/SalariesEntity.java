package model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "salaries", schema = "restaurant_manager", catalog = "")
public class SalariesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "person_id", nullable = false)
    private int personId;
    @Basic
    @Column(name = "salary_amount", nullable = false, precision = 0)
    private double salaryAmount;
    @Basic
    @Column(name = "effective_date", nullable = false)
    private Timestamp effectiveDate;
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

    public double getSalaryAmount() {
        return salaryAmount;
    }

    public void setSalaryAmount(double salaryAmount) {
        this.salaryAmount = salaryAmount;
    }

    public Timestamp getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public SalariesEntity() {
    }

    public SalariesEntity(int personId, double salaryAmount, Timestamp effectiveDate, int flag) {
        this.personId = personId;
        this.salaryAmount = salaryAmount;
        this.effectiveDate = effectiveDate;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "SalariesEntity{" +
                "id=" + id +
                ", personId=" + personId +
                ", salaryAmount=" + salaryAmount +
                ", effectiveDate=" + effectiveDate +
                ", flag=" + flag +
                '}';
    }
}
