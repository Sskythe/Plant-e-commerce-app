package com.cg.nursery.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	  @ExceptionHandler(PlantException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyPlantException(PlantException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }
	  
	  @ExceptionHandler(SeedException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MySeedException(SeedException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }

	  
	  @ExceptionHandler(PlanterException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyPlanterException(PlanterException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }

	  
	  @ExceptionHandler(OrderException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyOrderException(OrderException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }
	  
	  @ExceptionHandler(CustomerException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyCustomerException(CustomerException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }
	  
	  @ExceptionHandler(LoginException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyLoginException(LoginException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }
	  
	  @ExceptionHandler(AuthException.class)
	    public @ResponseBody ResponseEntity<ErrorInfo> MyAuthException(AuthException e, HttpServletRequest req) {
	   
	        ErrorInfo info = new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	        return  new ResponseEntity<ErrorInfo>(info,HttpStatus.NOT_FOUND);
	           
	    }
	  
	  


}
