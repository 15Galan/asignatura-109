import prJarras.Mesa;

public class EjemploUsoMesa1 {

    public static void main(String[] args) {

        Mesa mesa = new Mesa(5, 7);

        System.out.println("Llenar primera y segunda jarra.");
        System.out.println(mesa);

        System.out.println('\n' + "Llenar una jarra con otra hasta dejar 1L." + '\n');

        int paso = 1;

        if(mesa.capacidad(1) <= mesa.capacidad(2)){                                                          // Si la primera jarra es mas pequeña...
            while(mesa.contenido(1) != 1 && mesa.contenido(2) != 1){

                if(mesa.contenido(1) == 0) {                                                                       // La jarra no siempre empieza vacia en todas las iteraciones.
                    mesa.llenar(1);

                }else if(mesa.contenido(2) == mesa.capacidad(2)){                                            // La jarra grande debe vaciarse cuando se llena.
                    mesa.vaciar(2);
                }

                mesa.llenarDesde(2);                                                                               // Siempre debe pasarse el contenido de la primera a la segunda jarra.

                System.out.println("Paso #" + paso + ": " + mesa + '\n');

                paso++;
            }

        }else{                                                                                                          // Si la primera jarra es mas grande...
            while(mesa.contenido(1) != 1 && mesa.contenido(2) != 1){

                if(mesa.contenido(2) == 0) {                                                                       // La jarra no siempre empieza vacia en todas las iteraciones.
                    mesa.llenar(2);

                }else if(mesa.contenido(1) == mesa.capacidad(1)){                                            // La jarra grande debe vaciarse cuando se llena.
                    mesa.vaciar(1);
                }

                mesa.llenarDesde(1);                                                                               // Siempre debe pasarse el contenido de la segunda a la primera jarra.

                System.out.println("Paso #" + paso + ": " + mesa + '\n');

                paso++;
            }
        }

        // Idea (mía): En el ejemplo de la practica los litros son impares, ya que no puede conseguirse un resto 1
        // operando con numeros pares. Sabiendo eso, pense que la unica forma era llenar la jarra mas grande usando
        // la jarra mas pequeña de una forma continua, vaciando la grande cuando fuese necesario.
        // Asi se consigue (siendo las capacidades impares) que en algun momento, la jarra pequeña tenga 1L que
        // sobro al llenar la grande.
    }
}
