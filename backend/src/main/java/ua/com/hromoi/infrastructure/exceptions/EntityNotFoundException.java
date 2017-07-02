package ua.com.hromoi.infrastructure.exceptions;

/**
 * Created by Viacheslav_Khromoi on 02.07.2017.
 */
public class EntityNotFoundException extends Exception {
    /**
     * unique code of such error
     */
    public final static int CODE = 4002;
    /**
     * Entity that caused exception
     */
    public final String entity;

    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param entity entity that caused error
     */
    public EntityNotFoundException(String entity) {
        super(entity + " was not found");
        this.entity = entity;
    }
}
