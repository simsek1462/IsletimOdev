package paket;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Gorevlendirici {
	Queue<Process> FCFS=new LinkedList<Process>();
	Queue<Process> priority1=new LinkedList<Process>();
	Queue<Process> priority2=new LinkedList<Process>();
	Queue<Process> priority3=new LinkedList<Process>();
	ArrayList<Process> prosesler = new ArrayList<Process>();
	ArrayList<Process> askidakiprosesler = new ArrayList<Process>();
	public Gorevlendirici(ArrayList<Process> prosesler) {
		this.prosesler = prosesler;
	}
	boolean isEmpty()
	{
		if(FCFS.isEmpty()&&priority1.isEmpty()&&priority3.isEmpty()&&priority2.isEmpty())
			return true;
		else {
			return false;
		}
	}

	void calistirFCFS(int zaman) {
		Process p1Process;
		p1Process = FCFS.element();
		if (p1Process.getKalanSure() == 0) {
			p1Process.bitir(zaman);
			FCFS.remove();
			if(FCFS.isEmpty()==false) calistirFCFS(zaman);
		} else {
			p1Process.calis(zaman);
			p1Process.setKalanSure(p1Process.getKalanSure() - 1);
		}
	}
	void calistirPriority1(int zaman)
	{
		Process p1Process;
		p1Process=priority1.element();
		if(askidakiprosesler.contains(p1Process))
		{
			askidakiprosesler.remove(p1Process);
		}		
		if(p1Process.getKalanSure()==0)
		{
			p1Process.bitir(zaman);
			priority1.remove();
			if(priority1.isEmpty()==false) calistirPriority1(zaman);
		}
		else {
			p1Process.calis(zaman);
			p1Process.setKalanSure(p1Process.getKalanSure()-1);
		}
	}
	void calistirPriority2(int zaman)
	{
		Process p1Process;
		p1Process=priority2.element();
		if(askidakiprosesler.contains(p1Process))
		{
			askidakiprosesler.remove(p1Process);
		}	
		if(p1Process.getKalanSure()==0)
		{
			p1Process.bitir(zaman);
			priority2.remove();
			if(priority2.isEmpty()==false) calistirPriority2(zaman);
		}
		else {
			p1Process.calis(zaman);
			p1Process.setKalanSure(p1Process.getKalanSure()-1);
		}
	}
	void calistirPriority3(int zaman)
	{
		Process p1Process;
		p1Process=priority3.element();
		if(askidakiprosesler.contains(p1Process))
		{
			askidakiprosesler.remove(p1Process);
		}	
		if(p1Process.getKalanSure()==0)
		{
			p1Process.bitir(zaman);
			priority3.remove();
			if(priority3.isEmpty()==false) calistirPriority3(zaman);
		}
		else {
			p1Process.calis(zaman);
			p1Process.setKalanSure(p1Process.getKalanSure()-1);
		}
	}
	void OkuVeAta(int zaman)
	{
		for (Process process : prosesler) {
			if(zaman==process.getGelisZamani())
			{
				if(process.getOncelik()==0)
				{
					FCFS.add(process);
				}
				else if(process.getOncelik()==1)
				{
					priority1.add(process);
				}
				else if(process.getOncelik()==2)
				{
					priority2.add(process);
				}
				else
				{
					priority3.add(process);
				}
			}
		}
	}
	void zamanAsiminaUgrat(int zaman,Process a)
	{
		Process p1Process;
		p1Process=a;
		int oncelik=p1Process.getOncelik();
		if(oncelik==1)
			priority1.remove(p1Process);
		else if(oncelik==2)
			priority2.remove(p1Process);
		else {
			priority3.remove(p1Process);
		}
		p1Process.asimaUgrat(zaman);
	}

	void askiyaAl(int zaman, int kontrol) {
		if (kontrol == 1) {
			Process p1Process;
			p1Process = priority1.element();
			if (p1Process.getKalanSure() == 0) {
				p1Process.bitir(zaman);
				priority1.remove();
			} else {
				p1Process.setOncelik(p1Process.getOncelik() + 1);
				p1Process.askiyaAl(zaman);
				p1Process.setBeklemeSuresi(p1Process.getBeklemeSuresi() + 1);
				askidakiprosesler.add(p1Process);
				priority1.remove();
				priority2.add(p1Process);
			}

		} else if (kontrol == 2) {
			Process p1Process;
			p1Process = priority2.element();
			if (p1Process.getKalanSure() == 0) {
				p1Process.bitir(zaman);
				priority2.remove();
			} else {
				p1Process.askiyaAl(zaman);
				p1Process.setBeklemeSuresi(p1Process.getBeklemeSuresi() + 1);
				askidakiprosesler.add(p1Process);
				p1Process.setOncelik(p1Process.getOncelik() + 1);
				priority2.remove();
				priority3.add(p1Process);
			}

		} else if (kontrol == 3) {
			Process p1Process;
			p1Process = priority3.element();
			if (p1Process.getKalanSure() == 0) {
				p1Process.bitir(zaman);
				priority3.remove();
			} else {
				p1Process.askiyaAl(zaman);
				p1Process.setBeklemeSuresi(p1Process.getBeklemeSuresi() + 1);
				askidakiprosesler.add(p1Process);
				priority3.remove();
				priority3.add(p1Process);
			}
		}
	}
}
