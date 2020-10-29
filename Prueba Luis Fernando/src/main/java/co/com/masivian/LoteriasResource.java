package com.escrutinio.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.escrutinio.dto.loterias.LoteriaProductosDTO;
import com.escrutinio.dto.transversal.ItemFiltroDTO;
import com.escrutinio.service.LoteriasService;
import com.escrutinio.util.BusinessException;
import com.escrutinio.util.Util;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Servicio que contiene todos los procesos de negocio para las Loterias
 * localhost:puerto/path_name/
 */
@RestController
@RequestMapping("/escrutinio/loterias")
public class LoteriasResource {
	
	/**
	 * Atributo Logger para la app
	 */
	 private final Logger log = LoggerFactory.getLogger(LoteriasResource.class);

	/**
	 * Atributo que representa el servicio de loterias
	 */
	@Autowired
	private LoteriasService loteriasService;
	
	/**
	 * Metodo encargado de consultar las loterias por unos filtros dinamicos
	 * @param loteriasRequestDTO dto de entrada para la consulta de loterias
	 * @return lista de loterias encontradas
	 */
	@GetMapping(path = "/consultarLoterias/{loteriasRequestDTO}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Consultar Loterias", notes = "Operación para consular loterias")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<Object> consultarLoterias(@PathVariable LoteriaProductosDTO loteriasRequestDTO) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.consultarLoteriasFiltros(loteriasRequestDTO));
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".consultarLoteria", e.getMessage());
		}
	}
	
	@GetMapping(path = "/consultarRutaServidor", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Consultar consultarRutaServidor", notes = "Operación para consular consultarRutaServidor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<Object> consultarRutaServidor() {
		try {
			return Util.getResponseSuccessful(this.loteriasService.consultarRutaServidor());
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".consultarRutaServidor", e.getMessage());
		}
	}

	@GetMapping(path = "/consultarNombresImagenes/{tipo}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "Consultar consultarRutaServidor", notes = "Operación para consular consultarRutaServidor")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	public ResponseEntity<Object> consultarNombresImagenes(@PathVariable String tipo) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.consultarNombresImagenes(tipo));
		} catch (BusinessException e) {
			return Util.getResponseBadRequest(e.getMessage());
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".consultarNombresImagenes", e.getMessage());
		}
	}
	/**
	 * Metodo encargado de crear la loteria 
	 * @param loteriasDTO dto de entrada que representa la loteria
	 * @return loteria creada
	 */
	@PostMapping(path = "/crearLoteria",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "CrearLoteria", notes = "Operación para crear la loteria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> crearLoteria(@RequestBody LoteriaProductosDTO loteriasDTO) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.save(loteriasDTO));
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".crearLoteria ", e.getMessage());
		}
	}
	
	@PostMapping(path = "/adjuntarImagenLoteria",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "adjuntarImagenLoteria", notes = "Operación para crear la loteria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> adjuntarImagenLoteria(@RequestBody MultipartFile multiPart) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.saveImg(multiPart));
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".adjuntarImagenLoteria ", e.getMessage());
		}
	}
	
	/**
	 * metodo encargado de editar la loteria
	 * @param loteriasDTO loteria a editar
	 * @return loteria editada
	 */
	@PutMapping(path = "/editarLoteria",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "EditarLoteria", notes = "Operación para editar la loteria")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Proceso ejecutado satisfactoriamente"),
			@ApiResponse(code = 400, message = "Se presentó una exception de negocio"),
			@ApiResponse(code = 404, message = "Recurso no encontrado"),
			@ApiResponse(code = 500, message = "Internal Server Error")})
	public ResponseEntity<Object> editarLoteria(@RequestBody LoteriaProductosDTO loteriasDTO) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.save(loteriasDTO));
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".editarLoteria ", e.getMessage());
		}
	}
	
	
	@PostMapping(path = "/consultarLoteriasGanadoras",
			consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> consultarLoteriasGanadoras(@RequestBody ItemFiltroDTO filtro) {
		try {
			return Util.getResponseSuccessful(this.loteriasService.consultarLoteriasGanadoras(filtro));
		} catch (Exception e) {
			return Util.getResponseError(LoteriasResource.class.getSimpleName() + ".consultarLoteriasGanadoras ", e.getMessage());
		}
	}
}
