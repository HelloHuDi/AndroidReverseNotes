package com.tencent.liteav.basic.module;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class TXCStatus {
    private static native double nativeStatusGetDoubleValue(String str, int i);

    private static native long nativeStatusGetIntValue(String str, int i);

    private static native String nativeStatusGetStrValue(String str, int i);

    private static native boolean nativeStatusSetDoubleValue(String str, int i, double d);

    private static native boolean nativeStatusSetIntValue(String str, int i, long j);

    private static native boolean nativeStatusSetStrValue(String str, int i, String str2);

    private static native void nativeStatusStartRecord(String str);

    private static native void nativeStatusStopRecord(String str);

    /* renamed from: a */
    public static void m40651a(String str) {
        AppMethodBeat.m2504i(66068);
        nativeStatusStartRecord(str);
        AppMethodBeat.m2505o(66068);
    }

    /* renamed from: b */
    public static void m40654b(String str) {
        AppMethodBeat.m2504i(66069);
        nativeStatusStopRecord(str);
        AppMethodBeat.m2505o(66069);
    }

    /* renamed from: a */
    public static boolean m40652a(String str, int i, Object obj) {
        AppMethodBeat.m2504i(66070);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(66070);
            return false;
        } else if (obj == null) {
            AppMethodBeat.m2505o(66070);
            return false;
        } else {
            boolean nativeStatusSetDoubleValue;
            switch (i) {
                case 1001:
                case 3003:
                case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                case 6002:
                    if (obj instanceof Double) {
                        nativeStatusSetDoubleValue = nativeStatusSetDoubleValue(str, i, ((Double) obj).doubleValue());
                        AppMethodBeat.m2505o(66070);
                        return nativeStatusSetDoubleValue;
                    }
                    break;
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
                case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
                case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
                case 2008:
                case 2010:
                case 2011:
                case 2012:
                case 2013:
                case 2014:
                case 2015:
                case 3002:
                case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
                case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
                case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
                case ReaderCallback.SHOW_BAR /*5002*/:
                case 6001:
                case 6003:
                case 6004:
                case 6005:
                case 6006:
                case 6007:
                case 6008:
                case 6009:
                case 7112:
                    if (obj instanceof Long) {
                        nativeStatusSetDoubleValue = nativeStatusSetIntValue(str, i, ((Long) obj).longValue());
                        AppMethodBeat.m2505o(66070);
                        return nativeStatusSetDoubleValue;
                    }
                    break;
                case 3001:
                case 7012:
                case 7014:
                case 7015:
                case 7019:
                case 7106:
                case 7110:
                case 7113:
                case 7114:
                case 7115:
                case 7119:
                    if (obj instanceof String) {
                        nativeStatusSetDoubleValue = nativeStatusSetStrValue(str, i, (String) obj);
                        AppMethodBeat.m2505o(66070);
                        return nativeStatusSetDoubleValue;
                    }
                    break;
                case 7001:
                case 7002:
                case 7003:
                case 7004:
                case 7005:
                case 7006:
                case 7007:
                case 7008:
                case 7009:
                case 7010:
                case 7011:
                case 7013:
                case 7016:
                case 7017:
                case 7018:
                case 7020:
                case 7101:
                case 7102:
                case 7103:
                case 7104:
                case 7105:
                case 7107:
                case 7108:
                case 7109:
                case 7111:
                case 7116:
                case 7117:
                case 7118:
                    if (obj instanceof Long) {
                        nativeStatusSetDoubleValue = nativeStatusSetIntValue(str, i, ((Long) obj).longValue());
                        AppMethodBeat.m2505o(66070);
                        return nativeStatusSetDoubleValue;
                    }
                    break;
            }
            AppMethodBeat.m2505o(66070);
            return false;
        }
    }

    /* renamed from: a */
    public static Object m40650a(String str, int i) {
        AppMethodBeat.m2504i(66071);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(66071);
            return null;
        }
        Object valueOf;
        switch (i) {
            case 1001:
            case 3003:
            case WearableStatusCodes.DUPLICATE_LISTENER /*4001*/:
            case ReaderCallback.HIDDEN_BAR /*5001*/:
            case 6002:
                valueOf = Double.valueOf(nativeStatusGetDoubleValue(str, i));
                AppMethodBeat.m2505o(66071);
                return valueOf;
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case TXLiveConstants.PLAY_EVT_PLAY_PROGRESS /*2005*/:
            case TXLiveConstants.PLAY_EVT_PLAY_END /*2006*/:
            case TXLiveConstants.PLAY_EVT_PLAY_LOADING /*2007*/:
            case 2008:
            case 2010:
            case 2011:
            case 2012:
            case 2013:
            case 2014:
            case 2015:
            case 3002:
            case WearableStatusCodes.UNKNOWN_LISTENER /*4002*/:
            case WearableStatusCodes.DATA_ITEM_TOO_LARGE /*4003*/:
            case WearableStatusCodes.INVALID_TARGET_NODE /*4004*/:
            case ReaderCallback.SHOW_BAR /*5002*/:
            case 6001:
            case 6003:
            case 6004:
            case 6005:
            case 6006:
            case 6007:
            case 6008:
            case 6009:
            case 7112:
                valueOf = Long.valueOf(nativeStatusGetIntValue(str, i));
                AppMethodBeat.m2505o(66071);
                return valueOf;
            case 3001:
            case 7012:
            case 7014:
            case 7015:
            case 7019:
            case 7106:
            case 7110:
            case 7113:
            case 7114:
            case 7115:
            case 7119:
                valueOf = nativeStatusGetStrValue(str, i);
                AppMethodBeat.m2505o(66071);
                return valueOf;
            case 7001:
            case 7002:
            case 7003:
            case 7004:
            case 7005:
            case 7006:
            case 7007:
            case 7008:
            case 7009:
            case 7010:
            case 7011:
            case 7013:
            case 7016:
            case 7017:
            case 7018:
            case 7020:
            case 7101:
            case 7102:
            case 7103:
            case 7104:
            case 7105:
            case 7107:
            case 7108:
            case 7109:
            case 7111:
            case 7116:
            case 7117:
            case 7118:
                valueOf = Long.valueOf(nativeStatusGetIntValue(str, i));
                AppMethodBeat.m2505o(66071);
                return valueOf;
            default:
                AppMethodBeat.m2505o(66071);
                return null;
        }
    }

    /* renamed from: b */
    public static long m40653b(String str, int i) {
        long j;
        AppMethodBeat.m2504i(66072);
        Object a = m40650a(str, i);
        if (a == null || !(a instanceof Long)) {
            j = 0;
        } else {
            j = ((Long) a).longValue();
        }
        AppMethodBeat.m2505o(66072);
        return j;
    }

    /* renamed from: c */
    public static String m40655c(String str, int i) {
        String str2;
        AppMethodBeat.m2504i(66073);
        String str3 = "";
        Object a = m40650a(str, i);
        if (a == null || !(a instanceof String)) {
            str2 = str3;
        } else {
            str2 = (String) a;
        }
        AppMethodBeat.m2505o(66073);
        return str2;
    }

    /* renamed from: d */
    public static int m40656d(String str, int i) {
        int i2;
        AppMethodBeat.m2504i(66074);
        Object a = m40650a(str, i);
        if (a == null || !(a instanceof Long)) {
            i2 = 0;
        } else {
            i2 = ((Long) a).intValue();
        }
        AppMethodBeat.m2505o(66074);
        return i2;
    }

    /* renamed from: e */
    public static double m40657e(String str, int i) {
        double d;
        AppMethodBeat.m2504i(66075);
        Object a = m40650a(str, i);
        if (a == null || !(a instanceof Double)) {
            d = 0.0d;
        } else {
            d = ((Double) a).doubleValue();
        }
        AppMethodBeat.m2505o(66075);
        return d;
    }
}
