package exemplo1;

public class Estoque implements Observer {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Atualizando estoque: " + mensagem);
    }
}