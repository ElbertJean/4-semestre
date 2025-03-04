package antipattern.exemplo2;

public class Main {
    public static void main(String[] args) {
        Locomocao locomocao = new Locomocao("Onibus");
        Pessoa pessoa = new Pessoa(locomocao);
        pessoa.locomover();

        pessoa.setLocomocao(new Locomocao("Carro"));
        pessoa.locomover();

        pessoa.setLocomocao(new Locomocao("Corrida"));
        pessoa.locomover();
    }
}