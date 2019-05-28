package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewDatabase {
    /* renamed from: a */
    private static WebViewDatabase f13897a;
    /* renamed from: b */
    private Context f13898b;

    protected WebViewDatabase(Context context) {
        this.f13898b = context;
    }

    /* renamed from: a */
    private static synchronized WebViewDatabase m49511a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            AppMethodBeat.m2504i(65034);
            if (f13897a == null) {
                f13897a = new WebViewDatabase(context);
            }
            webViewDatabase = f13897a;
            AppMethodBeat.m2505o(65034);
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        AppMethodBeat.m2504i(65033);
        WebViewDatabase a = m49511a(context);
        AppMethodBeat.m2505o(65033);
        return a;
    }

    public void clearFormData() {
        AppMethodBeat.m2504i(65040);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebViewDatabase.getInstance(this.f13898b).clearFormData();
            AppMethodBeat.m2505o(65040);
            return;
        }
        a.mo64922c().mo57593g(this.f13898b);
        AppMethodBeat.m2505o(65040);
    }

    public void clearHttpAuthUsernamePassword() {
        AppMethodBeat.m2504i(65038);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebViewDatabase.getInstance(this.f13898b).clearHttpAuthUsernamePassword();
            AppMethodBeat.m2505o(65038);
            return;
        }
        a.mo64922c().mo57587e(this.f13898b);
        AppMethodBeat.m2505o(65038);
    }

    @Deprecated
    public void clearUsernamePassword() {
        AppMethodBeat.m2504i(65036);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebViewDatabase.getInstance(this.f13898b).clearUsernamePassword();
            AppMethodBeat.m2505o(65036);
            return;
        }
        a.mo64922c().mo57580c(this.f13898b);
        AppMethodBeat.m2505o(65036);
    }

    public boolean hasFormData() {
        AppMethodBeat.m2504i(65039);
        C40978bv a = C40978bv.m71073a();
        boolean hasFormData;
        if (a == null || !a.mo64921b()) {
            hasFormData = android.webkit.WebViewDatabase.getInstance(this.f13898b).hasFormData();
            AppMethodBeat.m2505o(65039);
            return hasFormData;
        }
        hasFormData = a.mo64922c().mo57591f(this.f13898b);
        AppMethodBeat.m2505o(65039);
        return hasFormData;
    }

    public boolean hasHttpAuthUsernamePassword() {
        AppMethodBeat.m2504i(65037);
        C40978bv a = C40978bv.m71073a();
        boolean hasHttpAuthUsernamePassword;
        if (a == null || !a.mo64921b()) {
            hasHttpAuthUsernamePassword = android.webkit.WebViewDatabase.getInstance(this.f13898b).hasHttpAuthUsernamePassword();
            AppMethodBeat.m2505o(65037);
            return hasHttpAuthUsernamePassword;
        }
        hasHttpAuthUsernamePassword = a.mo64922c().mo57585d(this.f13898b);
        AppMethodBeat.m2505o(65037);
        return hasHttpAuthUsernamePassword;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        AppMethodBeat.m2504i(65035);
        C40978bv a = C40978bv.m71073a();
        boolean hasUsernamePassword;
        if (a == null || !a.mo64921b()) {
            hasUsernamePassword = android.webkit.WebViewDatabase.getInstance(this.f13898b).hasUsernamePassword();
            AppMethodBeat.m2505o(65035);
            return hasUsernamePassword;
        }
        hasUsernamePassword = a.mo64922c().mo57578b(this.f13898b);
        AppMethodBeat.m2505o(65035);
        return hasUsernamePassword;
    }
}
