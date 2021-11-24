public class Paraula {

    public Paraula(int userTries){
        this.userTries = userTries;
    }
    private String paraula = selectParaula();
    private char [] knowChar = knowChar = new char[paraula.length()];
    int userTries;

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
            case 12 -> "StreetFighter";
            case 13 -> "Pan";
            default -> null;
        };
    }

    public char [] partirParaula(String paraula){
        char[] paraulaPart = new char[paraula.length()];
        for(int i = 0; i < paraula.length(); i++){
            paraulaPart[i] = paraula.charAt(i);
        }
        return paraulaPart;
    }
    public void mostrarParaula() {
        System.out.println("");
        if(userTries == 0){
            for(int i = 0; i < knowChar.length; i++){
                knowChar[i] = '_';
            }
        }
        for (int i = 0; i < paraula.length(); i++) {
            System.out.print(knowChar[i] + " ");
        }
        System.out.println("");
    }
    public int introuirParaula() {
        System.out.println("Introdueix la paraula");
        userTries++;
        String respuestaUsuario = Game.teclado.next();
        if(!respuestaUsuario.equals(paraula)){
            lletraPista(0);
            return 1;
        }
        else{
            System.out.println("ggwp");
            return 0;
        }
    }

    public void lletraPista(int seleccionador){
        seleccionador = (int) (Math.random()* paraula.length()-1);
        if(knowChar[seleccionador] == '_'){
            knowChar[seleccionador] = partirParaula(paraula)[seleccionador];
        }
        else {
            lletraPista(seleccionador);
        }
    }
}
