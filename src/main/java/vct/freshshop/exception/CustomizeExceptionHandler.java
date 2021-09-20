package vct.freshshop.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.FieldError;

@ControllerAdvice
@RestController
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotDefineException.class)
	public ResponseEntity<CustomizeErrorDetail> Exception(NotDefineException re, WebRequest rq) {

		CustomizeErrorDetail errDetail = new CustomizeErrorDetail(new Date(), re.getMessage(),
				rq.getDescription(false));
		return new ResponseEntity<CustomizeErrorDetail>(errDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomizeErrorDetail> handleResourceNotFoundException(ResourceNotFoundException re,
			WebRequest rq) {

		CustomizeErrorDetail errDetail = new CustomizeErrorDetail(new Date(), re.getMessage(),
				rq.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetail>(errDetail, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ElementNullException.class)
	public ResponseEntity<CustomizeErrorDetail> handleElementNullException(ElementNullException re, WebRequest rq) {

		CustomizeErrorDetail elementErrDetail = new CustomizeErrorDetail(new Date(), re.getMessage(),
				rq.getDescription(false));
		return new ResponseEntity<CustomizeErrorDetail>(elementErrDetail, HttpStatus.NOT_IMPLEMENTED);
	}

	@ExceptionHandler(DataFormatException.class)
	public ResponseEntity<CustomizeErrorDetail> handlDataFormatException(DataFormatException re, WebRequest rq) {

		CustomizeErrorDetail dataFormatErrDetail = new CustomizeErrorDetail(new Date(), re.getMessage(),
				rq.getDescription(false));

		return new ResponseEntity<CustomizeErrorDetail>(dataFormatErrDetail, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		CustomizeErrorDetail errorDetails = new CustomizeErrorDetail(new Date(), "Validation Failed", errors);
		return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
