package az.atl.springexample.model;

import lombok.*;

//@Getter
//@Setter
//@EqualsAndHashCode
//@AllArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
@Value
public class User {

     String name;
     String surname;
     Integer age;


    // public User() {
  // }

  //public User(String name, String surname, Integer age) {
  //    this.name = name;
  //    this.surname = surname;
  //    this.age = age;
  //}


  //  public String getName() {
  //      return name;
  //  }
  //
  //  public void setName(String name) {
  //      this.name = name;
  //  }
  //
  //  public String getSurname() {
  //      return surname;
  //  }
  //
  //  public void setSurname(String surname) {
  //      this.surname = surname;
  //  }
  //
  //  public Integer getAge() {
  //      return age;
  //  }
  //
  //  public void setAge(Integer age) {
  //      this.age = age;
  //  }


  // @Override
  // public boolean equals(Object object) {
  //     if (this == object) return true;
  //     if (object == null || getClass() != object.getClass()) return false;
  //     User user = (User) object;
  //     return Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(age, user.age);
  // }
  //
  // @Override
  // public int hashCode() {
  //     return Objects.hash(name, surname, age);
  // }
}
