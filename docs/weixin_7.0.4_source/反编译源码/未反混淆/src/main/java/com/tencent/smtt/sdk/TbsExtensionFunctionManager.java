package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import java.io.File;
import java.io.IOException;

public class TbsExtensionFunctionManager {
    public static final String BUGLY_SWITCH_FILE_NAME = "bugly_switch.txt";
    public static final String COOKIE_SWITCH_FILE_NAME = "cookie_switch.txt";
    public static final String DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME = "disable_get_apk_version_switch.txt";
    public static final String DISABLE_UNPREINIT = "disable_unpreinit.txt";
    public static final String DISABLE_USE_HOST_BACKUP_CORE = "disable_use_host_backup_core.txt";
    public static final String SP_KEY_COOKIE_DB_VERSION = "cookie_db_version";
    public static final String SP_NAME_FOR_COOKIE = "cookie_compatiable";
    public static final int SWITCH_BYTE_COOKIE = 1;
    public static final int SWITCH_BYTE_DISABLE_GET_APK_VERSION = 2;
    public static final int SWITCH_BYTE_DISABLE_UNPREINIT = 4;
    public static final int SWITCH_BYTE_DISABLE_USE_HOST_BACKUPCORE = 8;
    public static final String USEX5_FILE_NAME = "usex5.txt";
    private static TbsExtensionFunctionManager b;
    private boolean a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        AppMethodBeat.i(64385);
        if (b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                try {
                    if (b == null) {
                        b = new TbsExtensionFunctionManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(64385);
                    }
                }
            }
        }
        TbsExtensionFunctionManager tbsExtensionFunctionManager = b;
        AppMethodBeat.o(64385);
        return tbsExtensionFunctionManager;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        AppMethodBeat.i(64388);
        File file = new File(context.getFilesDir(), str);
        if (file.exists() && file.isFile()) {
            z = true;
            AppMethodBeat.o(64388);
        } else {
            z = false;
            AppMethodBeat.o(64388);
        }
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.i(64389);
            SharedPreferences sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
            if (sharedPreferences == null) {
                AppMethodBeat.o(64389);
            } else {
                i = sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
                AppMethodBeat.o(64389);
            }
        }
        return i;
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        AppMethodBeat.i(64386);
        if (this.a) {
            AppMethodBeat.o(64386);
        } else if (canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            CharSequence c;
            if (TbsShareManager.isThirdPartyApp(context)) {
                c = TbsShareManager.c(context);
            } else {
                File r = an.a().r(context);
                if (r == null) {
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                }
                if (r.listFiles() == null || r.listFiles().length <= 0) {
                    TbsLog.i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    AppMethodBeat.o(64386);
                } else {
                    Object c2 = r.getAbsolutePath();
                }
            }
            if (TextUtils.isEmpty(c2)) {
                TbsLog.i("TbsExtensionFunMana", "bugly init ,corePath is null");
                AppMethodBeat.o(64386);
            } else {
                File r2 = an.a().r(context);
                if (r2 == null) {
                    TbsLog.i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    AppMethodBeat.o(64386);
                } else {
                    try {
                        String parent = new File(c2, "tbs_bugly_dex.jar").getParent();
                        String[] strArr = new String[]{r4.getAbsolutePath()};
                        String absolutePath = r2.getAbsolutePath();
                        r.a(new DexLoader(parent, context, strArr, absolutePath, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, context, c2, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                        this.a = true;
                        TbsLog.i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        AppMethodBeat.o(64386);
                    } catch (Throwable th) {
                        TbsLog.i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        AppMethodBeat.o(64386);
                    }
                }
            }
        } else {
            TbsLog.i("TbsExtensionFunMana", "bugly is forbiden!!");
            AppMethodBeat.o(64386);
        }
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(64387);
            if (context == null) {
                AppMethodBeat.o(64387);
            } else {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                AppMethodBeat.o(64387);
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:".concat(String.valueOf(str)));
                            AppMethodBeat.o(64387);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        AppMethodBeat.o(64387);
                        z2 = true;
                    } else {
                        TbsLog.e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:".concat(String.valueOf(str)));
                        AppMethodBeat.o(64387);
                    }
                }
                AppMethodBeat.o(64387);
                z2 = true;
            }
        }
        return z2;
    }
}
