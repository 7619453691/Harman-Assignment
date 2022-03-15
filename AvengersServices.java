package com.harman.assignmentproject.services;


import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.harman.assignmentproject.wrapper.Characters;
import com.harman.assignmentproject.wrapper.Players;


@Service
public class AvengersServices 
{
	private Players getAllAvengers()
	{
		String url = "http://www.mocky.io/v2/5ecfd5dc3200006200e3d64b";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Players> entityPlayer = restTemplate.getForEntity(url, Players.class);
		Players players = entityPlayer.getBody();
		//System.out.println(players);
		return players;
	}


	/*
	 * public Players getAllAntiHeroes() { String url =
	 * "http://www.mocky.io/v2/5ecfd630320000f1aee3d64d"; RestTemplate restTemplate
	 * = new RestTemplate(); ResponseEntity<Players> entityPlayer =
	 * restTemplate.getForEntity(url, Players.class); Players players =
	 * entityPlayer.getBody(); System.out.println(players); return players; }
	 */


	private Players getAllMutants()
	{
		String url = "http://www.mocky.io/v2/5ecfd6473200009dc1e3d64e";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Players> entityPlayer = restTemplate.getForEntity(url, Players.class);
		Players players = entityPlayer.getBody();
		//System.out.println(players);
		return players;
	}
	
	public ArrayList<Characters> getAllCharacters()
	{
		Players allAvengers = getAllAvengers();
		Players allMutants = getAllMutants();
		
		ArrayList<Characters> allCharacters = new ArrayList<>(15);
		for(Characters character: allAvengers.getCharacter())
		{
			allCharacters.add(character);
		}
		for(Characters character: allMutants.getCharacter())
		{
			allCharacters.add(character);
		}
		return allCharacters;
	}
}
