package com.tencent.smtt.sdk;

import android.graphics.Picture;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.smtt.sdk.br */
class C5816br implements PictureListener {
    /* renamed from: a */
    final /* synthetic */ WebView.PictureListener f1417a;
    /* renamed from: b */
    final /* synthetic */ WebView f1418b;

    C5816br(WebView webView, WebView.PictureListener pictureListener) {
        this.f1418b = webView;
        this.f1417a = pictureListener;
    }

    public void onNewPicture(WebView webView, Picture picture) {
        AppMethodBeat.m2504i(64836);
        this.f1418b.mo49871a(webView);
        this.f1417a.onNewPicture(this.f1418b, picture);
        AppMethodBeat.m2505o(64836);
    }
}
