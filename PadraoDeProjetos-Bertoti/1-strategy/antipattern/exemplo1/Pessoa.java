package antipattern.exemplo1;

public class Pessoa {
    private String meioDeLocomocao;

    public Pessoa(String meioDeLocomocao) {
        this.meioDeLocomocao = meioDeLocomocao;
    }

    public void setMeioDeLocomocao(String meioDeLocomocao) {
        this.meioDeLocomocao = meioDeLocomocao;
    }

    public void locomover() {
        if (meioDeLocomocao.equals("Onibus")) {
            System.out.println("Método de locomoção: Ônibus");
        } else if (meioDeLocomocao.equals("Carro")) {
            System.out.println("Método de locomoção: Carro");
        } else if (meioDeLocomocao.equals("Corrida")) {
            System.out.println("Método de locomoção: Corrida");
        } else {
            System.out.println("Método de locomoção desconhecido");
        }
    }
}
