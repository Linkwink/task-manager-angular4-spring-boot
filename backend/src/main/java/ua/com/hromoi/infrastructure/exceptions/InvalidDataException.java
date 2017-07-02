package ua.com.hromoi.infrastructure.exceptions;

import java.util.List;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class InvalidDataException extends Exception{
    /**
     * unique code of such error
     */
    public final static int CODE = 4003;
    /**
     * Entity that caused exception
     */
    public final String entity;
    /**
     * List of the invalid fields
     */
    public final List<String> incorrectFields;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param entity entity that caused error
     * @param incorrectFields list of incorrect fields
     */
    public InvalidDataException(String entity, List<String> incorrectFields) {
        super("In entity " + entity + " the following fields are incorrect: " + String.join(",",incorrectFields));
        this.entity = entity;
        this.incorrectFields = incorrectFields;
    }
}
