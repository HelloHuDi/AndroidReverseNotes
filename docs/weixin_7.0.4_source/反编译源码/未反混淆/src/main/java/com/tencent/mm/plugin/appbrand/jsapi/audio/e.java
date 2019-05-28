package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 290;
    public static final String NAME = "destroyAudioInstance";

    static class a extends a {
        public String appId = "";
        public String ckD = "";
        public boolean error = false;
        public int hwi;
        private m hwz;
        public c hxS;

        public a(m mVar, c cVar, int i) {
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public final void Dp() {
            AppMethodBeat.i(137723);
            ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "runTask");
            ab.i("MicroMsg.AudioPlayerHelper", "destroyAudio, audioId:%s", this.ckD);
            t tVar = new t();
            tVar.csI.action = 5;
            tVar.csI.ckD = r0;
            com.tencent.mm.plugin.music.b.a.a(tVar);
            this.error = tVar.csJ.csN;
            wM();
            AppMethodBeat.o(137723);
        }

        public final void wM() {
            AppMethodBeat.i(137724);
            super.wM();
            ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "callback");
            if (this.hxS == null) {
                ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "server is null");
                AppMethodBeat.o(137724);
            } else if (this.error) {
                this.hxS.M(this.hwi, this.hwz.j("fail", null));
                AppMethodBeat.o(137724);
            } else {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(137724);
            }
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137725);
        if (jSONObject == null) {
            ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance fail, data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(137725);
            return;
        }
        ab.i("MicroMsg.Audio.JsApiDestroyInstanceAudio", "destroyAudioInstance data:%s", jSONObject.toString());
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            ab.e("MicroMsg.Audio.JsApiDestroyInstanceAudio", "audioId is empty");
            cVar.M(i, j("fail:audioId is empty", null));
            AppMethodBeat.o(137725);
            return;
        }
        a aVar = new a(this, cVar, i);
        aVar.appId = cVar.getAppId();
        aVar.ckD = optString;
        aVar.aCr();
        AppMethodBeat.o(137725);
    }
}
