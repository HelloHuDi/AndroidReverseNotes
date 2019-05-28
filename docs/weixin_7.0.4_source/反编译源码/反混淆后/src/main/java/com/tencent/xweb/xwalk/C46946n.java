package com.tencent.xweb.xwalk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.C16395k.C16394a;
import com.tencent.xweb.C16403w;
import com.tencent.xweb.C44572a;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C24523c;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C41131b;
import com.tencent.xweb.util.C6037d;
import com.tencent.xweb.xwalk.p687b.C36609f;
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

/* renamed from: com.tencent.xweb.xwalk.n */
public class C46946n implements XWalkInitListener, XWalkBackgroundUpdateListener {
    static C46946n ASD;
    XWalkInitializer ASE;
    XWalkUpdater ASF;
    protected Context mContext;

    /* renamed from: com.tencent.xweb.xwalk.n$a */
    public static class C24571a implements C16394a {
        /* renamed from: a */
        public final void mo30119a(Context context, HashMap<String, String> hashMap) {
            AppMethodBeat.m2504i(85375);
            C46946n.m89795a(context, hashMap);
            AppMethodBeat.m2505o(85375);
        }

        public final boolean isBusy() {
            AppMethodBeat.m2504i(85376);
            boolean isBusy = C46946n.isBusy();
            AppMethodBeat.m2505o(85376);
            return isBusy;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m89795a(Context context, HashMap<String, String> hashMap) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(85377);
        if (ASD == null) {
            ASD = new C46946n(context);
        }
        if (!XWalkEnvironment.isTestVersion(XWalkEnvironment.getInstalledNewstVersion())) {
            C46946n.m89799rE(false);
        }
        if (C24523c.m38149b("LOAD_CORE", C44570d.WV_KIND_CW).APn >= 6) {
            C24532f.m38181nI(252);
            if ("true".equalsIgnoreCase(C44572a.m80959iG("enable_check_dex", "tools"))) {
                z = true;
                if (z) {
                    String str = "check_need_fix_dex";
                    if ("true".equals(C44572a.ava("dis_".concat(String.valueOf(str))))) {
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
                    if (z2 && !C46946n.dVL()) {
                        C24532f.m38181nI(248);
                        XWalkEnvironment.setAvailableVersion(-1, null);
                    }
                }
                C46946n.m89791E(context, false);
                ASD.mo76256s(hashMap);
                AppMethodBeat.m2505o(85377);
            }
        }
        if (C24523c.m38149b("CREATE_WEBVIEW", C44570d.WV_KIND_CW).APn >= 6) {
            C24532f.m38181nI(247);
            if ("true".equalsIgnoreCase(C44572a.m80959iG("enable_check_dex_new_web", "tools"))) {
                z = true;
                if (z) {
                }
                C46946n.m89791E(context, false);
                ASD.mo76256s(hashMap);
                AppMethodBeat.m2505o(85377);
            }
        }
        z = false;
        if (z) {
        }
        C46946n.m89791E(context, false);
        ASD.mo76256s(hashMap);
        AppMethodBeat.m2505o(85377);
    }

    /* renamed from: E */
    public static void m89791E(Context context, boolean z) {
        AppMethodBeat.m2504i(85378);
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.m2505o(85378);
            return;
        }
        long j = sharedPreferencesForUpdateConfig.getLong("LAST_TRY_CLEAR_APK_TIME", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (z || currentTimeMillis < j || currentTimeMillis - j > 259200000) {
            try {
                C46946n.m89798jD(context);
            } catch (Exception e) {
                Log.m81046e("XWalkUpdaterImp", "tryClearOldXWebCore failed " + e.getMessage());
            }
            sharedPreferencesForUpdateConfig.edit().putLong("LAST_TRY_CLEAR_APK_TIME", currentTimeMillis).commit();
        }
        AppMethodBeat.m2505o(85378);
    }

    /* renamed from: jD */
    private static void m89798jD(Context context) {
        AppMethodBeat.m2504i(85379);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            AppMethodBeat.m2505o(85379);
            return;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(85379);
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
            int ay = C46946n.m89797ay(listFiles[i3]);
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
            i = C46946n.m89797ay(file);
            if (i > 0 && i < i2 && i != XWalkEnvironment.getAvailableVersion()) {
                try {
                    C41131b.avl(file.getAbsolutePath());
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", "cleared version = ".concat(String.valueOf(i)));
                    C24532f.m38180n(577, 65, 1);
                } catch (Exception e) {
                    XWalkEnvironment.addXWalkInitializeLog("XWalkUpdaterImp", " FileUtils.deleteAll failed " + e.getMessage());
                    C24532f.m38180n(577, 66, 1);
                }
            }
        }
        AppMethodBeat.m2505o(85379);
    }

