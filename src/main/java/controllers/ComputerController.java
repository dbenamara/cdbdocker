package controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dto.ComputerDto;
import service.ComputerService;

@RestController
@RequestMapping("/computers")
public class ComputerController {
	private ComputerService computerService;
	
	public ComputerController(ComputerService computerService) {
		this.computerService = computerService;
	}
	
	@GetMapping
	public ResponseEntity<List<ComputerDto>> findAll() {
		return new ResponseEntity<>(computerService.readAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ComputerDto> find(@PathVariable Integer id) {

		return new ResponseEntity<>(computerService.find(id).get(),HttpStatus.OK);
	}
}
