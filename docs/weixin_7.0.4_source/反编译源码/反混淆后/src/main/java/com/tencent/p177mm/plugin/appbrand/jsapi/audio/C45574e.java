package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.e */
public final class C45574e extends C10296a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.e$a */
    static class C19297a extends C2223a {
        public String appId = "";
        public String ckD = "";
        public boolean error = false;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;

        public C19297a(C45608m c45608m, C2241c c2241c, int i) {
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
        }

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137723);
            C4990ab.m7416i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
            C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", this.ckD);
            C42063t c42063t = new C42063t();
            c42063t.csI.action = 5;
            c42063t.csI.ckD = r0;
            C46093a.m85964a(c42063t);
            this.error = c42063t.csJ.csN;
            mo6087wM();
            AppMethodBeat.m2505o(137723);
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137724);
            super.mo6087wM();
            C4990ab.m7416i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
                AppMethodBeat.m2505o(137724);
            } else if (this.error) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail", null));
                AppMethodBeat.m2505o(137724);
            } else {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(137724);
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137725);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(137725);
            return;
        }
        C4990ab.m7417i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            c2241c.mo6107M(i, mo73394j("fail:audioId is empty", null));
            AppMethodBeat.m2505o(137725);
            return;
        }
        C19297a c19297a = new C19297a(this, c2241c, i);
        c19297a.appId = c2241c.getAppId();
        c19297a.ckD = optString;
        c19297a.aCr();
        AppMethodBeat.m2505o(137725);
    }
}
