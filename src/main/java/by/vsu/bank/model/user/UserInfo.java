package by.vsu.bank.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Entity
@Table(name = "users_info")
@Data
public class UserInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(name = "phone")
    @Pattern(regexp = "\\+\\d{3}\\(\\d{2}\\)\\d{3}\\-\\d{2}\\-\\d{2}", message = "incorrect phone number format")
    private String phone;

    @Column(name = "last_name", length = 50)
    @NotBlank
    private String lastName;

    @Column(name = "first_name", length = 50)
    @NotBlank
    private String first_name;

    @Column(name = "birthday")
    private Date date;

    @Column(name = "sex")
    private Sex sex;

    @Getter
    @AllArgsConstructor
    private enum Sex {
        MAlE("male"),
        FEMALE("female"),
        OTHER("other");
        private String value;
    }
}
