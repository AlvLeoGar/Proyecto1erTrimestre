public class Penjat {
    private String name;
    private int tries;
    private Paraula paraula = new Paraula();
    public Penjat(String name){
        this.name = name;
    }
    private int respuetaUsuario;
    public void inici(){
        do {
            System.out.println(" [1] Iniciar el joc");
            System.out.println(" [2] Mostrar normes");
            System.out.println(" [3] Eixir");
            respuetaUsuario = Game.teclado.nextInt();
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
            respuetaUsuario = Game.teclado.nextInt();
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
        do{
            paraula.mostrarParaula();
            System.out.println("Tria una opció: ");
            System.out.print(" [1] Intentar resoldre");
            System.out.print(" [2] Rendir-se");
            respuetaUsuario = Game.teclado.nextInt();
            switch (respuetaUsuario){
                case 1: paraula.lletraPista(); break;
                case 2: System.out.println("xD"); break;
                default: System.out.println("xD"); break;
            }
            }while(respuetaUsuario != 2);

        }

}
