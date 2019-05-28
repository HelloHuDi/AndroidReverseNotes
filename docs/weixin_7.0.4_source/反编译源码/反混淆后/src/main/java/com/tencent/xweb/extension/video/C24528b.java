package com.tencent.xweb.extension.video;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;

/* renamed from: com.tencent.xweb.extension.video.b */
public interface C24528b {
    /* renamed from: am */
    void mo30114am(boolean z, boolean z2);

    /* renamed from: dh */
    void mo30115dh(Object obj);

    boolean hasEnteredFullscreen();

    void onHideCustomView();

    void onShowCustomView(View view, CustomViewCallback customViewCallback);
}
