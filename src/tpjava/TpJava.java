/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpjava;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author i-Faly
 */
public class TpJava {

    /**
     * @param taileLine
     * @param taileCol
     * @return
     * @throws java.security.NoSuchAlgorithmException
     */
    public static long[][] generateMatrice(int taileLine, int taileCol) throws NoSuchAlgorithmException {
        Random rand = SecureRandom.getInstanceStrong();
        long[][] matrice = new long[taileLine][taileCol];
        for (int i = 0; i < taileLine; i++) {
            for (int j = 0; j < taileCol; j++) {
                matrice[i][j] = rand.nextInt(100);

            }
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
        Matrice p = new Matrice(m1.getLine(), m2.getCol());
        ThreadMatrice thread[] = new ThreadMatrice[m1.getCol()];
//      lance les threads
        for (int i = 0; i < m1.getCol(); i++) {
            thread[i] = new ThreadMatrice(m1.getLine(i), m2.getM());
            thread[i].start();
        }
//      recuperation 
        for (int i = 0; i < m1.getCol(); i++) {
            try {
                thread[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(TpJava.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.setMatrice(thread[i].getLineResult(), i);

        }

        return p;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {

        Matrice m1, m2, resultat, resultat2;
        m1 = new Matrice(generateMatrice(2000, 2000));
        m2 = new Matrice(generateMatrice(2000, 2000));

//      Temps d'execution sans affichage
        long begin = System.currentTimeMillis();
//        resultat = calculProduitThread(m1, m2);
        resultat = calculProduitSimple(m1, m2);
        long finish = System.currentTimeMillis();
        
        long begin2 = System.currentTimeMillis();
        resultat2 = calculProduitThread(m1, m2); // nombre de colnne threads m2 lancee
//        resultat = calculProduitSimple(m1, m2);
        long finish2 = System.currentTimeMillis();

//        System.out.println(resultat.affiche());
//        System.out.println(resultat2.affiche());
        System.out.println("Durrée simple = " + (finish - begin) + " ms");
        System.out.println("Durrée thread = " + (finish2 - begin2) + " ms");

    }
}
