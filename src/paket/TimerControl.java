package paket;

import java.util.Timer;
import java.util.TimerTask;
 
public class TimerControl {
 
    public int zaman=0;
    public int kontrol=-1;
    public  void calistir(Gorevlendirici gorevlendirici) {
 
             Timer myTimer=new Timer();
             TimerTask gorev =new TimerTask() {
 
					@Override
					public void run() {
						
						if(gorevlendirici.isEmpty()==false)
						{if(kontrol==1) gorevlendirici.askiyaAl(zaman, kontrol);
						if(kontrol==2) gorevlendirici.askiyaAl(zaman, kontrol);
						if(kontrol==3) gorevlendirici.askiyaAl(zaman, kontrol);}
						gorevlendirici.OkuVeAta(zaman);
						
						if (gorevlendirici.FCFS.isEmpty() == false) {
							gorevlendirici.calistirFCFS(zaman);
							kontrol = 0;
						}
						if(gorevlendirici.FCFS.isEmpty()==true&&gorevlendirici.priority1.isEmpty()==false) {
								gorevlendirici.calistirPriority1(zaman);
								kontrol = 1;
							} 
						if(gorevlendirici.FCFS.isEmpty()==true&&gorevlendirici.priority1.isEmpty()==true&&gorevlendirici.priority2.isEmpty()==false) {
							
									gorevlendirici.calistirPriority2(zaman);
									kontrol = 2;
								}
						if(gorevlendirici.FCFS.isEmpty()==true&&gorevlendirici.priority1.isEmpty()==true&&gorevlendirici.priority2.isEmpty()==true&&gorevlendirici.priority3.isEmpty()==false) {
									
										gorevlendirici.calistirPriority3(zaman);
										kontrol = 3;
								}
						for (Process process : gorevlendirici.askidakiprosesler) {
							if(process.getBeklemeSuresi()==21)
							{
								gorevlendirici.zamanAsiminaUgrat(zaman, process);
							}
							process.setBeklemeSuresi(process.getBeklemeSuresi()+1);
						}
						if(gorevlendirici.isEmpty()==true) myTimer.cancel();				
						zaman++;
					
					}
             };
             
             myTimer.schedule(gorev,0,1000);
       }
}
