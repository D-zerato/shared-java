package dz.shared.exception;

public class NotFoundObjectException extends RuntimeException {
    //
    private String[] messageArgs;

    public NotFoundObjectException(String messageCode) {
        //
        super(messageCode);
    }

    public NotFoundObjectException(Enum messageEnum) {
        //
        super(messageEnum.name());
    }

    public NotFoundObjectException(String messageCode, String... messageArgs) {
        super(messageCode);
        this.messageArgs = messageArgs;
    }

    public NotFoundObjectException(String messageCode, Throwable t) {
        //
        super(messageCode, t);
    }

    public NotFoundObjectException(Throwable t) {
        //
        super(t);
    }

    public static NotFoundObjectException newOne(String messageCode) {
        //
        return new NotFoundObjectException(messageCode);
    }

    public String getMessageCode() {
        //
        return this.getMessage();
    }

    public String[] getMessageArgs() {
        //
        return this.messageArgs;
    }
}
