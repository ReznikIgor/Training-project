package arrayManip;

public class ArraySort {

	int[] oddNumb = new int[10];
	int maxNumb = 20;

	public void fillArr() { //заполняет массив четными числами
		int number = 1;
		int i = 0;
		while (number <= maxNumb) {
			if (number % 2 == 0) {
				oddNumb[i] = number;
				i++;
			}
			number++;
		}

	}

	public void sortArr() { // сортирует числа от большего к меньшему
		for (int i = 0; i < oddNumb.length; i++) {
			for (int j = oddNumb.length - 1; j > i; j--) {

				if (oddNumb[j] > oddNumb[j - 1]) {
					int temp;
					temp = oddNumb[j];
					oddNumb[j] = oddNumb[j - 1];
					oddNumb[j - 1] = temp;
				}
			}
		}
	}

	public void printArr() { //выводит массив на экран
		for (int i = 0; i < oddNumb.length; i++) {
			System.out.println(oddNumb[i]);
		}
	}

}
