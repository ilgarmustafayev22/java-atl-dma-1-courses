package az.atlacademy.module01.example02;

public class Student extends Person {

    private String creditCard;


    public Student(String name, String surname, String creditCard) {
        super(name, surname);
        this.creditCard = creditCard;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public void foo(){
        System.out.println("I am a student");
    }
    @Override
    public String toString() {
        return "Student{" +
                "creditCard='" + creditCard + '\'' +
                '}';
    }

}
