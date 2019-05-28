package com.tencent.xweb.p1115c;

import android.content.Context;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.xweb.c.b */
public final class C44577b {

    /* renamed from: com.tencent.xweb.c.b$a */
    public interface C36584a {
        void dTS();

        /* renamed from: f */
        void mo41325f(WebView webView);

        String getCookie(String str);

        void removeAllCookie();

        void removeSessionCookie();

        void setCookie(String str, String str2);
    }

    /* renamed from: com.tencent.xweb.c.b$b */
    public interface C36585b {
        void init(Context context);

        void sync();
    }
}
