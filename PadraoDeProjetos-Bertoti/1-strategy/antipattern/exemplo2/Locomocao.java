package antipattern.exemplo2;

public class Locomocao {
    private String tipo;

    public Locomocao(String tipo) {
        this.tipo = tipo;
    }

    public void locomover() {
        if (tipo.equals("Onibus")) {
            System.out.println("Método de locomoção: Ônibus");
        } else if (tipo.equals("Carro")) {
            System.out.println("Método de locomoção: Carro");
        } else if (tipo.equals("Corrida")) {
            System.out.println("Método de locomoção: Corrida");
        } else {
            System.out.println("Método de locomoção desconhecido");
        }
    }
}
