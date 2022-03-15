package com.harman.assignmentproject.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harman.assignmentproject.response.AvengersResponse;
import com.harman.assignmentproject.services.AvengersServices;
import com.harman.assignmentproject.wrapper.Characters;

@RestController
@RequestMapping("/v1/avengers")
public class MyController
{
	public static ArrayList<Characters> allCharacters = null;
	@Autowired
	AvengersServices service;
	
	@GetMapping("/allCharacters")
	@Scheduled(fixedRate=15000)
	public ResponseEntity<AvengersResponse> getAllAvengers()
	{
		allCharacters = service.getAllCharacters();
		
		return new ResponseEntity<AvengersResponse>(new AvengersResponse(200, "data fetched!!", allCharacters),HttpStatus.OK);
	}
	
	@GetMapping("/getCharacterPower/{name}")
	public ResponseEntity<AvengersResponse> getCharacterPower(@PathVariable("name")String name)
	{
		System.out.println(name);
		allCharacters = service.getAllCharacters();
		System.out.println(allCharacters);
		int power = 0;
		for(Characters character: allCharacters)
		{
			if(character.getName().equalsIgnoreCase(name))
			{
				power = character.getMax_power();
				return new ResponseEntity<AvengersResponse>(new AvengersResponse(200, "Data Present!!", power),HttpStatus.OK);
			}
		}
		return new ResponseEntity<AvengersResponse>(new AvengersResponse(404, "Data NOT Present!!", 0),HttpStatus.NOT_FOUND);
	}
}
