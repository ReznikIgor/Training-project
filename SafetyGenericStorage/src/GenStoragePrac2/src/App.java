package GenStoragePrac2.src;


public class App {

	public static void main(String[] args) {
		
		GenericStorage<Integer> gs = new GenericStorage<>();
				
		gs.add(3);
		gs.add(5);
		gs.add(7);
		gs.add(9);
		gs.add(11);
		gs.add(13);
		
		gs.get(3);
		gs.getAll();
		gs.update(1, 6);
		gs.getAll();
		gs.delete(1);
		gs.getAll();
		gs.deleteObj(9);
		gs.getAll();
		gs.FullMassivLenght();

	}

}
