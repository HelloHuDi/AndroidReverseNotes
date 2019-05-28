package com.tencent.p177mm.platformtools;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.os.IBinder;
import android.os.SystemClock;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
/* renamed from: com.tencent.mm.platformtools.ah */
public final class C42252ah {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] gjH = new long[]{300, 200, 300, 200};

    /* renamed from: com.tencent.mm.platformtools.ah$1 */
    static class C265261 implements OnCancelListener {
        C265261() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.platformtools.ah$a */
    public static class C42251a {
        public final String toString() {
            AppMethodBeat.m2504i(16673);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            String str;
            if (stackTrace == null || stackTrace.length < 4) {
                str = "";
                AppMethodBeat.m2505o(16673);
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 3; i < stackTrace.length; i++) {
                if (stackTrace[i].getClassName().contains("com.tencent.mm")) {
                    stringBuilder.append("[");
                    stringBuilder.append(stackTrace[i].getClassName().substring(15));
                    stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                    stringBuilder.append(stackTrace[i].getMethodName());
                    stringBuilder.append("(" + stackTrace[i].getLineNumber() + ")]");
                }
            }
            str = stringBuilder.toString();
            AppMethodBeat.m2505o(16673);
            return str;
        }
    }

    /* renamed from: vA */
    public static String m74631vA(String str) {
        AppMethodBeat.m2504i(16674);
        if (str != null) {
            str = str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        AppMethodBeat.m2505o(16674);
        return str;
    }

    /* renamed from: c */
    public static String m74611c(List<String> list, String str) {
        AppMethodBeat.m2504i(16675);
        String str2;
        if (list == null) {
            str2 = "";
            AppMethodBeat.m2505o(16675);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (i2 == list.size() - 1) {
                    stringBuilder.append(((String) list.get(i2)).trim());
                } else {
                    stringBuilder.append(((String) list.get(i2)).trim() + str);
                }
                i = i2 + 1;
            } else {
                str2 = stringBuilder.toString();
                AppMethodBeat.m2505o(16675);
                return str2;
            }
        }
    }

    /* renamed from: j */
    public static List<String> m74626j(String[] strArr) {
        AppMethodBeat.m2504i(16676);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(16676);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        AppMethodBeat.m2505o(16676);
        return arrayList;
    }

    /* renamed from: ga */
    public static String m74622ga(long j) {
        AppMethodBeat.m2504i(16677);
        String str;
        if ((j >> 20) > 0) {
            str = (((float) Math.round((((float) j) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
            AppMethodBeat.m2505o(16677);
            return str;
        } else if ((j >> 9) > 0) {
            str = (((float) Math.round((((float) j) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
            AppMethodBeat.m2505o(16677);
            return str;
        } else {
            str = j + "B";
            AppMethodBeat.m2505o(16677);
            return str;
        }
    }

    static {
        AppMethodBeat.m2504i(16706);
        AppMethodBeat.m2505o(16706);
    }

    public static long anT() {
        AppMethodBeat.m2504i(16678);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.m2505o(16678);
        return currentTimeMillis;
    }

    /* renamed from: mK */
    public static String m74629mK(int i) {
        AppMethodBeat.m2504i(16679);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.m2505o(16679);
        return format;
    }

    public static long anU() {
        AppMethodBeat.m2504i(16680);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.m2505o(16680);
        return currentTimeMillis;
    }

    /* renamed from: fp */
    public static long m74621fp(long j) {
        AppMethodBeat.m2504i(16681);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        AppMethodBeat.m2505o(16681);
        return currentTimeMillis;
    }

    /* renamed from: gb */
    public static long m74623gb(long j) {
        AppMethodBeat.m2504i(16682);
        long currentTimeMillis = System.currentTimeMillis() - j;
        AppMethodBeat.m2505o(16682);
        return currentTimeMillis;
    }

    /* renamed from: az */
    public static long m74606az(long j) {
        AppMethodBeat.m2504i(16683);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.m2505o(16683);
        return elapsedRealtime;
    }

    /* renamed from: yz */
    public static long m74632yz() {
        AppMethodBeat.m2504i(16684);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(16684);
        return elapsedRealtime;
    }

    /* renamed from: cv */
    public static boolean m74615cv(Context context) {
        AppMethodBeat.m2504i(16685);
        String name = context.getClass().getName();
        String cc = C42252ah.m74614cc(context);
        C4990ab.m7410d("MicroMsg.Util", "top activity=" + cc + ", context=" + name);
        boolean equalsIgnoreCase = cc.equalsIgnoreCase(name);
        AppMethodBeat.m2505o(16685);
        return equalsIgnoreCase;
    }

    /* renamed from: cc */
    private static String m74614cc(Context context) {
        AppMethodBeat.m2504i(16686);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            C4990ab.m7416i("MicroMsg.Util", "top activity name =".concat(String.valueOf(className)));
            AppMethodBeat.m2505o(16686);
            return className;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.m2505o(16686);
            return className;
        }
    }

    /* renamed from: k */
    private static boolean m74627k(Context context, Intent intent) {
        AppMethodBeat.m2504i(16687);
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            AppMethodBeat.m2505o(16687);
            return true;
        }
        AppMethodBeat.m2505o(16687);
        return false;
    }

    /* renamed from: mL */
    public static boolean m74630mL(int i) {
        AppMethodBeat.m2504i(16688);
        long j = ((long) i) * 1000;
        long currentTimeMillis = j - System.currentTimeMillis();
        C4990ab.m7410d("MicroMsg.Util", "time " + j + "  systime " + System.currentTimeMillis() + " diff " + currentTimeMillis);
        if (currentTimeMillis < 0) {
            AppMethodBeat.m2505o(16688);
            return true;
        }
        AppMethodBeat.m2505o(16688);
        return false;
    }

    public static void anV() {
        AppMethodBeat.m2504i(16689);
        C4990ab.m7421w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", C42252ah.m74622ga((long) Debug.getGlobalAllocSize()), C42252ah.m74622ga((long) (Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize())), C42252ah.m74622ga((long) Debug.getGlobalExternalAllocSize()), C42252ah.m74622ga((long) (Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize())), C42252ah.m74622ga(Debug.getNativeHeapAllocatedSize()), C42252ah.m74622ga(Debug.getNativeHeapSize()));
        AppMethodBeat.m2505o(16689);
    }

    /* renamed from: h */
    public static int m74624h(Integer num) {
        AppMethodBeat.m2504i(16690);
        if (num == null) {
            AppMethodBeat.m2505o(16690);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(16690);
        return intValue;
    }

    /* renamed from: c */
    public static long m74610c(Long l) {
        AppMethodBeat.m2504i(16691);
        if (l == null) {
            AppMethodBeat.m2505o(16691);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(16691);
        return longValue;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public static boolean m74618d(Boolean bool) {
        AppMethodBeat.m2504i(16692);
        if (bool == null) {
            AppMethodBeat.m2505o(16692);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(16692);
        return booleanValue;
    }

    /* renamed from: e */
    public static boolean m74619e(Boolean bool) {
        AppMethodBeat.m2504i(16693);
        if (bool == null) {
            AppMethodBeat.m2505o(16693);
            return false;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(16693);
        return booleanValue;
    }

    /* renamed from: i */
    public static int m74625i(Integer num) {
        AppMethodBeat.m2504i(16694);
        if (num == null) {
            AppMethodBeat.m2505o(16694);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(16694);
        return intValue;
    }

    /* renamed from: d */
    public static long m74617d(Long l) {
        AppMethodBeat.m2504i(16695);
        if (l == null) {
            AppMethodBeat.m2505o(16695);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(16695);
        return longValue;
    }

    /* renamed from: f */
    public static boolean m74620f(Boolean bool) {
        AppMethodBeat.m2504i(16696);
        if (bool == null) {
            AppMethodBeat.m2505o(16696);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(16696);
        return booleanValue;
    }

    /* renamed from: bc */
    public static String m74607bc(String str, String str2) {
        return str == null ? str2 : str;
    }

    /* renamed from: bh */
    public static int m74609bh(Object obj) {
        AppMethodBeat.m2504i(16697);
        int intValue;
        if (obj == null) {
            AppMethodBeat.m2505o(16697);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.m2505o(16697);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = ((Long) obj).intValue();
            AppMethodBeat.m2505o(16697);
            return intValue;
        } else {
            AppMethodBeat.m2505o(16697);
            return 0;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.m2504i(16698);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(16698);
            return true;
        }
        AppMethodBeat.m2505o(16698);
        return false;
    }

    @Deprecated
    public static int getInt(String str, int i) {
        AppMethodBeat.m2504i(16699);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.m2505o(16699);
                    return i;
                }
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(16699);
            }
        }
        AppMethodBeat.m2505o(16699);
        return i;
    }

    @Deprecated
    /* renamed from: lb */
    public static long m74628lb(String str) {
        long j = -1;
        AppMethodBeat.m2504i(16700);
        if (str == null) {
            try {
                AppMethodBeat.m2505o(16700);
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(16700);
            }
        } else {
            j = Long.parseLong(str);
            AppMethodBeat.m2505o(16700);
        }
        return j;
    }

    /* renamed from: M */
    public static boolean m74604M(Context context, String str) {
        AppMethodBeat.m2504i(16701);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (C42252ah.m74627k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.m2505o(16701);
            return true;
        }
        C4990ab.m7412e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(16701);
        return false;
    }

    /* renamed from: cI */
    public static boolean m74612cI(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    /* renamed from: cJ */
    public static boolean m74613cJ(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static C42251a anW() {
        AppMethodBeat.m2504i(16702);
        C42251a c42251a = new C42251a();
        AppMethodBeat.m2505o(16702);
        return c42251a;
    }

    /* renamed from: bd */
    public static List<String> m74608bd(String str, String str2) {
        AppMethodBeat.m2504i(16703);
        List<String> list = null;
        if (str != null) {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            int groupCount = matcher.groupCount();
            list = new ArrayList();
            if (matcher.find()) {
                for (int i = 1; i <= groupCount; i++) {
                    list.add(matcher.group(i));
                }
            }
        }
        AppMethodBeat.m2505o(16703);
        return list;
    }

    /* renamed from: cw */
    public static boolean m74616cw(Context context) {
        AppMethodBeat.m2504i(16704);
        if (C21429d.bQU() != null) {
            C21429d.bQU().bQS();
        }
        if ((C5059g.cdh & 1) != 0) {
            C4990ab.m7412e("MicroMsg.Util", "package has set external update mode");
            Uri parse = Uri.parse(C5059g.xyc);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
            if (parse == null || addFlags == null || !C42252ah.m74627k(context, addFlags)) {
                C4990ab.m7412e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
            } else {
                C4990ab.m7416i("MicroMsg.Util", "parse market uri ok");
                context.startActivity(addFlags);
            }
            AppMethodBeat.m2505o(16704);
            return true;
        }
        C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000).commit();
        if (C21429d.bQU() != null) {
            C21426a c = C21429d.bQU().mo36878c(context, new C265261());
            if (c == null) {
                AppMethodBeat.m2505o(16704);
                return false;
            }
            c.update(3);
        }
        AppMethodBeat.m2505o(16704);
        return true;
    }

    /* renamed from: a */
    public static boolean m74605a(Context context, View view) {
        AppMethodBeat.m2504i(16705);
        if (view == null) {
            AppMethodBeat.m2505o(16705);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.m2505o(16705);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.m2505o(16705);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            C4990ab.m7413e("MicroMsg.Util", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.m2505o(16705);
        return hideSoftInputFromWindow;
    }
}
