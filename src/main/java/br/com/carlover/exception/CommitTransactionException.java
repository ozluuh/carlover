package br.com.carlover.exception;

public class CommitTransactionException extends Exception {

    public CommitTransactionException() {
        super("Commit exception, contacts administrator");
    }

    public CommitTransactionException(String message) {
        super(message);
    }

}
