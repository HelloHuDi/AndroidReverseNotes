package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppEventUtility {
    private static final String regex = "[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?";

    public static void assertIsNotMainThread() {
    }

    public static void assertIsMainThread() {
    }

    public static double normalizePrice(String str) {
        double d = 0.0d;
        AppMethodBeat.m2504i(72160);
        try {
            Matcher matcher = Pattern.compile(regex, 8).matcher(str);
            if (matcher.find()) {
                d = NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(matcher.group(0)).doubleValue();
                AppMethodBeat.m2505o(72160);
            } else {
                AppMethodBeat.m2505o(72160);
            }
        } catch (ParseException e) {
            AppMethodBeat.m2505o(72160);
        }
        return d;
    }

    public static String bytesToHex(byte[] bArr) {
        AppMethodBeat.m2504i(72161);
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i])}));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(72161);
        return stringBuffer2;
    }

    public static boolean isEmulator() {
        AppMethodBeat.m2504i(72162);
        if (Build.FINGERPRINT.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE) && Build.DEVICE.startsWith(MessengerShareContentUtility.TEMPLATE_GENERIC_TYPE)) || "google_sdk".equals(Build.PRODUCT))) {
            AppMethodBeat.m2505o(72162);
            return true;
        }
        AppMethodBeat.m2505o(72162);
        return false;
    }

    private static boolean isMainThread() {
        AppMethodBeat.m2504i(72163);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.m2505o(72163);
            return true;
        }
        AppMethodBeat.m2505o(72163);
        return false;
    }

    public static String getAppVersion() {
        AppMethodBeat.m2504i(72164);
        Context applicationContext = FacebookSdk.getApplicationContext();
        String str;
        try {
            str = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
            AppMethodBeat.m2505o(72164);
            return str;
        } catch (NameNotFoundException e) {
            str = "";
            AppMethodBeat.m2505o(72164);
            return str;
        }
    }
}
