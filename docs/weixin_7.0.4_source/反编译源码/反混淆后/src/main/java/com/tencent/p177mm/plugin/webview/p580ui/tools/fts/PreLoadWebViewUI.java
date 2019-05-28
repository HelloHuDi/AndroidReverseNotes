package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p612ui.widget.MMWebView.C30798a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C35571ah;
import com.tencent.p177mm.plugin.websearch.api.C35575ap;
import com.tencent.p177mm.plugin.websearch.api.C4510aj;
import com.tencent.p177mm.plugin.websearch.api.C4513al;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C14579h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C23001a;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI */
public abstract class PreLoadWebViewUI extends WebViewUI {
    protected String cIy;
    protected String cvF;
    boolean uCf;
    CountDownLatch uCg = new CountDownLatch(dbI() + 2);
    private C35571ah uCh;
    private int uaJ = -1;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI$2 */
    class C145992 implements Runnable {
        C145992() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8560);
            try {
                PreLoadWebViewUI.this.uCg.await();
            } catch (InterruptedException e) {
                C4990ab.printErrStackTrace("PreLoadWebViewUI", e, "", new Object[0]);
            }
            if (PreLoadWebViewUI.this.uCf) {
                C4990ab.m7416i("PreLoadWebViewUI", "send onUiInit to webview");
                PreLoadWebViewUI.this.dbE();
                PreLoadWebViewUI.this.uhz.mo71894aK(PreLoadWebViewUI.this.dbP());
            }
            AppMethodBeat.m2505o(8560);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI$1 */
    class C299031 implements C23001a {
        C299031() {
        }

        public final void onReady() {
            AppMethodBeat.m2504i(8559);
            PreLoadWebViewUI.this.dbO();
            AppMethodBeat.m2505o(8559);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI$a */
    protected class C35671a extends C14579h {
        protected C35671a() {
            super();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (TextUtils.isEmpty(this.cvF)) {
            this.cvF = getIntent().getStringExtra("sessionId");
            this.cIy = getIntent().getStringExtra("subSessionId");
            if (TextUtils.isEmpty(this.cIy)) {
                this.cIy = this.cvF;
            }
        }
    }

    public final C35571ah dap() {
        return this.uCh;
    }

    public final MMWebView aXX() {
        C4513al c4513al;
        C35571ah c35571ah;
        Intent intent = getIntent();
        if (intent != null) {
            this.uaJ = intent.getIntExtra("key_preload_biz", -1);
            C4990ab.m7417i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", Integer.valueOf(this.uaJ));
            c4513al = (C4513al) C4510aj.cVp().mo9576Ih(this.uaJ).mo38329fn(this);
        } else {
            c4513al = null;
        }
        MMWebView mMWebView = c4513al == null ? null : (MMWebView) c4513al.uaQ;
        if (c4513al == null) {
            c35571ah = null;
        } else {
            c35571ah = c4513al.uaR;
        }
        this.uCh = c35571ah;
        if (mMWebView == null) {
            C4990ab.m7416i("PreLoadWebViewUI", "no available preloaded webview");
            this.uCf = false;
            String cWL = cWL();
            int i = !TextUtils.isEmpty(cWL) ? C5046bo.ank(Uri.parse(cWL).getQueryParameter("isOpenPreload")) == 1 ? 1 : 0 : 0;
            if (i != 0) {
                C7060h.pYm.mo8381e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(4), Integer.valueOf(0));
            }
            if (this.uaJ == 2) {
                return C30798a.m49145in(this);
            }
            try {
                return C35575ap.cVF().cVG() ? C30798a.m49144im(this) : C30798a.m49145in(this);
            } catch (Exception e) {
                return C30798a.m49145in(this);
            }
        }
        C4990ab.m7417i("PreLoadWebViewUI", "use preloaded webview ,%s ", mMWebView.toString());
        this.uCf = true;
        C7060h.pYm.mo8381e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(3), Integer.valueOf(0));
        return mMWebView;
    }

    public void aMh() {
        super.aMh();
        this.uCg.countDown();
        if (this.uhz == null || this.uhz.ready) {
            dbO();
        } else {
            this.uhz.mo71883a(new C299031());
        }
        if (!C4872b.dnO()) {
            return;
        }
        if (this.uCf) {
            C23639t.makeText(C4996ah.getContext(), "use preloaded webview(安装coolassist时弹出), sys " + C35575ap.cVF().cVG(), 1).show();
        } else {
            C23639t.makeText(C4996ah.getContext(), "no preloaded webview(安装coolassist时弹出), sys " + C35575ap.cVF().cVG(), 1).show();
        }
    }

    public void onResume() {
        super.onResume();
        this.uCg.countDown();
    }

    public final boolean aYd() {
        return this.uCf;
    }

    public final void daq() {
        this.uCf = false;
    }

    /* Access modifiers changed, original: protected */
    public Map<String, Object> dbJ() {
        return null;
    }

    public int dbI() {
        return 0;
    }

    /* Access modifiers changed, original: protected */
    public void dbE() {
    }

    public final void daF() {
        C7060h.pYm.mo8381e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(5), Integer.valueOf(0));
    }

    /* Access modifiers changed, original: protected */
    public C44786d getJsapi() {
        return this.uhz;
    }

    private void dbO() {
        if (this.uCf) {
            new Thread(new C145992()).start();
        }
    }

    public final Map<String, Object> dbP() {
        Map emptyMap;
        String cWL = cWL();
        if (TextUtils.isEmpty(cWL)) {
            emptyMap = Collections.emptyMap();
        } else {
            HashMap hashMap = new HashMap();
            Uri parse = Uri.parse(cWL);
            for (String cWL2 : parse.getQueryParameterNames()) {
                hashMap.put(cWL2, parse.getQueryParameter(cWL2));
            }
            emptyMap = hashMap;
        }
        Map dbJ = dbJ();
        if (dbJ != null) {
            emptyMap.putAll(dbJ);
        }
        C4990ab.m7417i("PreLoadWebViewUI", "buildOnUiInitParams %s", emptyMap.toString());
        return emptyMap;
    }
}
