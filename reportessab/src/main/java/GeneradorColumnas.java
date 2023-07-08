

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Leo Montes
 */
public class GeneradorColumnas {

    public static void main(String[] args) {
        int colNum = 180;
        for (int k = 1; k < colNum; k++) {
            byte columna1 = (byte) (65 + k);
            char letraColumna1 = (char) columna1;
            if (columna1 == 91) {
                int colum2 = colNum - k;
                byte columna2;
                byte columna3;
                byte columna4;
                byte columna5;
                byte columna6;
                char letraColumna2;
                char letraColumna3;
                char letraColumna4;
                char letraColumna5;
                char letraColumna6;
                for (int i = 1; i < colum2; i++) {
                    columna1 = 65;
                    letraColumna1 = (char) columna1;
                    columna2 = (byte) (64 + i);
                    letraColumna2 = (char) columna2;
                    System.out.print("'" + letraColumna1 + letraColumna2 + "',");
                    if (columna2 == 90) {
                        int colum3 = colum2 - i;
                        for (int j = 1; j < colum3 + 1; j++) {
                            columna2 = 66;
                            letraColumna2 = (char) columna2;
                            columna3 = (byte) (64 + j);
                            letraColumna3 = (char) columna3;
                            System.out.print("'" + letraColumna2 + letraColumna3 + "',");
                            if (columna3 == 90) {
                                int colum4 = colum3 - j;
                                for (int l = 1; l < colum4 + 1; l++) {
                                    columna3 = 67;
                                    letraColumna3 = (char) columna3;
                                    columna4 = (byte) (64 + l);
                                    letraColumna4 = (char) columna4;
                                    System.out.print("'" + letraColumna3 + letraColumna4 + "',");
                                    if (columna4 == 90) {
                                        int colum5 = colum4 - l;
                                        for (int m = 1; m < colum5; m++) {
                                            columna4 = 68;
                                            letraColumna4 = (char) columna4;
                                            columna5 = (byte) (64 + m);
                                            letraColumna5 = (char) columna5;
                                            System.out.print("'" + letraColumna4 + letraColumna5 + "',");
                                            if (columna5 == 90) {
                                                int colum6 = colum5 - m;
                                                for (int n = 1; n < colum6; n++) {
                                                    columna5 = 69;
                                                    letraColumna5 = (char) columna5;
                                                    columna6 = (byte) (64 + n);
                                                    letraColumna6 = (char) columna6;
                                                    System.out.print("'" + letraColumna5 + letraColumna6 + "',");
                                                    if (columna6 == 90) {
                                                        break;
    }
                                                }

                                                break;
                                            }
                                        }
                                        break;
                                    }

                                }
                                break;
                            }
                        }
                        break;
                    }
                }

                break;
            }
            System.out.print("'" + letraColumna1 + "',");
        }
    }
}
