package com.tencent.p177mm.plugin.webview.p580ui.tools.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.xweb.C36592s;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi */
public class MMWebViewWithJsApi extends MMWebView {
    private C43989k uJK;
    private boolean uJL;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi$a */
    public static class C14670a {
        /* renamed from: fv */
        public static MMWebViewWithJsApi m22875fv(Context context) {
            AppMethodBeat.m2504i(138980);
            MMWebViewWithJsApi fw = C14670a.m22876fw(context);
            AppMethodBeat.m2505o(138980);
            return fw;
        }

        /* renamed from: fw */
        public static MMWebViewWithJsApi m22876fw(Context context) {
            AppMethodBeat.m2504i(10029);
            MMWebViewWithJsApi.m22874fu(context);
            MMWebViewWithJsApi mMWebViewWithJsApi = new MMWebViewWithJsApi(context);
            mMWebViewWithJsApi.inited = true;
            AppMethodBeat.m2505o(10029);
            return mMWebViewWithJsApi;
        }
    }

    /* renamed from: fu */
    static /* synthetic */ void m22874fu(Context context) {
        AppMethodBeat.m2504i(10036);
        MMWebView.m49133il(context);
        AppMethodBeat.m2505o(10036);
    }

    public MMWebViewWithJsApi(Context context) {
        this(context, null);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMWebViewWithJsApi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(10030);
        this.uJL = true;
        dKG();
        getSettings().setJavaScriptEnabled(true);
        getSettings().dUj();
        setWebChromeClient(new C14672i(this));
        setWebViewClient(new C43989k(this));
        String userAgentString = getSettings().getUserAgentString();
        if (!C30152u.akj(userAgentString)) {
            getSettings().setUserAgentString(C30152u.m47747bh(getContext(), userAgentString));
        }
        AppMethodBeat.m2505o(10030);
    }

    public C44786d getJsapi() {
        if (this.uJK != null) {
            return this.uJK.uDd;
        }
        return null;
    }

    public void setWebViewClient(C36592s c36592s) {
        AppMethodBeat.m2504i(10031);
        super.setWebViewClient(c36592s);
        if (c36592s instanceof C43989k) {
            this.uJK = (C43989k) c36592s;
            AppMethodBeat.m2505o(10031);
            return;
        }
        this.uJK = null;
        AppMethodBeat.m2505o(10031);
    }

    public void setCleanOnDetached(boolean z) {
        this.uJL = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(10032);
        super.onDetachedFromWindow();
        if (this.uJK != null && this.uJL) {
            this.uJK.cleanup();
        }
        AppMethodBeat.m2505o(10032);
    }

    public void loadData(String str, String str2, String str3) {
        AppMethodBeat.m2504i(10033);
        if (this.uJK != null) {
            this.uJK.mo69681of(true);
            this.uJK.agc("");
        }
        super.loadData(str, str2, str3);
        AppMethodBeat.m2505o(10033);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(10034);
        if (this.uJK != null) {
            this.uJK.mo69681of(true);
            this.uJK.agc("");
        }
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        AppMethodBeat.m2505o(10034);
    }

    /* JADX WARNING: Missing block: B:3:0x0015, code skipped:
            if (r3.uJK.agc(r4) == false) goto L_0x0017;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void loadUrl(String str) {
        AppMethodBeat.m2504i(10035);
        if (this.uJK != null) {
            this.uJK.mo69681of(false);
        }
        super.loadUrl(str);
        AppMethodBeat.m2505o(10035);
    }
}
