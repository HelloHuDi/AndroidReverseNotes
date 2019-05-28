package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class WebIconDatabase {
    /* renamed from: a */
    private static WebIconDatabase f1393a;

    @Deprecated
    /* renamed from: com.tencent.smtt.sdk.WebIconDatabase$a */
    public interface C5810a {
        /* renamed from: a */
        void mo12144a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    /* renamed from: a */
    private static synchronized WebIconDatabase m8791a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            AppMethodBeat.m2504i(64708);
            if (f1393a == null) {
                f1393a = new WebIconDatabase();
            }
            webIconDatabase = f1393a;
            AppMethodBeat.m2505o(64708);
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        AppMethodBeat.m2504i(64707);
        WebIconDatabase a = m8791a();
        AppMethodBeat.m2505o(64707);
        return a;
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, C5810a c5810a) {
    }

    public void close() {
        AppMethodBeat.m2504i(64702);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().close();
            AppMethodBeat.m2505o(64702);
            return;
        }
        a.mo64922c().mo57608m();
        AppMethodBeat.m2505o(64702);
    }

    public void open(String str) {
        AppMethodBeat.m2504i(64701);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
            AppMethodBeat.m2505o(64701);
            return;
        }
        a.mo64922c().mo57576b(str);
        AppMethodBeat.m2505o(64701);
    }

    public void releaseIconForPageUrl(String str) {
        AppMethodBeat.m2504i(64706);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
            AppMethodBeat.m2505o(64706);
            return;
        }
        a.mo64922c().mo57583d(str);
        AppMethodBeat.m2505o(64706);
    }

    public void removeAllIcons() {
        AppMethodBeat.m2504i(64703);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
            AppMethodBeat.m2505o(64703);
            return;
        }
        a.mo64922c().mo57606l();
        AppMethodBeat.m2505o(64703);
    }

    public void requestIconForPageUrl(String str, C5810a c5810a) {
        AppMethodBeat.m2504i(64704);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new C46738bl(this, c5810a));
            AppMethodBeat.m2505o(64704);
            return;
        }
        a.mo64922c().mo57566a(str, new C40976bk(this, c5810a));
        AppMethodBeat.m2505o(64704);
    }

    public void retainIconForPageUrl(String str) {
        AppMethodBeat.m2504i(64705);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
            AppMethodBeat.m2505o(64705);
            return;
        }
        a.mo64922c().mo57581c(str);
        AppMethodBeat.m2505o(64705);
    }
}
