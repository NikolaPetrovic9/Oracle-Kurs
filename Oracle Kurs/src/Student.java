
public class Student implements IStudent{
	private int brojIndeksa;
	private String ime;
	private float prosecnaOcena;
	
	public Student(int brojIndeksa, String ime, float prosecnaOcena) {
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prosecnaOcena = prosecnaOcena;
	}

	public int getBrojIndeksa() {
		return brojIndeksa;
	}

	public String getIme() {
		return ime;
	}

	public float getProsecnaOcena() {
		return prosecnaOcena;
	}
	
	@Override
	public String toString() {
		return  
			   "\nBroj indeksa  :\t" + brojIndeksa + 
			   "\nIme           :\t" + ime + 
			   "\nprosecnaOcena :\t" + prosecnaOcena +
			   "\n-------------------------------------";
				
	}
	
	
}
