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
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.x;
import com.tencent.smtt.utils.y;
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

class an {
    public static ThreadLocal<Integer> a = new ao();
    static boolean b = false;
    static final FileFilter c = new ap();
    private static an d = null;
    private static final ReentrantLock i = new ReentrantLock();
    private static final Lock j = new ReentrantLock();
    private static FileLock l = null;
    private static Handler m = null;
    private static final Long[][] n;
    private static int o = 0;
    private static boolean p = false;
    private int e = 0;
    private FileLock f;
    private FileOutputStream g;
    private boolean h = false;
    private boolean k = false;

    static {
        AppMethodBeat.i(64474);
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
        n = r0;
        AppMethodBeat.o(64474);
    }

    private an() {
        AppMethodBeat.i(64405);
        if (m == null) {
            m = new aq(this, al.a().getLooper());
        }
        AppMethodBeat.o(64405);
    }

    private void A(Context context) {
        AppMethodBeat.i(64442);
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip");
        if (z(context)) {
            try {
                C(context);
                D(context);
                TbsLog.i("TbsInstaller", "after renameTbsCoreShareDir");
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsLog.i("TbsInstaller", "is thirdapp and not chmod");
                } else {
                    TbsLog.i("TbsInstaller", "prepare to shareTbsCore");
                    TbsShareManager.a(context);
                }
                ai.a(context).a(0);
                ai.a(context).b(0);
                ai.a(context).d(0);
                ai.a(context).a("incrupdate_retry_num", 0);
                ai.a(context).b(0, 3);
                ai.a(context).a("");
                ai.a(context).c(-1);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == a().i(context) || i != a().j(context)) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + a().i(context) + " getTbsCoreInstalledVerInNolock is " + a().j(context));
                    } else {
                        o(context);
                    }
                }
                if (TbsShareManager.isThirdPartyApp(context)) {
                    TbsShareManager.writeCoreInfoForThirdPartyApp(context, n(context), true);
                }
                a.set(Integer.valueOf(0));
                o = 0;
            } catch (Throwable th) {
                TbsLogReport.getInstance(context).setInstallErrorCode(219, "exception when renameing from unzip:" + th.toString());
                TbsLog.e("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromUnzip Exception", true);
            }
            g(context);
            AppMethodBeat.o(64442);
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
        AppMethodBeat.o(64442);
    }

    private void B(Context context) {
        AppMethodBeat.i(64443);
        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy");
        if (z(context)) {
            try {
                C(context);
                E(context);
                TbsShareManager.a(context);
                ai.a(context).a(0, 3);
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
                    if (i <= 0 || i == a().i(context) || i != a().j(context)) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--generateNewTbsCoreFromCopy #1 deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + a().i(context) + " getTbsCoreInstalledVerInNolock is " + a().j(context));
                    } else {
                        o(context);
                    }
                }
                a.set(Integer.valueOf(0));
            } catch (Exception e) {
                TbsLogReport.getInstance(context).setInstallErrorCode(219, "exception when renameing from copy:" + e.toString());
            }
            g(context);
            AppMethodBeat.o(64443);
            return;
        }
        TbsLog.i("TbsInstaller", "get rename fileLock#4 ## failed!");
        AppMethodBeat.o(64443);
    }

    private void C(Context context) {
        AppMethodBeat.i(64453);
        TbsLog.i("TbsInstaller", "TbsInstaller--deleteOldCore");
        k.a(r(context), false);
        AppMethodBeat.o(64453);
    }

    private void D(Context context) {
        AppMethodBeat.i(64454);
        TbsLog.i("TbsInstaller", "TbsInstaller--renameShareDir");
        File u = u(context);
        File r = r(context);
        if (u == null || r == null) {
            AppMethodBeat.o(64454);
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
        f(context, false);
        AppMethodBeat.o(64454);
    }

    private void E(Context context) {
        AppMethodBeat.i(64456);
        TbsLog.i("TbsInstaller", "TbsInstaller--renameTbsCoreCopyDir");
        File w = w(context);
        File r = r(context);
        if (w == null || r == null) {
            AppMethodBeat.o(64456);
            return;
        }
        w.renameTo(r);
        f(context, false);
        AppMethodBeat.o(64456);
    }

    private void F(Context context) {
        AppMethodBeat.i(64457);
        TbsLog.i("TbsInstaller", "TbsInstaller--clearNewTbsCore");
        File u = u(context);
        if (u != null) {
            k.a(u, false);
        }
        ai.a(context).b(0, 5);
        ai.a(context).c(-1);
        QbSdk.a(context, "TbsInstaller::clearNewTbsCore forceSysWebViewInner!");
        AppMethodBeat.o(64457);
    }

    static synchronized an a() {
        an anVar;
        synchronized (an.class) {
            AppMethodBeat.i(64406);
            if (d == null) {
                synchronized (an.class) {
                    try {
                        if (d == null) {
                            d = new an();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.o(64406);
                        }
                    }
                }
            }
            anVar = d;
            AppMethodBeat.o(64406);
        }
        return anVar;
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
    private void a(int i, String str, Context context) {
        BufferedOutputStream bufferedOutputStream;
        Throwable th;
        BufferedOutputStream bufferedOutputStream2;
        AppMethodBeat.i(64422);
        new File(str).delete();
        TbsLog.i("TbsInstaller", "Local tbs apk(" + str + ") is deleted!", true);
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
                    AppMethodBeat.o(64422);
                    throw th;
                }
                try {
                    properties.setProperty("tbs_local_installation", "true");
                    properties.store(bufferedOutputStream, null);
                    TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is set!", true);
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                    }
                    try {
                        bufferedInputStream.close();
                        AppMethodBeat.o(64422);
                        return;
                    } catch (IOException e2) {
                        AppMethodBeat.o(64422);
                        return;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream2 = bufferedOutputStream;
                    if (bufferedOutputStream2 != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    AppMethodBeat.o(64422);
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
                AppMethodBeat.o(64422);
                throw th;
            }
        }
        AppMethodBeat.o(64422);
    }

    public static void a(Context context) {
        AppMethodBeat.i(64411);
        if (!y(context)) {
            if (a(context, "core_unzip_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_UNZIP_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_UNZIP_FOLDER_NAME");
                AppMethodBeat.o(64411);
                return;
            } else if (a(context, "core_share_backup_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_BACKUP_TBSCORE_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_BACKUP_TBSCORE_FOLDER_NAME");
                AppMethodBeat.o(64411);
                return;
            } else if (a(context, "core_copy_tmp")) {
                TbsCoreLoadStat.getInstance().a(context, 417, new Throwable("TMP_TBS_COPY_FOLDER_NAME"));
                TbsLog.e("TbsInstaller", "TbsInstaller-UploadIfTempCoreExistConfError INFO_TEMP_CORE_EXIST_CONF_ERROR TMP_TBS_COPY_FOLDER_NAME");
            }
        }
        AppMethodBeat.o(64411);
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
    private void a(Context context, Context context2, int i) {
        Editor edit;
        Throwable th;
        Exception e;
        AppMethodBeat.i(64427);
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-524);
        if (c(context2)) {
            AppMethodBeat.o(64427);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread start!  tbsCoreTargetVer is ".concat(String.valueOf(i)));
        if ((VERSION.SDK_INT >= 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-525);
            AppMethodBeat.o(64427);
        } else if (x(context2)) {
            boolean tryLock = j.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread #1 locked is ".concat(String.valueOf(tryLock)));
            if (tryLock) {
                i.lock();
                File file = null;
                try {
                    int c = ai.a(context2).c("copy_core_ver");
                    int b = ai.a(context2).b("copy_status");
                    if (c == i) {
                        QbSdk.m.onInstallFinish(220);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                        i.unlock();
                        j.unlock();
                        b();
                        AppMethodBeat.o(64427);
                        return;
                    }
                    int j = j(context2);
                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread tbsCoreInstalledVer=".concat(String.valueOf(j)));
                    if (j == i) {
                        QbSdk.m.onInstallFinish(220);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-528);
                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have same version is ".concat(String.valueOf(j)));
                        i.unlock();
                        j.unlock();
                        b();
                        AppMethodBeat.o(64427);
                        return;
                    }
                    int b2 = ai.a(context2).b();
                    if ((b2 > 0 && i > b2) || (c > 0 && i > c)) {
                        p(context2);
                    }
                    if (b == 3 && j > 0 && (i > j || i == 88888888)) {
                        b = -1;
                        p(context2);
                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread -- update TBS.....", true);
                    }
                    long currentTimeMillis;
                    if (k.b(context2)) {
                        if (b > 0) {
                            if (TbsShareManager.isThirdPartyApp(context2) || TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1 || i == i(context2)) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread return have copied is " + i(context2));
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64427);
                                return;
                            }
                        }
                        if (b == 0) {
                            b = ai.a(context2).c("copy_retry_num");
                            if (b > 2) {
                                TbsLogReport.getInstance(context2).setInstallErrorCode(211, "exceed copy retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-530);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64427);
                                return;
                            }
                            ai.a(context2).a("copy_retry_num", b + 1);
                        }
                        File r = r(context);
                        File q = !TbsShareManager.isThirdPartyApp(context2) ? TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1 ? q(context2) : w(context2) : w(context2);
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
                            ai.a(context2).a(i, 0);
                            x xVar = new x();
                            xVar.a(r);
                            currentTimeMillis = System.currentTimeMillis();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-551);
                            boolean a = k.a(r, q, c);
                            if (TbsDownloadConfig.getInstance(context2).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                TbsShareManager.b(context2);
                            }
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread time=" + (System.currentTimeMillis() - currentTimeMillis));
                            if (a) {
                                xVar.b(r);
                                if (xVar.a()) {
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
                                                TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                                if (obj != null) {
                                                }
                                                try {
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                                    f(context2, true);
                                                    file = ag.b(context);
                                                    if (TbsDownloader.getOverSea(context2)) {
                                                    }
                                                    ag.a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                                    ai.a(context2).a(i, 1);
                                                    if (this.k) {
                                                    }
                                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                                    TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                                    if (VERSION.SDK_INT < 11) {
                                                    }
                                                    try {
                                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                                        edit.putInt("tbs_preload_x5_counter", 0);
                                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                                        edit.putInt("tbs_preload_x5_version", i);
                                                        edit.commit();
                                                    } catch (Throwable th2) {
                                                        TbsLog.e("TbsInstaller", "Init tbs_preload_x5_counter#2 exception:" + Log.getStackTraceString(th2));
                                                    }
                                                    y.a(context2);
                                                    i.unlock();
                                                    j.unlock();
                                                    b();
                                                    AppMethodBeat.o(64427);
                                                    return;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    file = q;
                                                    try {
                                                        TbsLogReport.getInstance(context2).setInstallErrorCode(215, e.toString());
                                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                                                        k.a(file, false);
                                                        ai.a(context2).a(0, -1);
                                                    } catch (Exception e4) {
                                                        TbsLog.e("TbsInstaller", "[TbsInstaller-copyTbsCoreInThread] delete dstTmpDir throws exception:" + e4.getMessage() + "," + e4.getCause());
                                                    } catch (Throwable th3) {
                                                        i.unlock();
                                                        j.unlock();
                                                        b();
                                                        AppMethodBeat.o(64427);
                                                    }
                                                    i.unlock();
                                                    j.unlock();
                                                    b();
                                                    AppMethodBeat.o(64427);
                                                    return;
                                                }
                                            } catch (Throwable th4) {
                                                th2 = th4;
                                                bufferedInputStream = bufferedInputStream2;
                                                if (bufferedInputStream != null) {
                                                }
                                                AppMethodBeat.o(64427);
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
                                        TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                        if (obj != null) {
                                        }
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        f(context2, true);
                                        file = ag.b(context);
                                        if (TbsDownloader.getOverSea(context2)) {
                                        }
                                        ag.a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                        ai.a(context2).a(i, 1);
                                        if (this.k) {
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                        if (VERSION.SDK_INT < 11) {
                                        }
                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                        edit.putInt("tbs_preload_x5_counter", 0);
                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                        edit.putInt("tbs_preload_x5_version", i);
                                        edit.commit();
                                        y.a(context2);
                                        i.unlock();
                                        j.unlock();
                                        b();
                                        AppMethodBeat.o(64427);
                                        return;
                                    } catch (Throwable th5) {
                                    }
                                    if (obj == null) {
                                        File[] listFiles = q.listFiles();
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-552);
                                        tryLock = true;
                                        for (File file3 : listFiles) {
                                            if (!("1".equals(file3.getName()) || file3.getName().endsWith(".dex") || "tbs.conf".equals(file3.getName()) || file3.isDirectory() || file3.getName().endsWith(".prof"))) {
                                                String a2 = a.a(file3);
                                                String property = properties.getProperty(file3.getName(), "");
                                                if (property.equals("") || !a2.equals(property)) {
                                                    tryLock = false;
                                                    TbsLog.e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + a2);
                                                    break;
                                                }
                                                TbsLog.i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                                                tryLock = true;
                                            }
                                        }
                                    } else {
                                        tryLock = true;
                                    }
                                    TbsLog.i("TbsInstaller", "copyTbsCoreInThread - md5_check_success:".concat(String.valueOf(tryLock)));
                                    if (obj != null || tryLock) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success!");
                                        f(context2, true);
                                        file = ag.b(context);
                                        if (file != null && file.exists()) {
                                            ag.a(new File(file, TbsDownloader.getOverSea(context2) ? "x5.oversea.tbs.org" : "x5.tbs.org"), context2);
                                        }
                                        ai.a(context2).a(i, 1);
                                        if (this.k) {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(220, "continueInstallWithout core success");
                                        } else {
                                            TbsLogReport.getInstance(context2).setInstallErrorCode(220, "success");
                                        }
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-533);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread success -- version:".concat(String.valueOf(i)));
                                        edit = (VERSION.SDK_INT < 11 ? context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context2.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                                        edit.putInt("tbs_preload_x5_counter", 0);
                                        edit.putInt("tbs_preload_x5_recorder", 0);
                                        edit.putInt("tbs_preload_x5_version", i);
                                        edit.commit();
                                        y.a(context2);
                                    } else {
                                        TbsLog.e("TbsInstaller", "copyTbsCoreInThread - md5 incorrect -> delete destTmpDir!");
                                        k.a(q, true);
                                        TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify md5 fail after copying tbs core!");
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-532);
                                        i.unlock();
                                        j.unlock();
                                        b();
                                        AppMethodBeat.o(64427);
                                        return;
                                    }
                                }
                                TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread copy-verify fail!");
                                k.a(q, true);
                                TbsLogReport.getInstance(context2).setInstallErrorCode(213, "TbsCopy-Verify fail after copying tbs core!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-531);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64427);
                                return;
                            }
                            TbsLog.i("TbsInstaller", "TbsInstaller-copyTbsCoreInThread fail!");
                            ai.a(context2).a(i, 2);
                            k.a(q, false);
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-534);
                            TbsLogReport.getInstance(context2).setInstallErrorCode(212, "copy fail!");
                        }
                        i.unlock();
                        j.unlock();
                        b();
                        AppMethodBeat.o(64427);
                        return;
                    }
                    long a3 = y.a();
                    currentTimeMillis = TbsDownloadConfig.getInstance(context2).getDownloadMinFreeSpace();
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-529);
                    TbsLogReport.getInstance(context2).setInstallErrorCode(210, "rom is not enough when copying tbs core! curAvailROM=" + a3 + ",minReqRom=" + currentTimeMillis);
                    i.unlock();
                    j.unlock();
                    b();
                    AppMethodBeat.o(64427);
                    return;
                } catch (Exception e7) {
                    e4 = e7;
                    TbsLogReport.getInstance(context2).setInstallErrorCode(215, e4.toString());
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-537);
                    k.a(file, false);
                    ai.a(context2).a(0, -1);
                    i.unlock();
                    j.unlock();
                    b();
                    AppMethodBeat.o(64427);
                    return;
                }
            }
            b();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-538);
            AppMethodBeat.o(64427);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-526);
            AppMethodBeat.o(64427);
        }
    }

    private boolean a(Context context, File file) {
        AppMethodBeat.i(64431);
        boolean a = a(context, file, false);
        AppMethodBeat.o(64431);
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
            com.tencent.smtt.utils.k.b(r4);
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + r4.exists());
     */
    /* JADX WARNING: Missing block: B:71:0x01d0, code skipped:
            com.tencent.smtt.utils.TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
            com.tencent.matrix.trace.core.AppMethodBeat.o(64432);
     */
    /* JADX WARNING: Missing block: B:73:0x01dd, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:74:0x01de, code skipped:
            com.tencent.smtt.utils.TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + android.util.Log.getStackTraceString(r1));
     */
    /* JADX WARNING: Missing block: B:79:0x021b, code skipped:
            r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(Context context, File file, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(64432);
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs start");
        if (k.c(file)) {
            File dir;
            try {
                dir = context.getDir("tbs", 0);
                File file2 = z ? new File(dir, "core_share_decouple") : new File(dir, "core_unzip_tmp");
                if (file2.exists() && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
                    k.b(file2);
                }
            } catch (Throwable th) {
                TbsLog.e("TbsInstaller", "TbsInstaller-unzipTbs -- delete unzip folder if exists exception" + Log.getStackTraceString(th));
            }
            File v = z ? v(context) : u(context);
            if (v == null) {
                TbsLogReport.getInstance(context).setInstallErrorCode(205, "tmp unzip dir is null!");
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-521);
                AppMethodBeat.o(64432);
                return false;
            }
            try {
                k.a(v);
                if (z) {
                    k.a(v, true);
                }
                boolean a = k.a(file, v);
                if (a) {
                    a = a(v, context);
                }
                if (z) {
                    String[] list = v.list();
                    for (String file3 : list) {
                        File file4 = new File(v, file3);
                        if (file4.getName().endsWith(".dex")) {
                            file4.delete();
                        }
                    }
                    new File(t(context), "x5.tbs").delete();
                }
                if (a) {
                    f(context, true);
                    if (z) {
                        dir = q(context);
                        k.a(dir, true);
                        v.renameTo(dir);
                        TbsShareManager.b(context);
                    }
                } else {
                    k.b(v);
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-522);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#1! exist:" + v.exists());
                }
                TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
                AppMethodBeat.o(64432);
                return a;
            } catch (IOException e) {
            } catch (Exception th2) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-523);
                TbsLogReport.getInstance(context).setInstallErrorCode(207, th2);
                if (v == null || !v.exists()) {
                    z2 = false;
                }
                if (z2 && v != null) {
                    k.b(v);
                    TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exist:" + v.exists());
                }
            } catch (Throwable th22) {
                TbsLog.e("TbsInstaller", "copyFileIfChanged -- delete tmpTbsCoreUnzipDir#2! exception:" + Log.getStackTraceString(th22));
            }
        } else {
            TbsLogReport.getInstance(context).setInstallErrorCode(204, "apk is invalid!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-520);
            AppMethodBeat.o(64432);
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
        AppMethodBeat.o(64432);
        return false;
        TbsLog.i("TbsInstaller", "TbsInstaller-unzipTbs done");
        AppMethodBeat.o(64432);
        return false;
    }

    static boolean a(Context context, String str) {
        AppMethodBeat.i(64413);
        File file = new File(context.getDir("tbs", 0), str);
        if (!file.exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #1");
            AppMethodBeat.o(64413);
            return false;
        } else if (new File(file, "tbs.conf").exists()) {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #3");
            AppMethodBeat.o(64413);
            return true;
        } else {
            TbsLog.i("TbsInstaller", "TbsInstaller-isPrepareTbsCore, #2");
            AppMethodBeat.o(64413);
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
    private boolean a(File file, Context context) {
        Properties properties;
        boolean z;
        BufferedInputStream bufferedInputStream;
        boolean z2;
        BufferedInputStream bufferedInputStream2 = null;
        AppMethodBeat.i(64433);
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - " + file + ", " + context);
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
                    TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
                    if (z) {
                    }
                    z2 = true;
                    TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
                    if (z) {
                    }
                    TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
                    AppMethodBeat.o(64433);
                    return true;
                } catch (Throwable th) {
                    Throwable th2 = th;
                    bufferedInputStream2 = bufferedInputStream3;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.o(64433);
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
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
            if (z) {
            }
            z2 = true;
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
            if (z) {
            }
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            AppMethodBeat.o(64433);
            return true;
        } catch (Throwable th3) {
        }
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - need_check:".concat(String.valueOf(z)));
        if (z) {
            File[] listFiles = file.listFiles();
            for (File file3 : listFiles) {
                if (!("1".equals(file3.getName()) || file3.getName().endsWith(".dex") || "tbs.conf".equals(file3.getName()) || file3.isDirectory() || file3.getName().endsWith(".prof"))) {
                    String a = a.a(file3);
                    String property = properties.getProperty(file3.getName(), "");
                    if (property.equals("") || !property.equals(a)) {
                        TbsLog.e("TbsInstaller", "md5_check_failure for (" + file3.getName() + ") targetMd5:" + property + ", realMd5:" + a);
                        z2 = false;
                        break;
                    }
                    TbsLog.i("TbsInstaller", "md5_check_success for (" + file3.getName() + ")");
                }
            }
        }
        z2 = true;
        TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity - md5_check_success:".concat(String.valueOf(z2)));
        if (z || z2) {
            TbsLog.i("TbsInstaller", "finalCheckForTbsCoreValidity success!");
            AppMethodBeat.o(64433);
            return true;
        }
        TbsLog.e("TbsInstaller", "finalCheckForTbsCoreValidity - Verify failed after unzipping!");
        AppMethodBeat.o(64433);
        return false;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:133:0x05a3=Splitter:B:133:0x05a3, B:58:0x02d4=Splitter:B:58:0x02d4, B:145:0x061d=Splitter:B:145:0x061d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    private void b(Context context, String str, int i) {
        int i2 = 200;
        int i3 = 0;
        AppMethodBeat.i(64415);
        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-501);
        if (c(context)) {
            TbsLog.i("TbsInstaller", "isTbsLocalInstalled --> no installation!", true);
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-502);
            AppMethodBeat.o(64415);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer=".concat(String.valueOf(i)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread currentThreadName=" + Thread.currentThread().getName());
        if ((VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).getInt("tbs_precheck_disable_version", -1) == i) {
            TbsLog.e("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- version:" + i + " is disabled by preload_x5_check!");
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-503);
            AppMethodBeat.o(64415);
        } else if (!k.b(context)) {
            long a = y.a();
            long downloadMinFreeSpace = TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace();
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-504);
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when installing tbs core! curAvailROM=" + a + ",minReqRom=" + downloadMinFreeSpace);
            AppMethodBeat.o(64415);
        } else if (x(context)) {
            boolean tryLock = j.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread locked =".concat(String.valueOf(tryLock)));
            if (tryLock) {
                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-507);
                i.lock();
                try {
                    boolean z;
                    int i4;
                    int c = ai.a(context).c("copy_core_ver");
                    int b = ai.a(context).b();
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreCopyVer =".concat(String.valueOf(c)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstallVer =".concat(String.valueOf(b)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreTargetVer =".concat(String.valueOf(i)));
                    if ((b > 0 && i > b) || (c > 0 && i > c)) {
                        p(context);
                    }
                    c = ai.a(context).c();
                    b = j(context);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus1=".concat(String.valueOf(c)));
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread tbsCoreInstalledVer=".concat(String.valueOf(b)));
                    if (c < 0 || c >= 2) {
                        if (c == 3 && b > 0 && (i > b || i == 88888888)) {
                            c = -1;
                            p(context);
                            TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- update TBS.....", true);
                        }
                        z = false;
                        i4 = c;
                    } else {
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread -- retry.....", true);
                        z = true;
                        i4 = c;
                    }
                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-508);
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread installStatus2=".concat(String.valueOf(i4)));
                    String d;
                    if (i4 <= 0) {
                        TbsLog.i("TbsInstaller", "STEP 2/2 begin installation.....", true);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-509);
                        if (z) {
                            c = ai.a(context).c("unzip_retry_num");
                            if (c > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(201, "exceed unzip retry num!");
                                F(context);
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-510);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64415);
                                return;
                            }
                            ai.a(context).b(c + 1);
                        }
                        if (str == null) {
                            d = ai.a(context).d("install_apk_path");
                            if (d == null) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64415);
                                return;
                            }
                        }
                        d = str;
                        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreInThread apkPath =".concat(String.valueOf(d)));
                        int c2 = c(context, d);
                        if (c2 == 0) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-512);
                            TbsLogReport.getInstance(context).setInstallErrorCode(203, "apk version is 0!");
                            i.unlock();
                            j.unlock();
                            b();
                            AppMethodBeat.o(64415);
                            return;
                        }
                        ai.a(context).a("install_apk_path", d);
                        ai.a(context).b(c2, 0);
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-548);
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (!a(context, new File(d), true)) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed", EventType.TYPE_INSTALL_DECOUPLE);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64415);
                                return;
                            }
                        } else if (!a(context, new File(d))) {
                            TbsLogReport.getInstance(context).setInstallErrorCode(207, "unzipTbsApk failed");
                            i.unlock();
                            j.unlock();
                            b();
                            AppMethodBeat.o(64415);
                            return;
                        }
                        if (z) {
                            c = ai.a(context).b("unlzma_status");
                            if (c > 5) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(223, "exceed unlzma retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-553);
                                F(context);
                                ag.c(context);
                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_FULL_PACKAGE, Boolean.TRUE);
                                TbsDownloadConfig.getInstance(context).commit();
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64415);
                                return;
                            }
                            ai.a(context).d(c + 1);
                        }
                        TbsLog.i("TbsInstaller", "unlzma begin");
                        b = TbsDownloadConfig.getInstance().mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                        if (j(context) != 0) {
                            Object a2 = QbSdk.a(context, "can_unlzma", null);
                            tryLock = (a2 == null || !(a2 instanceof Boolean)) ? false : ((Boolean) a2).booleanValue();
                            if (tryLock) {
                                Bundle bundle = new Bundle();
                                bundle.putInt("responseCode", b);
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                                    bundle.putString("unzip_temp_path", q(context).getAbsolutePath());
                                } else {
                                    bundle.putString("unzip_temp_path", u(context).getAbsolutePath());
                                }
                                a2 = QbSdk.a(context, "unlzma", bundle);
                                if (a2 == null) {
                                    TbsLog.i("TbsInstaller", "unlzma return null");
                                    TbsLogReport.getInstance(context).setInstallErrorCode(222, "unlzma is null");
                                } else if (a2 instanceof Boolean) {
                                    if (((Boolean) a2).booleanValue()) {
                                        TbsLog.i("TbsInstaller", "unlzma success");
                                        i3 = 1;
                                    } else {
                                        TbsLog.i("TbsInstaller", "unlzma return false");
                                        TbsLogReport.getInstance(context).setInstallErrorCode(222, "unlzma return false");
                                    }
                                } else if (a2 instanceof Bundle) {
                                    i3 = 1;
                                } else if (a2 instanceof Throwable) {
                                    TbsLog.i("TbsInstaller", "unlzma failure because Throwable" + Log.getStackTraceString((Throwable) a2));
                                    TbsLogReport.getInstance(context).setInstallErrorCode(222, (Throwable) a2);
                                }
                                if (i3 == 0) {
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    AppMethodBeat.o(64415);
                                    return;
                                }
                            }
                        }
                        TbsLog.i("TbsInstaller", "unlzma finished");
                        ai.a(context).b(c2, 1);
                        c = c2;
                    } else {
                        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                            if (str == null) {
                                d = ai.a(context).d("install_apk_path");
                                if (d == null) {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(202, "apk path is null!");
                                    TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-511);
                                    i.unlock();
                                    j.unlock();
                                    b();
                                    AppMethodBeat.o(64415);
                                    return;
                                }
                            }
                            d = str;
                            a(context, new File(d), true);
                        }
                        c = 0;
                    }
                    if (i4 < 2) {
                        if (z) {
                            b = ai.a(context).c("dexopt_retry_num");
                            if (b > 10) {
                                TbsLogReport.getInstance(context).setInstallErrorCode(208, "exceed dexopt retry num!");
                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-514);
                                F(context);
                                i.unlock();
                                j.unlock();
                                b();
                                AppMethodBeat.o(64415);
                                return;
                            }
                            ai.a(context).a(b + 1);
                        }
                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-549);
                        if (f(context, 0)) {
                            ai.a(context).b(c, 2);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart!", true);
                            TbsLog.i("TbsInstaller", "STEP 2/2 installation completed! you can restart! version:".concat(String.valueOf(i)));
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-516);
                            Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit();
                            edit.putInt("tbs_preload_x5_counter", 0);
                            edit.putInt("tbs_preload_x5_recorder", 0);
                            edit.putInt("tbs_preload_x5_version", i);
                            edit.commit();
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-517);
                            if (i == 88888888) {
                                a(i, str, context);
                            }
                            if (this.k) {
                                TbsLogReport instance = TbsLogReport.getInstance(context);
                                if (ai.a(context).d() == 1) {
                                    i2 = 221;
                                }
                                instance.setInstallErrorCode(i2, "continueInstallWithout core success");
                            } else {
                                TbsLogReport.getInstance(context).setInstallErrorCode(ai.a(context).d() == 1 ? 221 : 200, "success");
                            }
                        } else {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-515);
                            i.unlock();
                            j.unlock();
                            b();
                            AppMethodBeat.o(64415);
                            return;
                        }
                    } else if (i4 == 2) {
                        QbSdk.m.onInstallFinish(200);
                    }
                } catch (Throwable th) {
                    i.unlock();
                    j.unlock();
                    b();
                    AppMethodBeat.o(64415);
                }
                i.unlock();
                j.unlock();
                b();
                AppMethodBeat.o(64415);
                return;
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-519);
            b();
            AppMethodBeat.o(64415);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-505);
            AppMethodBeat.o(64415);
        }
    }

    private boolean b(Context context, File file) {
        AppMethodBeat.i(64470);
        try {
            File[] listFiles = file.listFiles(new av(this));
            int length = listFiles.length;
            if (VERSION.SDK_INT < 16 && context.getPackageName() != null && context.getPackageName().equalsIgnoreCase(TbsConfig.APP_DEMO)) {
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
            }
            ClassLoader classLoader = context.getClassLoader();
            for (int i = 0; i < length; i++) {
                TbsLog.i("TbsInstaller", "jarFile: " + listFiles[i].getAbsolutePath());
                DexClassLoader dexClassLoader = new DexClassLoader(listFiles[i].getAbsolutePath(), file.getAbsolutePath(), null, classLoader);
            }
            AppMethodBeat.o(64470);
            return true;
        } catch (Exception e2) {
            TbsLogReport.getInstance(context).setInstallErrorCode(209, e2.toString());
            TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
            AppMethodBeat.o(64470);
            return false;
        }
    }

    private boolean c(Context context, File file) {
        AppMethodBeat.i(64471);
        try {
            File file2 = new File(file, "tbs_sdk_extension_dex.jar");
            File file3 = new File(file, "tbs_sdk_extension_dex.dex");
            DexClassLoader dexClassLoader = new DexClassLoader(file2.getAbsolutePath(), file.getAbsolutePath(), null, context.getClassLoader());
            String a = g.a(context, file3.getAbsolutePath());
            if (TextUtils.isEmpty(a)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(226, "can not find oat command");
                AppMethodBeat.o(64471);
                return false;
            }
            for (File file4 : file.listFiles(new aw(this))) {
                String substring = file4.getName().substring(0, file4.getName().length() - 4);
                Runtime.getRuntime().exec("/system/bin/dex2oat " + a.replaceAll("tbs_sdk_extension_dex", substring) + " --dex-location=" + a().r(context) + File.separator + substring + ".jar").waitFor();
            }
            AppMethodBeat.o(64471);
            return true;
        } catch (Exception e) {
            TbsLogReport.getInstance(context).setInstallErrorCode(226, e);
            AppMethodBeat.o(64471);
            return false;
        }
    }

    private synchronized boolean c(Context context, boolean z) {
        Throwable th;
        boolean z2 = false;
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(64408);
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy");
            try {
                if (x(context)) {
                    boolean tryLock = i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy Locked =".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        int b = ai.a(context).b("copy_status");
                        int a = a(false, context);
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy copyStatus =".concat(String.valueOf(b)));
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer =".concat(String.valueOf(a)));
                        if (b == 1) {
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer = 0", true);
                                B(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromCopy tbsCoreInstalledVer != 0", true);
                                B(context);
                            }
                            i.unlock();
                        }
                        z3 = false;
                        try {
                            i.unlock();
                        } catch (Throwable th2) {
                            th = th2;
                            try {
                                TbsLogReport.getInstance(context).setInstallErrorCode(215, th.toString());
                                QbSdk.a(context, "TbsInstaller::enableTbsCoreFromCopy exception:" + Log.getStackTraceString(th));
                                z2 = z3;
                                AppMethodBeat.o(64408);
                                return z2;
                            } catch (Throwable th3) {
                                AppMethodBeat.o(64408);
                            }
                        }
                    } else {
                        z3 = false;
                    }
                    b();
                    z2 = z3;
                    AppMethodBeat.o(64408);
                } else {
                    AppMethodBeat.o(64408);
                }
            } catch (Throwable th4) {
                th = th4;
                z3 = false;
            }
        }
        return z2;
    }

    private synchronized boolean d(Context context, boolean z) {
        Object e;
        boolean z2 = true;
        boolean z3 = false;
        synchronized (this) {
            AppMethodBeat.i(64409);
            if (context != null && "com.tencent.mm".equals(context.getApplicationContext().getApplicationInfo().packageName)) {
                TbsLogReport.getInstance(context).setInstallErrorCode(229, " ");
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip canRenameTmpDir =".concat(String.valueOf(z)));
            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #1 ");
            try {
                if (x(context)) {
                    TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #2 ");
                    boolean tryLock = i.tryLock();
                    TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip locked=".concat(String.valueOf(tryLock)));
                    if (tryLock) {
                        int c = ai.a(context).c();
                        TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip installStatus=".concat(String.valueOf(c)));
                        int a = a(false, context);
                        if (c == 2) {
                            TbsLog.i("TbsInstaller", "Tbsinstaller enableTbsCoreFromUnzip #4 ");
                            if (a == 0) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer = 0", false);
                                A(context);
                            } else if (z) {
                                TbsLog.i("TbsInstaller", "TbsInstaller-enableTbsCoreFromUnzip tbsCoreInstalledVer != 0", false);
                                A(context);
                            }
                            i.unlock();
                        }
                        z2 = false;
                        try {
                            i.unlock();
                        } catch (Exception e2) {
                            Exception e3 = e2;
                            QbSdk.a(context, "TbsInstaller::enableTbsCoreFromUnzip Exception: ".concat(String.valueOf(e3)));
                            z3 = z2;
                            AppMethodBeat.o(64409);
                            return z3;
                        }
                    }
                    z2 = false;
                    b();
                    z3 = z2;
                    AppMethodBeat.o(64409);
                } else {
                    AppMethodBeat.o(64409);
                }
            } catch (Exception e4) {
                e3 = e4;
                z2 = false;
            } catch (Throwable th) {
                i.unlock();
                AppMethodBeat.o(64409);
            }
        }
        return z3;
    }

    private boolean e(Context context, String str) {
        PackageInfo packageInfo;
        AppMethodBeat.i(64428);
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (NameNotFoundException e) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            AppMethodBeat.o(64428);
            return true;
        }
        AppMethodBeat.o(64428);
        return false;
    }

    private synchronized boolean e(Context context, boolean z) {
        return false;
    }

    private void f(Context context, boolean z) {
        AppMethodBeat.i(64420);
        if (context == null) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead context is null");
            AppMethodBeat.o(64420);
            return;
        }
        try {
            File file = new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf");
            if (!z) {
                k.b(file);
            } else if (!file.exists()) {
                file.createNewFile();
                AppMethodBeat.o(64420);
                return;
            }
            AppMethodBeat.o(64420);
        } catch (Exception e) {
            TbsLogReport.getInstance(context).setInstallErrorCode(225, "setTmpFolderCoreToRead Exception message is " + e.getMessage() + " Exception cause is " + e.getCause());
            AppMethodBeat.o(64420);
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
    private boolean f(Context context, int i) {
        String property;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(64435);
        TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt start - dirMode: ".concat(String.valueOf(i)));
        File u;
        switch (i) {
            case 0:
                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == z4) {
                    AppMethodBeat.o(64435);
                    return z4;
                }
                u = u(context);
            case 1:
                u = w(context);
            case 2:
                u = r(context);
                property = System.getProperty("java.vm.version");
                z = (property == null && property.startsWith("2")) ? z4 : false;
                z2 = z;
                z = VERSION.SDK_INT != 23 ? z4 : false;
                z3 = TbsDownloadConfig.getInstance(context).mPreferences.getBoolean(TbsConfigKey.KEY_STOP_PRE_OAT, false);
                if (z2 && z && !z3) {
                    z5 = z4;
                }
                if (!z5 && c(context, u)) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoatForArtVm");
                    AppMethodBeat.o(64435);
                    return z4;
                } else if (z2) {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- doDexoptForDavlikVM");
                    z4 = b(context, u);
                    AppMethodBeat.o(64435);
                    return z4;
                } else {
                    TbsLog.i("TbsInstaller", "doTbsDexOpt -- is ART mode, skip!");
                    TbsLog.i("TbsInstaller", "TbsInstaller-doTbsDexOpt done");
                    AppMethodBeat.o(64435);
                    return z4;
                }
            default:
                TbsLog.e("TbsInstaller", "doDexoptOrDexoat mode error: ".concat(String.valueOf(i)));
                AppMethodBeat.o(64435);
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

    static File t(Context context) {
        AppMethodBeat.i(64463);
        File file = new File(context.getDir("tbs", 0), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64463);
            return file;
        }
        AppMethodBeat.o(64463);
        return null;
    }

    private static boolean y(Context context) {
        AppMethodBeat.i(64419);
        if (context == null) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #1");
            AppMethodBeat.o(64419);
            return true;
        }
        try {
            if (new File(context.getDir("tbs", 0), "tmp_folder_core_to_read.conf").exists()) {
                TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #2");
                AppMethodBeat.o(64419);
                return true;
            }
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #3");
            AppMethodBeat.o(64419);
            return false;
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-getTmpFolderCoreToRead, #4");
            AppMethodBeat.o(64419);
            return true;
        }
    }

    private boolean z(Context context) {
        boolean tbsCoreLoadRenameFileLockEnable;
        AppMethodBeat.i(64441);
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #1 ");
        try {
            tbsCoreLoadRenameFileLockEnable = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
            tbsCoreLoadRenameFileLockEnable = true;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock #2  enabled is ".concat(String.valueOf(tbsCoreLoadRenameFileLockEnable)));
        if (tbsCoreLoadRenameFileLockEnable) {
            l = k.f(context);
        } else {
            l = bv.a().a(context);
        }
        if (l == null) {
            TbsLog.i("TbsInstaller", "getTbsCoreRenameFileLock## failed!");
            AppMethodBeat.o(64441);
            return false;
        }
        TbsLog.i("TbsInstaller", "Tbsinstaller getTbsCoreRenameFileLock true ");
        AppMethodBeat.o(64441);
        return true;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A:{SYNTHETIC, Splitter:B:35:0x006c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(64444);
        if (str == null) {
            AppMethodBeat.o(64444);
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
                            AppMethodBeat.o(64444);
                        } else {
                            i = Integer.parseInt(property);
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e2) {
                                }
                            }
                            AppMethodBeat.o(64444);
                        }
                    } catch (Exception e3) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        AppMethodBeat.o(64444);
                        throw th;
                    }
                }
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(64444);
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
                AppMethodBeat.o(64444);
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
        AppMethodBeat.o(64444);
        return i;
        AppMethodBeat.o(64444);
        return i;
    }

    public int a(boolean z, Context context) {
        AppMethodBeat.i(64407);
        if (z || ((Integer) a.get()).intValue() <= 0) {
            a.set(Integer.valueOf(j(context)));
        }
        int intValue = ((Integer) a.get()).intValue();
        AppMethodBeat.o(64407);
        return intValue;
    }

    public void a(Context context, int i) {
        AppMethodBeat.i(64417);
        f(context, true);
        ai.a(context).b(i, 2);
        AppMethodBeat.o(64417);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context, Bundle bundle) {
        AppMethodBeat.i(64424);
        if (bundle == null || context == null) {
            AppMethodBeat.o(64424);
            return;
        }
        Object[] objArr = new Object[]{context, bundle};
        Message message = new Message();
        message.what = 3;
        message.obj = objArr;
        m.sendMessage(message);
        AppMethodBeat.o(64424);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context, String str, int i) {
        AppMethodBeat.i(64414);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsApkPath=".concat(String.valueOf(str)));
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore tbsCoreTargetVer=".concat(String.valueOf(i)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCore currentThreadName=" + Thread.currentThread().getName());
        Object[] objArr = new Object[]{context, str, Integer.valueOf(i)};
        Message message = new Message();
        message.what = 1;
        message.obj = objArr;
        m.sendMessage(message);
        AppMethodBeat.o(64414);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(Context context, boolean z) {
        boolean z2 = false;
        AppMethodBeat.i(64410);
        if (z) {
            this.k = true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (x(context)) {
            int c;
            int b;
            int c2;
            int b2;
            String str = null;
            if (i.tryLock()) {
                try {
                    c = ai.a(context).c();
                    b = ai.a(context).b();
                    String d = ai.a(context).d("install_apk_path");
                    c2 = ai.a(context).c("copy_core_ver");
                    b2 = ai.a(context).b("copy_status");
                    i.unlock();
                    str = d;
                } catch (Throwable th) {
                    i.unlock();
                    AppMethodBeat.o(64410);
                }
            } else {
                c2 = 0;
                b2 = -1;
                b = 0;
                c = -1;
            }
            b();
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore installStatus=".concat(String.valueOf(c)));
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreInstallVer=".concat(String.valueOf(b)));
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsApkPath=".concat(String.valueOf(str)));
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore tbsCoreCopyVer=".concat(String.valueOf(c2)));
            TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore copyStatus=".concat(String.valueOf(b2)));
            if (TbsShareManager.isThirdPartyApp(context)) {
                c(context, TbsShareManager.a(context, false));
                AppMethodBeat.o(64410);
                return;
            }
            int i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
            if (i == 1 || i == 2 || i == 4) {
                z2 = true;
            }
            if (!(z2 || i == 0)) {
                Bundle bundle = new Bundle();
                bundle.putInt("operation", 10001);
                a(context, bundle);
            }
            if (c >= 0 && c < 2) {
                a(context, str, b);
            }
            if (b2 == 0) {
                b(context, c2);
            }
            AppMethodBeat.o(64410);
            return;
        }
        AppMethodBeat.o(64410);
    }

    public synchronized boolean a(Context context, Context context2) {
        AppMethodBeat.i(64436);
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp");
        if (p) {
            AppMethodBeat.o(64436);
        } else {
            p = true;
            new ar(this, context2, context).start();
            AppMethodBeat.o(64436);
        }
        return true;
    }

    public boolean a(Context context, File file, int i) {
        AppMethodBeat.i(64430);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread #1");
        boolean a = a(context, file, false);
        TbsLog.i("TbsInstaller", "unzipTbsCoreToThirdAppTmpInThread result is ".concat(String.valueOf(a)));
        if (a) {
            a().a(context, i);
        }
        AppMethodBeat.o(64430);
        return a;
    }

    /* Access modifiers changed, original: 0000 */
    public Context b(Context context, String str) {
        Context context2 = null;
        AppMethodBeat.i(64429);
        try {
            if (context.getPackageName() == str || !TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                context2 = context.createPackageContext(str, 2);
                AppMethodBeat.o(64429);
                return context2;
            }
            AppMethodBeat.o(64429);
            return context2;
        } catch (Exception e) {
            AppMethodBeat.o(64429);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public File b(Context context, Context context2) {
        AppMethodBeat.i(64459);
        File file = new File(context2.getDir("tbs", 0), "core_share");
        if (file.isDirectory() || ((context != null && TbsShareManager.isThirdPartyApp(context)) || file.mkdir())) {
            AppMethodBeat.o(64459);
            return file;
        }
        AppMethodBeat.o(64459);
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void b() {
        AppMethodBeat.i(64469);
        int i = this.e;
        this.e = i - 1;
        if (i > 1 || !this.h) {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock with skip");
            AppMethodBeat.o(64469);
        } else {
            TbsLog.i("TbsInstaller", "releaseTbsInstallingFileLock without skip");
            k.a(this.f, this.g);
            this.h = false;
            AppMethodBeat.o(64469);
        }
    }

    public void b(Context context) {
        AppMethodBeat.i(64416);
        f(context, true);
        ai.a(context).b(i(context), 2);
        AppMethodBeat.o(64416);
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
    public void b(Context context, Bundle bundle) {
        Throwable e;
        AppMethodBeat.i(64425);
        if (c(context)) {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-539);
            AppMethodBeat.o(64425);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread");
        if (bundle == null || context == null) {
            AppMethodBeat.o(64425);
        } else if (!k.b(context)) {
            TbsLogReport.getInstance(context).setInstallErrorCode(210, "rom is not enough when patching tbs core! curAvailROM=" + y.a() + ",minReqRom=" + TbsDownloadConfig.getInstance(context).getDownloadMinFreeSpace());
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-540);
            AppMethodBeat.o(64425);
        } else if (x(context)) {
            boolean tryLock = j.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread locked=".concat(String.valueOf(tryLock)));
            if (tryLock) {
                Bundle bundle2 = null;
                int i;
                try {
                    QbSdk.setTBSInstallingStatus(true);
                    if (j(context) <= 0 || ai.a(context).d() == 1) {
                        QbSdk.setTBSInstallingStatus(false);
                        j.unlock();
                        b();
                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                        QbSdk.setTBSInstallingStatus(false);
                        AppMethodBeat.o(64425);
                        return;
                    }
                    i = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_RESPONSECODE, 0);
                    tryLock = i == 1 || i == 2 || i == 4;
                    if (!(tryLock || i == 0)) {
                        int c = ai.a(context).c("incrupdate_retry_num");
                        String string;
                        String string2;
                        if (c > 5) {
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread exceed incrupdate num");
                            string = bundle.getString("old_apk_location");
                            string2 = bundle.getString("new_apk_location");
                            String string3 = bundle.getString("diff_file_location");
                            if (!TextUtils.isEmpty(string)) {
                                k.b(new File(string));
                            }
                            if (!TextUtils.isEmpty(string2)) {
                                k.b(new File(string2));
                            }
                            if (!TextUtils.isEmpty(string3)) {
                                k.b(new File(string3));
                            }
                            TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                            TbsDownloadConfig.getInstance(context).commit();
                            TbsLogReport.getInstance(context).setInstallErrorCode(224, "incrUpdate exceed retry max num");
                            j.unlock();
                            b();
                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                            QbSdk.setTBSInstallingStatus(false);
                            AppMethodBeat.o(64425);
                            return;
                        }
                        ai.a(context).a("incrupdate_retry_num", c + 1);
                        File t = t(context);
                        if (t != null && new File(t, "x5.tbs").exists()) {
                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-550);
                            bundle2 = QbSdk.a(context, bundle);
                            if (bundle2 == null) {
                                try {
                                    TbsLogReport.getInstance(context).setInstallErrorCode(228, "result null : " + bundle.getInt("new_core_ver"));
                                    i = 1;
                                    j.unlock();
                                    b();
                                    if (i == 0) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                        ai.a(context).a("incrupdate_retry_num", 0);
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                        ai.a(context).b(0, -1);
                                        ai.a(context).c(1);
                                        string = bundle2.getString("apk_path");
                                        ag.a(new File(string), context);
                                        b(context, string, bundle2.getInt("tbs_core_ver"));
                                    } else if (i == 2) {
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                    } else {
                                        TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                        TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                        TbsDownloadConfig.getInstance(context).commit();
                                        TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(i)));
                                    }
                                    QbSdk.setTBSInstallingStatus(false);
                                    AppMethodBeat.o(64425);
                                    return;
                                } catch (Exception e2) {
                                    e = e2;
                                    i = 1;
                                    try {
                                        TbsLog.i("TbsInstaller", "installLocalTbsCoreExInThread exception:" + Log.getStackTraceString(e));
                                        try {
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-543);
                                            TbsLogReport.getInstance(context).setInstallErrorCode(218, e.toString());
                                            j.unlock();
                                            b();
                                            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                            TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                            TbsDownloadConfig.getInstance(context).commit();
                                            TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(1)));
                                            QbSdk.setTBSInstallingStatus(false);
                                            AppMethodBeat.o(64425);
                                            return;
                                        } catch (Throwable th) {
                                            e = th;
                                            i = 1;
                                            j.unlock();
                                            b();
                                            if (i == 0) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_SUCCESS");
                                                ai.a(context).a("incrupdate_retry_num", 0);
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-544);
                                                ai.a(context).b(0, -1);
                                                ai.a(context).c(1);
                                                string2 = bundle2.getString("apk_path");
                                                ag.a(new File(string2), context);
                                                b(context, string2, bundle2.getInt("tbs_core_ver"));
                                            } else if (i == 2) {
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_NONEEDPATCH");
                                            } else {
                                                TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-546);
                                                TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTesCoreExInThread PATCH_FAIL");
                                                TbsDownloadConfig.getInstance(context).a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                                                TbsDownloadConfig.getInstance(context).commit();
                                                TbsLogReport.getInstance(context).setInstallErrorCode(217, "incrUpdate fail! patch ret=".concat(String.valueOf(i)));
                                            }
                                            QbSdk.setTBSInstallingStatus(false);
                                            AppMethodBeat.o(64425);
                                            throw e;
                                        }
                                    } catch (Throwable th2) {
                                        e = th2;
                                        j.unlock();
                                        b();
                                        if (i == 0) {
                                        }
                                        QbSdk.setTBSInstallingStatus(false);
                                        AppMethodBeat.o(64425);
                                        throw e;
                                    }
                                }
                            }
                            i = bundle2.getInt("patch_result");
                            try {
                                TbsLogReport.getInstance(context).setInstallErrorCode(228, "result " + i + " : " + bundle.getInt("new_core_ver"));
                                j.unlock();
                                b();
                                if (i == 0) {
                                }
                                QbSdk.setTBSInstallingStatus(false);
                                AppMethodBeat.o(64425);
                                return;
                            } catch (Exception e3) {
                                e = e3;
                            }
                        }
                    }
                    i = 2;
                    j.unlock();
                    b();
                    if (i == 0) {
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    AppMethodBeat.o(64425);
                    return;
                } catch (Exception e4) {
                    e = e4;
                    i = 2;
                } catch (Throwable th3) {
                    e = th3;
                    i = 2;
                    j.unlock();
                    b();
                    if (i == 0) {
                    }
                    QbSdk.setTBSInstallingStatus(false);
                    AppMethodBeat.o(64425);
                    throw e;
                }
            }
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-547);
            b();
            AppMethodBeat.o(64425);
        } else {
            TbsDownloadConfig.getInstance(context).setInstallInterruptCode(-541);
            AppMethodBeat.o(64425);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void b(Context context, boolean z) {
        AppMethodBeat.i(64412);
        if (QbSdk.b) {
            AppMethodBeat.o(64412);
        } else if (VERSION.SDK_INT < 8) {
            TbsLog.e("TbsInstaller", "android version < 2.1 no need install X5 core", true);
            AppMethodBeat.o(64412);
        } else {
            try {
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    File v = v(context);
                    if (v != null && v.exists()) {
                        k.a(v, false);
                    }
                }
            } catch (Throwable th) {
            }
            TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #1 ");
            if (y(context)) {
                TbsLog.i("TbsInstaller", "Tbsinstaller installTbsCoreIfNeeded #2 ");
                if (a(context, "core_unzip_tmp") && d(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromUnzip!!", true);
                    AppMethodBeat.o(64412);
                    return;
                } else if (a(context, "core_share_backup_tmp") && e(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromBackup!!", true);
                    AppMethodBeat.o(64412);
                    return;
                } else if (a(context, "core_copy_tmp") && c(context, z)) {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, enableTbsCoreFromCopy!!", true);
                    AppMethodBeat.o(64412);
                    return;
                } else {
                    TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreIfNeeded, error !!", true);
                    AppMethodBeat.o(64412);
                    return;
                }
            }
            AppMethodBeat.o(64412);
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean b(Context context, int i) {
        AppMethodBeat.i(64423);
        if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(64423);
            return false;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore targetTbsCoreVer=".concat(String.valueOf(i)));
        TbsLog.i("TbsInstaller", "TbsInstaller-continueInstallTbsCore currentProcessName=" + context.getApplicationInfo().processName);
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentProcessId=" + Process.myPid());
        TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore currentThreadName=" + Thread.currentThread().getName());
        if (d(context, i) != null) {
            Object[] objArr = new Object[]{d(context, i), context, Integer.valueOf(i)};
            Message message = new Message();
            message.what = 2;
            message.obj = objArr;
            m.sendMessage(message);
            AppMethodBeat.o(64423);
            return true;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--installLocalTbsCore copy from null");
        AppMethodBeat.o(64423);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    public int c(Context context, String str) {
        AppMethodBeat.i(64439);
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        if (packageArchiveInfo != null) {
            int i = packageArchiveInfo.versionCode;
            AppMethodBeat.o(64439);
            return i;
        }
        AppMethodBeat.o(64439);
        return 0;
    }

    /* Access modifiers changed, original: 0000 */
    public void c(Context context, int i) {
        AppMethodBeat.i(64426);
        TbsLog.i("TbsInstaller", "TbsInstaller-installTbsCoreForThirdPartyApp");
        if (i <= 0) {
            AppMethodBeat.o(64426);
            return;
        }
        int j = j(context);
        if (j == i) {
            AppMethodBeat.o(64426);
            return;
        }
        Context e = TbsShareManager.e(context);
        if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
            if (j <= 0) {
                TbsLog.i("TbsInstaller", "TbsInstaller--installTbsCoreForThirdPartyApp hostContext == null");
                QbSdk.a(context, "TbsInstaller::installTbsCoreForThirdPartyApp forceSysWebViewInner #2");
            }
            AppMethodBeat.o(64426);
            return;
        }
        TbsLog.i("TbsInstaller", "TbsInstaller--quickDexOptForThirdPartyApp hostContext != null");
        a(context, e);
        AppMethodBeat.o(64426);
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
    public boolean c(Context context) {
        BufferedInputStream bufferedInputStream;
        int i = 1;
        AppMethodBeat.i(64418);
        File file = new File(r(context), "tbs.conf");
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
                    TbsLog.i("TbsInstaller", "TBS_LOCAL_INSTALLATION is:" + booleanValue + " expired=" + z);
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
                AppMethodBeat.o(64418);
                throw th3;
            }
            AppMethodBeat.o(64418);
            return z;
        }
        AppMethodBeat.o(64418);
        return false;
    }

    public Context d(Context context, int i) {
        AppMethodBeat.i(64438);
        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreHostContext tbsCoreTargetVer=".concat(String.valueOf(i)));
        if (i <= 0) {
            AppMethodBeat.o(64438);
            return null;
        }
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        int i2 = 0;
        while (i2 < coreProviderAppList.length) {
            if (!context.getPackageName().equalsIgnoreCase(coreProviderAppList[i2]) && e(context, coreProviderAppList[i2])) {
                Context b = b(context, coreProviderAppList[i2]);
                if (b == null) {
                    continue;
                } else if (f(b)) {
                    int j = j(b);
                    TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext hostTbsCoreVer=".concat(String.valueOf(j)));
                    if (j != 0 && j == i) {
                        TbsLog.i("TbsInstaller", "TbsInstaller-getTbsCoreHostContext targetApp=" + coreProviderAppList[i2]);
                        AppMethodBeat.o(64438);
                        return b;
                    }
                } else {
                    TbsLog.e("TbsInstaller", "TbsInstaller--getTbsCoreHostContext " + coreProviderAppList[i2] + " illegal signature go on next");
                }
            }
            i2++;
        }
        AppMethodBeat.o(64438);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x005f A:{SYNTHETIC, Splitter:B:29:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public String d(Context context, String str) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        BufferedInputStream bufferedInputStream2;
        String str2 = null;
        AppMethodBeat.i(64446);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(64446);
        } else {
            bufferedInputStream = null;
            try {
                File file = new File(r(context), "tbs.conf");
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
                        AppMethodBeat.o(64446);
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedInputStream2 = bufferedInputStream;
                        if (bufferedInputStream2 != null) {
                        }
                        AppMethodBeat.o(64446);
                        throw th;
                    }
                }
                if (str2 != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (IOException e3) {
                    }
                }
                AppMethodBeat.o(64446);
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
                AppMethodBeat.o(64446);
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
        AppMethodBeat.o(64446);
        return str2;
        AppMethodBeat.o(64446);
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
    public void d(Context context) {
        Throwable th;
        BufferedOutputStream bufferedOutputStream;
        AppMethodBeat.i(64421);
        try {
            File file = new File(r(context), "tbs.conf");
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
                        AppMethodBeat.o(64421);
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                        }
                        if (bufferedInputStream != null) {
                        }
                        AppMethodBeat.o(64421);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                    if (bufferedOutputStream != null) {
                    }
                    if (bufferedInputStream != null) {
                    }
                    AppMethodBeat.o(64421);
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
                AppMethodBeat.o(64421);
                throw th;
            }
        } catch (IOException e4) {
            AppMethodBeat.o(64421);
        } catch (Throwable th4) {
            AppMethodBeat.o(64421);
        }
    }

    public boolean e(Context context) {
        AppMethodBeat.i(64434);
        try {
            File file = new File(k.a(context, 4), "x5.tbs.decouple");
            File v = a().v(context);
            k.a(v);
            k.a(v, true);
            k.a(file, v);
            String[] list = v.list();
            for (String file2 : list) {
                File file3 = new File(v, file2);
                if (file3.getName().endsWith(".dex")) {
                    file3.delete();
                }
            }
            a().f(context, true);
            file = q(context);
            k.a(file, true);
            v.renameTo(file);
            TbsShareManager.b(context);
            AppMethodBeat.o(64434);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(64434);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public boolean e(Context context, int i) {
        boolean z = true;
        AppMethodBeat.i(64467);
        try {
            File r;
            File file;
            boolean isThirdPartyApp = TbsShareManager.isThirdPartyApp(context);
            if (!isThirdPartyApp) {
                r = r(context);
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context));
                if (file.getAbsolutePath().contains(TbsConfig.APP_DEMO)) {
                    AppMethodBeat.o(64467);
                    return true;
                }
                r = file;
            } else {
                TbsLog.e("TbsInstaller", "321");
                AppMethodBeat.o(64467);
                return false;
            }
            if (r != null) {
                Long[][] lArr = n;
                int length = lArr.length;
                int i2 = 0;
                while (i2 < length) {
                    Long[] lArr2 = lArr[i2];
                    if (i == lArr2[0].intValue()) {
                        file = new File(r, "libmttwebview.so");
                        if (file.exists() && file.length() == lArr2[1].longValue()) {
                            TbsLog.d("TbsInstaller", "check so success: " + i + "; file: " + file);
                        } else {
                            if (!isThirdPartyApp) {
                                k.b(context.getDir("tbs", 0));
                            }
                            a.set(Integer.valueOf(0));
                            TbsLog.e("TbsInstaller", "322");
                            z = false;
                        }
                    } else {
                        i2++;
                    }
                }
            } else {
                TbsLog.e("TbsInstaller", "323");
                z = false;
            }
        } catch (Throwable th) {
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getMessage is " + th.getMessage());
            TbsLog.e("TbsInstaller", "ISTBSCORELEGAL exception getCause is " + th.getCause());
            z = false;
        }
        AppMethodBeat.o(64467);
        return z;
    }

    /* Access modifiers changed, original: 0000 */
    public boolean f(Context context) {
        AppMethodBeat.i(64437);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            AppMethodBeat.o(64437);
            return true;
        }
        try {
            Signature signature = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0];
            if (context.getPackageName().equals(TbsConfig.APP_QB)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.mm")) {
                if (!signature.toCharsString().equals("308202eb30820254a00302010202044d36f7a4300d06092a864886f70d01010505003081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e74301e170d3131303131393134333933325a170d3431303131313134333933325a3081b9310b300906035504061302383631123010060355040813094775616e67646f6e673111300f060355040713085368656e7a68656e31353033060355040a132c54656e63656e7420546563686e6f6c6f6779285368656e7a68656e2920436f6d70616e79204c696d69746564313a3038060355040b133154656e63656e74204775616e677a686f7520526573656172636820616e6420446576656c6f706d656e742043656e7465723110300e0603550403130754656e63656e7430819f300d06092a864886f70d010101050003818d0030818902818100c05f34b231b083fb1323670bfbe7bdab40c0c0a6efc87ef2072a1ff0d60cc67c8edb0d0847f210bea6cbfaa241be70c86daf56be08b723c859e52428a064555d80db448cdcacc1aea2501eba06f8bad12a4fa49d85cacd7abeb68945a5cb5e061629b52e3254c373550ee4e40cb7c8ae6f7a8151ccd8df582d446f39ae0c5e930203010001300d06092a864886f70d0101050500038181009c8d9d7f2f908c42081b4c764c377109a8b2c70582422125ce545842d5f520aea69550b6bd8bfd94e987b75a3077eb04ad341f481aac266e89d3864456e69fba13df018acdc168b9a19dfd7ad9d9cc6f6ace57c746515f71234df3a053e33ba93ece5cd0fc15f3e389a3f365588a9fcb439e069d3629cd7732a13fff7b891499")) {
                    AppMethodBeat.o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QQ)) {
                if (!signature.toCharsString().equals("30820253308201bca00302010202044bbb0361300d06092a864886f70d0101050500306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b30090603550403130251513020170d3130303430363039343831375a180f32323834303132303039343831375a306d310e300c060355040613054368696e61310f300d06035504080c06e58c97e4baac310f300d06035504070c06e58c97e4baac310f300d060355040a0c06e885bee8aeaf311b3019060355040b0c12e697a0e7babfe4b89ae58aa1e7b3bbe7bb9f310b300906035504031302515130819f300d06092a864886f70d010101050003818d0030818902818100a15e9756216f694c5915e0b529095254367c4e64faeff07ae13488d946615a58ddc31a415f717d019edc6d30b9603d3e2a7b3de0ab7e0cf52dfee39373bc472fa997027d798d59f81d525a69ecf156e885fd1e2790924386b2230cc90e3b7adc95603ddcf4c40bdc72f22db0f216a99c371d3bf89cba6578c60699e8a0d536950203010001300d06092a864886f70d01010505000381810094a9b80e80691645dd42d6611775a855f71bcd4d77cb60a8e29404035a5e00b21bcc5d4a562482126bd91b6b0e50709377ceb9ef8c2efd12cc8b16afd9a159f350bb270b14204ff065d843832720702e28b41491fbc3a205f5f2f42526d67f17614d8a974de6487b2c866efede3b4e49a0f916baa3c1336fd2ee1b1629652049")) {
                    AppMethodBeat.o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_DEMO)) {
                if (!signature.toCharsString().equals("3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a")) {
                    AppMethodBeat.o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals(TbsConfig.APP_QZONE)) {
                if (!signature.toCharsString().equals("308202ad30820216a00302010202044c26cea2300d06092a864886f70d010105050030819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d301e170d3130303632373034303830325a170d3335303632313034303830325a30819a310b3009060355040613023836311530130603550408130c4265696a696e672043697479311530130603550407130c4265696a696e67204369747931263024060355040a131d515a6f6e65205465616d206f662054656e63656e7420436f6d70616e7931183016060355040b130f54656e63656e7420436f6d70616e79311b301906035504031312416e64726f696420515a6f6e65205465616d30819f300d06092a864886f70d010101050003818d003081890281810082d6aca037a9843fbbe88b6dd19f36e9c24ce174c1b398f3a529e2a7fe02de99c27539602c026edf96ad8d43df32a85458bca1e6fbf11958658a7d6751a1d9b782bf43a8c19bd1c06bdbfd94c0516326ae3cf638ac42bb470580e340c46e6f306a772c1ef98f10a559edf867f3f31fe492808776b7bd953b2cba2d2b2d66a44f0203010001300d06092a864886f70d0101050500038181006003b04a8a8c5be9650f350cda6896e57dd13e6e83e7f891fc70f6a3c2eaf75cfa4fc998365deabbd1b9092159edf4b90df5702a0d101f8840b5d4586eb92a1c3cd19d95fbc1c2ac956309eda8eef3944baf08c4a49d3b9b3ffb06bc13dab94ecb5b8eb74e8789aa0ba21cb567f538bbc59c2a11e6919924a24272eb79251677")) {
                    AppMethodBeat.o(64437);
                    return false;
                }
            } else if (context.getPackageName().equals("com.tencent.qqpimsecure") && !signature.toCharsString().equals("30820239308201a2a00302010202044c96f48f300d06092a864886f70d01010505003060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e57753020170d3130303932303035343334335a180f32303635303632333035343334335a3060310b300906035504061302434e310b300906035504081302474431123010060355040713094775616e677a686f753110300e060355040a130754656e63656e74310b3009060355040b130233473111300f0603550403130857696c736f6e577530819f300d06092a864886f70d010101050003818d0030818902818100b56e79dbb1185a79e52d792bb3d0bb3da8010d9b87da92ec69f7dc5ad66ab6bfdff2a6a1ed285dd2358f28b72a468be7c10a2ce30c4c27323ed4edcc936080e5bedc2cbbca0b7e879c08a631182793f44bb3ea284179b263410c298e5f6831032c9702ba4a74e2ccfc9ef857f12201451602fc8e774ac59d6398511586c83d1d0203010001300d06092a864886f70d0101050500038181002475615bb65b8d8786b890535802948840387d06b1692ff3ea47ef4c435719ba1865b81e6bfa6293ce31747c3cd6b34595b485cc1563fd90107ba5845c28b95c79138f0dec288940395bc10f92f2b69d8dc410999deb38900974ce9984b678030edfba8816582f56160d87e38641288d8588d2a31e20b89f223d788dd35cc9c8")) {
                AppMethodBeat.o(64437);
                return false;
            }
            AppMethodBeat.o(64437);
            return true;
        } catch (Exception e) {
            TbsLog.i("TbsInstaller", "TbsInstaller-installLocalTbsCore getPackageInfo fail");
            AppMethodBeat.o(64437);
            return false;
        }
    }

    public void g(Context context) {
        AppMethodBeat.i(64440);
        boolean z = true;
        try {
            z = TbsDownloadConfig.getInstance().getTbsCoreLoadRenameFileLockEnable();
        } catch (Throwable th) {
        }
        if (z && l != null) {
            k.a(context, l);
        }
        AppMethodBeat.o(64440);
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A:{SYNTHETIC, Splitter:B:32:0x0076} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int h(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(64445);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File u = u(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--getTmpTbsCoreVersionUnzipDir  tbsShareDir is ".concat(String.valueOf(u)));
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
                        AppMethodBeat.o(64445);
                    } else {
                        i = Integer.parseInt(property);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        AppMethodBeat.o(64445);
                    }
                } catch (Exception e3) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.o(64445);
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(64445);
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
            AppMethodBeat.o(64445);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.o(64445);
        return i;
        AppMethodBeat.o(64445);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065 A:{SYNTHETIC, Splitter:B:32:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int i(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        int i = 0;
        AppMethodBeat.i(64447);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(q(context), "tbs.conf");
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
                        AppMethodBeat.o(64447);
                    } else {
                        i = Integer.parseInt(property);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        AppMethodBeat.o(64447);
                    }
                } catch (Exception e3) {
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream2 = bufferedInputStream;
                    if (bufferedInputStream2 != null) {
                    }
                    AppMethodBeat.o(64447);
                    throw th;
                }
            }
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(64447);
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
            AppMethodBeat.o(64447);
            throw th;
        }
        return i;
        if (bufferedInputStream != null) {
            try {
                bufferedInputStream.close();
            } catch (IOException e7) {
            }
        }
        AppMethodBeat.o(64447);
        return i;
        AppMethodBeat.o(64447);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0089 A:{SYNTHETIC, Splitter:B:36:0x0089} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int j(Context context) {
        BufferedInputStream bufferedInputStream;
        Exception e;
        Throwable th;
        AppMethodBeat.i(64448);
        BufferedInputStream bufferedInputStream2 = null;
        try {
            File file = new File(r(context), "tbs.conf");
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
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e2.toString());
                            }
                        }
                        AppMethodBeat.o(64448);
                        return 0;
                    }
                    int parseInt = Integer.parseInt(property);
                    if (o == 0) {
                        o = parseInt;
                    }
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e3) {
                            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e3.toString());
                        }
                    }
                    AppMethodBeat.o(64448);
                    return parseInt;
                } catch (Exception e4) {
                    e = e4;
                }
            } else {
                if (bufferedInputStream2 != null) {
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e22) {
                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e22.toString());
                    }
                }
                AppMethodBeat.o(64448);
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
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e32.toString());
                }
            }
            AppMethodBeat.o(64448);
            throw th;
        }
        AppMethodBeat.o(64448);
        return 0;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVerInNolock IOException=" + e222.toString());
                }
            }
            AppMethodBeat.o(64448);
            return 0;
        } catch (Throwable th3) {
            th = th3;
            if (bufferedInputStream != null) {
            }
            AppMethodBeat.o(64448);
            throw th;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public int k(Context context) {
        AppMethodBeat.i(64449);
        int i;
        if (o != 0) {
            i = o;
            AppMethodBeat.o(64449);
            return i;
        }
        i = j(context);
        AppMethodBeat.o(64449);
        return i;
    }

    /* Access modifiers changed, original: 0000 */
    public void l(Context context) {
        AppMethodBeat.i(64450);
        if (o != 0) {
            AppMethodBeat.o(64450);
            return;
        }
        o = j(context);
        AppMethodBeat.o(64450);
    }

    /* Access modifiers changed, original: 0000 */
    public boolean m(Context context) {
        AppMethodBeat.i(64451);
        if (new File(r(context), "tbs.conf").exists()) {
            AppMethodBeat.o(64451);
            return true;
        }
        AppMethodBeat.o(64451);
        return false;
    }

    /* Access modifiers changed, original: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fe A:{SYNTHETIC, Splitter:B:55:0x00fe} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0109 A:{Catch:{ Throwable -> 0x013a }} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ec A:{Catch:{ Throwable -> 0x016a }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int n(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        Exception e;
        AppMethodBeat.i(64452);
        if (x(context)) {
            boolean tryLock = i.tryLock();
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer locked=".concat(String.valueOf(tryLock)));
            if (tryLock) {
                BufferedInputStream bufferedInputStream2 = null;
                try {
                    File file = new File(r(context), "tbs.conf");
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
                                        TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e2.toString());
                                    }
                                }
                                try {
                                    if (i.isHeldByCurrentThread()) {
                                        i.unlock();
                                    }
                                } catch (Throwable th2) {
                                    TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th2)));
                                }
                                b();
                                AppMethodBeat.o(64452);
                                return 0;
                            }
                            a.set(Integer.valueOf(Integer.parseInt(property)));
                            int intValue = ((Integer) a.get()).intValue();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (IOException e3) {
                                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e3.toString());
                                }
                            }
                            try {
                                if (i.isHeldByCurrentThread()) {
                                    i.unlock();
                                }
                            } catch (Throwable th3) {
                                TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th3)));
                            }
                            b();
                            AppMethodBeat.o(64452);
                            return intValue;
                        } catch (Exception e4) {
                            e = e4;
                        }
                    } else {
                        if (bufferedInputStream2 != null) {
                            try {
                                bufferedInputStream2.close();
                            } catch (IOException e22) {
                                TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e22.toString());
                            }
                        }
                        try {
                            if (i.isHeldByCurrentThread()) {
                                i.unlock();
                            }
                        } catch (Throwable th22) {
                            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th22)));
                        }
                        b();
                        AppMethodBeat.o(64452);
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
                        if (i.isHeldByCurrentThread()) {
                        }
                    } catch (Throwable th32) {
                        TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th32)));
                    }
                    b();
                    AppMethodBeat.o(64452);
                    throw th22;
                }
            }
            b();
            AppMethodBeat.o(64452);
            return 0;
        }
        AppMethodBeat.o(64452);
        return -1;
        b();
        AppMethodBeat.o(64452);
        return 0;
        try {
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
        } catch (Throwable th222) {
            TbsLog.e("TbsInstaller", "TbsRenameLock.unlock exception: ".concat(String.valueOf(th222)));
        }
        b();
        AppMethodBeat.o(64452);
        return 0;
        try {
            TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer Exception=" + e.toString());
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e222) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e222.toString());
                }
            }
            if (i.isHeldByCurrentThread()) {
            }
            b();
            AppMethodBeat.o(64452);
            return 0;
        } catch (Throwable th5) {
            th222 = th5;
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e32) {
                    TbsLog.i("TbsInstaller", "TbsInstaller--getTbsCoreInstalledVer IOException=" + e32.toString());
                }
            }
            if (i.isHeldByCurrentThread()) {
                i.unlock();
            }
            b();
            AppMethodBeat.o(64452);
            throw th222;
        }
    }

    public boolean o(Context context) {
        AppMethodBeat.i(64455);
        TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple #0");
        File r = r(context);
        File q = q(context);
        try {
            k.a(q, true);
            k.a(r, q, new au(this));
            TbsShareManager.b(context);
            TbsLog.i("TbsInstaller", "TbsInstaller--coreShareCopyToDecouple success!!!");
            AppMethodBeat.o(64455);
            return true;
        } catch (Exception e) {
            AppMethodBeat.o(64455);
            return false;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public void p(Context context) {
        AppMethodBeat.i(64458);
        TbsLog.i("TbsInstaller", "TbsInstaller--cleanStatusAndTmpDir");
        ai.a(context).a(0);
        ai.a(context).b(0);
        ai.a(context).d(0);
        ai.a(context).a("incrupdate_retry_num", 0);
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) != 1) {
            ai.a(context).b(0, -1);
            ai.a(context).a("");
            ai.a(context).a("copy_retry_num", 0);
            ai.a(context).c(-1);
            ai.a(context).a(0, -1);
            k.a(u(context), true);
            k.a(w(context), true);
        }
        AppMethodBeat.o(64458);
    }

    /* Access modifiers changed, original: 0000 */
    public File q(Context context) {
        AppMethodBeat.i(64460);
        File file = new File(context.getDir("tbs", 0), "core_share_decouple");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64460);
            return file;
        }
        AppMethodBeat.o(64460);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public File r(Context context) {
        AppMethodBeat.i(64461);
        File b = b(null, context);
        AppMethodBeat.o(64461);
        return b;
    }

    /* Access modifiers changed, original: 0000 */
    public File s(Context context) {
        AppMethodBeat.i(64462);
        File file = new File(context.getDir("tbs", 0), "share");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64462);
            return file;
        }
        AppMethodBeat.o(64462);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public File u(Context context) {
        AppMethodBeat.i(64464);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64464);
            return file;
        }
        AppMethodBeat.o(64464);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public File v(Context context) {
        AppMethodBeat.i(64465);
        File file = new File(context.getDir("tbs", 0), "core_unzip_tmp_decouple");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64465);
            return file;
        }
        AppMethodBeat.o(64465);
        return null;
    }

    /* Access modifiers changed, original: 0000 */
    public File w(Context context) {
        AppMethodBeat.i(64466);
        File file = new File(context.getDir("tbs", 0), "core_copy_tmp");
        if (file.isDirectory() || file.mkdir()) {
            AppMethodBeat.o(64466);
            return file;
        }
        AppMethodBeat.o(64466);
        return null;
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized boolean x(Context context) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(64468);
            this.e++;
            if (this.h) {
                TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= true");
                AppMethodBeat.o(64468);
            } else {
                this.g = k.b(context, true, "tbslock.txt");
                if (this.g != null) {
                    this.f = k.a(context, this.g);
                    if (this.f == null) {
                        AppMethodBeat.o(64468);
                        z = false;
                    } else {
                        TbsLog.i("TbsInstaller", "getTbsInstallingFileLock success,is cached= false");
                        this.h = true;
                        AppMethodBeat.o(64468);
                    }
                } else {
                    AppMethodBeat.o(64468);
                    z = false;
                }
            }
        }
        return z;
    }
}
