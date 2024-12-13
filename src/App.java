import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        char[][] campo = {
                { '-', '-', '-' },
                { '-', '-', '-' },
                { '-', '-', '-' }
        };

        System.out.println("-------------------------");
        System.out.println("Tic Tac Toe");
        System.out.println("-------------------------");

        char Giocatore1 = 'X';
        char Giocatore2 = 'O';
        boolean turno = true;

        for (int mosse = 0; mosse < 9; mosse++) {

            char turnoCorrente;
            // assegnazione simbolo
            if (turno) {
                turnoCorrente = Giocatore1;
            } else {
                turnoCorrente = Giocatore2;
            }
            // controllo turno
            if (turno) {
                // turno del giocatore
                System.out.println("Mossa numero " + (mosse + 1) + " - Giocatore Utente (" + turnoCorrente + ")");

                boolean punto = false;
                int riga = 0, colonna = 0;
                // Controllo input
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
            } else {

                // Turno del PC
                System.out.println("Mossa numero " + (mosse + 1) + " - Giocatore Computer (" + turnoCorrente + ")");
                boolean sceltaPc = false;

                while (!sceltaPc) {
                    int rigaPc = r.nextInt(3);
                    int colonnaPc = r.nextInt(3);

                    if (campo[rigaPc][colonnaPc] == '-') {
                        campo[rigaPc][colonnaPc] = turnoCorrente;
                        sceltaPc = true;
                    }

                }

            }
            // stampa campo
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(campo[i][j] + " ");
                }
                System.out.println(" ");
            }

            // Controllo del vincitore
            char vincitore = '-';

            // Controllo righe
            for (int i = 0; i < 3; i++) {
                if (campo[i][0] != '-' && campo[i][0] == campo[i][1] && campo[i][1] == campo[i][2]) {
                    vincitore = campo[i][0];
                }
            }

            // Controllo colonne
            for (int j = 0; j < 3; j++) {
                if (campo[0][j] != '-' && campo[0][j] == campo[1][j] && campo[1][j] == campo[2][j]) {
                    vincitore = campo[0][j];
                }
            }
            // Controllo diagonali
            if (campo[0][0] != '-' && campo[0][0] == campo[1][1] && campo[1][1] == campo[2][2]) {
                vincitore = campo[0][0];
            }
            if (campo[0][2] != '-' && campo[0][2] == campo[1][1] && campo[1][1] == campo[2][0]) {
                vincitore = campo[0][2];
            }

            // Se c'è un vincitore
            if (vincitore == 'X') {
                System.out.println("Ha vinto il Giocatore Utente (X)!");
                break;
            } else if (vincitore == 'O') {
                System.out.println("Ha vinto il Giocatore Computer (O)!"); 
                break;
            }

            // Cambia turno
            turno = !turno;

            // Se siamo all'ultima mossa e non c'è vincitore, è pareggio
            if (mosse == 8) {
                System.out.println("Pareggio! Non ci sono più mosse disponibili.");
            }

            
        }
        sc.close();

    }
}
