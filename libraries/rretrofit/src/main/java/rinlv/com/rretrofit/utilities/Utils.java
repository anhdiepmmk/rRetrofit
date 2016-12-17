package rinlv.com.rretrofit.utilities;

import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

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
}
