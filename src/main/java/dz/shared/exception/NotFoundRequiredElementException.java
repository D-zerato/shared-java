package dz.shared.exception;

public class NotFoundRequiredElementException extends RuntimeException {
    //
    private String[] messageArgs;

    public NotFoundRequiredElementException(String messageCode) {
        //
        super(messageCode);
    }

    public NotFoundRequiredElementException(Enum messageEnum) {
        //
        super(messageEnum.name());
    }

    public NotFoundRequiredElementException(String messageCode, String... messageArgs) {
        super(messageCode);
        this.messageArgs = messageArgs;
    }

    public NotFoundRequiredElementException(String messageCode, Throwable t) {
        //
        super(messageCode, t);
    }

    public NotFoundRequiredElementException(Throwable t) {
        //
        super(t);
    }

    public static NotFoundRequiredElementException newOne(String messageCode) {
        //
        return new NotFoundRequiredElementException(messageCode);
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
