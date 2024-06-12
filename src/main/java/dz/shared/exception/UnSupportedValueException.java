package dz.shared.exception;

public class UnSupportedValueException extends RuntimeException {
    //
    private String[] messageArgs;

    public UnSupportedValueException(String messageCode) {
        //
        super(messageCode);
    }

    public UnSupportedValueException(Enum messageEnum) {
        //
        super(messageEnum.name());
    }

    public UnSupportedValueException(String messageCode, String... messageArgs) {
        super(messageCode);
        this.messageArgs = messageArgs;
    }

    public UnSupportedValueException(String messageCode, Throwable t) {
        //
        super(messageCode, t);
    }

    public UnSupportedValueException(Throwable t) {
        //
        super(t);
    }

    public static UnSupportedValueException newOne(String messageCode) {
        //
        return new UnSupportedValueException(messageCode);
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
