package com.tencent.tencentmap.mapsdk.p666a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16205ag;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31019an;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/* renamed from: com.tencent.tencentmap.mapsdk.a.a */
public class C41003a {
    /* renamed from: a */
    protected static String f16325a = null;
    /* renamed from: b */
    public static boolean f16326b = false;
    /* renamed from: c */
    private static String f16327c = null;
    /* renamed from: d */
    private static String f16328d = null;
    /* renamed from: e */
    private static Boolean f16329e = null;
    /* renamed from: f */
    private static int f16330f = 0;
    /* renamed from: g */
    private static String f16331g = "";

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d1 A:{Catch:{ Throwable -> 0x0128 }} */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0119 A:{SYNTHETIC, Splitter:B:65:0x0119} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static synchronized String m71114a(Context context) {
        String str;
        Throwable th;
        InputStream inputStream;
        synchronized (C41003a.class) {
            AppMethodBeat.m2504i(97744);
            if (context == null) {
                str = "";
                AppMethodBeat.m2505o(97744);
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
                    C16205ag.m24683a("channel path!! ".concat(String.valueOf(string)), new Object[0]);
                    if (string.equals("")) {
                        inputStream2 = null;
                    } else {
                        inputStream2 = assets.open(string);
                        try {
                            Properties properties = new Properties();
                            properties.load(inputStream2);
                            str = properties.getProperty("CHANNEL", "");
                            try {
                                C16205ag.m24683a("channel !! ".concat(String.valueOf(str)), new Object[0]);
                                if ("".equals(str)) {
                                    str2 = str;
                                } else {
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (IOException e) {
                                            C16205ag.m24684a(e);
                                        }
                                    }
                                    AppMethodBeat.m2505o(97744);
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
                            C16205ag.m24684a(e4);
                            str = str2;
                        }
                        string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (string != null) {
                            str = string.toString();
                        }
                        AppMethodBeat.m2505o(97744);
                    }
                } catch (Exception e5) {
                    inputStream2 = null;
                    try {
                        context.getSharedPreferences("DENGTA_META", 0).edit().putString("key_channelpath", "").commit();
                        C16205ag.m24686c("get app channel fail!", new Object[0]);
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                str = str2;
                            } catch (IOException e42) {
                                C16205ag.m24684a(e42);
                                str = str2;
                            }
                            string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                            if (string != null) {
                            }
                            AppMethodBeat.m2505o(97744);
                            return str;
                        }
                        str = str2;
                        string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                        if (string != null) {
                        }
                        AppMethodBeat.m2505o(97744);
                        return str;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e422) {
                                C16205ag.m24684a(e422);
                            }
                        }
                        AppMethodBeat.m2505o(97744);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                    if (inputStream != null) {
                    }
                    AppMethodBeat.m2505o(97744);
                    throw th;
                }
                str = str2;
                try {
                    string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
                    if (string != null) {
                    }
                } catch (Throwable th4) {
                    C16205ag.m24683a("no channel !!", new Object[0]);
                }
                AppMethodBeat.m2505o(97744);
            }
        }
        return str;
    }

    /* renamed from: b */
    public static synchronized boolean m71121b(Context context) {
        boolean z;
        Throwable e;
        boolean z2 = false;
        synchronized (C41003a.class) {
            AppMethodBeat.m2504i(97745);
            if (context == null) {
                C16205ag.m24687d("context == null return null", new Object[0]);
                AppMethodBeat.m2505o(97745);
            } else {
                try {
                    String string = context.getSharedPreferences("DENGTA_META", 4).getString("APPKEY_DENGTA", null);
                    String d = C31019an.m49827d();
                    if (string == null || !string.equals(d)) {
                        z = true;
                        try {
                            Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                            edit.putString("APPKEY_DENGTA", d);
                            edit.commit();
                            z2 = true;
                        } catch (Exception e2) {
                            e = e2;
                            C16205ag.m24685b("updateLocalAPPKEY fail!", new Object[0]);
                            C16205ag.m24684a(e);
                            z2 = z;
                            AppMethodBeat.m2505o(97745);
                            return z2;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    C16205ag.m24685b("updateLocalAPPKEY fail!", new Object[0]);
                    C16205ag.m24684a(e);
                    z2 = z;
                    AppMethodBeat.m2505o(97745);
                    return z2;
                }
                AppMethodBeat.m2505o(97745);
            }
        }
        return z2;
    }

    /* renamed from: c */
    public static boolean m71123c(Context context) {
        boolean z;
        Throwable e;
        boolean z2 = false;
        AppMethodBeat.m2504i(97746);
        if (context == null) {
            C16205ag.m24687d("context == null return null", new Object[0]);
            AppMethodBeat.m2505o(97746);
        } else {
            try {
                String string = context.getSharedPreferences("DENGTA_META", 0).getString("APPVER_DENGTA", null);
                String j = C41003a.m71132j(context);
                if (string == null || !string.equals(j)) {
                    z = true;
                    try {
                        Editor edit = context.getSharedPreferences("DENGTA_META", 0).edit();
                        edit.putString("APPVER_DENGTA", j);
                        edit.commit();
                        z2 = true;
                    } catch (Exception e2) {
                        e = e2;
                        C16205ag.m24685b("updateLocalAPPKEY fail!", new Object[0]);
                        C16205ag.m24684a(e);
                        z2 = z;
                        AppMethodBeat.m2505o(97746);
                        return z2;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                C16205ag.m24685b("updateLocalAPPKEY fail!", new Object[0]);
                C16205ag.m24684a(e);
                z2 = z;
                AppMethodBeat.m2505o(97746);
                return z2;
            }
            AppMethodBeat.m2505o(97746);
        }
        return z2;
    }

    /* renamed from: d */
    public static String m71124d(Context context) {
        AppMethodBeat.m2504i(97747);
        if (context == null) {
            AppMethodBeat.m2505o(97747);
            return null;
        }
        String packageName = context.getPackageName();
        AppMethodBeat.m2505o(97747);
        return packageName;
    }

    /* renamed from: e */
    public static String m71126e(Context context) {
        AppMethodBeat.m2504i(97748);
        if (f16327c == null) {
            f16327c = C41003a.m71132j(context);
        }
        String str = f16327c;
        AppMethodBeat.m2505o(97748);
        return str;
    }

    /* renamed from: j */
    private static synchronized String m71132j(Context context) {
        String valueOf;
        synchronized (C41003a.class) {
            AppMethodBeat.m2504i(97749);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context == null ? null : context.getPackageName(), 0);
                String str = packageInfo.versionName;
                int i = packageInfo.versionCode;
                if (str == null || str.trim().length() <= 0) {
                    valueOf = String.valueOf(i);
                    AppMethodBeat.m2505o(97749);
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
                        C16205ag.m24683a("add versionCode: %s", Integer.valueOf(i));
                        valueOf = str + "." + i;
                    } else {
                        valueOf = str;
                    }
                    C16205ag.m24683a("version: %s", valueOf);
                    AppMethodBeat.m2505o(97749);
                }
            } catch (Exception e) {
                C16205ag.m24684a(e);
                C16205ag.m24687d(e.toString(), new Object[0]);
                valueOf = "";
                AppMethodBeat.m2505o(97749);
            }
        }
        return valueOf;
    }

    /* renamed from: a */
    public static void m71116a(String str) {
        AppMethodBeat.m2504i(97750);
        synchronized (C41003a.class) {
            try {
                f16325a = str;
            } catch (Throwable th) {
                AppMethodBeat.m2505o(97750);
            }
        }
        C41014c m = C41014c.m71224m();
        if (m != null) {
            m.mo65049a(str);
        }
        AppMethodBeat.m2505o(97750);
    }

    /* renamed from: f */
    public static synchronized boolean m71128f(Context context) {
        boolean booleanValue;
        synchronized (C41003a.class) {
            AppMethodBeat.m2504i(97751);
            C16205ag.m24685b("Read phone state permission check! start ", new Object[0]);
            if (f16329e == null) {
                f16329e = Boolean.valueOf(C41003a.m71125d(context, "android.permission.READ_PHONE_STATE"));
            }
            booleanValue = f16329e.booleanValue();
            AppMethodBeat.m2505o(97751);
        }
        return booleanValue;
    }

    /* renamed from: g */
    public static boolean m71129g(Context context) {
        AppMethodBeat.m2504i(97752);
        boolean e = C41003a.m71127e(context, context.getPackageName());
        AppMethodBeat.m2505o(97752);
        return e;
    }

    /* renamed from: a */
    public static String m71113a() {
        AppMethodBeat.m2504i(97753);
        String str;
        if ("".equals(f16331g)) {
            try {
                if (f16330f == 0) {
                    f16330f = Process.myPid();
                }
                f16331g += f16330f + "_";
                f16331g += new Date().getTime();
            } catch (Exception e) {
            }
            str = f16331g;
            AppMethodBeat.m2505o(97753);
            return str;
        }
        str = f16331g;
        AppMethodBeat.m2505o(97753);
        return str;
    }

    /* renamed from: h */
    public static int m71130h(Context context) {
        AppMethodBeat.m2504i(97754);
        try {
            if (f16330f == 0) {
                f16330f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f16330f) {
                    int i = runningAppProcessInfo.importance;
                    AppMethodBeat.m2505o(97754);
                    return i;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(97754);
        return 0;
    }

    /* renamed from: a */
    public static boolean m71117a(Context context, int i) {
        AppMethodBeat.m2504i(97755);
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0].equals(C41003a.m71131i(context).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0])) {
                    AppMethodBeat.m2505o(97755);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(97755);
        return false;
    }

    /* renamed from: i */
    public static String m71131i(Context context) {
        AppMethodBeat.m2504i(97756);
        String str;
        if (f16328d != null) {
            str = f16328d;
            AppMethodBeat.m2505o(97756);
            return str;
        }
        try {
            if (f16330f == 0) {
                f16330f = Process.myPid();
            }
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == f16330f) {
                    str = runningAppProcessInfo.processName;
                    f16328d = str;
                    AppMethodBeat.m2505o(97756);
                    return str;
                }
            }
        } catch (Throwable th) {
            C16205ag.m24684a(th);
        }
        str = "";
        AppMethodBeat.m2505o(97756);
        return str;
    }

    /* renamed from: d */
    private static boolean m71125d(Context context, String str) {
        boolean z = true;
        AppMethodBeat.m2504i(97757);
        if (context == null || str == null) {
            C16205ag.m24687d("context or permission is null.", new Object[0]);
            AppMethodBeat.m2505o(97757);
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
                C16205ag.m24685b("AppInfo.isContainReadLogPermission() end", new Object[0]);
                z2 = z;
            } catch (Throwable th) {
                C16205ag.m24685b("AppInfo.isContainReadLogPermission() end", new Object[0]);
                AppMethodBeat.m2505o(97757);
            }
        }
        AppMethodBeat.m2505o(97757);
        return z2;
    }

    /* renamed from: e */
    private static boolean m71127e(Context context, String str) {
        AppMethodBeat.m2504i(97758);
        if (context == null || str == null || str.trim().length() <= 0) {
            AppMethodBeat.m2505o(97758);
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() == 0) {
                C16205ag.m24685b("no running proc", new Object[0]);
                AppMethodBeat.m2505o(97758);
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.importance == 100) {
                    for (Object equals : runningAppProcessInfo.pkgList) {
                        if (str.equals(equals)) {
                            AppMethodBeat.m2505o(97758);
                            return true;
                        }
                    }
                    continue;
                }
            }
            AppMethodBeat.m2505o(97758);
            return false;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            C16205ag.m24687d("Failed to judge }[%s]", th.getLocalizedMessage());
        }
    }

    /* renamed from: a */
    public static boolean m71118a(Context context, String str, String str2) {
        AppMethodBeat.m2504i(97759);
        boolean commit = context.getSharedPreferences("DENGTA_META", 0).edit().putString(str, str2).commit();
        AppMethodBeat.m2505o(97759);
        return commit;
    }

    /* renamed from: b */
    public static String m71119b(Context context, String str, String str2) {
        AppMethodBeat.m2504i(97760);
        String string = context.getSharedPreferences("DENGTA_META", 0).getString(str, str2);
        AppMethodBeat.m2505o(97760);
        return string;
    }

    /* renamed from: a */
    public static void m71115a(Context context, String str) {
        AppMethodBeat.m2504i(97761);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("querytimes", str).commit();
        AppMethodBeat.m2505o(97761);
    }

    /* renamed from: b */
    public static void m71120b(Context context, String str) {
        AppMethodBeat.m2504i(97762);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("initsdkdate", str).commit();
        AppMethodBeat.m2505o(97762);
    }

    /* renamed from: c */
    public static void m71122c(Context context, String str) {
        AppMethodBeat.m2504i(97763);
        context.getSharedPreferences("DENGTA_META", 0).edit().putString("pid_stat", str).commit();
        AppMethodBeat.m2505o(97763);
    }
}
