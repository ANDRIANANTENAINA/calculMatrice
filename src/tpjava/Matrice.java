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
public class Matrice {

    private int col;
    private int line;
    private long m[][];

    public Matrice() {
        this.col = 0;
        this.line = 0;
        this.m = null;
    }

    public Matrice(int line, int col) {
        m = null;
        this.col = col;
        this.line = line;
        this.m = new long[line][col];
    }

    public Matrice(long m[][]) {
        this.m = m;
        this.line = m.length;
        this.col = m[0].length;
    }

    public long[][] getM() {
        return m;
    }

    public void setM(long[][] m) {
        this.m = m;
    }

    public long[] getCol(int colN) {
        long columnN[] = new long[this.line];
        for (int i = 0; i < this.line; i++) {
            columnN[i] = m[i][colN];
        }
        return columnN;
    }

    public void set(int line, int col, int valeur) {
        m[line][col] = valeur;
    }

    public long[] getLine(int lineN) {
        long ligneN[] = new long[this.col];
        for (int i = 0; i < this.col; i++) {
            ligneN[i] = m[lineN][i];
        }
        return ligneN;
    }

    public int getCol() {
        return col;
    }

    public int getLine() {
        return line;
    }

    public long get(int l, int c) {
        return m[l][c];
    }

    @Override
    public String toString() {
        return "Matrice{" + "col=" + col + ", line=" + line + ", m=" + m + '}';
    }
}
