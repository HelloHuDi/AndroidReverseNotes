package com.tencent.xweb.x5;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebChromeClient;

public class b extends WebChromeClient {
    public final void dVA() {
        AppMethodBeat.i(84796);
        super.onHideCustomView();
        AppMethodBeat.o(84796);
    }

    public View getVideoLoadingProgressView() {
        AppMethodBeat.i(84797);
        View videoLoadingProgressView = super.getVideoLoadingProgressView();
        AppMethodBeat.o(84797);
        return videoLoadingProgressView;
    }
}
