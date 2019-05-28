package com.tencent.xweb.c;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.xweb.g;
import com.tencent.xweb.h;

public interface e {
    boolean a(String str, String str2, h hVar);

    boolean a(String str, String str2, String str3, g gVar);

    boolean b(String str, String str2, h hVar);

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);

    void w(String str, Bitmap bitmap);
}
