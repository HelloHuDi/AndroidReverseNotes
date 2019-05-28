package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.utils.C24272a;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C36449x;
import com.tencent.smtt.utils.C5822y;
import com.tencent.smtt.utils.TbsLog;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.smtt.sdk.an */
class C5813an {
    /* renamed from: a */
    public static ThreadLocal<Integer> f1398a = new C16147ao();
    /* renamed from: b */
    static boolean f1399b = false;
    /* renamed from: c */
    static final FileFilter f1400c = new C40973ap();
    /* renamed from: d */
    private static C5813an f1401d = null;
    /* renamed from: i */
    private static final ReentrantLock f1402i = new ReentrantLock();
    /* renamed from: j */
    private static final Lock f1403j = new ReentrantLock();
    /* renamed from: l */
    private static FileLock f1404l = null;
    /* renamed from: m */
    private static Handler f1405m = null;
    /* renamed from: n */
    private static final Long[][] f1406n;
    /* renamed from: o */
    private static int f1407o = 0;
    /* renamed from: p */
    private static boolean f1408p = false;
    /* renamed from: e */
    private int f1409e = 0;
    /* renamed from: f */
    private FileLock f1410f;
    /* renamed from: g */
    private FileOutputStream f1411g;
    /* renamed from: h */
    private boolean f1412h = false;
    /* renamed from: k */
    private boolean f1413k = false;

    static {
        AppMethodBeat.m2504i(64474);
        r0 = new Long[11][];
        r0[0] = new Long[]{Long.valueOf(44006), Long.valueOf(39094008)};
        r0[1] = new Long[]{Long.valueOf(44005), Long.valueOf(39094008)};
        r0[2] = new Long[]{Long.valueOf(43910), Long.valueOf(38917816)};
        r0[3] = new Long[]{Long.valueOf(44027), Long.valueOf(39094008)};
        r0[4] = new Long[]{Long.valueOf(44028), Long.valueOf(39094008)};
        r0[5] = new Long[]{Long.valueOf(44029), Long.valueOf(39094008)};
        r0[6] = new Long[]{Long.valueOf(44030), Long.valueOf(39094008)};
        r0[7] = new Long[]{Long.valueOf(44032), Long.valueOf(39094008)};
        r0[8] = new Long[]{Long.valueOf(44033), Long.valueOf(39094008)};
        r0[9] = new Long[]{Long.valueOf(44034), Long.valueOf(39094008)};
        r0[10] = new Long[]{Long.valueOf(43909), Long.valueOf(38917816)};
        f1406n = r0;
        AppMethodBeat.m2505o(64474);
    }

    private C5813an() {
        AppMethodBeat.m2504i(64405);
        if (f1405m == null) {
            f1405m = new C36434aq(this, C24267al.m37429a().getLooper());
        }
        AppMethodBeat.m2505o(64405);
    }

