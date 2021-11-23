public class Paraula {
    private char [] knowChar = new char[25];

    private String paraula = selectParaula();

    public String selectParaula(){
        for(int i = 0; i < 24; i++){
            knowChar[i] = 0;
        }
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
    public char [] partirParaula(String paraula){
        char[] paraulaPart = new char[paraula.length()];
        for(int i = 0; i < paraula.length(); i++){
            paraulaPart[i] = paraula.charAt(i);
        }
        return paraulaPart;
    }
    public void mostrarParaula() {
        System.out.println("");

        for (int i = 0; i < paraula.length(); i++) {
            for (int j = 0; j < knowChar.length; j++) {
                if (knowChar[j] == partirParaula(paraula)[i] || Character.toUpperCase(knowChar[j]) == partirParaula(paraula)[i]) {
                    System.out.print(partirParaula(paraula)[i] + " ");
                    i++;
                }
            }
            System.out.print("_ ");
        }
        System.out.println("");
    }
    public void introuirParaula() {
        System.out.println("Introdueix la paraula");
        int i = 0;

    }
    public void lletraPista(){
        for(int i = 0; i < knowChar.length; i++){
            if(knowChar[i] != 0){
                knowChar[i] = 'e';
            }
        }
    }
}
