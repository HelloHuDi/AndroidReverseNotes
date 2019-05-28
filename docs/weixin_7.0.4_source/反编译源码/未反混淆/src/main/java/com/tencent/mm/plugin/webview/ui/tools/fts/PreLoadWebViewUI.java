package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.al;
import com.tencent.mm.plugin.websearch.api.ap;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public abstract class PreLoadWebViewUI extends WebViewUI {
    protected String cIy;
    protected String cvF;
    boolean uCf;
    CountDownLatch uCg = new CountDownLatch(dbI() + 2);
    private ah uCh;
    private int uaJ = -1;

    protected class a extends h {
        protected a() {
            super();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
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

    public final ah dap() {
        return this.uCh;
    }

    public final MMWebView aXX() {
        al alVar;
        ah ahVar;
        Intent intent = getIntent();
        if (intent != null) {
            this.uaJ = intent.getIntExtra("key_preload_biz", -1);
            ab.i("PreLoadWebViewUI", "getting preloaded  webview, biz %d", Integer.valueOf(this.uaJ));
            alVar = (al) aj.cVp().Ih(this.uaJ).fn(this);
        } else {
            alVar = null;
        }
        MMWebView mMWebView = alVar == null ? null : (MMWebView) alVar.uaQ;
        if (alVar == null) {
            ahVar = null;
        } else {
            ahVar = alVar.uaR;
        }
        this.uCh = ahVar;
        if (mMWebView == null) {
            ab.i("PreLoadWebViewUI", "no available preloaded webview");
            this.uCf = false;
            String cWL = cWL();
            int i = !TextUtils.isEmpty(cWL) ? bo.ank(Uri.parse(cWL).getQueryParameter("isOpenPreload")) == 1 ? 1 : 0 : 0;
            if (i != 0) {
                com.tencent.mm.plugin.report.service.h.pYm.e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(4), Integer.valueOf(0));
            }
            if (this.uaJ == 2) {
                return com.tencent.mm.ui.widget.MMWebView.a.in(this);
            }
            try {
                return ap.cVF().cVG() ? com.tencent.mm.ui.widget.MMWebView.a.im(this) : com.tencent.mm.ui.widget.MMWebView.a.in(this);
            } catch (Exception e) {
                return com.tencent.mm.ui.widget.MMWebView.a.in(this);
            }
        }
        ab.i("PreLoadWebViewUI", "use preloaded webview ,%s ", mMWebView.toString());
        this.uCf = true;
        com.tencent.mm.plugin.report.service.h.pYm.e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(3), Integer.valueOf(0));
        return mMWebView;
    }

    public void aMh() {
        super.aMh();
        this.uCg.countDown();
        if (this.uhz == null || this.uhz.ready) {
            dbO();
        } else {
            this.uhz.a(new com.tencent.mm.plugin.webview.ui.tools.jsapi.d.a() {
                public final void onReady() {
                    AppMethodBeat.i(8559);
                    PreLoadWebViewUI.this.dbO();
                    AppMethodBeat.o(8559);
                }
            });
        }
        if (!b.dnO()) {
            return;
        }
        if (this.uCf) {
            t.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "use preloaded webview(安装coolassist时弹出), sys " + ap.cVF().cVG(), 1).show();
        } else {
            t.makeText(com.tencent.mm.sdk.platformtools.ah.getContext(), "no preloaded webview(安装coolassist时弹出), sys " + ap.cVF().cVG(), 1).show();
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
        com.tencent.mm.plugin.report.service.h.pYm.e(15005, Integer.valueOf(this.uaJ), Integer.valueOf(5), Integer.valueOf(0));
    }

    /* Access modifiers changed, original: protected */
    public d getJsapi() {
        return this.uhz;
    }

    private void dbO() {
        if (this.uCf) {
            new Thread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8560);
                    try {
                        PreLoadWebViewUI.this.uCg.await();
                    } catch (InterruptedException e) {
                        ab.printErrStackTrace("PreLoadWebViewUI", e, "", new Object[0]);
                    }
                    if (PreLoadWebViewUI.this.uCf) {
                        ab.i("PreLoadWebViewUI", "send onUiInit to webview");
                        PreLoadWebViewUI.this.dbE();
                        PreLoadWebViewUI.this.uhz.aK(PreLoadWebViewUI.this.dbP());
                    }
                    AppMethodBeat.o(8560);
                }
            }).start();
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
        ab.i("PreLoadWebViewUI", "buildOnUiInitParams %s", emptyMap.toString());
        return emptyMap;
    }
}
