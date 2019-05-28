package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import org.json.JSONException;
import org.json.JSONObject;

public final class k implements com.tencent.mm.plugin.appbrand.jsapi.f.c {
    ap hZL;
    AppBrandVideoView iaq;
    private com.tencent.mm.plugin.appbrand.jsapi.e iar;
    ap ias;
    int iat;
    int iau = 0;

    static final class h extends ah {
        private static final int CTRL_INDEX = 127;
        private static final String NAME = "onVideoPlay";

        private h() {
        }

        /* synthetic */ h(byte b) {
            this();
        }
    }

    static final class a extends ah {
        private static final int CTRL_INDEX = 480;
        private static final String NAME = "onVideoCanPlay";

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    static final class j extends ah {
        private static final int CTRL_INDEX = 485;
        private static final String NAME = "onVideoResourceError";

        j() {
        }
    }

    static final class b extends ah {
        private static final int CTRL_INDEX = 131;
        private static final String NAME = "onVideoClickDanmuBtn";

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static final class i extends ah {
        private static final int CTRL_INDEX = 548;
        private static final String NAME = "onVideoProgress";

        private i() {
        }

        /* synthetic */ i(byte b) {
            this();
        }
    }

    static final class k extends ah {
        private static final int CTRL_INDEX = 484;
        private static final String NAME = "onVideoResourceLoad";

        k() {
        }
    }

    static final class m extends ah {
        private static final int CTRL_INDEX = 350;
        private static final String NAME = "onVideoWaiting";

        private m() {
        }

        /* synthetic */ m(byte b) {
            this();
        }
    }

    static final class c extends ah {
        private static final int CTRL_INDEX = 129;
        private static final String NAME = "onVideoEnded";

        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }
    }

    static final class l extends ah {
        private static final int CTRL_INDEX = 138;
        private static final String NAME = "onVideoTimeUpdate";

        private l() {
        }

        /* synthetic */ l(byte b) {
            this();
        }
    }

    static final class d extends ah {
        private static final int CTRL_INDEX = 349;
        private static final String NAME = "onVideoError";

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    static final class e extends ah {
        private static final int CTRL_INDEX = 130;
        private static final String NAME = "onVideoFullScreenChange";

        private e() {
        }

        /* synthetic */ e(byte b) {
            this();
        }
    }

    static final class f extends ah {
        private static final int CTRL_INDEX = 628;
        private static final String NAME = "onVideoLoadedMetaData";

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    static final class g extends ah {
        private static final int CTRL_INDEX = 128;
        private static final String NAME = "onVideoPause";

        private g() {
        }

        /* synthetic */ g(byte b) {
            this();
        }
    }

    public k(AppBrandVideoView appBrandVideoView, com.tencent.mm.plugin.appbrand.jsapi.e eVar) {
        AppMethodBeat.i(126572);
        this.iaq = appBrandVideoView;
        this.iar = eVar;
        this.iar.a((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
        AppMethodBeat.o(126572);
    }

    public final void onDestroy() {
        AppMethodBeat.i(126573);
        ab.d("MicroMsg.JsApiVideoCallback", "onDestroy clean");
        clean();
        this.iaq.setCallback(null);
        AppMethodBeat.o(126573);
    }

    public final void clean() {
        AppMethodBeat.i(126574);
        this.iar.b((com.tencent.mm.plugin.appbrand.jsapi.f.c) this);
        aFW();
        aFX();
        AppMethodBeat.o(126574);
    }

    public final void c(int i, boolean z, int i2) {
        AppMethodBeat.i(126575);
        try {
            ab.i("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange videoPlayerId=%d isFullScreen=%b direction:%d", Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2));
            JSONObject aFV = aFV();
            aFV.put("fullScreen", z);
            aFV.put("videoPlayerId", i);
            aFV.put(TencentLocation.EXTRA_DIRECTION, i2);
            a(new e(), aFV);
            AppMethodBeat.o(126575);
        } catch (JSONException e) {
            ab.e("MicroMsg.JsApiVideoCallback", "onVideoFullScreenChange e=%s", e);
            AppMethodBeat.o(126575);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(ah ahVar, JSONObject jSONObject) {
        AppMethodBeat.i(126576);
        if (!((ahVar instanceof l) || (ahVar instanceof i))) {
            ab.i("MicroMsg.JsApiVideoCallback", "dispatchEvent event %s", ahVar.getName());
        }
        this.iar.b(ahVar.AM(jSONObject.toString()));
        AppMethodBeat.o(126576);
    }

    /* Access modifiers changed, original: final */
    public final JSONObject aFV() {
        AppMethodBeat.i(126577);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("data", this.iaq.getCookieData());
        AppMethodBeat.o(126577);
        return jSONObject;
    }

    /* Access modifiers changed, original: final */
    public final void aFW() {
        AppMethodBeat.i(126578);
        if (this.ias != null) {
            this.ias.stopTimer();
        }
        AppMethodBeat.o(126578);
    }

    /* Access modifiers changed, original: final */
    public final void aFX() {
        AppMethodBeat.i(126579);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.o(126579);
    }
}
