package edu.lntu;

public class ParsingException extends RuntimeException {

    public ParsingException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
