package com.tencent.ytcommon.auth;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StatisticsUtils {
    public static String getDeviceUid(Context context) {
        AppMethodBeat.m2504i(20);
        String str;
        if (context.getPackageName().startsWith("com.tencent")) {
            str = "com.tencent";
            AppMethodBeat.m2505o(20);
            return str;
        }
        String imei = getIMEI(context.getApplicationContext());
        str = getMacAddr(context.getApplicationContext());
        Object obj = !TextUtils.isEmpty(str) ? 1 : null;
        if (obj != null) {
            str = str.replaceAll(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, "");
        }
        StringBuilder append = new StringBuilder().append(imei);
        if (obj == null) {
            str = "";
        }
        str = toMD5(encryptUid(append.append(str).toString()));
        AppMethodBeat.m2505o(20);
        return str;
    }

    public static String getMacAddr(Context context) {
        AppMethodBeat.m2504i(21);
        if (context == null) {
            AppMethodBeat.m2505o(21);
            return null;
        }
        String macAddress;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                macAddress = connectionInfo.getMacAddress();
                AppMethodBeat.m2505o(21);
                return macAddress;
            }
        }
        macAddress = null;
        AppMethodBeat.m2505o(21);
        return macAddress;
    }

    public static String getIMEI(Context context) {
        String deviceId;
        AppMethodBeat.m2504i(22);
        String string = Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(string)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                AppMethodBeat.m2505o(22);
                return deviceId;
            }
        }
        deviceId = string;
        AppMethodBeat.m2505o(22);
        return deviceId;
    }

    public static String toMD5(String str) {
        AppMethodBeat.m2504i(23);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(23);
            return str2;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.reset();
            instance.update(str.getBytes());
            str2 = new BigInteger(1, instance.digest()).toString(16);
            while (str2.length() < 32) {
                str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str2));
            }
        } catch (NoSuchAlgorithmException e) {
            str2 = "";
        }
        AppMethodBeat.m2505o(23);
        return str2;
    }

    private static char getChar(byte b, int i) {
        AppMethodBeat.m2504i(24);
        char offset = (char) (b - getOffset(i & 1));
        AppMethodBeat.m2505o(24);
        return offset;
    }

    private static byte getOffset(int i) {
        return (byte) (i == 0 ? 65 : 97);
    }

    private static String encryptUid(String str) {
        AppMethodBeat.m2504i(25);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.m2505o(25);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            stringBuilder.append(charAt + (charAt % length));
        }
        stringBuilder.reverse();
        str2 = stringBuilder.toString();
        AppMethodBeat.m2505o(25);
        return str2;
    }

    private StatisticsUtils() {
    }
}
