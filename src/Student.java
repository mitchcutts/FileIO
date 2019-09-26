//Mitch Cutts and Jared Hamilton, 11AM Section
public class Student implements Comparable<Student> {	
	private String name;
	private int score;
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return  name + " " + score;
	}

	@Override

	//compare based on student's name (alphabetical)
	public int compareTo(Student o) {
		return name.compareTo(o.name);
	} 
}
