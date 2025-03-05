package exemplo2;

import java.util.Scanner;

public class Guitarra implements Instrumento{

    public void tocar(String banda) {
        switch (banda) {
            case "Iron Maiden":
                System.out.println("Qual solo deseja tocar?");
                System.out.println("1 - Fear of the Dark\n2 - The Number of the Beast");
                Scanner scannerIron = new Scanner(System.in);
                String soloIron = scannerIron.nextLine();
                switch (soloIron) {
                    case "1":
                        System.out.println("Tocando solo Fear of the Dark");
                        break;
                    case "2":
                        System.out.println("Tocando solo The Number of the Beast");
                        break;
                    default:
                        System.out.println("Opção Inválida, Bye!");
                    break;
                }
                break;
            case "Cueio":
                System.out.println("Qual solo deseja tocar?");
                System.out.println("1- De Creta a Icaria\n2- Cair e Levantar\n3- Vida Sem Cida");
                Scanner scannerCueio = new Scanner(System.in);
                String soloCueio = scannerCueio.nextLine();

                switch (soloCueio) {
                    case "1":
                        System.out.println("Tocando solo Fear of the Dark");
                        break;
                    case "2":
                        System.out.println("Tocando solo The Number of the Beast");
                        break;
                    case "3":
                        System.out.println("Tocando solo The Number of the Beast");
                        break;
                    default:
                        System.out.println("Opção Inválida, Bye!");
                        break;
                }
                break;
            default:
                System.out.println("Você não sabe solos dessa banda.");
                break;
        }
    }
}
