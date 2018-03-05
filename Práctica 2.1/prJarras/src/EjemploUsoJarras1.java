import prJarras.Jarra;

public class EjemploUsoJarras1 {
    public static void main(String[] args) {

        Jarra jarraA = new Jarra(7);
        Jarra jarraB = new Jarra(4);

        System.out.println("Llenar A y B.");
        jarraA.llenar();
        System.out.println("A: " + jarraA);
        System.out.println("B: " + jarraB + '\n');

        System.out.println("Llenar B con A.");
        jarraB.llenaDesde(jarraA);
        System.out.println("A: " + jarraA);
        System.out.println("B: " + jarraB + '\n');

        System.out.println("Vaciar B.");
        jarraB.vaciar();
        System.out.println("A: " + jarraA);
        System.out.println("B: " + jarraB + '\n');

        System.out.println("Llenar B con A.");
        jarraB.llenaDesde(jarraA);
        System.out.println("A: " + jarraA);
        System.out.println("B: " + jarraB + '\n');
    }
}
