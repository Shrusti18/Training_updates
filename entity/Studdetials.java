package Task1.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Detialsinfo")
public class Studdetials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int rollid;

    @Column(name = "Address")
    public String address;
    @Column(name = "Gender")
    public String gender;
    @Column(name = "email_id")
    public String emailid;

    public void setAddress(String address) {
        this.address =address;

    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmailid(String emailId) {
        this.emailid=emailId;
    }


    public String getAddress() {
        this.address=address;
        return address;
    }

    public String getGender() {
        this.gender=gender;
        return gender;
    }
}
