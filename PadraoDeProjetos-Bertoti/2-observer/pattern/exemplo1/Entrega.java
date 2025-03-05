package exemplo1;

public class Entrega implements Observer {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Preparando entrega: " + mensagem);
    }
}
