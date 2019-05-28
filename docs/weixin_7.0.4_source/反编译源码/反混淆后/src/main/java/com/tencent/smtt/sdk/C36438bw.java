package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.smtt.sdk.bw */
class C36438bw {
    /* renamed from: a */
    private DexLoader f15171a;

    public C36438bw(DexLoader dexLoader) {
        this.f15171a = dexLoader;
    }

    /* renamed from: a */
    public int mo57557a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        AppMethodBeat.m2504i(65107);
        Object invokeStaticMethod;
        int intValue;
        if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.m2505o(65107);
            return ZipJNI.UNZ_BADZIPFILE;
        } else if (str2 == null) {
            invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            if (invokeStaticMethod == null) {
                AppMethodBeat.m2505o(65107);
                return ZipJNI.UNZ_INTERNALERROR;
            }
            intValue = ((Integer) invokeStaticMethod).intValue();
            AppMethodBeat.m2505o(65107);
            return intValue;
        } else {
            invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            if (invokeStaticMethod == null) {
                AppMethodBeat.m2505o(65107);
                return ZipJNI.UNZ_INTERNALERROR;
            }
            intValue = ((Integer) invokeStaticMethod).intValue();
            AppMethodBeat.m2505o(65107);
            return intValue;
        }
    }

    /* renamed from: a */
    public IX5WebViewBase mo57558a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        AppMethodBeat.m2504i(65051);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
                }
                iX5WebViewBase = null;
                invokeStaticMethod = null;
            } catch (Exception e) {
                iX5WebViewBase = null;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        TbsCoreLoadStat.getInstance().mo64872a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e2) {
                }
            }
        }
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65051);
            return null;
        }
        AppMethodBeat.m2505o(65051);
        return iX5WebViewBase;
    }

    /* renamed from: a */
    public InputStream mo57559a(String str, boolean z) {
        AppMethodBeat.m2504i(65054);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65054);
            return null;
        }
        InputStream inputStream = (InputStream) invokeStaticMethod;
        AppMethodBeat.m2505o(65054);
        return inputStream;
    }

    /* renamed from: a */
    public String mo57560a(String str) {
        AppMethodBeat.m2504i(65052);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65052);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65052);
        return str2;
    }

    /* renamed from: a */
    public String mo57561a(String str, String str2, String str3) {
        AppMethodBeat.m2504i(65091);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65091);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65091);
        return str4;
    }

    /* renamed from: a */
    public void mo57562a(Context context, boolean z) {
        AppMethodBeat.m2504i(65106);
        TbsLog.m80438w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            AppMethodBeat.m2505o(65106);
            return;
        }
        try {
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
            AppMethodBeat.m2505o(65106);
        } catch (Exception e) {
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.f15171a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.f15171a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f15171a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.f15171a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
            AppMethodBeat.m2505o(65106);
        }
    }

    /* renamed from: a */
    public void mo57563a(ValueCallback<Map> valueCallback) {
        AppMethodBeat.m2504i(65073);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.m2505o(65073);
    }

    /* renamed from: a */
    public void mo57564a(String str, long j) {
        AppMethodBeat.m2504i(65076);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
        AppMethodBeat.m2505o(65076);
    }

    /* renamed from: a */
    public void mo57565a(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.m2504i(65074);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.m2505o(65074);
    }

    /* renamed from: a */
    public void mo57566a(String str, IconListener iconListener) {
        AppMethodBeat.m2504i(65063);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
        AppMethodBeat.m2505o(65063);
    }

    /* renamed from: a */
    public void mo57567a(boolean z) {
        AppMethodBeat.m2504i(65050);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.m2505o(65050);
    }

    /* renamed from: a */
    public boolean mo57568a() {
        AppMethodBeat.m2504i(65045);
        try {
            Method method = this.f15171a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            boolean booleanValue;
            if (invoke instanceof Boolean) {
                booleanValue = ((Boolean) invoke).booleanValue();
                return booleanValue;
            }
            booleanValue = ((Boolean) invoke).booleanValue();
            AppMethodBeat.m2505o(65045);
            return booleanValue;
        } finally {
            AppMethodBeat.m2505o(65045);
        }
    }

    /* renamed from: a */
    public boolean mo57569a(Context context, String str) {
        AppMethodBeat.m2504i(65108);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
            AppMethodBeat.m2505o(65108);
            return booleanValue;
        }
        AppMethodBeat.m2505o(65108);
        return false;
    }

    /* renamed from: a */
    public boolean mo57570a(Map<String, String[]> map) {
        AppMethodBeat.m2504i(65049);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65049);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65049);
        return booleanValue;
    }

    /* renamed from: a */
    public byte[] mo57571a(byte[] bArr) {
        AppMethodBeat.m2504i(65092);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65092);
            return null;
        }
        byte[] bArr2 = (byte[]) invokeStaticMethod;
        AppMethodBeat.m2505o(65092);
        return bArr2;
    }

    /* renamed from: a */
    public Uri[] mo57572a(int i, Intent intent) {
        AppMethodBeat.m2504i(65061);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65061);
            return null;
        }
        Uri[] uriArr = (Uri[]) invokeStaticMethod;
        AppMethodBeat.m2505o(65061);
        return uriArr;
    }

    /* renamed from: b */
    public DexLoader mo57573b() {
        return this.f15171a;
    }

    /* renamed from: b */
    public String mo57574b(String str, String str2, String str3) {
        AppMethodBeat.m2504i(65105);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65105);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65105);
        return str4;
    }

    /* renamed from: b */
    public void mo57575b(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.m2504i(65080);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.m2505o(65080);
    }

    /* renamed from: b */
    public void mo57576b(String str) {
        AppMethodBeat.m2504i(65060);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65060);
    }

    /* renamed from: b */
    public void mo57577b(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.m2504i(65075);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.m2505o(65075);
    }

    /* renamed from: b */
    public boolean mo57578b(Context context) {
        AppMethodBeat.m2504i(65067);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65067);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65067);
        return booleanValue;
    }

    /* renamed from: c */
    public Object mo57579c() {
        AppMethodBeat.m2504i(65046);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(65046);
        return invokeStaticMethod;
    }

    /* renamed from: c */
    public void mo57580c(Context context) {
        AppMethodBeat.m2504i(65068);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.m2505o(65068);
    }

    /* renamed from: c */
    public void mo57581c(String str) {
        AppMethodBeat.m2504i(65064);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65064);
    }

    /* renamed from: c */
    public void mo57582c(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(65081);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.m2505o(65081);
    }

    /* renamed from: d */
    public void mo57583d(String str) {
        AppMethodBeat.m2504i(65065);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65065);
    }

    /* renamed from: d */
    public boolean mo57584d() {
        AppMethodBeat.m2504i(65047);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65047);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65047);
        return booleanValue;
    }

    /* renamed from: d */
    public boolean mo57585d(Context context) {
        AppMethodBeat.m2504i(65069);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65069);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65069);
        return booleanValue;
    }

    /* renamed from: e */
    public void mo57586e() {
        AppMethodBeat.m2504i(65048);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(65048);
    }

    /* renamed from: e */
    public void mo57587e(Context context) {
        AppMethodBeat.m2504i(65070);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.m2505o(65070);
    }

    /* renamed from: e */
    public void mo57588e(String str) {
        AppMethodBeat.m2504i(65077);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65077);
    }

    /* renamed from: f */
    public String mo57589f() {
        AppMethodBeat.m2504i(65053);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65053);
            return null;
        }
        String str = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65053);
        return str;
    }

    /* renamed from: f */
    public void mo57590f(String str) {
        AppMethodBeat.m2504i(65082);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65082);
    }

    /* renamed from: f */
    public boolean mo57591f(Context context) {
        AppMethodBeat.m2504i(65071);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65071);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65071);
        return booleanValue;
    }

    /* renamed from: g */
    public Object mo57592g() {
        AppMethodBeat.m2504i(65055);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(65055);
        return invokeStaticMethod;
    }

    /* renamed from: g */
    public void mo57593g(Context context) {
        AppMethodBeat.m2504i(65072);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
        AppMethodBeat.m2505o(65072);
    }

    /* renamed from: g */
    public void mo57594g(String str) {
        AppMethodBeat.m2504i(65083);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
        AppMethodBeat.m2505o(65083);
    }

    /* renamed from: h */
    public IX5DateSorter mo57595h(Context context) {
        AppMethodBeat.m2504i(65079);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65079);
            return null;
        }
        IX5DateSorter iX5DateSorter = (IX5DateSorter) invokeStaticMethod;
        AppMethodBeat.m2505o(65079);
        return iX5DateSorter;
    }

    /* renamed from: h */
    public String mo57596h(String str) {
        AppMethodBeat.m2504i(65085);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65085);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65085);
        return str2;
    }

    /* renamed from: h */
    public boolean mo57597h() {
        AppMethodBeat.m2504i(65056);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65056);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65056);
        return booleanValue;
    }

    /* renamed from: i */
    public IX5WebChromeClient mo57598i() {
        AppMethodBeat.m2504i(65057);
        if (this.f15171a == null) {
            AppMethodBeat.m2505o(65057);
            return null;
        }
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65057);
            return null;
        }
        IX5WebChromeClient iX5WebChromeClient = (IX5WebChromeClient) invokeStaticMethod;
        AppMethodBeat.m2505o(65057);
        return iX5WebChromeClient;
    }

    /* renamed from: i */
    public String mo57599i(Context context) {
        AppMethodBeat.m2504i(65110);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            String str = (String) invokeStaticMethod;
            AppMethodBeat.m2505o(65110);
            return str;
        }
        AppMethodBeat.m2505o(65110);
        return null;
    }

    /* renamed from: i */
    public boolean mo57600i(String str) {
        AppMethodBeat.m2504i(65086);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65086);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65086);
        return booleanValue;
    }

    /* renamed from: j */
    public IX5WebViewClient mo57601j() {
        AppMethodBeat.m2504i(65058);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65058);
            return null;
        }
        IX5WebViewClient iX5WebViewClient = (IX5WebViewClient) invokeStaticMethod;
        AppMethodBeat.m2505o(65058);
        return iX5WebViewClient;
    }

    /* renamed from: j */
    public String mo57602j(String str) {
        AppMethodBeat.m2504i(65087);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65087);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65087);
        return str2;
    }

    /* renamed from: k */
    public IX5WebViewClientExtension mo57603k() {
        AppMethodBeat.m2504i(65059);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65059);
            return null;
        }
        IX5WebViewClientExtension iX5WebViewClientExtension = (IX5WebViewClientExtension) invokeStaticMethod;
        AppMethodBeat.m2505o(65059);
        return iX5WebViewClientExtension;
    }

    /* renamed from: k */
    public boolean mo57604k(String str) {
        AppMethodBeat.m2504i(65088);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65088);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65088);
        return booleanValue;
    }

    /* renamed from: l */
    public String mo57605l(String str) {
        AppMethodBeat.m2504i(65089);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65089);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65089);
        return str2;
    }

    /* renamed from: l */
    public void mo57606l() {
        AppMethodBeat.m2504i(65062);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        AppMethodBeat.m2505o(65062);
    }

    /* renamed from: m */
    public String mo57607m(String str) {
        AppMethodBeat.m2504i(65090);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65090);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65090);
        return str2;
    }

    /* renamed from: m */
    public void mo57608m() {
        AppMethodBeat.m2504i(65066);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
        AppMethodBeat.m2505o(65066);
    }

    /* renamed from: n */
    public void mo57609n() {
        AppMethodBeat.m2504i(65078);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
        AppMethodBeat.m2505o(65078);
    }

    /* renamed from: n */
    public boolean mo57610n(String str) {
        AppMethodBeat.m2504i(65093);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65093);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65093);
        return booleanValue;
    }

    /* renamed from: o */
    public void mo57611o() {
        AppMethodBeat.m2504i(65084);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
        AppMethodBeat.m2505o(65084);
    }

    /* renamed from: o */
    public boolean mo57612o(String str) {
        AppMethodBeat.m2504i(65094);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65094);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65094);
        return booleanValue;
    }

    /* renamed from: p */
    public void mo57613p() {
        AppMethodBeat.m2504i(65109);
        this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(65109);
    }

    /* renamed from: p */
    public boolean mo57614p(String str) {
        AppMethodBeat.m2504i(65095);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65095);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65095);
        return booleanValue;
    }

    /* renamed from: q */
    public boolean mo57615q(String str) {
        AppMethodBeat.m2504i(65096);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65096);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65096);
        return booleanValue;
    }

    /* renamed from: r */
    public boolean mo57616r(String str) {
        AppMethodBeat.m2504i(65097);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65097);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65097);
        return booleanValue;
    }

    /* renamed from: s */
    public boolean mo57617s(String str) {
        AppMethodBeat.m2504i(65098);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65098);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65098);
        return booleanValue;
    }

    /* renamed from: t */
    public boolean mo57618t(String str) {
        AppMethodBeat.m2504i(65099);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65099);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65099);
        return booleanValue;
    }

    /* renamed from: u */
    public boolean mo57619u(String str) {
        AppMethodBeat.m2504i(65100);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65100);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65100);
        return booleanValue;
    }

    /* renamed from: v */
    public boolean mo57620v(String str) {
        AppMethodBeat.m2504i(65101);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65101);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65101);
        return booleanValue;
    }

    /* renamed from: w */
    public boolean mo57621w(String str) {
        AppMethodBeat.m2504i(65102);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65102);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65102);
        return booleanValue;
    }

    /* renamed from: x */
    public boolean mo57622x(String str) {
        AppMethodBeat.m2504i(65103);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65103);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.m2505o(65103);
        return booleanValue;
    }

    /* renamed from: y */
    public String mo57623y(String str) {
        AppMethodBeat.m2504i(65104);
        Object invokeStaticMethod = this.f15171a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.m2505o(65104);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.m2505o(65104);
        return str2;
    }
}
