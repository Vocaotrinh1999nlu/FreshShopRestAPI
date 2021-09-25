package vct.freshshop.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.entity.Oder;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.service.in.OderServiceInterface;

@RequestMapping("/api")
@RestController
public class OderController {

	@Autowired
	private OderServiceInterface oderService;
	
	@GetMapping("/oder")
	public ResponseEntity<List<Oder>> findAll(){
		List<Oder> oders = oderService.findAll();
		return new ResponseEntity<List<Oder>>(oders, HttpStatus.OK);
	}
	
	@GetMapping("/oder/{id}")
	public ResponseEntity<Oder> findById(@PathVariable("id") int id){
		Optional<Oder> oder = oderService.findById(id);
		return oder.map(o -> new ResponseEntity<Oder>(o, HttpStatus.OK))
				.orElseThrow(() -> new ResourceNotFoundException("Oder not found"));
	}
	
	@PostMapping("/oder")
	public ResponseEntity<String> save(@Valid @RequestBody Oder oder){
		oderService.save(oder);
		return new ResponseEntity<String>("Create", HttpStatus.OK);
	}
}
