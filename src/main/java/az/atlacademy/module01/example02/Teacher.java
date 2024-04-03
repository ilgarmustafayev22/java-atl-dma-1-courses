package az.atlacademy.module01.example02;

public class Teacher extends Person{

    private String jobTitle;

    public Teacher(String name, String surname, String jobTitle) {
        super(name, surname);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "jobTitle='" + jobTitle + '\'' +
                '}';
    }

}
