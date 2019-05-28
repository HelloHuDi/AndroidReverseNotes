package com.tencent.xweb.c;

import android.content.Context;
import com.tencent.xweb.WebView;

public final class b {

    public interface a {
        void dTS();

        void f(WebView webView);

        String getCookie(String str);

        void removeAllCookie();

        void removeSessionCookie();

        void setCookie(String str, String str2);
    }

    public interface b {
        void init(Context context);

        void sync();
    }
}
