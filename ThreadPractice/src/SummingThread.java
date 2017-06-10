
public class SummingThread implements Runnable {

	public static int counter = 0;
	public static final Object LOCK = new Object();

	@Override
	public void run() {

		while (true) {
			synchronized (LOCK) {
				counter += Integer.parseInt(Thread.currentThread().getName());
				System.out.println(counter);
				try {
					LOCK.wait(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}

	}

}
