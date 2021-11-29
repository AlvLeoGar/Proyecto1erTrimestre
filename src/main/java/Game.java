import java.util.Scanner;

public class Game {
    static Scanner teclado = new Scanner(System.in);
    private static String name = "Jugador";
    public static void main(String[] args){
        int puntuacioPenjat = 0;
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
                    break;
                case 3:
                    EnfonsarFlota enfonsarFlota = new EnfonsarFlota(name);
                    enfonsarFlota.inici();
                    break;
                case 4:
                    System.out.println("La ultima puntuació del penjat: " + puntuacioPenjat);
                    break;
                case 5:
                    System.out.println("Bye");
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