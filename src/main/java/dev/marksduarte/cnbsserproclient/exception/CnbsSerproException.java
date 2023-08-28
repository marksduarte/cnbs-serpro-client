package dev.marksduarte.cnbsserproclient.exception;

public class CnbsSerproException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CnbsSerproException(String msg) {
		super(msg);
	}

	public CnbsSerproException(String message, Throwable cause) {
		super(message, cause);
	}
}
