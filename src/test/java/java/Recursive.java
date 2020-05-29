package java;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
display(1);
	}

	public static void display(int i){
		
		if(i<=10){
	System.out.println(i);
	i++;
	display(i);
		}
	
	}
}
