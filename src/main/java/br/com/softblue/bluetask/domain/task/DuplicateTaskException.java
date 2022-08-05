package br.com.softblue.bluetask.domain.task;

public class DuplicateTaskException extends Exception{

    public DuplicateTaskException(String message) {
        super(message);
    }
}
