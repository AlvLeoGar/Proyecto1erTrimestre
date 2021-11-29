import java.util.Scanner;

public class Game {
    static Scanner teclado = new Scanner(System.in);
    private static String name = "Jugador";
    private static String ultimJugadorPenjat = "(no record)";
    private static String ultimJugadorFlota = "(no record)";
    public static void main(String[] args){
        int puntuacioPenjat = 0;
        int puntuacioFlota = 0;
        int respuestaUsuario;
        do {
            System.out.println("Tria una opció:");
            System.out.println(" [1] Introduir nom del Jugador");
            System.out.println(" [2] Jugar al Penjat");
            System.out.println(" [3] Jugar al Enfosar la flota");
            System.out.println(" [4] Vorer últimes puntuacions");
            System.out.println(" [5] Eixir");
            respuestaUsuario = teclado.nextInt();
            switch (respuestaUsuario) {
                case 1:
                    introduirName();
                    break;
                case 2:
                    Penjat penjat = new Penjat(name);
                    penjat.inici();
                    puntuacioPenjat = penjat.sendLastResult();
                    ultimJugadorPenjat = penjat.lastPlayer();
                    break;
                case 3:
                    EnfonsarFlota enfonsarFlota = new EnfonsarFlota(name);
                    enfonsarFlota.inici();
                    puntuacioFlota = enfonsarFlota.flotaEnd();
                    ultimJugadorFlota = enfonsarFlota.flotaName();
                    break;
                case 4:
                    System.out.println("La ultima puntuació del Penjat pertanya a " + ultimJugadorPenjat + " y te " + puntuacioPenjat);
                    System.out.println("La ultima puntuació de Enfonsar la Flota pertanya a " + ultimJugadorFlota + " y te " + puntuacioFlota + " punts.");
                    break;
                case 5:
                    System.out.println("Gracies per jugar!!!!");
                    System.out.println("Fet per Álvaro León García, alumne de 1º de DAW");
                    break;
                default:
                    System.out.println("opció no correcta");
                    break;
            }
        }while (respuestaUsuario != 5);
    }
    static void introduirName(){
        System.out.println("Dime el nom que vols tindre");
        name = teclado.next();
    }
}