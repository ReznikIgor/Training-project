
public class Deadlock extends Thread{
	private static final Object LOCK6 = new Object();
	private static final Object LOCK7 = new Object();

	public void run() {
		
		synchronized (LOCK6) {
			System.out.println("захватили первым потоком обьект ЛОК6");
			Thread.yield();
			
			synchronized (LOCK7) {
				System.out.println("захватили первым потоком обьект ЛОК7");
			}
		}
	
		synchronized (LOCK7) {
			System.out.println("захватили вторым потоком обьект ЛОК7");
			Thread.yield();
			synchronized (LOCK6) {
				System.out.println("захватили вторым потоком обьект ЛОК6");
			}
		}
	}

	
}



