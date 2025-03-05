package exemplo1;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Observer> observadores = new ArrayList<>();

    public void adicionarObservador(Observer observador) {
        observadores.add(observador);
    }

    public void removerObservador(Observer observador) {
        observadores.remove(observador);
    }

    public void notificarObservadores(String mensagem) {
        for (Observer obs : observadores) {
            obs.atualizar(mensagem);
        }
    }

    public void realizarCompra(String produto) {
        System.out.println("Compra realizada: " + produto);
        notificarObservadores("Novo pedido: " + produto);
    }
}
