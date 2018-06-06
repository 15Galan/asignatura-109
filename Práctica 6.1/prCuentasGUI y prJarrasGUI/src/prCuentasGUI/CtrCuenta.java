package prCuentasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrCuenta implements ActionListener {

    private VistaCuenta vistaCuenta;
    private Cuenta cuenta;

    public CtrCuenta(VistaCuenta vc, Cuenta c) {
        vistaCuenta = vc;
        cuenta = c;
    }

    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();
        vistaCuenta.mensaje("");

        try{
            if(comando.equals(VistaCuenta.INGRESO)){
                double cantidad = vistaCuenta.obtenerCantidad();

                cuenta.ingresa(cantidad);

                vistaCuenta.saldo(cuenta.saldo());
                vistaCuenta.mensaje("Ingreso de " + cantidad + "€ realizado con éxito");
                vistaCuenta.borrar();

            } else if(comando.equals(VistaCuenta.GASTO)){
                double cantidad = vistaCuenta.obtenerCantidad();
                double saldo_inicial = cuenta.saldo();

                cuenta.extrae(cantidad);

                if(cantidad > saldo_inicial){
                    cantidad = saldo_inicial;
                }

                vistaCuenta.saldo(cuenta.saldo());
                vistaCuenta.mensaje("Extracto de " + cantidad + "€ realizado con éxito.");
                vistaCuenta.borrar();

            }else if(comando.equals(VistaCuenta.SALDO)){
                vistaCuenta.mensaje("El saldo actual es de " + cuenta.saldo() + "€.");
            }

        }catch (NumberFormatException e){
            e.getCause();

            vistaCuenta.mensaje("¿Qué has escrito?");
            vistaCuenta.borrar();
        }
    }
}
