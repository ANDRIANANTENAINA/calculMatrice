/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i-Faly
 */
public class TpJava {

    /**
     * @param args the command line arguments
     */
    public long[][] generateMatrice(int taileLine, int taileCol) {
        long[][] matrice = new long[taileLine][taileCol];
        for (int i = 0; i < taileLine; i++) {

        }
        for (int i = 0; i < taileCol; i++) {

        }
        return matrice;
    }

    public static Matrice calculProduitSimple(Matrice m1, Matrice m2) {
        Matrice p;
        SimpleMatrice prod = new SimpleMatrice();
        p = new Matrice(prod.prouduitMatrice(m1.getM(), m2.getM()));
        return p;
    }

    public static Matrice calculProduitThread(Matrice m1, Matrice m2) {
        ThreadMatrice thread;
        for (int i = 0; i < m1.getCol(); i++) {
            thread = new ThreadMatrice(m1.getLine(i), m2.getM());
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(Arrays.toString(thread.getLineResult()));
        }
        return null;
    }

    public static void main(String[] args) {
        long[][] a = {{1, 2}, {3, 4}};
        long[][] b = {{5, 6}, {7, 8}};
        long[][] c = {{1, 2, 3}, {4, 5, 6}, {4, 5, 6}};
        long[][] d = {{1, 2}, {3, 4}, {5, 6}};
        long[][] e = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        long[][] p;
        Matrice m1, m2, resultat;
        m1 = new Matrice(a);
        m2 = new Matrice(b);


//      Temps d'execution sans affichage
        long begin = System.currentTimeMillis();
        resultat = calculProduitSimple(m1, m2);
        long finish = System.currentTimeMillis();
        
        System.out.println("Durrée = " + (finish - begin) + " ms");
        System.out.println(resultat.affiche());
    }

}
