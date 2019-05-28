package com.tencent.recovery.p662wx.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.recovery.util.Util;
import java.util.UUID;

/* renamed from: com.tencent.recovery.wx.util.WXUtil */
public class WXUtil {
    /* renamed from: iG */
    public static String m8761iG(Context context) {
        return context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    /* renamed from: iH */
    public static String m8762iH(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        String string = sharedPreferences.getString("login_weixin_username", "");
        if (Util.isNullOrNil(string)) {
            string = sharedPreferences.getString("login_user_name", "");
        }
        if (Util.isNullOrNil(string)) {
            return String.valueOf(Util.m8736iB(context));
        }
        return string;
    }

    public static final String atN(String str) {
        if (str.contains("?")) {
            return str + "uuid=" + UUID.randomUUID().toString();
        }
        return str + "?uuid=" + UUID.randomUUID().toString();
    }

    /* renamed from: QZ */
    public static final String m8759QZ(int i) {
        return "KeyConfigHttpCode[" + i + "]";
    }

    /* renamed from: Ra */
    public static final String m8760Ra(int i) {
        return "KeyPatchHttpCode[" + i + "]";
    }
}
