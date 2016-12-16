package rinlv.com.rretrofit.models;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class HeaderEntity {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public HeaderEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
