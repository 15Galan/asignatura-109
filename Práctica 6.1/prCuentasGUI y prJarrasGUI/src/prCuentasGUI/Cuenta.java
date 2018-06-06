package prCuentasGUI;

public class Cuenta {
	private double saldo;
	
	public Cuenta(double si) {
        if (si < 0) { // saldo inicial negativo
        	throw new RuntimeException("Imposible crear una cuenta con saldo inicial negativo");
        }
		saldo = si;
	}
	public void ingresa(double ing) {
		if (ing < 0) { // ingreso negativo
        	throw new RuntimeException("Imposible ingresar una cantidad negativa");
        }
		saldo += ing;
	}
	public double extrae(double extrae) {
		if (extrae < 0) { // extracción negativa
        	throw new RuntimeException("Imposible extraer una cantidad negativa");
        }
		double realExtrae = extrae;
		if (saldo < extrae) {
			realExtrae = saldo;
			saldo = 0;
		} else {
			saldo -= realExtrae;
		}
		return realExtrae;
	}
	public double saldo() {
		return saldo;
	}

}
