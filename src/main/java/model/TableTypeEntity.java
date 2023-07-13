package model;

import javax.persistence.*;

@Entity
@Table(name = "table_type", schema = "restaurant_manager", catalog = "")
public class TableTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public TableTypeEntity() {
    }

    public TableTypeEntity(String name, String comment, int flag) {
        this.name = name;
        this.comment = comment;
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TableTypeEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", flag=" + flag +
                '}';
    }
}
