package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WebViewDatabase {
    private static WebViewDatabase a;
    private Context b;

    protected WebViewDatabase(Context context) {
        this.b = context;
    }

    private static synchronized WebViewDatabase a(Context context) {
        WebViewDatabase webViewDatabase;
        synchronized (WebViewDatabase.class) {
            AppMethodBeat.i(65034);
            if (a == null) {
                a = new WebViewDatabase(context);
            }
            webViewDatabase = a;
            AppMethodBeat.o(65034);
        }
        return webViewDatabase;
    }

    public static WebViewDatabase getInstance(Context context) {
        AppMethodBeat.i(65033);
        WebViewDatabase a = a(context);
        AppMethodBeat.o(65033);
        return a;
    }

    public void clearFormData() {
        AppMethodBeat.i(65040);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearFormData();
            AppMethodBeat.o(65040);
            return;
        }
        a.c().g(this.b);
        AppMethodBeat.o(65040);
    }

    public void clearHttpAuthUsernamePassword() {
        AppMethodBeat.i(65038);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearHttpAuthUsernamePassword();
            AppMethodBeat.o(65038);
            return;
        }
        a.c().e(this.b);
        AppMethodBeat.o(65038);
    }

    @Deprecated
    public void clearUsernamePassword() {
        AppMethodBeat.i(65036);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebViewDatabase.getInstance(this.b).clearUsernamePassword();
            AppMethodBeat.o(65036);
            return;
        }
        a.c().c(this.b);
        AppMethodBeat.o(65036);
    }

    public boolean hasFormData() {
        AppMethodBeat.i(65039);
        bv a = bv.a();
        boolean hasFormData;
        if (a == null || !a.b()) {
            hasFormData = android.webkit.WebViewDatabase.getInstance(this.b).hasFormData();
            AppMethodBeat.o(65039);
            return hasFormData;
        }
        hasFormData = a.c().f(this.b);
        AppMethodBeat.o(65039);
        return hasFormData;
    }

    public boolean hasHttpAuthUsernamePassword() {
        AppMethodBeat.i(65037);
        bv a = bv.a();
        boolean hasHttpAuthUsernamePassword;
        if (a == null || !a.b()) {
            hasHttpAuthUsernamePassword = android.webkit.WebViewDatabase.getInstance(this.b).hasHttpAuthUsernamePassword();
            AppMethodBeat.o(65037);
            return hasHttpAuthUsernamePassword;
        }
        hasHttpAuthUsernamePassword = a.c().d(this.b);
        AppMethodBeat.o(65037);
        return hasHttpAuthUsernamePassword;
    }

    @Deprecated
    public boolean hasUsernamePassword() {
        AppMethodBeat.i(65035);
        bv a = bv.a();
        boolean hasUsernamePassword;
        if (a == null || !a.b()) {
            hasUsernamePassword = android.webkit.WebViewDatabase.getInstance(this.b).hasUsernamePassword();
            AppMethodBeat.o(65035);
            return hasUsernamePassword;
        }
        hasUsernamePassword = a.c().b(this.b);
        AppMethodBeat.o(65035);
        return hasUsernamePassword;
    }
}
