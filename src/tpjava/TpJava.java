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
public class TpJava {

    /**
     * @param args the command line arguments
     */
    public long[][] generateMatrice(int taileLine, int taileCol){
        long[][] matrice = new long[taileLine][taileCol];
        for (int i = 0; i < taileLine; i++) {
            
        }
        for (int i = 0; i < taileCol; i++) {
            
        }
        return matrice;
    }
    
    public static void main(String[] args) {
        long[][] a = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        long[][] b = {{1, 2}, {1, 2}, {1, 2}};
        long[][] c = {{1, 2}, {3, 4}};
        long[][] d = {{5, 6}, {7, 8}};
        long[][] e = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        long[][] p;
        Matrice aa;

        SimpleMatrice prod = new SimpleMatrice();

//      Temps d'execution sans affichage
        long begin = System.currentTimeMillis();
        p = prod.prouduitMatrice(d, c);
        System.out.println("Durrée = " + (System.currentTimeMillis() - begin) + " ms");
        
        aa = new Matrice(p);
        System.out.println(prod.affiche());
    }

}
