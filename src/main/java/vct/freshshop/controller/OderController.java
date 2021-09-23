package vct.freshshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.entity.Oder;
import vct.freshshop.service.in.OderServiceInterface;

@RequestMapping("/api")
@RestController
public class OderController {

	@Autowired
	private OderServiceInterface oderService;
	
	@PostMapping("/oder")
	public ResponseEntity<String> save(@Valid @RequestBody Oder oder){
		oderService.save(oder);
		return new ResponseEntity<String>("Create", HttpStatus.OK);
	}
}
