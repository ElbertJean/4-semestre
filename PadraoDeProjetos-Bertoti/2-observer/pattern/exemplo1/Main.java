package exemplo1;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        Observer email = new EmailNotificacao();
        Observer estoque = new Estoque();
        Observer entrega = new Entrega();

        loja.adicionarObservador(email);
        loja.adicionarObservador(estoque);
        loja.adicionarObservador(entrega);

        loja.realizarCompra("Smartphone");
        System.out.println('\n');

        loja.removerObservador(estoque);
        loja.realizarCompra("Notebook");
    }
}
