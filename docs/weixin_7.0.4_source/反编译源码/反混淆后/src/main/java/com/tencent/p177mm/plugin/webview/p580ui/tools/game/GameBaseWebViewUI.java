package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI */
public class GameBaseWebViewUI extends WebViewUI {
    private C14610c mUY = new C46121();
    protected C22971a uCU;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI$a */
    protected class C4611a extends C14579h {
        protected C4611a() {
            super();
        }

        /* renamed from: b */
        public void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8635);
            GameBaseWebViewUI.this.mUY.uDp.dbY();
            super.mo7562b(webView, str, bitmap);
            AppMethodBeat.m2505o(8635);
        }

        /* renamed from: b */
        public void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(8636);
            super.mo5992b(webView, str);
            GameBaseWebViewUI.this.mUY.uDp.dbZ();
            AppMethodBeat.m2505o(8636);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameBaseWebViewUI$1 */
    class C46121 extends C14610c {
        C46121() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: I */
        public final void mo9702I(Bundle bundle) {
            AppMethodBeat.m2504i(8634);
            try {
                if (!(GameBaseWebViewUI.this.icy == null || bundle == null)) {
                    GameBaseWebViewUI.this.icy.mo15575g(96, bundle);
                }
                AppMethodBeat.m2505o(8634);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(8634);
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameBaseWebViewUI() {
        AppMethodBeat.m2504i(8637);
        AppMethodBeat.m2505o(8637);
    }

    /* renamed from: ab */
    public final void mo9701ab(Bundle bundle) {
        AppMethodBeat.m2504i(8638);
        this.mUY.uDp.mo26864ao(bundle);
        AppMethodBeat.m2505o(8638);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(8639);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(8639);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8640);
        this.mUY.uDp.onResume();
        if (this.uCU != null) {
            C22971a c22971a = this.uCU;
            c22971a.mUY.uDp.onResume();
            c22971a.mUZ = System.currentTimeMillis();
        }
        super.onResume();
        AppMethodBeat.m2505o(8640);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8641);
        super.onPause();
        this.mUY.uDp.onPause();
        if (this.uCU != null) {
            C22971a c22971a = this.uCU;
            c22971a.mUY.uDp.onPause();
            GameWebPerformanceInfo gameWebPerformanceInfo = c22971a.mUN;
            gameWebPerformanceInfo.eCj += System.currentTimeMillis() - c22971a.mUZ;
            c22971a.mUZ = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(8641);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8642);
        C14610c.m22839a(C14610c.this);
        if (this.uCU != null) {
            this.uCU.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(8642);
    }

    public final boolean aMj() {
        return true;
    }
}
