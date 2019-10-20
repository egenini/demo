package ar.com.tbf.common.api.exception;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2389622415910473778L;

	public NotFoundException(Integer id) {
		super("Could not find " + id);
	}

}
