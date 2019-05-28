package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.d;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

public class f extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    static class a extends a {
        public String appId = "";
        public String ckD = "";
        public String ckz;
        public int csK;
        public int duration = 0;
        public boolean error = false;
        public int fSc;
        public int fqZ;
        public String hAa;
        public int hwi;
        private m hwz;
        public c hxS;
        public int startTime;

        public a(m mVar, c cVar, int i) {
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public final void Dp() {
            AppMethodBeat.i(137726);
            String str = this.ckD;
            t tVar = new t();
            tVar.csI.action = 6;
            tVar.csI.ckD = str;
            com.tencent.mm.plugin.music.b.a.a(tVar);
            d dVar = tVar.csJ.csO;
            if (dVar == null) {
                ab.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", this.ckD);
                this.error = true;
                this.hAa = "return parameter is invalid";
                wM();
                AppMethodBeat.o(137726);
            } else if (dVar.duration < 0 || dVar.csK < 0) {
                ab.e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", Integer.valueOf(dVar.duration), Integer.valueOf(dVar.csK));
                this.error = true;
                this.hAa = "return parameter is invalid";
                wM();
                AppMethodBeat.o(137726);
            } else {
                this.duration = dVar.duration;
                this.csK = dVar.csK;
                this.fSc = dVar.rw ? 1 : 0;
                this.ckz = dVar.ckz;
                this.fqZ = dVar.fqZ;
                this.startTime = dVar.startTime;
                ab.d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", Integer.valueOf(this.duration), Integer.valueOf(this.csK), Integer.valueOf(this.fSc), Integer.valueOf(this.fqZ), this.ckz, Integer.valueOf(this.startTime));
                wM();
                AppMethodBeat.o(137726);
            }
        }

        public final void wM() {
            AppMethodBeat.i(137727);
            if (this.hxS == null) {
                ab.e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
                AppMethodBeat.o(137727);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(this.duration));
            hashMap.put("currentTime", Integer.valueOf(this.csK));
            hashMap.put("paused", Boolean.valueOf(this.fSc == 1));
            hashMap.put("buffered", Integer.valueOf(this.fqZ));
            hashMap.put("src", this.ckz);
            hashMap.put("startTime", Integer.valueOf(this.startTime));
            Object obj = TextUtils.isEmpty(this.hAa) ? "" : this.hAa;
            if (this.error) {
                ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", obj);
                this.hxS.M(this.hwi, this.hwz.j("fail:".concat(String.valueOf(obj)), null));
                AppMethodBeat.o(137727);
                return;
            }
            this.hxS.M(this.hwi, this.hwz.j("ok", hashMap));
            AppMethodBeat.o(137727);
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137728);
        if (jSONObject == null) {
            ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(137728);
            return;
        }
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            ab.e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            cVar.M(i, j("fail:audioId is empty", null));
            AppMethodBeat.o(137728);
            return;
        }
        a aVar = new a(this, cVar, i);
        aVar.appId = cVar.getAppId();
        aVar.ckD = optString;
        aVar.aCr();
        AppMethodBeat.o(137728);
    }
}
