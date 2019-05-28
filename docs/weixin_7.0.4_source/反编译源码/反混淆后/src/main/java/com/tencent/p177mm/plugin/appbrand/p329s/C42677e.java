package com.tencent.p177mm.plugin.appbrand.p329s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p328r.C45673m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.s.e */
public final class C42677e {
    private static final Set<Object> hvE = new HashSet();
    private static final String iRj = C4996ah.getPackageName();
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    static {
        AppMethodBeat.m2504i(87422);
        AppMethodBeat.m2505o(87422);
    }

    public static void aNX() {
        AppMethodBeat.m2504i(87409);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        C4996ah.getContext().sendBroadcast(intent);
        intent = new Intent();
        intent.setComponent(new ComponentName(iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        C4996ah.getContext().sendBroadcast(intent);
        AppMethodBeat.m2505o(87409);
    }

    public static long aNY() {
        AppMethodBeat.m2504i(87410);
        long anT = C5046bo.anT();
        AppMethodBeat.m2505o(87410);
        return anT;
    }

    public static String getMMString(int i, Object... objArr) {
        AppMethodBeat.m2504i(87411);
        String string = C4996ah.getResources().getString(i, objArr);
        AppMethodBeat.m2505o(87411);
        return string;
    }

    /* renamed from: bB */
    public static <T> T m75580bB(T t) {
        AppMethodBeat.m2504i(87412);
        hvE.add(t);
        AppMethodBeat.m2505o(87412);
        return t;
    }

    /* renamed from: at */
    public static void m75579at(Object obj) {
        AppMethodBeat.m2504i(87413);
        hvE.remove(obj);
        AppMethodBeat.m2505o(87413);
    }

    @Deprecated
    public static void aNR() {
        AppMethodBeat.m2504i(87414);
        C45673m.aNR();
        AppMethodBeat.m2505o(87414);
    }

    @Deprecated
    public static C5004al aNS() {
        AppMethodBeat.m2504i(87415);
        C5004al aNS = C45673m.aNS();
        AppMethodBeat.m2505o(87415);
        return aNS;
    }

    @Deprecated
    /* renamed from: d */
    public static void m75584d(Map map) {
        AppMethodBeat.m2504i(87416);
        C32192i.m52509d(map);
        AppMethodBeat.m2505o(87416);
    }

    /* renamed from: Eh */
    public static String m75577Eh(String str) {
        AppMethodBeat.m2504i(87417);
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int i2 = 0;
            while (i2 < iRk.length) {
                String str2 = iRl[i2];
                int i3 = 0;
                while (i3 < str2.length() && i + i3 < length && str2.charAt(i3) == str.charAt(i + i3)) {
                    i3++;
                }
                if (i3 == str2.length()) {
                    break;
                }
                i2++;
            }
            if (i2 != iRk.length) {
                stringBuffer.append(iRk[i2]);
                i = iRl[i2].length() + i;
            } else {
                stringBuffer.append(str.charAt(i));
                i++;
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(87417);
        return stringBuffer2;
    }

    /* renamed from: Ei */
    public static String m75578Ei(String str) {
        AppMethodBeat.m2504i(87418);
        if (str == null) {
            AppMethodBeat.m2505o(87418);
            return null;
        }
        String replace = str.replace(8232, 10).replace(8233, 10);
        AppMethodBeat.m2505o(87418);
        return replace;
    }

    /* renamed from: c */
    public static String m75582c(ComponentName componentName) {
        AppMethodBeat.m2504i(87419);
        String str = "[UNKNOWN]";
        if (componentName == null) {
            AppMethodBeat.m2505o(87419);
        } else {
            PackageManager packageManager = C4996ah.getContext().getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.m2505o(87419);
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                    if (activityInfo != null) {
                        str = activityInfo.taskAffinity;
                        AppMethodBeat.m2505o(87419);
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", e);
                }
                AppMethodBeat.m2505o(87419);
            }
        }
        return str;
    }

    /* renamed from: c */
    public static int m75581c(Context context, float f) {
        AppMethodBeat.m2504i(87420);
        int round = Math.round(context.getResources().getDisplayMetrics().density * f);
        AppMethodBeat.m2505o(87420);
        return round;
    }

    /* renamed from: cZ */
    public static float m75583cZ(Context context) {
        AppMethodBeat.m2504i(87421);
        float f = 3.0f / context.getResources().getDisplayMetrics().density;
        AppMethodBeat.m2505o(87421);
        return f;
    }
}
