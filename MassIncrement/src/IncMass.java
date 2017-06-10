
public class IncMass {
	
	public static int[] incrementArray(int[] input) throws CellExc{
				
		checkForNullAndEmpty(input);
		checkForFirstCell(input);
		checkFor0To9(input);
	
			int indexOfNine = 0;
			int numbOfElements = input.length;
			boolean testForNine = false;
			
			
			for (int i : input) {
				if(i == 9){
					indexOfNine ++;
				}
			}
			if (indexOfNine == numbOfElements){
				testForNine = true;
				
			}
			else{testForNine = false;
			}

			
			int[] copyArr = new int[numbOfElements];
			
			if (testForNine == true) {
				copyArr = new int [input.length+1];
				System.arraycopy(input, 0, copyArr, 1, input.length);
				
			}
			
			else if (testForNine == false) {
				copyArr = new int [numbOfElements];
				System.arraycopy(input, 0, copyArr, 0, input.length);
				
			}
			
			for (int i = copyArr.length-1; i >= 0; i--){
				if (copyArr[i] == 9){
					copyArr[i] = 0;
				}
				else{
					copyArr[i]++;
					break;
				}
			}
			
			return copyArr;
	}

		
		public static void checkForNullAndEmpty(int[] array)throws CellExc{
			if(array == null){
				throw new CellExc("ћассив нулей");
			}
		
			if(new int[0].length == array.length){
				throw new CellExc("ƒлина массива равна нулю");
			}
		}
		
		public static void checkForFirstCell(int[] array) throws CellExc{
			if (array.length > 1 && array[0] == 0){
				throw new CellExc("ѕерва€ €чейка не может быть равна нулю");
			}
		}
		
		public static void checkFor0To9(int[] array) throws CellExc{
			for(int i : array){
				if(i > 9 | i < 0){
					throw new CellExc("„исло в €чейке должно быть от 0 до 9");
				}
			}
		}
}
		
	
	
	
	

	


