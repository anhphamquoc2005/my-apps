public class Dog extends Animal implements Playable {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("\nGâu gâu!");
    }

    @Override
    public void play() {
        System.out.println("Chó đang ngoạm bóng...");
    }
}
