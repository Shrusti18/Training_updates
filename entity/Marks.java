package Task1.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Marksinfo")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int markid;

   @Column(name = "Subject_name")
    public String subject;
    @ Column(name = "Sub_marks")
    public float marks;

    public void setSubject(String subject) {
        this.subject=subject;
    }


    public String getSubject() {
        this.subject=subject;
        return subject;
    }

    public Float getMarks() {
        this.marks=marks;
        return marks;
    }

    public void setMarks(Float marks) {
        this.marks=marks;

    }
}
