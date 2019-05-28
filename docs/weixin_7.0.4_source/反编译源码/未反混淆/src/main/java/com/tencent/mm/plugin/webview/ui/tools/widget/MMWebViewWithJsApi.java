package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.s;

public class MMWebViewWithJsApi extends MMWebView {
    private k uJK;
    private boolean uJL;

    public static class a {
        public static MMWebViewWithJsApi fv(Context context) {
            AppMethodBeat.i(138980);
            MMWebViewWithJsApi fw = fw(context);
            AppMethodBeat.o(138980);
            return fw;
        }

        public static MMWebViewWithJsApi fw(Context context) {
            AppMethodBeat.i(10029);
            MMWebViewWithJsApi.fu(context);
            MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(context);
            mMWebViewWithJsApi.inited = true;
            AppMethodBeat.o(10029);
            return mMWebViewWithJsApi;
        }
    }

    static /* synthetic */ void fu(Context context) {
        AppMethodBeat.i(10036);
        MMWebView.il(context);
        AppMethodBeat.o(10036);
    }

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(10030);
        this.uJL = true;
        dKG();
        getSettings().setJavaScriptEnabled(true);
        getSettings().dUj();
        setWebChromeClient(new i(this));
        setWebViewClient(new k(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!u.akj(userAgentString)) {
            getSettings().setUserAgentString(u.bh(getContext(), userAgentString));
        }
        AppMethodBeat.o(10030);
    }

    public d getJsapi() {
        if (this.uJK != null) {
            return this.uJK.uDd;
        }
        return null;
    }

    public void setWebViewClient(s sVar) {
        AppMethodBeat.i(10031);
        super.setWebViewClient(sVar);
        if (sVar instanceof k) {
            this.uJK = (k) sVar;
            AppMethodBeat.o(10031);
            return;
        }
        this.uJK = null;
        AppMethodBeat.o(10031);
    }

    public void setCleanOnDetached(boolean z) {
        this.uJL = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(10032);
        super.onDetachedFromWindow();
        if (this.uJK != null && this.uJL) {
            this.uJK.cleanup();
        }
        AppMethodBeat.o(10032);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.i(10033);
        if (this.uJK != null) {
            this.uJK.of(true);
            this.uJK.agc("");
        }
        super.loadData(str, str2, str3);
        AppMethodBeat.o(10033);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(10034);
        if (this.uJK != null) {
            this.uJK.of(true);
            this.uJK.agc("");
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.o(10034);
    }

    /* JADX WARNING: Missing block: B:3:0x0015, code skipped:
            if (r3.uJK.agc(r4) == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUrl(String str) {
        AppMethodBeat.i(10035);
        if (this.uJK != null) {
            this.uJK.of(false);
        }
        super.loadUrl(str);
        AppMethodBeat.o(10035);
    }
}
