package com.dharmendra.University.Management.System.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class StudentModel {

   @Id
   @NotNull
   private Integer studentId;

   @NotBlank
   private String firstName;

   private String lastName;

   @Min(18) @Max(25)
   private Integer age;

   @Enumerated(EnumType.STRING)
   private Department department;
}
