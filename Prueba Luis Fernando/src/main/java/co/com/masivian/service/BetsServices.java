package co.com.masivian.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.masivian.controller.BetsController;
import co.com.masivian.dto.BetDTO;
import co.com.masivian.entity.Roulette;
import co.com.masivian.util.Util;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/Bets")
public class BetsServices {
	
	private final Logger log = LoggerFactory.getLogger(BetsController.class);
	
	@Autowired
	private BetsController betsController;
	

	
	@PostMapping(path = "/createRoulette")
	@ApiOperation(value = "createRoulette", notes = "Operación para crear la ruleta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> createRoulette(@RequestBody Roulette roulette) {
		try {
			return Util.getResponseSuccessful(this.betsController.createRoulette(roulette));
		} catch (Exception e) {
			return Util.getResponseError(BetsServices.class.getSimpleName() + ".createRoulette", e.getMessage());
		}
	}
	
	
	@GetMapping(path = "/rouletteOpening/{idRoulette}")
	@ApiOperation(value = "rouletteOpening/{idRoulette}", notes = "Operación para abirir la ruleta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public  ResponseEntity<Object>  rouletteOpening(@PathVariable Long idRoulette ){
		try {
			return Util.getResponseSuccessful(this.betsController.rouletteOpening(idRoulette));
		} catch (Exception e) {
			return Util.getResponseError(BetsServices.class.getSimpleName() + ".rouletteOpening/{idRoulette}", e.getMessage());
		}
	}
	
	
	
	@PostMapping(path = "/BetNumber")
	@ApiOperation(value = "/BetNumber", notes = "Operación para apuestas a la ruleta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> BetsNumber(@RequestBody BetDTO betDTO) {
		try {
			return Util.getResponseSuccessful(this.betsController.BetsNumber(betDTO));
		} catch (Exception e) {
			return Util.getResponseError(BetsServices.class.getSimpleName() + "./BetNumber", e.getMessage());
		}
	}
	
	
	@PostMapping(path = "/closingBets")
	@ApiOperation(value = "/closingBets", notes = "Operación para crear la ruleta")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> rouletteClosing(@RequestBody Roulette roulette) {
		try {
			return Util.getResponseSuccessful(this.betsController.rouletteClosing(roulette));
		} catch (Exception e) {
			return Util.getResponseError(BetsServices.class.getSimpleName() + "./closingBets/{idRoulette}", e.getMessage());
		}
	}
	
	
	@GetMapping(path = "/rouletteList")
	@ApiOperation(value = "rouletteList", notes = "Operación para consultar las ruletas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public  ResponseEntity<Object>  rouletteList(){
		try {
			return Util.getResponseSuccessful(this.betsController.rouletteList());
		} catch (Exception e) {
			return Util.getResponseError(BetsServices.class.getSimpleName() + ".rouletteList", e.getMessage());
		}
	}
	
	

}
