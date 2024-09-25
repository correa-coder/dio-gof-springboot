package one.digitalinovation.gof.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @NotBlank
    @Column(nullable = false)
    private String postalCode;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false)
    private String street;

    @Size(max = 50)
    private String suiteOrAptNumber;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String neighborhood;

    @NotBlank
    @Size(max = 50)
    @Column(nullable = false)
    private String city;

    @NotBlank
    @Size(max = 2)
    @Column(nullable = false)
    private String state;
}
