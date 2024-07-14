package com.system.students.manager.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "students")
@Getter
@Setter
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
    private long id_number;
    
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "parent_name", nullable = false)
    private String parent_name;

    @Column(name = "parent_contact", nullable = false)
    private long parent_contact;

          
      // relationship

      ////////// mapped to school
      @ManyToOne
      @JoinColumn(name = "school_id")
      private School school;
      /////////////////////////////////////

     @ManyToOne
    @JoinColumn(name = "class_id")
    private Class clazz;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentAssignment> studentAssignments;

    @OneToMany(mappedBy = "student")
    private List<AssignmentSubmission> submissions;
  
      @Column(name = "subjects")
      private String subjects;

    public Students_Model(long id, String firstName, String lastName, String surname, String date_of_birth,
            String gender, String address, long id_number, String email, String parent_name, long parent_contact,
            String subjects) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.date_of_birth = date_of_birth;
        this.gender = gender;
        this.address = address;
        this.id_number = id_number;
        this.email = email;
        this.parent_name = parent_name;
        this.parent_contact = parent_contact;
        this.subjects = subjects;
    }

    

      ///////
      

}
