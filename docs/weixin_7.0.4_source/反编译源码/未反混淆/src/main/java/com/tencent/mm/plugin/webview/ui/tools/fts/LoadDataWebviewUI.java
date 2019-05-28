package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.xweb.WebView;
import java.util.concurrent.CountDownLatch;

public class LoadDataWebviewUI extends PreLoadWebViewUI {
    private CountDownLatch uBY = new CountDownLatch(1);

    protected class a extends h {
        protected a() {
            super();
        }

        static /* synthetic */ void a(a aVar, WebView webView, String str) {
            AppMethodBeat.i(8555);
            super.b(webView, str);
            AppMethodBeat.o(8555);
        }

        static /* synthetic */ void a(a aVar, WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8554);
            super.b(webView, str, bitmap);
            AppMethodBeat.o(8554);
        }

        public void b(final WebView webView, final String str, final Bitmap bitmap) {
            AppMethodBeat.i(8552);
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8549);
                    try {
                        LoadDataWebviewUI.this.uBY.await();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("LoadDataWebviewUI", e, "", new Object[0]);
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8548);
                            a.a(a.this, webView, str, bitmap);
                            AppMethodBeat.o(8548);
                        }
                    });
                    AppMethodBeat.o(8549);
                }
            }, "LoadDataWebviewClient_onPageStarted");
            AppMethodBeat.o(8552);
        }

        public void b(final WebView webView, final String str) {
            AppMethodBeat.i(8553);
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8551);
                    try {
                        LoadDataWebviewUI.this.uBY.await();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("LoadDataWebviewUI", e, null, new Object[0]);
                    }
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8550);
                            a.a(a.this, webView, str);
                            AppMethodBeat.o(8550);
                        }
                    });
                    AppMethodBeat.o(8551);
                }
            }, "LoadDataWebviewClient_onPageStarted");
            AppMethodBeat.o(8553);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LoadDataWebviewUI() {
        AppMethodBeat.i(8556);
        AppMethodBeat.o(8556);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8557);
        super.onCreate(bundle);
        AppMethodBeat.o(8557);
    }

    public void aMh() {
        AppMethodBeat.i(8558);
        super.aMh();
        this.uBY.countDown();
        AppMethodBeat.o(8558);
    }
}
