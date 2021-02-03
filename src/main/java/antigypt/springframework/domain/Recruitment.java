package antigypt.springframework.domain;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Recruitment")
@Data
public class Recruitment {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long recruitmentId;

        @Column(name = "firstName")
        private String firstName;
        @Column(name = "lastName")
        private String lastName;
        @Column(name = "birthDate")
        private LocalDate birthDate;
        @Column(name = "applicationDate")
        private LocalDate applicationDate;
        @Column(name = "email")
        private String email;
        @Column(name = "homePhone")
        private String homePhone;
        @Column(name = "mobilePhone")
        private String mobilePhone;
        @Column(name = "desiredSalary")
        private Double desiredSalary;

        @Enumerated(EnumType.STRING)
        private Title title;
        @Enumerated(EnumType.STRING)
        private Gender gender;

        @Embedded
        @AttributeOverrides({
                @AttributeOverride( name = "addressLine", column = @Column(name = "addressLine")),
                @AttributeOverride( name = "city", column = @Column(name = "city")),
                @AttributeOverride( name = "region", column = @Column(name = "region")),
                @AttributeOverride( name = "postalCode", column = @Column(name = "postalCode")),
                @AttributeOverride( name = "country", column = @Column(name = "country"))
        })
        private Address address;

        @Lob
        @Column(name = "photo")
        private Byte[] photo;
        @Lob
        @Column(name = "detail")
        private String detail;
        @Lob
        @Column(name = "cv")
        private Byte[] cv;

        @PrePersist
        public void onCreate(){
                setApplicationDate(LocalDate.now());
        }


    }

