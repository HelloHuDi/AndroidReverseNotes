package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class bs implements PictureListener {
    final /* synthetic */ WebView.PictureListener a;
    final /* synthetic */ WebView b;

    bs(WebView webView, WebView.PictureListener pictureListener) {
        this.b = webView;
        this.a = pictureListener;
    }

    public void onNewPicture(IX5WebViewBase iX5WebViewBase, Picture picture, boolean z) {
        AppMethodBeat.i(64837);
        this.b.a(iX5WebViewBase);
        this.a.onNewPicture(this.b, picture);
        AppMethodBeat.o(64837);
    }

    public void onNewPictureIfHaveContent(IX5WebViewBase iX5WebViewBase, Picture picture) {
    }
}
