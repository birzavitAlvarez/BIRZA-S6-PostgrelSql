package com.example.BIRZAS6.controller;
import com.example.BIRZAS6.DTO.BancoDTO;
import com.example.BIRZAS6.entity.Banco;
import com.example.BIRZAS6.service.BancoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller	
@CrossOrigin
@RequestMapping(path="/banco")
public class BancoController {
    
    @Autowired
	private BancoService bancoService;

	// READ ALL
	@GetMapping
	public ResponseEntity<?> readAll(){
		List<Banco> bancos =bancoService.findAll();
		List<BancoDTO> bancosDTO=new ArrayList<>();
		for(Banco banco: bancos) {
			BancoDTO bancoDTO=new BancoDTO (banco.getCodban(),banco.getNomban());
			bancosDTO.add(bancoDTO);
		}
		// Map<String,Object> respuesta=new HashMap<>();
		// respuesta.put("status",200);
		// respuesta.put("data", bancosDTO);
		return ResponseEntity.ok(bancosDTO);//(respuesta)
	}
	// READ BY ID
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id) {
		Optional<Banco> bancoOptional=bancoService.findById(id);
		if(!bancoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		BancoDTO bancoDTO = new BancoDTO(bancoOptional.get().getCodban(), bancoOptional.get().getNomban());
		// Map<String, Object> respuesta = new HashMap<>();
		// respuesta.put("status", 200);
		// respuesta.put("data", bancoDTO);
		return ResponseEntity.ok(bancoDTO); //(respuesta)
	}
	// CREATE
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Banco banco){
		bancoService.save(banco);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
	}
	// UPDATE BY ID
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Banco banco,@PathVariable Integer id){
		Optional<Banco> bancoOptional= bancoService.findById(id);
		if(!bancoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		banco.setCodban(id);
		bancoService.save(banco);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);
	}
	// DELETE BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Banco> bancoOptional= bancoService.findById(id);
		if(!bancoOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		bancoService.deleteById(id);
		Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("status", 200);
		return ResponseEntity.ok(respuesta);		
	}
}