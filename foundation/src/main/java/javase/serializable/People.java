package javase.serializable;

import java.io.Serializable;

/**
 * @Author:Kevin
 * @Description:
 * @Date: 2019/7/3 14:19
 */
public class People implements Serializable {
    private String name;
    private Integer age;
    private static Integer weight = 8001;
    private String height;

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

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height='" + height + '\'' +
                '}';
    }
}
