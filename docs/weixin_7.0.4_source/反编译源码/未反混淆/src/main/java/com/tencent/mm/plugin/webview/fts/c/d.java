package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.fts.c.b.a;
import com.tencent.mm.plugin.webview.fts.c.b.b;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public final class d implements a {
    public ap ias;
    public int iat;
    FtsWebVideoView uhG;
    private b uhv;
    private com.tencent.mm.plugin.webview.ui.tools.jsapi.d uhz;

    public d(FtsWebVideoView ftsWebVideoView, b bVar, com.tencent.mm.plugin.webview.ui.tools.jsapi.d dVar) {
        AppMethodBeat.i(5952);
        this.uhG = ftsWebVideoView;
        this.uhv = bVar;
        this.uhv.a(this);
        this.uhz = dVar;
        AppMethodBeat.o(5952);
    }

    public final void clean() {
        AppMethodBeat.i(5953);
        ab.i("MicroMsg.JsApiVideoCallback", "clean %s", toString());
        aFW();
        AppMethodBeat.o(5953);
    }

    public final void aM(JSONObject jSONObject) {
        AppMethodBeat.i(5954);
        this.uhz.a("onVideoPlayerCallback", null, jSONObject);
        AppMethodBeat.o(5954);
    }

    public final void b(int i, boolean z, String str) {
        AppMethodBeat.i(5955);
        try {
            ab.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%s", Integer.valueOf(i), Boolean.valueOf(z), str);
            aM(a(5, u(z, str)));
            AppMethodBeat.o(5955);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e);
            AppMethodBeat.o(5955);
        }
    }

    public final void cWB() {
        AppMethodBeat.i(5956);
        try {
            aM(a(6, cWC()));
            AppMethodBeat.o(5956);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.JsApiVideoCallback", e, null, new Object[0]);
            AppMethodBeat.o(5956);
        }
    }

    private JSONObject u(boolean z, String str) {
        AppMethodBeat.i(5957);
        JSONObject aFV = aFV();
        aFV.put("fullScreen", z);
        aFV.put(TencentLocation.EXTRA_DIRECTION, str);
        AppMethodBeat.o(5957);
        return aFV;
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.i(5958);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.uhG.getCookieData());
        AppMethodBeat.o(5958);
        return jSONObject;
    }

    private JSONObject cWC() {
        AppMethodBeat.i(5959);
        JSONObject aFV = aFV();
        aFV.put("currentTime", this.uhG.getCurrPosSec());
        AppMethodBeat.o(5959);
        return aFV;
    }

    public final void aFW() {
        AppMethodBeat.i(5960);
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.o(5960);
    }

    public final void wU() {
    }

    public final void wW() {
    }

    public final void onDestroy() {
        AppMethodBeat.i(5961);
        ab.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.uhG.setCallback(null);
        AppMethodBeat.o(5961);
    }

    public final void aDI() {
    }

    public final boolean wY() {
        return false;
    }

    public final void cWy() {
    }

    public final void cWz() {
    }

    public final JSONObject a(int i, JSONObject jSONObject) {
        AppMethodBeat.i(5962);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("playerId", this.uhG.getmVideoPlayerId());
        jSONObject2.put("event", i);
        if (jSONObject != null) {
            jSONObject2.put("detail", jSONObject);
        }
        AppMethodBeat.o(5962);
        return jSONObject2;
    }
}
