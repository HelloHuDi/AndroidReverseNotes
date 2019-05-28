package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.r;
import com.tencent.smtt.utils.t;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.xwalk.core.XWalkUpdater;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static String A = null;
    private static boolean B = false;
    private static boolean C = true;
    private static TbsListener D = null;
    private static TbsListener E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    private static boolean F = false;
    private static boolean G = false;
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean a = false;
    static boolean b = false;
    static boolean c = true;
    static String d;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static Object h = new Object();
    static boolean i = true;
    static boolean j = true;
    static boolean k = false;
    static volatile boolean l = a;
    static TbsListener m = new n();
    public static boolean mDisableUseHostBackupCore = false;
    static Map<String, Object> n = null;
    private static int o = 0;
    private static String p = "";
    private static Class<?> q = null;
    private static Object r = null;
    private static boolean s = false;
    public static boolean sIsVersionPrinted = false;
    private static String[] t;
    private static String u = "NULL";
    private static String v = "UNKNOWN";
    private static boolean w = false;
    private static int x = 0;
    private static int y = ErrorCode.NEEDDOWNLOAD_TRUE;
    private static String z = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static {
        AppMethodBeat.i(64056);
        AppMethodBeat.o(64056);
    }

    static Bundle a(Context context, Bundle bundle) {
        AppMethodBeat.i(64004);
        if (a(context)) {
            Object a = r.a(r, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                Bundle bundle2 = (Bundle) a;
                AppMethodBeat.o(64004);
                return bundle2;
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(216, "incrUpdate return null!");
            AppMethodBeat.o(64004);
            return null;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(216, "initForPatch return false!");
        AppMethodBeat.o(64004);
        return null;
    }

    static Object a(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(64052);
        if (a(context)) {
            Object a = r.a(r, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
            if (a != null) {
                AppMethodBeat.o(64052);
                return a;
            }
            AppMethodBeat.o(64052);
            return null;
        }
        Integer valueOf = Integer.valueOf(EXTENSION_INIT_FAILURE);
        AppMethodBeat.o(64052);
        return valueOf;
    }

    static String a() {
        return p;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(64018);
            if (a) {
                AppMethodBeat.o(64018);
            } else {
                a = true;
                v = "forceSysWebViewInner: ".concat(String.valueOf(str));
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + v);
                TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(v));
                AppMethodBeat.o(64018);
            }
        }
    }

    static boolean a(Context context) {
        AppMethodBeat.i(64001);
        try {
            if (q != null) {
                AppMethodBeat.o(64001);
                return true;
            }
            File r = an.a().r(context);
            if (r == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                AppMethodBeat.o(64001);
                return false;
            }
            File file = new File(r, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                TbsLog.i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
                bv.a().a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, r.getAbsolutePath(), null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                loadTBSSDKExtension(context, file.getParent());
                AppMethodBeat.o(64001);
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            AppMethodBeat.o(64001);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(64001);
            return false;
        }
    }

    static boolean a(Context context, int i) {
        AppMethodBeat.i(64005);
        boolean a = a(context, i, (int) i.sHCENCODEVIDEOTIMEOUT);
        AppMethodBeat.o(64005);
        return a;
    }

    static boolean a(Context context, int i, int i2) {
        AppMethodBeat.i(64006);
        if (n != null && n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.o(64006);
            return true;
        } else if (c(context)) {
            Object a = r.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43644), Integer.valueOf(i2));
            boolean booleanValue;
            if (a != null) {
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(64006);
                return booleanValue;
            }
            a = r.a(r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43644));
            if (a != null) {
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(64006);
                return booleanValue;
            }
            AppMethodBeat.o(64006);
            return true;
        } else {
            AppMethodBeat.o(64006);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z) {
        AppMethodBeat.i(63997);
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43644; SDK_VERSION_NAME: 4.3.0.1057");
            sIsVersionPrinted = true;
        }
        if (a && !z) {
            TbsLog.e("QbSdk", "QbSdk init: " + v, false);
            TbsCoreLoadStat.getInstance().a(context, 414, new Throwable(v));
            AppMethodBeat.o(63997);
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(u));
            AppMethodBeat.o(63997);
            return false;
        } else {
            if (!C) {
                d(context);
            }
            try {
                File r = an.a().r(context);
                if (r == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    AppMethodBeat.o(63997);
                    return false;
                }
                int a;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    if (o != 0) {
                        a = an.a().a(true, context);
                        if (o != a) {
                            q = null;
                            r = null;
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=".concat(String.valueOf(a)), true);
                            TbsLog.e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + o, true);
                            TbsCoreLoadStat.getInstance().a(context, 303, new Throwable("sTbsVersion: " + o + "; tbsCoreInstalledVer: " + a));
                            AppMethodBeat.o(63997);
                            return false;
                        }
                    }
                    a = 0;
                    o = a;
                } else if (o == 0 || o == TbsShareManager.d(context)) {
                    o = TbsShareManager.d(context);
                } else {
                    q = null;
                    r = null;
                    TbsLog.e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    TbsCoreLoadStat.getInstance().a(context, 302, new Throwable("sTbsVersion: " + o + "; AvailableTbsCoreVersion: " + TbsShareManager.d(context)));
                    AppMethodBeat.o(63997);
                    return false;
                }
                if (q != null) {
                    AppMethodBeat.o(63997);
                    return true;
                }
                File file;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(an.a().r(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.j(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    AppMethodBeat.o(63997);
                    return false;
                }
                if (file.exists()) {
                    Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #1 is ".concat(String.valueOf(hostCorePathAppDefined)));
                    TbsLog.i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                    bv.a().a(context);
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    loadTBSSDKExtension(context, file.getParent());
                    r.a(r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                    r.a(r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    AppMethodBeat.o(63997);
                    return true;
                }
                try {
                    TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    a = an.a().j(context);
                    if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (a > 0) {
                            TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(a))));
                        } else {
                            TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(a))));
                        }
                    } else if (a > 0) {
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(a))));
                    } else {
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(a))));
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.o(63997);
                return false;
            } catch (Throwable th2) {
                TbsLog.e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
                TbsCoreLoadStat.getInstance().a(context, 306, th2);
                AppMethodBeat.o(63997);
                return false;
            }
        }
    }

    static boolean a(Context context, boolean z, boolean z2) {
        int i = 1;
        boolean z3 = false;
        AppMethodBeat.i(64014);
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        if (disabledCoreVersion != 0 && disabledCoreVersion == an.a().j(context)) {
            TbsLog.e("QbSdk", "force use sys by remote switch");
            AppMethodBeat.o(64014);
        } else if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.i(context)) {
            TbsCoreLoadStat.getInstance().a(context, 302);
            AppMethodBeat.o(64014);
        } else if (a(context, z)) {
            Object a = r.a(r, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43644));
            boolean a2;
            if (a == null) {
                a = r.a(r, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
                if (a == null) {
                    TbsCoreLoadStat.getInstance().a(context, 308);
                } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                    AppMethodBeat.o(64014);
                } else if (a instanceof Boolean) {
                    o = o.d();
                    a2 = a(context, o.d());
                    if (((Boolean) a).booleanValue() && !a2) {
                        z3 = true;
                    }
                    if (!z3) {
                        TbsLog.e(TbsListener.tag_load_error, "318");
                        TbsLog.w(TbsListener.tag_load_error, "isX5Disable:".concat(String.valueOf(a2)));
                        TbsLog.w(TbsListener.tag_load_error, "(Boolean) ret:" + ((Boolean) a));
                    }
                    AppMethodBeat.o(64014);
                }
            } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                AppMethodBeat.o(64014);
            } else if (a instanceof Bundle) {
                Bundle bundle = (Bundle) a;
                if (bundle.isEmpty()) {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable(String.valueOf(a)));
                    TbsLog.e(TbsListener.tag_load_error, "empty bundle");
                    AppMethodBeat.o(64014);
                } else {
                    int i2;
                    try {
                        i2 = bundle.getInt("result_code", -1);
                    } catch (Exception e) {
                        TbsLog.e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                        i2 = -1;
                    }
                    a2 = i2 == 0;
                    String valueOf;
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        o.a(TbsShareManager.d(context));
                        valueOf = String.valueOf(TbsShareManager.d(context));
                        p = valueOf;
                        if (valueOf.length() == 5) {
                            p = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(p).toString();
                        }
                        if (p.length() != 6) {
                            p = "";
                        }
                    } else {
                        try {
                            if (VERSION.SDK_INT >= 12) {
                                p = bundle.getString("tbs_core_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                p = valueOf;
                                if (valueOf == null) {
                                    p = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                            }
                        } catch (Exception e2) {
                            p = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        try {
                            o = Integer.parseInt(p);
                        } catch (NumberFormatException e3) {
                            o = 0;
                        }
                        o.a(o);
                        if (o == 0) {
                            TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sTbsVersion is 0"));
                            AppMethodBeat.o(64014);
                        } else {
                            if ((o <= 0 || o > 25442) && o != 25472) {
                                i = 0;
                            }
                            if (i != 0) {
                                TbsLog.e(TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + o);
                                k.b(an.a().r(context));
                                TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("is_obsolete --> delete old core:" + o));
                                AppMethodBeat.o(64014);
                            }
                        }
                    }
                    try {
                        t = bundle.getStringArray("tbs_jarfiles");
                        if (t instanceof String[]) {
                            try {
                                d = bundle.getString("tbs_librarypath");
                                a = null;
                                if (i2 != 0) {
                                    try {
                                        a = r.a(r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e4) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().a(context, 404, new Throwable("detail: ".concat(String.valueOf(a))));
                                            z3 = a2;
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: ".concat(String.valueOf(a))));
                                        z3 = a2;
                                        break;
                                    case -1:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("detail: ".concat(String.valueOf(a))));
                                            z3 = a2;
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().a(context, ((Integer) a).intValue(), new Throwable("detail: ".concat(String.valueOf(a))));
                                        z3 = a2;
                                        break;
                                    case 0:
                                        z3 = a2;
                                        break;
                                    default:
                                        TbsCoreLoadStat.getInstance().a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                        z3 = a2;
                                        break;
                                }
                            } catch (Exception e5) {
                                AppMethodBeat.o(64014);
                            }
                        } else {
                            TbsCoreLoadStat.getInstance().a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + t));
                            AppMethodBeat.o(64014);
                        }
                    } catch (Throwable th) {
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                        AppMethodBeat.o(64014);
                    }
                }
            } else {
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable(String.valueOf(a)));
                TbsLog.e(TbsListener.tag_load_error, "ret not instance of bundle");
                AppMethodBeat.o(64014);
            }
            if (!z3) {
                TbsLog.e(TbsListener.tag_load_error, "319");
            }
            AppMethodBeat.o(64014);
        } else {
            TbsLog.e("QbSdk", "QbSdk.init failure!");
            AppMethodBeat.o(64014);
        }
        return z3;
    }

    protected static String b() {
        AppMethodBeat.i(64053);
        bv a = bv.a();
        if (a != null && a.b()) {
            Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                String str = (String) invokeStaticMethod;
                AppMethodBeat.o(64053);
                return str;
            }
        }
        AppMethodBeat.o(64053);
        return null;
    }

    static boolean b(Context context) {
        AppMethodBeat.i(64003);
        if (context == null) {
            AppMethodBeat.o(64003);
            return false;
        }
        try {
            if (context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                TbsLog.i("QbSdk", "clearPluginConfigFile #1");
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
                String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
                TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
                if (!(string == null || string.contains(str))) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("plugin_setting", 0);
                    if (sharedPreferences != null) {
                        Editor edit = sharedPreferences.edit();
                        edit.clear();
                        edit.commit();
                        TbsLog.i("QbSdk", "clearPluginConfigFile done");
                    }
                }
            }
            AppMethodBeat.o(64003);
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            AppMethodBeat.o(64003);
            return false;
        }
    }

    private static boolean c(Context context) {
        AppMethodBeat.i(64002);
        try {
            if (q != null) {
                AppMethodBeat.o(64002);
                return true;
            }
            File r = an.a().r(context);
            if (r == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                AppMethodBeat.o(64002);
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(an.a().r(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.j(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().a(context, 304);
                AppMethodBeat.o(64002);
                return false;
            }
            if (file.exists()) {
                Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                TbsLog.i("QbSdk", "QbSdk init optDirExtension #3 is ".concat(String.valueOf(hostCorePathAppDefined)));
                TbsLog.i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
                bv.a().a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                loadTBSSDKExtension(context, file.getParent());
                r.a(r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, b.a, b.b, b.c, b.d);
                r.a(r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                AppMethodBeat.o(64002);
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
            AppMethodBeat.o(64002);
            return false;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(64002);
            return false;
        }
    }

    public static boolean canLoadVideo(Context context) {
        AppMethodBeat.i(64013);
        Object a = r.a(r, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            TbsCoreLoadStat.getInstance().a(context, 314);
        } else if (!((Boolean) a).booleanValue()) {
            TbsCoreLoadStat.getInstance().a(context, 313);
        }
        if (a == null) {
            AppMethodBeat.o(64013);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.o(64013);
        return booleanValue;
    }

    public static boolean canLoadX5(Context context) {
        AppMethodBeat.i(64007);
        boolean a = a(context, false, false);
        AppMethodBeat.o(64007);
        return a;
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        AppMethodBeat.i(64000);
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && VERSION.SDK_INT == 19) {
                AppMethodBeat.o(64000);
                return true;
            }
            if (q == null) {
                File r = an.a().r(context);
                if (r == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    AppMethodBeat.o(64000);
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                    TbsLog.i("QbSdk", "QbSdk init optDirExtension #2 is ".concat(String.valueOf(hostCorePathAppDefined)));
                    TbsLog.i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                    bv.a().a(context);
                    q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    if (r == null) {
                        if (TbsShareManager.e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                            TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                            AppMethodBeat.o(64000);
                            return false;
                        }
                        loadTBSSDKExtension(context, file.getParent());
                    }
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    AppMethodBeat.o(64000);
                    return false;
                }
            }
            Object a = r.a(r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            if (a == null || !(a instanceof Boolean)) {
                AppMethodBeat.o(64000);
                return false;
            }
            boolean booleanValue = ((Boolean) a).booleanValue();
            AppMethodBeat.o(64000);
            return booleanValue;
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.o(64000);
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(64021);
        new h(context, str, valueCallback).start();
        AppMethodBeat.o(64021);
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        AppMethodBeat.i(64015);
        if (a(context, false)) {
            AppMethodBeat.o(64015);
        } else {
            AppMethodBeat.o(64015);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:76:0x0157 A:{SYNTHETIC, Splitter:B:76:0x0157} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103 A:{SYNTHETIC, Splitter:B:46:0x0103} */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0157 A:{SYNTHETIC, Splitter:B:76:0x0157} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean canOpenWebPlus(Context context) {
        boolean z;
        Throwable th;
        Throwable th2;
        BufferedInputStream bufferedInputStream;
        InputStream inputStream = null;
        AppMethodBeat.i(64008);
        if (x == 0) {
            x = a.a();
        }
        TbsLog.i("QbSdk", "canOpenWebPlus - totalRAM: " + x);
        if (VERSION.SDK_INT < 7 || x < y) {
            AppMethodBeat.o(64008);
            return false;
        } else if (context == null) {
            AppMethodBeat.o(64008);
            return false;
        } else {
            BufferedInputStream bufferedInputStream2;
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(an.a().r(context), "tbs.conf")));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("android_sdk_max_supported");
                    String property2 = properties.getProperty("android_sdk_min_supported");
                    int parseInt = Integer.parseInt(property);
                    int parseInt2 = Integer.parseInt(property2);
                    int parseInt3 = Integer.parseInt(VERSION.SDK);
                    if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                        TbsLog.i("QbSdk", "canOpenWebPlus - sdkVersion: ".concat(String.valueOf(parseInt3)));
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                        AppMethodBeat.o(64008);
                        return false;
                    }
                    parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                    }
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(new File(an.t(context), "tbs_extension.conf"));
                        try {
                            Properties properties2 = new Properties();
                            properties2.load(fileInputStream);
                            int parseInt4 = Integer.parseInt(properties2.getProperty("tbs_local_version"));
                            parseInt2 = Integer.parseInt(properties2.getProperty(TbsConfigKey.KEY_APP_VERSIONCODE_FOR_SWITCH));
                            if (parseInt == 88888888 || parseInt4 == 88888888) {
                                z = false;
                            } else if (parseInt > parseInt4) {
                                z = false;
                            } else if (parseInt == parseInt4) {
                                if (parseInt2 > 0) {
                                    if (parseInt2 != b.b(context)) {
                                        z = false;
                                    }
                                }
                                z = Boolean.parseBoolean(properties2.getProperty("x5_disabled")) && !TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getBoolean(TbsConfigKey.KEY_SWITCH_BACKUPCORE_ENABLE, false);
                            } else {
                                z = false;
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception e3) {
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            AppMethodBeat.o(64008);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(64008);
                        throw th;
                    }
                    if (z) {
                        AppMethodBeat.o(64008);
                        return true;
                    }
                    AppMethodBeat.o(64008);
                    return false;
                } catch (Throwable th5) {
                }
            } catch (Throwable th6) {
                th2 = th6;
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e5) {
                    }
                }
                AppMethodBeat.o(64008);
                throw th2;
            }
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        AppMethodBeat.i(64012);
        Object a = r.a(r, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        if (a == null || !(a instanceof Boolean)) {
            AppMethodBeat.o(64012);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.o(64012);
        return booleanValue;
    }

    public static void checkTbsValidity(Context context) {
        AppMethodBeat.i(64029);
        if (context == null) {
            AppMethodBeat.o(64029);
            return;
        }
        if (!t.a(context)) {
            TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().a(context, 419);
            forceSysWebView();
        }
        AppMethodBeat.o(64029);
    }

    public static void clear(Context context) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c A:{SYNTHETIC, Splitter:B:15:0x007c} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clearAllWebViewCache(Context context, boolean z) {
        Throwable th;
        Object obj;
        Object obj2 = 1;
        AppMethodBeat.i(64043);
        TbsLog.i("QbSdk", "clearAllWebViewCache(" + context + ", " + z + ")");
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    bv a = bv.a();
                    if (a != null && a.b()) {
                        a.c().a(context, z);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    int obj3 = 1;
                    TbsLog.e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
                    obj2 = obj3;
                    if (obj2 == null) {
                    }
                }
            } else {
                obj2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            obj3 = null;
        }
        if (obj2 == null) {
            TbsLog.i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            AppMethodBeat.o(64043);
            return;
        }
        try {
            WebView webView = new WebView(context);
            if (VERSION.SDK_INT >= 11) {
                webView.removeJavascriptInterface("searchBoxJavaBridge_");
                webView.removeJavascriptInterface("accessibility");
                webView.removeJavascriptInterface("accessibilityTraversal");
            }
            webView.clearCache(true);
            if (z) {
                CookieSyncManager.createInstance(context);
                CookieManager.getInstance().removeAllCookie();
            }
            WebViewDatabase.getInstance(context).clearUsernamePassword();
            WebViewDatabase.getInstance(context).clearHttpAuthUsernamePassword();
            WebViewDatabase.getInstance(context).clearFormData();
            WebStorage.getInstance().deleteAllData();
            WebIconDatabase.getInstance().removeAllIcons();
            AppMethodBeat.o(64043);
        } catch (Throwable th32) {
            TbsLog.e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th32));
            AppMethodBeat.o(64043);
        }
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.i(64022);
        bv a = bv.a();
        a.a(context, null);
        if (a.b()) {
            a.c().p();
        }
        AppMethodBeat.o(64022);
    }

    public static void continueLoadSo(Context context) {
        AppMethodBeat.i(64035);
        if ("com.tencent.mm".equals(getCurrentProcessName(context)) && WebView.mWebViewCreated) {
            r.a(r, "continueLoadSo", new Class[0], new Object[0]);
        }
        AppMethodBeat.o(64035);
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        AppMethodBeat.i(64047);
        if (context == null) {
            AppMethodBeat.o(64047);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(64047);
            return false;
        } else if (isMiniQBShortCutExist(context, str, str2)) {
            AppMethodBeat.o(64047);
            return false;
        } else {
            bv a = bv.a();
            if (a == null || !a.b()) {
                AppMethodBeat.o(64047);
                return false;
            }
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            DexLoader b = a.c().b();
            TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.e("QbSdk", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(invokeStaticMethod)));
            if (invokeStaticMethod != null) {
                AppMethodBeat.o(64047);
                return true;
            }
            AppMethodBeat.o(64047);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{SYNTHETIC, Splitter:B:24:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{SYNTHETIC, Splitter:B:24:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void d(Context context) {
        Throwable th;
        int i = -1;
        AppMethodBeat.i(64032);
        C = true;
        SharedPreferences sharedPreferences = null;
        int i2;
        int i3;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            int i4 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i4 >= 0) {
                i2 = i4 + 1;
                if (i2 > 4) {
                    AppMethodBeat.o(64032);
                    return;
                } else {
                    i4 = i2;
                    i3 = i2;
                }
            } else {
                i3 = -1;
            }
            try {
                i2 = an.a().j(context);
                if (i2 <= 0) {
                    AppMethodBeat.o(64032);
                    return;
                }
                if (i4 <= 4) {
                    try {
                        sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i4).commit();
                    } catch (Throwable th2) {
                        th = th2;
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
                        i4 = -1;
                        if (i4 > 3) {
                        }
                    }
                }
                i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                if (i4 >= 0) {
                    i4++;
                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4).commit();
                    if (i4 > 3) {
                        try {
                            i4 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            Editor edit = sharedPreferences.edit();
                            if (i4 == i2) {
                                k.a(an.a().r(context), false);
                                File a = ai.a(context).a();
                                if (a != null) {
                                    k.a(a, false);
                                }
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                            } else {
                                TbsLog.e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i4);
                            }
                            edit.putInt("tbs_precheck_disable_version", i4);
                            edit.commit();
                            AppMethodBeat.o(64032);
                            return;
                        } catch (Throwable th3) {
                            TbsLog.e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                            AppMethodBeat.o(64032);
                            return;
                        }
                    }
                    if (i3 > 0 && i3 <= 3) {
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        bv.a().a(context, null);
                        TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i = 0;
                    }
                    try {
                        i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i4 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                        }
                    } catch (Throwable th32) {
                        TbsLog.e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                    }
                    TbsLog.i("QbSdk", "QbSdk -- preload_x5_check result:".concat(String.valueOf(i)));
                    AppMethodBeat.o(64032);
                    return;
                }
                i4 = -1;
                if (i4 > 3) {
                }
            } catch (Throwable th4) {
                th32 = th4;
                i2 = -1;
            }
        } catch (Throwable th5) {
            th32 = th5;
            i3 = -1;
            i2 = -1;
        }
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        AppMethodBeat.i(64049);
        if (context == null) {
            AppMethodBeat.o(64049);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(64049);
            return false;
        } else {
            bv a = bv.a();
            if (a == null || !a.b()) {
                AppMethodBeat.o(64049);
                return false;
            }
            if (a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null) {
                AppMethodBeat.o(64049);
                return true;
            }
            AppMethodBeat.o(64049);
            return false;
        }
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void disableAutoCreateX5Webview() {
        j = false;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(64054);
        bv a = bv.a();
        if (a != null && a.b()) {
            try {
                a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
                AppMethodBeat.o(64054);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(64054);
    }

    public static void forceSysWebView() {
        AppMethodBeat.i(64019);
        b = true;
        u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
        AppMethodBeat.o(64019);
    }

    public static long getApkFileSize(Context context) {
        AppMethodBeat.i(64039);
        if (context != null) {
            long j = TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            AppMethodBeat.o(64039);
            return j;
        }
        AppMethodBeat.o(64039);
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        AppMethodBeat.i(64026);
        String str;
        try {
            int myPid = Process.myPid();
            str = "";
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                str = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str;
            }
            AppMethodBeat.o(64026);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.o(64026);
            return str;
        }
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        AppMethodBeat.i(64037);
        String[] strArr;
        if (t instanceof String[]) {
            int length = t.length;
            strArr = new String[length];
            while (i < length) {
                strArr[i] = str + t[i];
                i++;
            }
            AppMethodBeat.o(64037);
            return strArr;
        }
        Object a = r.a(r, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        strArr = (String[]) a;
        AppMethodBeat.o(64037);
        return strArr;
    }

    public static boolean getDownloadWithoutWifi() {
        return F;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        AppMethodBeat.i(64036);
        if (r == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            AppMethodBeat.o(64036);
            return false;
        }
        Bundle bundle = (Bundle) r.a(r, "canLoadX5CoreAndNotLoadSo", new Class[]{Integer.TYPE}, Integer.valueOf(43644));
        if (bundle == null) {
            TbsLog.i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + an.a().a(true, context));
            AppMethodBeat.o(64036);
            return false;
        }
        t = bundle.getStringArray("tbs_jarfiles");
        d = bundle.getString("tbs_librarypath");
        AppMethodBeat.o(64036);
        return true;
    }

    public static String getMiniQBVersion(Context context) {
        AppMethodBeat.i(64046);
        bv a = bv.a();
        a.a(context, null);
        if (a == null || !a.b()) {
            AppMethodBeat.o(64046);
            return null;
        }
        String f = a.c().f();
        AppMethodBeat.o(64046);
        return f;
    }

    public static boolean getOnlyDownload() {
        return k;
    }

    public static String getQQBuildNumber() {
        return A;
    }

    public static Map<String, Object> getSettings() {
        return n;
    }

    public static boolean getTBSInstalling() {
        return G;
    }

    public static String getTID() {
        return z;
    }

    public static String getTbsResourcesPath(Context context) {
        AppMethodBeat.i(64017);
        String g = TbsShareManager.g(context);
        AppMethodBeat.o(64017);
        return g;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.i(64033);
        int a;
        if (TbsShareManager.isThirdPartyApp(context)) {
            a = TbsShareManager.a(context, false);
            AppMethodBeat.o(64033);
            return a;
        }
        a = an.a().j(context);
        if (a == 0 && ai.a(context).c() == 3) {
            reset(context);
        }
        AppMethodBeat.o(64033);
        return a;
    }

    public static int getTbsVersionForCrash(Context context) {
        AppMethodBeat.i(64034);
        int a;
        if (TbsShareManager.isThirdPartyApp(context)) {
            a = TbsShareManager.a(context, false);
            AppMethodBeat.o(64034);
            return a;
        }
        a = an.a().k(context);
        if (a == 0 && ai.a(context).c() == 3) {
            reset(context);
        }
        AppMethodBeat.o(64034);
        return a;
    }

    public static void initBuglyAsync(boolean z) {
        i = z;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        AppMethodBeat.i(63999);
        if (q == null) {
            File r = an.a().r(context);
            if (r == null) {
                AppMethodBeat.o(63999);
                return;
            }
            File file = new File(r, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                String absolutePath = r.getAbsolutePath();
                bv.a().a(context);
                q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            } else {
                AppMethodBeat.o(63999);
                return;
            }
        }
        AppMethodBeat.o(63999);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(64051);
        if (n == null) {
            n = map;
            AppMethodBeat.o(64051);
            return;
        }
        try {
            n.putAll(map);
            AppMethodBeat.o(64051);
        } catch (Exception e) {
            AppMethodBeat.o(64051);
        }
    }

    public static void initX5Environment(Context context, PreInitCallback preInitCallback) {
        AppMethodBeat.i(64031);
        if (context == null) {
            AppMethodBeat.o(64031);
            return;
        }
        b(context);
        E = new l(context, preInitCallback);
        if (TbsShareManager.isThirdPartyApp(context)) {
            an.a().b(context, true);
        }
        TbsDownloader.needDownload(context, false, false, new m(context, preInitCallback));
        AppMethodBeat.o(64031);
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(64011);
        o a = o.a(true);
        a.a(context, false, false, null);
        if (a == null || !a.b()) {
            AppMethodBeat.o(64011);
            return false;
        }
        boolean a2 = a.a().a(context, str, str2, bundle);
        AppMethodBeat.o(64011);
        return a2;
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        AppMethodBeat.i(64050);
        if (webView == null) {
            AppMethodBeat.o(64050);
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            String substring = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (d.a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                bv a = bv.a();
                if (a != null && a.b() && a.c().a(context, substring, null, str2, null) == 0) {
                    AppMethodBeat.o(64050);
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        AppMethodBeat.o(64050);
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        AppMethodBeat.i(64048);
        if (context == null) {
            AppMethodBeat.o(64048);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(64048);
            return false;
        } else {
            bv a = bv.a();
            if (a == null || !a.b()) {
                AppMethodBeat.o(64048);
                return false;
            }
            Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
            if (invokeStaticMethod != null) {
                boolean booleanValue = (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.FALSE).booleanValue();
                AppMethodBeat.o(64048);
                return booleanValue;
            }
            AppMethodBeat.o(64048);
            return false;
        }
    }

    public static boolean isNeedInitX5FirstTime() {
        return w;
    }

    public static boolean isTbsCoreInited() {
        AppMethodBeat.i(64030);
        o a = o.a(false);
        if (a == null || !a.g()) {
            AppMethodBeat.o(64030);
            return false;
        }
        AppMethodBeat.o(64030);
        return true;
    }

    public static boolean isX5DisabledSync(Context context) {
        int i;
        AppMethodBeat.i(64009);
        if (ai.a(context).c() == 2) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            AppMethodBeat.o(64009);
            return false;
        } else if (c(context)) {
            i2 = an.a().j(context);
            Object a = r.a(r, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(43644));
            if (a != null) {
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.o(64009);
                return booleanValue;
            }
            AppMethodBeat.o(64009);
            return true;
        } else {
            AppMethodBeat.o(64009);
            return true;
        }
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Object obj = 1;
        Object obj2 = null;
        AppMethodBeat.i(63998);
        if (r != null) {
            AppMethodBeat.o(63998);
            return;
        }
        if (q == null) {
            TbsLog.i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
        }
        Constructor constructor = null;
        try {
            constructor = q.getConstructor(new Class[]{Context.class, Context.class, String.class, String.class, String.class});
        } catch (Throwable th) {
            obj = obj2;
        }
        try {
            if (TbsShareManager.isThirdPartyApp(context)) {
                Context e = TbsShareManager.e(context);
                if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                    TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                    AppMethodBeat.o(63998);
                } else if (obj != null) {
                    r = constructor.newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined(), str, null});
                    AppMethodBeat.o(63998);
                } else if (e == null) {
                    r = q.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()});
                    AppMethodBeat.o(63998);
                } else {
                    r = q.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, e});
                    AppMethodBeat.o(63998);
                }
            } else if (obj == null) {
                Constructor constructor2 = q.getConstructor(new Class[]{Context.class, Context.class});
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                r = constructor2.newInstance(new Object[]{context, context});
                AppMethodBeat.o(63998);
            } else {
                String str2 = null;
                if ("com.tencent.mm".equals(getCurrentProcessName(context)) && !WebView.mWebViewCreated) {
                    str2 = "notLoadSo";
                }
                r = constructor.newInstance(new Object[]{context, context, null, str, str2});
                AppMethodBeat.o(63998);
            }
        } catch (Throwable th2) {
            AppMethodBeat.o(63998);
        }
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(64023);
            preInit(context, null);
            AppMethodBeat.o(64023);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(64027);
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            l = a;
            if (!s) {
                k kVar = new k(context, new j(Looper.getMainLooper(), preInitCallback, context));
                kVar.setName("tbs_preinit");
                kVar.setPriority(10);
                kVar.start();
                s = true;
            }
            AppMethodBeat.o(64027);
        }
    }

    public static void reset(Context context) {
        AppMethodBeat.i(64040);
        reset(context, false);
        AppMethodBeat.o(64040);
    }

    /* JADX WARNING: Missing block: B:8:0x0031, code skipped:
            if (r2 != r3) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(Context context, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(64041);
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            if (z && !TbsShareManager.isThirdPartyApp(context)) {
                int i = an.a().i(context);
                int j = an.a().j(context);
                if (i > 43300) {
                }
            }
            z2 = false;
            TbsDownloader.b(context);
            k.a(context.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            an.a.set(Integer.valueOf(0));
            File file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
            if (z2) {
                k.b(an.a().q(context), an.a().u(context));
                an.a().b(context);
            }
            AppMethodBeat.o(64041);
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
            AppMethodBeat.o(64041);
        }
    }

    public static void resetDecoupleCore(Context context) {
        AppMethodBeat.i(64042);
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            k.b(an.a().q(context));
            AppMethodBeat.o(64042);
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
            AppMethodBeat.o(64042);
        }
    }

    public static void setCurrentID(String str) {
        AppMethodBeat.i(64016);
        if (str == null) {
            AppMethodBeat.o(64016);
            return;
        }
        if (str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            z = "0000000000000000".substring(substring.length()) + substring;
        }
        AppMethodBeat.o(64016);
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        b.a = str;
        b.b = str2;
        b.c = str3;
        b.d = str4;
    }

    public static void setDisableUnpreinitBySwitch(boolean z) {
        AppMethodBeat.i(64025);
        B = z;
        TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + B);
        AppMethodBeat.o(64025);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z) {
        AppMethodBeat.i(64024);
        mDisableUseHostBackupCore = z;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
        AppMethodBeat.o(64024);
    }

    public static void setDownloadWithoutWifi(boolean z) {
        F = z;
    }

    public static void setNeedInitX5FirstTime(boolean z) {
        w = z;
    }

    public static void setOnlyDownload(boolean z) {
        k = z;
    }

    public static void setQQBuildNumber(String str) {
        A = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        G = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        D = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.i(64010);
        TbsLog.setTbsLogClient(tbsLogClient);
        AppMethodBeat.o(64010);
    }

    public static void setUploadCode(Context context, int i) {
        AppMethodBeat.i(64028);
        TbsDownloadUpload instance;
        if (i < 130 || i > a.CTRL_INDEX) {
            if (i >= 150 && i <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                instance = TbsDownloadUpload.getInstance(context);
                instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(i));
                instance.commit();
            }
            AppMethodBeat.o(64028);
            return;
        }
        instance = TbsDownloadUpload.getInstance(context);
        instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(i));
        instance.commit();
        AppMethodBeat.o(64028);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(64044);
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            AppMethodBeat.o(64044);
            return -100;
        }
        bv a = bv.a();
        a.a(context, null);
        if (!a.b()) {
            TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            AppMethodBeat.o(64044);
            return ZipJNI.UNZ_PARAMERROR;
        } else if (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) {
            int a2 = a.c().a(context, str, hashMap, null, valueCallback);
            if (a2 == 0) {
                TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            } else {
                TbsLogReport.getInstance(context).setLoadErrorCode(504, String.valueOf(a2));
            }
            AppMethodBeat.o(64044);
            return a2;
        } else {
            AppMethodBeat.o(64044);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        AppMethodBeat.i(63996);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        boolean a = d.a(context, str, i2, str2, hashMap, bundle);
        AppMethodBeat.o(63996);
        return a;
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        AppMethodBeat.i(63995);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        boolean a = d.a(context, str, hashMap);
        AppMethodBeat.o(63995);
        return a;
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        AppMethodBeat.i(63994);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == TbsConfig.APP_QQ) {
                    bv a = bv.a();
                    if (a != null && a.b()) {
                        Object invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
                        if (invokeStaticMethod != null) {
                            IX5WebViewBase iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
                            if (iX5WebViewBase != null) {
                                webView = (WebView) iX5WebViewBase.getView().getParent();
                            }
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        if (d.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0) {
            AppMethodBeat.o(63994);
            return true;
        }
        AppMethodBeat.o(63994);
        return false;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(64045);
        if (context == null) {
            AppMethodBeat.o(64045);
            return false;
        }
        bv a = bv.a();
        a.a(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (d.a(context, str, hashMap, str2, null) != 0) {
            if (a.b()) {
                if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                    AppMethodBeat.o(64045);
                    return false;
                } else if (a.c().a(context, str, hashMap, null, valueCallback) == 0) {
                    AppMethodBeat.o(64045);
                    return true;
                }
            }
            AppMethodBeat.o(64045);
            return false;
        }
        AppMethodBeat.o(64045);
        return true;
    }

    public static void unForceSysWebView() {
        AppMethodBeat.i(64020);
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
        AppMethodBeat.o(64020);
    }

    public static synchronized boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static boolean useSoftWare() {
        AppMethodBeat.i(64038);
        if (r == null) {
            AppMethodBeat.o(64038);
            return false;
        }
        Object a = r.a(r, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = r.a(r, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(a.a()));
        }
        if (a == null) {
            AppMethodBeat.o(64038);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.o(64038);
        return booleanValue;
    }
}
