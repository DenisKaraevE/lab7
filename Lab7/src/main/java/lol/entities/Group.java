package lol.entities;

import javax.persistence.*;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer start_year;
    private Integer end_year;

    private Long department_id;

    public String getTitle() {
        return title;
    }

    public Group setTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getStart_year() {
        return start_year;
    }

    public Group setStart_year(Integer startYear) {
        this.start_year = startYear;
        return this;
    }

    public Integer getEnd_year() {
        return end_year;
    }

    public Group setEnd_year(Integer endYear) {
        this.end_year = endYear;
        return this;
    }

    public Long getDepartment_id() {
        return department_id;
    }

    public Group setDepartment_id(Long departmentId) {
        this.department_id = departmentId;
        return this;
    }

    public Group setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getId() {
        return id;
    }
}
