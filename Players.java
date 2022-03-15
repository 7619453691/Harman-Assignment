package com.harman.assignmentproject.wrapper;

import java.util.Arrays;

public class Players 
{
	private String name;
	private Characters[] character;
	
	public Players()
	{
		
	}

	public Players(String name, Characters[] character) {
		super();
		this.name = name;
		this.character = character;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Characters[] getCharacter() {
		return character;
	}

	public void setCharacter(Characters[] character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "Players [name=" + name + ", character=" + Arrays.toString(character) + "]";
	}

	
	
}
