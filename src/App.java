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

        char Giocatore1= 'X';
        char Giocatore2= 'O';
        boolean turno= true;

        for ( int mosse = 0; mosse < 9; mosse++) {

            char turnoCorrente;

            if (turno) {
                turnoCorrente= Giocatore1;
            }
            else {
                turnoCorrente= Giocatore2;
            }

            System.out.println("\nMossa numero " + (mosse + 1));

            boolean punto = false;
            int riga = 0, colonna = 0;

            while (!punto) {
                System.out.print("Inserisci la riga (1-3): ");
                riga = sc.nextInt();

                System.out.print("Inserisci la colonna (1-3): ");
                colonna = sc.nextInt();

                if (riga < 1 || riga > 3 || colonna < 1 || colonna > 3) {
                    System.out.println("Coordinata non valida");
                    continue;
                }

                if (campo[riga - 1][colonna - 1] != '-') {
                    System.out.println("Questa posizione è già occupata");
                    continue;
                }

                punto = true;

            }


            campo[riga - 1][colonna - 1] = turnoCorrente;

            // stampa campo
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(campo[i][j] + " ");
                }
                System.out.println(" ");
            }

            turno= !turno;

        }

        System.out.println("Partita terminata");
        sc.close();

    }
}
