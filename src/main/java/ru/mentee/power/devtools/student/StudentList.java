package ru.mentee.power.devtools.student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
  private List<Student> studentList;

  public StudentList() {
    studentList = new ArrayList<>();
  }

  // нарушение: имя метода
  public void addStudent(Student student) {
    if (student != null) {
      studentList.add(student);
    }  // нарушение: нет пробела после if

  }

  // нарушение: длинная строка (>120 символов)
  public List<Student> getStudentFromSpecificCity(String city) {
    return studentList.stream().filter(s -> s.city().equals(city)).toList();
  }

  // отступы больше или меньше
  public void tryThis() {
  }

  // PascalCase в названии метода
  public void pascalCaseMistake() {
  }

  // множество пустых строк


  // конец файла

}
