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
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.p1104a.C24262d;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C30951r;
import com.tencent.smtt.utils.C30952t;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
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
    /* renamed from: A */
    private static String f16232A = null;
    /* renamed from: B */
    private static boolean f16233B = false;
    /* renamed from: C */
    private static boolean f16234C = true;
    /* renamed from: D */
    private static TbsListener f16235D = null;
    /* renamed from: E */
    private static TbsListener f16236E = null;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    /* renamed from: F */
    private static boolean f16237F = false;
    /* renamed from: G */
    private static boolean f16238G = false;
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
    /* renamed from: a */
    static boolean f16239a = false;
    /* renamed from: b */
    static boolean f16240b = false;
    /* renamed from: c */
    static boolean f16241c = true;
    /* renamed from: d */
    static String f16242d;
    /* renamed from: e */
    static boolean f16243e = false;
    /* renamed from: f */
    static long f16244f = 0;
    /* renamed from: g */
    static long f16245g = 0;
    /* renamed from: h */
    static Object f16246h = new Object();
    /* renamed from: i */
    static boolean f16247i = true;
    /* renamed from: j */
    static boolean f16248j = true;
    /* renamed from: k */
    static boolean f16249k = false;
    /* renamed from: l */
    static volatile boolean f16250l = f16239a;
    /* renamed from: m */
    static TbsListener f16251m = new C5817n();
    public static boolean mDisableUseHostBackupCore = false;
    /* renamed from: n */
    static Map<String, Object> f16252n = null;
    /* renamed from: o */
    private static int f16253o = 0;
    /* renamed from: p */
    private static String f16254p = "";
    /* renamed from: q */
    private static Class<?> f16255q = null;
    /* renamed from: r */
    private static Object f16256r = null;
    /* renamed from: s */
    private static boolean f16257s = false;
    public static boolean sIsVersionPrinted = false;
    /* renamed from: t */
    private static String[] f16258t;
    /* renamed from: u */
    private static String f16259u = "NULL";
    /* renamed from: v */
    private static String f16260v = "UNKNOWN";
    /* renamed from: w */
    private static boolean f16261w = false;
    /* renamed from: x */
    private static int f16262x = 0;
    /* renamed from: y */
    private static int f16263y = ErrorCode.NEEDDOWNLOAD_TRUE;
    /* renamed from: z */
    private static String f16264z = null;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static {
        AppMethodBeat.m2504i(64056);
        AppMethodBeat.m2505o(64056);
    }

    /* renamed from: a */
    static Bundle m71032a(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(64004);
        if (m71036a(context)) {
            Object a = C30951r.m49578a(f16256r, "incrUpdate", new Class[]{Context.class, Bundle.class}, context, bundle);
            if (a != null) {
                Bundle bundle2 = (Bundle) a;
                AppMethodBeat.m2505o(64004);
                return bundle2;
            }
            TbsLogReport.getInstance(context).setInstallErrorCode(216, "incrUpdate return null!");
            AppMethodBeat.m2505o(64004);
            return null;
        }
        TbsLogReport.getInstance(context).setInstallErrorCode(216, "initForPatch return false!");
        AppMethodBeat.m2505o(64004);
        return null;
    }

    /* renamed from: a */
    static Object m71033a(Context context, String str, Bundle bundle) {
        AppMethodBeat.m2504i(64052);
        if (m71036a(context)) {
            Object a = C30951r.m49578a(f16256r, "miscCall", new Class[]{String.class, Bundle.class}, str, bundle);
            if (a != null) {
                AppMethodBeat.m2505o(64052);
                return a;
            }
            AppMethodBeat.m2505o(64052);
            return null;
        }
        Integer valueOf = Integer.valueOf(EXTENSION_INIT_FAILURE);
        AppMethodBeat.m2505o(64052);
        return valueOf;
    }

    /* renamed from: a */
    static String m71034a() {
        return f16254p;
    }

    /* renamed from: a */
    static synchronized void m71035a(Context context, String str) {
        synchronized (QbSdk.class) {
            AppMethodBeat.m2504i(64018);
            if (f16239a) {
                AppMethodBeat.m2505o(64018);
            } else {
                f16239a = true;
                f16260v = "forceSysWebViewInner: ".concat(String.valueOf(str));
                TbsLog.m80432e("QbSdk", "QbSdk.SysWebViewForcedInner..." + f16260v);
                TbsCoreLoadStat.getInstance().mo64872a(context, 401, new Throwable(f16260v));
                AppMethodBeat.m2505o(64018);
            }
        }
    }

    /* renamed from: a */
    static boolean m71036a(Context context) {
        AppMethodBeat.m2504i(64001);
        try {
            if (f16255q != null) {
                AppMethodBeat.m2505o(64001);
                return true;
            }
            File r = C5813an.m8800a().mo12183r(context);
            if (r == null) {
                TbsLog.m80432e("QbSdk", "QbSdk initExtension (false) optDir == null");
                AppMethodBeat.m2505o(64001);
                return false;
            }
            File file = new File(r, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                TbsLog.m80434i("QbSdk", "new DexLoader #3 dexFile is " + file.getAbsolutePath());
                C40978bv.m71073a().mo64919a(context);
                f16255q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, r.getAbsolutePath(), null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                loadTBSSDKExtension(context, file.getParent());
                AppMethodBeat.m2505o(64001);
                return true;
            }
            TbsLog.m80433e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            AppMethodBeat.m2505o(64001);
            return false;
        } catch (Throwable th) {
            TbsLog.m80432e("QbSdk", "initExtension sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64001);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m71037a(Context context, int i) {
        AppMethodBeat.m2504i(64005);
        boolean a = m71038a(context, i, (int) C1625i.sHCENCODEVIDEOTIMEOUT);
        AppMethodBeat.m2505o(64005);
        return a;
    }

    /* renamed from: a */
    static boolean m71038a(Context context, int i, int i2) {
        AppMethodBeat.m2504i(64006);
        if (f16252n != null && f16252n.containsKey(KEY_SET_SENDREQUEST_AND_UPLOAD) && f16252n.get(KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m80434i("QbSdk", "[QbSdk.isX5Disabled] -- SET_SENDREQUEST_AND_UPLOAD is false");
            AppMethodBeat.m2505o(64006);
            return true;
        } else if (m71045c(context)) {
            Object a = C30951r.m49578a(f16256r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43644), Integer.valueOf(i2));
            boolean booleanValue;
            if (a != null) {
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(64006);
                return booleanValue;
            }
            a = C30951r.m49578a(f16256r, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i), Integer.valueOf(43644));
            if (a != null) {
                booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(64006);
                return booleanValue;
            }
            AppMethodBeat.m2505o(64006);
            return true;
        } else {
            AppMethodBeat.m2505o(64006);
            return true;
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static boolean m71039a(Context context, boolean z) {
        AppMethodBeat.m2504i(63997);
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.m80434i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43644; SDK_VERSION_NAME: 4.3.0.1057");
            sIsVersionPrinted = true;
        }
        if (f16239a && !z) {
            TbsLog.m80433e("QbSdk", "QbSdk init: " + f16260v, false);
            TbsCoreLoadStat.getInstance().mo64872a(context, 414, new Throwable(f16260v));
            AppMethodBeat.m2505o(63997);
            return false;
        } else if (f16240b) {
            TbsLog.m80433e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().mo64872a(context, 402, new Throwable(f16259u));
            AppMethodBeat.m2505o(63997);
            return false;
        } else {
            if (!f16234C) {
                m71047d(context);
            }
            try {
                File r = C5813an.m8800a().mo12183r(context);
                if (r == null) {
                    TbsLog.m80432e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().mo64872a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    AppMethodBeat.m2505o(63997);
                    return false;
                }
                int a;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    if (f16253o != 0) {
                        a = C5813an.m8800a().mo12149a(true, context);
                        if (f16253o != a) {
                            f16255q = null;
                            f16256r = null;
                            TbsLog.m80433e("QbSdk", "QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=".concat(String.valueOf(a)), true);
                            TbsLog.m80433e("QbSdk", "QbSdk init (false) not isThirdPartyApp sTbsVersion=" + f16253o, true);
                            TbsCoreLoadStat.getInstance().mo64872a(context, 303, new Throwable("sTbsVersion: " + f16253o + "; tbsCoreInstalledVer: " + a));
                            AppMethodBeat.m2505o(63997);
                            return false;
                        }
                    }
                    a = 0;
                    f16253o = a;
                } else if (f16253o == 0 || f16253o == TbsShareManager.m49469d(context)) {
                    f16253o = TbsShareManager.m49469d(context);
                } else {
                    f16255q = null;
                    f16256r = null;
                    TbsLog.m80432e("QbSdk", "QbSdk init (false) ERROR_UNMATCH_TBSCORE_VER_THIRDPARTY!");
                    TbsCoreLoadStat.getInstance().mo64872a(context, 302, new Throwable("sTbsVersion: " + f16253o + "; AvailableTbsCoreVersion: " + TbsShareManager.m49469d(context)));
                    AppMethodBeat.m2505o(63997);
                    return false;
                }
                if (f16255q != null) {
                    AppMethodBeat.m2505o(63997);
                    return true;
                }
                File file;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(C5813an.m8800a().mo12183r(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.m49476j(context)) {
                    file = new File(TbsShareManager.m49467c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().mo64872a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    AppMethodBeat.m2505o(63997);
                    return false;
                }
                if (file.exists()) {
                    Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                    TbsLog.m80434i("QbSdk", "QbSdk init optDirExtension #1 is ".concat(String.valueOf(hostCorePathAppDefined)));
                    TbsLog.m80434i("QbSdk", "new DexLoader #1 dexFile is " + file.getAbsolutePath());
                    C40978bv.m71073a().mo64919a(context);
                    f16255q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    loadTBSSDKExtension(context, file.getParent());
                    C30951r.m49578a(f16256r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, C36443b.f15180a, C36443b.f15181b, C36443b.f15182c, C36443b.f15183d);
                    C30951r.m49578a(f16256r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                    AppMethodBeat.m2505o(63997);
                    return true;
                }
                try {
                    TbsLog.m80432e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                    a = C5813an.m8800a().mo12175j(context);
                    if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                        if (a > 0) {
                            TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(a))));
                        } else {
                            TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(with fusion dex)!".concat(String.valueOf(a))));
                        }
                    } else if (a > 0) {
                        TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(a))));
                    } else {
                        TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE, new Exception("tbs_sdk_extension_dex not exist(without fusion dex)!".concat(String.valueOf(a))));
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.m2505o(63997);
                return false;
            } catch (Throwable th2) {
                TbsLog.m80432e("QbSdk", "QbSdk init Throwable: " + Log.getStackTraceString(th2));
                TbsCoreLoadStat.getInstance().mo64872a(context, 306, th2);
                AppMethodBeat.m2505o(63997);
                return false;
            }
        }
    }

    /* renamed from: a */
    static boolean m71040a(Context context, boolean z, boolean z2) {
        int i = 1;
        boolean z3 = false;
        AppMethodBeat.m2504i(64014);
        int disabledCoreVersion = TbsPVConfig.getInstance(context).getDisabledCoreVersion();
        if (disabledCoreVersion != 0 && disabledCoreVersion == C5813an.m8800a().mo12175j(context)) {
            TbsLog.m80432e("QbSdk", "force use sys by remote switch");
            AppMethodBeat.m2505o(64014);
        } else if (TbsShareManager.isThirdPartyApp(context) && !TbsShareManager.m49475i(context)) {
            TbsCoreLoadStat.getInstance().mo64871a(context, 302);
            AppMethodBeat.m2505o(64014);
        } else if (m71039a(context, z)) {
            Object a = C30951r.m49578a(f16256r, "canLoadX5Core", new Class[]{Integer.TYPE}, Integer.valueOf(43644));
            boolean a2;
            if (a == null) {
                a = C30951r.m49578a(f16256r, "canLoadX5", new Class[]{Integer.TYPE}, Integer.valueOf(C40970a.m71063a()));
                if (a == null) {
                    TbsCoreLoadStat.getInstance().mo64871a(context, 308);
                } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                    AppMethodBeat.m2505o(64014);
                } else if (a instanceof Boolean) {
                    f16253o = C5818o.m8866d();
                    a2 = m71037a(context, C5818o.m8866d());
                    if (((Boolean) a).booleanValue() && !a2) {
                        z3 = true;
                    }
                    if (!z3) {
                        TbsLog.m80432e(TbsListener.tag_load_error, "318");
                        TbsLog.m80438w(TbsListener.tag_load_error, "isX5Disable:".concat(String.valueOf(a2)));
                        TbsLog.m80438w(TbsListener.tag_load_error, "(Boolean) ret:" + ((Boolean) a));
                    }
                    AppMethodBeat.m2505o(64014);
                }
            } else if ((a instanceof String) && ((String) a).equalsIgnoreCase("AuthenticationFail")) {
                AppMethodBeat.m2505o(64014);
            } else if (a instanceof Bundle) {
                Bundle bundle = (Bundle) a;
                if (bundle.isEmpty()) {
                    TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_EMPTY_BUNDLE, new Throwable(String.valueOf(a)));
                    TbsLog.m80432e(TbsListener.tag_load_error, "empty bundle");
                    AppMethodBeat.m2505o(64014);
                } else {
                    int i2;
                    try {
                        i2 = bundle.getInt("result_code", -1);
                    } catch (Exception e) {
                        TbsLog.m80432e("QbSdk", "bundle.getInt(KEY_RESULT_CODE) error : " + e.toString());
                        i2 = -1;
                    }
                    a2 = i2 == 0;
                    String valueOf;
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        C5818o.m8864a(TbsShareManager.m49469d(context));
                        valueOf = String.valueOf(TbsShareManager.m49469d(context));
                        f16254p = valueOf;
                        if (valueOf.length() == 5) {
                            f16254p = new StringBuilder(AppEventsConstants.EVENT_PARAM_VALUE_NO).append(f16254p).toString();
                        }
                        if (f16254p.length() != 6) {
                            f16254p = "";
                        }
                    } else {
                        try {
                            if (VERSION.SDK_INT >= 12) {
                                f16254p = bundle.getString("tbs_core_version", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            } else {
                                valueOf = bundle.getString("tbs_core_version");
                                f16254p = valueOf;
                                if (valueOf == null) {
                                    f16254p = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                                }
                            }
                        } catch (Exception e2) {
                            f16254p = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                        }
                        try {
                            f16253o = Integer.parseInt(f16254p);
                        } catch (NumberFormatException e3) {
                            f16253o = 0;
                        }
                        C5818o.m8864a(f16253o);
                        if (f16253o == 0) {
                            TbsCoreLoadStat.getInstance().mo64872a(context, 307, new Throwable("sTbsVersion is 0"));
                            AppMethodBeat.m2505o(64014);
                        } else {
                            if ((f16253o <= 0 || f16253o > 25442) && f16253o != 25472) {
                                i = 0;
                            }
                            if (i != 0) {
                                TbsLog.m80432e(TbsDownloader.LOGTAG, "is_obsolete --> delete old core:" + f16253o);
                                C30950k.m49564b(C5813an.m8800a().mo12183r(context));
                                TbsCoreLoadStat.getInstance().mo64872a(context, 307, new Throwable("is_obsolete --> delete old core:" + f16253o));
                                AppMethodBeat.m2505o(64014);
                            }
                        }
                    }
                    try {
                        f16258t = bundle.getStringArray("tbs_jarfiles");
                        if (f16258t instanceof String[]) {
                            try {
                                f16242d = bundle.getString("tbs_librarypath");
                                a = null;
                                if (i2 != 0) {
                                    try {
                                        a = C30951r.m49578a(f16256r, "getErrorCodeForLogReport", new Class[0], new Object[0]);
                                    } catch (Exception e4) {
                                    }
                                }
                                switch (i2) {
                                    case -2:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().mo64872a(context, 404, new Throwable("detail: ".concat(String.valueOf(a))));
                                            z3 = a2;
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().mo64872a(context, ((Integer) a).intValue(), new Throwable("detail: ".concat(String.valueOf(a))));
                                        z3 = a2;
                                        break;
                                    case -1:
                                        if (!(a instanceof Integer)) {
                                            TbsCoreLoadStat.getInstance().mo64872a(context, 307, new Throwable("detail: ".concat(String.valueOf(a))));
                                            z3 = a2;
                                            break;
                                        }
                                        TbsCoreLoadStat.getInstance().mo64872a(context, ((Integer) a).intValue(), new Throwable("detail: ".concat(String.valueOf(a))));
                                        z3 = a2;
                                        break;
                                    case 0:
                                        z3 = a2;
                                        break;
                                    default:
                                        TbsCoreLoadStat.getInstance().mo64872a(context, 415, new Throwable("detail: " + a + "errcode" + i2));
                                        z3 = a2;
                                        break;
                                }
                            } catch (Exception e5) {
                                AppMethodBeat.m2505o(64014);
                            }
                        } else {
                            TbsCoreLoadStat.getInstance().mo64872a(context, 307, new Throwable("sJarFiles not instanceof String[]: " + f16258t));
                            AppMethodBeat.m2505o(64014);
                        }
                    } catch (Throwable th) {
                        TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, th);
                        AppMethodBeat.m2505o(64014);
                    }
                }
            } else {
                TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.ERROR_QBSDK_INIT_ERROR_RET_TYPE_NOT_BUNDLE, new Throwable(String.valueOf(a)));
                TbsLog.m80432e(TbsListener.tag_load_error, "ret not instance of bundle");
                AppMethodBeat.m2505o(64014);
            }
            if (!z3) {
                TbsLog.m80432e(TbsListener.tag_load_error, "319");
            }
            AppMethodBeat.m2505o(64014);
        } else {
            TbsLog.m80432e("QbSdk", "QbSdk.init failure!");
            AppMethodBeat.m2505o(64014);
        }
        return z3;
    }

    /* renamed from: b */
    protected static String m71042b() {
        AppMethodBeat.m2504i(64053);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            Object invokeStaticMethod = a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                String str = (String) invokeStaticMethod;
                AppMethodBeat.m2505o(64053);
                return str;
            }
        }
        AppMethodBeat.m2505o(64053);
        return null;
    }

    /* renamed from: b */
    static boolean m71043b(Context context) {
        AppMethodBeat.m2504i(64003);
        if (context == null) {
            AppMethodBeat.m2505o(64003);
            return false;
        }
        try {
            if (context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                TbsLog.m80434i("QbSdk", "clearPluginConfigFile #1");
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
                String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
                TbsLog.m80434i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
                if (!(string == null || string.contains(str))) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("plugin_setting", 0);
                    if (sharedPreferences != null) {
                        Editor edit = sharedPreferences.edit();
                        edit.clear();
                        edit.commit();
                        TbsLog.m80434i("QbSdk", "clearPluginConfigFile done");
                    }
                }
            }
            AppMethodBeat.m2505o(64003);
            return true;
        } catch (Throwable th) {
            TbsLog.m80434i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            AppMethodBeat.m2505o(64003);
            return false;
        }
    }

    /* renamed from: c */
    private static boolean m71045c(Context context) {
        AppMethodBeat.m2504i(64002);
        try {
            if (f16255q != null) {
                AppMethodBeat.m2505o(64002);
                return true;
            }
            File r = C5813an.m8800a().mo12183r(context);
            if (r == null) {
                TbsLog.m80432e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                AppMethodBeat.m2505o(64002);
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(C5813an.m8800a().mo12183r(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.m49476j(context)) {
                file = new File(TbsShareManager.m49467c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().mo64871a(context, 304);
                AppMethodBeat.m2505o(64002);
                return false;
            }
            if (file.exists()) {
                Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                TbsLog.m80434i("QbSdk", "QbSdk init optDirExtension #3 is ".concat(String.valueOf(hostCorePathAppDefined)));
                TbsLog.m80434i("QbSdk", "new DexLoader #4 dexFile is " + file.getAbsolutePath());
                C40978bv.m71073a().mo64919a(context);
                f16255q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                loadTBSSDKExtension(context, file.getParent());
                C30951r.m49578a(f16256r, "putInfo", new Class[]{String.class, String.class, String.class, String.class}, C36443b.f15180a, C36443b.f15181b, C36443b.f15182c, C36443b.f15183d);
                C30951r.m49578a(f16256r, "setClientVersion", new Class[]{Integer.TYPE}, Integer.valueOf(1));
                AppMethodBeat.m2505o(64002);
                return true;
            }
            TbsCoreLoadStat.getInstance().mo64872a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
            AppMethodBeat.m2505o(64002);
            return false;
        } catch (Throwable th) {
            TbsLog.m80432e("QbSdk", "initForX5DisableConfig sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64002);
            return false;
        }
    }

    public static boolean canLoadVideo(Context context) {
        AppMethodBeat.m2504i(64013);
        Object a = C30951r.m49578a(f16256r, "canLoadVideo", new Class[]{Integer.TYPE}, Integer.valueOf(0));
        if (a == null) {
            TbsCoreLoadStat.getInstance().mo64871a(context, 314);
        } else if (!((Boolean) a).booleanValue()) {
            TbsCoreLoadStat.getInstance().mo64871a(context, 313);
        }
        if (a == null) {
            AppMethodBeat.m2505o(64013);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.m2505o(64013);
        return booleanValue;
    }

    public static boolean canLoadX5(Context context) {
        AppMethodBeat.m2504i(64007);
        boolean a = m71040a(context, false, false);
        AppMethodBeat.m2505o(64007);
        return a;
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        AppMethodBeat.m2504i(64000);
        try {
            if (context.getApplicationInfo().packageName.contains("com.moji.mjweather") && VERSION.SDK_INT == 19) {
                AppMethodBeat.m2505o(64000);
                return true;
            }
            if (f16255q == null) {
                File r = C5813an.m8800a().mo12183r(context);
                if (r == null) {
                    TbsLog.m80432e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    AppMethodBeat.m2505o(64000);
                    return false;
                }
                File file = new File(TbsShareManager.m49467c(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    Object hostCorePathAppDefined = TbsShareManager.getHostCorePathAppDefined() != null ? TbsShareManager.getHostCorePathAppDefined() : r.getAbsolutePath();
                    TbsLog.m80434i("QbSdk", "QbSdk init optDirExtension #2 is ".concat(String.valueOf(hostCorePathAppDefined)));
                    TbsLog.m80434i("QbSdk", "new DexLoader #2 dexFile is " + file.getAbsolutePath());
                    C40978bv.m71073a().mo64919a(context);
                    f16255q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, hostCorePathAppDefined, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    if (f16256r == null) {
                        if (TbsShareManager.m49471e(context) == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                            TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                            AppMethodBeat.m2505o(64000);
                            return false;
                        }
                        loadTBSSDKExtension(context, file.getParent());
                    }
                } else {
                    TbsLog.m80433e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    AppMethodBeat.m2505o(64000);
                    return false;
                }
            }
            Object a = C30951r.m49578a(f16256r, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            if (a == null || !(a instanceof Boolean)) {
                AppMethodBeat.m2505o(64000);
                return false;
            }
            boolean booleanValue = ((Boolean) a).booleanValue();
            AppMethodBeat.m2505o(64000);
            return booleanValue;
        } catch (Throwable th) {
            TbsLog.m80432e("QbSdk", "canLoadX5FirstTimeThirdApp sys WebView: " + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64000);
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(64021);
        new C40979h(context, str, valueCallback).start();
        AppMethodBeat.m2505o(64021);
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        AppMethodBeat.m2504i(64015);
        if (m71039a(context, false)) {
            AppMethodBeat.m2505o(64015);
        } else {
            AppMethodBeat.m2505o(64015);
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
        AppMethodBeat.m2504i(64008);
        if (f16262x == 0) {
            f16262x = C40970a.m71063a();
        }
        TbsLog.m80434i("QbSdk", "canOpenWebPlus - totalRAM: " + f16262x);
        if (VERSION.SDK_INT < 7 || f16262x < f16263y) {
            AppMethodBeat.m2505o(64008);
            return false;
        } else if (context == null) {
            AppMethodBeat.m2505o(64008);
            return false;
        } else {
            BufferedInputStream bufferedInputStream2;
            try {
                bufferedInputStream2 = new BufferedInputStream(new FileInputStream(new File(C5813an.m8800a().mo12183r(context), "tbs.conf")));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream2);
                    String property = properties.getProperty("android_sdk_max_supported");
                    String property2 = properties.getProperty("android_sdk_min_supported");
                    int parseInt = Integer.parseInt(property);
                    int parseInt2 = Integer.parseInt(property2);
                    int parseInt3 = Integer.parseInt(VERSION.SDK);
                    if (parseInt3 > parseInt || parseInt3 < parseInt2) {
                        TbsLog.m80434i("QbSdk", "canOpenWebPlus - sdkVersion: ".concat(String.valueOf(parseInt3)));
                        try {
                            bufferedInputStream2.close();
                        } catch (Exception e) {
                        }
                        AppMethodBeat.m2505o(64008);
                        return false;
                    }
                    parseInt = Integer.parseInt(properties.getProperty("tbs_core_version"));
                    try {
                        bufferedInputStream2.close();
                    } catch (Exception e2) {
                    }
                    InputStream fileInputStream;
                    try {
                        fileInputStream = new FileInputStream(new File(C5813an.m8819t(context), "tbs_extension.conf"));
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
                                    if (parseInt2 != C36443b.m60185b(context)) {
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
                            AppMethodBeat.m2505o(64008);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream = null;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(64008);
                        throw th;
                    }
                    if (z) {
                        AppMethodBeat.m2505o(64008);
                        return true;
                    }
                    AppMethodBeat.m2505o(64008);
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
                AppMethodBeat.m2505o(64008);
                throw th2;
            }
        }
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        AppMethodBeat.m2504i(64012);
        Object a = C30951r.m49578a(f16256r, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, Integer.valueOf(i));
        if (a == null || !(a instanceof Boolean)) {
            AppMethodBeat.m2505o(64012);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.m2505o(64012);
        return booleanValue;
    }

    public static void checkTbsValidity(Context context) {
        AppMethodBeat.m2504i(64029);
        if (context == null) {
            AppMethodBeat.m2505o(64029);
            return;
        }
        if (!C30952t.m49581a(context)) {
            TbsLog.m80432e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().mo64871a(context, 419);
            forceSysWebView();
        }
        AppMethodBeat.m2505o(64029);
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
        AppMethodBeat.m2504i(64043);
        TbsLog.m80434i("QbSdk", "clearAllWebViewCache(" + context + ", " + z + ")");
        try {
            if (new WebView(context).getWebViewClientExtension() != null) {
                try {
                    C40978bv a = C40978bv.m71073a();
                    if (a != null && a.mo64921b()) {
                        a.mo64922c().mo57562a(context, z);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    int obj3 = 1;
                    TbsLog.m80432e("QbSdk", "clearAllWebViewCache exception 2 -- " + Log.getStackTraceString(th));
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
            TbsLog.m80434i("QbSdk", "is_in_x5_mode --> no need to clear system webview!");
            AppMethodBeat.m2505o(64043);
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
            AppMethodBeat.m2505o(64043);
        } catch (Throwable th32) {
            TbsLog.m80432e("QbSdk", "clearAllWebViewCache exception 1 -- " + Log.getStackTraceString(th32));
            AppMethodBeat.m2505o(64043);
        }
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.m2504i(64022);
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(context, null);
        if (a.mo64921b()) {
            a.mo64922c().mo57613p();
        }
        AppMethodBeat.m2505o(64022);
    }

    public static void continueLoadSo(Context context) {
        AppMethodBeat.m2504i(64035);
        if ("com.tencent.mm".equals(getCurrentProcessName(context)) && WebView.mWebViewCreated) {
            C30951r.m49578a(f16256r, "continueLoadSo", new Class[0], new Object[0]);
        }
        AppMethodBeat.m2505o(64035);
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        AppMethodBeat.m2504i(64047);
        if (context == null) {
            AppMethodBeat.m2505o(64047);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.m2505o(64047);
            return false;
        } else if (isMiniQBShortCutExist(context, str, str2)) {
            AppMethodBeat.m2505o(64047);
            return false;
        } else {
            C40978bv a = C40978bv.m71073a();
            if (a == null || !a.mo64921b()) {
                AppMethodBeat.m2505o(64047);
                return false;
            }
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            DexLoader b = a.mo64922c().mo57573b();
            TbsLog.m80432e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, context, str, str2, bitmap);
            TbsLog.m80432e("QbSdk", "qbsdk after createMiniQBShortCut ret: ".concat(String.valueOf(invokeStaticMethod)));
            if (invokeStaticMethod != null) {
                AppMethodBeat.m2505o(64047);
                return true;
            }
            AppMethodBeat.m2505o(64047);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127 A:{SKIP} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{SYNTHETIC, Splitter:B:24:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A:{SYNTHETIC, Splitter:B:24:0x0073} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0127 A:{SKIP} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    private static void m71047d(Context context) {
        Throwable th;
        int i = -1;
        AppMethodBeat.m2504i(64032);
        f16234C = true;
        SharedPreferences sharedPreferences = null;
        int i2;
        int i3;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            int i4 = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i4 >= 0) {
                i2 = i4 + 1;
                if (i2 > 4) {
                    AppMethodBeat.m2505o(64032);
                    return;
                } else {
                    i4 = i2;
                    i3 = i2;
                }
            } else {
                i3 = -1;
            }
            try {
                i2 = C5813an.m8800a().mo12175j(context);
                if (i2 <= 0) {
                    AppMethodBeat.m2505o(64032);
                    return;
                }
                if (i4 <= 4) {
                    try {
                        sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i4).commit();
                    } catch (Throwable th2) {
                        th = th2;
                        TbsLog.m80432e("QbSdk", "tbs_preload_x5_counter Inc exception:" + Log.getStackTraceString(th));
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
                                C30950k.m49550a(C5813an.m8800a().mo12183r(context), false);
                                File a = C36432ai.m60088a(context).mo57537a();
                                if (a != null) {
                                    C30950k.m49550a(a, false);
                                }
                                TbsLog.m80432e("QbSdk", "QbSdk - preload_x5_check: tbs core " + i2 + " is deleted!");
                            } else {
                                TbsLog.m80432e("QbSdk", "QbSdk - preload_x5_check -- reset exception core_ver:" + i2 + "; value:" + i4);
                            }
                            edit.putInt("tbs_precheck_disable_version", i4);
                            edit.commit();
                            AppMethodBeat.m2505o(64032);
                            return;
                        } catch (Throwable th3) {
                            TbsLog.m80432e("QbSdk", "tbs_preload_x5_counter disable version exception:" + Log.getStackTraceString(th3));
                            AppMethodBeat.m2505o(64032);
                            return;
                        }
                    }
                    if (i3 > 0 && i3 <= 3) {
                        TbsLog.m80434i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                        C40978bv.m71073a().mo64920a(context, null);
                        TbsLog.m80434i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        i = 0;
                    }
                    try {
                        i4 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i4 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i4 - 1).commit();
                        }
                    } catch (Throwable th32) {
                        TbsLog.m80432e("QbSdk", "tbs_preload_x5_counter Dec exception:" + Log.getStackTraceString(th32));
                    }
                    TbsLog.m80434i("QbSdk", "QbSdk -- preload_x5_check result:".concat(String.valueOf(i)));
                    AppMethodBeat.m2505o(64032);
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
        AppMethodBeat.m2504i(64049);
        if (context == null) {
            AppMethodBeat.m2505o(64049);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.m2505o(64049);
            return false;
        } else {
            C40978bv a = C40978bv.m71073a();
            if (a == null || !a.mo64921b()) {
                AppMethodBeat.m2505o(64049);
                return false;
            }
            if (a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, context, str, str2) != null) {
                AppMethodBeat.m2505o(64049);
                return true;
            }
            AppMethodBeat.m2505o(64049);
            return false;
        }
    }

    public static void disAllowThirdAppDownload() {
        f16241c = false;
    }

    public static void disableAutoCreateX5Webview() {
        f16248j = false;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(64054);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            try {
                a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, context, str, valueCallback);
                AppMethodBeat.m2505o(64054);
                return;
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.m2505o(64054);
    }

    public static void forceSysWebView() {
        AppMethodBeat.m2504i(64019);
        f16240b = true;
        f16259u = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.m80432e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
        AppMethodBeat.m2505o(64019);
    }

    public static long getApkFileSize(Context context) {
        AppMethodBeat.m2504i(64039);
        if (context != null) {
            long j = TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            AppMethodBeat.m2505o(64039);
            return j;
        }
        AppMethodBeat.m2505o(64039);
        return 0;
    }

    public static String getCurrentProcessName(Context context) {
        AppMethodBeat.m2504i(64026);
        String str;
        try {
            int myPid = Process.myPid();
            str = "";
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getApplicationContext().getSystemService("activity")).getRunningAppProcesses()) {
                str = runningAppProcessInfo.pid == myPid ? runningAppProcessInfo.processName : str;
            }
            AppMethodBeat.m2505o(64026);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.m2505o(64026);
            return str;
        }
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        AppMethodBeat.m2504i(64037);
        String[] strArr;
        if (f16258t instanceof String[]) {
            int length = f16258t.length;
            strArr = new String[length];
            while (i < length) {
                strArr[i] = str + f16258t[i];
                i++;
            }
            AppMethodBeat.m2505o(64037);
            return strArr;
        }
        Object a = C30951r.m49578a(f16256r, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, context, context2, str);
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        strArr = (String[]) a;
        AppMethodBeat.m2505o(64037);
        return strArr;
    }

    public static boolean getDownloadWithoutWifi() {
        return f16237F;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return f16240b;
    }

    public static boolean getJarFilesAndLibraryPath(Context context) {
        AppMethodBeat.m2504i(64036);
        if (f16256r == null) {
            TbsLog.m80434i("QbSdk", "getJarFilesAndLibraryPath sExtensionObj is null");
            AppMethodBeat.m2505o(64036);
            return false;
        }
        Bundle bundle = (Bundle) C30951r.m49578a(f16256r, "canLoadX5CoreAndNotLoadSo", new Class[]{Integer.TYPE}, Integer.valueOf(43644));
        if (bundle == null) {
            TbsLog.m80434i("QbSdk", "getJarFilesAndLibraryPath bundle is null and coreverison is " + C5813an.m8800a().mo12149a(true, context));
            AppMethodBeat.m2505o(64036);
            return false;
        }
        f16258t = bundle.getStringArray("tbs_jarfiles");
        f16242d = bundle.getString("tbs_librarypath");
        AppMethodBeat.m2505o(64036);
        return true;
    }

    public static String getMiniQBVersion(Context context) {
        AppMethodBeat.m2504i(64046);
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(context, null);
        if (a == null || !a.mo64921b()) {
            AppMethodBeat.m2505o(64046);
            return null;
        }
        String f = a.mo64922c().mo57589f();
        AppMethodBeat.m2505o(64046);
        return f;
    }

    public static boolean getOnlyDownload() {
        return f16249k;
    }

    public static String getQQBuildNumber() {
        return f16232A;
    }

    public static Map<String, Object> getSettings() {
        return f16252n;
    }

    public static boolean getTBSInstalling() {
        return f16238G;
    }

    public static String getTID() {
        return f16264z;
    }

    public static String getTbsResourcesPath(Context context) {
        AppMethodBeat.m2504i(64017);
        String g = TbsShareManager.m49473g(context);
        AppMethodBeat.m2505o(64017);
        return g;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.m2504i(64033);
        int a;
        if (TbsShareManager.isThirdPartyApp(context)) {
            a = TbsShareManager.m49460a(context, false);
            AppMethodBeat.m2505o(64033);
            return a;
        }
        a = C5813an.m8800a().mo12175j(context);
        if (a == 0 && C36432ai.m60088a(context).mo57547c() == 3) {
            reset(context);
        }
        AppMethodBeat.m2505o(64033);
        return a;
    }

    public static int getTbsVersionForCrash(Context context) {
        AppMethodBeat.m2504i(64034);
        int a;
        if (TbsShareManager.isThirdPartyApp(context)) {
            a = TbsShareManager.m49460a(context, false);
            AppMethodBeat.m2505o(64034);
            return a;
        }
        a = C5813an.m8800a().mo12176k(context);
        if (a == 0 && C36432ai.m60088a(context).mo57547c() == 3) {
            reset(context);
        }
        AppMethodBeat.m2505o(64034);
        return a;
    }

    public static void initBuglyAsync(boolean z) {
        f16247i = z;
    }

    public static void initForinitAndNotLoadSo(Context context) {
        AppMethodBeat.m2504i(63999);
        if (f16255q == null) {
            File r = C5813an.m8800a().mo12183r(context);
            if (r == null) {
                AppMethodBeat.m2505o(63999);
                return;
            }
            File file = new File(r, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                String absolutePath = r.getAbsolutePath();
                C40978bv.m71073a().mo64919a(context);
                f16255q = new DexLoader(file.getParent(), context, new String[]{file.getAbsolutePath()}, absolutePath, null).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
            } else {
                AppMethodBeat.m2505o(63999);
                return;
            }
        }
        AppMethodBeat.m2505o(63999);
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.m2504i(64051);
        if (f16252n == null) {
            f16252n = map;
            AppMethodBeat.m2505o(64051);
            return;
        }
        try {
            f16252n.putAll(map);
            AppMethodBeat.m2505o(64051);
        } catch (Exception e) {
            AppMethodBeat.m2505o(64051);
        }
    }

    public static void initX5Environment(Context context, PreInitCallback preInitCallback) {
        AppMethodBeat.m2504i(64031);
        if (context == null) {
            AppMethodBeat.m2505o(64031);
            return;
        }
        m71043b(context);
        f16236E = new C16152l(context, preInitCallback);
        if (TbsShareManager.isThirdPartyApp(context)) {
            C5813an.m8800a().mo12161b(context, true);
        }
        TbsDownloader.needDownload(context, false, false, new C16153m(context, preInitCallback));
        AppMethodBeat.m2505o(64031);
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(64011);
        C5818o a = C5818o.m8863a(true);
        a.mo12196a(context, false, false, null);
        if (a == null || !a.mo12198b()) {
            AppMethodBeat.m2505o(64011);
            return false;
        }
        boolean a2 = a.mo12195a().mo50066a(context, str, str2, bundle);
        AppMethodBeat.m2505o(64011);
        return a2;
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        AppMethodBeat.m2504i(64050);
        if (webView == null) {
            AppMethodBeat.m2505o(64050);
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
            if (C24262d.m37418a(context, "miniqb://home".equals(substring) ? "qb://navicard/addCard?cardId=168&cardName=168" : substring, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                C40978bv a = C40978bv.m71073a();
                if (a != null && a.mo64921b() && a.mo64922c().mo57557a(context, substring, null, str2, null) == 0) {
                    AppMethodBeat.m2505o(64050);
                    return true;
                }
                webView.loadUrl(substring);
            }
        } else {
            webView.loadUrl(str);
        }
        AppMethodBeat.m2505o(64050);
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        AppMethodBeat.m2504i(64048);
        if (context == null) {
            AppMethodBeat.m2505o(64048);
            return false;
        } else if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.m2505o(64048);
            return false;
        } else {
            C40978bv a = C40978bv.m71073a();
            if (a == null || !a.mo64921b()) {
                AppMethodBeat.m2505o(64048);
                return false;
            }
            Object invokeStaticMethod = a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, context, str);
            if (invokeStaticMethod != null) {
                boolean booleanValue = (invokeStaticMethod instanceof Boolean ? (Boolean) invokeStaticMethod : Boolean.FALSE).booleanValue();
                AppMethodBeat.m2505o(64048);
                return booleanValue;
            }
            AppMethodBeat.m2505o(64048);
            return false;
        }
    }

    public static boolean isNeedInitX5FirstTime() {
        return f16261w;
    }

    public static boolean isTbsCoreInited() {
        AppMethodBeat.m2504i(64030);
        C5818o a = C5818o.m8863a(false);
        if (a == null || !a.mo12203g()) {
            AppMethodBeat.m2505o(64030);
            return false;
        }
        AppMethodBeat.m2505o(64030);
        return true;
    }

    public static boolean isX5DisabledSync(Context context) {
        int i;
        AppMethodBeat.m2504i(64009);
        if (C36432ai.m60088a(context).mo57547c() == 2) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            AppMethodBeat.m2505o(64009);
            return false;
        } else if (m71045c(context)) {
            i2 = C5813an.m8800a().mo12175j(context);
            Object a = C30951r.m49578a(f16256r, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, Integer.valueOf(i2), Integer.valueOf(43644));
            if (a != null) {
                boolean booleanValue = ((Boolean) a).booleanValue();
                AppMethodBeat.m2505o(64009);
                return booleanValue;
            }
            AppMethodBeat.m2505o(64009);
            return true;
        } else {
            AppMethodBeat.m2505o(64009);
            return true;
        }
    }

    public static void loadTBSSDKExtension(Context context, String str) {
        Object obj = 1;
        Object obj2 = null;
        AppMethodBeat.m2504i(63998);
        if (f16256r != null) {
            AppMethodBeat.m2505o(63998);
            return;
        }
        if (f16255q == null) {
            TbsLog.m80434i("QbSdk", "QbSdk loadTBSSDKExtension sExtensionClass is null");
        }
        Constructor constructor = null;
        try {
            constructor = f16255q.getConstructor(new Class[]{Context.class, Context.class, String.class, String.class, String.class});
        } catch (Throwable th) {
            obj = obj2;
        }
        try {
            if (TbsShareManager.isThirdPartyApp(context)) {
                Context e = TbsShareManager.m49471e(context);
                if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                    TbsLogReport.getInstance(context.getApplicationContext()).setLoadErrorCode(227, "host context is null!");
                    AppMethodBeat.m2505o(63998);
                } else if (obj != null) {
                    f16256r = constructor.newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined(), str, null});
                    AppMethodBeat.m2505o(63998);
                } else if (e == null) {
                    f16256r = f16255q.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()});
                    AppMethodBeat.m2505o(63998);
                } else {
                    f16256r = f16255q.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, e});
                    AppMethodBeat.m2505o(63998);
                }
            } else if (obj == null) {
                Constructor constructor2 = f16255q.getConstructor(new Class[]{Context.class, Context.class});
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                f16256r = constructor2.newInstance(new Object[]{context, context});
                AppMethodBeat.m2505o(63998);
            } else {
                String str2 = null;
                if ("com.tencent.mm".equals(getCurrentProcessName(context)) && !WebView.mWebViewCreated) {
                    str2 = "notLoadSo";
                }
                f16256r = constructor.newInstance(new Object[]{context, context, null, str, str2});
                AppMethodBeat.m2505o(63998);
            }
        } catch (Throwable th2) {
            AppMethodBeat.m2505o(63998);
        }
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            AppMethodBeat.m2504i(64023);
            preInit(context, null);
            AppMethodBeat.m2505o(64023);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            AppMethodBeat.m2504i(64027);
            TbsLog.initIfNeed(context);
            TbsLog.m80434i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.m80434i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            f16250l = f16239a;
            if (!f16257s) {
                C46741k c46741k = new C46741k(context, new C40980j(Looper.getMainLooper(), preInitCallback, context));
                c46741k.setName("tbs_preinit");
                c46741k.setPriority(10);
                c46741k.start();
                f16257s = true;
            }
            AppMethodBeat.m2505o(64027);
        }
    }

    public static void reset(Context context) {
        AppMethodBeat.m2504i(64040);
        reset(context, false);
        AppMethodBeat.m2505o(64040);
    }

    /* JADX WARNING: Missing block: B:8:0x0031, code skipped:
            if (r2 != r3) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(Context context, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(64041);
        TbsLog.m80433e("QbSdk", "QbSdk reset!", true);
        try {
            TbsDownloader.stopDownload();
            if (z && !TbsShareManager.isThirdPartyApp(context)) {
                int i = C5813an.m8800a().mo12174i(context);
                int j = C5813an.m8800a().mo12175j(context);
                if (i > 43300) {
                }
            }
            z2 = false;
            TbsDownloader.m37405b(context);
            C30950k.m49551a(context.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.m80435i("QbSdk", "delete downloaded apk success", true);
            C5813an.f1398a.set(Integer.valueOf(0));
            File file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
            if (z2) {
                C30950k.m49566b(C5813an.m8800a().mo12182q(context), C5813an.m8800a().mo12185u(context));
                C5813an.m8800a().mo12159b(context);
            }
            AppMethodBeat.m2505o(64041);
        } catch (Throwable th) {
            TbsLog.m80432e("QbSdk", "QbSdk reset exception:" + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64041);
        }
    }

    public static void resetDecoupleCore(Context context) {
        AppMethodBeat.m2504i(64042);
        TbsLog.m80433e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            C30950k.m49564b(C5813an.m8800a().mo12182q(context));
            AppMethodBeat.m2505o(64042);
        } catch (Throwable th) {
            TbsLog.m80432e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
            AppMethodBeat.m2505o(64042);
        }
    }

    public static void setCurrentID(String str) {
        AppMethodBeat.m2504i(64016);
        if (str == null) {
            AppMethodBeat.m2505o(64016);
            return;
        }
        if (str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            f16264z = "0000000000000000".substring(substring.length()) + substring;
        }
        AppMethodBeat.m2505o(64016);
    }

    public static void setDeviceInfo(String str, String str2, String str3, String str4) {
        C36443b.f15180a = str;
        C36443b.f15181b = str2;
        C36443b.f15182c = str3;
        C36443b.f15183d = str4;
    }

    public static void setDisableUnpreinitBySwitch(boolean z) {
        AppMethodBeat.m2504i(64025);
        f16233B = z;
        TbsLog.m80434i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + f16233B);
        AppMethodBeat.m2505o(64025);
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z) {
        AppMethodBeat.m2504i(64024);
        mDisableUseHostBackupCore = z;
        TbsLog.m80434i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
        AppMethodBeat.m2505o(64024);
    }

    public static void setDownloadWithoutWifi(boolean z) {
        f16237F = z;
    }

    public static void setNeedInitX5FirstTime(boolean z) {
        f16261w = z;
    }

    public static void setOnlyDownload(boolean z) {
        f16249k = z;
    }

    public static void setQQBuildNumber(String str) {
        f16232A = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        f16238G = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        f16235D = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.m2504i(64010);
        TbsLog.setTbsLogClient(tbsLogClient);
        AppMethodBeat.m2505o(64010);
    }

    public static void setUploadCode(Context context, int i) {
        AppMethodBeat.m2504i(64028);
        TbsDownloadUpload instance;
        if (i < 130 || i > C33333a.CTRL_INDEX) {
            if (i >= 150 && i <= JsApiGetBackgroundAudioState.CTRL_INDEX) {
                instance = TbsDownloadUpload.getInstance(context);
                instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(i));
                instance.commit();
            }
            AppMethodBeat.m2505o(64028);
            return;
        }
        instance = TbsDownloadUpload.getInstance(context);
        instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(i));
        instance.commit();
        AppMethodBeat.m2505o(64028);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(64044);
        TbsCoreLoadStat.getInstance().mo64871a(context, 501);
        if (context == null) {
            AppMethodBeat.m2505o(64044);
            return -100;
        }
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(context, null);
        if (!a.mo64921b()) {
            TbsCoreLoadStat.getInstance().mo64871a(context, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_ISNOTX5CORE);
            AppMethodBeat.m2505o(64044);
            return ZipJNI.UNZ_PARAMERROR;
        } else if (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) {
            int a2 = a.mo64922c().mo57557a(context, str, hashMap, null, valueCallback);
            if (a2 == 0) {
                TbsCoreLoadStat.getInstance().mo64871a(context, ErrorCode.INFO_CODE_MINIQB_STARTMINIQBTOLOADURL_SUCCESS);
            } else {
                TbsLogReport.getInstance(context).setLoadErrorCode(504, String.valueOf(a2));
            }
            AppMethodBeat.m2505o(64044);
            return a2;
        } else {
            AppMethodBeat.m2505o(64044);
            return XWalkUpdater.ERROR_SET_VERNUM;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        AppMethodBeat.m2504i(63996);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        boolean a = C24262d.m37423a(context, str, i2, str2, hashMap, bundle);
        AppMethodBeat.m2505o(63996);
        return a;
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        AppMethodBeat.m2504i(63995);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        boolean a = C24262d.m37424a(context, str, hashMap);
        AppMethodBeat.m2505o(63995);
        return a;
    }

    public static boolean startQBToLoadurl(Context context, String str, int i, WebView webView) {
        AppMethodBeat.m2504i(63994);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (str2 == "com.tencent.mm" || str2 == TbsConfig.APP_QQ) {
                    C40978bv a = C40978bv.m71073a();
                    if (a != null && a.mo64921b()) {
                        Object invokeStaticMethod = a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0]);
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
        if (C24262d.m37418a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0) {
            AppMethodBeat.m2505o(63994);
            return true;
        }
        AppMethodBeat.m2505o(63994);
        return false;
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(64045);
        if (context == null) {
            AppMethodBeat.m2505o(64045);
            return false;
        }
        C40978bv a = C40978bv.m71073a();
        a.mo64920a(context, null);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        if (C24262d.m37418a(context, str, hashMap, str2, null) != 0) {
            if (a.mo64921b()) {
                if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
                    AppMethodBeat.m2505o(64045);
                    return false;
                } else if (a.mo64922c().mo57557a(context, str, hashMap, null, valueCallback) == 0) {
                    AppMethodBeat.m2505o(64045);
                    return true;
                }
            }
            AppMethodBeat.m2505o(64045);
            return false;
        }
        AppMethodBeat.m2505o(64045);
        return true;
    }

    public static void unForceSysWebView() {
        AppMethodBeat.m2504i(64020);
        f16240b = false;
        TbsLog.m80432e("QbSdk", "sys WebView: unForceSysWebView called");
        AppMethodBeat.m2505o(64020);
    }

    public static synchronized boolean unPreInit(Context context) {
        synchronized (QbSdk.class) {
        }
        return true;
    }

    public static boolean useSoftWare() {
        AppMethodBeat.m2504i(64038);
        if (f16256r == null) {
            AppMethodBeat.m2505o(64038);
            return false;
        }
        Object a = C30951r.m49578a(f16256r, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = C30951r.m49578a(f16256r, "useSoftWare", new Class[]{Integer.TYPE}, Integer.valueOf(C40970a.m71063a()));
        }
        if (a == null) {
            AppMethodBeat.m2505o(64038);
            return false;
        }
        boolean booleanValue = ((Boolean) a).booleanValue();
        AppMethodBeat.m2505o(64038);
        return booleanValue;
    }
}
