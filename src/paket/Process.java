package paket;

import java.io.IOException;

public class Process {
    private int oncelik;
    private int gelisZamani;
    private int calismaZamani;
    private int kalanSure;
    private int ID;
    private int beklemeSuresi;
    public String renk;
    public Process(int oncelik,int gelisZamani,int calismaZamani,int ID)
    {
        this.oncelik=oncelik;
        this.gelisZamani=gelisZamani;
        this.calismaZamani=calismaZamani;
        this.ID=ID;
        this.setBeklemeSuresi(0);
        this.setKalanSure(calismaZamani);
    }
    public int getKalanSure() {
        return kalanSure;
    }
    public void setKalanSure(int kalanSure) {
        this.kalanSure = kalanSure;
    }
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    public int getGelisZamani() {
        return gelisZamani;
    }
    public void setGelisZamani(int gelisZamani) {
        this.gelisZamani = gelisZamani;
    }
    public void setCalismaZamani(int calismaZamani) {
        this.calismaZamani = calismaZamani;
    }
    public int getOncelik() {
        return oncelik;
    }
    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }
    public int getCalismaZamani() {
        return calismaZamani;
    }
    public int getBeklemeSuresi() {
        return beklemeSuresi;
    }
    public void setBeklemeSuresi(int beklemeSuresi) {
        this.beklemeSuresi = beklemeSuresi;
    }
    public void yazdir()
    {
        int oncelik=getOncelik();
        int gelisZamani=getGelisZamani();
        int calismaZamani=getCalismaZamani();
        int ID=getID();
        System.out.println(renk+gelisZamani+" "+oncelik+" "+calismaZamani+" "+ID);
    }
    public void calis(int zaman)
    {
        if(kalanSure==calismaZamani)
           println(renk+zaman+".0000 sn  "+"proses baþladý              "+"(ID:"+ID+"  öncelik:"+oncelik+" kalan süre:"+kalanSure+" sn)");
        else {
            println(renk+zaman+".0000 sn  "+"proses yürütülüyor          "+"(ID:"+ID+"  öncelik:"+oncelik+" kalan süre:"+kalanSure+" sn)");
        }
        setBeklemeSuresi(0);
    }
    public void bitir(int zaman)
    {
        println(renk+zaman+".0000 sn  "+"proses sonlandý             "+"(ID:"+ID+"  öncelik:"+oncelik+" kalan süre:"+kalanSure+" sn)");
    }
    public void askiyaAl(int zaman)
    {
       println(renk+zaman+".0000 sn  "+"proses askýda               "+"(ID:"+ID+"  öncelik:"+oncelik+" kalan süre:"+kalanSure+" sn)");
    }
    public void asimaUgrat(int zaman)
    {
        println(renk+zaman+".0000 sn  "+"proses zaman aþýmý          "+"(ID:"+ID+"  öncelik:"+oncelik+" kalan süre:"+kalanSure+" sn)");
    }
    static void println(String s) {
        try {
            new ProcessBuilder("cmd", "/c", "echo " + s).inheritIO().start().waitFor();
        } catch (InterruptedException|IOException e) {
            throw new RuntimeException(e);
        }
    }
}
