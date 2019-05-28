package com.tencent.tencentmap.mapsdk.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.ag;
import com.tencent.tencentmap.mapsdk.maps.a.an;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class a {
    protected static String a = null;
    public static boolean b = false;
    private static String c = null;
    private static String d = null;
    private static Boolean e = null;
    private static int f = 0;
    private static String g = "";

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0119 A:{SYNTHETIC, Splitter:B:65:0x0119} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized String a(Context context) {
        String str;
        Throwable th;
        InputStream inputStream;
        synchronized (a.class) {
            AppMethodBeat.i(97744);
            if (context == null) {
                str = "";
                AppMethodBeat.o(97744);
            } else {
                Object string;
                String str2 = "";
                AssetManager assets = context.getAssets();
                InputStream inputStream2;
                try {
                    string = context.getSharedPreferences("DENGTA_META", 0).getString("key_channelpath", "");
                    if (string.equals("")) {
                        string = "channel.ini";
                        context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", string).commit();
                    }
                    ag.a("channel path!! ".concat(String.valueOf(string)), new Object[0]);
                    if (string.equals("")) {
                        inputStream2 = null;
                    } else {
                        inputStream2 = assets.open(string);
                        try {
                            Properties properties = new Properties();
                            properties.load(inputStream2);
                            str = properties.getProperty("CHANNEL", "");
                            try {
                                ag.a("channel !! ".concat(String.valueOf(str)), new Object[0]);
                                if ("".equals(str)) {
                                    str2 = str;
                                } else {
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e) {
                                            ag.a(e);
                                        }
                                    }
                                    AppMethodBeat.o(97744);
                                }
                            } catch (Exception e2) {
                                str2 = str;
                            }
                        } catch (Exception e3) {
                        }
                    }
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                            str = str2;
                        } catch (IOException e4) {
                            ag.a(e4);
                            str = str2;
                        }
                        string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (string != null) {
                            str = string.toString();
                        }
                        AppMethodBeat.o(97744);
                    }
                } catch (Exception e5) {
                    inputStream2 = null;
                    try {
                        context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", "").commit();
                        ag.c("get app channel fail!", new Object[0]);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                str = str2;
                            } catch (IOException e42) {
                                ag.a(e42);
                                str = str2;
                            }
                            string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                            if (string != null) {
                            }
                            AppMethodBeat.o(97744);
                            return str;
                        }
                        str = str2;
                        string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (string != null) {
                        }
                        AppMethodBeat.o(97744);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e422) {
                                ag.a(e422);
                            }
                        }
                        AppMethodBeat.o(97744);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(97744);
                    throw th;
                }
                str = str2;
                try {
                    string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (string != null) {
                    }
                } catch (Throwable th4) {
                    ag.a("no channel !!", new Object[0]);
                }
                AppMethodBeat.o(97744);
            }
        }
        return str;
    }

    public static synchronized boolean b(Context context) {
        boolean z;
        Throwable e;
        boolean z2 = false;
        synchronized (a.class) {
            AppMethodBeat.i(97745);
            if (context == null) {
                ag.d("context == null return null", new Object[0]);
                AppMethodBeat.o(97745);
            } else {
                try {
                    String string = context.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
                    String d = an.d();
                    if (string == null || !string.equals(d)) {
                        z = true;
                        try {
                            Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                            edit.putString("APPKEY_DENGTA", d);
                            edit.commit();
                            z2 = true;
                        } catch (Exception e2) {
                            e = e2;
                            ag.b("updateLocalAPPKEY fail!", new Object[0]);
                            ag.a(e);
                            z2 = z;
                            AppMethodBeat.o(97745);
                            return z2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    ag.b("updateLocalAPPKEY fail!", new Object[0]);
                    ag.a(e);
                    z2 = z;
                    AppMethodBeat.o(97745);
                    return z2;
                }
                AppMethodBeat.o(97745);
            }
        }
        return z2;
    }

    public static boolean c(Context context) {
        boolean z;
        Throwable e;
        boolean z2 = false;
        AppMethodBeat.i(97746);
        if (context == null) {
            ag.d("context == null return null", new Object[0]);
            AppMethodBeat.o(97746);
        } else {
            try {
                String string = context.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
                String j = j(context);
                if (string == null || !string.equals(j)) {
                    z = true;
                    try {
                        Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                        edit.putString("APPVER_DENGTA", j);
                        edit.commit();
                        z2 = true;
                    } catch (Exception e2) {
                        e = e2;
                        ag.b("updateLocalAPPKEY fail!", new Object[0]);
                        ag.a(e);
                        z2 = z;
                        AppMethodBeat.o(97746);
                        return z2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                ag.b("updateLocalAPPKEY fail!", new Object[0]);
                ag.a(e);
                z2 = z;
                AppMethodBeat.o(97746);
                return z2;
            }
            AppMethodBeat.o(97746);
        }
        return z2;
    }

    public static String d(Context context) {
        AppMethodBeat.i(97747);
        if (context == null) {
            AppMethodBeat.o(97747);
            return null;
        }
        String packageName = context.getPackageName();
        AppMethodBeat.o(97747);
        return packageName;
    }

    public static String e(Context context) {
        AppMethodBeat.i(97748);
        if (c == null) {
            c = j(context);
        }
        String str = c;
        AppMethodBeat.o(97748);
        return str;
    }

    private static synchronized String j(Context context) {
        String valueOf;
        synchronized (a.class) {
            AppMethodBeat.i(97749);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context == null ? null : context.getPackageName(), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                if (str == null || str.trim().length() <= 0) {
                    valueOf = String.valueOf(i);
                    AppMethodBeat.o(97749);
                } else {
                    str = str.trim().replace(10, ' ').replace(13, ' ').replace("|", "%7C");
                    char[] toCharArray = str.toCharArray();
                    int i2 = 0;
                    for (char c : toCharArray) {
                        if (c == '.') {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        ag.a("add versionCode: %s", Integer.valueOf(i));
                        valueOf = str + "." + i;
                    } else {
                        valueOf = str;
                    }
                    ag.a("version: %s", valueOf);
                    AppMethodBeat.o(97749);
                }
            } catch (Exception e) {
                ag.a(e);
                ag.d(e.toString(), new Object[0]);
                valueOf = "";
                AppMethodBeat.o(97749);
            }
        }
        return valueOf;
    }

    public static void a(String str) {
        AppMethodBeat.i(97750);
        synchronized (a.class) {
            try {
                a = str;
            } catch (Throwable th) {
                AppMethodBeat.o(97750);
            }
        }
        c m = c.m();
        if (m != null) {
            m.a(str);
        }
        AppMethodBeat.o(97750);
    }

    public static synchronized boolean f(Context context) {
        boolean booleanValue;
        synchronized (a.class) {
            AppMethodBeat.i(97751);
            ag.b("Read phone state permission check! start ", new Object[0]);
            if (e == null) {
                e = Boolean.valueOf(d(context, "android.permission.READ_PHONE_STATE"));
            }
            booleanValue = e.booleanValue();
            AppMethodBeat.o(97751);
        }
        return booleanValue;
    }

    public static boolean g(Context context) {
        AppMethodBeat.i(97752);
        boolean e = e(context, context.getPackageName());
        AppMethodBeat.o(97752);
        return e;
    }

    public static String a() {
        AppMethodBeat.i(97753);
        String str;
        if ("".equals(g)) {
            try {
                if (f == 0) {
                    f = Process.myPid();
                }
                g += f + "_";
                g += new Date().getTime();
            } catch (Exception e) {
            }
            str = g;
            AppMethodBeat.o(97753);
            return str;
        }
        str = g;
        AppMethodBeat.o(97753);
        return str;
    }

    public static int h(Context context) {
        AppMethodBeat.i(97754);
        try {
            if (f == 0) {
                f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    int i = runningAppProcessInfo.importance;
                    AppMethodBeat.o(97754);
                    return i;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(97754);
        return 0;
    }

    public static boolean a(Context context, int i) {
        AppMethodBeat.i(97755);
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0].equals(i(context).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0])) {
                    AppMethodBeat.o(97755);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(97755);
        return false;
    }

    public static String i(Context context) {
        AppMethodBeat.i(97756);
        String str;
        if (d != null) {
            str = d;
            AppMethodBeat.o(97756);
            return str;
        }
        try {
            if (f == 0) {
                f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f) {
                    str = runningAppProcessInfo.processName;
                    d = str;
                    AppMethodBeat.o(97756);
                    return str;
                }
            }
        } catch (Throwable th) {
            ag.a(th);
        }
        str = "";
        AppMethodBeat.o(97756);
        return str;
    }

    private static boolean d(Context context, String str) {
        boolean z = true;
        AppMethodBeat.i(97757);
        if (context == null || str == null) {
            ag.d("context or permission is null.", new Object[0]);
            AppMethodBeat.o(97757);
            return false;
        }
        boolean z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (!z2) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    for (Object equals : strArr) {
                        if (str.equals(equals)) {
                            break;
                        }
                    }
                }
                z = z2;
                ag.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
                z2 = z;
            } catch (Throwable th) {
                ag.b("AppInfo.isContainReadLogPermission() end", new Object[0]);
                AppMethodBeat.o(97757);
            }
        }
        AppMethodBeat.o(97757);
        return z2;
    }

    private static boolean e(Context context, String str) {
        AppMethodBeat.i(97758);
        if (context == null || str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(97758);
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
                ag.b("no running proc", new Object[0]);
                AppMethodBeat.o(97758);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    for (Object equals : runningAppProcessInfo.pkgList) {
                        if (str.equals(equals)) {
                            AppMethodBeat.o(97758);
                            return true;
                        }
                    }
                    continue;
                }
            }
            AppMethodBeat.o(97758);
            return false;
        } catch (Throwable th) {
            ag.a(th);
            ag.d("Failed to judge }[%s]", th.getLocalizedMessage());
        }
    }

    public static boolean a(Context context, String str, String str2) {
        AppMethodBeat.i(97759);
        boolean commit = context.getSharedPreferences("DENGTA_META", 0).edit().putString(str, str2).commit();
        AppMethodBeat.o(97759);
        return commit;
    }

    public static String b(Context context, String str, String str2) {
        AppMethodBeat.i(97760);
        String string = context.getSharedPreferences("DENGTA_META", 0).getString(str, str2);
        AppMethodBeat.o(97760);
        return string;
    }

    public static void a(Context context, String str) {
        AppMethodBeat.i(97761);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", str).commit();
        AppMethodBeat.o(97761);
    }

    public static void b(Context context, String str) {
        AppMethodBeat.i(97762);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", str).commit();
        AppMethodBeat.o(97762);
    }

    public static void c(Context context, String str) {
        AppMethodBeat.i(97763);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("pid_stat", str).commit();
        AppMethodBeat.o(97763);
    }
}
