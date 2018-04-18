import prDatos.Datos;

public class PruebaDatos {

    public static void main(String[] args) {

        String[] valores = {"5", "9", "Pepe", "10", "Maria", "12", "13", "Paco", "17", "20", "Ana", "25", "Juan", "Lola"};
        Datos datos = new Datos(valores, 10, 20);

        System.out.println(datos.toString());
    }
}
