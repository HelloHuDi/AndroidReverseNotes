package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C19600a;
import com.tencent.p177mm.plugin.music.p460b.C28542e;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.d */
public class C33242d extends C19497u {
    public static final int CTRL_INDEX = 291;
    public static final String NAME = "createAudioInstance";
    private static Vector<String> hzY = new Vector();

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.d$a */
    static class C33243a extends C2223a {
        public String appId = "";
        public int bJt = 0;
        public String ckD = "";
        public String hAa = "";

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137719);
            C4990ab.m7417i("MicroMsg.Audio.JsApiCreateAudioInstance", "runTask flag:%d", Integer.valueOf(this.bJt));
            this.hAa = "";
            C42063t c42063t;
            if (this.bJt == 0) {
                C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "createAudioPlayer, appId:%s, audioId:%s", this.appId, this.ckD);
                C42063t c42063t2 = new C42063t();
                c42063t2.csI.action = 10;
                c42063t2.csI.appId = r0;
                c42063t2.csI.ckD = r1;
                C46093a.m85964a(c42063t2);
                this.ckD = c42063t2.csI.ckD;
                C4990ab.m7417i("MicroMsg.Audio.JsApiCreateAudioInstance", "player audioId:%s", this.ckD);
                if (TextUtils.isEmpty(this.ckD)) {
                    this.hAa = "fail to create audio instance";
                }
            } else if (this.bJt == 1) {
                C4990ab.m7416i("MicroMsg.Audio.JsApiCreateAudioInstance", "pauseAllAudioPlayer");
                C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "pauseAllAudioPlayer appId:%s", this.appId);
                c42063t = new C42063t();
                c42063t.csI.action = 12;
                c42063t.csI.appId = r0;
                C46093a.m85964a(c42063t);
            } else if (this.bJt == 2) {
                C4990ab.m7416i("MicroMsg.Audio.JsApiCreateAudioInstance", "stopAllAudioPlayer");
                C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "destroyAllAudioPlayer appId:%s", this.appId);
                c42063t = new C42063t();
                c42063t.csI.action = 9;
                c42063t.csI.appId = r0;
                C46093a.m85964a(c42063t);
                C19600a.m30385Cs(this.appId);
            }
            mo6087wM();
            AppMethodBeat.m2505o(137719);
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137720);
            super.mo6087wM();
            if (this.bJt != 0) {
                if (this.bJt != 1) {
                    C4990ab.m7412e("MicroMsg.Audio.JsApiCreateAudioInstance", "destroy audio instance end");
                }
                AppMethodBeat.m2505o(137720);
            } else if (TextUtils.isEmpty(this.ckD)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiCreateAudioInstance", "create player failed");
                AppMethodBeat.m2505o(137720);
            } else {
                C4990ab.m7416i("MicroMsg.Audio.JsApiCreateAudioInstance", "create player ok");
                AppMethodBeat.m2505o(137720);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(137722);
        AppMethodBeat.m2505o(137722);
    }

    /* renamed from: b */
    public final String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(137721);
        final String appId = c2241c.getAppId();
        String bSy = C28542e.bSy();
        HashMap hashMap = new HashMap();
        hashMap.put("audioId", bSy);
        C4990ab.m7417i("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", appId, bSy);
        C33243a c33243a = new C33243a();
        c33243a.ckD = bSy;
        c33243a.bJt = 0;
        c33243a.appId = appId;
        c33243a.aCr();
        C33186c c269231 = new C33186c() {
            public final void onCreate() {
                AppMethodBeat.m2504i(137715);
                C19600a.m30389ao(appId, true);
                AppMethodBeat.m2505o(137715);
            }

            public final void onResume() {
                AppMethodBeat.m2504i(137716);
                C19600a.m30389ao(appId, true);
                AppMethodBeat.m2505o(137716);
            }

            /* renamed from: a */
            public final void mo6074a(C33184d c33184d) {
                AppMethodBeat.m2504i(137717);
                C4990ab.m7417i("MicroMsg.Audio.JsApiCreateAudioInstance", "onPause, appId:%s", appId);
                C19600a.m30389ao(appId, false);
                C33243a c33243a = new C33243a();
                c33243a.bJt = 1;
                c33243a.appId = appId;
                c33243a.aCr();
                AppMethodBeat.m2505o(137717);
            }

            public final void onDestroy() {
                AppMethodBeat.m2504i(137718);
                C4990ab.m7417i("MicroMsg.Audio.JsApiCreateAudioInstance", "onDestroy, appId:%s", appId);
                C33243a c33243a = new C33243a();
                c33243a.bJt = 2;
                c33243a.appId = appId;
                c33243a.aCs();
                C33183g.m54276b(appId, this);
                C33242d.hzY.remove(appId);
                AppMethodBeat.m2505o(137718);
            }
        };
        if (!hzY.contains(appId)) {
            C33183g.m54274a(appId, c269231);
            hzY.add(appId);
        }
        appId = mo73394j("ok", hashMap);
        AppMethodBeat.m2505o(137721);
        return appId;
    }
}
