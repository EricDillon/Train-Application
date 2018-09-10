package Train_Ticket;

import java.util.*;

/*
 * This class handles storing all data regarding a single 
 * passenger. Will be stored in a list of passengers when writing
 * to a file
 */

public class Passenger implements Comparable<Passenger>
{
	private String name;
	private int age;
	private char gender;
	
	
	//Constructor
	public Passenger(String name, int age, char gender) 
	{
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	
	//Getters/Setters
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public char getGender() {
		return gender;
	}


	public void setGender(char gender) {
		this.gender = gender;
	}


	@Override
	public int compareTo(Passenger arg0) {
		// TODO Auto-generated method stub
		return 1;
	}



}
