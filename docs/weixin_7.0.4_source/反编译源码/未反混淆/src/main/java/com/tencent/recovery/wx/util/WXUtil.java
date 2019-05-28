package com.tencent.recovery.wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.recovery.util.Util;
import java.util.UUID;

public class WXUtil {
    public static String iG(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public static String iH(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("login_weixin_username", "");
        if (Util.isNullOrNil(string)) {
            string = sharedPreferences.getString("login_user_name", "");
        }
        if (Util.isNullOrNil(string)) {
            return String.valueOf(Util.iB(context));
        }
        return string;
    }

    public static final String atN(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    public static final String QZ(int i) {
        return "KeyConfigHttpCode[" + i + "]";
    }

    public static final String Ra(int i) {
        return "KeyPatchHttpCode[" + i + "]";
    }
}
