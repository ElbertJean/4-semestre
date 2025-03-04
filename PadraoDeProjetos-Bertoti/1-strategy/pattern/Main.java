package pattern;

public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(new Onibus());
        pessoa.locomover();

        pessoa.setLocomocao(new Carro());
        pessoa.locomover();

        pessoa.setLocomocao(new Corrida());
        pessoa.locomover();
    }
}
