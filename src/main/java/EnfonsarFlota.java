public class EnfonsarFlota {
    private String name;
    private int respuetaUsuario;
    private int resultados;
    private boolean normes = true;
    private boolean introduirVaixells = false;
    private boolean control = false;
    public EnfonsarFlota(String name){
        this.name = name;
    }
    public void inici(){
        do {
            if (control){
                System.out.println("Has obtingut " + flotaEnd() + " punts");
            }
            System.out.println("_.*WELCOME TO Enfonsar la Flota*._");
            System.out.println(" [1] Iniciar el joc");
            System.out.println(" [2] Mostrar normes");
            System.out.println(" [3] Eixir");
            respuetaUsuario = Game.teclado.nextInt();
            switch(respuetaUsuario){
                case 1:
                    flotaStart();
                    break;
                case 2:
                    if(!normes) {
                        System.out.println("Ya havies vist les normes, vols tornar a veure-les? (y/n)");
                        if(Game.teclado.next().equalsIgnoreCase("y")){
                            normes = true;
                        }
                    }
                    if(normes) {
                        System.out.println("El joc conisteix en enfonsar tota la flota del oponent que será colocada de al azar");
                        System.out.println("N'hi han 5 tipus de vaixells ");
                        System.out.println("[1] Tipus A ----> D'aquests vaixells n'hi han 3 i cadascun ocupa una celda");
                        System.out.println("[2] Tipus E ----> D'aquests vaixells n'hi han 3 i cadascun ocupa dues celdes");
                        System.out.println("[3] Tipus I ----> D'aquests vaixells n'hi han 2 i cadascun ocupa tres celdes");
                        System.out.println("[3] Tipus O ----> D'aquests vaixells n'hi ha 1 i ocupa quatre celdes");
                        System.out.println("[3] Tipus U ----> D'aquests vaixells n'hi ha 1 i ocupa cinc celdes");
                        System.out.println("Quan acertes golpejant al oponent es mostrarà una !, de lo contrari, es mostrarà una ?");
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
    public void flotaStart(){
        Tablero tablero = new Tablero(name);
        tablero.mostrarTabler();
        if(!introduirVaixells){
            tablero.introduirVaixell();
            introduirVaixells = true;
        }
        tablero.introduirVaixellEnemic();
        do {
            tablero.mostrarTabler();
            if (tablero.comprobarFin()) {
                respuetaUsuario = 2;
            } else {
                System.out.println("Que vols fer?");
                System.out.println("[1] Disparar  [2] Eixir");
                respuetaUsuario = Game.teclado.nextInt();
                switch (respuetaUsuario) {
                    case 1:
                        tablero.disparar();
                        break;
                    case 2:
                        System.out.println("Partida finalitzada");
                        resultados = tablero.finalitzar();
                        break;
                    default:
                        System.out.println("Elegix una de les opcions mostrades");
                }
            }
        }while (respuetaUsuario != 2);
    }
    public int flotaEnd(){
        return resultados;
    }
    public String flotaName(){
        return name;
    }
}
