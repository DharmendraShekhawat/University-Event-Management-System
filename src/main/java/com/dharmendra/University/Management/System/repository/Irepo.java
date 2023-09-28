package com.dharmendra.University.Management.System.repository;

import com.dharmendra.University.Management.System.entity.Department;
import com.dharmendra.University.Management.System.entity.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Irepo extends JpaRepository<StudentModel,Integer> {
    //@Modifying
//@Query(value = "")
//    void addStudentList(List<StudentModel> students);
    @Modifying
    @Query(value = "update student_model set department =:department where student_id =:studentId", nativeQuery = true)
    void updateStudentDepartment(Integer studentId, String department);

    @Modifying
    @Query(value = "delete from student_model where student_id =:id", nativeQuery = true)
    void deleteStudentById(Integer id);

    @Query(value = "select * from student_model", nativeQuery = true)
    List<StudentModel> getAllStudents();

    @Query(value = "select * from student_model where student_id =:studentId", nativeQuery = true)
    List<StudentModel> getStudentById(Integer studentId);



}
