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
import com.tencent.smtt.utils.C30951r;
import com.tencent.smtt.utils.TbsLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    /* renamed from: d */
    private static CookieManager f17276d;
    /* renamed from: a */
    ArrayList<C44449b> f17277a;
    /* renamed from: b */
    String f17278b;
    /* renamed from: c */
    C24257a f17279c = C24257a.MODE_NONE;
    /* renamed from: e */
    private boolean f17280e = false;
    /* renamed from: f */
    private boolean f17281f = false;

    /* renamed from: com.tencent.smtt.sdk.CookieManager$a */
    public enum C24257a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL;

        static {
            AppMethodBeat.m2505o(63864);
        }
    }

    /* renamed from: com.tencent.smtt.sdk.CookieManager$b */
    class C44449b {
        /* renamed from: a */
        int f17271a;
        /* renamed from: b */
        String f17272b;
        /* renamed from: c */
        String f17273c;
        /* renamed from: d */
        ValueCallback<Boolean> f17274d;

        C44449b() {
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        AppMethodBeat.m2504i(63865);
        if (f17276d == null) {
            synchronized (CookieManager.class) {
                try {
                    if (f17276d == null) {
                        f17276d = new CookieManager();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(63865);
                    }
                }
            }
        }
        CookieManager cookieManager = f17276d;
        AppMethodBeat.m2505o(63865);
        return cookieManager;
    }

    public static int getROMCookieDBVersion(Context context) {
        AppMethodBeat.m2504i(63885);
        int i = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).getInt("db_version", -1);
        AppMethodBeat.m2505o(63885);
        return i;
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        AppMethodBeat.m2504i(63886);
        Editor edit = (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("cookiedb_info", 4) : context.getSharedPreferences("cookiedb_info", 0)).edit();
        edit.putInt("db_version", i);
        edit.commit();
        AppMethodBeat.m2505o(63886);
    }

    /* Access modifiers changed, original: declared_synchronized */
    /* renamed from: a */
    public synchronized void mo70587a() {
        AppMethodBeat.m2504i(63882);
        this.f17281f = true;
        if (this.f17277a == null || this.f17277a.size() == 0) {
            AppMethodBeat.m2505o(63882);
        } else {
            C40978bv a = C40978bv.m71073a();
            Iterator it;
            C44449b c44449b;
            if (a != null && a.mo64921b()) {
                it = this.f17277a.iterator();
                while (it.hasNext()) {
                    c44449b = (C44449b) it.next();
                    switch (c44449b.f17271a) {
                        case 1:
                            setCookie(c44449b.f17272b, c44449b.f17273c, c44449b.f17274d);
                            break;
                        case 2:
                            setCookie(c44449b.f17272b, c44449b.f17273c);
                            break;
                        default:
                            break;
                    }
                }
            }
            it = this.f17277a.iterator();
            while (it.hasNext()) {
                c44449b = (C44449b) it.next();
                switch (c44449b.f17271a) {
                    case 1:
                        if (VERSION.SDK_INT < 21) {
                            break;
                        }
                        C30951r.m49578a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, c44449b.f17272b, c44449b.f17273c, c44449b.f17274d);
                        break;
                    case 2:
                        android.webkit.CookieManager.getInstance().setCookie(c44449b.f17272b, c44449b.f17273c);
                        break;
                    default:
                        break;
                }
            }
            this.f17277a.clear();
            AppMethodBeat.m2505o(63882);
        }
    }

    /* Access modifiers changed, original: protected|declared_synchronized */
    /* renamed from: a */
    public synchronized void mo70588a(Context context, boolean z, boolean z2) {
        AppMethodBeat.m2504i(63884);
        if (this.f17279c == C24257a.MODE_NONE || context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) || this.f17280e) {
            AppMethodBeat.m2505o(63884);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long j = 0;
            TbsLog.m80434i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (z || QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f16239a) {
                if (QbSdk.getIsSysWebViewForcedByOuter() || QbSdk.f16239a) {
                    z2 = false;
                }
                boolean canUseFunction = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.USEX5_FILE_NAME);
                TbsLog.m80434i(LOGTAG, "usex5 : mUseX5LastProcess->" + canUseFunction + ",useX5:" + z2);
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
                if (canUseFunction == z2) {
                    AppMethodBeat.m2505o(63884);
                } else {
                    int i;
                    int i2;
                    TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                    if (TextUtils.isEmpty(this.f17278b)) {
                        tbsLogInfo.setErrorCode(701);
                        i = 0;
                        i2 = 0;
                    } else if (C5813an.m8800a().mo12179n(context) <= 0 || C5813an.m8800a().mo12179n(context) >= 36001) {
                        boolean z3;
                        if (canUseFunction) {
                            i2 = C16155x.m24508d(context);
                            if (i2 > 0) {
                                i = getROMCookieDBVersion(context);
                                z3 = i <= 0;
                            }
                            z3 = false;
                            i = 0;
                        } else {
                            i2 = C16155x.m24508d(context);
                            if (i2 > 0) {
                                String d = C5813an.m8800a().mo12167d(context, "cookies_database_version");
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
                            C16155x.m24505a(context, this.f17279c, this.f17278b, z3, z2);
                            tbsLogInfo.setErrorCode(704);
                            j = System.currentTimeMillis() - currentTimeMillis;
                        }
                    } else {
                        AppMethodBeat.m2505o(63884);
                    }
                    tbsLogInfo.setFailDetail("x5->sys:" + canUseFunction + " from:" + i2 + " to:" + i + ",timeused:" + j);
                    TbsLogReport.getInstance(context).eventReport(EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
                    AppMethodBeat.m2505o(63884);
                }
            } else {
                C40978bv.m71073a().mo64920a(context, null);
                AppMethodBeat.m2505o(63884);
            }
        }
    }

    public boolean acceptCookie() {
        AppMethodBeat.m2504i(63879);
        C40978bv a = C40978bv.m71073a();
        boolean acceptCookie;
        if (a == null || !a.mo64921b()) {
            acceptCookie = android.webkit.CookieManager.getInstance().acceptCookie();
            AppMethodBeat.m2505o(63879);
            return acceptCookie;
        }
        acceptCookie = a.mo64922c().mo57584d();
        AppMethodBeat.m2505o(63879);
        return acceptCookie;
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        boolean booleanValue;
        AppMethodBeat.m2504i(63874);
        C40978bv a = C40978bv.m71073a();
        Object invokeStaticMethod;
        if (a != null && a.mo64921b()) {
            invokeStaticMethod = a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod != null) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.m2505o(63874);
            } else {
                AppMethodBeat.m2505o(63874);
                booleanValue = true;
            }
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(63874);
            booleanValue = true;
        } else {
            invokeStaticMethod = C30951r.m49578a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            if (invokeStaticMethod != null) {
                booleanValue = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.m2505o(63874);
            } else {
                AppMethodBeat.m2505o(63874);
                booleanValue = false;
            }
        }
        return booleanValue;
    }

    public void flush() {
        AppMethodBeat.m2504i(63870);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
            AppMethodBeat.m2505o(63870);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(63870);
        } else {
            C30951r.m49578a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
            AppMethodBeat.m2505o(63870);
        }
    }

    public String getCookie(String str) {
        AppMethodBeat.m2504i(63880);
        C40978bv a = C40978bv.m71073a();
        String str2;
        if (a == null || !a.mo64921b()) {
            str2 = null;
            try {
                str2 = android.webkit.CookieManager.getInstance().getCookie(str);
            } catch (Throwable th) {
            }
            AppMethodBeat.m2505o(63880);
            return str2;
        }
        str2 = a.mo64922c().mo57560a(str);
        AppMethodBeat.m2505o(63880);
        return str2;
    }

    public boolean hasCookies() {
        AppMethodBeat.m2504i(63878);
        C40978bv a = C40978bv.m71073a();
        boolean hasCookies;
        if (a == null || !a.mo64921b()) {
            hasCookies = android.webkit.CookieManager.getInstance().hasCookies();
            AppMethodBeat.m2505o(63878);
            return hasCookies;
        }
        hasCookies = a.mo64922c().mo57597h();
        AppMethodBeat.m2505o(63878);
        return hasCookies;
    }

    public void removeAllCookie() {
        AppMethodBeat.m2504i(63868);
        if (this.f17277a != null) {
            this.f17277a.clear();
        }
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
            AppMethodBeat.m2505o(63868);
            return;
        }
        a.mo64922c().mo57586e();
        AppMethodBeat.m2505o(63868);
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(63869);
        if (this.f17277a != null) {
            this.f17277a.clear();
        }
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.m2505o(63869);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(63869);
        } else {
            C30951r.m49578a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.m2505o(63869);
        }
    }

    public void removeExpiredCookie() {
        AppMethodBeat.m2504i(63871);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
            AppMethodBeat.m2505o(63871);
            return;
        }
        a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(63871);
    }

    public void removeSessionCookie() {
        AppMethodBeat.m2504i(63866);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
            AppMethodBeat.m2505o(63866);
            return;
        }
        a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        AppMethodBeat.m2505o(63866);
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(63867);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.m2505o(63867);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(63867);
        } else {
            C30951r.m49578a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
            AppMethodBeat.m2505o(63867);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        AppMethodBeat.m2504i(63872);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                AppMethodBeat.m2505o(63872);
            } catch (Throwable th) {
                AppMethodBeat.m2505o(63872);
            }
        } else {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
            AppMethodBeat.m2505o(63872);
        }
        return;
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        AppMethodBeat.m2504i(63873);
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            AppMethodBeat.m2505o(63873);
        } else if (VERSION.SDK_INT < 21) {
            AppMethodBeat.m2505o(63873);
        } else {
            C30951r.m49578a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
            AppMethodBeat.m2505o(63873);
        }
    }

    public synchronized void setCookie(String str, String str2) {
        AppMethodBeat.m2504i(63875);
        setCookie(str, str2, false);
        AppMethodBeat.m2505o(63875);
    }

    public synchronized void setCookie(String str, String str2, ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.m2504i(63877);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            if (!C40978bv.m71073a().mo64923d()) {
                C44449b c44449b = new C44449b();
                c44449b.f17271a = 1;
                c44449b.f17272b = str;
                c44449b.f17273c = str2;
                c44449b.f17274d = valueCallback;
                if (this.f17277a == null) {
                    this.f17277a = new ArrayList();
                }
                this.f17277a.add(c44449b);
            }
            if (this.f17281f) {
                if (VERSION.SDK_INT < 21) {
                    AppMethodBeat.m2505o(63877);
                } else {
                    C30951r.m49578a(android.webkit.CookieManager.getInstance(), "setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
                }
            }
            AppMethodBeat.m2505o(63877);
        } else {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class, ValueCallback.class}, str, str2, valueCallback);
            AppMethodBeat.m2505o(63877);
        }
    }

    public synchronized void setCookie(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(63876);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            if (this.f17281f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!C40978bv.m71073a().mo64923d()) {
                C44449b c44449b = new C44449b();
                c44449b.f17271a = 2;
                c44449b.f17272b = str;
                c44449b.f17273c = str2;
                c44449b.f17274d = null;
                if (this.f17277a == null) {
                    this.f17277a = new ArrayList();
                }
                this.f17277a.add(c44449b);
            }
            AppMethodBeat.m2505o(63876);
        } else {
            a.mo64922c().mo57573b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new Class[]{String.class, String.class}, str, str2);
            AppMethodBeat.m2505o(63876);
        }
    }

    public boolean setCookieCompatialbeMode(Context context, C24257a c24257a, String str, boolean z) {
        AppMethodBeat.m2504i(63883);
        System.currentTimeMillis();
        if (context == null || !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            AppMethodBeat.m2505o(63883);
            return false;
        }
        this.f17279c = c24257a;
        if (str != null) {
            this.f17278b = str;
        }
        if (!(this.f17279c == C24257a.MODE_NONE || !z || C40978bv.m71073a().mo64923d())) {
            C40978bv.m71073a().mo64920a(context, null);
        }
        AppMethodBeat.m2505o(63883);
        return true;
    }

    public void setCookies(Map<String, String[]> map) {
        AppMethodBeat.m2504i(63881);
        C40978bv a = C40978bv.m71073a();
        boolean a2 = (a == null || !a.mo64921b()) ? false : a.mo64922c().mo57570a((Map) map);
        if (!a2) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
        AppMethodBeat.m2505o(63881);
    }
}
