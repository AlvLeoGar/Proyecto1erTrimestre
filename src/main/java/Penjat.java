public class Penjat {
    private String name;
    private int tries;
    private int userTries;
    private int puntuacio;
    private int resultat = 1;
    private boolean normes = true;
    public Penjat(String name){
        this.name = name;
    }
    private int respuetaUsuario;
    public void inici(){
        do {
            System.out.println("_.*WELCOME TO El Penjat*._");
            System.out.println(" [1] Iniciar el joc");
            System.out.println(" [2] Mostrar normes");
            System.out.println(" [3] Eixir");
            respuetaUsuario = Game.teclado.nextInt();
            switch(respuetaUsuario){
                case 1:
                    userTries = 0;
                    penjatStart();
                    break;
                case 2:
                    if(!normes) {
                        System.out.println("Ya havies vist les normes, vols tornar a veure-les? (y/n)");
                        if(Game.teclado.next().equalsIgnoreCase("y")){
                            normes = true;
                        }
                    }
                    if(normes) {
                        System.out.println("El joc conisteix en acertar la paraula que apareixerá censurada en pantalla en una quantitat limitada de intents.");
                        System.out.println("N'hi han 3 dificultats que defineixen els intents que tens: ");
                        System.out.println("[1] Fàcil ---> Tens 9 intents per acertar la paraula");
                        System.out.println("[2] Normal ---> Tens 6 intents per acertar la paraula");
                        System.out.println("[3] Difícil ---> Tens 3 intents per acertar la paraula");
                        System.out.println("Les tematiques de les paraules son: videojocs, informatica i futbol (les paraules NO portaràn accent)");
                        normes = false;
                    }
                    break;
                case 3:
                    System.out.println("Tornant al menú");
                    break;
                default: System.out.println("Entrada incorrecta, selecciona un nombre del 1 al 3");
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
        Paraula paraula = new Paraula(userTries, tries);
        do{
            if (respuetaUsuario == 25661){
                System.out.println("Has perdut");
                respuetaUsuario++;
            }
            else{
                paraula.mostrarParaula();
                System.out.println("Tria una opció: ");
                System.out.print(" [1] Intentar resoldre");
                System.out.print(" [2] Rendir-se");

                if(userTries == tries && resultat != 0) {
                    respuetaUsuario = 25661;
                }
                else{
                    respuetaUsuario = Game.teclado.nextInt();
                }
                switch (respuetaUsuario) {
                    case 1:
                        resultat = paraula.introuirParaula();
                        userTries++;
                        if(resultat == 0){
                            puntuacio = paraula.sendPuntuacion();
                            respuetaUsuario = 25662;
                        }
                        break;
                    case 2:
                        System.out.println("Chao");
                        respuetaUsuario = 25662;
                        break;
                    case 25662:
                        System.out.println("Has perdut");
                        break;
                    default:
                        System.out.println("Elegeix una opció que es mostra en pantalla");
                        break;
                }
            }
        }while(respuetaUsuario != 25662);
      respuetaUsuario = 0;
    }

    public int sendLastResult(){
        return puntuacio;
    }
    public String lastPlayer(){return name;}
}
