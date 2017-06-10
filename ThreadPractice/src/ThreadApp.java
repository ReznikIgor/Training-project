import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ThreadApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		
//		Thread firstThread = new ExThread();
//		firstThread.start();
//		firstThread.setName("threadExThread");
//		
//		Thread secondThread = new Thread(new ImpRunn());
//		secondThread.start();
//		secondThread.setName("threadImpRunn");
//		
		MyShedule myShed = new MyShedule();	
		Map<Integer,String> map = new HashMap<Integer,String>();
		map.put(1000, "1000 msek");
		map.put(1500, "1500 msek");
		map.put(2000, "2000 msek");
		map.put(2500, "2500 msek");
		map.put(3000, "3000 msek");
		myShed.setMap(map);
//		myShed.start();
		
		Thread thr1 = new Thread(new SummingThread());
		Thread thr2 = new Thread(new SummingThread());
		
		thr1.setName("21");
		thr2.setName("31");
		
//		thr1.start();
//		thr2.start();
		
		Thread tr1 = new Deadlock();
		Thread tr2 = new Deadlock();
//		tr1.start();
	//	tr2.start();
		
		
		int countOfThreads = 3;
		
		for (int j = 1; j <= countOfThreads ; j++) {
			new copyAllFromIO().start();
		}
	}

}
