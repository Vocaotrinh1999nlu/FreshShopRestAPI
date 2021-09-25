package vct.freshshop.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

import vct.freshshop.dto.OderItemDTO;
import vct.freshshop.entity.OderItem;
import vct.freshshop.exception.ResourceNotFoundException;
import vct.freshshop.service.in.OderItemServiceInterface;

@RequestMapping("/api")
@RestController
public class OderItemController {

	@Autowired
	private OderItemServiceInterface oderItemService;

	@GetMapping("/oderItem")
	public ResponseEntity<List<OderItemDTO>> findAll() {
		List<OderItemDTO> oderItems = oderItemService.findAll().stream().map(o -> oderItemService.convertToDTO(o))
				.collect(Collectors.toList());
		return new ResponseEntity<List<OderItemDTO>>(oderItems, HttpStatus.OK);
	}

	public ResponseEntity<OderItem> findById(@PathVariable("id") int id) {
		Optional<OderItem> oderItem = oderItemService.findById(id);
		return oderItem.map(o -> new ResponseEntity<OderItem>(o, HttpStatus.OK))
				.orElseThrow(() -> new ResourceNotFoundException("Oder Item is not found"));
	}

	@PostMapping("/oderItem")
	public ResponseEntity<String> save(@Valid @RequestBody OderItem oderItem) {
		oderItemService.save(oderItem);
		return new ResponseEntity<String>("Created", HttpStatus.OK);
	}

}
