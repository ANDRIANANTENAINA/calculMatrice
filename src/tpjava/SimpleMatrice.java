/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

/**
 *
 * @author i-Faly
 */
public class SimpleMatrice{

    private long matriceP[][];
    
    public SimpleMatrice() {
    }

    public void setMatriceP(long[][] matriceP) {
        this.matriceP = matriceP;
    }

    /**
     *
     * @param m1
     * @param m2
     * @return
     */
    public long[][] prouduitMatrice(long[][] m1, long[][] m2) {
        long matriceProd[][];

        if (m1[0].length == m2.length) {
            matriceProd = new long[m1.length][m2[0].length];
            for (int i = 0; i < m1.length; i++) {// 0 1 2 3
                for (int j = 0; j < m2[0].length; j++) { // 0 1
                    matriceProd[i][j] = 0;
                    for (int k = 0; k < m1[0].length; k++) { // 0 1 2
                        matriceProd[i][j] += m1[i][k] * m2[k][j];
                    }
                }
            }
            this.matriceP = matriceProd;
            return this.matriceP;
        }

        if (m2[0].length == m1.length) {
            matriceProd = new long[m2.length][m1[0].length];
            for (int i = 0; i < m2.length; i++) {// 0 1 2 3
                for (int j = 0; j < m1[0].length; j++) { // 0 1
                    matriceProd[i][j] = 0;
                    for (int k = 0; k < m2[0].length; k++) { // 0 1 2
                        matriceProd[i][j] += m2[i][k] * m1[k][j];
                    }
                }
            }
            this.matriceP = matriceProd;
            return this.matriceP;
        }
        return this.matriceP;
    }

    public String affiche() {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append("\n");
        for (int i = 0; i < matriceP.length; i++) {
            for (int j = 0; j < matriceP[0].length; j++) {
                builder.append(matriceP[i][j]).append("\t");
            }
            builder.append("\n");
        }
        builder.append("]").append("\n");
        return builder.toString();
    }

    @Override
    public String toString() {
        return "SimpleMatrice{" + "matrice Produit = " + matriceP + '}';
    }

}
