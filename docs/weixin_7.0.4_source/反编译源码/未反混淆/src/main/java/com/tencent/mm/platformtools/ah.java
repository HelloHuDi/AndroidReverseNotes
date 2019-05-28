package com.tencent.mm.platformtools;

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
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Deprecated
public final class ah {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] gjH = new long[]{300, 200, 300, 200};

    public static class a {
        public final String toString() {
            AppMethodBeat.i(16673);
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            String str;
            if (stackTrace == null || stackTrace.length < 4) {
                str = "";
                AppMethodBeat.o(16673);
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
            AppMethodBeat.o(16673);
            return str;
        }
    }

    public static String vA(String str) {
        AppMethodBeat.i(16674);
        if (str != null) {
            str = str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        AppMethodBeat.o(16674);
        return str;
    }

    public static String c(List<String> list, String str) {
        AppMethodBeat.i(16675);
        String str2;
        if (list == null) {
            str2 = "";
            AppMethodBeat.o(16675);
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
                AppMethodBeat.o(16675);
                return str2;
            }
        }
    }

    public static List<String> j(String[] strArr) {
        AppMethodBeat.i(16676);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(16676);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        AppMethodBeat.o(16676);
        return arrayList;
    }

    public static String ga(long j) {
        AppMethodBeat.i(16677);
        String str;
        if ((j >> 20) > 0) {
            str = (((float) Math.round((((float) j) * 10.0f) / 1048576.0f)) / 10.0f) + "MB";
            AppMethodBeat.o(16677);
            return str;
        } else if ((j >> 9) > 0) {
            str = (((float) Math.round((((float) j) * 10.0f) / 1024.0f)) / 10.0f) + "KB";
            AppMethodBeat.o(16677);
            return str;
        } else {
            str = j + "B";
            AppMethodBeat.o(16677);
            return str;
        }
    }

    static {
        AppMethodBeat.i(16706);
        AppMethodBeat.o(16706);
    }

    public static long anT() {
        AppMethodBeat.i(16678);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(16678);
        return currentTimeMillis;
    }

    public static String mK(int i) {
        AppMethodBeat.i(16679);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.o(16679);
        return format;
    }

    public static long anU() {
        AppMethodBeat.i(16680);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(16680);
        return currentTimeMillis;
    }

    public static long fp(long j) {
        AppMethodBeat.i(16681);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        AppMethodBeat.o(16681);
        return currentTimeMillis;
    }

    public static long gb(long j) {
        AppMethodBeat.i(16682);
        long currentTimeMillis = System.currentTimeMillis() - j;
        AppMethodBeat.o(16682);
        return currentTimeMillis;
    }

    public static long az(long j) {
        AppMethodBeat.i(16683);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.o(16683);
        return elapsedRealtime;
    }

    public static long yz() {
        AppMethodBeat.i(16684);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(16684);
        return elapsedRealtime;
    }

    public static boolean cv(Context context) {
        AppMethodBeat.i(16685);
        String name = context.getClass().getName();
        String cc = cc(context);
        ab.d("MicroMsg.Util", "top activity=" + cc + ", context=" + name);
        boolean equalsIgnoreCase = cc.equalsIgnoreCase(name);
        AppMethodBeat.o(16685);
        return equalsIgnoreCase;
    }

    private static String cc(Context context) {
        AppMethodBeat.i(16686);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            ab.i("MicroMsg.Util", "top activity name =".concat(String.valueOf(className)));
            AppMethodBeat.o(16686);
            return className;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.o(16686);
            return className;
        }
    }

    private static boolean k(Context context, Intent intent) {
        AppMethodBeat.i(16687);
        if (context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0) {
            AppMethodBeat.o(16687);
            return true;
        }
        AppMethodBeat.o(16687);
        return false;
    }

    public static boolean mL(int i) {
        AppMethodBeat.i(16688);
        long j = ((long) i) * 1000;
        long currentTimeMillis = j - System.currentTimeMillis();
        ab.d("MicroMsg.Util", "time " + j + "  systime " + System.currentTimeMillis() + " diff " + currentTimeMillis);
        if (currentTimeMillis < 0) {
            AppMethodBeat.o(16688);
            return true;
        }
        AppMethodBeat.o(16688);
        return false;
    }

    public static void anV() {
        AppMethodBeat.i(16689);
        ab.w("MicroMsg.Util", "memory usage: h=%s/%s, e=%s/%s, n=%s/%s", ga((long) Debug.getGlobalAllocSize()), ga((long) (Debug.getGlobalAllocSize() + Debug.getGlobalFreedSize())), ga((long) Debug.getGlobalExternalAllocSize()), ga((long) (Debug.getGlobalExternalAllocSize() + Debug.getGlobalExternalFreedSize())), ga(Debug.getNativeHeapAllocatedSize()), ga(Debug.getNativeHeapSize()));
        AppMethodBeat.o(16689);
    }

    public static int h(Integer num) {
        AppMethodBeat.i(16690);
        if (num == null) {
            AppMethodBeat.o(16690);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(16690);
        return intValue;
    }

    public static long c(Long l) {
        AppMethodBeat.i(16691);
        if (l == null) {
            AppMethodBeat.o(16691);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(16691);
        return longValue;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static boolean d(Boolean bool) {
        AppMethodBeat.i(16692);
        if (bool == null) {
            AppMethodBeat.o(16692);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(16692);
        return booleanValue;
    }

    public static boolean e(Boolean bool) {
        AppMethodBeat.i(16693);
        if (bool == null) {
            AppMethodBeat.o(16693);
            return false;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(16693);
        return booleanValue;
    }

    public static int i(Integer num) {
        AppMethodBeat.i(16694);
        if (num == null) {
            AppMethodBeat.o(16694);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(16694);
        return intValue;
    }

    public static long d(Long l) {
        AppMethodBeat.i(16695);
        if (l == null) {
            AppMethodBeat.o(16695);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(16695);
        return longValue;
    }

    public static boolean f(Boolean bool) {
        AppMethodBeat.i(16696);
        if (bool == null) {
            AppMethodBeat.o(16696);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(16696);
        return booleanValue;
    }

    public static String bc(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int bh(Object obj) {
        AppMethodBeat.i(16697);
        int intValue;
        if (obj == null) {
            AppMethodBeat.o(16697);
            return 0;
        } else if (obj instanceof Integer) {
            intValue = ((Integer) obj).intValue();
            AppMethodBeat.o(16697);
            return intValue;
        } else if (obj instanceof Long) {
            intValue = ((Long) obj).intValue();
            AppMethodBeat.o(16697);
            return intValue;
        } else {
            AppMethodBeat.o(16697);
            return 0;
        }
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(16698);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(16698);
            return true;
        }
        AppMethodBeat.o(16698);
        return false;
    }

    @Deprecated
    public static int getInt(String str, int i) {
        AppMethodBeat.i(16699);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.o(16699);
                    return i;
                }
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(16699);
            }
        }
        AppMethodBeat.o(16699);
        return i;
    }

    @Deprecated
    public static long lb(String str) {
        long j = -1;
        AppMethodBeat.i(16700);
        if (str == null) {
            try {
                AppMethodBeat.o(16700);
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(16700);
            }
        } else {
            j = Long.parseLong(str);
            AppMethodBeat.o(16700);
        }
        return j;
    }

    public static boolean M(Context context, String str) {
        AppMethodBeat.i(16701);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.o(16701);
            return true;
        }
        ab.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(str)));
        AppMethodBeat.o(16701);
        return false;
    }

    public static boolean cI(int i, int i2) {
        return ((double) i2) > ((double) i) * 2.0d;
    }

    public static boolean cJ(int i, int i2) {
        return ((double) i) > ((double) i2) * 2.0d;
    }

    public static a anW() {
        AppMethodBeat.i(16702);
        a aVar = new a();
        AppMethodBeat.o(16702);
        return aVar;
    }

    public static List<String> bd(String str, String str2) {
        AppMethodBeat.i(16703);
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
        AppMethodBeat.o(16703);
        return list;
    }

    public static boolean cw(Context context) {
        AppMethodBeat.i(16704);
        if (d.bQU() != null) {
            d.bQU().bQS();
        }
        if ((g.cdh & 1) != 0) {
            ab.e("MicroMsg.Util", "package has set external update mode");
            Uri parse = Uri.parse(g.xyc);
            Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
            if (parse == null || addFlags == null || !k(context, addFlags)) {
                ab.e("MicroMsg.Util", "parse market uri failed, jump to weixin.qq.com");
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
            } else {
                ab.i("MicroMsg.Util", "parse market uri ok");
                context.startActivity(addFlags);
            }
            AppMethodBeat.o(16704);
            return true;
        }
        com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", System.currentTimeMillis() / 1000).commit();
        if (d.bQU() != null) {
            com.tencent.mm.plugin.p.a c = d.bQU().c(context, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            if (c == null) {
                AppMethodBeat.o(16704);
                return false;
            }
            c.update(3);
        }
        AppMethodBeat.o(16704);
        return true;
    }

    public static boolean a(Context context, View view) {
        AppMethodBeat.i(16705);
        if (view == null) {
            AppMethodBeat.o(16705);
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
        if (inputMethodManager == null) {
            AppMethodBeat.o(16705);
            return false;
        }
        IBinder windowToken = view.getWindowToken();
        if (windowToken == null) {
            AppMethodBeat.o(16705);
            return false;
        }
        boolean hideSoftInputFromWindow;
        try {
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(windowToken, 0);
        } catch (IllegalArgumentException e) {
            ab.e("MicroMsg.Util", "hide VKB(View) exception %s", e);
            hideSoftInputFromWindow = false;
        }
        AppMethodBeat.o(16705);
        return hideSoftInputFromWindow;
    }
}
