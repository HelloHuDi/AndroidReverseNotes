package com.tencent.xweb.p1115c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.C41127g;
import com.tencent.xweb.C46945h;

/* renamed from: com.tencent.xweb.c.e */
public interface C24524e {
    /* renamed from: a */
    boolean mo13220a(String str, String str2, C46945h c46945h);

    /* renamed from: a */
    boolean mo13221a(String str, String str2, String str3, C41127g c41127g);

    /* renamed from: b */
    boolean mo13222b(String str, String str2, C46945h c46945h);

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    /* renamed from: w */
    void mo13225w(String str, Bitmap bitmap);
}