    /* renamed from: aE */
    public static int m89796aE(Context context, int i) {
        Object obj = 1;
        AppMethodBeat.m2504i(85380);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed: bad context");
            AppMethodBeat.m2505o(85380);
            return -1;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer failed files is null");
            AppMethodBeat.m2505o(85380);
            return -1;
        }
        int ay;
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
        int length = listFiles.length;
        int i2 = 0;
        int i3 = -1;
        Object obj2 = null;
        while (i2 < length) {
            ay = C46946n.m89797ay(listFiles[i2]);
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
            if (!C46946n.m89792SA(i3)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                ay = -1;
            }
            ay = i3;
        } else if (C46946n.m89792SA(i)) {
            XWalkEnvironment.addXWalkInitializeLog("revertToApkVer checkApkExist targetApk exist");
            ay = i;
        } else {
            if (!C46946n.m89792SA(i3)) {
                XWalkEnvironment.addXWalkInitializeLog("revertToApkVer nAvailableOldVer targetApk not exist");
                ay = -1;
            }
            ay = i3;
        }
        if (ay == i) {
            C24532f.m38181nI(89);
        } else if (ay > 0) {
            C24532f.m38181nI(90);
        } else if (obj != null) {
            C24532f.m38181nI(92);
        } else {
            C24532f.m38181nI(91);
        }
        XWalkEnvironment.addXWalkInitializeLog("revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + ay);
        XWalkEnvironment.setAvailableVersion(ay, "revert from:" + XWalkEnvironment.getInstalledNewstVersion() + " to:" + ay);
        AppMethodBeat.m2505o(85380);
        return ay;
    }

    /* renamed from: SA */
    private static boolean m89792SA(int i) {
        AppMethodBeat.m2504i(85381);
        File SC = C46946n.m89794SC(i);
        if (SC == null) {
            Log.m81046e("XWalkUpdaterImp", "checkfiles no config file");
            AppMethodBeat.m2505o(85381);
            return false;
        }
        boolean checkFileListMd5 = FileListMD5Checker.checkFileListMd5(i, SC);
        AppMethodBeat.m2505o(85381);
        return checkFileListMd5;
    }

    /* renamed from: ay */
    private static int m89797ay(File file) {
        int i = -1;
        AppMethodBeat.m2504i(85382);
        if (file == null) {
            AppMethodBeat.m2505o(85382);
        } else {
            String name = file.getName();
            if (name != null && name.startsWith("app_xwalk_") && file.isDirectory()) {
                name = name.substring(10);
                try {
                    i = Integer.parseInt(name);
                    AppMethodBeat.m2505o(85382);
                } catch (Exception e) {
                    Log.m81046e("XWalkUpdaterImp", "get apk version strApkVer  is ".concat(String.valueOf(name)));
                }
            }
            AppMethodBeat.m2505o(85382);
        }
        return i;
    }

    private static boolean dVK() {
        AppMethodBeat.m2504i(85383);
        if (C41131b.avl(XWalkEnvironment.getOptimizedDexDir(XWalkEnvironment.getInstalledNewstVersion()))) {
            XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex suc");
            AppMethodBeat.m2505o(85383);
            return true;
        }
        XWalkEnvironment.addXWalkInitializeLog("tryRemoveOptDex failed");
        AppMethodBeat.m2505o(85383);
        return false;
    }

    public static boolean dVL() {
        AppMethodBeat.m2504i(85384);
        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion();
        if (installedNewstVersion <= 0) {
            AppMethodBeat.m2505o(85384);
            return false;
        }
        File SC = C46946n.m89794SC(installedNewstVersion);
        if (SC == null) {
            Log.m81046e("XWalkUpdaterImp", "doFixDex checkfiles no config file");
            AppMethodBeat.m2505o(85384);
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
            String cz = C6037d.m9501cz(extractedCoreDir);
            if (TextUtils.isEmpty(cz)) {
                cz = "";
            }
            if (!cz.equalsIgnoreCase(C6037d.m9501cz(str))) {
                C24532f.m38181nI(253);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex dex cruppted");
                if (!C41131b.avl(extractedCoreDir)) {
                    C24532f.m38181nI(250);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex delete cruppted dex failed");
                    z = false;
                } else if (C41131b.copyFile(str, extractedCoreDir)) {
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace suc");
                    z = true;
                } else {
                    C24532f.m38181nI(249);
                    XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", " doFixDex copy dex to replace failed");
                    z = false;
                }
                C46946n.dVK();
            } else if (C46946n.dVK()) {
                C24532f.m38181nI(254);
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex suc");
                z = true;
            } else {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "doFixDex try remove  opt dex failed");
                C24532f.m38181nI(255);
                z = false;
            }
            AppMethodBeat.m2505o(85384);
            return z;
        } else {
            Log.m81046e("XWalkUpdaterImp", "doFixDex checkFileListMd5 failed");
            AppMethodBeat.m2505o(85384);
            return false;
        }
    }

