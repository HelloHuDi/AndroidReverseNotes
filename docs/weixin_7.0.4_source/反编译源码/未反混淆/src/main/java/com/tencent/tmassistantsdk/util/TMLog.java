package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;

public class TMLog {
    protected static boolean mDebugFlagForSDK = true;
    protected static String mDebugFlagForSDKTag = "";
    protected static boolean mHardDebugFlag = true;
    protected static HashMap<String, ArrayList<Long>> mUseTimeLongList = new HashMap();
    protected static HashMap<String, ArrayList<String>> mUseTimeStringList = new HashMap();

    static {
        AppMethodBeat.i(76299);
        AppMethodBeat.o(76299);
    }

    public static void setDebugLog(boolean z, String str) {
        mDebugFlagForSDK = z;
        mDebugFlagForSDKTag = str;
    }

    public static void debugV(String str) {
        AppMethodBeat.i(76288);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            ab.v(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.o(76288);
    }

    public static void debugE(String str) {
        AppMethodBeat.i(76289);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            ab.e(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.o(76289);
    }

    public static boolean isForDebug() {
        return mHardDebugFlag;
    }

    public static void v(String str, String str2) {
        AppMethodBeat.i(76290);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            ab.v(str, str2);
        }
        AppMethodBeat.o(76290);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(76291);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            ab.i(str, str2);
        }
        AppMethodBeat.o(76291);
    }

    public static void d(String str, String str2) {
        AppMethodBeat.i(76292);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            ab.d(str, str2);
        }
        AppMethodBeat.o(76292);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(76293);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            ab.w(str, str2);
        }
        AppMethodBeat.o(76293);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(76294);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            ab.e(str, str2);
        }
        AppMethodBeat.o(76294);
    }

    public static void time(String str) {
        AppMethodBeat.i(76295);
        time("UseTime", str, false);
        AppMethodBeat.o(76295);
    }

    public static void time(String str, boolean z) {
        AppMethodBeat.i(76296);
        time("UseTime", str, z);
        AppMethodBeat.o(76296);
    }

    public static void time(String str, String str2) {
        AppMethodBeat.i(76297);
        time(str, str2, false);
        AppMethodBeat.o(76297);
    }

    public static void time(String str, String str2, boolean z) {
        int i = 0;
        AppMethodBeat.i(76298);
        if (isForDebug()) {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3 = (ArrayList) mUseTimeStringList.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                mUseTimeStringList.put(str, arrayList3);
                arrayList = arrayList3;
            } else {
                arrayList = arrayList3;
            }
            arrayList.add(str2);
            arrayList3 = (ArrayList) mUseTimeLongList.get(str);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList();
                mUseTimeLongList.put(str, arrayList3);
                arrayList2 = arrayList3;
            } else {
                arrayList2 = arrayList3;
            }
            arrayList2.add(Long.valueOf(System.currentTimeMillis()));
            if (z) {
                StringBuffer stringBuffer = new StringBuffer();
                long longValue = ((Long) arrayList2.get(0)).longValue();
                stringBuffer.append("total time:");
                stringBuffer.append(((Long) arrayList2.get(arrayList2.size() - 1)).longValue() - longValue);
                stringBuffer.append(" ");
                while (i < arrayList.size()) {
                    stringBuffer.append(((Long) arrayList2.get(i)).longValue() - longValue);
                    longValue = ((Long) arrayList2.get(i)).longValue();
                    stringBuffer.append(" ");
                    stringBuffer.append((String) arrayList.get(i));
                    stringBuffer.append(" ");
                    i++;
                }
                ab.v(str, stringBuffer.toString());
                arrayList.clear();
                arrayList2.clear();
            }
            AppMethodBeat.o(76298);
            return;
        }
        AppMethodBeat.o(76298);
    }
}
