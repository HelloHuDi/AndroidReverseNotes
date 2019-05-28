package com.tencent.smtt.sdk;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class WebIconDatabase {
    private static WebIconDatabase a;

    @Deprecated
    public interface a {
        void a(String str, Bitmap bitmap);
    }

    private WebIconDatabase() {
    }

    private static synchronized WebIconDatabase a() {
        WebIconDatabase webIconDatabase;
        synchronized (WebIconDatabase.class) {
            AppMethodBeat.i(64708);
            if (a == null) {
                a = new WebIconDatabase();
            }
            webIconDatabase = a;
            AppMethodBeat.o(64708);
        }
        return webIconDatabase;
    }

    public static WebIconDatabase getInstance() {
        AppMethodBeat.i(64707);
        WebIconDatabase a = a();
        AppMethodBeat.o(64707);
        return a;
    }

    public void bulkRequestIconForPageUrl(ContentResolver contentResolver, String str, a aVar) {
    }

    public void close() {
        AppMethodBeat.i(64702);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().close();
            AppMethodBeat.o(64702);
            return;
        }
        a.c().m();
        AppMethodBeat.o(64702);
    }

    public void open(String str) {
        AppMethodBeat.i(64701);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().open(str);
            AppMethodBeat.o(64701);
            return;
        }
        a.c().b(str);
        AppMethodBeat.o(64701);
    }

    public void releaseIconForPageUrl(String str) {
        AppMethodBeat.i(64706);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().releaseIconForPageUrl(str);
            AppMethodBeat.o(64706);
            return;
        }
        a.c().d(str);
        AppMethodBeat.o(64706);
    }

    public void removeAllIcons() {
        AppMethodBeat.i(64703);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().removeAllIcons();
            AppMethodBeat.o(64703);
            return;
        }
        a.c().l();
        AppMethodBeat.o(64703);
    }

    public void requestIconForPageUrl(String str, a aVar) {
        AppMethodBeat.i(64704);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().requestIconForPageUrl(str, new bl(this, aVar));
            AppMethodBeat.o(64704);
            return;
        }
        a.c().a(str, new bk(this, aVar));
        AppMethodBeat.o(64704);
    }

    public void retainIconForPageUrl(String str) {
        AppMethodBeat.i(64705);
        bv a = bv.a();
        if (a == null || !a.b()) {
            android.webkit.WebIconDatabase.getInstance().retainIconForPageUrl(str);
            AppMethodBeat.o(64705);
            return;
        }
        a.c().c(str);
        AppMethodBeat.o(64705);
    }
}
