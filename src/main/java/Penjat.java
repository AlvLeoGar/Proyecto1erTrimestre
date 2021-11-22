import java.util.Scanner;

public class Penjat {
    Scanner teclado = new Scanner(System.in);
    private String name;
    private int tries;
    public Penjat(String name){
        this.name = name;
    }
    private int respuetaUsuario;
    public void inici(){
        do {
            System.out.println(" [1] Iniciar el joc");
            System.out.println(" [2] Mostrar normes");
            System.out.println(" [3] Eixir");
            respuetaUsuario = teclado.nextInt();
            switch(respuetaUsuario){
                case 1:
                    penjatStart();
                    break;
                case 2:
                    System.out.println("khjgibgioshygsdkgnslohglksdngioghs");
                    break;
                case 3:
                    System.out.println("JAJA OMGLUL");
                    break;
                default: System.out.println("JAJA OMGL");
            }
        }while(respuetaUsuario != 3);
    }
    public void penjatStart(){
        System.out.println("Selecciona el nivell de dificultat (1 - 3)");
        do {
            respuetaUsuario = teclado.nextInt();
            if (respuetaUsuario == 1) {
                System.out.println("Dificultat seleccionada: Fàcil");
                tries = 9;
            } else if (respuetaUsuario == 2) {
                System.out.println("Dificultat seleccionada: Normal");
                tries = 6;
            } else if (respuetaUsuario == 3) {
                System.out.println("Dificultat seleccionada: Difícil");
                tries = 3;
            } else {
                System.out.println("Dime un nombre entre 1 i 3");
            }
        } while (respuetaUsuario > 3);
        System.out.println(selectParaula());
    }
    public String selectParaula(){
        int seleccionador = (int) (Math.random() * 14);
        return switch (seleccionador) {
            case 0 -> "Puntuació";
            case 1 -> "Variable";
            case 2 -> "Gol";
            case 3 -> "Nivel";
            case 4 -> "Objecte";
            case 5 -> "Porter";
            case 6 -> "Mundo";
            case 7 -> "HolaMundo";
            case 8 -> "Delanter";
            case 9 -> "Control";
            case 10 -> "Classe";
            case 11 -> "Defensa";
            case 12 -> "Street Fighter";
            case 13 -> "Pan";
            default -> null;
        };
    }
}
