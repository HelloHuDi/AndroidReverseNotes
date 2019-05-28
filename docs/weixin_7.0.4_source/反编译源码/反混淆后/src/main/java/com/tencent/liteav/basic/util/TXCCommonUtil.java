package com.tencent.liteav.basic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXCCommonUtil {
    private static String mAppID = "";
    private static String mStrAppVersion = "";
    public static String pituLicencePath = "YTFaceSDK.licence";

    private static native int nativeGetSDKID();

    private static native String nativeGetSDKVersion();

    static {
        AppMethodBeat.m2504i(66029);
        C17778b.m27756e();
        AppMethodBeat.m2505o(66029);
    }

    public static int[] getSDKVersion() {
        AppMethodBeat.m2504i(66023);
        String[] split = nativeGetSDKVersion().split("\\.");
        int[] iArr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                iArr[i] = Integer.parseInt(split[i]);
            } catch (NumberFormatException e) {
                iArr[i] = 0;
            }
        }
        AppMethodBeat.m2505o(66023);
        return iArr;
    }

    public static String getSDKVersionStr() {
        AppMethodBeat.m2504i(66024);
        String nativeGetSDKVersion = nativeGetSDKVersion();
        AppMethodBeat.m2505o(66024);
        return nativeGetSDKVersion;
    }

    public static int getSDKID() {
        AppMethodBeat.m2504i(66025);
        int nativeGetSDKID = nativeGetSDKID();
        AppMethodBeat.m2505o(66025);
        return nativeGetSDKID;
    }

    public static String getFileExtension(String str) {
        AppMethodBeat.m2504i(66026);
        String str2 = null;
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf(46);
            if (lastIndexOf >= 0 && lastIndexOf < str.length() - 1) {
                str2 = str.substring(lastIndexOf + 1);
            }
        }
        AppMethodBeat.m2505o(66026);
        return str2;
    }

    public static void sleep(int i) {
        AppMethodBeat.m2504i(66027);
        try {
            Thread.sleep((long) i);
            AppMethodBeat.m2505o(66027);
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(66027);
        }
    }

    public static String getStreamIDByStreamUrl(String str) {
        AppMethodBeat.m2504i(66028);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(66028);
            return null;
        }
        String substring;
        int indexOf = str.indexOf("?");
        if (indexOf != -1) {
            substring = str.substring(0, indexOf);
        } else {
            substring = str;
        }
        if (substring == null || substring.length() == 0) {
            AppMethodBeat.m2505o(66028);
            return null;
        }
        int lastIndexOf = substring.lastIndexOf("/");
        if (lastIndexOf != -1) {
            substring = substring.substring(lastIndexOf + 1);
        }
        if (substring == null || substring.length() == 0) {
            AppMethodBeat.m2505o(66028);
            return null;
        }
        lastIndexOf = substring.indexOf(".");
        if (lastIndexOf != -1) {
            substring = substring.substring(0, lastIndexOf);
        }
        if (substring == null || substring.length() == 0) {
            AppMethodBeat.m2505o(66028);
            return null;
        }
        AppMethodBeat.m2505o(66028);
        return substring;
    }

    public static void setAppVersion(String str) {
        mStrAppVersion = str;
    }

    public static void setPituLicencePath(String str) {
        pituLicencePath = str;
    }

    public static String getAppVersion() {
        return mStrAppVersion;
    }

    public static void setAppID(String str) {
        mAppID = str;
    }

    public static String getAppID() {
        return mAppID;
    }
}
