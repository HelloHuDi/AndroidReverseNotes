package com.tencent.tinker.loader.shareutil;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.xwalk.core.XWalkEnvironment;

public class ShareTinkerInternals {
    private static final boolean AFi = auv(System.getProperty("java.vm.version"));
    private static final boolean AFj = dSt();
    private static Boolean AFk = null;
    private static String AFl = null;
    private static String AFm = null;
    private static String processName = null;

    public static boolean dSp() {
        return AFi || VERSION.SDK_INT >= 21;
    }

    public static boolean dSq() {
        return AFj && VERSION.SDK_INT < 24;
    }

    public static boolean dSr() {
        return VERSION.SDK_INT > 25;
    }

    public static String dSs() {
        if (AFm != null) {
            return AFm;
        }
        AFm = (String) Class.forName("dalvik.system.VMRuntime").getDeclaredMethod("getCurrentInstructionSet", new Class[0]).invoke(null, new Object[0]);
        new StringBuilder("getCurrentInstructionSet:").append(AFm);
        return AFm;
    }

    public static boolean auu(String str) {
        String str2 = Build.FINGERPRINT;
        if (str == null || str.equals("") || str2 == null || str2.equals("")) {
            new StringBuilder("fingerprint empty:").append(str).append(",current:").append(str2);
            return false;
        } else if (str.equals(str2)) {
            return false;
        } else {
            new StringBuilder("system OTA,fingerprint not equal:").append(str).append(",").append(str2);
            return true;
        }
    }

    /* renamed from: a */
    public static ShareDexDiffPatchInfo m9415a(ShareDexDiffPatchInfo shareDexDiffPatchInfo, int i) {
        if (!shareDexDiffPatchInfo.ADN.startsWith("test.dex")) {
            return null;
        }
        String str;
        if (i != 1) {
            str = "classes" + i + ".dex";
        } else {
            str = XWalkEnvironment.XWALK_CORE_CLASSES_DEX;
        }
        return new ShareDexDiffPatchInfo(str, shareDexDiffPatchInfo.path, shareDexDiffPatchInfo.ADO, shareDexDiffPatchInfo.ADP, shareDexDiffPatchInfo.ADS, shareDexDiffPatchInfo.ADQ, shareDexDiffPatchInfo.ADR, shareDexDiffPatchInfo.ADT);
    }

    public static boolean isNullOrNil(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public static int m9414a(Context context, int i, File file, ShareSecurityCheck shareSecurityCheck) {
        int i2;
        HashMap dSo;
        if (shareSecurityCheck.mo12704aw(file)) {
            String jl = m9420jl(context);
            if (jl == null) {
                i2 = -5;
            } else {
                dSo = shareSecurityCheck.dSo();
                if (dSo == null) {
                    i2 = -2;
                } else {
                    String str = (String) dSo.get("TINKER_ID");
                    if (str == null) {
                        i2 = -6;
                    } else if (jl.equals(str)) {
                        i2 = 0;
                    } else {
                        new StringBuilder("tinkerId is not equal, base is ").append(jl).append(", but patch is ").append(str);
                        i2 = -7;
                    }
                }
            }
        } else {
            i2 = -1;
        }
        if (i2 != 0) {
            return i2;
        }
        Object obj;
        if (i == 7) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            dSo = shareSecurityCheck.AFg;
            if (!m9409Sa(i) && dSo.containsKey("assets/dex_meta.txt")) {
                return -9;
            }
            if (!m9410Sb(i) && dSo.containsKey("assets/so_meta.txt")) {
                return -9;
            }
            if (!m9411Sc(i) && dSo.containsKey("assets/res_meta.txt")) {
                return -9;
            }
        }
        return 0;
    }