    /* renamed from: rE */
    public static void m89799rE(boolean z) {
        AppMethodBeat.m2504i(85385);
        int availableVersion = XWalkEnvironment.getAvailableVersion();
        if (availableVersion <= 0) {
            AppMethodBeat.m2505o(85385);
            return;
        }
        SharedPreferences sharedPreferencesForUpdateConfig = XWalkEnvironment.getSharedPreferencesForUpdateConfig();
        if (sharedPreferencesForUpdateConfig == null) {
            AppMethodBeat.m2505o(85385);
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
                    C24532f.m38181nI(77);
                    XWalkEnvironment.addXWalkInitializeLog("", "some res corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("", "some res corrupted");
                }
                C24532f.m38181nI(76);
            }
            i = C46946n.m89793SB(availableVersion);
            if (i == 0) {
                int i2 = sharedPreferencesForUpdateConfig.getInt("LAST_CHECK_VERSION", -1);
                sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", -1).commit();
                if (i2 != availableVersion) {
                    C24532f.m38181nI(64);
                    XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted at first time");
                } else {
                    XWalkEnvironment.addXWalkInitializeLog("", "some files corrupted");
                }
                C24532f.m38181nI(63);
            }
            if ("true".equalsIgnoreCase(C44572a.m80959iG("disable_res_check", "tools"))) {
                XWalkEnvironment.addXWalkInitializeLog("", "ignore res files check");
            } else {
                i &= checkExtractResFileLengtgAndMd5;
            }
            if (i == 0) {
                XWalkEnvironment.setAvailableVersion(-1, null);
                AppMethodBeat.m2505o(85385);
                return;
            }
            sharedPreferencesForUpdateConfig.edit().putInt("LAST_CHECK_VERSION", availableVersion).commit();
            Log.m81049i("XWalkUpdaterImp", "checkfiles parse");
            AppMethodBeat.m2505o(85385);
            return;
        }
        AppMethodBeat.m2505o(85385);
    }

    /* renamed from: SB */
    private static boolean m89793SB(int i) {
        AppMethodBeat.m2504i(85386);
        File SC = C46946n.m89794SC(i);
        if (SC != null) {
            boolean checkFileListMd5 = FileListMD5Checker.checkFileListMd5(i, SC);
            AppMethodBeat.m2505o(85386);
            return checkFileListMd5;
        } else if (XWalkEnvironment.isTestVersion(i)) {
            AppMethodBeat.m2505o(85386);
            return true;
        } else {
            Log.m81046e("XWalkUpdaterImp", "checkfiles no config file");
            C24532f.m38181nI(78);
            if ("true".equalsIgnoreCase(C44572a.m80959iG("dis_config_file_check", "tools"))) {
                XWalkInitializer.addXWalkInitializeLog("XWalkUpdaterImp", "dis_config_file_check ");
                AppMethodBeat.m2505o(85386);
                return true;
            }
            AppMethodBeat.m2505o(85386);
            return false;
        }
    }

    /* renamed from: SC */
    private static File m89794SC(int i) {
        AppMethodBeat.m2504i(85387);
        try {
            File file = new File(XWalkEnvironment.getPatchFileListConfig(i));
            if (file.exists()) {
                AppMethodBeat.m2505o(85387);
                return file;
            }
            file = new File(XWalkEnvironment.getDownloadZipFileListConfig(i));
            if (file.exists()) {
                AppMethodBeat.m2505o(85387);
                return file;
            }
            AppMethodBeat.m2505o(85387);
            return null;
        } catch (Exception e) {
            AppMethodBeat.m2505o(85387);
            return null;
        }
    }

    public static boolean isBusy() {
        AppMethodBeat.m2504i(85388);
        if (ASD == null) {
            AppMethodBeat.m2505o(85388);
            return false;
        }
        boolean dWf = C36609f.dWf();
        AppMethodBeat.m2505o(85388);
        return dWf;
    }

    public C46946n(Context context) {
        AppMethodBeat.m2504i(85389);
        this.mContext = context;
        this.ASE = new XWalkInitializer(this, context);
        this.ASF = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
        AppMethodBeat.m2505o(85389);
    }

    /* renamed from: s */
    public final boolean mo76256s(HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(85390);
        new C36609f(this.ASF, hashMap).execute(new String[0]);
        AppMethodBeat.m2505o(85390);
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
        AppMethodBeat.m2504i(85391);
        C36609f.dWg();
        AppMethodBeat.m2505o(85391);
    }

    public void onXWalkUpdateProgress(int i) {
        AppMethodBeat.m2504i(85392);
        C6060b dUo = C16403w.dUo();
        if (dUo != null) {
            dUo.mo13347pP(i);
        }
        AppMethodBeat.m2505o(85392);
    }

    public void onXWalkUpdateCancelled() {
        AppMethodBeat.m2504i(85393);
        C36609f.dWh();
        C6060b dUo = C16403w.dUo();
        if (dUo != null) {
            dUo.aMA();
        }
        AppMethodBeat.m2505o(85393);
    }

    public void onXWalkUpdateFailed(int i) {
        AppMethodBeat.m2504i(85394);
        C36609f.m60706SF(i);
        C6060b dUo = C16403w.dUo();
        if (dUo != null) {
            dUo.aMA();
        }
        AppMethodBeat.m2505o(85394);
    }

    public void onXWalkUpdateCompleted() {
        AppMethodBeat.m2504i(85395);
        C36609f.dWi();
        C6060b dUo = C16403w.dUo();
        if (dUo != null) {
            dUo.aMB();
        }
        AppMethodBeat.m2505o(85395);
    }
}
