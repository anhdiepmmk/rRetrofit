package rinlv.com.rretrofit.models;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class ErrorEntity {
    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
