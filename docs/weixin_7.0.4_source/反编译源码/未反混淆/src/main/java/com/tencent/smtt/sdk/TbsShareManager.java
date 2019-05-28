package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TbsShareManager {
    private static Context a;
    private static boolean b;
    private static String c = null;
    private static String d = null;
    private static int e = 0;
    private static String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static String j = null;
    private static boolean k = false;
    private static boolean l = false;
    public static boolean mHasQueryed = false;

    static int a(Context context, boolean z) {
        AppMethodBeat.i(64580);
        b(context, z);
        int i = e;
        AppMethodBeat.o(64580);
        return i;
    }

    static String a() {
        return d;
    }

    static void a(Context context) {
        AppMethodBeat.i(64568);
        TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, an.a().r(context));
            File s = an.a().s(context);
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + s.getAbsolutePath());
            tbsLinuxToolsJni.a(s.getAbsolutePath(), "755");
            AppMethodBeat.o(64568);
        } catch (Throwable th) {
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            AppMethodBeat.o(64568);
        }
    }

    private static void a(Context context, int i) {
        AppMethodBeat.i(64589);
        if (!TbsPVConfig.getInstance(a).isDisableHostBackupCore()) {
            String[] strArr = new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
            TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                File backupCoreFile;
                if (i == getBackupCoreVersion(context, str)) {
                    if (an.a().f(getPackageContext(context, str, false))) {
                        backupCoreFile = getBackupCoreFile(context, str);
                        if (a.a(context, backupCoreFile, 0, i)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i + " packageName is " + str);
                            an.a().a(context, backupCoreFile, i);
                            AppMethodBeat.o(64589);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (i == getBackupDecoupleCoreVersion(context, str)) {
                    if (an.a().f(getPackageContext(context, str, false))) {
                        backupCoreFile = getBackupDecoupleCoreFile(context, str);
                        if (a.a(context, backupCoreFile, 0, i)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i + " packageName is " + str);
                            an.a().a(context, backupCoreFile, i);
                            AppMethodBeat.o(64589);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.o(64589);
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        AppMethodBeat.i(64570);
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file != null && file.exists() && file.isDirectory()) {
            TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
            AppMethodBeat.o(64570);
            return;
        }
        AppMethodBeat.o(64570);
    }

    static void b(Context context) {
        AppMethodBeat.i(64569);
        try {
            a(context, new TbsLinuxToolsJni(context), an.a().q(context));
            AppMethodBeat.o(64569);
        } catch (Throwable th) {
            AppMethodBeat.o(64569);
        }
    }

    static boolean b(Context context, boolean z) {
        AppMethodBeat.i(64598);
        if (i(context)) {
            AppMethodBeat.o(64598);
            return true;
        }
        if (z) {
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        }
        AppMethodBeat.o(64598);
        return false;
    }

    static String c(Context context) {
        AppMethodBeat.i(64578);
        j(context);
        String str = d;
        AppMethodBeat.o(64578);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e A:{SYNTHETIC, Splitter:B:40:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3 A:{SYNTHETIC, Splitter:B:43:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A:{SYNTHETIC, Splitter:B:31:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A:{SYNTHETIC, Splitter:B:34:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e A:{SYNTHETIC, Splitter:B:40:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3 A:{SYNTHETIC, Splitter:B:43:0x00a3} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.i(64586);
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream3 = null;
        BufferedInputStream bufferedInputStream2;
        try {
            File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                if (null != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream3.close();
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(64586);
                return;
            }
            Properties properties;
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream2);
                properties.setProperty("core_disabled", "false");
                if (z) {
                    String absolutePath = an.a().r(context).getAbsolutePath();
                    String packageName = context.getApplicationContext().getPackageName();
                    int b = b.b(context);
                    properties.setProperty("core_packagename", packageName);
                    properties.setProperty("core_path", absolutePath);
                    properties.setProperty("app_version", String.valueOf(b));
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            } catch (Throwable th2) {
                th = th2;
                bufferedOutputStream2 = null;
                if (bufferedInputStream2 != null) {
                }
                if (bufferedOutputStream2 != null) {
                }
                AppMethodBeat.o(64586);
                throw th;
            }
            try {
                properties.store(bufferedOutputStream, null);
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e3) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(64586);
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedInputStream2 != null) {
                }
                if (bufferedOutputStream2 != null) {
                }
                AppMethodBeat.o(64586);
                throw th;
            }
        } catch (Throwable th22) {
            th = th22;
            bufferedOutputStream2 = null;
            bufferedInputStream2 = null;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (Exception e5) {
                }
            }
            if (bufferedOutputStream2 != null) {
                try {
                    bufferedOutputStream2.close();
                } catch (Exception e6) {
                }
            }
            AppMethodBeat.o(64586);
            throw th;
        }
    }

    static int d(Context context) {
        AppMethodBeat.i(64579);
        int a = a(context, true);
        AppMethodBeat.o(64579);
        return a;
    }

    private static String[] d(Context context, boolean z) {
        String[] strArr;
        AppMethodBeat.i(64588);
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{context.getApplicationContext().getPackageName()};
        } else {
            strArr = getCoreProviderAppList();
            if (z) {
                strArr = new String[]{context.getApplicationContext().getPackageName()};
            }
        }
        AppMethodBeat.o(64588);
        return strArr;
    }

    static Context e(Context context) {
        Context context2 = null;
        AppMethodBeat.i(64581);
        j(context);
        if (f != null) {
            Context packageContext = getPackageContext(context, f, true);
            if (an.a().f(packageContext)) {
                context2 = packageContext;
            }
        }
        AppMethodBeat.o(64581);
        return context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0067 A:{SYNTHETIC, Splitter:B:42:0x0067} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized String f(Context context) {
        BufferedInputStream bufferedInputStream;
        String str;
        Throwable th;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.i(64591);
            bufferedInputStream = null;
            BufferedInputStream bufferedInputStream2;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    if (null != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    AppMethodBeat.o(64591);
                    str = null;
                } else {
                    bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream2);
                        str = properties.getProperty("core_packagename", "");
                        if ("".equals(str)) {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e2) {
                                }
                            }
                            AppMethodBeat.o(64591);
                            str = null;
                        } else {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            AppMethodBeat.o(64591);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(64591);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                }
                AppMethodBeat.o(64591);
                throw th;
            }
        }
        return str;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (Exception e5) {
            }
        }
        AppMethodBeat.o(64591);
        str = null;
        return str;
        AppMethodBeat.o(64591);
        str = null;
        return str;
    }

    public static int findCoreForThirdPartyApp(Context context) {
        int i;
        AppMethodBeat.i(64584);
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        if (f == null || !f.equals("AppDefined")) {
            if (!(k(context) || l(context))) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (e != an.a().a(c)) {
            e = 0;
            d = null;
            f = null;
            TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + an.a().a(c));
        }
        if (e > 0) {
            String str = "com.jd.jrapp";
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            i = ("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || str.equals(applicationInfo.packageName)) ? 1 : 0;
            if ((i == 0 ? QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        i = e;
        AppMethodBeat.o(64584);
        return i;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        return false;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
    }

    static String g(Context context) {
        AppMethodBeat.i(64592);
        try {
            n(context);
            if (d == null || TextUtils.isEmpty(d)) {
                AppMethodBeat.o(64592);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(d);
            stringBuilder.append(File.separator);
            stringBuilder.append("res.apk");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(64592);
            return stringBuilder2;
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            AppMethodBeat.o(64592);
            return null;
        }
    }

    public static File getBackupCoreFile(Context context, String str) {
        AppMethodBeat.i(64576);
        try {
            File file = new File(new File(k.a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                AppMethodBeat.o(64576);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(64576);
        return null;
    }

    public static int getBackupCoreVersion(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(64574);
        try {
            File file = new File(new File(k.a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                i = a.b(file);
                AppMethodBeat.o(64574);
                return i;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(64574);
        return i;
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        AppMethodBeat.i(64577);
        try {
            File file = new File(new File(k.a(getPackageContext(context, str, true), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                AppMethodBeat.o(64577);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(64577);
        return null;
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        int i = 0;
        AppMethodBeat.i(64575);
        try {
            File file = new File(new File(k.a(getPackageContext(context, str, false), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                i = a.b(file);
                AppMethodBeat.o(64575);
                return i;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(64575);
        return i;
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return k;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return c;
    }

    public static long getHostCoreVersions(Context context) {
        AppMethodBeat.i(64572);
        long j = 0;
        for (String str : getCoreProviderAppList()) {
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                j += ((long) getSharedTbsCoreVersion(context, str)) * 10000000000L;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QQ)) {
                j += ((long) getSharedTbsCoreVersion(context, str)) * 100000;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QZONE)) {
                j += (long) getSharedTbsCoreVersion(context, str);
            }
        }
        AppMethodBeat.o(64572);
        return j;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        Context context2 = null;
        AppMethodBeat.i(64599);
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    AppMethodBeat.o(64599);
                    return context2;
                }
            } catch (NameNotFoundException e) {
                AppMethodBeat.o(64599);
            } catch (Exception e2) {
                AppMethodBeat.o(64599);
            }
        }
        context2 = context.createPackageContext(str, 2);
        AppMethodBeat.o(64599);
        return context2;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        AppMethodBeat.i(64573);
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            int j = an.a().j(packageContext);
            AppMethodBeat.o(64573);
            return j;
        }
        AppMethodBeat.o(64573);
        return 0;
    }

    public static File getTbsShareFile(Context context, String str) {
        AppMethodBeat.i(64595);
        File s = an.a().s(context);
        if (s == null) {
            AppMethodBeat.o(64595);
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            AppMethodBeat.o(64595);
            return file;
        }
        try {
            file.createNewFile();
            AppMethodBeat.o(64595);
            return file;
        } catch (IOException e) {
            AppMethodBeat.o(64595);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0 A:{SYNTHETIC, Splitter:B:53:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092 A:{SYNTHETIC, Splitter:B:44:0x0092} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized int h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.i(64593);
            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                    AppMethodBeat.o(64593);
                } else {
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream3);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (Exception e2) {
                                }
                            }
                            AppMethodBeat.o(64593);
                        } else {
                            TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                            i = Math.max(Integer.parseInt(property), 0);
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (Exception e3) {
                                }
                            }
                            AppMethodBeat.o(64593);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.o(64593);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                }
                AppMethodBeat.o(64593);
                throw th;
            }
        }
        return i;
    }

    static boolean i(Context context) {
        AppMethodBeat.i(64596);
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (e == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                AppMethodBeat.o(64596);
                return false;
            }
            if (c == null) {
                if (e != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    AppMethodBeat.o(64596);
                    return true;
                }
            } else if (e != 0 && an.a().a(c) == e) {
                AppMethodBeat.o(64596);
                return true;
            }
            if (l(context)) {
                AppMethodBeat.o(64596);
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            AppMethodBeat.o(64596);
            return false;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            AppMethodBeat.o(64596);
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        AppMethodBeat.i(64571);
        try {
            if (a == null || !a.equals(context.getApplicationContext())) {
                Context applicationContext = context.getApplicationContext();
                a = applicationContext;
                String packageName = applicationContext.getPackageName();
                for (Object equals : getCoreProviderAppList()) {
                    if (packageName.equals(equals)) {
                        b = false;
                        AppMethodBeat.o(64571);
                        return false;
                    }
                }
                b = true;
                AppMethodBeat.o(64571);
                return true;
            }
            boolean z = b;
            AppMethodBeat.o(64571);
            return z;
        } catch (Throwable th) {
        }
    }

    static boolean j(Context context) {
        AppMethodBeat.i(64597);
        boolean b = b(context, true);
        AppMethodBeat.o(64597);
        return b;
    }

    private static boolean k(Context context) {
        AppMethodBeat.i(64582);
        if (f == null) {
            AppMethodBeat.o(64582);
            return false;
        } else if (e == getSharedTbsCoreVersion(context, f)) {
            AppMethodBeat.o(64582);
            return true;
        } else {
            AppMethodBeat.o(64582);
            return false;
        }
    }

    private static boolean l(Context context) {
        AppMethodBeat.i(64583);
        if (QbSdk.getOnlyDownload()) {
            AppMethodBeat.o(64583);
            return false;
        }
        for (String str : getCoreProviderAppList()) {
            if (e > 0 && e == getSharedTbsCoreVersion(context, str)) {
                Context packageContext = getPackageContext(context, str, true);
                if (an.a().f(context)) {
                    d = an.a().b(context, packageContext).getAbsolutePath();
                    f = str;
                    AppMethodBeat.o(64583);
                    return true;
                }
            }
        }
        AppMethodBeat.o(64583);
        return false;
    }

    private static boolean m(Context context) {
        AppMethodBeat.i(64585);
        if (context == null) {
            AppMethodBeat.o(64585);
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        AppMethodBeat.o(64585);
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0029=Splitter:B:16:0x0029, B:45:0x00fd=Splitter:B:45:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0115 A:{SYNTHETIC, Splitter:B:59:0x0115} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        AppMethodBeat.i(64594);
        if (l) {
            AppMethodBeat.o(64594);
            return;
        }
        synchronized (TbsShareManager.class) {
            try {
                if (l) {
                } else {
                    BufferedInputStream bufferedInputStream3 = null;
                    try {
                        File tbsShareFile = getTbsShareFile(context, "core_info");
                        if (tbsShareFile == null) {
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (Exception e) {
                                }
                            }
                            AppMethodBeat.o(64594);
                            return;
                        }
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                e = Math.max(Integer.parseInt(property), 0);
                                TbsLog.i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                            }
                            property = properties.getProperty("core_packagename", "");
                            if (!"".equals(property)) {
                                f = property;
                            }
                            if (!(f == null || a == null)) {
                                if (f.equals(a.getPackageName())) {
                                    k = true;
                                } else {
                                    k = false;
                                }
                            }
                            property = properties.getProperty("core_path", "");
                            if (!"".equals(property)) {
                                d = property;
                            }
                            property = properties.getProperty("app_version", "");
                            if (!"".equals(property)) {
                                j = property;
                            }
                            g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            l = true;
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedInputStream2 = bufferedInputStream;
                            if (bufferedInputStream2 != null) {
                            }
                            AppMethodBeat.o(64594);
                            throw th;
                        }
                        AppMethodBeat.o(64594);
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream2 = bufferedInputStream3;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        AppMethodBeat.o(64594);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.o(64594);
            }
        }
        return;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        AppMethodBeat.o(64594);
    }

    public static void setHostCorePathAppDefined(String str) {
        c = str;
    }

    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i, boolean z) {
        Object obj = 1;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.i(64587);
            TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is ".concat(String.valueOf(i)));
            if (i == 0) {
                m(context);
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-401);
                AppMethodBeat.o(64587);
            } else {
                int h = h(context);
                TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is ".concat(String.valueOf(h)));
                if (h < 0) {
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-402);
                    AppMethodBeat.o(64587);
                } else if (i == h) {
                    if (d(context) == 0 && !z) {
                        a(context, i);
                    }
                    c(context, z);
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-403);
                    AppMethodBeat.o(64587);
                } else if (i < h) {
                    m(context);
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
                    AppMethodBeat.o(64587);
                } else {
                    h = an.a().j(context);
                    TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ".concat(String.valueOf(h)));
                    if (i < h) {
                        m(context);
                        TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-404);
                        AppMethodBeat.o(64587);
                    } else {
                        String[] d = d(context, z);
                        if (c != null) {
                            File tbsShareFile;
                            TbsLinuxToolsJni tbsLinuxToolsJni;
                            if (i == an.a().a(c)) {
                                writeProperties(context, Integer.toString(i), "AppDefined", c, Integer.toString(1));
                                try {
                                    tbsShareFile = getTbsShareFile(context, "core_info");
                                    if (!(i || tbsShareFile == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                        tbsLinuxToolsJni.a(tbsShareFile.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni.a(an.a().s(context).getAbsolutePath(), "755");
                                        i = true;
                                    }
                                    AppMethodBeat.o(64587);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(64587);
                                }
                            } else if (i > an.a().a(c)) {
                                for (String str : d) {
                                    if (i == getSharedTbsCoreVersion(context, str)) {
                                        Context packageContext = getPackageContext(context, str, true);
                                        String absolutePath = an.a().r(packageContext).getAbsolutePath();
                                        b.b(context);
                                        if (an.a().f(packageContext)) {
                                            try {
                                                k.a(new File(absolutePath), new File(c), new bc());
                                                writeProperties(context, Integer.toString(i), "AppDefined", c, Integer.toString(1));
                                                tbsShareFile = getTbsShareFile(context, "core_info");
                                                if (!(i || tbsShareFile == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(a);
                                                    tbsLinuxToolsJni.a(tbsShareFile.getAbsolutePath(), "644");
                                                    tbsLinuxToolsJni.a(an.a().s(context).getAbsolutePath(), "755");
                                                    i = true;
                                                }
                                                AppMethodBeat.o(64587);
                                            } catch (Throwable th2) {
                                                AppMethodBeat.o(64587);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (String str2 : d) {
                            if (i == getSharedTbsCoreVersion(context, str2)) {
                                Context packageContext2 = getPackageContext(context, str2, true);
                                String absolutePath2 = an.a().r(packageContext2).getAbsolutePath();
                                int b = b.b(context);
                                if (an.a().f(packageContext2)) {
                                    if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                        TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:".concat(String.valueOf(i)));
                                        try {
                                            k.b(an.a().r(context));
                                            TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    writeProperties(context, Integer.toString(i), str2, absolutePath2, Integer.toString(b));
                                    try {
                                        File tbsShareFile2 = getTbsShareFile(context, "core_info");
                                        if (!(i || tbsShareFile2 == null)) {
                                            TbsLinuxToolsJni tbsLinuxToolsJni2 = new TbsLinuxToolsJni(a);
                                            tbsLinuxToolsJni2.a(tbsShareFile2.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni2.a(an.a().s(context).getAbsolutePath(), "755");
                                            i = true;
                                        }
                                    } catch (Throwable th4) {
                                    }
                                    if (obj == null && !z) {
                                        a(context, i);
                                    }
                                    AppMethodBeat.o(64587);
                                }
                            }
                        }
                        obj = null;
                        a(context, i);
                        AppMethodBeat.o(64587);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fd A:{SYNTHETIC, Splitter:B:46:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0102 A:{SYNTHETIC, Splitter:B:49:0x0102} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00eb A:{SYNTHETIC, Splitter:B:37:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f0 A:{SYNTHETIC, Splitter:B:40:0x00f0} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00fd A:{SYNTHETIC, Splitter:B:46:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0102 A:{SYNTHETIC, Splitter:B:49:0x0102} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        int i = 0;
        AppMethodBeat.i(64590);
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        TbsLog.i("TbsShareManager", "writeProperties -- stack: " + Log.getStackTraceString(new Throwable("#")));
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3;
        try {
            File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-405);
                if (null != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e) {
                    }
                }
                if (null != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (Exception e2) {
                    }
                }
                AppMethodBeat.o(64590);
                return;
            }
            bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                Properties properties = new Properties();
                properties.load(bufferedInputStream);
                try {
                    i = Integer.parseInt(str);
                } catch (Exception e3) {
                }
                if (i != 0) {
                    properties.setProperty("core_version", str);
                    properties.setProperty("core_disabled", "false");
                    properties.setProperty("core_packagename", str2);
                    properties.setProperty("core_path", str3);
                    properties.setProperty("app_version", str4);
                } else {
                    properties.setProperty("core_disabled", "true");
                }
                bufferedOutputStream3 = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
                try {
                    properties.store(bufferedOutputStream3, null);
                    l = false;
                    TbsDownloadConfig.getInstance(a).setDownloadInterruptCode(-406);
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (bufferedOutputStream3 != null) {
                        try {
                            bufferedOutputStream3.close();
                        } catch (Exception e5) {
                        }
                    }
                    AppMethodBeat.o(64590);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream3;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.o(64590);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                AppMethodBeat.o(64590);
                throw th;
            }
        } catch (Throwable th32) {
            th = th32;
            bufferedOutputStream = null;
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e6) {
                }
            }
            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (Exception e7) {
                }
            }
            AppMethodBeat.o(64590);
            throw th;
        }
    }
}
