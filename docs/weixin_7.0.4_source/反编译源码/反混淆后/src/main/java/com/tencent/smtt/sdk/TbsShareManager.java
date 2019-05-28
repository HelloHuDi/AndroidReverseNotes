package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C24272a;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TbsShareManager {
    /* renamed from: a */
    private static Context f13853a;
    /* renamed from: b */
    private static boolean f13854b;
    /* renamed from: c */
    private static String f13855c = null;
    /* renamed from: d */
    private static String f13856d = null;
    /* renamed from: e */
    private static int f13857e = 0;
    /* renamed from: f */
    private static String f13858f = null;
    /* renamed from: g */
    private static boolean f13859g = false;
    /* renamed from: h */
    private static boolean f13860h = false;
    /* renamed from: i */
    private static boolean f13861i = false;
    /* renamed from: j */
    private static String f13862j = null;
    /* renamed from: k */
    private static boolean f13863k = false;
    /* renamed from: l */
    private static boolean f13864l = false;
    public static boolean mHasQueryed = false;

    /* renamed from: a */
    static int m49460a(Context context, boolean z) {
        AppMethodBeat.m2504i(64580);
        m49466b(context, z);
        int i = f13857e;
        AppMethodBeat.m2505o(64580);
        return i;
    }

    /* renamed from: a */
    static String m49461a() {
        return f13856d;
    }

    /* renamed from: a */
    static void m49462a(Context context) {
        AppMethodBeat.m2504i(64568);
        TbsLog.m80434i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            m49464a(context, tbsLinuxToolsJni, C5813an.m8800a().mo12183r(context));
            File s = C5813an.m8800a().mo12184s(context);
            TbsLog.m80434i("TbsShareManager", "shareTbsCore tbsShareDir is " + s.getAbsolutePath());
            tbsLinuxToolsJni.mo70610a(s.getAbsolutePath(), "755");
            AppMethodBeat.m2505o(64568);
        } catch (Throwable th) {
            TbsLog.m80434i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            AppMethodBeat.m2505o(64568);
        }
    }

    /* renamed from: a */
    private static void m49463a(Context context, int i) {
        AppMethodBeat.m2504i(64589);
        if (!TbsPVConfig.getInstance(f13853a).isDisableHostBackupCore()) {
            String[] strArr = new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
            TbsLog.m80434i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
            for (int i2 = 0; i2 < 5; i2++) {
                String str = strArr[i2];
                File backupCoreFile;
                if (i == getBackupCoreVersion(context, str)) {
                    if (C5813an.m8800a().mo12171f(getPackageContext(context, str, false))) {
                        backupCoreFile = getBackupCoreFile(context, str);
                        if (C24272a.m37435a(context, backupCoreFile, 0, i)) {
                            TbsLog.m80434i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i + " packageName is " + str);
                            C5813an.m8800a().mo12155a(context, backupCoreFile, i);
                            AppMethodBeat.m2505o(64589);
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (i == getBackupDecoupleCoreVersion(context, str)) {
                    if (C5813an.m8800a().mo12171f(getPackageContext(context, str, false))) {
                        backupCoreFile = getBackupDecoupleCoreFile(context, str);
                        if (C24272a.m37435a(context, backupCoreFile, 0, i)) {
                            TbsLog.m80434i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i + " packageName is " + str);
                            C5813an.m8800a().mo12155a(context, backupCoreFile, i);
                            AppMethodBeat.m2505o(64589);
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
        AppMethodBeat.m2505o(64589);
    }

    /* renamed from: a */
    private static void m49464a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        AppMethodBeat.m2504i(64570);
        TbsLog.m80434i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file != null && file.exists() && file.isDirectory()) {
            TbsLog.m80434i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
            tbsLinuxToolsJni.mo70610a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        tbsLinuxToolsJni.mo70610a(file2.getAbsolutePath(), "755");
                    } else {
                        tbsLinuxToolsJni.mo70610a(file2.getAbsolutePath(), "644");
                    }
                } else if (file2.isDirectory()) {
                    m49464a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.m80433e("TbsShareManager", "unknown file type.", true);
                }
            }
            AppMethodBeat.m2505o(64570);
            return;
        }
        AppMethodBeat.m2505o(64570);
    }

    /* renamed from: b */
    static void m49465b(Context context) {
        AppMethodBeat.m2504i(64569);
        try {
            m49464a(context, new TbsLinuxToolsJni(context), C5813an.m8800a().mo12182q(context));
            AppMethodBeat.m2505o(64569);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(64569);
        }
    }

    /* renamed from: b */
    static boolean m49466b(Context context, boolean z) {
        AppMethodBeat.m2504i(64598);
        if (m49475i(context)) {
            AppMethodBeat.m2505o(64598);
            return true;
        }
        if (z) {
            QbSdk.m71035a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        }
        AppMethodBeat.m2505o(64598);
        return false;
    }

    /* renamed from: c */
    static String m49467c(Context context) {
        AppMethodBeat.m2504i(64578);
        m49476j(context);
        String str = f13856d;
        AppMethodBeat.m2505o(64578);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e A:{SYNTHETIC, Splitter:B:40:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3 A:{SYNTHETIC, Splitter:B:43:0x00a3} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A:{SYNTHETIC, Splitter:B:31:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091 A:{SYNTHETIC, Splitter:B:34:0x0091} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x009e A:{SYNTHETIC, Splitter:B:40:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a3 A:{SYNTHETIC, Splitter:B:43:0x00a3} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private static void m49468c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.m2504i(64586);
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
                AppMethodBeat.m2505o(64586);
                return;
            }
            Properties properties;
            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(tbsShareFile));
            try {
                properties = new Properties();
                properties.load(bufferedInputStream2);
                properties.setProperty("core_disabled", "false");
                if (z) {
                    String absolutePath = C5813an.m8800a().mo12183r(context).getAbsolutePath();
                    String packageName = context.getApplicationContext().getPackageName();
                    int b = C36443b.m60185b(context);
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
                AppMethodBeat.m2505o(64586);
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
                AppMethodBeat.m2505o(64586);
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                if (bufferedInputStream2 != null) {
                }
                if (bufferedOutputStream2 != null) {
                }
                AppMethodBeat.m2505o(64586);
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
            AppMethodBeat.m2505o(64586);
            throw th;
        }
    }

    /* renamed from: d */
    static int m49469d(Context context) {
        AppMethodBeat.m2504i(64579);
        int a = m49460a(context, true);
        AppMethodBeat.m2505o(64579);
        return a;
    }

    /* renamed from: d */
    private static String[] m49470d(Context context, boolean z) {
        String[] strArr;
        AppMethodBeat.m2504i(64588);
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{context.getApplicationContext().getPackageName()};
        } else {
            strArr = getCoreProviderAppList();
            if (z) {
                strArr = new String[]{context.getApplicationContext().getPackageName()};
            }
        }
        AppMethodBeat.m2505o(64588);
        return strArr;
    }

    /* renamed from: e */
    static Context m49471e(Context context) {
        Context context2 = null;
        AppMethodBeat.m2504i(64581);
        m49476j(context);
        if (f13858f != null) {
            Context packageContext = getPackageContext(context, f13858f, true);
            if (C5813an.m8800a().mo12171f(packageContext)) {
                context2 = packageContext;
            }
        }
        AppMethodBeat.m2505o(64581);
        return context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x0067 A:{SYNTHETIC, Splitter:B:42:0x0067} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    static synchronized String m49472f(Context context) {
        BufferedInputStream bufferedInputStream;
        String str;
        Throwable th;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.m2504i(64591);
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
                    AppMethodBeat.m2505o(64591);
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
                            AppMethodBeat.m2505o(64591);
                            str = null;
                        } else {
                            if (bufferedInputStream2 != null) {
                                try {
                                    bufferedInputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                            AppMethodBeat.m2505o(64591);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(64591);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                }
                AppMethodBeat.m2505o(64591);
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
        AppMethodBeat.m2505o(64591);
        str = null;
        return str;
        AppMethodBeat.m2505o(64591);
        str = null;
        return str;
    }

    public static int findCoreForThirdPartyApp(Context context) {
        int i;
        AppMethodBeat.m2504i(64584);
        m49480n(context);
        TbsLog.m80434i("TbsShareManager", "core_info mAvailableCoreVersion is " + f13857e + " mAvailableCorePath is " + f13856d + " mSrcPackageName is " + f13858f);
        if (f13858f == null) {
            TbsLog.m80432e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        if (f13858f == null || !f13858f.equals("AppDefined")) {
            if (!(m49477k(context) || m49478l(context))) {
                f13857e = 0;
                f13856d = null;
                f13858f = null;
                TbsLog.m80434i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (f13857e != C5813an.m8800a().mo12148a(f13855c)) {
            f13857e = 0;
            f13856d = null;
            f13858f = null;
            TbsLog.m80434i("TbsShareManager", "check AppDefined core is error src is " + f13857e + " dest is " + C5813an.m8800a().mo12148a(f13855c));
        }
        if (f13857e > 0) {
            String str = "com.jd.jrapp";
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            i = ("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || str.equals(applicationInfo.packageName)) ? 1 : 0;
            if ((i == 0 ? QbSdk.m71037a(context, f13857e) : false) || f13859g) {
                f13857e = 0;
                f13856d = null;
                f13858f = null;
                TbsLog.m80434i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        i = f13857e;
        AppMethodBeat.m2505o(64584);
        return i;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        return false;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
    }

    /* renamed from: g */
    static String m49473g(Context context) {
        AppMethodBeat.m2504i(64592);
        try {
            m49480n(context);
            if (f13856d == null || TextUtils.isEmpty(f13856d)) {
                AppMethodBeat.m2505o(64592);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder(f13856d);
            stringBuilder.append(File.separator);
            stringBuilder.append("res.apk");
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(64592);
            return stringBuilder2;
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64592);
            return null;
        }
    }

    public static File getBackupCoreFile(Context context, String str) {
        AppMethodBeat.m2504i(64576);
        try {
            File file = new File(new File(C30950k.m49545a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                AppMethodBeat.m2505o(64576);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(64576);
        return null;
    }

    public static int getBackupCoreVersion(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(64574);
        try {
            File file = new File(new File(C30950k.m49545a(getPackageContext(context, str, false), 4)), "x5.tbs.org");
            if (file.exists()) {
                i = C24272a.m37436b(file);
                AppMethodBeat.m2505o(64574);
                return i;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(64574);
        return i;
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        AppMethodBeat.m2504i(64577);
        try {
            File file = new File(new File(C30950k.m49545a(getPackageContext(context, str, true), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                AppMethodBeat.m2505o(64577);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(64577);
        return null;
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        int i = 0;
        AppMethodBeat.m2504i(64575);
        try {
            File file = new File(new File(C30950k.m49545a(getPackageContext(context, str, false), 4)), "x5.tbs.decouple");
            if (file.exists()) {
                i = C24272a.m37436b(file);
                AppMethodBeat.m2505o(64575);
                return i;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(64575);
        return i;
    }

    public static boolean getCoreDisabled() {
        return f13859g;
    }

    public static boolean getCoreFormOwn() {
        return f13863k;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return f13855c;
    }

    public static long getHostCoreVersions(Context context) {
        AppMethodBeat.m2504i(64572);
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
        AppMethodBeat.m2505o(64572);
        return j;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        Context context2 = null;
        AppMethodBeat.m2504i(64599);
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    TbsLog.m80434i("TbsShareManager", "gray no core app,skip get context");
                    AppMethodBeat.m2505o(64599);
                    return context2;
                }
            } catch (NameNotFoundException e) {
                AppMethodBeat.m2505o(64599);
            } catch (Exception e2) {
                AppMethodBeat.m2505o(64599);
            }
        }
        context2 = context.createPackageContext(str, 2);
        AppMethodBeat.m2505o(64599);
        return context2;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        AppMethodBeat.m2504i(64573);
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            int j = C5813an.m8800a().mo12175j(packageContext);
            AppMethodBeat.m2505o(64573);
            return j;
        }
        AppMethodBeat.m2505o(64573);
        return 0;
    }

    public static File getTbsShareFile(Context context, String str) {
        AppMethodBeat.m2504i(64595);
        File s = C5813an.m8800a().mo12184s(context);
        if (s == null) {
            AppMethodBeat.m2505o(64595);
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            AppMethodBeat.m2505o(64595);
            return file;
        }
        try {
            file.createNewFile();
            AppMethodBeat.m2505o(64595);
            return file;
        } catch (IOException e) {
            AppMethodBeat.m2505o(64595);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a0 A:{SYNTHETIC, Splitter:B:53:0x00a0} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092 A:{SYNTHETIC, Splitter:B:44:0x0092} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    static synchronized int m49474h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.m2504i(64593);
            TbsLog.m80434i("TbsShareManager", "readCoreVersionFromConfig #1");
            BufferedInputStream bufferedInputStream2 = null;
            BufferedInputStream bufferedInputStream3;
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.m80434i("TbsShareManager", "readCoreVersionFromConfig #2");
                    if (bufferedInputStream2 != null) {
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                    }
                    AppMethodBeat.m2505o(64593);
                } else {
                    bufferedInputStream3 = new BufferedInputStream(new FileInputStream(tbsShareFile));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream3);
                        String property = properties.getProperty("core_version", "");
                        if ("".equals(property)) {
                            TbsLog.m80434i("TbsShareManager", "readCoreVersionFromConfig #4");
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (Exception e2) {
                                }
                            }
                            AppMethodBeat.m2505o(64593);
                        } else {
                            TbsLog.m80434i("TbsShareManager", "readCoreVersionFromConfig #3");
                            i = Math.max(Integer.parseInt(property), 0);
                            if (bufferedInputStream3 != null) {
                                try {
                                    bufferedInputStream3.close();
                                } catch (Exception e3) {
                                }
                            }
                            AppMethodBeat.m2505o(64593);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedInputStream3 != null) {
                            try {
                                bufferedInputStream3.close();
                            } catch (Exception e4) {
                            }
                        }
                        AppMethodBeat.m2505o(64593);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream3 = bufferedInputStream2;
                if (bufferedInputStream3 != null) {
                }
                AppMethodBeat.m2505o(64593);
                throw th;
            }
        }
        return i;
    }

    /* renamed from: i */
    static boolean m49475i(Context context) {
        AppMethodBeat.m2504i(64596);
        try {
            if (f13857e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (f13857e == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                AppMethodBeat.m2505o(64596);
                return false;
            }
            if (f13855c == null) {
                if (f13857e != 0 && getSharedTbsCoreVersion(context, f13858f) == f13857e) {
                    AppMethodBeat.m2505o(64596);
                    return true;
                }
            } else if (f13857e != 0 && C5813an.m8800a().mo12148a(f13855c) == f13857e) {
                AppMethodBeat.m2505o(64596);
                return true;
            }
            if (m49478l(context)) {
                AppMethodBeat.m2505o(64596);
                return true;
            }
            TbsCoreLoadStat.getInstance().mo64872a(context, 418, new Throwable("mAvailableCoreVersion=" + f13857e + "; mSrcPackageName=" + f13858f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f13858f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            f13856d = null;
            f13857e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.m71035a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            AppMethodBeat.m2505o(64596);
            return false;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            AppMethodBeat.m2505o(64596);
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        AppMethodBeat.m2504i(64571);
        try {
            if (f13853a == null || !f13853a.equals(context.getApplicationContext())) {
                Context applicationContext = context.getApplicationContext();
                f13853a = applicationContext;
                String packageName = applicationContext.getPackageName();
                for (Object equals : getCoreProviderAppList()) {
                    if (packageName.equals(equals)) {
                        f13854b = false;
                        AppMethodBeat.m2505o(64571);
                        return false;
                    }
                }
                f13854b = true;
                AppMethodBeat.m2505o(64571);
                return true;
            }
            boolean z = f13854b;
            AppMethodBeat.m2505o(64571);
            return z;
        } catch (Throwable th) {
        }
    }

    /* renamed from: j */
    static boolean m49476j(Context context) {
        AppMethodBeat.m2504i(64597);
        boolean b = m49466b(context, true);
        AppMethodBeat.m2505o(64597);
        return b;
    }

    /* renamed from: k */
    private static boolean m49477k(Context context) {
        AppMethodBeat.m2504i(64582);
        if (f13858f == null) {
            AppMethodBeat.m2505o(64582);
            return false;
        } else if (f13857e == getSharedTbsCoreVersion(context, f13858f)) {
            AppMethodBeat.m2505o(64582);
            return true;
        } else {
            AppMethodBeat.m2505o(64582);
            return false;
        }
    }

    /* renamed from: l */
    private static boolean m49478l(Context context) {
        AppMethodBeat.m2504i(64583);
        if (QbSdk.getOnlyDownload()) {
            AppMethodBeat.m2505o(64583);
            return false;
        }
        for (String str : getCoreProviderAppList()) {
            if (f13857e > 0 && f13857e == getSharedTbsCoreVersion(context, str)) {
                Context packageContext = getPackageContext(context, str, true);
                if (C5813an.m8800a().mo12171f(context)) {
                    f13856d = C5813an.m8800a().mo12157b(context, packageContext).getAbsolutePath();
                    f13858f = str;
                    AppMethodBeat.m2505o(64583);
                    return true;
                }
            }
        }
        AppMethodBeat.m2505o(64583);
        return false;
    }

    /* renamed from: m */
    private static boolean m49479m(Context context) {
        AppMethodBeat.m2504i(64585);
        if (context == null) {
            AppMethodBeat.m2505o(64585);
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        AppMethodBeat.m2505o(64585);
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0029=Splitter:B:16:0x0029, B:45:0x00fd=Splitter:B:45:0x00fd} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0115 A:{SYNTHETIC, Splitter:B:59:0x0115} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    private static void m49480n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        AppMethodBeat.m2504i(64594);
        if (f13864l) {
            AppMethodBeat.m2505o(64594);
            return;
        }
        synchronized (TbsShareManager.class) {
            try {
                if (f13864l) {
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
                            AppMethodBeat.m2505o(64594);
                            return;
                        }
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                        try {
                            Properties properties = new Properties();
                            properties.load(bufferedInputStream);
                            String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                f13857e = Math.max(Integer.parseInt(property), 0);
                                TbsLog.m80434i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + f13857e + " " + Log.getStackTraceString(new Throwable("#")));
                            }
                            property = properties.getProperty("core_packagename", "");
                            if (!"".equals(property)) {
                                f13858f = property;
                            }
                            if (!(f13858f == null || f13853a == null)) {
                                if (f13858f.equals(f13853a.getPackageName())) {
                                    f13863k = true;
                                } else {
                                    f13863k = false;
                                }
                            }
                            property = properties.getProperty("core_path", "");
                            if (!"".equals(property)) {
                                f13856d = property;
                            }
                            property = properties.getProperty("app_version", "");
                            if (!"".equals(property)) {
                                f13862j = property;
                            }
                            f13859g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            f13864l = true;
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
                            AppMethodBeat.m2505o(64594);
                            throw th;
                        }
                        AppMethodBeat.m2505o(64594);
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream2 = bufferedInputStream3;
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (Exception e3) {
                            }
                        }
                        AppMethodBeat.m2505o(64594);
                        throw th;
                    }
                }
            } finally {
                AppMethodBeat.m2505o(64594);
            }
        }
        return;
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        AppMethodBeat.m2505o(64594);
    }

    public static void setHostCorePathAppDefined(String str) {
        f13855c = str;
    }

    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i, boolean z) {
        Object obj = 1;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.m2504i(64587);
            TbsLog.m80434i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is ".concat(String.valueOf(i)));
            if (i == 0) {
                m49479m(context);
                TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-401);
                AppMethodBeat.m2505o(64587);
            } else {
                int h = m49474h(context);
                TbsLog.m80434i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is ".concat(String.valueOf(h)));
                if (h < 0) {
                    TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-402);
                    AppMethodBeat.m2505o(64587);
                } else if (i == h) {
                    if (m49469d(context) == 0 && !z) {
                        m49463a(context, i);
                    }
                    m49468c(context, z);
                    TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-403);
                    AppMethodBeat.m2505o(64587);
                } else if (i < h) {
                    m49479m(context);
                    TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-404);
                    AppMethodBeat.m2505o(64587);
                } else {
                    h = C5813an.m8800a().mo12175j(context);
                    TbsLog.m80434i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ".concat(String.valueOf(h)));
                    if (i < h) {
                        m49479m(context);
                        TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-404);
                        AppMethodBeat.m2505o(64587);
                    } else {
                        String[] d = m49470d(context, z);
                        if (f13855c != null) {
                            File tbsShareFile;
                            TbsLinuxToolsJni tbsLinuxToolsJni;
                            if (i == C5813an.m8800a().mo12148a(f13855c)) {
                                writeProperties(context, Integer.toString(i), "AppDefined", f13855c, Integer.toString(1));
                                try {
                                    tbsShareFile = getTbsShareFile(context, "core_info");
                                    if (!(f13861i || tbsShareFile == null)) {
                                        tbsLinuxToolsJni = new TbsLinuxToolsJni(f13853a);
                                        tbsLinuxToolsJni.mo70610a(tbsShareFile.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni.mo70610a(C5813an.m8800a().mo12184s(context).getAbsolutePath(), "755");
                                        f13861i = true;
                                    }
                                    AppMethodBeat.m2505o(64587);
                                } catch (Throwable th) {
                                    AppMethodBeat.m2505o(64587);
                                }
                            } else if (i > C5813an.m8800a().mo12148a(f13855c)) {
                                for (String str : d) {
                                    if (i == getSharedTbsCoreVersion(context, str)) {
                                        Context packageContext = getPackageContext(context, str, true);
                                        String absolutePath = C5813an.m8800a().mo12183r(packageContext).getAbsolutePath();
                                        C36443b.m60185b(context);
                                        if (C5813an.m8800a().mo12171f(packageContext)) {
                                            try {
                                                C30950k.m49556a(new File(absolutePath), new File(f13855c), new C44455bc());
                                                writeProperties(context, Integer.toString(i), "AppDefined", f13855c, Integer.toString(1));
                                                tbsShareFile = getTbsShareFile(context, "core_info");
                                                if (!(f13861i || tbsShareFile == null)) {
                                                    tbsLinuxToolsJni = new TbsLinuxToolsJni(f13853a);
                                                    tbsLinuxToolsJni.mo70610a(tbsShareFile.getAbsolutePath(), "644");
                                                    tbsLinuxToolsJni.mo70610a(C5813an.m8800a().mo12184s(context).getAbsolutePath(), "755");
                                                    f13861i = true;
                                                }
                                                AppMethodBeat.m2505o(64587);
                                            } catch (Throwable th2) {
                                                AppMethodBeat.m2505o(64587);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        for (String str2 : d) {
                            if (i == getSharedTbsCoreVersion(context, str2)) {
                                Context packageContext2 = getPackageContext(context, str2, true);
                                String absolutePath2 = C5813an.m8800a().mo12183r(packageContext2).getAbsolutePath();
                                int b = C36443b.m60185b(context);
                                if (C5813an.m8800a().mo12171f(packageContext2)) {
                                    if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                        TbsLog.m80434i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:".concat(String.valueOf(i)));
                                        try {
                                            C30950k.m49564b(C5813an.m8800a().mo12183r(context));
                                            TbsLog.m80434i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                        } catch (Throwable th3) {
                                        }
                                    }
                                    writeProperties(context, Integer.toString(i), str2, absolutePath2, Integer.toString(b));
                                    try {
                                        File tbsShareFile2 = getTbsShareFile(context, "core_info");
                                        if (!(f13861i || tbsShareFile2 == null)) {
                                            TbsLinuxToolsJni tbsLinuxToolsJni2 = new TbsLinuxToolsJni(f13853a);
                                            tbsLinuxToolsJni2.mo70610a(tbsShareFile2.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni2.mo70610a(C5813an.m8800a().mo12184s(context).getAbsolutePath(), "755");
                                            f13861i = true;
                                        }
                                    } catch (Throwable th4) {
                                    }
                                    if (obj == null && !z) {
                                        m49463a(context, i);
                                    }
                                    AppMethodBeat.m2505o(64587);
                                }
                            }
                        }
                        obj = null;
                        m49463a(context, i);
                        AppMethodBeat.m2505o(64587);
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
        AppMethodBeat.m2504i(64590);
        TbsLog.m80434i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        TbsLog.m80434i("TbsShareManager", "writeProperties -- stack: " + Log.getStackTraceString(new Throwable("#")));
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream2 = null;
        BufferedOutputStream bufferedOutputStream3;
        try {
            File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-405);
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
                AppMethodBeat.m2505o(64590);
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
                    f13864l = false;
                    TbsDownloadConfig.getInstance(f13853a).setDownloadInterruptCode(-406);
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
                    AppMethodBeat.m2505o(64590);
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream = bufferedOutputStream3;
                    if (bufferedInputStream != null) {
                    }
                    if (bufferedOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(64590);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream = null;
                if (bufferedInputStream != null) {
                }
                if (bufferedOutputStream != null) {
                }
                AppMethodBeat.m2505o(64590);
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
            AppMethodBeat.m2505o(64590);
            throw th;
        }
    }
}
