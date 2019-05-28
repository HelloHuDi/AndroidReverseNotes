package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

/* renamed from: com.tencent.smtt.sdk.bs */
class C36436bs implements PictureListener {
    /* renamed from: a */
    final /* synthetic */ WebView.PictureListener f15168a;
    /* renamed from: b */
    final /* synthetic */ WebView f15169b;

    C36436bs(WebView webView, WebView.PictureListener pictureListener) {
        this.f15169b = webView;
        this.f15168a = pictureListener;
    }

    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
        AppMethodBeat.m2504i(64837);
        this.f15169b.mo49872a(iX5WebViewBase);
        this.f15168a.onNewPicture(this.f15169b, picture);
        AppMethodBeat.m2505o(64837);
    }

    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
    }
}
