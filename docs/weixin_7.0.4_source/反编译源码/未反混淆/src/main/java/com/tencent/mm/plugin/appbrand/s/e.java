package com.tencent.mm.plugin.appbrand.s;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e {
    private static final Set<Object> hvE = new HashSet();
    private static final String iRj = ah.getPackageName();
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', ' ', '\''};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    static {
        AppMethodBeat.i(87422);
        AppMethodBeat.o(87422);
    }

    public static void aNX() {
        AppMethodBeat.i(87409);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(iRj, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ah.getContext().sendBroadcast(intent);
        intent = new Intent();
        intent.setComponent(new ComponentName(iRj, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        ah.getContext().sendBroadcast(intent);
        AppMethodBeat.o(87409);
    }

    public static long aNY() {
        AppMethodBeat.i(87410);
        long anT = bo.anT();
        AppMethodBeat.o(87410);
        return anT;
    }

    public static String getMMString(int i, Object... objArr) {
        AppMethodBeat.i(87411);
        String string = ah.getResources().getString(i, objArr);
        AppMethodBeat.o(87411);
        return string;
    }

    public static <T> T bB(T t) {
        AppMethodBeat.i(87412);
        hvE.add(t);
        AppMethodBeat.o(87412);
        return t;
    }

    public static void at(Object obj) {
        AppMethodBeat.i(87413);
        hvE.remove(obj);
        AppMethodBeat.o(87413);
    }

    @Deprecated
    public static void aNR() {
        AppMethodBeat.i(87414);
        m.aNR();
        AppMethodBeat.o(87414);
    }

    @Deprecated
    public static al aNS() {
        AppMethodBeat.i(87415);
        al aNS = m.aNS();
        AppMethodBeat.o(87415);
        return aNS;
    }

    @Deprecated
    public static void d(Map map) {
        AppMethodBeat.i(87416);
        i.d(map);
        AppMethodBeat.o(87416);
    }

    public static String Eh(String str) {
        AppMethodBeat.i(87417);
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
        AppMethodBeat.o(87417);
        return stringBuffer2;
    }

    public static String Ei(String str) {
        AppMethodBeat.i(87418);
        if (str == null) {
            AppMethodBeat.o(87418);
            return null;
        }
        String replace = str.replace(8232, 10).replace(8233, 10);
        AppMethodBeat.o(87418);
        return replace;
    }

    public static String c(ComponentName componentName) {
        AppMethodBeat.i(87419);
        String str = "[UNKNOWN]";
        if (componentName == null) {
            AppMethodBeat.o(87419);
        } else {
            PackageManager packageManager = ah.getContext().getPackageManager();
            if (packageManager == null) {
                AppMethodBeat.o(87419);
            } else {
                try {
                    ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                    if (activityInfo != null) {
                        str = activityInfo.taskAffinity;
                        AppMethodBeat.o(87419);
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", e);
                }
                AppMethodBeat.o(87419);
            }
        }
        return str;
    }

    public static int c(Context context, float f) {
        AppMethodBeat.i(87420);
        int round = Math.round(context.getResources().getDisplayMetrics().density * f);
        AppMethodBeat.o(87420);
        return round;
    }

    public static float cZ(Context context) {
        AppMethodBeat.i(87421);
        float f = 3.0f / context.getResources().getDisplayMetrics().density;
        AppMethodBeat.o(87421);
        return f;
    }
}
