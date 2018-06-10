import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main{

	public static float avg(ArrayList<Student> list) {
		float total = 0;
		int i = 0;
		while(i < list.size()) {
			total += list.get(i).dobaviProsecnuOcenu();
			i++;
		}
		return total / i;
	}
	public static void printingList(ArrayList<Student> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public static void populateStudents(ArrayList<Student> students) {
		Scanner in = new Scanner(System.in);

		System.out.print("Molimo unesite br. studenata > ");
		int n;
		n = in.nextInt();

		for(int i = 0; i < n; i++) {
			System.out.println("Student broj #" + (i+1));
			//unosenje broja indeksa
			int brInd;
			do {
				System.out.print("Broj indeksa > ");
				while (!in.hasNextInt()) {
					String input = in.next();
					System.err.println("| " + input + " |" + " nije validan broj indeksa, pokusajte ponovo. ");
				}
				brInd = in.nextInt();
				if(brInd < 0 ) {
					System.err.println("| " + brInd + " |" + " nije validan, unesite ponovo: ");
				}
			} while (brInd < 0);
			in.nextLine();

			//Unosenje imena
			Matcher match;
			String ime;
			do {
				Pattern pattern = Pattern.compile("^[a-zA-z]*(\\s)[a-zA-z]*"); 
				System.out.print("Ime > ");
				ime = in.nextLine();
				match = pattern.matcher(ime); 
				if(!match.matches()){
					System.err.println("| " + ime + " |" + " nije validno ime,unesite ponovo");
				}
			}while(!match.matches());

			//unosenje proseka
			float prosek;
			do {
				System.out.print("Prosek > ");			
				prosek = in.nextFloat();
				
				if(prosek <= 0 || prosek > 10) {
					System.err.println("| " + prosek + " |" + " nije validan, unesite ponovo: ");
				}
			} while (prosek <= 0 || prosek > 10);

			students.add(new Student(brInd,ime,prosek));
		}
	}
	public static void avgPrint(ArrayList<Student> students) {
		System.out.println("Prosecna ocena svih studenata > " + avg(students));
	}
	public static void sortStudents(ArrayList<Student> students) {
		SortingAndSearchinStudents student = new SortingAndSearchinStudents();
		student.sortingStudents(students);
		System.out.println("Lista studenata sortiranih po prosecnoj oceni");
		printingList(students);
	}
	public static void searchStudents(ArrayList<Student> students,int searchKey) {
		SortingAndSearchinStudents student = new SortingAndSearchinStudents();
		student.sortingStudents(students);
		//System.out.println(student.toString());
		
		Student st = student.binarySearch(students, searchKey);
		if(st == null) {
			System.err.println("Trazeni student nije pronadjen");
		}
		else	
		{	
			System.out.println("< Student je pronadjen >");
			System.out.println(st.toString());
		}
	}
	public static void main(String args[]) 
	{
		//popunjavanje liste student
		ArrayList<Student> students = new ArrayList<>();
		populateStudents(students);
		printingList(students);

		//stampanje prosecne ocene
		Scanner scann = new Scanner(System.in);
		System.out.print("Ukoliko zelite da vidite prosecnu ocenu studenata unesite (D/d) > ");
		char yn = scann.next().charAt(0);
		if(yn == 'd' || yn == 'D') {
			avgPrint(students);
		}
		System.out.print("Ukoliko zelite da sortirate studente po prosecnoj oceni unesite (D/d) >");
		char yn2 = scann.next().charAt(0);
		if(yn2 == 'd' || yn2 == 'D') {
			sortStudents(students);
		}
		System.out.print("Ukoliko zelite da pretrazite studente po broju indeksa unesite (D/d) >");
		char yn3 = scann.next().charAt(0);
		if(students.size() <= 1) {
			System.err.println("Nije moguce pretraziti listu studentata,\n"
					+ "lista je prazna ili je samo jedan student unesen ");
		}else {
			if(yn3 == 'd' || yn3 == 'D') {
				System.out.print("Unesite broj indeksa studenta > ");
				int br = scann.nextInt();
				searchStudents(students,br);
			}
		}
		System.out.println("<- Hvala na koriscenju aplikacije ->");
	}


}





