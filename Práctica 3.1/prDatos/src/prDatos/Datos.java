package prDatos;

import java.util.Arrays;

public class Datos {

    private double[] datos;
    private String[] errores;
    private double min;
    private double max;

    public Datos(String[] valores, double minimo, double maximo){

        datos = new double[valores.length];
        errores = new String[valores.length];
        min = minimo;
        max = maximo;

        int id = 0;     // Indice del array «valores».
        int ie = 0;     // Indice del array «errores».

        for (String s : valores) {
            try {
                datos[id] = Double.parseDouble(s);
                id++;

            }catch(NumberFormatException e) {
                errores[ie] = s;
                ie++;
            }
        }

        datos = Arrays.copyOf(datos, id);
        errores = Arrays.copyOf(errores, ie);
    }

    public double calcMedia(){
        double media = 0;
        int N = 0;

        for(double d : datos){

            if(min <= d && d <= max){
                media += d;
                N++;
            }
        }

        if(N != 0){
            media = media/N;
        }else{
            throw new DatosException("Error");
        }

        return media;
    }

    public double calcDesvTipica(){
        double media = calcMedia();     // No repetir todos los calculos de la media en cada iteracion del bucle «for».
        double desvTipica = 0;
        int N = 0;

        for(double d : datos){

            if(min <= d && d <= max){
                desvTipica += Math.pow(d - media, 2);
                N++;
            }
        }

        if(N != 0){
            desvTipica = Math.sqrt(desvTipica/N);
        }else{
            throw new DatosException("Error");
        }

        return desvTipica;
    }

    public void setRango(String rango){
        String[] min_max = rango.split(";");

        try{

        min = Double.parseDouble(min_max[0]);
        max = Double.parseDouble(min_max[1]);

//        }catch(IndexOutOfBoundException e){
//            throw new DatosException("Error: No hay datos suficientes.");
        }catch(NumberFormatException e){
            throw new DatosException("Error: No se recibe un numero");
        }catch(Exception e){
            throw new DatosException();
        }

        /*
        int idx = minmax.indexOf(';');
        min = Double.parseDouble(minmax.substring(0,idx);
        max = Double.parseDouble(minmax.substring(idx+1);
        */
    }

    public double[] getDatos(){
        return datos;
    }

    public String[] getErrores() {
        return errores;
    }

    @Override
    public String toString() {
        String mensaje = "Min: " + min + ", Max: " + max + "," + '\n';

        mensaje += Arrays.toString(datos) + "," + '\n';

        mensaje += Arrays.toString(errores) + "," + '\n';

        try{
            mensaje += "Media: " + calcMedia() + ", ";

        }catch (Exception e){
            mensaje += "Media: ERROR ";
        }

        try{
            mensaje += "DesvTipica: " + calcDesvTipica();

        }catch(Exception e){
            mensaje += "DesvTipica: ERROR";
        }


        return mensaje;
    }
}
