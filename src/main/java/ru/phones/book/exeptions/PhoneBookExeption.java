package ru.phones.book.exeptions;

public class PhoneBookExeption extends RuntimeException {
    PhoneBookExeption(Throwable cause) {
        super(cause);
    }

    PhoneBookExeption(String message) {
        super(message);
    }

    public PhoneBookExeption(String message, Throwable cause) {
        super(message, cause);
    }
}
