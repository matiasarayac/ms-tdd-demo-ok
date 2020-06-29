package cl.matiasaraya.tddworkshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.matiasaraya.tddworkshop.elements.Loan;
import cl.matiasaraya.tddworkshop.elements.Response;
import cl.matiasaraya.tddworkshop.service.LoanDefaultRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/tddworkshop")
@Api(value = "TDDWorkshop API")
public class TDDWorkshop {
	
	
	@Autowired
	private LoanDefaultRulesService loanDefaultRulesService;
		
	
	/** POST **/	
	@PostMapping(value = "/isInDefaultForDaysPastDue")
	@ApiOperation(value = "Determine if a client is under default by the given loan", response = Response.class, responseContainer = "", notes = "Returns true for success and false for error operation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Success return a Boolean Object", response = Boolean.class),
			@ApiResponse(code = 204, message = "No content, without content for the query"),
			@ApiResponse(code = 500, message = "Internal Server Error, Exception message") })
	public ResponseEntity<Response> isInDefaultForDaysPastDue(@RequestBody Loan loan) {		
							
		Response response = new Response();		
		
		boolean responseData = loanDefaultRulesService.isInDefaultForDaysPastDue(loan);		
		if (responseData) {
			response.setMessage("El cliente se encuentra en Incumplimiento, porque su credito de tipo:"+loan.getType()+" tiene "+loan.getDaysPastDue()+" días de mora");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("El cliente no esta en Incumplimiento por este credito");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}		
	}

}
