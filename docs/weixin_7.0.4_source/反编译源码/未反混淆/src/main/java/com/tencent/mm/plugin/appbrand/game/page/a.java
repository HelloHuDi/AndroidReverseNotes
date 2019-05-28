package com.tencent.mm.plugin.appbrand.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.h;
import com.tencent.mm.plugin.appbrand.h.j;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.c;
import java.net.URL;

public final class a implements aj {
    private ViewGroup hsF;
    private ViewGroup hsG;

    public final void cE(Context context) {
        AppMethodBeat.i(130216);
        if (this.hsF == null) {
            this.hsF = new FrameLayout(context);
        }
        if (this.hsG == null) {
            this.hsG = new FrameLayout(context);
        }
        AppMethodBeat.o(130216);
    }

    public final View getWrapperView() {
        return this.hsF;
    }

    public final View getContentView() {
        return this.hsG;
    }

    public final boolean g(Canvas canvas) {
        return false;
    }

    public final void H(Runnable runnable) {
    }

    public final void bU(String str, String str2) {
    }

    public final String getUserAgentString() {
        return "MiniGame";
    }

    public final int getWidth() {
        return 0;
    }

    public final int getHeight() {
        return 0;
    }

    public final int getContentHeight() {
        return 0;
    }

    public final int getWebScrollX() {
        return 0;
    }

    public final int getWebScrollY() {
        return 0;
    }

    public final void setTitle(String str) {
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
    }

    public final void a(URL url, String str, ValueCallback<String> valueCallback) {
    }

    public final void a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
    }

    public final void setJsExceptionHandler(h hVar) {
    }

    public final void destroy() {
    }

    public final <T extends j> T af(Class<T> cls) {
        return null;
    }

    public final void wU() {
    }

    public final void wW() {
    }

    public final void setOnScrollChangedListener(af afVar) {
    }

    public final void setWebViewLayoutListener(ad adVar) {
    }

    public final void setOnTrimListener(ae aeVar) {
    }

    public final void aAM() {
    }

    public final void z(int i, long j) {
    }

    public final void setFullscreenImpl(c cVar) {
    }

    public final boolean aAN() {
        return false;
    }

    public final boolean aAO() {
        return false;
    }

    public final void setVerticalScrollBarEnabled(boolean z) {
    }

    public final boolean aAP() {
        return false;
    }
}
