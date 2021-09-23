package vct.freshshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vct.freshshop.entity.OderItem;
import vct.freshshop.service.in.OderItemServiceInterface;

@RequestMapping("/api")
@RestController
public class OderItemController {

	@Autowired
	private OderItemServiceInterface oderItemService;
	
	@PostMapping("/oderItem")
	public ResponseEntity<String> save(@Valid @RequestBody OderItem oderItem){
		oderItemService.save(oderItem);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}
	
}
