package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.a.a.b;
import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.ui.banner.f;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONException;
import org.json.JSONObject;

public final class i extends JsApiOperateBackgroundAudio<b> {
    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ SetBackgroundAudioListenerTask a(a aVar, c cVar, int i) {
        AppMethodBeat.i(130714);
        SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new SetBackgroundAudioListenerTaskWC(aVar, (b) cVar, i);
        AppMethodBeat.o(130714);
        return setBackgroundAudioListenerTaskWC;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void l(c cVar) {
        AppMethodBeat.i(130713);
        b bVar = (b) cVar;
        if (this.hAp != null) {
            AppBrandSysConfigLU xZ = bVar.xL().xZ();
            this.hAp.cBc = xZ.hhd.gVt;
            this.hAp.cwz = xZ.cwz;
            this.hAp.cBb = p.a(bVar);
            final v.b y = v.Zp().y(v.nW("AppBrandService#" + bVar.hashCode()), true);
            synchronized (y) {
                try {
                    f anonymousClass1;
                    f fVar = (f) y.get("StickyBannerChangeListener", null);
                    if (fVar == null) {
                        anonymousClass1 = new f() {
                            public final void bg(String str, int i) {
                                AppMethodBeat.i(130711);
                                String string = y.getString("appId", "");
                                int i2 = y.getInt("pkgType", 0);
                                if (!((string.equals(str) && i2 == i) || !y.nX("operateBackgroundAudio#isPlaying") || g.wW(string) == g.b.ON_RESUME)) {
                                    ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(i.this, i.this.hAp.hxS, i.this.hAp.hwi);
                                    operateBackgroundAudioTask.hAs = jSONObject.toString();
                                    operateBackgroundAudioTask.appId = string;
                                    AppBrandMainProcessService.a(operateBackgroundAudioTask);
                                }
                                AppMethodBeat.o(130711);
                            }
                        };
                        h hVar = (h) bVar.aa(h.class);
                        if (hVar != null) {
                            y.j("pkgType", Integer.valueOf(hVar.hhd.gVt));
                        }
                        y.j("StickyBannerChangeListener", anonymousClass1);
                        y.j("appId", bVar.getAppId());
                    } else {
                        anonymousClass1 = fVar;
                    }
                    if (((g.c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                        AnonymousClass2 anonymousClass2 = new g.c() {
                            public final void onDestroy() {
                                AppMethodBeat.i(130712);
                                ab.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", y.getString("appId", ""));
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "stop");
                                } catch (JSONException e) {
                                }
                                MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(i.this, i.this.hAp.hxS, i.this.hAp.hwi);
                                operateBackgroundAudioTask.hAs = jSONObject.toString();
                                operateBackgroundAudioTask.appId = r0;
                                AppBrandMainProcessService.b(operateBackgroundAudioTask);
                                AppMethodBeat.o(130712);
                            }
                        };
                        y.j("AppBrandLifeCycle.Listener", anonymousClass2);
                        this.hAp.huj = anonymousClass2;
                    }
                    if (this.hAp instanceof SetBackgroundAudioListenerTaskWC) {
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAy = anonymousClass1;
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAx = y;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(130713);
                }
            }
            return;
        }
        AppMethodBeat.o(130713);
    }
}
