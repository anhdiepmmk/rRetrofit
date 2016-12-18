package rinlv.com.rretrofit.utilities;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import rinlv.com.rretrofit.models.PostParameter;

/**
 * Created by Rin.LV on 12/17/2016.
 */

public class Utils {

    public static <T> List<T> stringGsonToArray(String s, Class<T[]> clazz) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        return Arrays.asList(new Gson().fromJson(s, clazz));
    }

    public static <T> T stringGsonToObject(String s, Class<T> clazz) {
        if (TextUtils.isEmpty(s)) {
            return null;
        }
        return new Gson().fromJson(s, clazz);
    }

    public static Map<String, String> getFieldMap(PostParameter postParameter) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        return gson.fromJson(gson.toJson(postParameter), type);
    }
}
