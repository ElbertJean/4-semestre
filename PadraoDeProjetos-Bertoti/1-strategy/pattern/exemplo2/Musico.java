package exemplo2;

public class Musico {
    private Instrumento instrumento;
    
    public Musico(Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    void setInstrumento (Instrumento instrumento) {
        this.instrumento = instrumento;
    }

    void tocar(String musica) {
        instrumento.tocar(musica);
    }
    
}