    /* renamed from: A */
    private void m8794A(Context context) {
        AppMethodBeat.m2504i(64442);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (m8821z(context)) {
            try {
                m8796C(context);
                m8797D(context);
                TbsLog.m80434i("TbsInstaller", "after renameTbsCoreShareDir");
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.m80434i("TbsInstaller", "is thirdapp and not chmod");
                } else {
                    TbsLog.m80434i("TbsInstaller", "prepare to shareTbsCore");
                    TbsShareManager.m49462a(context);
                }
                C36432ai.m60088a(context).mo57538a(0);
                C36432ai.m60088a(context).mo57545b(0);
                C36432ai.m60088a(context).mo57552d(0);
                C36432ai.m60088a(context).mo57541a("incrupdate_retry_num", 0);
                C36432ai.m60088a(context).mo57546b(0, 3);
                C36432ai.m60088a(context).mo57540a("");
                C36432ai.m60088a(context).mo57549c(-1);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == C5813an.m8800a().mo12174i(context) || i != C5813an.m8800a().mo12175j(context)) {
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + C5813an.m8800a().mo12174i(context) + " getTbsCoreInstalledVerInNolock is " + C5813an.m8800a().mo12175j(context));
                    } else {
                        mo12180o(context);
                    }
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsShareManager.writeCoreInfoForThirdPartyApp(context, mo12179n(context), true);
                }
                f1398a.set(Integer.valueOf(0));
                f1407o = 0;
            } catch (Throwable th) {
                TbsLogReport.getInstance(context).setInstallErrorCode(219, "exception when renameing from unzip:" + th.toString());
                TbsLog.m80433e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
            }
            mo12172g(context);
            AppMethodBeat.m2505o(64442);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "get rename fileLock#4 ## failed!");
        AppMethodBeat.m2505o(64442);
    }

    /* renamed from: B */
    private void m8795B(Context context) {
        AppMethodBeat.m2504i(64443);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (m8821z(context)) {
            try {
                m8796C(context);
                m8798E(context);
                TbsShareManager.m49462a(context);
                C36432ai.m60088a(context).mo57539a(0, 3);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == C5813an.m8800a().mo12174i(context) || i != C5813an.m8800a().mo12175j(context)) {
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + C5813an.m8800a().mo12174i(context) + " getTbsCoreInstalledVerInNolock is " + C5813an.m8800a().mo12175j(context));
                    } else {
                        mo12180o(context);
                    }
                }
                f1398a.set(Integer.valueOf(0));
            } catch (Exception e) {
                TbsLogReport.getInstance(context).setInstallErrorCode(219, "exception when renameing from copy:" + e.toString());
            }
            mo12172g(context);
            AppMethodBeat.m2505o(64443);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "get rename fileLock#4 ## failed!");
        AppMethodBeat.m2505o(64443);
    }

    /* renamed from: C */
    private void m8796C(Context context) {
        AppMethodBeat.m2504i(64453);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--deleteOldCore");
        C30950k.m49550a(mo12183r(context), false);
        AppMethodBeat.m2505o(64453);
    }

    /* renamed from: D */
    private void m8797D(Context context) {
        AppMethodBeat.m2504i(64454);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--renameShareDir");
        File u = mo12185u(context);
        File r = mo12183r(context);
        if (u == null || r == null) {
            AppMethodBeat.m2505o(64454);
            return;
        }
        boolean renameTo = u.renameTo(r);
        if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
            if (renameTo) {
                TbsLogReport.getInstance(context).setInstallErrorCode(230, " ");
            } else {
                TbsLogReport.getInstance(context).setInstallErrorCode(231, " ");
            }
        }
        m8817f(context, false);
        AppMethodBeat.m2505o(64454);
    }

    /* renamed from: E */
    private void m8798E(Context context) {
        AppMethodBeat.m2504i(64456);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File w = mo12187w(context);
        File r = mo12183r(context);
        if (w == null || r == null) {
            AppMethodBeat.m2505o(64456);
            return;
        }
        w.renameTo(r);
        m8817f(context, false);
        AppMethodBeat.m2505o(64456);
    }

    /* renamed from: F */
    private void m8799F(Context context) {
        AppMethodBeat.m2504i(64457);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File u = mo12185u(context);
        if (u != null) {
            C30950k.m49550a(u, false);
        }
        C36432ai.m60088a(context).mo57546b(0, 5);
        C36432ai.m60088a(context).mo57549c(-1);
        QbSdk.m71035a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
        AppMethodBeat.m2505o(64457);
    }

    /* renamed from: a */
    static synchronized C5813an m8800a() {
        C5813an c5813an;
        synchronized (C5813an.class) {
            AppMethodBeat.m2504i(64406);
            if (f1401d == null) {
                synchronized (C5813an.class) {
                    try {
                        if (f1401d == null) {
                            f1401d = new C5813an();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(64406);
                        }
                    }
                }
            }
            c5813an = f1401d;
            AppMethodBeat.m2505o(64406);
        }
        return c5813an;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092 A:{SYNTHETIC, Splitter:B:19:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097 A:{SYNTHETIC, Splitter:B:22:0x0097} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A:{SYNTHETIC, Splitter:B:30:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae A:{SYNTHETIC, Splitter:B:33:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092 A:{SYNTHETIC, Splitter:B:19:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0097 A:{SYNTHETIC, Splitter:B:22:0x0097} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a9 A:{SYNTHETIC, Splitter:B:30:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae A:{SYNTHETIC, Splitter:B:33:0x00ae} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private void m8801a(int i, String str, Context context) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.m2504i(64422);
        new File(str).delete();
        TbsLog.m80435i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file.canRead()) {
            File file2 = new File(file, "tbs.conf");
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                } catch (Throwable th2) {
                    th = th2;
                    bufferedOutputStream2 = null;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    AppMethodBeat.m2505o(64422);
                    throw th;
                }
                try {
                    properties.setProperty("tbs_local_installation", "true");
                    properties.store(bufferedOutputStream, null);
                    TbsLog.m80435i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                    }
                    try {
                        bufferedInputStream.close();
                        AppMethodBeat.m2505o(64422);
                        return;
                    } catch (IOException e2) {
                        AppMethodBeat.m2505o(64422);
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    AppMethodBeat.m2505o(64422);
                    throw th;
                }
            } catch (Throwable th22) {
                th = th22;
                bufferedOutputStream2 = null;
                bufferedInputStream = null;
                if (bufferedOutputStream2 != null) {
                    try {
                        bufferedOutputStream2.close();
                    } catch (IOException e3) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(64422);
                throw th;
            }
        }
        AppMethodBeat.m2505o(64422);
    }

    /* renamed from: a */
    public static void m8802a(Context context) {
        AppMethodBeat.m2504i(64411);
        if (!C5813an.m8820y(context)) {
            if (C5813an.m8808a(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().mo64872a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.m80432e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
                AppMethodBeat.m2505o(64411);
                return;
            } else if (C5813an.m8808a(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().mo64872a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.m80432e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
                AppMethodBeat.m2505o(64411);
                return;
            } else if (C5813an.m8808a(context, "core_copy_tmp")) {
                TbsCoreLoadStat.getInstance().mo64872a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.m80432e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
        AppMethodBeat.m2505o(64411);
    }

    /* JADX WARNING: Removed duplicated region for block: B:196:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x033f A:{SYNTHETIC, Splitter:B:96:0x033f} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0540 A:{SYNTHETIC, Splitter:B:168:0x0540} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04c4 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0544 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04d9 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0566 A:{SYNTHETIC, Splitter:B:174:0x0566} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0505 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03d9 A:{SYNTHETIC, Splitter:B:121:0x03d9} */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x033f A:{SYNTHETIC, Splitter:B:96:0x033f} */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x046a A:{SKIP, Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04c4 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0540 A:{SYNTHETIC, Splitter:B:168:0x0540} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04d9 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0544 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0505 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0566 A:{SYNTHETIC, Splitter:B:174:0x0566} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x03df A:{Splitter:B:83:0x0317, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x03d9 A:{SYNTHETIC, Splitter:B:121:0x03d9} */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x063e  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x033f A:{SYNTHETIC, Splitter:B:96:0x033f} */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x046a A:{SKIP, Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0540 A:{SYNTHETIC, Splitter:B:168:0x0540} */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x04c4 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0544 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x04d9 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0566 A:{SYNTHETIC, Splitter:B:174:0x0566} */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0505 A:{Catch:{ Exception -> 0x03ec }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x03e2 A:{SYNTHETIC, Splitter:B:126:0x03e2} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:122:?, code skipped:
            r2.close();
     */
    /* JADX WARNING: Missing block: B:124:0x03df, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:127:?, code skipped:
            r2.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    /* renamed from: a */
    private void m8803a(Context context, Context context2, int i) {
        Editor edit;
        Throwable th;
        Exception e;
        AppMethodBeat.m2504i(64427);
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (mo12165c(context2)) {
            AppMethodBeat.m2505o(64427);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ".concat(String.valueOf(i)));
        if ((VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m80432e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
            AppMethodBeat.m2505o(64427);
        } else if (mo12188x(context2)) {
            boolean tryLock = f1403j.tryLock();
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is ".concat(String.valueOf(tryLock)));
            if (tryLock) {
                f1402i.lock();
                File file = null;
                try {
                    int c = C36432ai.m60088a(context2).mo57548c("copy_core_ver");
                    int b = C36432ai.m60088a(context2).mo57544b("copy_status");
                    if (c == i) {
                        QbSdk.f16251m.onInstallFinish(220);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                        f1402i.unlock();
                        f1403j.unlock();
                        mo12158b();
                        AppMethodBeat.m2505o(64427);
                        return;
                    }
                    int j = mo12175j(context2);
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=".concat(String.valueOf(j)));
                    if (j == i) {
                        QbSdk.f16251m.onInstallFinish(220);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is ".concat(String.valueOf(j)));
                        f1402i.unlock();
                        f1403j.unlock();
                        mo12158b();
                        AppMethodBeat.m2505o(64427);
                        return;
                    }
                    int b2 = C36432ai.m60088a(context2).mo57543b();
                    if ((b2 > 0 && i > b2) || (c > 0 && i > c)) {
                        mo12181p(context2);
                    }
                    if (b == 3 && j > 0 && (i > j || i == 88888888)) {
                        b = -1;
                        mo12181p(context2);
                        TbsLog.m80435i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                    }
                    long currentTimeMillis;
                    if (C30950k.m49565b(context2)) {
                        if (b > 0) {
                            if (TbsShareManager.isThirdPartyApp(context2) || TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1 || i == mo12174i(context2)) {
                                TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + mo12174i(context2));
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64427);
                                return;
                            }
                        }
                        if (b == 0) {
                            b = C36432ai.m60088a(context2).mo57548c("copy_retry_num");
                            if (b > 2) {
                                TbsLogReport.getInstance(context2).setInstallErrorCode(211, "exceed copy retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64427);
                                return;
                            }
                            C36432ai.m60088a(context2).mo57541a("copy_retry_num", b + 1);
                        }
                        File r = mo12183r(context);
                        File q = !TbsShareManager.isThirdPartyApp(context2) ? TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1 ? mo12182q(context2) : mo12187w(context2) : mo12187w(context2);
                        if (r == null || q == null) {
                            if (r == null) {
                                TbsLogReport.getInstance(context2).setInstallErrorCode(213, "src-dir is null when copying tbs core!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-535);
                            }
                            if (q == null) {
                                TbsLogReport.getInstance(context2).setInstallErrorCode(214, "dst-dir is null when copying tbs core!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-536);
                            }
                        } else {
                            C36432ai.m60088a(context2).mo57539a(i, 0);
                            C36449x c36449x = new C36449x();
                            c36449x.mo57641a(r);
                            currentTimeMillis = System.currentTimeMillis();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                            boolean a = C30950k.m49556a(r, q, f1400c);
                            if (TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                TbsShareManager.m49465b(context2);
                            }
                            TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread time=" + (System.currentTimeMillis() - currentTimeMillis));
                            if (a) {
                                c36449x.mo57643b(r);
                                if (c36449x.mo57642a()) {
                                    Properties properties;
                                    Object obj = 1;
                                    BufferedInputStream bufferedInputStream = null;
                                    Properties properties2;
                                    try {
                                        BufferedInputStream bufferedInputStream2;
                                        File file2 = new File(q, "1");
                                        properties2 = new Properties();
                                        if (file2.exists()) {
                                            bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file2));
                                            try {
                                                properties2.load(bufferedInputStream2);
                                            } catch (Exception e2) {
                                                bufferedInputStream = bufferedInputStream2;
                                                if (bufferedInputStream != null) {
                                                }
                                                properties = properties2;
                                                if (obj == null) {
                                                }
                                                TbsLog.m80434i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                                if (obj != null) {
                                                }
                                                try {
                                                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                    m8817f(context2, true);
                                                    file = C36431ag.m60063b(context);
                                                    if (TbsDownloader.getOverSea(context2)) {
                                                    }
                                                    C36431ag.m60060a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                                    C36432ai.m60088a(context2).mo57539a(i, 1);
                                                    if (this.f1413k) {
                                                    }
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                                    if (VERSION.SDK_INT < 11) {
                                                    }
                                                    try {
                                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                                        edit.putInt("tbs_preload_x5_counter", 0);
                                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                                        edit.putInt("tbs_preload_x5_version", i);
                                                        edit.commit();
                                                    } catch (Throwable th2) {
                                                        TbsLog.m80432e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th2));
                                                    }
                                                    C5822y.m8883a(context2);
                                                    f1402i.unlock();
                                                    f1403j.unlock();
                                                    mo12158b();
                                                    AppMethodBeat.m2505o(64427);
                                                    return;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    file = q;
                                                    try {
                                                        TbsLogReport.getInstance(context2).setInstallErrorCode(215, e.toString());
                                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                                                        C30950k.m49550a(file, false);
                                                        C36432ai.m60088a(context2).mo57539a(0, -1);
                                                    } catch (Exception e4) {
                                                        TbsLog.m80432e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e4.getMessage() + "," + e4.getCause());
                                                    } catch (Throwable th3) {
                                                        f1402i.unlock();
                                                        f1403j.unlock();
                                                        mo12158b();
                                                        AppMethodBeat.m2505o(64427);
                                                    }
                                                    f1402i.unlock();
                                                    f1403j.unlock();
                                                    mo12158b();
                                                    AppMethodBeat.m2505o(64427);
                                                    return;
                                                }
                                            } catch (Throwable th4) {
                                                th2 = th4;
                                                bufferedInputStream = bufferedInputStream2;
                                                if (bufferedInputStream != null) {
                                                }
                                                AppMethodBeat.m2505o(64427);
                                                throw th2;
                                            }
                                        }
                                        obj = null;
                                        bufferedInputStream2 = null;
                                        if (bufferedInputStream2 != null) {
                                            try {
                                                bufferedInputStream2.close();
                                            } catch (IOException e5) {
                                            }
                                        }
                                        properties = properties2;
                                    } catch (Exception e6) {
                                        properties2 = null;
                                        if (bufferedInputStream != null) {
                                        }
                                        properties = properties2;
                                        if (obj == null) {
                                        }
                                        TbsLog.m80434i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                        if (obj != null) {
                                        }
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        m8817f(context2, true);
                                        file = C36431ag.m60063b(context);
                                        if (TbsDownloader.getOverSea(context2)) {
                                        }
                                        C36431ag.m60060a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                        C36432ai.m60088a(context2).mo57539a(i, 1);
                                        if (this.f1413k) {
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                        if (VERSION.SDK_INT < 11) {
                                        }
                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                        edit.putInt("tbs_preload_x5_counter", 0);
                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                        edit.putInt("tbs_preload_x5_version", i);
                                        edit.commit();
                                        C5822y.m8883a(context2);
                                        f1402i.unlock();
                                        f1403j.unlock();
                                        mo12158b();
                                        AppMethodBeat.m2505o(64427);
                                        return;
                                    } catch (Throwable th5) {
                                    }
                                    if (obj == null) {
                                        File[] listFiles = q.listFiles();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                        tryLock = true;
                                        for (File file3 : listFiles) {
                                            if (!("1".equals(file3.getName()) || file3.getName().endsWith(".dex") || "tbs.conf".equals(file3.getName()) || file3.isDirectory() || file3.getName().endsWith(".prof"))) {
                                                String a2 = C24272a.m37434a(file3);
                                                String property = properties.getProperty(file3.getName(), "");
                                                if (property.equals("") || !a2.equals(property)) {
                                                    tryLock = false;
                                                    TbsLog.m80432e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + a2);
                                                    break;
                                                }
                                                TbsLog.m80434i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                                                tryLock = true;
                                            }
                                        }
                                    } else {
                                        tryLock = true;
                                    }
                                    TbsLog.m80434i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                    if (obj != null || tryLock) {
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        m8817f(context2, true);
                                        file = C36431ag.m60063b(context);
                                        if (file != null && file.exists()) {
                                            C36431ag.m60060a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                        }
                                        C36432ai.m60088a(context2).mo57539a(i, 1);
                                        if (this.f1413k) {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(220, "continueInstallWithout core success");
                                        } else {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(220, "success");
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                        edit.putInt("tbs_preload_x5_counter", 0);
                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                        edit.putInt("tbs_preload_x5_version", i);
                                        edit.commit();
                                        C5822y.m8883a(context2);
                                    } else {
                                        TbsLog.m80432e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                        C30950k.m49550a(q, true);
                                        TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify md5 fail after copying tbs core!");
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                        f1402i.unlock();
                                        f1403j.unlock();
                                        mo12158b();
                                        AppMethodBeat.m2505o(64427);
                                        return;
                                    }
                                }
                                TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                C30950k.m49550a(q, true);
                                TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify fail after copying tbs core!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64427);
                                return;
                            }
                            TbsLog.m80434i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                            C36432ai.m60088a(context2).mo57539a(i, 2);
                            C30950k.m49550a(q, false);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                            TbsLogReport.getInstance(context2).setInstallErrorCode(212, "copy fail!");
                        }
                        f1402i.unlock();
                        f1403j.unlock();
                        mo12158b();
                        AppMethodBeat.m2505o(64427);
                        return;
                    }
                    long a3 = C5822y.m8882a();
                    currentTimeMillis = TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                    TbsLogReport.getInstance(context2).setInstallErrorCode(210, "rom is not enough when copying tbs core! curAvailROM=" + a3 + ",minReqRom=" + currentTimeMillis);
                    f1402i.unlock();
                    f1403j.unlock();
                    mo12158b();
                    AppMethodBeat.m2505o(64427);
                    return;
                } catch (Exception e7) {
                    e4 = e7;
                    TbsLogReport.getInstance(context2).setInstallErrorCode(215, e4.toString());
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                    C30950k.m49550a(file, false);
                    C36432ai.m60088a(context2).mo57539a(0, -1);
                    f1402i.unlock();
                    f1403j.unlock();
                    mo12158b();
                    AppMethodBeat.m2505o(64427);
                    return;
                }
            }
            mo12158b();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
            AppMethodBeat.m2505o(64427);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
            AppMethodBeat.m2505o(64427);
        }
    }

    /* renamed from: a */
    private boolean m8806a(Context context, File file) {
        AppMethodBeat.m2504i(64431);
        boolean a = m8807a(context, file, false);
        AppMethodBeat.m2505o(64431);
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x013a A:{Splitter:B:21:0x00a8, ExcHandler: IOException (r1_15 'e' java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:47:0x013a, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:49:?, code skipped:
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r11).setInstallInterruptCode(-523);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(r11).setInstallErrorCode(206, r1);
     */
    /* JADX WARNING: Missing block: B:50:0x014d, code skipped:
            if (r4 == null) goto L_0x021b;
     */
    /* JADX WARNING: Missing block: B:53:0x0155, code skipped:
            r1 = true;
     */
    /* JADX WARNING: Missing block: B:57:?, code skipped:
            com.tencent.smtt.utils.C30950k.m49564b(r4);
            com.tencent.smtt.utils.TbsLog.m80432e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + r4.exists());
     */
    /* JADX WARNING: Missing block: B:71:0x01d0, code skipped:
            com.tencent.smtt.utils.TbsLog.m80434i("TbsInstaller", "TbsInstaller-unzipTbs done");
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(64432);
     */
    /* JADX WARNING: Missing block: B:73:0x01dd, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:74:0x01de, code skipped:
            com.tencent.smtt.utils.TbsLog.m80432e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARNING: Missing block: B:79:0x021b, code skipped:
            r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m8807a(Context context, File file, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(64432);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (C30950k.m49570c(file)) {
            File dir;
            try {
                dir = context.getDir("tbs", 0);
                File file2 = z ? new File(dir, "core_share_decouple") : new File(dir, "core_unzip_tmp");
                if (file2.exists() && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                    C30950k.m49564b(file2);
                }
            } catch (Throwable th) {
                TbsLog.m80432e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File v = z ? mo12186v(context) : mo12185u(context);
            if (v == null) {
                TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-521);
                AppMethodBeat.m2505o(64432);
                return false;
            }
            try {
                C30950k.m49554a(v);
                if (z) {
                    C30950k.m49550a(v, true);
                }
                boolean a = C30950k.m49555a(file, v);
                if (a) {
                    a = m8809a(v, context);
                }
                if (z) {
                    String[] list = v.list();
                    for (String file3 : list) {
                        File file4 = new File(v, file3);
                        if (file4.getName().endsWith(".dex")) {
                            file4.delete();
                        }
                    }
                    new File(C5813an.m8819t(context), "x5.tbs").delete();
                }
                if (a) {
                    m8817f(context, true);
                    if (z) {
                        dir = mo12182q(context);
                        C30950k.m49550a(dir, true);
                        v.renameTo(dir);
                        TbsShareManager.m49465b(context);
                    }
                } else {
                    C30950k.m49564b(v);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                    TbsLog.m80432e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + v.exists());
                }
                TbsLog.m80434i("TbsInstaller", "TbsInstaller-unzipTbs done");
                AppMethodBeat.m2505o(64432);
                return a;
            } catch (IOException e) {
            } catch (Exception th2) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                TbsLogReport.getInstance(context).setInstallErrorCode(207, th2);
                if (v == null || !v.exists()) {
                    z2 = false;
                }
                if (z2 && v != null) {
                    C30950k.m49564b(v);
                    TbsLog.m80432e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + v.exists());
                }
            } catch (Throwable th22) {
                TbsLog.m80432e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th22));
            }
        } else {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-520);
            AppMethodBeat.m2505o(64432);
            return false;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-unzipTbs done");
        AppMethodBeat.m2505o(64432);
        return false;
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-unzipTbs done");
        AppMethodBeat.m2505o(64432);
        return false;
    }

    /* renamed from: a */
    static boolean m8808a(Context context, String str) {
        AppMethodBeat.m2504i(64413);
        File file = new File(context.getDir("tbs", 0), str);
        if (!file.exists()) {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
            AppMethodBeat.m2505o(64413);
            return false;
        } else if (new File(file, "tbs.conf").exists()) {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            AppMethodBeat.m2505o(64413);
            return true;
        } else {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
            AppMethodBeat.m2505o(64413);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2 A:{SYNTHETIC, Splitter:B:38:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0146 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00f8 A:{Splitter:B:1:0x002a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f2 A:{SYNTHETIC, Splitter:B:38:0x00f2} */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0146 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A:{SYNTHETIC, Splitter:B:43:0x00fb} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:36:0x00ee, code skipped:
            r0 = null;
            r1 = null;
     */
    /* JADX WARNING: Missing block: B:39:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:41:0x00f8, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:44:?, code skipped:
            r3.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private boolean m8809a(File file, Context context) {
        Properties properties;
        boolean z;
        BufferedInputStream bufferedInputStream;
        boolean z2;
        BufferedInputStream bufferedInputStream2 = null;
        AppMethodBeat.m2504i(64433);
        TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
        try {
            BufferedInputStream bufferedInputStream3;
            File file2 = new File(file, "1");
            properties = new Properties();
            if (file2.exists()) {
                bufferedInputStream3 = new BufferedInputStream(new FileInputStream(file2));
                try {
                    properties.load(bufferedInputStream3);
                    z = true;
                } catch (Exception e) {
                    bufferedInputStream = bufferedInputStream3;
                    if (bufferedInputStream != null) {
                    }
                    z = true;
                    TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
                    if (z) {
                    }
                    z2 = true;
                    TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
                    if (z) {
                    }
                    TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                    AppMethodBeat.m2505o(64433);
                    return true;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(64433);
                    throw th2;
                }
            }
            bufferedInputStream3 = null;
            z = false;
            if (bufferedInputStream3 != null) {
                try {
                    bufferedInputStream3.close();
                } catch (IOException e2) {
                }
            }
        } catch (Exception e3) {
            bufferedInputStream = null;
            if (bufferedInputStream != null) {
            }
            z = true;
            TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
            if (z) {
            }
            z2 = true;
            TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
            if (z) {
            }
            TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            AppMethodBeat.m2505o(64433);
            return true;
        } catch (Throwable th3) {
        }
        TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
        if (z) {
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                if (!("1".equals(file3.getName()) || file3.getName().endsWith(".dex") || "tbs.conf".equals(file3.getName()) || file3.isDirectory() || file3.getName().endsWith(".prof"))) {
                    String a = C24272a.m37434a(file3);
                    String property = properties.getProperty(file3.getName(), "");
                    if (property.equals("") || !property.equals(a)) {
                        TbsLog.m80432e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + a);
                        z2 = false;
                        break;
                    }
                    TbsLog.m80434i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                }
            }
        }
        z2 = true;
        TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
        if (z || z2) {
            TbsLog.m80434i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            AppMethodBeat.m2505o(64433);
            return true;
        }
        TbsLog.m80432e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
        AppMethodBeat.m2505o(64433);
        return false;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:133:0x05a3=Splitter:B:133:0x05a3, B:58:0x02d4=Splitter:B:58:0x02d4, B:145:0x061d=Splitter:B:145:0x061d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    /* renamed from: b */
    private void m8810b(Context context, String str, int i) {
        int i2 = 200;
        int i3 = 0;
        AppMethodBeat.m2504i(64415);
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (mo12165c(context)) {
            TbsLog.m80435i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            AppMethodBeat.m2505o(64415);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=".concat(String.valueOf(i)));
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.m80432e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            AppMethodBeat.m2505o(64415);
        } else if (!C30950k.m49565b(context)) {
            long a = C5822y.m8882a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + a + ",minReqRom=" + downloadMinFreeSpace);
            AppMethodBeat.m2505o(64415);
        } else if (mo12188x(context)) {
            boolean tryLock = f1403j.tryLock();
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =".concat(String.valueOf(tryLock)));
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                f1402i.lock();
                try {
                    boolean z;
                    int i4;
                    int c = C36432ai.m60088a(context).mo57548c("copy_core_ver");
                    int b = C36432ai.m60088a(context).mo57543b();
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =".concat(String.valueOf(c)));
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =".concat(String.valueOf(b)));
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =".concat(String.valueOf(i)));
                    if ((b > 0 && i > b) || (c > 0 && i > c)) {
                        mo12181p(context);
                    }
                    c = C36432ai.m60088a(context).mo57547c();
                    b = mo12175j(context);
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=".concat(String.valueOf(c)));
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=".concat(String.valueOf(b)));
                    if (c < 0 || c >= 2) {
                        if (c == 3 && b > 0 && (i > b || i == 88888888)) {
                            c = -1;
                            mo12181p(context);
                            TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        z = false;
                        i4 = c;
                    } else {
                        TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z = true;
                        i4 = c;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=".concat(String.valueOf(i4)));
                    String d;
                    if (i4 <= 0) {
                        TbsLog.m80435i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z) {
                            c = C36432ai.m60088a(context).mo57548c("unzip_retry_num");
                            if (c > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                                m8799F(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64415);
                                return;
                            }
                            C36432ai.m60088a(context).mo57545b(c + 1);
                        }
                        if (str == null) {
                            d = C36432ai.m60088a(context).mo57551d("install_apk_path");
                            if (d == null) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64415);
                                return;
                            }
                        }
                        d = str;
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =".concat(String.valueOf(d)));
                        int c2 = mo12163c(context, d);
                        if (c2 == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                            f1402i.unlock();
                            f1403j.unlock();
                            mo12158b();
                            AppMethodBeat.m2505o(64415);
                            return;
                        }
                        C36432ai.m60088a(context).mo57542a("install_apk_path", d);
                        C36432ai.m60088a(context).mo57546b(c2, 0);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (!m8807a(context, new File(d), true)) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed", EventType.TYPE_INSTALL_DECOUPLE);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64415);
                                return;
                            }
                        } else if (!m8806a(context, new File(d))) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                            f1402i.unlock();
                            f1403j.unlock();
                            mo12158b();
                            AppMethodBeat.m2505o(64415);
                            return;
                        }
                        if (z) {
                            c = C36432ai.m60088a(context).mo57544b("unlzma_status");
                            if (c > 5) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(223, "exceed unlzma retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                m8799F(context);
                                C36431ag.m60066c(context);
                                TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.TRUE);
                                TbsDownloadConfig.getInstance(context).commit();
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64415);
                                return;
                            }
                            C36432ai.m60088a(context).mo57552d(c + 1);
                        }
                        TbsLog.m80434i("TbsInstaller", "unlzma begin");
                        b = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                        if (mo12175j(context) != 0) {
                            Object a2 = QbSdk.m71033a(context, "can_unlzma", null);
                            tryLock = (a2 == null || !(a2 instanceof Boolean)) ? false : ((Boolean) a2).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", b);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    bundle.putString("unzip_temp_path", mo12182q(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", mo12185u(context).getAbsolutePath());
                                }
                                a2 = QbSdk.m71033a(context, "unlzma", bundle);
                                if (a2 == null) {
                                    TbsLog.m80434i("TbsInstaller", "unlzma return null");
                                    TbsLogReport.getInstance(context).setInstallErrorCode(222, "unlzma is null");
                                } else if (a2 instanceof Boolean) {
                                    if (((Boolean) a2).booleanValue()) {
                                        TbsLog.m80434i("TbsInstaller", "unlzma success");
                                        i3 = 1;
                                    } else {
                                        TbsLog.m80434i("TbsInstaller", "unlzma return false");
                                        TbsLogReport.getInstance(context).setInstallErrorCode(222, "unlzma return false");
                                    }
                                } else if (a2 instanceof Bundle) {
                                    i3 = 1;
                                } else if (a2 instanceof Throwable) {
                                    TbsLog.m80434i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) a2));
                                    TbsLogReport.getInstance(context).setInstallErrorCode(222, (Throwable) a2);
                                }
                                if (i3 == 0) {
                                    f1402i.unlock();
                                    f1403j.unlock();
                                    mo12158b();
                                    AppMethodBeat.m2505o(64415);
                                    return;
                                }
                            }
                        }
                        TbsLog.m80434i("TbsInstaller", "unlzma finished");
                        C36432ai.m60088a(context).mo57546b(c2, 1);
                        c = c2;
                    } else {
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (str == null) {
                                d = C36432ai.m60088a(context).mo57551d("install_apk_path");
                                if (d == null) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    f1402i.unlock();
                                    f1403j.unlock();
                                    mo12158b();
                                    AppMethodBeat.m2505o(64415);
                                    return;
                                }
                            }
                            d = str;
                            m8807a(context, new File(d), true);
                        }
                        c = 0;
                    }
                    if (i4 < 2) {
                        if (z) {
                            b = C36432ai.m60088a(context).mo57548c("dexopt_retry_num");
                            if (b > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(208, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                m8799F(context);
                                f1402i.unlock();
                                f1403j.unlock();
                                mo12158b();
                                AppMethodBeat.m2505o(64415);
                                return;
                            }
                            C36432ai.m60088a(context).mo57538a(b + 1);
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (m8818f(context, 0)) {
                            C36432ai.m60088a(context).mo57546b(c, 2);
                            TbsLog.m80435i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.m80434i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:".concat(String.valueOf(i)));
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            if (i == 88888888) {
                                m8801a(i, str, context);
                            }
                            if (this.f1413k) {
                                TbsLogReport instance = TbsLogReport.getInstance(context);
                                if (C36432ai.m60088a(context).mo57550d() == 1) {
                                    i2 = 221;
                                }
                                instance.setInstallErrorCode(i2, "continueInstallWithout core success");
                            } else {
                                TbsLogReport.getInstance(context).setInstallErrorCode(C36432ai.m60088a(context).mo57550d() == 1 ? 221 : 200, "success");
                            }
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            f1402i.unlock();
                            f1403j.unlock();
                            mo12158b();
                            AppMethodBeat.m2505o(64415);
                            return;
                        }
                    } else if (i4 == 2) {
                        QbSdk.f16251m.onInstallFinish(200);
                    }
                } catch (Throwable th) {
                    f1402i.unlock();
                    f1403j.unlock();
                    mo12158b();
                    AppMethodBeat.m2505o(64415);
                }
                f1402i.unlock();
                f1403j.unlock();
                mo12158b();
                AppMethodBeat.m2505o(64415);
                return;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            mo12158b();
            AppMethodBeat.m2505o(64415);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            AppMethodBeat.m2505o(64415);
        }
    }

    /* renamed from: b */
    private boolean m8811b(Context context, File file) {
        AppMethodBeat.m2504i(64470);
        try {
            File[] listFiles = file.listFiles(new C30944av(this));
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.m80434i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            AppMethodBeat.m2505o(64470);
            return true;
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e2.toString());
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            AppMethodBeat.m2505o(64470);
            return false;
        }
    }

    /* renamed from: c */
    private boolean m8812c(Context context, File file) {
        AppMethodBeat.m2504i(64471);
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String a = C30949g.m49541a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, "can not find oat command");
                AppMethodBeat.m2505o(64471);
                return false;
            }
            for (File file4 : file.listFiles(new C24268aw(this))) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + a.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + C5813an.m8800a().mo12183r(context) + File.separator + substring + ".jar").waitFor();
            }
            AppMethodBeat.m2505o(64471);
            return true;
        } catch (Exception e) {
            TbsLogReport.getInstance(context).setInstallErrorCode(226, e);
            AppMethodBeat.m2505o(64471);
            return false;
        }
    }

    /* renamed from: c */
    private synchronized boolean m8813c(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.m2504i(64408);
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (mo12188x(context)) {
                    boolean tryLock = f1402i.tryLock();
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        int b = C36432ai.m60088a(context).mo57544b("copy_status");
                        int a = mo12149a(false, context);
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =".concat(String.valueOf(b)));
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =".concat(String.valueOf(a)));
                        if (b == 1) {
                            if (a == 0) {
                                TbsLog.m80435i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                m8795B(context);
                            } else if (z) {
                                TbsLog.m80435i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                m8795B(context);
                            }
                            f1402i.unlock();
                        }
                        z3 = false;
                        try {
                            f1402i.unlock();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                                QbSdk.m71035a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                                z2 = z3;
                                AppMethodBeat.m2505o(64408);
                                return z2;
                            } catch (Throwable th3) {
                                AppMethodBeat.m2505o(64408);
                            }
                        }
                    } else {
                        z3 = false;
                    }
                    mo12158b();
                    z2 = z3;
                    AppMethodBeat.m2505o(64408);
                } else {
                    AppMethodBeat.m2505o(64408);
                }
            } catch (Throwable th4) {
                th = th4;
                z3 = false;
            }
        }
        return z2;
    }

    /* renamed from: d */
    private synchronized boolean m8814d(Context context, boolean z) {
        Object e;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(64409);
            if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(229, " ");
            }
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =".concat(String.valueOf(z)));
            TbsLog.m80434i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
            try {
                if (mo12188x(context)) {
                    TbsLog.m80434i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
                    boolean tryLock = f1402i.tryLock();
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        int c = C36432ai.m60088a(context).mo57547c();
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=".concat(String.valueOf(c)));
                        int a = mo12149a(false, context);
                        if (c == 2) {
                            TbsLog.m80434i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                            if (a == 0) {
                                TbsLog.m80435i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                m8794A(context);
                            } else if (z) {
                                TbsLog.m80435i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                m8794A(context);
                            }
                            f1402i.unlock();
                        }
                        z2 = false;
                        try {
                            f1402i.unlock();
                        } catch (Exception e2) {
                            Exception e3 = e2;
                            QbSdk.m71035a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: ".concat(String.valueOf(e3)));
                            z3 = z2;
                            AppMethodBeat.m2505o(64409);
                            return z3;
                        }
                    }
                    z2 = false;
                    mo12158b();
                    z3 = z2;
                    AppMethodBeat.m2505o(64409);
                } else {
                    AppMethodBeat.m2505o(64409);
                }
            } catch (Exception e4) {
                e3 = e4;
                z2 = false;
            } catch (Throwable th) {
                f1402i.unlock();
                AppMethodBeat.m2505o(64409);
            }
        }
        return z3;
    }

    /* renamed from: e */
    private boolean m8815e(Context context, String str) {
        PackageInfo packageInfo;
        AppMethodBeat.m2504i(64428);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            AppMethodBeat.m2505o(64428);
            return true;
        }
        AppMethodBeat.m2505o(64428);
        return false;
    }

    /* renamed from: e */
    private synchronized boolean m8816e(Context context, boolean z) {
        return false;
    }

    /* renamed from: f */
    private void m8817f(Context context, boolean z) {
        AppMethodBeat.m2504i(64420);
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            AppMethodBeat.m2505o(64420);
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                C30950k.m49564b(file);
            } else if (!file.exists()) {
                file.createNewFile();
                AppMethodBeat.m2505o(64420);
                return;
            }
            AppMethodBeat.m2505o(64420);
        } catch (Exception e) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
            AppMethodBeat.m2505o(64420);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a7 A:{Catch:{ Exception -> 0x00d4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064 A:{Catch:{ Exception -> 0x00d4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00c2 A:{SYNTHETIC, Splitter:B:42:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00ab A:{Catch:{ Exception -> 0x00d4 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:45:0x00d4, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:46:0x00d5, code skipped:
            com.tencent.smtt.sdk.TbsLogReport.getInstance(r10).setInstallErrorCode(209, r0.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    private boolean m8818f(Context context, int i) {
        String property;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.m2504i(64435);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(i)));
        File u;
        switch (i) {
            case 0:
                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == z4) {
                    AppMethodBeat.m2505o(64435);
                    return z4;
                }
                u = mo12185u(context);
            case 1:
                u = mo12187w(context);
            case 2:
                u = mo12183r(context);
                property = System.getProperty("java.vm.version");
                z = (property == null && property.startsWith("2")) ? z4 : false;
                z2 = z;
                z = VERSION.SDK_INT != 23 ? z4 : false;
                z3 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsConfigKey.KEY_STOP_PRE_OAT, false);
                if (z2 && z && !z3) {
                    z5 = z4;
                }
                if (!z5 && m8812c(context, u)) {
                    TbsLog.m80434i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                    AppMethodBeat.m2505o(64435);
                    return z4;
                } else if (z2) {
                    TbsLog.m80434i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                    z4 = m8811b(context, u);
                    AppMethodBeat.m2505o(64435);
                    return z4;
                } else {
                    TbsLog.m80434i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
                    AppMethodBeat.m2505o(64435);
                    return z4;
                }
            default:
                TbsLog.m80432e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(64435);
                return false;
        }
        try {
            property = System.getProperty("java.vm.version");
            if (property == null) {
            }
            z2 = z;
        } catch (Throwable th) {
            TbsLogReport.getInstance(context).setInstallErrorCode(226, th);
            z2 = false;
        }
        if (VERSION.SDK_INT != 23) {
        }
        z3 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsConfigKey.KEY_STOP_PRE_OAT, false);
        z5 = z4;
        if (!z5) {
        }
        if (z2) {
        }
    }

    /* renamed from: t */
    static File m8819t(Context context) {
        AppMethodBeat.m2504i(64463);
        File file = new File(context.getDir("tbs", 0), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64463);
            return file;
        }
        AppMethodBeat.m2505o(64463);
        return null;
    }

    /* renamed from: y */
    private static boolean m8820y(Context context) {
        AppMethodBeat.m2504i(64419);
        if (context == null) {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
            AppMethodBeat.m2505o(64419);
            return true;
        }
        try {
            if (new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                AppMethodBeat.m2505o(64419);
                return true;
            }
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
            AppMethodBeat.m2505o(64419);
            return false;
        } catch (Exception e) {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
            AppMethodBeat.m2505o(64419);
            return true;
        }
    }

    /* renamed from: z */
    private boolean m8821z(Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        AppMethodBeat.m2504i(64441);
        TbsLog.m80434i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            tbsCoreLoadRenameFileLockEnable = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        TbsLog.m80434i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(tbsCoreLoadRenameFileLockEnable)));
        if (tbsCoreLoadRenameFileLockEnable) {
            f1404l = C30950k.m49574f(context);
        } else {
            f1404l = C40978bv.m71073a().mo64919a(context);
        }
        if (f1404l == null) {
            TbsLog.m80434i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            AppMethodBeat.m2505o(64441);
            return false;
        }
        TbsLog.m80434i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        AppMethodBeat.m2505o(64441);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A:{SYNTHETIC, Splitter:B:35:0x006c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public int mo12148a(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(64444);
        if (str == null) {
            AppMethodBeat.m2505o(64444);
        } else {
            BufferedInputStream bufferedInputStream2 = null;
            try {
                File file = new File(new File(str), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        String property = properties.getProperty("tbs_core_version");
                        if (property == null) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                            AppMethodBeat.m2505o(64444);
                        } else {
                            i = Integer.parseInt(property);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            AppMethodBeat.m2505o(64444);
                        }
                    } catch (Exception e3) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(64444);
                        throw th;
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.m2505o(64444);
            } catch (Exception e5) {
                bufferedInputStream = bufferedInputStream2;
            } catch (Throwable th3) {
                th = th3;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e6) {
                    }
                }
                AppMethodBeat.m2505o(64444);
                throw th;
            }
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.m2505o(64444);
        return i;
        AppMethodBeat.m2505o(64444);
        return i;
    }

    /* renamed from: a */
    public int mo12149a(boolean z, Context context) {
        AppMethodBeat.m2504i(64407);
        if (z || ((Integer) f1398a.get()).intValue() <= 0) {
            f1398a.set(Integer.valueOf(mo12175j(context)));
        }
        int intValue = ((Integer) f1398a.get()).intValue();
        AppMethodBeat.m2505o(64407);
        return intValue;
    }

    /* renamed from: a */
    public void mo12150a(Context context, int i) {
        AppMethodBeat.m2504i(64417);
        m8817f(context, true);
        C36432ai.m60088a(context).mo57546b(i, 2);
        AppMethodBeat.m2505o(64417);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo12151a(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(64424);
        if (bundle == null || context == null) {
            AppMethodBeat.m2505o(64424);
            return;
        }
        Object[] objArr = new Object[]{context, bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        f1405m.sendMessage(message);
        AppMethodBeat.m2505o(64424);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo12152a(Context context, String str, int i) {
        AppMethodBeat.m2504i(64414);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(i)));
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        f1405m.sendMessage(message);
        AppMethodBeat.m2505o(64414);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo12153a(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.m2504i(64410);
        if (z) {
            this.f1413k = true;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (mo12188x(context)) {
            int c;
            int b;
            int c2;
            int b2;
            String str = null;
            if (f1402i.tryLock()) {
                try {
                    c = C36432ai.m60088a(context).mo57547c();
                    b = C36432ai.m60088a(context).mo57543b();
                    String d = C36432ai.m60088a(context).mo57551d("install_apk_path");
                    c2 = C36432ai.m60088a(context).mo57548c("copy_core_ver");
                    b2 = C36432ai.m60088a(context).mo57544b("copy_status");
                    f1402i.unlock();
                    str = d;
                } catch (Throwable th) {
                    f1402i.unlock();
                    AppMethodBeat.m2505o(64410);
                }
            } else {
                c2 = 0;
                b2 = -1;
                b = 0;
                c = -1;
            }
            mo12158b();
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=".concat(String.valueOf(c)));
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=".concat(String.valueOf(b)));
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=".concat(String.valueOf(str)));
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=".concat(String.valueOf(c2)));
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=".concat(String.valueOf(b2)));
            if (TbsShareManager.isThirdPartyApp(context)) {
                mo12164c(context, TbsShareManager.m49460a(context, false));
                AppMethodBeat.m2505o(64410);
                return;
            }
            int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i == 1 || i == 2 || i == 4) {
                z2 = true;
            }
            if (!(z2 || i == 0)) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                mo12151a(context, bundle);
            }
            if (c >= 0 && c < 2) {
                mo12152a(context, str, b);
            }
            if (b2 == 0) {
                mo12162b(context, c2);
            }
            AppMethodBeat.m2505o(64410);
            return;
        }
        AppMethodBeat.m2505o(64410);
    }

    /* renamed from: a */
    public synchronized boolean mo12154a(Context context, Context context2) {
        AppMethodBeat.m2504i(64436);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (f1408p) {
            AppMethodBeat.m2505o(64436);
        } else {
            f1408p = true;
            new C46736ar(this, context2, context).start();
            AppMethodBeat.m2505o(64436);
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo12155a(Context context, File file, int i) {
        AppMethodBeat.m2504i(64430);
        TbsLog.m80434i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean a = m8807a(context, file, false);
        TbsLog.m80434i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(a)));
        if (a) {
            C5813an.m8800a().mo12150a(context, i);
        }
        AppMethodBeat.m2505o(64430);
        return a;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public Context mo12156b(Context context, String str) {
        Context context2 = null;
        AppMethodBeat.m2504i(64429);
        try {
            if (context.getPackageName() == str || !TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                context2 = context.createPackageContext(str, 2);
                AppMethodBeat.m2505o(64429);
                return context2;
            }
            AppMethodBeat.m2505o(64429);
            return context2;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64429);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public File mo12157b(Context context, Context context2) {
        AppMethodBeat.m2504i(64459);
        File file = new File(context2.getDir("tbs", 0), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            AppMethodBeat.m2505o(64459);
            return file;
        }
        AppMethodBeat.m2505o(64459);
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: b */
    public synchronized void mo12158b() {
        AppMethodBeat.m2504i(64469);
        int i = this.f1409e;
        this.f1409e = i - 1;
        if (i > 1 || !this.f1412h) {
            TbsLog.m80434i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            AppMethodBeat.m2505o(64469);
        } else {
            TbsLog.m80434i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            C30950k.m49552a(this.f1410f, this.f1411g);
            this.f1412h = false;
            AppMethodBeat.m2505o(64469);
        }
    }

    /* renamed from: b */
    public void mo12159b(Context context) {
        AppMethodBeat.m2504i(64416);
        m8817f(context, true);
        C36432ai.m60088a(context).mo57546b(mo12174i(context), 2);
        AppMethodBeat.m2505o(64416);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x037f  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0339  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02dd  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0339  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public void mo12160b(Context context, Bundle bundle) {
        Throwable e;
        AppMethodBeat.m2504i(64425);
        if (mo12165c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            AppMethodBeat.m2505o(64425);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle == null || context == null) {
            AppMethodBeat.m2505o(64425);
        } else if (!C30950k.m49565b(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + C5822y.m8882a() + ",minReqRom=" + TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace());
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            AppMethodBeat.m2505o(64425);
        } else if (mo12188x(context)) {
            boolean tryLock = f1403j.tryLock();
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=".concat(String.valueOf(tryLock)));
            if (tryLock) {
                Bundle bundle2 = null;
                int i;
                try {
                    QbSdk.setTBSInstallingStatus(true);
                    if (mo12175j(context) <= 0 || C36432ai.m60088a(context).mo57550d() == 1) {
                        QbSdk.setTBSInstallingStatus(false);
                        f1403j.unlock();
                        mo12158b();
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        QbSdk.setTBSInstallingStatus(false);
                        AppMethodBeat.m2505o(64425);
                        return;
                    }
                    i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                    tryLock = i == 1 || i == 2 || i == 4;
                    if (!(tryLock || i == 0)) {
                        int c = C36432ai.m60088a(context).mo57548c("incrupdate_retry_num");
                        String string;
                        String string2;
                        if (c > 5) {
                            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                            string = bundle.getString("old_apk_location");
                            string2 = bundle.getString("new_apk_location");
                            String string3 = bundle.getString("diff_file_location");
                            if (!TextUtils.isEmpty(string)) {
                                C30950k.m49564b(new File(string));
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                C30950k.m49564b(new File(string2));
                            }
                            if (!TextUtils.isEmpty(string3)) {
                                C30950k.m49564b(new File(string3));
                            }
                            TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                            TbsDownloadConfig.getInstance(context).commit();
                            TbsLogReport.getInstance(context).setInstallErrorCode(224, "incrUpdate exceed retry max num");
                            f1403j.unlock();
                            mo12158b();
                            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            QbSdk.setTBSInstallingStatus(false);
                            AppMethodBeat.m2505o(64425);
                            return;
                        }
                        C36432ai.m60088a(context).mo57541a("incrupdate_retry_num", c + 1);
                        File t = C5813an.m8819t(context);
                        if (t != null && new File(t, "x5.tbs").exists()) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                            bundle2 = QbSdk.m71032a(context, bundle);
                            if (bundle2 == null) {
                                try {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(228, "result null : " + bundle.getInt("new_core_ver"));
                                    i = 1;
                                    f1403j.unlock();
                                    mo12158b();
                                    if (i == 0) {
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                        C36432ai.m60088a(context).mo57541a("incrupdate_retry_num", 0);
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                        C36432ai.m60088a(context).mo57546b(0, -1);
                                        C36432ai.m60088a(context).mo57549c(1);
                                        string = bundle2.getString("apk_path");
                                        C36431ag.m60060a(new File(string), context);
                                        m8810b(context, string, bundle2.getInt("tbs_core_ver"));
                                    } else if (i == 2) {
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                    } else {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                        TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                        TbsDownloadConfig.getInstance(context).commit();
                                        TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(i)));
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                    AppMethodBeat.m2505o(64425);
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    i = 1;
                                    try {
                                        TbsLog.m80434i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                        try {
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                            TbsLogReport.getInstance(context).setInstallErrorCode(218, e.toString());
                                            f1403j.unlock();
                                            mo12158b();
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                            TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                            TbsDownloadConfig.getInstance(context).commit();
                                            TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(1)));
                                            QbSdk.setTBSInstallingStatus(false);
                                            AppMethodBeat.m2505o(64425);
                                            return;
                                        } catch (Throwable th) {
                                            e = th;
                                            i = 1;
                                            f1403j.unlock();
                                            mo12158b();
                                            if (i == 0) {
                                                TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                C36432ai.m60088a(context).mo57541a("incrupdate_retry_num", 0);
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                C36432ai.m60088a(context).mo57546b(0, -1);
                                                C36432ai.m60088a(context).mo57549c(1);
                                                string2 = bundle2.getString("apk_path");
                                                C36431ag.m60060a(new File(string2), context);
                                                m8810b(context, string2, bundle2.getInt("tbs_core_ver"));
                                            } else if (i == 2) {
                                                TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                            } else {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                TbsDownloadConfig.getInstance(context).f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                                TbsDownloadConfig.getInstance(context).commit();
                                                TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(i)));
                                            }
                                            QbSdk.setTBSInstallingStatus(false);
                                            AppMethodBeat.m2505o(64425);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        f1403j.unlock();
                                        mo12158b();
                                        if (i == 0) {
                                        }
                                        QbSdk.setTBSInstallingStatus(false);
                                        AppMethodBeat.m2505o(64425);
                                        throw e;
                                    }
                                }
                            }
                            i = bundle2.getInt("patch_result");
                            try {
                                TbsLogReport.getInstance(context).setInstallErrorCode(228, "result " + i + " : " + bundle.getInt("new_core_ver"));
                                f1403j.unlock();
                                mo12158b();
                                if (i == 0) {
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                AppMethodBeat.m2505o(64425);
                                return;
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                    }
                    i = 2;
                    f1403j.unlock();
                    mo12158b();
                    if (i == 0) {
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    AppMethodBeat.m2505o(64425);
                    return;
                } catch (Exception e4) {
                    e = e4;
                    i = 2;
                } catch (Throwable th3) {
                    e = th3;
                    i = 2;
                    f1403j.unlock();
                    mo12158b();
                    if (i == 0) {
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    AppMethodBeat.m2505o(64425);
                    throw e;
                }
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
            mo12158b();
            AppMethodBeat.m2505o(64425);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            AppMethodBeat.m2505o(64425);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo12161b(Context context, boolean z) {
        AppMethodBeat.m2504i(64412);
        if (QbSdk.f16240b) {
            AppMethodBeat.m2505o(64412);
        } else if (VERSION.SDK_INT < 8) {
            TbsLog.m80433e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            AppMethodBeat.m2505o(64412);
        } else {
            try {
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    File v = mo12186v(context);
                    if (v != null && v.exists()) {
                        C30950k.m49550a(v, false);
                    }
                }
            } catch (Throwable th) {
            }
            TbsLog.m80434i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
            if (C5813an.m8820y(context)) {
                TbsLog.m80434i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
                if (C5813an.m8808a(context, "core_unzip_tmp") && m8814d(context, z)) {
                    TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                    AppMethodBeat.m2505o(64412);
                    return;
                } else if (C5813an.m8808a(context, "core_share_backup_tmp") && m8816e(context, z)) {
                    TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
                    AppMethodBeat.m2505o(64412);
                    return;
                } else if (C5813an.m8808a(context, "core_copy_tmp") && m8813c(context, z)) {
                    TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
                    AppMethodBeat.m2505o(64412);
                    return;
                } else {
                    TbsLog.m80435i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                    AppMethodBeat.m2505o(64412);
                    return;
                }
            }
            AppMethodBeat.m2505o(64412);
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public boolean mo12162b(Context context, int i) {
        AppMethodBeat.m2504i(64423);
        if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.m2505o(64423);
            return false;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=".concat(String.valueOf(i)));
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (mo12166d(context, i) != null) {
            Object[] objArr = new Object[]{mo12166d(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = objArr;
            f1405m.sendMessage(message);
            AppMethodBeat.m2505o(64423);
            return true;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        AppMethodBeat.m2505o(64423);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public int mo12163c(Context context, String str) {
        AppMethodBeat.m2504i(64439);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            int i = packageArchiveInfo.versionCode;
            AppMethodBeat.m2505o(64439);
            return i;
        }
        AppMethodBeat.m2505o(64439);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo12164c(Context context, int i) {
        AppMethodBeat.m2504i(64426);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i <= 0) {
            AppMethodBeat.m2505o(64426);
            return;
        }
        int j = mo12175j(context);
        if (j == i) {
            AppMethodBeat.m2505o(64426);
            return;
        }
        Context e = TbsShareManager.m49471e(context);
        if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
            if (j <= 0) {
                TbsLog.m80434i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.m71035a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
            AppMethodBeat.m2505o(64426);
            return;
        }
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        mo12154a(context, e);
        AppMethodBeat.m2505o(64426);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0096 A:{SYNTHETIC, Splitter:B:30:0x0096} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a1 A:{Splitter:B:6:0x002e, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            r3.close();
     */
    /* JADX WARNING: Missing block: B:36:0x00a1, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:38:0x00a4, code skipped:
            r1 = r3;
            r0 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    public boolean mo12165c(Context context) {
        BufferedInputStream bufferedInputStream;
        int i = 1;
        AppMethodBeat.m2504i(64418);
        File file = new File(mo12183r(context), "tbs.conf");
        if (file.exists()) {
            boolean z;
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream2;
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                boolean booleanValue;
                try {
                    properties.load(bufferedInputStream2);
                    booleanValue = Boolean.valueOf(properties.getProperty("tbs_local_installation", "false")).booleanValue();
                    z = booleanValue ? System.currentTimeMillis() - file.lastModified() > 259200000 : false;
                    TbsLog.m80434i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z);
                    if (z) {
                        i = 0;
                    }
                    z = booleanValue & i;
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                    }
                } catch (Throwable th) {
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                bufferedInputStream2 = null;
                if (bufferedInputStream2 != null) {
                }
                AppMethodBeat.m2505o(64418);
                throw th3;
            }
            AppMethodBeat.m2505o(64418);
            return z;
        }
        AppMethodBeat.m2505o(64418);
        return false;
    }

    /* renamed from: d */
    public Context mo12166d(Context context, int i) {
        AppMethodBeat.m2504i(64438);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(i)));
        if (i <= 0) {
            AppMethodBeat.m2505o(64438);
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i2 = 0;
        while (i2 < coreProviderAppList.length) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && m8815e(context, coreProviderAppList[i2])) {
                Context b = mo12156b(context, coreProviderAppList[i2]);
                if (b == null) {
                    continue;
                } else if (mo12171f(b)) {
                    int j = mo12175j(b);
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=".concat(String.valueOf(j)));
                    if (j != 0 && j == i) {
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i2]);
                        AppMethodBeat.m2505o(64438);
                        return b;
                    }
                } else {
                    TbsLog.m80432e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        AppMethodBeat.m2505o(64438);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A:{SYNTHETIC, Splitter:B:29:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public String mo12167d(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        String str2 = null;
        AppMethodBeat.m2504i(64446);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(64446);
        } else {
            bufferedInputStream = null;
            try {
                File file = new File(mo12183r(context), "tbs.conf");
                if (file.exists()) {
                    Properties properties = new Properties();
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                    try {
                        properties.load(bufferedInputStream);
                        bufferedInputStream.close();
                        str2 = properties.getProperty(str);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        AppMethodBeat.m2505o(64446);
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(64446);
                        throw th;
                    }
                }
                if (str2 != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(64446);
            } catch (Exception e4) {
                bufferedInputStream = str2;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream2 = str2;
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                AppMethodBeat.m2505o(64446);
                throw th;
            }
        }
        return str2;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e6) {
            }
        }
        AppMethodBeat.m2505o(64446);
        return str2;
        AppMethodBeat.m2505o(64446);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A:{SYNTHETIC, Splitter:B:23:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A:{SYNTHETIC, Splitter:B:26:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078 A:{SYNTHETIC, Splitter:B:36:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A:{SYNTHETIC, Splitter:B:39:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A:{SYNTHETIC, Splitter:B:23:0x005b} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0060 A:{SYNTHETIC, Splitter:B:26:0x0060} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078 A:{SYNTHETIC, Splitter:B:36:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007d A:{SYNTHETIC, Splitter:B:39:0x007d} */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public void mo12168d(Context context) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.m2504i(64421);
        try {
            File file = new File(mo12183r(context), "tbs.conf");
            Properties properties = new Properties();
            BufferedInputStream bufferedInputStream;
            BufferedOutputStream bufferedOutputStream2;
            try {
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        properties.setProperty("tbs_local_installation", "false");
                        properties.store(bufferedOutputStream2, null);
                        try {
                            bufferedOutputStream2.close();
                        } catch (IOException e) {
                        }
                        bufferedInputStream.close();
                        AppMethodBeat.m2505o(64421);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        AppMethodBeat.m2505o(64421);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    AppMethodBeat.m2505o(64421);
                    throw th;
                }
            } catch (Throwable th32) {
                th = th32;
                bufferedOutputStream = null;
                bufferedInputStream = null;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e2) {
                    }
                }
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.m2505o(64421);
                throw th;
            }
        } catch (IOException e4) {
            AppMethodBeat.m2505o(64421);
        } catch (Throwable th4) {
            AppMethodBeat.m2505o(64421);
        }
    }

    /* renamed from: e */
    public boolean mo12169e(Context context) {
        AppMethodBeat.m2504i(64434);
        try {
            File file = new File(C30950k.m49545a(context, 4), "x5.tbs.decouple");
            File v = C5813an.m8800a().mo12186v(context);
            C30950k.m49554a(v);
            C30950k.m49550a(v, true);
            C30950k.m49555a(file, v);
            String[] list = v.list();
            for (String file2 : list) {
                File file3 = new File(v, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            C5813an.m8800a().m8817f(context, true);
            file = mo12182q(context);
            C30950k.m49550a(file, true);
            v.renameTo(file);
            TbsShareManager.m49465b(context);
            AppMethodBeat.m2505o(64434);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64434);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: e */
    public boolean mo12170e(Context context, int i) {
        boolean z = true;
        AppMethodBeat.m2504i(64467);
        try {
            File r;
            File file;
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                r = mo12183r(context);
            } else if (TbsShareManager.m49476j(context)) {
                file = new File(TbsShareManager.m49467c(context));
                if (file.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    AppMethodBeat.m2505o(64467);
                    return true;
                }
                r = file;
            } else {
                TbsLog.m80432e("TbsInstaller", "321");
                AppMethodBeat.m2505o(64467);
                return false;
            }
            if (r != null) {
                Long[][] lArr = f1406n;
                int length = lArr.length;
                int i2 = 0;
                while (i2 < length) {
                    Long[] lArr2 = lArr[i2];
                    if (i == lArr2[0].intValue()) {
                        file = new File(r, "libmttwebview.so");
                        if (file.exists() && file.length() == lArr2[1].longValue()) {
                            TbsLog.m80430d("TbsInstaller", "check so success: " + i + "; file: " + file);
                        } else {
                            if (!isThirdPartyApp) {
                                C30950k.m49564b(context.getDir("tbs", 0));
                            }
                            f1398a.set(Integer.valueOf(0));
                            TbsLog.m80432e("TbsInstaller", "322");
                            z = false;
                        }
                    } else {
                        i2++;
                    }
                }
            } else {
                TbsLog.m80432e("TbsInstaller", "323");
                z = false;
            }
        } catch (Throwable th) {
            TbsLog.m80432e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.m80432e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            z = false;
        }
        AppMethodBeat.m2505o(64467);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: f */
    public boolean mo12171f(Context context) {
        AppMethodBeat.m2504i(64437);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            AppMethodBeat.m2505o(64437);
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.m2505o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    AppMethodBeat.m2505o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    AppMethodBeat.m2505o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.m2505o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    AppMethodBeat.m2505o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                AppMethodBeat.m2505o(64437);
                return false;
            }
            AppMethodBeat.m2505o(64437);
            return true;
        } catch (Exception e) {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            AppMethodBeat.m2505o(64437);
            return false;
        }
    }

    /* renamed from: g */
    public void mo12172g(Context context) {
        AppMethodBeat.m2504i(64440);
        boolean z = true;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
        }
        if (z && f1404l != null) {
            C30950k.m49549a(context, f1404l);
        }
        AppMethodBeat.m2505o(64440);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public int mo12173h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(64445);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File u = mo12185u(context);
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is ".concat(String.valueOf(u)));
            File file = new File(u, "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        AppMethodBeat.m2505o(64445);
                    } else {
                        i = Integer.parseInt(property);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        AppMethodBeat.m2505o(64445);
                    }
                } catch (Exception e3) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(64445);
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(64445);
        } catch (Exception e5) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(64445);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.m2505o(64445);
        return i;
        AppMethodBeat.m2505o(64445);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A:{SYNTHETIC, Splitter:B:32:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    public int mo12174i(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(64447);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(mo12182q(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e) {
                            }
                        }
                        AppMethodBeat.m2505o(64447);
                    } else {
                        i = Integer.parseInt(property);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        AppMethodBeat.m2505o(64447);
                    }
                } catch (Exception e3) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.m2505o(64447);
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.m2505o(64447);
        } catch (Exception e5) {
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.m2505o(64447);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.m2505o(64447);
        return i;
        AppMethodBeat.m2505o(64447);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0089 A:{SYNTHETIC, Splitter:B:36:0x0089} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: j */
    public int mo12175j(Context context) {
        BufferedInputStream bufferedInputStream;
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(64448);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(mo12183r(context), "tbs.conf");
            if (file.exists()) {
                Properties properties = new Properties();
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                try {
                    properties.load(bufferedInputStream);
                    bufferedInputStream.close();
                    String property = properties.getProperty("tbs_core_version");
                    if (property == null) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                            }
                        }
                        AppMethodBeat.m2505o(64448);
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (f1407o == 0) {
                        f1407o = parseInt;
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e3.toString());
                        }
                    }
                    AppMethodBeat.m2505o(64448);
                    return parseInt;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                        TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString());
                    }
                }
                AppMethodBeat.m2505o(64448);
                return 0;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedInputStream = bufferedInputStream2;
        } catch (Throwable th2) {
            th = th2;
            bufferedInputStream = bufferedInputStream2;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e32) {
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e32.toString());
                }
            }
            AppMethodBeat.m2505o(64448);
            throw th;
        }
        AppMethodBeat.m2505o(64448);
        return 0;
        try {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString());
                }
            }
            AppMethodBeat.m2505o(64448);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.m2505o(64448);
            throw th;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: k */
    public int mo12176k(Context context) {
        AppMethodBeat.m2504i(64449);
        int i;
        if (f1407o != 0) {
            i = f1407o;
            AppMethodBeat.m2505o(64449);
            return i;
        }
        i = mo12175j(context);
        AppMethodBeat.m2505o(64449);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: l */
    public void mo12177l(Context context) {
        AppMethodBeat.m2504i(64450);
        if (f1407o != 0) {
            AppMethodBeat.m2505o(64450);
            return;
        }
        f1407o = mo12175j(context);
        AppMethodBeat.m2505o(64450);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: m */
    public boolean mo12178m(Context context) {
        AppMethodBeat.m2504i(64451);
        if (new File(mo12183r(context), "tbs.conf").exists()) {
            AppMethodBeat.m2505o(64451);
            return true;
        }
        AppMethodBeat.m2505o(64451);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe A:{SYNTHETIC, Splitter:B:55:0x00fe} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0109 A:{Catch:{ Throwable -> 0x013a }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ec A:{Catch:{ Throwable -> 0x016a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: n */
    public int mo12179n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        AppMethodBeat.m2504i(64452);
        if (mo12188x(context)) {
            boolean tryLock = f1402i.tryLock();
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=".concat(String.valueOf(tryLock)));
            if (tryLock) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    File file = new File(mo12183r(context), "tbs.conf");
                    if (file.exists()) {
                        Properties properties = new Properties();
                        bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
                        try {
                            properties.load(bufferedInputStream);
                            bufferedInputStream.close();
                            String property = properties.getProperty("tbs_core_version");
                            if (property == null) {
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e2) {
                                        TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                    }
                                }
                                try {
                                    if (f1402i.isHeldByCurrentThread()) {
                                        f1402i.unlock();
                                    }
                                } catch (Throwable th2) {
                                    TbsLog.m80432e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th2)));
                                }
                                mo12158b();
                                AppMethodBeat.m2505o(64452);
                                return 0;
                            }
                            f1398a.set(Integer.valueOf(Integer.parseInt(property)));
                            int intValue = ((Integer) f1398a.get()).intValue();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                                }
                            }
                            try {
                                if (f1402i.isHeldByCurrentThread()) {
                                    f1402i.unlock();
                                }
                            } catch (Throwable th3) {
                                TbsLog.m80432e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th3)));
                            }
                            mo12158b();
                            AppMethodBeat.m2505o(64452);
                            return intValue;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } else {
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e22) {
                                TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                            }
                        }
                        try {
                            if (f1402i.isHeldByCurrentThread()) {
                                f1402i.unlock();
                            }
                        } catch (Throwable th22) {
                            TbsLog.m80432e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th22)));
                        }
                        mo12158b();
                        AppMethodBeat.m2505o(64452);
                        return 0;
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedInputStream = bufferedInputStream2;
                } catch (Throwable th4) {
                    th22 = th4;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                    }
                    try {
                        if (f1402i.isHeldByCurrentThread()) {
                        }
                    } catch (Throwable th32) {
                        TbsLog.m80432e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th32)));
                    }
                    mo12158b();
                    AppMethodBeat.m2505o(64452);
                    throw th22;
                }
            }
            mo12158b();
            AppMethodBeat.m2505o(64452);
            return 0;
        }
        AppMethodBeat.m2505o(64452);
        return -1;
        mo12158b();
        AppMethodBeat.m2505o(64452);
        return 0;
        try {
            if (f1402i.isHeldByCurrentThread()) {
                f1402i.unlock();
            }
        } catch (Throwable th222) {
            TbsLog.m80432e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th222)));
        }
        mo12158b();
        AppMethodBeat.m2505o(64452);
        return 0;
        try {
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                }
            }
            if (f1402i.isHeldByCurrentThread()) {
            }
            mo12158b();
            AppMethodBeat.m2505o(64452);
            return 0;
        } catch (Throwable th5) {
            th222 = th5;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e32) {
                    TbsLog.m80434i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                }
            }
            if (f1402i.isHeldByCurrentThread()) {
                f1402i.unlock();
            }
            mo12158b();
            AppMethodBeat.m2505o(64452);
            throw th222;
        }
    }

    /* renamed from: o */
    public boolean mo12180o(Context context) {
        AppMethodBeat.m2504i(64455);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File r = mo12183r(context);
        File q = mo12182q(context);
        try {
            C30950k.m49550a(q, true);
            C30950k.m49556a(r, q, new C16148au(this));
            TbsShareManager.m49465b(context);
            TbsLog.m80434i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            AppMethodBeat.m2505o(64455);
            return true;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64455);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: p */
    public void mo12181p(Context context) {
        AppMethodBeat.m2504i(64458);
        TbsLog.m80434i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        C36432ai.m60088a(context).mo57538a(0);
        C36432ai.m60088a(context).mo57545b(0);
        C36432ai.m60088a(context).mo57552d(0);
        C36432ai.m60088a(context).mo57541a("incrupdate_retry_num", 0);
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
            C36432ai.m60088a(context).mo57546b(0, -1);
            C36432ai.m60088a(context).mo57540a("");
            C36432ai.m60088a(context).mo57541a("copy_retry_num", 0);
            C36432ai.m60088a(context).mo57549c(-1);
            C36432ai.m60088a(context).mo57539a(0, -1);
            C30950k.m49550a(mo12185u(context), true);
            C30950k.m49550a(mo12187w(context), true);
        }
        AppMethodBeat.m2505o(64458);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: q */
    public File mo12182q(Context context) {
        AppMethodBeat.m2504i(64460);
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64460);
            return file;
        }
        AppMethodBeat.m2505o(64460);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: r */
    public File mo12183r(Context context) {
        AppMethodBeat.m2504i(64461);
        File b = mo12157b(null, context);
        AppMethodBeat.m2505o(64461);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: s */
    public File mo12184s(Context context) {
        AppMethodBeat.m2504i(64462);
        File file = new File(context.getDir("tbs", 0), "share");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64462);
            return file;
        }
        AppMethodBeat.m2505o(64462);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: u */
    public File mo12185u(Context context) {
        AppMethodBeat.m2504i(64464);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64464);
            return file;
        }
        AppMethodBeat.m2505o(64464);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: v */
    public File mo12186v(Context context) {
        AppMethodBeat.m2504i(64465);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64465);
            return file;
        }
        AppMethodBeat.m2505o(64465);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: w */
    public File mo12187w(Context context) {
        AppMethodBeat.m2504i(64466);
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.m2505o(64466);
            return file;
        }
        AppMethodBeat.m2505o(64466);
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: x */
    public synchronized boolean mo12188x(Context context) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(64468);
            this.f1409e++;
            if (this.f1412h) {
                TbsLog.m80434i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
                AppMethodBeat.m2505o(64468);
            } else {
                this.f1411g = C30950k.m49563b(context, true, "tbslock.txt");
                if (this.f1411g != null) {
                    this.f1410f = C30950k.m49548a(context, this.f1411g);
                    if (this.f1410f == null) {
                        AppMethodBeat.m2505o(64468);
                        z = false;
                    } else {
                        TbsLog.m80434i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.f1412h = true;
                        AppMethodBeat.m2505o(64468);
                    }
                } else {
                    AppMethodBeat.m2505o(64468);
                    z = false;
                }
            }
        }
        return z;
    }
}
