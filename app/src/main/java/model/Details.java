package model;

public class Details {
    private String name;
    private String age;
    private int imageId;
    private String gender;

    public Details(String name, String age, int imageId, String gender) {
        this.name = name;
        this.age = age;
        this.imageId = imageId;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
