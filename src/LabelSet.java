import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class LabelSet {

    private int u;
    private ArrayList<Integer> epsilon;
    private ArrayList<Integer> smernikyVrcholov;
    private ArrayList<Hrana> zoznamHran;
    private int[] t;
    private int[] x;
    public LabelSet(int zaciatocnyVrchol, Input input){
        this.u = zaciatocnyVrchol;

        this.smernikyVrcholov = input.getSmernikVrcholov();
        this.zoznamHran = input.getZoznamHran();

        this.t = new int[input.getPocetVrchol() + 1];
        this.x = new int[input.getPocetVrchol() + 1];
        for(int i = 1; i <= input.getPocetVrchol(); i++){
            this.t[i] = Integer.MAX_VALUE / 2;
            this.x[i] = 0;
        }

        this.t[zaciatocnyVrchol] = 0;

        this.epsilon = new ArrayList<>();
        this.epsilon.add(zaciatocnyVrchol);
    }

    public void najdiNajkratsieCesty(){
        while(!this.epsilon.isEmpty()) {
            int r = this.vyberVrchol();
            for (int i = this.smernikyVrcholov.get(r); i < this.smernikyVrcholov.get(r + 1); i++) {
                int j = this.zoznamHran.get(i).getVrcholDo();
                int cenaH = this.zoznamHran.get(i).getCena();
                if (this.t[j] > this.t[r] + cenaH) {
                    this.t[j] = this.t[r] + cenaH;
                    this.x[j] = r;
                    if (this.nenachadzaVZoznameEpsilon(j)) {
                        this.epsilon.add(j);
                    }
                }
            }
        }
    }

    public void vypisNajkratsiuCestu(int doVrcholaV){
        int j = doVrcholaV;
        var zoznam = new ArrayList<Integer>();
        var sb = new StringBuilder();
        int v = j;

        zoznam.add(j);
        while (this.x[v] != 0) {
            zoznam.add(x[v]);
            v = this.x[v];
        }

        for (int i = zoznam.size() - 1; i > -1; i--) {
            sb.append(zoznam.get(i));
            sb.append(" ");
        }

        if (x[v] == 0) {
            System.out.println("Cesta z vrcholu " + this.u + " do vrchola " + j);
            System.out.println("Dlzka cesty je " + this.t[j]);
            System.out.println("Cesta je " + sb.toString());
            System.out.println();
        }

    }

    private int vyberVrchol(){
        Integer v = this.epsilon.get(0);
        for (int i = 1; i < this.epsilon.size(); i++){
            if(this.t[v] > this.t[this.epsilon.get(i)]){
                v = this.epsilon.get(i);
            }
        }
        this.epsilon.remove(v);
        return v;
    }

    private boolean nenachadzaVZoznameEpsilon(int cislo){
        for (int aktualny: this.epsilon) {
            if(aktualny == cislo) {
                return false;
            }
        }
        return true;
    }



}
