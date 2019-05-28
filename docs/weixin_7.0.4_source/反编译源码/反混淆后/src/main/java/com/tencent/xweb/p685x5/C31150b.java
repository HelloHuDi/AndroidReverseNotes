package com.tencent.xweb.p685x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient;

/* renamed from: com.tencent.xweb.x5.b */
public class C31150b extends WebChromeClient {
    public final void dVA() {
        AppMethodBeat.m2504i(84796);
        super.onHideCustomView();
        AppMethodBeat.m2505o(84796);
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.m2504i(84797);
        View videoLoadingProgressView = super.getVideoLoadingProgressView();
        AppMethodBeat.m2505o(84797);
        return videoLoadingProgressView;
    }
}
