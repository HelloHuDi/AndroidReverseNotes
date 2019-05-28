package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import com.tencent.luggage.sdk.config.AppBrandSysConfigLU;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33185b;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio.OperateBackgroundAudioTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC.SetBackgroundAudioListenerTaskWC;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C10835f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.i */
public final class C26925i extends JsApiOperateBackgroundAudio<C45126b> {
    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ SetBackgroundAudioListenerTask mo44668a(C10296a c10296a, C2241c c2241c, int i) {
        AppMethodBeat.m2504i(130714);
        SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new SetBackgroundAudioListenerTaskWC(c10296a, (C45126b) c2241c, i);
        AppMethodBeat.m2505o(130714);
        return setBackgroundAudioListenerTaskWC;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: l */
    public final /* synthetic */ void mo44669l(C2241c c2241c) {
        AppMethodBeat.m2504i(130713);
        C45126b c45126b = (C45126b) c2241c;
        if (this.hAp != null) {
            AppBrandSysConfigLU xZ = c45126b.mo34954xL().mo43489xZ();
            this.hAp.cBc = xZ.hhd.gVt;
            this.hAp.cwz = xZ.cwz;
            this.hAp.cBb = C42641p.m75509a(c45126b);
            final C32800b y = C37922v.m64076Zp().mo60676y(C37922v.m64078nW("AppBrandService#" + c45126b.hashCode()), true);
            synchronized (y) {
                try {
                    C10835f c192981;
                    C10835f c10835f = (C10835f) y.get("StickyBannerChangeListener", null);
                    if (c10835f == null) {
                        c192981 = new C10835f() {
                            /* renamed from: bg */
                            public final void mo6073bg(String str, int i) {
                                AppMethodBeat.m2504i(130711);
                                String string = y.getString("appId", "");
                                int i2 = y.getInt("pkgType", 0);
                                if (!((string.equals(str) && i2 == i) || !y.mo53357nX("operateBackgroundAudio#isPlaying") || C33183g.m54287wW(string) == C33185b.ON_RESUME)) {
                                    C4990ab.m7416i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(C26925i.this, C26925i.this.hAp.hxS, C26925i.this.hAp.hwi);
                                    operateBackgroundAudioTask.hAs = jSONObject.toString();
                                    operateBackgroundAudioTask.appId = string;
                                    AppBrandMainProcessService.m54349a(operateBackgroundAudioTask);
                                }
                                AppMethodBeat.m2505o(130711);
                            }
                        };
                        C16597h c16597h = (C16597h) c45126b.mo5937aa(C16597h.class);
                        if (c16597h != null) {
                            y.mo53356j("pkgType", Integer.valueOf(c16597h.hhd.gVt));
                        }
                        y.mo53356j("StickyBannerChangeListener", c192981);
                        y.mo53356j("appId", c45126b.getAppId());
                    } else {
                        c192981 = c10835f;
                    }
                    if (((C33186c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                        C269262 c269262 = new C33186c() {
                            public final void onDestroy() {
                                AppMethodBeat.m2504i(130712);
                                C4990ab.m7417i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onDestroy, appId:%s", y.getString("appId", ""));
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "stop");
                                } catch (JSONException e) {
                                }
                                MainProcessTask operateBackgroundAudioTask = new OperateBackgroundAudioTask(C26925i.this, C26925i.this.hAp.hxS, C26925i.this.hAp.hwi);
                                operateBackgroundAudioTask.hAs = jSONObject.toString();
                                operateBackgroundAudioTask.appId = r0;
                                AppBrandMainProcessService.m54355b(operateBackgroundAudioTask);
                                AppMethodBeat.m2505o(130712);
                            }
                        };
                        y.mo53356j("AppBrandLifeCycle.Listener", c269262);
                        this.hAp.huj = c269262;
                    }
                    if (this.hAp instanceof SetBackgroundAudioListenerTaskWC) {
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAy = c192981;
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAx = y;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(130713);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(130713);
    }
}
