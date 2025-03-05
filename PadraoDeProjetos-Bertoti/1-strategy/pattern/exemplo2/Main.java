package exemplo2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Musico musico = new Musico(new Violao());
        musico.tocar("Pepeu Gomes");

        Musico musico2 = new Musico(new Piano());
        musico2.tocar("Tina Charles");

        Musico musico3 = new Musico(new Guitarra());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual banda deseja tocar?");
        String banda = scanner.nextLine();
        musico3.tocar(banda);

        scanner.close();
    }
}
