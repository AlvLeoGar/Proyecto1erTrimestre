public class Tablero {
    private String tipusVaixell = "A";
    private String[][] tableroAliado = new String[12][12];
    private String[][] tableroEnemigo = new String[12][12];
    private String[][] tableroOculto = new String[12][12];
    private int respuestaUsuario;
    private int filera;
    private int columna;
    private boolean ocupado = true;
    private boolean isOcupado = true;
    private boolean generarTabler = false;

    public void mostrarTabler() {
        if (!generarTabler) {
            crearTabler();
            generarTabler = true;
        }
        for (int i = 0; i < 12; i++) {
            System.out.println("");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroAliado[i][j]);
            }
            System.out.print("   ");
            for (int j = 0; j < 12; j++) {
                System.out.print(tableroEnemigo[i][j]);
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
        System.out.println("Es va a introduir el vaixells tipus " + tipusVaixell);
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt() - 1;
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt() - 1;
                if (!tableroAliado[filera][columna].equals(" ")) {
                    System.out.println("Esta posició està ocupada");
                    if (i != 0) {
                        i--;
                    }
                    ocupado = false;
                } else {
                    tableroAliado[filera][columna] = tipusVaixell;
                    ocupado = false;

                }
            } while (ocupado);
        }
        tipusVaixell = "E";
        ocupado = true;
        for (int i = 0; i < 3; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt() - 1;
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt() - 1;
                System.out.println("Amb quina orientació el vols posar?:");
                System.out.println("[1] Cap amunt");
                System.out.println("[2] Cap abaix");
                System.out.println("[3] Cap l'esquerra");
                System.out.println("[4] Cap la dreta");
                isOcupado = true;
                respuestaUsuario = Game.teclado.nextInt();
                switch (respuestaUsuario) {
                    case 1:
                        for (int j = 0; j < 2; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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
                        break;
                    case 2:
                        for (int j = 0; j < 2; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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
                        break;
                    case 3:
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

            } while (ocupado);
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                System.out.println("Vaixell: " + tipusVaixell + " " + (i + 1));
                System.out.println("En quina columna el vols posar");
                columna = Game.teclado.nextInt() - 1;
                System.out.println("En quina filera el vols posar");
                filera = Game.teclado.nextInt() - 1;
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
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera - j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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
                        break;
                    case 2:
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera + j][columna].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna - j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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
                        for (int j = 0; j < 3; j++) {
                            if (!tableroAliado[filera][columna + j].equals(" ") && isOcupado) {
                                System.out.println("Esta posició està ocupada");
                                if (i != 0) {
                                    i--;
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

            } while (ocupado);
        }
        tipusVaixell = "O";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt() - 1;
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt() - 1;
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
                    break;
                case 2:
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
                    break;
                case 3:
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
                    break;
                case 4:
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
                    break;
                default:
                    System.out.println("Posició no valida");
            }
        } while (ocupado);
        tipusVaixell = "U";
        do {
            System.out.println("Vaixell: " + tipusVaixell);
            System.out.println("En quina columna el vols posar");
            columna = Game.teclado.nextInt() - 1;
            System.out.println("En quina filera el vols posar");
            filera = Game.teclado.nextInt() - 1;
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
                    break;
                case 2:
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
                    break;
                case 3:
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
                    break;
                case 4:
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
                    break;
                default:
                    System.out.println("Posició no valida");
            }
        } while (ocupado);
    }

    public void introduirVaixellEnemic() {
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
                if (filera - 1 < 0 || columna - 1 < 0 || filera + 1 > 12 || columna + 1 > 12) {
                    if (i != 0) {
                        i--;
                        ocupado = false;
                    }
                } else {
                    switch (respuestaUsuario) {
                        case 1:
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 2:
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 3:
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 4:
                            for (int j = 0; j < 2; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        default:
                            respuestaUsuario = (int) (Math.random() * 5);
                    }
                }
            } while (ocupado) ;
        }
        tipusVaixell = "I";
        for (int i = 0; i < 2; i++) {
            do {
                columna = (int) (Math.random() * 12);
                filera = (int) (Math.random() * 12);
                isOcupado = true;
                ocupado = true;
                respuestaUsuario = (int) (Math.random() * 5);
                if (filera - 1 < 0 || columna - 1 < 0 || filera + 1 > 12 || columna + 1 > 12) {
                    if (i != 0) {
                        i--;
                        ocupado = false;
                    }
                } else {
                    switch (respuestaUsuario) {
                        case 1:
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera - j][columna].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 2:
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera + j][columna].equals(" ") && isOcupado) {

                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 3:
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna - j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        case 4:
                            for (int j = 0; j < 3; j++) {
                                if (!tableroEnemigo[filera][columna + j].equals(" ") && isOcupado) {
                                    if (i != 0) {
                                        i--;
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
                            break;
                        default:
                            respuestaUsuario = (int) (Math.random() * 5);
                    }
                }
            } while (ocupado);
        }
    }
}
