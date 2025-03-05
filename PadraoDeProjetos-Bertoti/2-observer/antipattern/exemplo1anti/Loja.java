package exemplo1anti;

public class Loja {
    private EmailNotificacao email;
    private Estoque estoque;
    private Entrega entrega;

    public Loja() {
        this.email = new EmailNotificacao();
        this.estoque = new Estoque();
        this.entrega = new Entrega();
    }

    public void realizarCompra(String produto) {
        System.out.println("Compra realizada: " + produto);

        email.enviarEmail(produto);
        estoque.atualizarEstoque(produto);
        entrega.prepararEntrega(produto);
    }
}
