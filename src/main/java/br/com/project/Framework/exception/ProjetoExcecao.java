package br.com.project.Framework.exception;

import br.com.project.Framework.utils.Log;

/**
 * Exceção de negócios.
 */
public class ProjetoExcecao extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ProjetoExcecao() {
        super();
    }

    public ProjetoExcecao(String message, Throwable cause) {
        super(message, cause);
        Log.info(message);
    }

    public ProjetoExcecao(String message) {
        super(message);
        Log.info(message);
    }

    public ProjetoExcecao(Throwable cause) {
        super(cause);
        Log.info(cause.getMessage());
    }

}
