package org.example.entity;

import java.util.Objects;

public class Employee {
    private int id;
    private String firstname;
    private String lastname;

    public Employee(int id, String firstname, String lastname)
    {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
        {
            return true;
        }

        Employee employee = (Employee) obj;
        return this.firstname.equals(employee.getFirstname()) && this.lastname.equals(employee.getLastname()) && this.id == employee.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString()
    {
        return "Id: " + this.id + " " + "FirstName: " + firstname + " " + "LastName: " + lastname;
    }
}
