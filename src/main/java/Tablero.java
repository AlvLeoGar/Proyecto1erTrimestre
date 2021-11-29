public class Tablero {
    public Tablero(String name){this.name = name;}
    private String tipusVaixell;
    private String[][] tableroAliado = new String[12][12];
    private String[][] tableroEnemigo = new String[12][12];
    private String[][] tableroOculto = new String[12][12];
    private String name;
    private int respuestaUsuario;
    private int filera;
    private int columna;
    private int punts = 0;
    private int contadorAliado= 0, contadorEnemigo = 0, contadorFallo = 0;
    private boolean ocupado = true;
    private boolean isOcupado = true;
    private boolean generarTabler = false;
    private boolean control;

    public void mostrarTabler() {
        if (!generarTabler) {
            crearTabler();
            generarTabler = true;
        }
        System.out.println(name + "           PC");
        for (int i = 0; i < 12; i++) {
            System.out.println("");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroAliado[i][j]);
            }
            System.out.print("   ");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroOculto[i][j]);
            }
        }
        System.out.println("");
    }

    public void crearTabler() {
        for (int i = 0; i < 12; i++) {
            tableroAliado[i][0] = "|";
            tableroAliado[i][11] = "|";
            tableroEnemigo[i][0] = "|";
            tableroEnemigo[i][11] = "|";
            tableroOculto[i][0] = "|";
            tableroOculto[i][11] = "|";
        }
        for (int i = 0; i < 12; i++) {
            tableroAliado[0][i] = "-";
            tableroAliado[11][i] = "-";
            tableroEnemigo[0][i] = "-";
            tableroEnemigo[11][i] = "-";
            tableroOculto[0][i] = "-";
            tableroOculto[11][i] = "-";
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                tableroAliado[i][j] = " ";
                tableroEnemigo[i][j] = " ";
                tableroOculto[i][j] = " ";
            }
        }
    }

    public void introduirVaixell() {
        tipusVaixell = "A";
        System.out.println("Es va a introduir el vaixells tipus " + tipusVaixell);
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt();
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt();
                if(filera < 0 || filera >= 12 || columna < 0 || columna >=12){
                    System.out.println("Posición no valida");
                    if(i != 0){
                        i--;
                        ocupado = false;
                    }
                } else {
                    if (!tableroAliado[filera][columna].equals(" ")) {
                        System.out.println("Esta posició està ocupada");
                        if (i != 0) {
                            i--;
                            ocupado = false;
                        }

                    } else {
                        tableroAliado[filera][columna] = tipusVaixell;
                        ocupado = false;
                    }
                }
                mostrarTabler();
            } while (ocupado);
        }
        tipusVaixell = "E";
        ocupado = true;
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt();
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt();
                System.out.println("Amb quina orientació el vols posar?:");
                System.out.println("[1] Cap amunt");
                System.out.println("[2] Cap abaix");
                System.out.println("[3] Cap l'esquerra");
                System.out.println("[4] Cap la dreta");
                isOcupado = true;
                respuestaUsuario = Game.teclado.nextInt();
                switch (respuestaUsuario) {
                    case 1:
                        if(filera - 1 < 0){
                            System.out.println("Posició no valida");
                            if(i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera - j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(filera + 1 >= 12){
                            System.out.println("Posició no valida");
                            if(i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera + j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if(columna - 1 < 0){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroAliado[filera][columna - j] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        for (int j = 0; j < 2; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 2; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Posició no valida");
                }
                mostrarTabler();
            } while (ocupado);
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt();
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt();
                System.out.println("Amb quina orientació el vols posar?:");
                System.out.println("[1] Cap amunt");
                System.out.println("[2] Cap abaix");
                System.out.println("[3] Cap l'esquerra");
                System.out.println("[4] Cap la dreta");
                isOcupado = true;
                ocupado = true;
                respuestaUsuario = Game.teclado.nextInt();
                switch (respuestaUsuario) {
                    case 1:
                        if(filera - 2 < 0){
                            System.out.println("Posició no valida");
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                    System.out.println("Esta posició està ocupada");
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroAliado[filera - j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if(filera + 2 >=12){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                ocupado = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    ocupado = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                        break;
                    case 3:
                        if(columna - 2 < 0) {
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                ocupado = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    ocupado = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                        break;
                    case 4:
                        if(columna + 2 >=12){
                            System.out.println("Posició no valida");
                            if(i != 0){
                                i--;
                                ocupado = false;
                            }
                        }
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado || columna + 2 >=12) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
                                    ocupado = false;
                                }
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 3; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                        break;
                    default:
                        System.out.println("Posició no valida");
                }
                mostrarTabler();
            } while (ocupado);
        }
        tipusVaixell = "O";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt();
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt();
            System.out.println("Amb quina orientació el vols posar?:");
            System.out.println("[1] Cap amunt");
            System.out.println("[2] Cap abaix");
            System.out.println("[3] Cap l'esquerra");
            System.out.println("[4] Cap la dreta");
            isOcupado = true;
            ocupado = true;
            respuestaUsuario = Game.teclado.nextInt();
            switch (respuestaUsuario) {
                case 1:
                    if(filera - 3 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera - j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 3 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 3 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 3 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Posició no valida");
            }
            mostrarTabler();
        } while (ocupado);
        tipusVaixell = "U";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt();
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt();
            System.out.println("Amb quina orientació el vols posar?:");
            System.out.println("[1] Cap amunt");
            System.out.println("[2] Cap abaix");
            System.out.println("[3] Cap l'esquerra");
            System.out.println("[4] Cap la dreta");
            isOcupado = true;
            ocupado = true;
            respuestaUsuario = Game.teclado.nextInt();
            switch (respuestaUsuario) {
                case 1:
                    if(filera - 4 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera - j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 4 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera + j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 4 < 0){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera][columna - j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 4 >= 12){
                        System.out.println("Posició no valida");
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroAliado[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Posició no valida");
            }
            mostrarTabler();
        } while (ocupado);
    }

    public void introduirVaixellEnemic() {
        tipusVaixell = "A";
        for (int i = 0; i < 3; i++) {
            ocupado = true;
            do {
                filera = (int) (Math.random() * 12);
                columna = (int) (Math.random() * 12);

                if (!tableroEnemigo[filera][columna].equals(" ")) {
                    System.out.println("");
                    if (i != 0) {
                        i--;
                        ocupado = false;
                    }

                } else {
                    tableroEnemigo[filera][columna] = tipusVaixell;
                    ocupado = false;

                }
            } while (ocupado);
        }

        tipusVaixell = "E";
        for (int i = 0; i < 3; i++) {
            do {
                columna = (int) (Math.random() * 12);
                filera = (int) (Math.random() * 12);
                isOcupado = true;
                ocupado = true;
                respuestaUsuario = (int) (Math.random() * 5);
                switch (respuestaUsuario) {
                    case 1:
                        if (filera - 1 < 0) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera - j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (filera + 1 >= 12) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera + j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (columna - 1 < 0) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera][columna - j] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (columna + 1 >= 12) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }
                        } else {
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;
                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 2; j++) {
                                    tableroEnemigo[filera][columna + j] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    default:
                        respuestaUsuario = (int) (Math.random() * 5);
                }
            } while (ocupado);
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                columna = (int) (Math.random() * 12);
                filera = (int) (Math.random() * 12);
                isOcupado = true;
                ocupado = true;
                respuestaUsuario = (int) (Math.random() * 5);
                switch (respuestaUsuario) {
                    case 1:
                        if (filera - 2 < 0) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera - j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 2:
                        if (filera + 2 >= 12) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {

                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera + j][columna] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 3:
                        if (columna - 2 < 0) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera][columna - j] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (columna + 2 >= 12) {
                            if (i != 0) {
                                i--;
                                ocupado = false;
                            }

                        } else {
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
                                        ocupado = false;
                                    }
                                    isOcupado = false;

                                }
                            }
                            if (isOcupado) {
                                for (int j = 0; j < 3; j++) {
                                    tableroEnemigo[filera][columna + j] = tipusVaixell;
                                    ocupado = false;
                                }
                            }
                        }
                        break;
                    default:
                        respuestaUsuario = (int) (Math.random() * 5);
                }
            } while (ocupado);
        }
        tipusVaixell = "O";
        do {
            columna = (int) (Math.random() * 12);
            filera = (int) (Math.random() * 12);
            isOcupado = true;
            ocupado = true;
            respuestaUsuario = (int) (Math.random() * 5);
            switch (respuestaUsuario) {
                case 1:
                    if (filera - 3 < 0){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera - j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 3 >= 12){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera + j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 3 < 0){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera][columna - j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 3 >= 12){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 4; j++) {
                            if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 4; j++) {
                                tableroEnemigo[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                default:
                    respuestaUsuario = (int) (Math.random() * 5);
            }
        } while (ocupado);
        tipusVaixell = "U";
        do {
            columna = (int) (Math.random() * 12);
            filera = (int) (Math.random() * 12);
            isOcupado = true;
            ocupado = true;
            respuestaUsuario = (int) (Math.random() * 5);
            switch (respuestaUsuario) {
                case 1:
                    if (filera - 4 < 0){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;
                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera - j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 2:
                    if(filera + 4 >= 12){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera + j][columna] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 3:
                    if(columna - 4 < 0){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera][columna - j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                case 4:
                    if(columna + 4 >= 12){
                        ocupado = true;
                    } else {
                        for (int j = 0; j < 5; j++) {
                            if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                isOcupado = false;

                            }
                        }
                        if (isOcupado) {
                            for (int j = 0; j < 5; j++) {
                                tableroEnemigo[filera][columna + j] = tipusVaixell;
                                ocupado = false;
                            }
                        }
                    }
                    break;
                default:
                    respuestaUsuario = (int) (Math.random() * 5);
            }
        } while (ocupado);
    }

    public void disparar(){
        ocupado = true;
        do {
            System.out.println("Dime en quina columna vols disparar");
            columna = Game.teclado.nextInt();
            System.out.println("Dime en quina fila vols disparar");
            filera = Game.teclado.nextInt();
            if(columna < 0 || columna >= 12 || filera < 0 || filera >=12){
                ocupado = true;
                System.out.println("Posició no valida");
            }
            else{
                ocupado = false;
            }
        }while(ocupado);
        if(!tableroEnemigo[filera][columna].equals(" ") && !tableroOculto[filera][columna].equals("!")){
            tableroOculto[filera][columna] = "!";
            System.out.println("HAS GOLPEJAT AL OBJECTIU!!!!! (+1 punt)");
            punts++;
        }
        else{
            tableroOculto[filera][columna] = "?";
            System.out.println("No has acertat...");
        }
        do {
            columna = (int) (Math.random() * 10)+ 1;
            filera = (int) (Math.random() * 10)+ 1;
            if (tableroAliado[filera][columna].equals("X") || tableroAliado[filera][columna].equals("?")) {
                control = true;
            } else if(!tableroAliado[filera][columna].equals(" ")){
                control = false;
                tableroAliado[filera][columna] = "X";
                System.out.println("Te han golpejat...");
            } else{
                control = false;
                System.out.println("No te han golpejat!");
            }
        }while(control);
    }

    public boolean comprobarFin(){
        for(int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (tableroAliado[i][j].equals("X")) {
                    contadorEnemigo++;
                }
                if (tableroOculto[i][j].equals("!")) {
                    contadorAliado++;
                }
            }
        }
        if(contadorAliado == 24 || contadorEnemigo == 24){
            return true;
        }
        else{
            contadorEnemigo = 0; contadorAliado = 0;
            return false;
        }
    }
    public int finalitzar(){
        contadorEnemigo = 0; contadorAliado = 0;
        for(int i = 1; i < 11; i++){
            for (int j = 1; j < 11; j++){
                if(tableroAliado[i][j].equals("X")) {
                    contadorEnemigo++;
                }
                if(tableroOculto[i][j].equals("!")){
                    contadorAliado++;
                }
                if(tableroOculto[i][j].equals("?")){
                    contadorFallo++;
                }
            }
        }
        punts += (24-contadorEnemigo);
        punts -= contadorFallo;
        return punts;
    }
}