    /* renamed from: S */
    public static Properties m9408S(File file) {
        Throwable th;
        IOException e;
        ZipFile zipFile;
        if (!file.isFile() || file.length() == 0) {
            return null;
        }
        ZipFile zipFile2;
        try {
            zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("assets/package_meta.txt");
                if (entry == null) {
                    SharePatchFileUtil.m9368a(zipFile2);
                    return null;
                }
                Object inputStream;
                try {
                    inputStream = zipFile2.getInputStream(entry);
                    try {
                        Properties properties = new Properties();
                        properties.load(inputStream);
                        SharePatchFileUtil.m9369ah(inputStream);
                        SharePatchFileUtil.m9368a(zipFile2);
                        return properties;
                    } catch (Throwable th2) {
                        th = th2;
                        SharePatchFileUtil.m9369ah(inputStream);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = null;
                }
            } catch (IOException e2) {
                e = e2;
                zipFile = zipFile2;
            } catch (Throwable th4) {
                th = th4;
                SharePatchFileUtil.m9368a(zipFile2);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            zipFile = null;
            try {
                new StringBuilder("fastGetPatchPackageMeta exception:").append(e.getMessage());
                SharePatchFileUtil.m9368a(zipFile);
                return null;
            } catch (Throwable th42) {
                th = th42;
                zipFile2 = zipFile;
                SharePatchFileUtil.m9368a(zipFile2);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            zipFile2 = null;
            SharePatchFileUtil.m9368a(zipFile2);
            throw th;
        }
    }

    /* renamed from: jl */
    private static String m9420jl(Context context) {
        if (AFl != null) {
            return AFl;
        }
        try {
            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("TINKER_ID");
            if (obj != null) {
                AFl = String.valueOf(obj);
            } else {
                AFl = null;
            }
            return AFl;
        } catch (Exception e) {
            new StringBuilder("getManifestTinkerID exception:").append(e.getMessage());
            return null;
        }
    }

    /* renamed from: Sa */
    public static boolean m9409Sa(int i) {
        return (i & 1) != 0;
    }

    /* renamed from: Sb */
    public static boolean m9410Sb(int i) {
        return (i & 2) != 0;
    }

    /* renamed from: Sc */
    public static boolean m9411Sc(int i) {
        return (i & 4) != 0;
    }

    /* renamed from: Sd */
    public static String m9412Sd(int i) {
        switch (i) {
            case 1:
                return "patch_file";
            case 2:
                return "patch_info";
            case 3:
                return "dex";
            case 4:
                return "dex_opt";
            case 5:
                return "lib";
            case 6:
                return "resource";
            default:
                return "unknown";
        }
    }

    /* renamed from: jm */
    public static void m9421jm(Context context) {
        context.getSharedPreferences("tinker_share_config", 4).edit().putBoolean("tinker_enable_1.9.10", false).commit();
    }

    /* renamed from: jn */
    public static boolean m9422jn(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("tinker_share_config", 4).getBoolean("tinker_enable_1.9.10", true);
    }

    /* renamed from: jo */
    public static int m9423jo(Context context) {
        String concat = "tinker_own_config_".concat(String.valueOf(m9416aD(context)));
        int i = context.getSharedPreferences(concat, 0).getInt("safe_mode_count_1.9.10", 0);
        new StringBuilder("getSafeModeCount: preferName:").append(concat).append(" count:").append(i);
        return i;
    }

    /* renamed from: aD */
    public static void m9417aD(Context context, int i) {
        String concat = "tinker_own_config_".concat(String.valueOf(m9416aD(context)));
        context.getSharedPreferences(concat, 0).edit().putInt("safe_mode_count_1.9.10", i).commit();
        new StringBuilder("setSafeModeCount: preferName:").append(concat).append(" count:").append(i);
    }

    /* renamed from: Se */
    public static boolean m9413Se(int i) {
        return i != 0;
    }

    /* renamed from: jp */
    public static boolean m9424jp(Context context) {
        String str = null;
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo != null) {
            str = applicationInfo.processName;
        }
        if (isNullOrNil(str)) {
            str = context.getPackageName();
        }
        Object aD = m9416aD(context);
        if (aD == null || aD.length() == 0) {
            aD = "";
        }
        return str.equals(aD);
    }

    /* renamed from: jq */
    public static boolean m9425jq(Context context) {
        if (AFk != null) {
            return AFk.booleanValue();
        }
        Boolean valueOf = Boolean.valueOf(m9416aD(context).endsWith(":patch"));
        AFk = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: ch */
    public static String m9419ch(Context context, String str) {
        if (!str.equals("changing")) {
            return str;
        }
        if (m9424jp(context)) {
            return "odex";
        }
        return "interpet";
    }

    /* renamed from: jr */
    public static void m9426jr(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && runningAppProcessInfo.pid != Process.myPid()) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    /* renamed from: js */
    public static void m9427js(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.uid == Process.myUid() && !runningAppProcessInfo.processName.equals(context.getPackageName())) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    /* renamed from: aD */
    public static String m9416aD(Context context) {
        if (processName != null) {
            return processName;
        }
        String aE = m9418aE(context);
        processName = aE;
        return aE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b0 A:{SYNTHETIC, Splitter:B:50:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a6 A:{SYNTHETIC, Splitter:B:44:0x00a6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aE */
    private static String m9418aE(Context context) {
        Exception e;
        Throwable th;
        int myPid = Process.myPid();
        if (context == null || myPid <= 0) {
            return "";
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager != null) {
            try {
                List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                        if (runningAppProcessInfo.pid == myPid) {
                            break;
                        }
                    }
                    RunningAppProcessInfo runningAppProcessInfo2 = null;
                    if (runningAppProcessInfo2 != null) {
                        return runningAppProcessInfo2.processName;
                    }
                }
            } catch (Exception e2) {
                new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            }
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + myPid + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i = 0;
                    while (i < read) {
                        if ((bArr[i] & 255) > 128 || bArr[i] <= (byte) 0) {
                            read = i;
                            break;
                        }
                        i++;
                    }
                    String str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                        return str;
                    } catch (Exception e3) {
                        return str;
                    }
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                return "";
            } catch (Exception e5) {
                e2 = e5;
                try {
                    new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
                    if (fileInputStream != null) {
                    }
                    return "";
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e2 = e6;
            fileInputStream = null;
            new StringBuilder("getProcessNameInternal exception:").append(e2.getMessage());
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                }
            }
            return "";
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e8) {
                }
            }
            throw th;
        }
    }

    private static boolean auv(String str) {
        if (str == null) {
            return false;
        }
        Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
        if (!matcher.matches()) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                return true;
            }
            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean dSt() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
            String str = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejit"});
            String str2 = (String) declaredMethod.invoke(null, new Object[]{"dalvik.vm.usejitprofiles"});
            if (!isNullOrNil(str) && isNullOrNil(str2) && str.equals("true")) {
                return true;
            }
        } catch (Throwable th) {
            new StringBuilder("isVmJitInternal ex:").append(th);
        }
        return false;
    }

    /* renamed from: m */
    public static String m9428m(Throwable th) {
        if (th == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        while (true) {
            try {
                Throwable cause = th.getCause();
                if (cause == null) {
                    break;
                }
                th = cause;
            } finally {
                SharePatchFileUtil.m9369ah(printStream);
            }
        }
        th.printStackTrace(printStream);
        String amD = amD(byteArrayOutputStream.toString());
        return amD;
    }

    private static String amD(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        if (toCharArray == null) {
            return null;
        }
        char c;
        int i = 0;
        while (i < toCharArray.length) {
            if (toCharArray[i] > 127) {
                toCharArray[i] = 0;
                c = 1;
                break;
            }
            i++;
        }
        c = 0;
        if (c != 0) {
            return new String(toCharArray, 0, i);
        }
        return str;
    }
}
