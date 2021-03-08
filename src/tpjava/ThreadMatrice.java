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
public class ThreadMatrice extends Thread {

    private long res[];
    private long lineResult[];
    private final long m[][];

    public ThreadMatrice(long[] lineResult, long[][] m) {
        this.lineResult = lineResult;
        this.m = m;
    }

    
  
//    n * m
//  maka resutlta produit scalaire

    public long doGetRes(long lineN[], long colM[]) {
        long lineRes = 0;
        for (int i = 0; i < lineN.length; i++) {
            lineRes += lineN[i] * colM[i];
        }
        return lineRes;
    }

    @Override
    public void run() {
//      thread each line
        this.res = getResLine(lineResult, m);
    }

    public long[] getResLine(long line[], long matrice[][]) {
        long b = 0;
        long columnN[] = new long[matrice[0].length];
        
        for (int i = 0; i < matrice[0].length; i++) {
            b = doGetRes(line, getCol(i));
            columnN[i] = b;
        }

        return columnN;
    }
    
    public long[] getCol(int colN) {
        long columnN[] = new long[m.length];
        
        for (int i = 0; i < m.length; i++) {
            columnN[i] = m[i][colN];
        }
        return columnN;
    }

    public long[] getLineResult() {
        return res;
    }
    
    
}
