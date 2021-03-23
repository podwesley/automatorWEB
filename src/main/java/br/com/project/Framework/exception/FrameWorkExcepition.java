package br.com.project.Framework.exception;

import br.com.project.Framework.utils.Log;

/**
 * Exceção de negócios.
 */
public class FrameWorkExcepition extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public FrameWorkExcepition() {
        super();
    }

    public FrameWorkExcepition(String message, Throwable cause) {
        super(message, cause);
        Log.info(message);
    }

    public FrameWorkExcepition(String message) {
        super(message);
        Log.info(message);
    }

    public FrameWorkExcepition(Throwable cause) {
        super(cause);
        Log.info(cause.getMessage());
    }

}
