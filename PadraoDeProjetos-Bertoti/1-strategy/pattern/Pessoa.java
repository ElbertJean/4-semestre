package pattern;
public class Pessoa {
    private Locomocao locomocao;

    public Pessoa(Locomocao locomocao) {
        this.locomocao = locomocao;
    }

    public void setLocomocao(Locomocao locomocao) {
        this.locomocao = locomocao;
    }

    public void locomover() {
        locomocao.mover();
    }
}
