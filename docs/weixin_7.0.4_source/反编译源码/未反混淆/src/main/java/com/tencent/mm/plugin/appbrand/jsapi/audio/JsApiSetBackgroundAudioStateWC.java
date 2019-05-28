package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiSetBackgroundAudioStateWC extends JsApiSetBackgroundAudioState {

    public static class SetBackgroundAudioStateTaskWC extends SetBackgroundAudioStateTask {
        public SetBackgroundAudioStateTaskWC(a aVar, c cVar, int i) {
            super(aVar, cVar, i);
        }

        public final String AP(String str) {
            AppMethodBeat.i(130764);
            String str2 = com.tencent.mm.plugin.i.c.XW() + str.hashCode();
            AppMethodBeat.o(130764);
            return str2;
        }
    }

    public static class SetBackgroundAudioListenerTaskWC extends SetBackgroundAudioListenerTask {
        public b hAx;
        public f hAy;

        public SetBackgroundAudioListenerTaskWC(a aVar, c cVar, int i) {
            super(aVar, cVar, i);
        }

        /* Access modifiers changed, original: protected|final */
        public final void oa(int i) {
            AppMethodBeat.i(130763);
            switch (i) {
                case 0:
                case 1:
                    this.hAx.j("setBackgroundAudioState#isPlaying", Boolean.TRUE);
                    AppBrandStickyBannerLogic.a.d(this.hAy);
                    AppMethodBeat.o(130763);
                    return;
                case 2:
                case 3:
                case 4:
                case 7:
                    this.hAx.j("setBackgroundAudioState#isPlaying", Boolean.FALSE);
                    AppBrandStickyBannerLogic.a.c(this.hAy);
                    AppMethodBeat.o(130763);
                    return;
                case 8:
                case 11:
                case 12:
                    AppMethodBeat.o(130763);
                    return;
                case 10:
                    AppMethodBeat.o(130763);
                    return;
                case 13:
                    AppMethodBeat.o(130763);
                    return;
                case 14:
                    AppMethodBeat.o(130763);
                    return;
                default:
                    AppMethodBeat.o(130763);
                    return;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final SetBackgroundAudioStateTask b(a aVar, c cVar, int i) {
        AppMethodBeat.i(130765);
        SetBackgroundAudioStateTaskWC setBackgroundAudioStateTaskWC = new SetBackgroundAudioStateTaskWC(aVar, cVar, i);
        AppMethodBeat.o(130765);
        return setBackgroundAudioStateTaskWC;
    }

    /* Access modifiers changed, original: protected|final */
    public final SetBackgroundAudioListenerTask a(a aVar, c cVar, int i) {
        AppMethodBeat.i(130766);
        SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new SetBackgroundAudioListenerTaskWC(aVar, cVar, i);
        AppMethodBeat.o(130766);
        return setBackgroundAudioListenerTaskWC;
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(String str, c cVar) {
        AppMethodBeat.i(130767);
        if (this.hAp != null) {
            h hVar = (h) cVar.aa(h.class);
            this.hAp.cBc = hVar.hhd.gVt;
            this.hAp.cwz = hVar.cwz;
            this.hAp.cBb = p.a(cVar);
            ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", Integer.valueOf(this.hAp.cBc), this.hAp.cwz, this.hAp.cBb);
            final b y = v.Zp().y(str, true);
            synchronized (y) {
                try {
                    f fVar = (f) y.get("StickyBannerChangeListener", null);
                    if (fVar == null) {
                        fVar = new f() {
                            public final void bg(String str, int i) {
                                AppMethodBeat.i(130761);
                                String string = y.getString("appId", "");
                                int i2 = y.getInt("pkgType", 0);
                                if (!((string.equals(str) && i2 == i) || !y.nX("setBackgroundAudioState#isPlaying") || g.wW(string) == g.b.ON_RESUME)) {
                                    ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask b = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.hAp.hxS, JsApiSetBackgroundAudioStateWC.this.hAp.hwi);
                                    b.hAs = jSONObject.toString();
                                    b.appId = string;
                                    AppBrandMainProcessService.a(b);
                                }
                                AppMethodBeat.o(130761);
                            }
                        };
                        y.j("pkgType", Integer.valueOf(hVar.hhd.gVt));
                        y.j("StickyBannerChangeListener", fVar);
                        y.j("appId", cVar.getAppId());
                    }
                    if (((g.c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                        AnonymousClass2 anonymousClass2 = new g.c() {
                            public final void onDestroy() {
                                AppMethodBeat.i(130762);
                                ab.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", y.getString("appId", ""));
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "stop");
                                } catch (JSONException e) {
                                }
                                MainProcessTask b = JsApiSetBackgroundAudioStateWC.this.b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.hAp.hxS, JsApiSetBackgroundAudioStateWC.this.hAp.hwi);
                                b.hAs = jSONObject.toString();
                                b.appId = r0;
                                AppBrandMainProcessService.b(b);
                                AppMethodBeat.o(130762);
                            }
                        };
                        y.j("AppBrandLifeCycle.Listener", anonymousClass2);
                        this.hAp.huj = anonymousClass2;
                    }
                    if (this.hAp instanceof SetBackgroundAudioListenerTaskWC) {
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAy = fVar;
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAx = y;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(130767);
                }
            }
            return;
        }
        AppMethodBeat.o(130767);
    }

    /* Access modifiers changed, original: protected|final */
    public final String a(JSONObject jSONObject, c cVar) {
        AppMethodBeat.i(130768);
        String a = super.a(jSONObject, cVar);
        if (a == null || a.length() <= 0) {
            a = "";
            AppMethodBeat.o(130768);
            return a;
        } else if (a.startsWith("http://") || a.startsWith("https://")) {
            AppMethodBeat.o(130768);
            return a;
        } else {
            File yg = cVar.asE().yg(a);
            if (yg == null || !yg.exists()) {
                a = "";
                AppMethodBeat.o(130768);
                return a;
            }
            a = yg.getAbsolutePath();
            if (!a.startsWith("file://")) {
                a = "file://".concat(String.valueOf(a));
            }
            AppMethodBeat.o(130768);
            return a;
        }
    }
}
