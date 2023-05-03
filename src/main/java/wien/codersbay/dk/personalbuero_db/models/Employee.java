package wien.codersbay.dk.personalbuero_db.models;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfbirth;
    private LocalDate hireDate;
    private double salary;

    public Employee(String firstName, String lastName, LocalDate dateOfbirth, LocalDate hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfbirth = dateOfbirth;
        this.hireDate = hireDate;
    }

    public Employee(int id, String firstName, String lastName, LocalDate dateOfbirth, LocalDate hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfbirth = dateOfbirth;
        this.hireDate = hireDate;
    }

    public int getAge() {
        return 0;
    }

    public int getYearsInCompany() {
        return 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public String toString() {
        return "Employee {id =" +this.id + ", firstName=" + this.firstName + ", lastName=" + this.lastName;
    }



}
