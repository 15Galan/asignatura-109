package prJarrasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorJarras implements ActionListener {

    private VistaJarras vistaJarras;

    private Jarra jarraA;
    private Jarra jarraB;

    public ControladorJarras(VistaJarras panel) {
        vistaJarras = panel;
        vistaJarras.habilitarInicio(true);
        vistaJarras.ok("Indica las capacidades iniciales.");
    }

    public void actionPerformed(ActionEvent evento){
        try{
            if(evento.getActionCommand().equals(VistaJarras.INICIAR)){
                jarraA = new Jarra(vistaJarras.capacidadInicialA());
                jarraB = new Jarra(vistaJarras.capacidadInicialB());
                vistaJarras.agregarAHistorico("Se han creado las Jarras A y B.");
                vistaJarras.ok("Jarras creadas con éxito.");

                vistaJarras.habilitarInicio(false);

            }else if(evento.getActionCommand().equals(VistaJarras.LLENAR_A)){
                jarraA.llenar();
                vistaJarras.agregarAHistorico("Se ha llenado la Jarra A.");
                vistaJarras.ok("Jarra A llenada con éxito.");

            }else if(evento.getActionCommand().equals(VistaJarras.LLENAR_B)){
                jarraB.llenar();
                vistaJarras.agregarAHistorico("Se ha llenado la Jarra B.");
                vistaJarras.ok("Jarra B llenada con éxito.");

            }else if(evento.getActionCommand().equals(VistaJarras.VACIAR_A)){
                jarraA.vaciar();
                vistaJarras.agregarAHistorico("Se ha vaciado la Jarra A.");
                vistaJarras.ok("Jarra A vaciada con éxito.");

            }else if(evento.getActionCommand().equals(VistaJarras.VACIAR_B)){
                jarraB.vaciar();
                vistaJarras.agregarAHistorico("Se ha vaciado la Jarra B.");
                vistaJarras.ok("Jarra B vaciada con éxito.");

            }else if(evento.getActionCommand().equals(VistaJarras.VOLCAR_A_EN_B)){
                jarraB.llenarDesde(jarraA);
                vistaJarras.agregarAHistorico("Se ha volcado la Jarra A sobre la Jarra B.");
                vistaJarras.ok("Jarra A volcada con éxito.");

            }else if(evento.getActionCommand().equals(VistaJarras.VOLCAR_B_EN_A)){
                jarraA.llenarDesde(jarraB);
                vistaJarras.agregarAHistorico("Se ha volcado la Jarra B sobre la Jarra A.");
                vistaJarras.ok("Jarra B volcada con éxito.");

            }else if(evento.equals(VistaJarras.FINALIZAR)){
                jarraA = null;
                jarraB = null;

                vistaJarras.limpiar();
                vistaJarras.habilitarInicio(true);
            }

            if(jarraA != null && jarraB != null){
                vistaJarras.contenidoA(jarraA.getContenido());
                vistaJarras.contenidoB(jarraB.getContenido());
                vistaJarras.capacidadA(jarraA.getCapacidad());
                vistaJarras.capacidadB(jarraB.getCapacidad());
            }

        }catch (NullPointerException e){
            e.getCause();
        }
    }
}
