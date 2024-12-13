import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        char[][] campo = {
                { '-', '-', '-' },
                { '-', '-', '-' },
                { '-', '-', '-' }
        };

        System.out.println("-------------------------");
        System.out.println("Tic Tac Toe");
        System.out.println("-------------------------");

        System.out.print("Inserisci la riga (1-3): ");
        int riga = sc.nextInt();

        System.out.print("Inserisci la colonna (1-3): ");
        int colonna = sc.nextInt();

        campo[riga - 1][colonna - 1] = 'X';

        // stampa campo
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(campo[i][j] + " ");
            }
            System.out.println(" ");
        }

        sc.close();

    }
}
