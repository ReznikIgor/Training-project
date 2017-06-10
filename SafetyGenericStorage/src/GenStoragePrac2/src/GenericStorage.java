package GenStoragePrac2.src;

import java.util.Arrays;



public class GenericStorage<T>{
	
	private Object[] massiv;
	int counter = 0;
	
	public GenericStorage(){
		massiv = new Object[10];
	}
	public GenericStorage(int size){
		massiv = new Object[size];
	}
	public void add(T obj){
		synchronized (massiv) {
			massiv[counter] = obj;
			counter++;
		}
		
	}
	public T get(int index){
		if(index >= 0 && index < counter){
			System.out.println(massiv[index]);
			return (T) massiv[index];
		}
		else{
			System.out.println("Недоступный элемент");
			return null;
		}
	}
	public T[] getAll(){
		System.out.println(Arrays.toString(massiv));
		return (T[])massiv;
	}
	public void update(int index, T obj){
		synchronized (massiv) {
			if(index >= 0 && index < counter){
			massiv[index] = obj;
			}
			else{
			System.out.println("Такого элемента нет в массиве");
			}
		}
	}
	public void delete(int index){
		synchronized (massiv) {
			if(index >= 0 && index < counter){
				Object[] massiv2 = new Object[massiv.length-1];
				for (int i = 0, j = 0; i < massiv.length; i++) {
					if(i != index){
						massiv2[j] = massiv[i];
						j++;
					}
				
				}
				massiv = massiv2;
				counter--;
			}
			else{
				System.out.println("Нельзя удалить элемент");
			}
		}
	}
	public void deleteObj(T obj){		
		synchronized (massiv) {
			for (int i = 0; i < massiv.length; i++) {
				if(obj.equals(massiv[i])){
					delete(i);
				}
			}
		}
	}
			
	public int FullMassivLenght(){
		int i = 0;
		int massLenght = 0;
		while(i < massiv.length){
			if(massiv[i] != null){
				massLenght++;
			}
			i++;
		}
		System.out.println(massLenght);
		return massLenght;
	}

}
