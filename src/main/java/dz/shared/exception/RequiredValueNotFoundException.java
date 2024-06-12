package dz.shared.exception;

public class RequiredValueNotFoundException extends RuntimeException {
    //
    private String[] messageArgs;

    public RequiredValueNotFoundException(String messageCode) {
        //
        super(messageCode);
    }

    public RequiredValueNotFoundException(Enum messageEnum) {
        //
        super(messageEnum.name());
    }

    public RequiredValueNotFoundException(String messageCode, String... messageArgs) {
        super(messageCode);
        this.messageArgs = messageArgs;
    }

    public RequiredValueNotFoundException(String messageCode, Throwable t) {
        //
        super(messageCode, t);
    }

    public RequiredValueNotFoundException(Throwable t) {
        //
        super(t);
    }

    public static RequiredValueNotFoundException newOne(String messageCode) {
        //
        return new RequiredValueNotFoundException(messageCode);
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
