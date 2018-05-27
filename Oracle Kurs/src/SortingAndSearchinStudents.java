import java.util.ArrayList;
import java.util.Collections;

public class SortingAndSearchinStudents {

	public void sortingStudents(ArrayList<Student> list) {
		for(int i = 0; i < list.size()-1; i++) {
			for(int j = 0; j <list.size()-i-1; j++) {
				if(list.get(j).getProsecnaOcena() < list.get(j+1).getProsecnaOcena()) {
					Collections.swap(list, j, j+1);
				}
			}
		}
	}
	public Student binarySearch(ArrayList<Student> list,int brIndeksa) {
		int low = 0, high = list.size()-1;
	
		while (low <= high) {
			int mid = low + (high-1)/2;
	     
	        if(list.get(mid).getBrojIndeksa() == brIndeksa) 
	        	return list.get(mid);
	       if (list.get(mid).getBrojIndeksa() < brIndeksa) 
	            low = mid + 1;
	        else  
	            high = mid - 1;
		}
		return null;
	}
}






