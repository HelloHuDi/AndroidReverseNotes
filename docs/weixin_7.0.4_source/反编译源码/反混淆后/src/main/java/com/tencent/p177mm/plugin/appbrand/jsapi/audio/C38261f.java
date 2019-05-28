package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C41729d;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.f */
public class C38261f extends C10296a {
    public static final int CTRL_INDEX = 293;
    public static final String NAME = "getAudioState";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.f$a */
    static class C26924a extends C2223a {
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
        private C45608m hwz;
        public C2241c hxS;
        public int startTime;

        public C26924a(C45608m c45608m, C2241c c2241c, int i) {
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
        }

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137726);
            String str = this.ckD;
            C42063t c42063t = new C42063t();
            c42063t.csI.action = 6;
            c42063t.csI.ckD = str;
            C46093a.m85964a(c42063t);
            C41729d c41729d = c42063t.csJ.csO;
            if (c41729d == null) {
                C4990ab.m7413e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, audioState is null, audioId:%s", this.ckD);
                this.error = true;
                this.hAa = "return parameter is invalid";
                mo6087wM();
                AppMethodBeat.m2505o(137726);
            } else if (c41729d.duration < 0 || c41729d.csK < 0) {
                C4990ab.m7413e("MicroMsg.Audio.JsApiGetAudioState", "return parameter is invalid, duration:%d, currentTime:%d", Integer.valueOf(c41729d.duration), Integer.valueOf(c41729d.csK));
                this.error = true;
                this.hAa = "return parameter is invalid";
                mo6087wM();
                AppMethodBeat.m2505o(137726);
            } else {
                this.duration = c41729d.duration;
                this.csK = c41729d.csK;
                this.fSc = c41729d.f17164rw ? 1 : 0;
                this.ckz = c41729d.ckz;
                this.fqZ = c41729d.fqZ;
                this.startTime = c41729d.startTime;
                C4990ab.m7411d("MicroMsg.Audio.JsApiGetAudioState", "duration: %d , currentTime: %d ,paused: %d , buffered: %d , src: %s, startTime:%d", Integer.valueOf(this.duration), Integer.valueOf(this.csK), Integer.valueOf(this.fSc), Integer.valueOf(this.fqZ), this.ckz, Integer.valueOf(this.startTime));
                mo6087wM();
                AppMethodBeat.m2505o(137726);
            }
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137727);
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiGetAudioState", "service is null");
                AppMethodBeat.m2505o(137727);
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
                C4990ab.m7413e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState fail, err:%s", obj);
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:".concat(String.valueOf(obj)), null));
                AppMethodBeat.m2505o(137727);
                return;
            }
            this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", hashMap));
            AppMethodBeat.m2505o(137727);
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137728);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(137728);
            return;
        }
        String optString = jSONObject.optString("audioId");
        if (TextUtils.isEmpty(optString)) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiGetAudioState", "getAudioState audioId is empty");
            c2241c.mo6107M(i, mo73394j("fail:audioId is empty", null));
            AppMethodBeat.m2505o(137728);
            return;
        }
        C26924a c26924a = new C26924a(this, c2241c, i);
        c26924a.appId = c2241c.getAppId();
        c26924a.ckD = optString;
        c26924a.aCr();
        AppMethodBeat.m2505o(137728);
    }
}
