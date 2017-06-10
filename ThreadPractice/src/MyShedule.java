import java.util.HashMap;
import java.util.Map;


public class MyShedule extends Thread{
		
	private Map<Integer,String> map;
	
	public void setMap(Map<Integer,String> map){
		this.map = map;
				
	}
	
	@Override
	public void run(){
		for(Map.Entry<Integer, String> entry : map.entrySet()){

			try {
				Thread.sleep(entry.getKey());
				System.out.println(entry.getValue());
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
	
		
		
	}
	
	

}
