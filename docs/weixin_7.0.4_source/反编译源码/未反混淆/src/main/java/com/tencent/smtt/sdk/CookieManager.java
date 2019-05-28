package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;
    ArrayList<b> a;
    String b;
    a c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL;

        static {
            AppMethodBeat.o(63864);
        }
    }

    class b {
        int a;
        String b;
        String c;
        ValueCallback<Boolean> d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        AppMethodBeat.i(63865);
        if (d == null) {
            synchronized (CookieManager.class) {
                try {
                    if (d == null) {
                        d = new CookieManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(63865);
                    }
                }
            }
        }
        CookieManager cookieManager = d;
        AppMethodBeat.o(63865);
        return cookieManager;
    }

    public static int getROMCookieDBVersion(Context context) {
        AppMethodBeat.i(63885);
        int i = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).getInt("db_version", -1);
        AppMethodBeat.o(63885);
        return i;
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        AppMethodBeat.i(63886);
        Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).edit();
        edit.putInt("db_version", i);
        edit.commit();
        AppMethodBeat.o(63886);
    }

    /* Access modifiers changed, original: declared_synchronized */
    public synchronized void a() {
        AppMethodBeat.i(63882);
        this.f = true;
        if (this.a == null || this.a.size() == 0) {
            AppMethodBeat.o(63882);
        } else {
            bv a = bv.a();
            Iterator it;
            b bVar;
            if (a != null && a.b()) {
                it = this.a.iterator();
                while (it.hasNext()) {
                    bVar = (b) it.next();
                    switch (bVar.a) {
                        case 1:
                            setCookie(bVar.b, bVar.c, bVar.d);
                            break;
                        case 2:
                            setCookie(bVar.b, bVar.c);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.a.iterator();
            while (it.hasNext()) {
                bVar = (b) it.next();
                switch (bVar.a) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        r.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, bVar.b, bVar.c, bVar.d);
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(bVar.b, bVar.c);
                        break;
                    default:
                        break;
                }
            }
            this.a.clear();
            AppMethodBeat.o(63882);
        }
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    public synchronized void a(Context context, boolean z, boolean z2) {
        AppMethodBeat.i(63884);
        if (this.c == a.MODE_NONE || context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) || this.e) {
            AppMethodBeat.o(63884);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (z || QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.a) {
                    z2 = false;
                }
                boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
                TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
                if (canUseFunction == z2) {
                    AppMethodBeat.o(63884);
                } else {
                    int i;
                    int i2;
                    TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                    if (TextUtils.isEmpty(this.b)) {
                        tbsLogInfo.setErrorCode(701);
                        i = 0;
                        i2 = 0;
                    } else if (an.a().n(context) <= 0 || an.a().n(context) >= 36001) {
                        boolean z3;
                        if (canUseFunction) {
                            i2 = x.d(context);
                            if (i2 > 0) {
                                i = getROMCookieDBVersion(context);
                                z3 = i <= 0;
                            }
                            z3 = false;
                            i = 0;
                        } else {
                            i2 = x.d(context);
                            if (i2 > 0) {
                                String d = an.a().d(context, "cookies_database_version");
                                if (!TextUtils.isEmpty(d)) {
                                    try {
                                        i = Integer.parseInt(d);
                                        z3 = false;
                                    } catch (Exception e) {
                                    }
                                }
                            }
                            z3 = false;
                            i = 0;
                        }
                        if (!z3 && (i2 <= 0 || i <= 0)) {
                            tbsLogInfo.setErrorCode(702);
                        } else if (i >= i2) {
                            tbsLogInfo.setErrorCode(703);
                        } else {
                            x.a(context, this.c, this.b, z3, z2);
                            tbsLogInfo.setErrorCode(704);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    } else {
                        AppMethodBeat.o(63884);
                    }
                    tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i2 + " to:" + i + ",timeused:" + j);
                    TbsLogReport.getInstance(context).eventReport(EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
                    AppMethodBeat.o(63884);
                }
            } else {
                bv.a().a(context, null);
                AppMethodBeat.o(63884);
            }
        }
    }

    public boolean acceptCookie() {
        AppMethodBeat.i(63879);
        bv a = bv.a();
        boolean acceptCookie;
        if (a == null || !a.b()) {
            acceptCookie = android.webkit.CookieManager.getInstance().acceptCookie();
            AppMethodBeat.o(63879);
            return acceptCookie;
        }
        acceptCookie = a.c().d();
        AppMethodBeat.o(63879);
        return acceptCookie;
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        AppMethodBeat.i(63874);
        bv a = bv.a();
        Object invokeStaticMethod;
        if (a != null && a.b()) {
            invokeStaticMethod = a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod != null) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.o(63874);
            } else {
                AppMethodBeat.o(63874);
                booleanValue = true;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(63874);
            booleanValue = true;
        } else {
            invokeStaticMethod = r.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            if (invokeStaticMethod != null) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.o(63874);
            } else {
                AppMethodBeat.o(63874);
                booleanValue = false;
            }
        }
        return booleanValue;
    }

    public void flush() {
        AppMethodBeat.i(63870);
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
            AppMethodBeat.o(63870);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(63870);
        } else {
            r.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
            AppMethodBeat.o(63870);
        }
    }

    public String getCookie(String str) {
        AppMethodBeat.i(63880);
        bv a = bv.a();
        String str2;
        if (a == null || !a.b()) {
            str2 = null;
            try {
                str2 = android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
            }
            AppMethodBeat.o(63880);
            return str2;
        }
        str2 = a.c().a(str);
        AppMethodBeat.o(63880);
        return str2;
    }

    public boolean hasCookies() {
        AppMethodBeat.i(63878);
        bv a = bv.a();
        boolean hasCookies;
        if (a == null || !a.b()) {
            hasCookies = android.webkit.CookieManager.getInstance().hasCookies();
            AppMethodBeat.o(63878);
            return hasCookies;
        }
        hasCookies = a.c().h();
        AppMethodBeat.o(63878);
        return hasCookies;
    }

    public void removeAllCookie() {
        AppMethodBeat.i(63868);
        if (this.a != null) {
            this.a.clear();
        }
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
            AppMethodBeat.o(63868);
            return;
        }
        a.c().e();
        AppMethodBeat.o(63868);
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(63869);
        if (this.a != null) {
            this.a.clear();
        }
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(63869);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(63869);
        } else {
            r.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(63869);
        }
    }

    public void removeExpiredCookie() {
        AppMethodBeat.i(63871);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
            AppMethodBeat.o(63871);
            return;
        }
        a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(63871);
    }

    public void removeSessionCookie() {
        AppMethodBeat.i(63866);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
            AppMethodBeat.o(63866);
            return;
        }
        a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        AppMethodBeat.o(63866);
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(63867);
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(63867);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(63867);
        } else {
            r.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.o(63867);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        AppMethodBeat.i(63872);
        bv a = bv.a();
        if (a == null || !a.b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                AppMethodBeat.o(63872);
            } catch (Throwable th) {
                AppMethodBeat.o(63872);
            }
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.o(63872);
        }
        return;
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        AppMethodBeat.i(63873);
        bv a = bv.a();
        if (a != null && a.b()) {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            AppMethodBeat.o(63873);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.o(63873);
        } else {
            r.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            AppMethodBeat.o(63873);
        }
    }

    public synchronized void setCookie(String str, String str2) {
        AppMethodBeat.i(63875);
        setCookie(str, str2, false);
        AppMethodBeat.o(63875);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(63877);
        bv a = bv.a();
        if (a == null || !a.b()) {
            if (!bv.a().d()) {
                b bVar = new b();
                bVar.a = 1;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = valueCallback;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(bVar);
            }
            if (this.f) {
                if (VERSION.SDK_INT < 21) {
                    AppMethodBeat.o(63877);
                } else {
                    r.a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
                }
            }
            AppMethodBeat.o(63877);
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
            AppMethodBeat.o(63877);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        AppMethodBeat.i(63876);
        bv a = bv.a();
        if (a == null || !a.b()) {
            if (this.f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!bv.a().d()) {
                b bVar = new b();
                bVar.a = 2;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = null;
                if (this.a == null) {
                    this.a = new ArrayList();
                }
                this.a.add(bVar);
            }
            AppMethodBeat.o(63876);
        } else {
            a.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
            AppMethodBeat.o(63876);
        }
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        AppMethodBeat.i(63883);
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            AppMethodBeat.o(63883);
            return false;
        }
        this.c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (!(this.c == a.MODE_NONE || !z || bv.a().d())) {
            bv.a().a(context, null);
        }
        AppMethodBeat.o(63883);
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        AppMethodBeat.i(63881);
        bv a = bv.a();
        boolean a2 = (a == null || !a.b()) ? false : a.c().a((Map) map);
        if (!a2) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
        AppMethodBeat.o(63881);
    }
}
