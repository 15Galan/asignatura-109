package prJarras;

public class Mesa {

    private Jarra jarra1;                       // Una mesa contiene 2 jarras, por lo que maneja
    private Jarra jarra2;                       // dos variables propias de tipo «Jarra».

    public Mesa(Jarra jarraA, Jarra jarraB){
        jarra1 = jarraA;
        jarra2 = jarraB;
    }

    public Mesa(int capacidad1, int capacidad2){
        jarra1 = new Jarra(capacidad1);
        jarra2 = new Jarra(capacidad2);
    }

    public int capacidad(int jarra){
        int c;

        switch (jarra){
            case 1 : c = jarra1.capacidad(); break;
            case 2 : c = jarra2.capacidad(); break;
            default: throw new RuntimeException("ERROR: Jarra mal indicada."); // break;                                // El «break» resulta inutil, ya que si antes de el se ejecuta una excepción, nunca se ejecutara el «break».
        }

        return c;
    }

    public int contenido(int jarra){                                                                                    // Hecho con «if-else» como ejemplo.
        int c;

        if(jarra == 1){
            c = jarra1.contenido();

        }else if(jarra == 2) {
            c = jarra2.contenido();

        }else{
            throw new RuntimeException("ERROR: Jarra mal indicada."); // break;
        }

        return c;
    }

    public void llenar(int jarra){
        switch (jarra){
            case 1 : jarra1.llenar(); break;
            case 2 : jarra2.llenar(); break;
            default: throw new RuntimeException("ERROR: Jarra mal indicada."); // break;
        }
    }

    public void vaciar(int jarra) throws RuntimeException{
        switch (jarra){
            case 1 : jarra1.vaciar(); break;
            case 2 : jarra2.vaciar(); break;
            default: throw new RuntimeException("ERROR: Jarra mal indicada."); // break;
        }
    }

    public void llenarDesde(int jarra) throws RuntimeException{
        switch (jarra){
            case 1 : jarra1.llenarDesde(jarra2); break;
            case 2 : jarra2.llenarDesde(jarra1); break;
            default: throw new RuntimeException("ERROR: Jarra mal indicada."); // break;
        }
    }

    @Override
    public String toString() {
        return "Mesa[ " + jarra1 + " , " + jarra2 + " ]";
    }
}
