package com.tencent.mm.plugin.webview.ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.xweb.WebView;

public class GameBaseWebViewUI extends WebViewUI {
    private c mUY = new c() {
        /* Access modifiers changed, original: protected|final */
        public final void I(Bundle bundle) {
            AppMethodBeat.i(8634);
            try {
                if (!(GameBaseWebViewUI.this.icy == null || bundle == null)) {
                    GameBaseWebViewUI.this.icy.g(96, bundle);
                }
                AppMethodBeat.o(8634);
            } catch (RemoteException e) {
                AppMethodBeat.o(8634);
            }
        }
    };
    protected a uCU;

    protected class a extends h {
        protected a() {
            super();
        }

        public void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8635);
            GameBaseWebViewUI.this.mUY.uDp.dbY();
            super.b(webView, str, bitmap);
            AppMethodBeat.o(8635);
        }

        public void b(WebView webView, String str) {
            AppMethodBeat.i(8636);
            super.b(webView, str);
            GameBaseWebViewUI.this.mUY.uDp.dbZ();
            AppMethodBeat.o(8636);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameBaseWebViewUI() {
        AppMethodBeat.i(8637);
        AppMethodBeat.o(8637);
    }

    public final void ab(Bundle bundle) {
        AppMethodBeat.i(8638);
        this.mUY.uDp.ao(bundle);
        AppMethodBeat.o(8638);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(8639);
        super.onCreate(bundle);
        AppMethodBeat.o(8639);
    }

    public void onResume() {
        AppMethodBeat.i(8640);
        this.mUY.uDp.onResume();
        if (this.uCU != null) {
            a aVar = this.uCU;
            aVar.mUY.uDp.onResume();
            aVar.mUZ = System.currentTimeMillis();
        }
        super.onResume();
        AppMethodBeat.o(8640);
    }

    public void onPause() {
        AppMethodBeat.i(8641);
        super.onPause();
        this.mUY.uDp.onPause();
        if (this.uCU != null) {
            a aVar = this.uCU;
            aVar.mUY.uDp.onPause();
            GameWebPerformanceInfo gameWebPerformanceInfo = aVar.mUN;
            gameWebPerformanceInfo.eCj += System.currentTimeMillis() - aVar.mUZ;
            aVar.mUZ = System.currentTimeMillis();
        }
        AppMethodBeat.o(8641);
    }

    public void onDestroy() {
        AppMethodBeat.i(8642);
        c.a(c.this);
        if (this.uCU != null) {
            this.uCU.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(8642);
    }

    public final boolean aMj() {
        return true;
    }
}
