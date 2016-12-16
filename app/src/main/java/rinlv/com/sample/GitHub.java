package rinlv.com.sample;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Rin.LV on 12/16/2016.
 */

public class GitHub {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("full_name")
    private String fName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public String toString() {
        return "GitHub{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fName='" + fName + '\'' +
                '}';
    }
}
