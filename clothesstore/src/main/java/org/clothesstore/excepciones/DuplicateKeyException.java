package org.clothesstore.excepciones;

public class DuplicateKeyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2557458998371935448L;

	public DuplicateKeyException() {
		super();
	}

	public DuplicateKeyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DuplicateKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateKeyException(String message) {
		super(message);
	}

	public DuplicateKeyException(Throwable cause) {
		super(cause);
	}
	
	

}
