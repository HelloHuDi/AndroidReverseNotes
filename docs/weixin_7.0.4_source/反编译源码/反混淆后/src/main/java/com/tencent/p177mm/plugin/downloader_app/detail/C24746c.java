package com.tencent.p177mm.plugin.downloader_app.detail;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C17821n.C17822a;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.luggage.p146d.C41709g;
import com.tencent.luggage.p146d.C8860e.C8862a;
import com.tencent.luggage.p146d.p1171a.C25685a;
import com.tencent.luggage.p147g.C32192i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.webview.luggage.C43887h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.c */
public final class C24746c extends C17821n {
    private MMWebView fow;
    boolean kOh = false;
    private C17822a kOi = new C247482();

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.c$2 */
    class C247482 extends C17822a {
        C247482() {
        }

        /* renamed from: a */
        public final void mo32978a(C17821n c17821n, String str) {
        }

        /* renamed from: b */
        public final void mo32979b(C17821n c17821n, String str) {
            AppMethodBeat.m2504i(136045);
            C4990ab.m7417i("MicroMsg.DownloadDetailWebPage", "onUrlLoadingFinished, preload = %b", Boolean.valueOf(C24746c.this.kOh));
            String string = C24746c.this.bPP.getString("rawUrl");
            if (C5046bo.isNullOrNil(string)) {
                AppMethodBeat.m2505o(136045);
                return;
            }
            string = Uri.parse(string).getQueryParameter("appid");
            C24746c.this.bPN.mo52826a(new C17817c() {
                public final String name() {
                    return "onDataEnvReady";
                }

                /* renamed from: wQ */
                public final JSONObject mo7075wQ() {
                    AppMethodBeat.m2504i(136044);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appid", string);
                    } catch (JSONException e) {
                    }
                    AppMethodBeat.m2505o(136044);
                    return jSONObject;
                }
            });
            AppMethodBeat.m2505o(136045);
        }
    }

    public C24746c(C41709g c41709g, C32186k c32186k, Bundle bundle) {
        super(c41709g, c32186k, bundle);
        AppMethodBeat.m2504i(136046);
        if (c32186k != null) {
            this.kOh = true;
        }
        C4990ab.m7417i("MicroMsg.DownloadDetailWebPage", "preload = %b", Boolean.valueOf(this.kOh));
        mo20035a((C8862a) this.kOi);
        this.bPN.bPC = C25685a.bPT;
        C43887h.m78713b(this);
        AppMethodBeat.m2505o(136046);
    }

    /* renamed from: wU */
    public final void mo20045wU() {
        AppMethodBeat.m2504i(136048);
        C4990ab.m7416i("MicroMsg.DownloadDetailWebPage", "onForeground");
        m38628IB("onResume");
        this.fow.onResume();
        AppMethodBeat.m2505o(136048);
    }

    /* renamed from: wW */
    public final void mo20047wW() {
        AppMethodBeat.m2504i(136049);
        C4990ab.m7416i("MicroMsg.DownloadDetailWebPage", "onBackground");
        m38628IB("onPause");
        this.fow.onPause();
        AppMethodBeat.m2505o(136049);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(136050);
        C4990ab.m7416i("MicroMsg.DownloadDetailWebPage", "onDestroy");
        m38628IB("onDestroy");
        C43887h.m78714c(this);
        AppMethodBeat.m2505o(136050);
    }

    /* renamed from: g */
    public final void mo20038g(String str, Bundle bundle) {
        AppMethodBeat.m2504i(136051);
        if (!this.kOh) {
            this.bPN.loadUrl(str);
        }
        AppMethodBeat.m2505o(136051);
    }

    /* renamed from: xt */
    public final String mo30766xt() {
        AppMethodBeat.m2504i(136052);
        String p = C32192i.m52511p(C4996ah.getContext(), "luggage_mm_adapter.js");
        AppMethodBeat.m2505o(136052);
        return p;
    }

    /* renamed from: wR */
    public final View mo20042wR() {
        AppMethodBeat.m2504i(136047);
        this.fow = (MMWebView) this.bPN.mo52835xr();
        View wR = super.mo20042wR();
        AppMethodBeat.m2505o(136047);
        return wR;
    }

    /* renamed from: IB */
    private void m38628IB(final String str) {
        AppMethodBeat.m2504i(136053);
        this.bPN.mo52826a(new C17817c() {
            public final String name() {
                return "activity:state_change";
            }

            /* renamed from: wQ */
            public final JSONObject mo7075wQ() {
                AppMethodBeat.m2504i(136043);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("state", str);
                } catch (Exception e) {
                }
                AppMethodBeat.m2505o(136043);
                return jSONObject;
            }
        });
        AppMethodBeat.m2505o(136053);
    }
}
