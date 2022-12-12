package Exams.JavaAdvancedExam19February2022.P03Parots;

public class Main {
    public static void main(String[] args) {

        Cage cage = new Cage("Wildness", 20);

        Parrot parrot = new Parrot("Fluffy", "Loriinae");

        System.out.println(parrot);


        cage.add(parrot);
        System.out.println(cage.count());

        cage.remove("Parrot Name");

        Parrot secondParrot = new Parrot("Bunny", "Cacatuidae");
        Parrot thirdParrot = new Parrot("Jumpy", "Strigopoidea");
        Parrot fourthParrot = new Parrot("Puffy", "Strigopoidea");
        Parrot fifthParrot = new Parrot("Marlin", "Arinae");


        cage.add(secondParrot);
        cage.add(thirdParrot);
        cage.add(fourthParrot);
        cage.add(fifthParrot);

        System.out.println(cage.sellParrot("Bunny"));


        System.out.println(cage.report());

    }
}
