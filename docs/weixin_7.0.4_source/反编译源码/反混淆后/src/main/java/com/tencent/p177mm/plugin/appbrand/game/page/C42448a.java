package com.tencent.p177mm.plugin.appbrand.game.page;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p297h.C2169j;
import com.tencent.p177mm.plugin.appbrand.p297h.C33211h;
import com.tencent.p177mm.plugin.appbrand.page.C27221aj;
import com.tencent.p177mm.plugin.appbrand.page.C38459ad;
import com.tencent.p177mm.plugin.appbrand.page.C38464c;
import com.tencent.p177mm.plugin.appbrand.page.C42643ae;
import com.tencent.p177mm.plugin.appbrand.page.C42644af;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.appbrand.game.page.a */
public final class C42448a implements C27221aj {
    private ViewGroup hsF;
    private ViewGroup hsG;

    /* renamed from: cE */
    public final void mo22182cE(Context context) {
        AppMethodBeat.m2504i(130216);
        if (this.hsF == null) {
            this.hsF = new FrameLayout(context);
        }
        if (this.hsG == null) {
            this.hsG = new FrameLayout(context);
        }
        AppMethodBeat.m2505o(130216);
    }

    public final View getWrapperView() {
        return this.hsF;
    }

    public final View getContentView() {
        return this.hsG;
    }

    /* renamed from: g */
    public final boolean mo22183g(Canvas canvas) {
        return false;
    }

    /* renamed from: H */
    public final void mo22176H(Runnable runnable) {
    }

    /* renamed from: bU */
    public final void mo22181bU(String str, String str2) {
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

    /* renamed from: a */
    public final void mo14967a(URL url, String str, ValueCallback<String> valueCallback) {
    }

    /* renamed from: a */
    public final void mo14968a(URL url, String str, String str2, String str3, ValueCallback<String> valueCallback) {
    }

    public final void setJsExceptionHandler(C33211h c33211h) {
    }

    public final void destroy() {
    }

    /* renamed from: af */
    public final <T extends C2169j> T mo14970af(Class<T> cls) {
        return null;
    }

    /* renamed from: wU */
    public final void mo22196wU() {
    }

    /* renamed from: wW */
    public final void mo22197wW() {
    }

    public final void setOnScrollChangedListener(C42644af c42644af) {
    }

    public final void setWebViewLayoutListener(C38459ad c38459ad) {
    }

    public final void setOnTrimListener(C42643ae c42643ae) {
    }

    public final void aAM() {
    }

    /* renamed from: z */
    public final void mo22198z(int i, long j) {
    }

    public final void setFullscreenImpl(C38464c c38464c) {
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
