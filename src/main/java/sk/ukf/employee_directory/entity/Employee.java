package sk.ukf.employee_directory.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "Meno je povinné")
    @Size(min = 2, max = 50, message = "Meno musí mať 2-50 znakov")
    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @NotBlank(message = "Priezvisko je povinné")
    @Size(min = 2, max = 50, message = "Priezvisko musí mať 2-50 znakov")
    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @NotNull(message = "Dátum narodenia je povinný")
    @Past(message = "Dátum narodenia musí byť v minulosti")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotBlank(message = "Email je povinný")
    @Email(message = "Neplatný email")
    @Pattern(
            regexp = "^[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?(?:\\.[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?)+$",
            message = "Email má neplatný formát"
    )
    @Size(max = 100, message = "Email môže mať najviac 100 znakov")
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "Telefónne číslo je povinné")
    @Pattern(
            regexp = "^\\+421\\d{9}$",
            message = "Telefónne číslo musí začínať +421 a obsahovať presne 9 číslic za ním."
    )
    @Column(name = "phone")
    private String phone;

    @NotBlank(message = "Pracovná pozícia je povinná")
    @Size(min = 2, max = 50, message = "Pracovná pozícia musí mať 2-50 znakov")
    @Column(name = "job_title", nullable = false)
    private String jobTitle;

    @DecimalMin(value = "100.01", message = "Plat musí byť vyšší ako 100 €")
    @DecimalMax(value = "99999.99", message = "Plat musí byť nižší ako 100000 €")
    @Column(name = "salary")
    private BigDecimal salary;

    @NotNull(message = "Je povinné uviesť, či je práca fulltime")
    @Column(name = "full_time", nullable = false)
    private Boolean fullTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Boolean getFullTime() {
        return fullTime;
    }

    public void setFullTime(Boolean fullTime) {
        this.fullTime = fullTime;
    }
}
