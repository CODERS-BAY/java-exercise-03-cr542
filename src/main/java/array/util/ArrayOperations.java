package array.util;

/**
 * Utility class which performs various operations with integer arrays.
 */
public class ArrayOperations {
    private final int[] numbers;      // array that needs to be sorted.
    private final int[] unsorted;     // reference array which stays unsorted.

    public ArrayOperations(int[] numbers) {
        this.numbers = numbers;
        this.unsorted = numbers.clone();
    }

    /* **********************************************************
     *   Please implement the following methods.                 *
     *   It is intended that they are not static.                *
     * ***********************************************************/

    /**
     * Prints out the numbers array.
     */

    public void print() {
    	System.out.print("[");
        for(int i = 0; i < numbers.length; i++) {
        	if(i == (numbers.length -1)) {
        		System.out.print(numbers[i]);
        	} else {
        	System.out.print(numbers[i] + ", ");
        	}
        }
        System.out.print("]");
    }

    /**
     * @return the sorted numbers array.
     * @see <a href="sorting algortihms">http://faculty.cs.niu.edu/~hutchins/csci241/sorting.htm</a>
     */
    public int[] sort() {
    	int exchangeValue = 0;
    	for(int k = numbers.length; k > 1; k--) {
	    	for(int i = 0; i < numbers.length-1; i++) {
	    		if(numbers[i] > numbers[i+1]) {
	    			exchangeValue = numbers[i];
	    			numbers[i] = numbers[i+1];
	    			numbers[i+1] = exchangeValue;
	    		}
	    	}
    	}
        return numbers;
    }

    /**
     * @return the sorted array in reverse order
     */
    public int[] revertSort() {
    	return reverted(sort());
    }

    /**
     * @return the unsorted array in reverted order.
     */
    public int[] reverted() {
        return reverted(numbers);
    }

    /**
     * @param value which should be searched for.
     * @return true if the array contains the value, false otherwise.
     */
    public boolean contains(int value) {
        for(int i = 0; i < numbers.length; i++) {
        	if(numbers[i] == value) {
        		return true;
        	}
        }
    	return false;
    }

    /**
     * @return the average value of all elements summed up.
     */
    public double average() {
    	return (sumUpValues() / numbers.length);
    }

    /**
     * @return the average value of all elements summed up, but without the highest and the lowest value.
     */
    public double trimmedMean() {
        return (sumUpValues() - getHighestValue() - getLowestValue()) / (numbers.length - 2);
    }

    /**
     * @return the max value of the array. In the array [1,9,3] max would be 9.
     */
    public int maxValue() {
        return getHighestValue();
    }

    /**
     * @return the min value of the array. In the array [1,9,3] min would be 1.
     */
    public int minValue() {
        return getLowestValue();
    }

    /* **********************************************************
     *   Feel free to add as many private helper methods as      *
     *   you like.                                               *
     * ***********************************************************/
    
    private double sumUpValues() {
    	double sum = 0;
    	for(double d : numbers) {
    		sum += d;
    	}
    	return sum;
    }
    
    private int getHighestValue() {
    	int highestValue = numbers[0];
    	for(int i = 1; i < numbers.length; i++) {
    		if(numbers[i] >= highestValue) {
    			highestValue = numbers[i];
    		}
    	}
    	return highestValue;
    }
    
    private int getLowestValue() {
    	int lowestValue = numbers[0];
    	for(int i = 1; i < numbers.length; i++) {
    		if(numbers[i] < lowestValue) {
    			lowestValue = numbers[i];
    		}
    	}
    	
    	return lowestValue;
    }
    
    private int[] reverted(int[] arr) {
    	int numberIndex = 0;
    	int[] tmp = new int[arr.length];
        for(int i = (arr.length-1); i >= 0; i--) {
        	tmp[numberIndex] = arr[i];
        	numberIndex++;
        }
        return tmp;
    }
}