
public class Deadlock extends Thread{
	private static final Object LOCK6 = new Object();
	private static final Object LOCK7 = new Object();

	public void run() {
		
		synchronized (LOCK6) {
			System.out.println("��������� ������ ������� ������ ���6");
			Thread.yield();
			
			synchronized (LOCK7) {
				System.out.println("��������� ������ ������� ������ ���7");
			}
		}
	
		synchronized (LOCK7) {
			System.out.println("��������� ������ ������� ������ ���7");
			Thread.yield();
			synchronized (LOCK6) {
				System.out.println("��������� ������ ������� ������ ���6");
			}
		}
	}

	
}



