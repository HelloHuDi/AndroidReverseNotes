package com.tencent.mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.e;
import com.tencent.luggage.d.g;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.luggage.d.n.a;
import com.tencent.luggage.g.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends n {
    private MMWebView fow;
    boolean kOh = false;
    private a kOi = new a() {
        public final void a(n nVar, String str) {
        }

        public final void b(n nVar, String str) {
            AppMethodBeat.i(136045);
            ab.i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", Boolean.valueOf(c.this.kOh));
            String string = c.this.bPP.getString("rawUrl");
            if (bo.isNullOrNil(string)) {
                AppMethodBeat.o(136045);
                return;
            }
            string = Uri.parse(string).getQueryParameter("appid");
            c.this.bPN.a(new com.tencent.luggage.d.c() {
                public final String name() {
                    return "onDataEnvReady";
                }

                public final JSONObject wQ() {
                    AppMethodBeat.i(136044);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appid", string);
                    } catch (JSONException e) {
                    }
                    AppMethodBeat.o(136044);
                    return jSONObject;
                }
            });
            AppMethodBeat.o(136045);
        }
    };

    public c(g gVar, k kVar, Bundle bundle) {
        super(gVar, kVar, bundle);
        AppMethodBeat.i(136046);
        if (kVar != null) {
            this.kOh = true;
        }
        ab.i("MicroMsg.DownloadDetailWebPage", "preload = %b", Boolean.valueOf(this.kOh));
        a((e.a) this.kOi);
        this.bPN.bPC = com.tencent.luggage.d.a.a.bPT;
        h.b(this);
        AppMethodBeat.o(136046);
    }

    public final void wU() {
        AppMethodBeat.i(136048);
        ab.i("MicroMsg.DownloadDetailWebPage", "onForeground");
        IB("onResume");
        this.fow.onResume();
        AppMethodBeat.o(136048);
    }

    public final void wW() {
        AppMethodBeat.i(136049);
        ab.i("MicroMsg.DownloadDetailWebPage", "onBackground");
        IB("onPause");
        this.fow.onPause();
        AppMethodBeat.o(136049);
    }

    public final void onDestroy() {
        AppMethodBeat.i(136050);
        ab.i("MicroMsg.DownloadDetailWebPage", "onDestroy");
        IB("onDestroy");
        h.c(this);
        AppMethodBeat.o(136050);
    }

    public final void g(String str, Bundle bundle) {
        AppMethodBeat.i(136051);
        if (!this.kOh) {
            this.bPN.loadUrl(str);
        }
        AppMethodBeat.o(136051);
    }

    public final String xt() {
        AppMethodBeat.i(136052);
        String p = i.p(ah.getContext(), "luggage_mm_adapter.js");
        AppMethodBeat.o(136052);
        return p;
    }

    public final View wR() {
        AppMethodBeat.i(136047);
        this.fow = (MMWebView) this.bPN.xr();
        View wR = super.wR();
        AppMethodBeat.o(136047);
        return wR;
    }

    private void IB(final String str) {
        AppMethodBeat.i(136053);
        this.bPN.a(new com.tencent.luggage.d.c() {
            public final String name() {
                return "activity:state_change";
            }

            public final JSONObject wQ() {
                AppMethodBeat.i(136043);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (Exception e) {
                }
                AppMethodBeat.o(136043);
                return jSONObject;
            }
        });
        AppMethodBeat.o(136053);
    }
}
