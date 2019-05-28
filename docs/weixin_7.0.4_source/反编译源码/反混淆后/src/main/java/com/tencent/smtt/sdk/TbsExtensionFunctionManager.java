package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.C30951r;
import com.tencent.smtt.utils.TbsLog;
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
    /* renamed from: b */
    private static TbsExtensionFunctionManager f13843b;
    /* renamed from: a */
    private boolean f13844a;

    private TbsExtensionFunctionManager() {
    }

    public static TbsExtensionFunctionManager getInstance() {
        AppMethodBeat.m2504i(64385);
        if (f13843b == null) {
            synchronized (TbsExtensionFunctionManager.class) {
                try {
                    if (f13843b == null) {
                        f13843b = new TbsExtensionFunctionManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(64385);
                    }
                }
            }
        }
        TbsExtensionFunctionManager tbsExtensionFunctionManager = f13843b;
        AppMethodBeat.m2505o(64385);
        return tbsExtensionFunctionManager;
    }

    public synchronized boolean canUseFunction(Context context, String str) {
        boolean z;
        AppMethodBeat.m2504i(64388);
        File file = new File(context.getFilesDir(), str);
        if (file.exists() && file.isFile()) {
            z = true;
            AppMethodBeat.m2505o(64388);
        } else {
            z = false;
            AppMethodBeat.m2505o(64388);
        }
        return z;
    }

    public synchronized int getRomCookieDBVersion(Context context) {
        int i = -1;
        synchronized (this) {
            AppMethodBeat.m2504i(64389);
            SharedPreferences sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences(SP_NAME_FOR_COOKIE, 4) : context.getSharedPreferences(SP_NAME_FOR_COOKIE, 0);
            if (sharedPreferences == null) {
                AppMethodBeat.m2505o(64389);
            } else {
                i = sharedPreferences.getInt(SP_KEY_COOKIE_DB_VERSION, -1);
                AppMethodBeat.m2505o(64389);
            }
        }
        return i;
    }

    public synchronized void initTbsBuglyIfNeed(Context context) {
        AppMethodBeat.m2504i(64386);
        if (this.f13844a) {
            AppMethodBeat.m2505o(64386);
        } else if (canUseFunction(context, BUGLY_SWITCH_FILE_NAME)) {
            CharSequence c;
            if (TbsShareManager.isThirdPartyApp(context)) {
                c = TbsShareManager.m49467c(context);
            } else {
                File r = C5813an.m8800a().mo12183r(context);
                if (r == null) {
                    TbsLog.m80434i("TbsExtensionFunMana", "getTbsCoreShareDir is null");
                }
                if (r.listFiles() == null || r.listFiles().length <= 0) {
                    TbsLog.m80434i("TbsExtensionFunMana", "getTbsCoreShareDir is empty!");
                    AppMethodBeat.m2505o(64386);
                } else {
                    Object c2 = r.getAbsolutePath();
                }
            }
            if (TextUtils.isEmpty(c2)) {
                TbsLog.m80434i("TbsExtensionFunMana", "bugly init ,corePath is null");
                AppMethodBeat.m2505o(64386);
            } else {
                File r2 = C5813an.m8800a().mo12183r(context);
                if (r2 == null) {
                    TbsLog.m80434i("TbsExtensionFunMana", "bugly init ,optDir is null");
                    AppMethodBeat.m2505o(64386);
                } else {
                    try {
                        String parent = new File(c2, "tbs_bugly_dex.jar").getParent();
                        String[] strArr = new String[]{r4.getAbsolutePath()};
                        String absolutePath = r2.getAbsolutePath();
                        C30951r.m49576a(new DexLoader(parent, context, strArr, absolutePath, null).loadClass("com.tencent.smtt.tbs.bugly.TBSBuglyManager"), "initBugly", new Class[]{Context.class, String.class, String.class, String.class}, context, c2, String.valueOf(WebView.getTbsSDKVersion(context)), String.valueOf(WebView.getTbsCoreVersion(context)));
                        this.f13844a = true;
                        TbsLog.m80434i("TbsExtensionFunMana", "initTbsBuglyIfNeed success!");
                        AppMethodBeat.m2505o(64386);
                    } catch (Throwable th) {
                        TbsLog.m80434i("TbsExtensionFunMana", "bugly init ,try init bugly failed(need new core):" + Log.getStackTraceString(th));
                        AppMethodBeat.m2505o(64386);
                    }
                }
            }
        } else {
            TbsLog.m80434i("TbsExtensionFunMana", "bugly is forbiden!!");
            AppMethodBeat.m2505o(64386);
        }
    }

    public synchronized boolean setFunctionEnable(Context context, String str, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(64387);
            if (context == null) {
                AppMethodBeat.m2505o(64387);
            } else {
                File file = new File(context.getFilesDir(), str);
                if (z) {
                    if (!file.exists()) {
                        try {
                            if (file.createNewFile()) {
                                AppMethodBeat.m2505o(64387);
                                z2 = true;
                            }
                        } catch (IOException e) {
                            TbsLog.m80432e("TbsExtensionFunMana", "setFunctionEnable,createNewFile fail:".concat(String.valueOf(str)));
                            AppMethodBeat.m2505o(64387);
                        }
                    }
                } else if (file.exists()) {
                    if (file.delete()) {
                        AppMethodBeat.m2505o(64387);
                        z2 = true;
                    } else {
                        TbsLog.m80432e("TbsExtensionFunMana", "setFunctionEnable,file.delete fail:".concat(String.valueOf(str)));
                        AppMethodBeat.m2505o(64387);
                    }
                }
                AppMethodBeat.m2505o(64387);
                z2 = true;
            }
        }
        return z2;
    }
}
