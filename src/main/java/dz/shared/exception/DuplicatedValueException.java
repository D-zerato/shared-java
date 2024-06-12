package dz.shared.exception;

public class DuplicatedValueException extends RuntimeException {
    //
    private String[] messageArgs;

    public DuplicatedValueException(String messageCode) {
        //
        super(messageCode);
    }

    public DuplicatedValueException(Enum messageEnum) {
        //
        super(messageEnum.name());
    }

    public DuplicatedValueException(String messageCode, String... messageArgs) {
        super(messageCode);
        this.messageArgs = messageArgs;
    }

    public DuplicatedValueException(String messageCode, Throwable t) {
        //
        super(messageCode, t);
    }

    public DuplicatedValueException(Throwable t) {
        //
        super(t);
    }

    public static DuplicatedValueException newOne(String messageCode) {
        //
        return new DuplicatedValueException(messageCode);
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
