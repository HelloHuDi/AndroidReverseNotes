package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
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

class bw {
    private DexLoader a;

    public bw(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public int a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(65107);
        Object invokeStaticMethod;
        int intValue;
        if (TbsDownloader.getOverSea(context)) {
            AppMethodBeat.o(65107);
            return ZipJNI.UNZ_BADZIPFILE;
        } else if (str2 == null) {
            invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            if (invokeStaticMethod == null) {
                AppMethodBeat.o(65107);
                return ZipJNI.UNZ_INTERNALERROR;
            }
            intValue = ((Integer) invokeStaticMethod).intValue();
            AppMethodBeat.o(65107);
            return intValue;
        } else {
            invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            if (invokeStaticMethod == null) {
                AppMethodBeat.o(65107);
                return ZipJNI.UNZ_INTERNALERROR;
            }
            intValue = ((Integer) invokeStaticMethod).intValue();
            AppMethodBeat.o(65107);
            return intValue;
        }
    }

    public IX5WebViewBase a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        AppMethodBeat.i(65051);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.THROWABLE_INITX5CORE, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable((String) invokeStaticMethod2));
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
                        TbsCoreLoadStat.getInstance().a(context, ErrorCode.THROWABLE_INITX5CORE, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e2) {
                }
            }
        }
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65051);
            return null;
        }
        AppMethodBeat.o(65051);
        return iX5WebViewBase;
    }

    public InputStream a(String str, boolean z) {
        AppMethodBeat.i(65054);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65054);
            return null;
        }
        InputStream inputStream = (InputStream) invokeStaticMethod;
        AppMethodBeat.o(65054);
        return inputStream;
    }

    public String a(String str) {
        AppMethodBeat.i(65052);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65052);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65052);
        return str2;
    }

    public String a(String str, String str2, String str3) {
        AppMethodBeat.i(65091);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65091);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.o(65091);
        return str4;
    }

    public void a(Context context, boolean z) {
        AppMethodBeat.i(65106);
        TbsLog.w("desktop", " tbsWizard clearAllX5Cache");
        if (z) {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class}, context);
            AppMethodBeat.o(65106);
            return;
        }
        try {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new Class[]{Context.class, Boolean.TYPE}, context, Boolean.valueOf(z));
            AppMethodBeat.o(65106);
        } catch (Exception e) {
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
            this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new Object[0]);
            this.a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new Object[0]);
            Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new Object[0]);
            }
            invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new Object[0]);
            if (invokeStaticMethod != null) {
                this.a.invokeMethod(invokeStaticMethod, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new Object[0]);
            }
            this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
            AppMethodBeat.o(65106);
        }
    }

    public void a(ValueCallback<Map> valueCallback) {
        AppMethodBeat.i(65073);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(65073);
    }

    public void a(String str, long j) {
        AppMethodBeat.i(65076);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
        AppMethodBeat.o(65076);
    }

    public void a(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(65074);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(65074);
    }

    public void a(String str, IconListener iconListener) {
        AppMethodBeat.i(65063);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
        AppMethodBeat.o(65063);
    }

    public void a(boolean z) {
        AppMethodBeat.i(65050);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
        AppMethodBeat.o(65050);
    }

    public boolean a() {
        AppMethodBeat.i(65045);
        try {
            Method method = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            boolean booleanValue;
            if (invoke instanceof Boolean) {
                booleanValue = ((Boolean) invoke).booleanValue();
                return booleanValue;
            }
            booleanValue = ((Boolean) invoke).booleanValue();
            AppMethodBeat.o(65045);
            return booleanValue;
        } finally {
            AppMethodBeat.o(65045);
        }
    }

    public boolean a(Context context, String str) {
        AppMethodBeat.i(65108);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        if (invokeStaticMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
            AppMethodBeat.o(65108);
            return booleanValue;
        }
        AppMethodBeat.o(65108);
        return false;
    }

    public boolean a(Map<String, String[]> map) {
        AppMethodBeat.i(65049);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65049);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65049);
        return booleanValue;
    }

    public byte[] a(byte[] bArr) {
        AppMethodBeat.i(65092);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new Class[]{String.class}, bArr);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65092);
            return null;
        }
        byte[] bArr2 = (byte[]) invokeStaticMethod;
        AppMethodBeat.o(65092);
        return bArr2;
    }

    public Uri[] a(int i, Intent intent) {
        AppMethodBeat.i(65061);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65061);
            return null;
        }
        Uri[] uriArr = (Uri[]) invokeStaticMethod;
        AppMethodBeat.o(65061);
        return uriArr;
    }

    public DexLoader b() {
        return this.a;
    }

    public String b(String str, String str2, String str3) {
        AppMethodBeat.i(65105);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new Class[]{String.class, String.class, String.class}, str, str2, str3);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65105);
            return null;
        }
        String str4 = (String) invokeStaticMethod;
        AppMethodBeat.o(65105);
        return str4;
    }

    public void b(ValueCallback<Set<String>> valueCallback) {
        AppMethodBeat.i(65080);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
        AppMethodBeat.o(65080);
    }

    public void b(String str) {
        AppMethodBeat.i(65060);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
        AppMethodBeat.o(65060);
    }

    public void b(String str, ValueCallback<Long> valueCallback) {
        AppMethodBeat.i(65075);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(65075);
    }

    public boolean b(Context context) {
        AppMethodBeat.i(65067);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65067);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65067);
        return booleanValue;
    }

    public Object c() {
        AppMethodBeat.i(65046);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
        AppMethodBeat.o(65046);
        return invokeStaticMethod;
    }

    public void c(Context context) {
        AppMethodBeat.i(65068);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.o(65068);
    }

    public void c(String str) {
        AppMethodBeat.i(65064);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.o(65064);
    }

    public void c(String str, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(65081);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
        AppMethodBeat.o(65081);
    }

    public void d(String str) {
        AppMethodBeat.i(65065);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
        AppMethodBeat.o(65065);
    }

    public boolean d() {
        AppMethodBeat.i(65047);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65047);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65047);
        return booleanValue;
    }

    public boolean d(Context context) {
        AppMethodBeat.i(65069);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65069);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65069);
        return booleanValue;
    }

    public void e() {
        AppMethodBeat.i(65048);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(65048);
    }

    public void e(Context context) {
        AppMethodBeat.i(65070);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        AppMethodBeat.o(65070);
    }

    public void e(String str) {
        AppMethodBeat.i(65077);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
        AppMethodBeat.o(65077);
    }

    public String f() {
        AppMethodBeat.i(65053);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65053);
            return null;
        }
        String str = (String) invokeStaticMethod;
        AppMethodBeat.o(65053);
        return str;
    }

    public void f(String str) {
        AppMethodBeat.i(65082);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new Class[]{String.class}, str);
        AppMethodBeat.o(65082);
    }

    public boolean f(Context context) {
        AppMethodBeat.i(65071);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65071);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65071);
        return booleanValue;
    }

    public Object g() {
        AppMethodBeat.i(65055);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
        AppMethodBeat.o(65055);
        return invokeStaticMethod;
    }

    public void g(Context context) {
        AppMethodBeat.i(65072);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
        AppMethodBeat.o(65072);
    }

    public void g(String str) {
        AppMethodBeat.i(65083);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new Class[]{String.class}, str);
        AppMethodBeat.o(65083);
    }

    public IX5DateSorter h(Context context) {
        AppMethodBeat.i(65079);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65079);
            return null;
        }
        IX5DateSorter iX5DateSorter = (IX5DateSorter) invokeStaticMethod;
        AppMethodBeat.o(65079);
        return iX5DateSorter;
    }

    public String h(String str) {
        AppMethodBeat.i(65085);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65085);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65085);
        return str2;
    }

    public boolean h() {
        AppMethodBeat.i(65056);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65056);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65056);
        return booleanValue;
    }

    public IX5WebChromeClient i() {
        AppMethodBeat.i(65057);
        if (this.a == null) {
            AppMethodBeat.o(65057);
            return null;
        }
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65057);
            return null;
        }
        IX5WebChromeClient iX5WebChromeClient = (IX5WebChromeClient) invokeStaticMethod;
        AppMethodBeat.o(65057);
        return iX5WebChromeClient;
    }

    public String i(Context context) {
        AppMethodBeat.i(65110);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new Class[]{Context.class}, context);
        if (invokeStaticMethod instanceof String) {
            String str = (String) invokeStaticMethod;
            AppMethodBeat.o(65110);
            return str;
        }
        AppMethodBeat.o(65110);
        return null;
    }

    public boolean i(String str) {
        AppMethodBeat.i(65086);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65086);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65086);
        return booleanValue;
    }

    public IX5WebViewClient j() {
        AppMethodBeat.i(65058);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65058);
            return null;
        }
        IX5WebViewClient iX5WebViewClient = (IX5WebViewClient) invokeStaticMethod;
        AppMethodBeat.o(65058);
        return iX5WebViewClient;
    }

    public String j(String str) {
        AppMethodBeat.i(65087);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65087);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65087);
        return str2;
    }

    public IX5WebViewClientExtension k() {
        AppMethodBeat.i(65059);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65059);
            return null;
        }
        IX5WebViewClientExtension iX5WebViewClientExtension = (IX5WebViewClientExtension) invokeStaticMethod;
        AppMethodBeat.o(65059);
        return iX5WebViewClientExtension;
    }

    public boolean k(String str) {
        AppMethodBeat.i(65088);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65088);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65088);
        return booleanValue;
    }

    public String l(String str) {
        AppMethodBeat.i(65089);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65089);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65089);
        return str2;
    }

    public void l() {
        AppMethodBeat.i(65062);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
        AppMethodBeat.o(65062);
    }

    public String m(String str) {
        AppMethodBeat.i(65090);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65090);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65090);
        return str2;
    }

    public void m() {
        AppMethodBeat.i(65066);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
        AppMethodBeat.o(65066);
    }

    public void n() {
        AppMethodBeat.i(65078);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
        AppMethodBeat.o(65078);
    }

    public boolean n(String str) {
        AppMethodBeat.i(65093);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65093);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65093);
        return booleanValue;
    }

    public void o() {
        AppMethodBeat.i(65084);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new Object[0]);
        AppMethodBeat.o(65084);
    }

    public boolean o(String str) {
        AppMethodBeat.i(65094);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65094);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65094);
        return booleanValue;
    }

    public void p() {
        AppMethodBeat.i(65109);
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
        AppMethodBeat.o(65109);
    }

    public boolean p(String str) {
        AppMethodBeat.i(65095);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65095);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65095);
        return booleanValue;
    }

    public boolean q(String str) {
        AppMethodBeat.i(65096);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65096);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65096);
        return booleanValue;
    }

    public boolean r(String str) {
        AppMethodBeat.i(65097);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65097);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65097);
        return booleanValue;
    }

    public boolean s(String str) {
        AppMethodBeat.i(65098);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65098);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65098);
        return booleanValue;
    }

    public boolean t(String str) {
        AppMethodBeat.i(65099);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65099);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65099);
        return booleanValue;
    }

    public boolean u(String str) {
        AppMethodBeat.i(65100);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65100);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65100);
        return booleanValue;
    }

    public boolean v(String str) {
        AppMethodBeat.i(65101);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65101);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65101);
        return booleanValue;
    }

    public boolean w(String str) {
        AppMethodBeat.i(65102);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65102);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65102);
        return booleanValue;
    }

    public boolean x(String str) {
        AppMethodBeat.i(65103);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65103);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
        AppMethodBeat.o(65103);
        return booleanValue;
    }

    public String y(String str) {
        AppMethodBeat.i(65104);
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new Class[]{String.class}, str);
        if (invokeStaticMethod == null) {
            AppMethodBeat.o(65104);
            return null;
        }
        String str2 = (String) invokeStaticMethod;
        AppMethodBeat.o(65104);
        return str2;
    }
}
