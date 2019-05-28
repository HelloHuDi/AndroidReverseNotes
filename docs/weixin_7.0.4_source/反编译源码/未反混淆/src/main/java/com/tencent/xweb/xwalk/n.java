package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.c.c;
import com.tencent.xweb.util.b;
import com.tencent.xweb.util.f;
import com.tencent.xweb.w;
import java.io.File;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkDecompressor;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.FileListMD5Checker;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public class n implements XWalkInitListener, XWalkBackgroundUpdateListener {
    static n ASD;
    XWalkInitializer ASE;
    XWalkUpdater ASF;
    protected Context mContext;

    public static class a implements com.tencent.xweb.k.a {
        public final void a(Context context, HashMap<String, String> hashMap) {
            AppMethodBeat.i(85375);
            n.a(context, hashMap);
            AppMethodBeat.o(85375);
        }

        public final boolean isBusy() {
            AppMethodBeat.i(85376);
            boolean isBusy = n.isBusy();
            AppMethodBeat.o(85376);
            return isBusy;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(Context context, HashMap<String, String> hashMap) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(85377);
        if (ASD == null) {
            ASD = new n(context);
        }
        if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersion())) {
            rE(false);
        }
        if (c.b("LOAD_CORE", d.WV_KIND_CW).APn >= 6) {
            f.nI(252);
            if ("true".equalsIgnoreCase(com.tencent.xweb.a.iG("enable_check_dex", "tools"))) {
                z = true;
                if (z) {
                    String str = "check_need_fix_dex";
                    if ("true".equals(com.tencent.xweb.a.ava("dis_".concat(String.valueOf(str))))) {
                        z2 = false;
                    } else {
                        SharedPreferences mMKVSharedPreferences = XWalkEnvironment.getMMKVSharedPreferences("FREQUENT_LIMITER");
                        long j = mMKVSharedPreferences.getLong(str, 0);
                        long currentTimeMillis = System.currentTimeMillis();
                        if (Math.abs(currentTimeMillis - j) < 43200000) {
                            z2 = false;
                        } else {
                            mMKVSharedPreferences.edit().putLong(str, currentTimeMillis).commit();
                        }
                    }
                    if (z2 && !dVL()) {
                        f.nI(248);
                        XWalkEnvironment.setAvailableVersion(-1, null);
                    }
                }
                E(context, false);
                ASD.s(hashMap);
                AppMethodBeat.o(85377);
            }
        }
        if (c.b("CREATE_WEBVIEW", d.WV_KIND_CW).APn >= 6) {
            f.nI(247);
            if ("true".equalsIgnoreCase(com.tencent.xweb.a.iG("enable_check_dex_new_web", "tools"))) {
                z = true;
                if (z) {
                }
                E(context, false);
                ASD.s(hashMap);
                AppMethodBeat.o(85377);
            }
        }
        z = false;
        if (z) {
        }
        E(context, false);
        ASD.s(hashMap);
        AppMethodBeat.o(85377);
    }

    public static void E(Context context, boolean z) {
        AppMethodBeat.i(85378);
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.o(85378);
            return;
        }
        long j = sharedPreferencesForUpdateConfig.getLong("LAST_TRY_CLEAR_APK_TIME", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis < j || currentTimeMillis - j > 259200000) {
            try {
                jD(context);
            } catch (Exception e) {
                Log.e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + e.getMessage());
            }
            sharedPreferencesForUpdateConfig.edit().putLong("LAST_TRY_CLEAR_APK_TIME", currentTimeMillis).commit();
        }
        AppMethodBeat.o(85378);
    }

    private static void jD(Context context) {
        AppMethodBeat.i(85379);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            AppMethodBeat.o(85379);
            return;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            AppMethodBeat.o(85379);
            return;
        }
        int i = 0;
        int i2 = 0;
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
        int length = listFiles.length;
        int i3 = 0;
        while (i3 < length) {
            int i4;
            int i5;
            int ay = ay(listFiles[i3]);
            if (ay >= 0 && ay != installedNewstVersion) {
                if (ay >= i) {
                    i4 = i;
                    i5 = ay;
                } else if (ay >= i2) {
                    i4 = ay;
                    i5 = i;
                }
                i3++;
                i2 = i4;
                i = i5;
            }
            i4 = i2;
            i5 = i;
            i3++;
            i2 = i4;
            i = i5;
        }
        for (File file : listFiles) {
            i = ay(file);
            if (i > 0 && i < i2 && i != XWalkEnvironment.getAvailableVersion()) {
                try {
                    b.avl(file.getAbsolutePath());
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(i)));
                    f.n(577, 65, 1);
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + e.getMessage());
                    f.n(577, 66, 1);
                }
            }
        }
        AppMethodBeat.o(85379);
    }

    public static int aE(Context context, int i) {
        Object obj = 1;
        AppMethodBeat.i(85380);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
            AppMethodBeat.o(85380);
            return -1;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
            AppMethodBeat.o(85380);
            return -1;
        }
        int ay;
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
        int length = listFiles.length;
        int i2 = 0;
        int i3 = -1;
        Object obj2 = null;
        while (i2 < length) {
            ay = ay(listFiles[i2]);
            if (ay >= 0) {
                if (ay == i) {
                    obj2 = 1;
                }
                if (ay <= i && ay >= 49 && ay != installedNewstVersion && ay > i3) {
                    i2++;
                    i3 = ay;
                }
            }
            ay = i3;
            i2++;
            i3 = ay;
        }
        if (i3 <= 0) {
            obj = null;
        }
        if (obj2 == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer did not find target version:".concat(String.valueOf(i)));
            if (!SA(i3)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                ay = -1;
            }
            ay = i3;
        } else if (SA(i)) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            ay = i;
        } else {
            if (!SA(i3)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                ay = -1;
            }
            ay = i3;
        }
        if (ay == i) {
            f.nI(89);
        } else if (ay > 0) {
            f.nI(90);
        } else if (obj != null) {
            f.nI(92);
        } else {
            f.nI(91);
        }
        XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + ay);
        XWalkEnvironment.setAvailableVersion(ay, "revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + ay);
        AppMethodBeat.o(85380);
        return ay;
    }

    private static boolean SA(int i) {
        AppMethodBeat.i(85381);
        File SC = SC(i);
        if (SC == null) {
            Log.e("XWalkUpdaterImp", "checkfiles no config file");
            AppMethodBeat.o(85381);
            return false;
        }
        boolean checkFileListMd5 = FileListMD5Checker.checkFileListMd5(i, SC);
        AppMethodBeat.o(85381);
        return checkFileListMd5;
    }

    private static int ay(File file) {
        int i = -1;
        AppMethodBeat.i(85382);
        if (file == null) {
            AppMethodBeat.o(85382);
        } else {
            String name = file.getName();
            if (name != null && name.startsWith("app_xwalk_") && file.isDirectory()) {
                name = name.substring(10);
                try {
                    i = Integer.parseInt(name);
                    AppMethodBeat.o(85382);
                } catch (Exception e) {
                    Log.e("XWalkUpdaterImp", "get apk version strApkVer  is ".concat(String.valueOf(name)));
                }
            }
            AppMethodBeat.o(85382);
        }
        return i;
    }

    private static boolean dVK() {
        AppMethodBeat.i(85383);
        if (b.avl(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersion()))) {
            XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
            AppMethodBeat.o(85383);
            return true;
        }
        XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
        AppMethodBeat.o(85383);
        return false;
    }

    public static boolean dVL() {
        AppMethodBeat.i(85384);
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
        if (installedNewstVersion <= 0) {
            AppMethodBeat.o(85384);
            return false;
        }
        File SC = SC(installedNewstVersion);
        if (SC == null) {
            Log.e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
            AppMethodBeat.o(85384);
            return false;
        } else if (FileListMD5Checker.checkFileListMd5(installedNewstVersion, SC)) {
            boolean z;
            String extractedCoreDir = XWalkEnvironment.getExtractedCoreDir(installedNewstVersion);
            String str = XWalkEnvironment.getExtractedCoreDir(installedNewstVersion) + "_bk";
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (!XWalkDecompressor.extractResource(XWalkEnvironment.getDownloadApkPath(installedNewstVersion), str)) {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex extract faield");
            }
            extractedCoreDir = extractedCoreDir + File.separator + XWalkEnvironment.XWALK_CORE_CLASSES_DEX;
            str = str + File.separator + XWalkEnvironment.XWALK_CORE_CLASSES_DEX;
            String cz = com.tencent.xweb.util.d.cz(extractedCoreDir);
            if (TextUtils.isEmpty(cz)) {
                cz = "";
            }
            if (!cz.equalsIgnoreCase(com.tencent.xweb.util.d.cz(str))) {
                f.nI(253);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
                if (!b.avl(extractedCoreDir)) {
                    f.nI(250);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
                    z = false;
                } else if (b.copyFile(str, extractedCoreDir)) {
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
                    z = true;
                } else {
                    f.nI(249);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
                    z = false;
                }
                dVK();
            } else if (dVK()) {
                f.nI(254);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
                z = true;
            } else {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
                f.nI(255);
                z = false;
            }
            AppMethodBeat.o(85384);
            return z;
        } else {
            Log.e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
            AppMethodBeat.o(85384);
            return false;
        }
    }

    public static void rE(boolean z) {
        AppMethodBeat.i(85385);
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion <= 0) {
            AppMethodBeat.o(85385);
            return;
        }
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.o(85385);
            return;
        }
        long j = sharedPreferencesForUpdateConfig.getLong("CHECK_FILES_MD5_TIME", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis < j || currentTimeMillis - j > 7200000) {
            int i;
            sharedPreferencesForUpdateConfig.edit().putLong("CHECK_FILES_MD5_TIME", currentTimeMillis).commit();
            boolean checkExtractResFileLengtgAndMd5 = XWalkUpdater.checkExtractResFileLengtgAndMd5(XWalkEnvironment.getDownloadResFileListConfig(availableVersion), XWalkEnvironment.getExtractedCoreDir(availableVersion), availableVersion);
            if (!checkExtractResFileLengtgAndMd5) {
                i = sharedPreferencesForUpdateConfig.getInt("LAST_CHECK_RES_VERSION", -1);
                sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_RES_VERSION", -1).commit();
                if (i != availableVersion) {
                    f.nI(77);
                    XWalkEnvironment.addXWalkInitializeLog("", "some res corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("", "some res corrupted");
                }
                f.nI(76);
            }
            i = SB(availableVersion);
            if (i == 0) {
                int i2 = sharedPreferencesForUpdateConfig.getInt("LAST_CHECK_VERSION", -1);
                sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", -1).commit();
                if (i2 != availableVersion) {
                    f.nI(64);
                    XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted");
                }
                f.nI(63);
            }
            if ("true".equalsIgnoreCase(com.tencent.xweb.a.iG("disable_res_check", "tools"))) {
                XWalkEnvironment.addXWalkInitializeLog("", "ignore res files check");
            } else {
                i &= checkExtractResFileLengtgAndMd5;
            }
            if (i == 0) {
                XWalkEnvironment.setAvailableVersion(-1, null);
                AppMethodBeat.o(85385);
                return;
            }
            sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", availableVersion).commit();
            Log.i("XWalkUpdaterImp", "checkfiles parse");
            AppMethodBeat.o(85385);
            return;
        }
        AppMethodBeat.o(85385);
    }

    private static boolean SB(int i) {
        AppMethodBeat.i(85386);
        File SC = SC(i);
        if (SC != null) {
            boolean checkFileListMd5 = FileListMD5Checker.checkFileListMd5(i, SC);
            AppMethodBeat.o(85386);
            return checkFileListMd5;
        } else if (XWalkEnvironment.isTestVersion(i)) {
            AppMethodBeat.o(85386);
            return true;
        } else {
            Log.e("XWalkUpdaterImp", "checkfiles no config file");
            f.nI(78);
            if ("true".equalsIgnoreCase(com.tencent.xweb.a.iG("dis_config_file_check", "tools"))) {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
                AppMethodBeat.o(85386);
                return true;
            }
            AppMethodBeat.o(85386);
            return false;
        }
    }

    private static File SC(int i) {
        AppMethodBeat.i(85387);
        try {
            File file = new File(XWalkEnvironment.getPatchFileListConfig(i));
            if (file.exists()) {
                AppMethodBeat.o(85387);
                return file;
            }
            file = new File(XWalkEnvironment.getDownloadZipFileListConfig(i));
            if (file.exists()) {
                AppMethodBeat.o(85387);
                return file;
            }
            AppMethodBeat.o(85387);
            return null;
        } catch (Exception e) {
            AppMethodBeat.o(85387);
            return null;
        }
    }

    public static boolean isBusy() {
        AppMethodBeat.i(85388);
        if (ASD == null) {
            AppMethodBeat.o(85388);
            return false;
        }
        boolean dWf = com.tencent.xweb.xwalk.b.f.dWf();
        AppMethodBeat.o(85388);
        return dWf;
    }

    public n(Context context) {
        AppMethodBeat.i(85389);
        this.mContext = context;
        this.ASE = new XWalkInitializer(this, context);
        this.ASF = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
        AppMethodBeat.o(85389);
    }

    public final boolean s(HashMap<String, String> hashMap) {
        AppMethodBeat.i(85390);
        new com.tencent.xweb.xwalk.b.f(this.ASF, hashMap).execute(new String[0]);
        AppMethodBeat.o(85390);
        return false;
    }

    public void onXWalkInitStarted() {
    }

    public void onXWalkInitCancelled() {
    }

    public void onXWalkInitFailed() {
    }

    public void onXWalkInitCompleted() {
    }

    public void onXWalkUpdateStarted() {
        AppMethodBeat.i(85391);
        com.tencent.xweb.xwalk.b.f.dWg();
        AppMethodBeat.o(85391);
    }

    public void onXWalkUpdateProgress(int i) {
        AppMethodBeat.i(85392);
        b dUo = w.dUo();
        if (dUo != null) {
            dUo.pP(i);
        }
        AppMethodBeat.o(85392);
    }

    public void onXWalkUpdateCancelled() {
        AppMethodBeat.i(85393);
        com.tencent.xweb.xwalk.b.f.dWh();
        b dUo = w.dUo();
        if (dUo != null) {
            dUo.aMA();
        }
        AppMethodBeat.o(85393);
    }

    public void onXWalkUpdateFailed(int i) {
        AppMethodBeat.i(85394);
        com.tencent.xweb.xwalk.b.f.SF(i);
        b dUo = w.dUo();
        if (dUo != null) {
            dUo.aMA();
        }
        AppMethodBeat.o(85394);
    }

    public void onXWalkUpdateCompleted() {
        AppMethodBeat.i(85395);
        com.tencent.xweb.xwalk.b.f.dWi();
        b dUo = w.dUo();
        if (dUo != null) {
            dUo.aMB();
        }
        AppMethodBeat.o(85395);
    }
}
