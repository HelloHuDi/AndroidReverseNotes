package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.xweb.WebView;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI */
public class LoadDataWebviewUI extends PreLoadWebViewUI {
    private CountDownLatch uBY = new CountDownLatch(1);

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI$a */
    protected class C22964a extends C14579h {
        protected C22964a() {
            super();
        }

        /* renamed from: a */
        static /* synthetic */ void m34837a(C22964a c22964a, WebView webView, String str) {
            AppMethodBeat.m2504i(8555);
            super.mo5992b(webView, str);
            AppMethodBeat.m2505o(8555);
        }

        /* renamed from: a */
        static /* synthetic */ void m34838a(C22964a c22964a, WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8554);
            super.mo7562b(webView, str, bitmap);
            AppMethodBeat.m2505o(8554);
        }

        /* renamed from: b */
        public void mo7562b(final WebView webView, final String str, final Bitmap bitmap) {
            AppMethodBeat.m2504i(8552);
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI$a$1$1 */
                class C229611 implements Runnable {
                    C229611() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(8548);
                        C22964a.m34838a(C22964a.this, webView, str, bitmap);
                        AppMethodBeat.m2505o(8548);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(8549);
                    try {
                        LoadDataWebviewUI.this.uBY.await();
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("LoadDataWebviewUI", e, "", new Object[0]);
                    }
                    C5004al.m7441d(new C229611());
                    AppMethodBeat.m2505o(8549);
                }
            }, "LoadDataWebviewClient_onPageStarted");
            AppMethodBeat.m2505o(8552);
        }

        /* renamed from: b */
        public void mo5992b(final WebView webView, final String str) {
            AppMethodBeat.m2504i(8553);
            C7305d.post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.LoadDataWebviewUI$a$2$1 */
                class C229631 implements Runnable {
                    C229631() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(8550);
                        C22964a.m34837a(C22964a.this, webView, str);
                        AppMethodBeat.m2505o(8550);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(8551);
                    try {
                        LoadDataWebviewUI.this.uBY.await();
                    } catch (InterruptedException e) {
                        C4990ab.printErrStackTrace("LoadDataWebviewUI", e, null, new Object[0]);
                    }
                    C5004al.m7441d(new C229631());
                    AppMethodBeat.m2505o(8551);
                }
            }, "LoadDataWebviewClient_onPageStarted");
            AppMethodBeat.m2505o(8553);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LoadDataWebviewUI() {
        AppMethodBeat.m2504i(8556);
        AppMethodBeat.m2505o(8556);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8557);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(8557);
    }

    public void aMh() {
        AppMethodBeat.m2504i(8558);
        super.aMh();
        this.uBY.countDown();
        AppMethodBeat.m2505o(8558);
    }
}
