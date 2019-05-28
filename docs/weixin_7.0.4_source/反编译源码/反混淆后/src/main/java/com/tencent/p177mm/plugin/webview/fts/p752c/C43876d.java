package com.tencent.p177mm.plugin.webview.fts.p752c;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.webview.fts.p1069ui.FtsWebVideoView;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22790a;
import com.tencent.p177mm.plugin.webview.fts.p752c.C43872b.C22791b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.c.d */
public final class C43876d implements C22790a {
    public C7564ap ias;
    public int iat;
    FtsWebVideoView uhG;
    private C22791b uhv;
    private C44786d uhz;

    /* renamed from: com.tencent.mm.plugin.webview.fts.c.d$1 */
    public class C72011 implements C5015a {
        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(5951);
            try {
                int currPosMs = C43876d.this.uhG.getCurrPosMs();
                if (Math.abs(currPosMs - C43876d.this.iat) < 250) {
                    AppMethodBeat.m2505o(5951);
                    return true;
                }
                C43876d.this.iat = currPosMs;
                C43876d c43876d = C43876d.this;
                C43876d c43876d2 = C43876d.this;
                C43876d c43876d3 = C43876d.this;
                JSONObject aFV = c43876d3.aFV();
                aFV.put("currentTime", c43876d3.uhG.getCurrPosSec());
                c43876d.mo69569aM(c43876d2.mo69566a(4, aFV));
                AppMethodBeat.m2505o(5951);
                return true;
            } catch (JSONException e) {
                C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
            }
        }
    }

    public C43876d(FtsWebVideoView ftsWebVideoView, C22791b c22791b, C44786d c44786d) {
        AppMethodBeat.m2504i(5952);
        this.uhG = ftsWebVideoView;
        this.uhv = c22791b;
        this.uhv.mo9679a(this);
        this.uhz = c44786d;
        AppMethodBeat.m2505o(5952);
    }

    public final void clean() {
        AppMethodBeat.m2504i(5953);
        C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "clean %s", toString());
        aFW();
        AppMethodBeat.m2505o(5953);
    }

    /* renamed from: aM */
    public final void mo69569aM(JSONObject jSONObject) {
        AppMethodBeat.m2504i(5954);
        this.uhz.mo71890a("onVideoPlayerCallback", null, jSONObject);
        AppMethodBeat.m2505o(5954);
    }

    /* renamed from: b */
    public final void mo69570b(int i, boolean z, String str) {
        AppMethodBeat.m2504i(5955);
        try {
            C4990ab.m7417i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", Integer.valueOf(i), Boolean.valueOf(z), str);
            mo69569aM(mo69566a(5, m78697u(z, str)));
            AppMethodBeat.m2505o(5955);
        } catch (JSONException e) {
            C4990ab.m7413e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e);
            AppMethodBeat.m2505o(5955);
        }
    }

    public final void cWB() {
        AppMethodBeat.m2504i(5956);
        try {
            mo69569aM(mo69566a(6, cWC()));
            AppMethodBeat.m2505o(5956);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            AppMethodBeat.m2505o(5956);
        }
    }

    /* renamed from: u */
    private JSONObject m78697u(boolean z, String str) {
        AppMethodBeat.m2504i(5957);
        JSONObject aFV = aFV();
        aFV.put("fullScreen", z);
        aFV.put(TencentLocation.EXTRA_DIRECTION, str);
        AppMethodBeat.m2505o(5957);
        return aFV;
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.m2504i(5958);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.uhG.getCookieData());
        AppMethodBeat.m2505o(5958);
        return jSONObject;
    }

    private JSONObject cWC() {
        AppMethodBeat.m2504i(5959);
        JSONObject aFV = aFV();
        aFV.put("currentTime", this.uhG.getCurrPosSec());
        AppMethodBeat.m2505o(5959);
        return aFV;
    }

    public final void aFW() {
        AppMethodBeat.m2504i(5960);
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.m2505o(5960);
    }

    /* renamed from: wU */
    public final void mo38384wU() {
    }

    /* renamed from: wW */
    public final void mo38385wW() {
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(5961);
        C4990ab.m7410d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.uhG.setCallback(null);
        AppMethodBeat.m2505o(5961);
    }

    public final void aDI() {
    }

    /* renamed from: wY */
    public final boolean mo38386wY() {
        return false;
    }

    public final void cWy() {
    }

    public final void cWz() {
    }

    /* renamed from: a */
    public final JSONObject mo69566a(int i, JSONObject jSONObject) {
        AppMethodBeat.m2504i(5962);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.uhG.getmVideoPlayerId());
        jSONObject2.put("event", i);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        AppMethodBeat.m2505o(5962);
        return jSONObject2;
    }
}
