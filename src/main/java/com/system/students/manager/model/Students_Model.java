package com.system.students.manager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Students_Model {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "first_name", nullable = false)
  private String firstName;

  @Column(name = "last_name", nullable = false)
  private String lastName;

  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "date_of_birth", nullable = false)
  private String date_of_birth;

  @Column(name = "gender", nullable = false)
  private String gender;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "id_number", nullable = false)
  private String id_number;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "parent_name", nullable = false)
  private String parent_name;

  @Column(name = "parent_contact", nullable = false)
  private String parent_contact;

  // relationship

  ////////// mapped to school

  /////////////////////////////////////

  @Column(name = "subjects")
  private String subjects;

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getDate_of_birth() {
    return date_of_birth;
  }

  public void setDate_of_birth(String date_of_birth) {
    this.date_of_birth = date_of_birth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getId_number() {
    return id_number;
  }

  public void setId_number(String id_number) {
    this.id_number = id_number;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getParent_name() {
    return parent_name;
  }

  public void setParent_name(String parent_name) {
    this.parent_name = parent_name;
  }

  public String getParent_contact() {
    return parent_contact;
  }

  public void setParent_contact(String parent_contact) {
    this.parent_contact = parent_contact;
  }

  public String getSubjects() {
    return subjects;
  }

  public void setSubjects(String subjects) {
    this.subjects = subjects;
  }

}
