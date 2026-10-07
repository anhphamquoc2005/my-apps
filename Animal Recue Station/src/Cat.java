public class Cat extends Animal implements Playable{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("Moew moew!");
    }

    @Override
    public void play() {
        System.out.println("Mèo đang vờn cuộn len...");
    }
}
