package paket;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
public class Uygulama {

    public static void main(String[] args) throws IOException
    {
        String[] renkler=new String[8];
        String BLACK = "\033[0;30m";   // BLACK
        String RED = "\033[0;31m";     // RED
        String YELLOW = "\033[0;33m";  // YELLOW
        String BLUE = "\033[0;34m";    // BLUE
        String PURPLE = "\033[0;35m";  // PURPLE
        String CYAN = "\033[0;36m";    // CYAN
        String WHITE = "\033[0;37m";   // WHITE
        String GREEN = "\033[0;32m";
        renkler[0]=BLACK;
        renkler[1]=RED;
        renkler[2]=YELLOW;
        renkler[3]=BLUE;
        renkler[4]=PURPLE;
        renkler[5]=CYAN;
        renkler[6]=WHITE;
        renkler[7]=GREEN;



        File file = new File(args[0]);
        FileReader fileReader = new FileReader(file);
        String line;
        BufferedReader br = new BufferedReader(fileReader);
        ArrayList<Process> prosesler = new ArrayList<Process>();
        int yedek=0;
        int oncelik=0;
        int calismaZamani=0;
        int gelisZamani=0;
        int ID=0;
        int j=0;
        while ((line = br.readLine()) != null) {
            for(int i=0;i<line.length();i++)
            {
                if(line.charAt(i)==',')
                {
                    String tmpString=line.substring(yedek,i);
                    if(yedek==0)
                    {
                        gelisZamani=Integer.parseInt(tmpString);
                    }
                    else {
                        oncelik=Integer.parseInt(tmpString);
                    }
                    yedek=i+2;
                }
            }
            String tmp=line.substring(yedek,line.length());
            calismaZamani=Integer.parseInt(tmp);
            yedek=0;
            Process p1=new Process(oncelik, gelisZamani, calismaZamani,ID);
            p1.renk=renkler[j];
            j++;
            if(j==7) j=0;
            prosesler.add(p1);
            ID++;
        }
        Gorevlendirici gorevlendirici=new Gorevlendirici(prosesler);
        TimerControl t1=new TimerControl();
        t1.calistir(gorevlendirici);

        br.close();

    }

}

