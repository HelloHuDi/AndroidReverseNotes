package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

public interface b {
    void am(boolean z, boolean z2);

    void dh(Object obj);

    boolean hasEnteredFullscreen();

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);
}
