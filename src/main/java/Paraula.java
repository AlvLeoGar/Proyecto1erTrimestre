public class Paraula {
    private int lletraMostrada = 0;
    private int dificultat;
    private String paraula = selectParaula();
    private char [] knowChar  = new char[paraula.length()];
    int userTries;
    char [] resultado;
    private boolean pistaDada;
    public Paraula(int userTries, int dificultat){ //constructor
        this.userTries = userTries;
        this.dificultat = dificultat;
    }
    public String selectParaula(){ //seleccionador de paraula
        int seleccionador = (int) (Math.random() * 51);
        return switch (seleccionador) {
            case 0 -> "Puntuacio";
            case 1 -> "Variable";
            case 2 -> "Gol";
            case 3 -> "Nivel";
            case 4 -> "Objecte";
            case 5 -> "Porter";
            case 6 -> "Mundo";
            case 7 -> "HolaMundo";
            case 8 -> "Devanter";
            case 9 -> "Control";
            case 10 -> "Classe";
            case 11 -> "Defensa";
            case 12 -> "StreetFighter";
            case 13 -> "Zelda";
            case 14 -> "Arcade";
            case 15 -> "Boss";
            case 16 -> "Experiencia";
            case 17 -> "Computadora";
            case 18 -> "Videoconsola";
            case 19 -> "Checkpoint";
            case 20 -> "DVD";
            case 21 -> "Beta";
            case 22 -> "Targeta grafica";
            case 23 -> "Actualizacio";
            case 24 -> "Software";
            case 25 -> "Hardware";
            case 26 -> "Alfa";
            case 27 -> "Online";
            case 28 -> "Retro";
            case 29 -> "RPG";
            case 30 -> "Descarga";
            case 31 -> "Fornite";
            case 32 -> "MarioBros";
            case 33 -> "Procesador";
            case 34 -> "Pixel";
            case 35 -> "Pendrive";
            case 36 -> "Codi";
            case 37 -> "Arxiu";
            case 38 -> "Virus";
            case 39 -> "Web";
            case 40 -> "Simulador";
            case 41 -> "Emulador";
            case 42 -> "Servidor";
            case 43 -> "Sonic";
            case 44 -> "Pokemon";
            case 45 -> "CallOfDuty";
            case 46 -> "GTA";
            case 47 -> "Fifa";
            case 48 -> "Corner";
            case 49 -> "Penalti";
            case 50 -> "Porteria";
            default -> "Pan";
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
        resultado = new char[respuestaUsuario.length()];
        for(int i = 0; i < respuestaUsuario.length(); i++){
           resultado[i] = respuestaUsuario.charAt(i);
        }
        for (int i = 0; i < paraulaLlarga(); i++) {
            if (Character.toUpperCase(resultado[i]) != Character.toUpperCase(partirParaula(paraula)[i]) && !pistaDada) {
                lletraPista();
                userTries++;
            } else if(respuestaUsuario.equalsIgnoreCase(paraula)){
                System.out.println("ggwp");
                return 0;
            }
        }
        return 1;
    }

    public int paraulaLlarga(){ //evitar ArrayOutOfIndex quan es comproba la paraula
        if(paraula.length() <= resultado.length){
            return paraula.length();
        }
        else{
            return resultado.length;
        }
    }

    public void lletraPista() { //per a posar una lletra pista a l'hora de jugar
        int seleccionador = (int) (Math.random() * paraula.length());
        if (knowChar[seleccionador] == '_' && !pistaDada) {
            knowChar[seleccionador] = partirParaula(paraula)[seleccionador];
            for (int i = 0; i < paraula.length(); i++) {
                if (Character.toUpperCase(partirParaula(paraula)[i]) == Character.toUpperCase(knowChar[seleccionador])){
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
    public int lletresRepetides(){ //per a calcular les lletres repetides
        int lletres = paraula.length();
        char [] repetides = partirParaula(paraula);
        for(int i = 0 ; i < paraula.length(); i++){
            int repeticiones = 0;
            char update = paraula.charAt(i);
            boolean control = true;
            for(int j= 0; j < paraula.length(); j++){
                if(update == repetides[j]){
                    repeticiones++;
                    repetides[j] = '_';
                }
                if(repeticiones >= 2 && repetides[i] == '_' && control){
                    lletres--;
                    control = false;
                }
            }
        }
        return lletres;
    }
    public int sendPuntuacion(){ //enviar la puntuació
        System.out.println("has obtingut: ");
        System.out.print((dificultat-userTries) * lletresRepetides() + (paraula.length()-lletresRepetides()) - lletraMostrada);
        System.out.print(" punts");
        System.out.println("");
        return (dificultat-userTries) * lletresRepetides() + (paraula.length()-lletresRepetides()) - lletraMostrada;
    }
}

