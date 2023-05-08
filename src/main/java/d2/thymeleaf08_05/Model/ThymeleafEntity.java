package d2.thymeleaf08_05.Model;

public class ThymeleafEntity {
// Đây cũng là một loại biến trong thymeleaf
    private String name;
    private int age;
    private String email;

    public ThymeleafEntity(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ThymeleafEntity() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
