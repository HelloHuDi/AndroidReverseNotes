package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.net.URLEncoder;
import java.util.List;
import org.apache.http.NameValuePair;

public final class m {
    public static String aqc() {
        AppMethodBeat.i(108382);
        ab.i("MicroMsg.GoogleContactLogic", "getRequestCodeUrl:%s", "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com");
        AppMethodBeat.o(108382);
        return "https://accounts.google.com/o/oauth2/auth?scope=https://www.googleapis.com/auth/userinfo.email https://www.google.com/m8/feeds&redirect_uri=urn:ietf:wg:oauth:2.0:oob&response_type=code&client_id=369820936870.apps.googleusercontent.com";
    }

    public static String au(List<NameValuePair> list) {
        AppMethodBeat.i(108383);
        StringBuilder stringBuilder = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            NameValuePair nameValuePair = (NameValuePair) list.get(i);
            if (!TextUtils.isEmpty(nameValuePair.getName())) {
                if (i != 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(URLEncoder.encode(nameValuePair.getName(), "UTF-8"));
                stringBuilder.append("=");
                if (!TextUtils.isEmpty(nameValuePair.getValue())) {
                    stringBuilder.append(URLEncoder.encode(nameValuePair.getValue(), "UTF-8"));
                }
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(108383);
        return stringBuilder2;
    }

    public static boolean cx(Context context) {
        AppMethodBeat.i(108384);
        Intent intent = new Intent("com.google.android.gms.common.account.CHOOSE_ACCOUNT");
        if (context.getPackageManager().resolveActivity(new Intent("com.tencent.mm.gms.ACTION_CHOOSE_ACCOUNT"), 0) == null || context.getPackageManager().resolveActivity(intent, 0) == null) {
            AppMethodBeat.o(108384);
            return false;
        } else if (VERSION.SDK_INT < 8) {
            AppMethodBeat.o(108384);
            return false;
        } else if (context.getSharedPreferences(ah.doA(), 0).getBoolean("googleauth", false)) {
            AppMethodBeat.o(108384);
            return false;
        } else {
            AppMethodBeat.o(108384);
            return true;
        }
    }
}
