package exemplo2;

public class Violao implements Instrumento{
    
    public void tocar(String musica) {
        switch (musica) {
            case "Iron Maiden":
                System.out.println("Tocando Iron Maiden no violão");
                break;
            case "Cueio Limão":
                System.out.println("Tocando Cueio Limão no violão");
                break;
            case "A-HA":
                System.out.println("Tocando A-HA no violão");
                break;
            default:
                System.out.println("Você não sabe tocar músicas desse artista no violão");
                break;
        }
    }
}
