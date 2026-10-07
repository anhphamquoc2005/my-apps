public abstract class Animal {

    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    @Override
    public String toString() {
        return "Tên: " + name + " | Tuổi: " + age;
    }
}
