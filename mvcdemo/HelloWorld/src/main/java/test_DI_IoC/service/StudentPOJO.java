package test_DI_IoC.service;

public class StudentPOJO {
    private String id;
    private String name;
    private Integer age;
    private Boolean isStudent;

    public StudentPOJO() {

    }

    public StudentPOJO(String id, String name, Integer age, Boolean isStudent) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isStudent = isStudent;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getStudent() {
        return isStudent;
    }

    public void setStudent(Boolean student) {
        isStudent = student;
    }

    @Override
    public String toString() {
        return "StudentPOJO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", isStudent=" + isStudent +
                '}';
    }
}
