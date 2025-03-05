package exemplo1;

public class EmailNotificacao implements Observer {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Enviando email: " + mensagem);
    }
}
