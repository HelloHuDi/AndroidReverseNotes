package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

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
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.C10835f;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC */
public final class JsApiSetBackgroundAudioStateWC extends JsApiSetBackgroundAudioState {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC$SetBackgroundAudioStateTaskWC */
    public static class SetBackgroundAudioStateTaskWC extends SetBackgroundAudioStateTask {
        public SetBackgroundAudioStateTaskWC(C10296a c10296a, C2241c c2241c, int i) {
            super(c10296a, c2241c, i);
        }

        /* renamed from: AP */
        public final String mo21753AP(String str) {
            AppMethodBeat.m2504i(130764);
            String str2 = C43217c.m76863XW() + str.hashCode();
            AppMethodBeat.m2505o(130764);
            return str2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioStateWC$SetBackgroundAudioListenerTaskWC */
    public static class SetBackgroundAudioListenerTaskWC extends SetBackgroundAudioListenerTask {
        public C32800b hAx;
        public C10835f hAy;

        public SetBackgroundAudioListenerTaskWC(C10296a c10296a, C2241c c2241c, int i) {
            super(c10296a, c2241c, i);
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: oa */
        public final void mo21754oa(int i) {
            AppMethodBeat.m2504i(130763);
            switch (i) {
                case 0:
                case 1:
                    this.hAx.mo53356j("setBackgroundAudioState#isPlaying", Boolean.TRUE);
                    C19773a.m30608d(this.hAy);
                    AppMethodBeat.m2505o(130763);
                    return;
                case 2:
                case 3:
                case 4:
                case 7:
                    this.hAx.mo53356j("setBackgroundAudioState#isPlaying", Boolean.FALSE);
                    C19773a.m30606c(this.hAy);
                    AppMethodBeat.m2505o(130763);
                    return;
                case 8:
                case 11:
                case 12:
                    AppMethodBeat.m2505o(130763);
                    return;
                case 10:
                    AppMethodBeat.m2505o(130763);
                    return;
                case 13:
                    AppMethodBeat.m2505o(130763);
                    return;
                case 14:
                    AppMethodBeat.m2505o(130763);
                    return;
                default:
                    AppMethodBeat.m2505o(130763);
                    return;
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final SetBackgroundAudioStateTask mo21752b(C10296a c10296a, C2241c c2241c, int i) {
        AppMethodBeat.m2504i(130765);
        SetBackgroundAudioStateTaskWC setBackgroundAudioStateTaskWC = new SetBackgroundAudioStateTaskWC(c10296a, c2241c, i);
        AppMethodBeat.m2505o(130765);
        return setBackgroundAudioStateTaskWC;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final SetBackgroundAudioListenerTask mo21749a(C10296a c10296a, C2241c c2241c, int i) {
        AppMethodBeat.m2504i(130766);
        SetBackgroundAudioListenerTaskWC setBackgroundAudioListenerTaskWC = new SetBackgroundAudioListenerTaskWC(c10296a, c2241c, i);
        AppMethodBeat.m2505o(130766);
        return setBackgroundAudioListenerTaskWC;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo21751a(String str, C2241c c2241c) {
        AppMethodBeat.m2504i(130767);
        if (this.hAp != null) {
            C16597h c16597h = (C16597h) c2241c.mo5937aa(C16597h.class);
            this.hAp.cBc = c16597h.hhd.gVt;
            this.hAp.cwz = c16597h.cwz;
            this.hAp.cBb = C42641p.m75509a(c2241c);
            C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pkgType:%d, brandName:%s, appUserName", Integer.valueOf(this.hAp.cBc), this.hAp.cwz, this.hAp.cBb);
            final C32800b y = C37922v.m64076Zp().mo60676y(str, true);
            synchronized (y) {
                try {
                    C10835f c10835f = (C10835f) y.get("StickyBannerChangeListener", null);
                    if (c10835f == null) {
                        c10835f = new C10835f() {
                            /* renamed from: bg */
                            public final void mo6073bg(String str, int i) {
                                AppMethodBeat.m2504i(130761);
                                String string = y.getString("appId", "");
                                int i2 = y.getInt("pkgType", 0);
                                if (!((string.equals(str) && i2 == i) || !y.mo53357nX("setBackgroundAudioState#isPlaying") || C33183g.m54287wW(string) == C33185b.ON_RESUME)) {
                                    C4990ab.m7416i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onStickyBannerChanged, pause the music");
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("operationType", "pause");
                                    } catch (JSONException e) {
                                    }
                                    MainProcessTask b = JsApiSetBackgroundAudioStateWC.this.mo21752b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.hAp.hxS, JsApiSetBackgroundAudioStateWC.this.hAp.hwi);
                                    b.hAs = jSONObject.toString();
                                    b.appId = string;
                                    AppBrandMainProcessService.m54349a(b);
                                }
                                AppMethodBeat.m2505o(130761);
                            }
                        };
                        y.mo53356j("pkgType", Integer.valueOf(c16597h.hhd.gVt));
                        y.mo53356j("StickyBannerChangeListener", c10835f);
                        y.mo53356j("appId", c2241c.getAppId());
                    }
                    if (((C33186c) y.get("AppBrandLifeCycle.Listener", null)) == null) {
                        C103002 c103002 = new C33186c() {
                            public final void onDestroy() {
                                AppMethodBeat.m2504i(130762);
                                C4990ab.m7417i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", y.getString("appId", ""));
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("operationType", "stop");
                                } catch (JSONException e) {
                                }
                                MainProcessTask b = JsApiSetBackgroundAudioStateWC.this.mo21752b(JsApiSetBackgroundAudioStateWC.this, JsApiSetBackgroundAudioStateWC.this.hAp.hxS, JsApiSetBackgroundAudioStateWC.this.hAp.hwi);
                                b.hAs = jSONObject.toString();
                                b.appId = r0;
                                AppBrandMainProcessService.m54355b(b);
                                AppMethodBeat.m2505o(130762);
                            }
                        };
                        y.mo53356j("AppBrandLifeCycle.Listener", c103002);
                        this.hAp.huj = c103002;
                    }
                    if (this.hAp instanceof SetBackgroundAudioListenerTaskWC) {
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAy = c10835f;
                        ((SetBackgroundAudioListenerTaskWC) this.hAp).hAx = y;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(130767);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(130767);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final String mo21750a(JSONObject jSONObject, C2241c c2241c) {
        AppMethodBeat.m2504i(130768);
        String a = super.mo21750a(jSONObject, c2241c);
        if (a == null || a.length() <= 0) {
            a = "";
            AppMethodBeat.m2505o(130768);
            return a;
        } else if (a.startsWith("http://") || a.startsWith("https://")) {
            AppMethodBeat.m2505o(130768);
            return a;
        } else {
            File yg = c2241c.asE().mo34314yg(a);
            if (yg == null || !yg.exists()) {
                a = "";
                AppMethodBeat.m2505o(130768);
                return a;
            }
            a = yg.getAbsolutePath();
            if (!a.startsWith("file://")) {
                a = "file://".concat(String.valueOf(a));
            }
            AppMethodBeat.m2505o(130768);
            return a;
        }
    }
}
