public class Paraula {
    private int lletraMostrada = 0;
    private int dificultat;
    private String paraula = selectParaula();
    private char [] knowChar  = new char[paraula.length()];
    int userTries;
    private char [] resultado = new char[paraula.length()];
    private boolean pistaDada;
    public Paraula(int userTries, int dificultat){ //constructor
        this.userTries = userTries;
        this.dificultat = dificultat;
    }
    public String selectParaula(){ //seleccionador de paraula
        int seleccionador = 12; //(int) (Math.random() * 14);
        return switch (seleccionador) {
            case 0 -> "Puntuacio";
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
            case 14 -> "Arcade";
            case 15 -> "Boss";
            case 16 -> "Experiencia";
            case 17 -> "Computadora";
            case 18 -> "Videoconsola";
            default -> null;
        };
    }

    public char [] partirParaula(String paraula){ //pasar la paraula a array de char
        char[] paraulaPart = new char[paraula.length()];
        for(int i = 0; i < paraula.length(); i++){
            paraulaPart[i] = paraula.charAt(i);
        }
        return paraulaPart;
    }
    public void mostrarParaula() { //pintar la paraula censurada
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
    public int introuirParaula() { //proces de introduccio de paraules y comprobar si està mal
        System.out.println("Introdueix la paraula");
        pistaDada = false;
        String respuestaUsuario = Game.teclado.next();
        for(int i = 0; i < respuestaUsuario.length(); i++){
           resultado[i] = respuestaUsuario.charAt(i);
        }
        for (int i = 0; i < paraula.length(); i++) {
            if ((Character.toUpperCase(resultado[i]) != Character.toUpperCase(partirParaula(paraula)[i]) ||
                    Character.toLowerCase(resultado[i]) != Character.toLowerCase(partirParaula(paraula)[i])
                    )&& !pistaDada) {
                lletraPista();
                userTries++;
            } else if(respuestaUsuario.equalsIgnoreCase(paraula)){
                System.out.println("ggwp");
                sendPuntuacion();
                return 0;
            }
        }
        return 1;
    }

    public void lletraPista() { //per a posar una lletra pista a l'hora de jugar
        int seleccionador = (int) (Math.random() * paraula.length());
        if (knowChar[seleccionador] == '_') {
            knowChar[seleccionador] = partirParaula(paraula)[seleccionador];
            for (int i = 0; i < paraula.length(); i++) {
                if (partirParaula(paraula)[i] == knowChar[seleccionador]){
                    knowChar[i] = partirParaula(paraula)[seleccionador];
                    lletraMostrada++;
                }

            }
            pistaDada = true;
        } else {
            for(int i=0; i< paraula.length(); i++){ //evitar StackOverflow
                if (!(knowChar[i] == partirParaula(paraula)[i])) {
                    lletraPista();
                }
            }
        }
    }
    public int lletresRepetides(){
        int lletres = 0;
        char [] repetides = new char[paraula.length()];
        for(int i= 0; i < paraula.length(); i++){
            repetides[i] = '_';
        }
        for(int i = 0; i < paraula.length(); i++){
            int repeticions = 0;

            boolean control = true;
            for(int j = 0;j < paraula.length(); j++) {
                if (partirParaula(paraula)[i] == partirParaula(paraula)[j]) {
                    repeticions++;
                    if (repeticions >= 2) {
                        for (int k = 0; k < paraula.length(); k++) {
                            for(int repetidor = repetides.length-1; repetidor> 0;repetidor--)
                            if (repetides[repetidor] != partirParaula(paraula)[i] && control) {
                                repetides[lletres] = partirParaula(paraula)[i];
                                lletres++;
                                control = false;
                            }
                            else if(repetides[k] != '_'){
                                repetidor = 0;
                                k = partirParaula(paraula).length;
                            }
                        }
                    }
                }
            }
        }
        return lletres;
    }
    public int sendPuntuacion(){
        System.out.println((dificultat-userTries)*(paraula.length()-lletresRepetides())+ lletresRepetides() - lletraMostrada);
        return (dificultat-userTries) * (paraula.length()-lletresRepetides()) + lletresRepetides() - lletraMostrada;
    }
}
