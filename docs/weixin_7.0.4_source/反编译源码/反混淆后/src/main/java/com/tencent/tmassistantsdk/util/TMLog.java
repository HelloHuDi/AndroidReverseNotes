package com.tencent.tmassistantsdk.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;

public class TMLog {
    protected static boolean mDebugFlagForSDK = true;
    protected static String mDebugFlagForSDKTag = "";
    protected static boolean mHardDebugFlag = true;
    protected static HashMap<String, ArrayList<Long>> mUseTimeLongList = new HashMap();
    protected static HashMap<String, ArrayList<String>> mUseTimeStringList = new HashMap();

    static {
        AppMethodBeat.m2504i(76299);
        AppMethodBeat.m2505o(76299);
    }

    public static void setDebugLog(boolean z, String str) {
        mDebugFlagForSDK = z;
        mDebugFlagForSDKTag = str;
    }

    public static void debugV(String str) {
        AppMethodBeat.m2504i(76288);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            C4990ab.m7418v(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.m2505o(76288);
    }

    public static void debugE(String str) {
        AppMethodBeat.m2504i(76289);
        if (mDebugFlagForSDK && !TextUtils.isEmpty(mDebugFlagForSDKTag)) {
            C4990ab.m7412e(mDebugFlagForSDKTag, str);
        }
        AppMethodBeat.m2505o(76289);
    }

    public static boolean isForDebug() {
        return mHardDebugFlag;
    }

    /* renamed from: v */
    public static void m60589v(String str, String str2) {
        AppMethodBeat.m2504i(76290);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            C4990ab.m7418v(str, str2);
        }
        AppMethodBeat.m2505o(76290);
    }

    /* renamed from: i */
    public static void m60588i(String str, String str2) {
        AppMethodBeat.m2504i(76291);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            C4990ab.m7416i(str, str2);
        }
        AppMethodBeat.m2505o(76291);
    }

    /* renamed from: d */
    public static void m60586d(String str, String str2) {
        AppMethodBeat.m2504i(76292);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            C4990ab.m7410d(str, str2);
        }
        AppMethodBeat.m2505o(76292);
    }

    /* renamed from: w */
    public static void m60590w(String str, String str2) {
        AppMethodBeat.m2504i(76293);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            C4990ab.m7420w(str, str2);
        }
        AppMethodBeat.m2505o(76293);
    }

    /* renamed from: e */
    public static void m60587e(String str, String str2) {
        AppMethodBeat.m2504i(76294);
        if (isForDebug()) {
            if (str2 == null) {
                str2 = "............";
            }
            C4990ab.m7412e(str, str2);
        }
        AppMethodBeat.m2505o(76294);
    }

    public static void time(String str) {
        AppMethodBeat.m2504i(76295);
        time("UseTime", str, false);
        AppMethodBeat.m2505o(76295);
    }

    public static void time(String str, boolean z) {
        AppMethodBeat.m2504i(76296);
        time("UseTime", str, z);
        AppMethodBeat.m2505o(76296);
    }

    public static void time(String str, String str2) {
        AppMethodBeat.m2504i(76297);
        time(str, str2, false);
        AppMethodBeat.m2505o(76297);
    }

    public static void time(String str, String str2, boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(76298);
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
                C4990ab.m7418v(str, stringBuffer.toString());
                arrayList.clear();
                arrayList2.clear();
            }
            AppMethodBeat.m2505o(76298);
            return;
        }
        AppMethodBeat.m2505o(76298);
    }
}
