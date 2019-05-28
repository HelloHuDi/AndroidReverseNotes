package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.b;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import org.json.JSONObject;

public class h extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private com.tencent.mm.plugin.appbrand.jsapi.audio.k.a hAm;

    static final class a extends a {
        public String appId = "";
        public String ckD = "";
        public String ckz = "";
        public int csK = 0;
        public boolean error = false;
        public long fqP;
        public long fqQ;
        public String gSP;
        public String hAa;
        public String hAn = "";
        public String hAo;
        public int hwi;
        private m hwz;
        public c hxS;
        public String processName = "";

        public a(m mVar, c cVar, int i) {
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public final void Dp() {
            AppMethodBeat.i(137745);
            ab.i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", this.hAn);
            this.error = false;
            String str = this.hAn;
            t tVar;
            t tVar2;
            if (str.equalsIgnoreCase("play")) {
                b pO = com.tencent.mm.ag.c.pO(this.ckD);
                if (pO == null) {
                    ab.e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                    pO = com.tencent.mm.plugin.appbrand.media.a.b.b(this.appId, this.ckD, this.ckz, this.hAo, this.gSP, this.processName);
                }
                if (pO != null) {
                    pO.fqT = this.fqP;
                    pO.fqU = this.fqQ;
                }
                ab.d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", this.ckD);
                tVar = new t();
                tVar.csI.action = 1;
                tVar.csI.ckD = r1;
                tVar.csI.csL = pO;
                com.tencent.mm.plugin.music.b.a.a(tVar);
                if (tVar.csJ.csN) {
                    ab.i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
                } else if (com.tencent.mm.ag.c.pN(this.ckD)) {
                    this.error = true;
                    this.hAa = "audio is playing, don't play again";
                } else {
                    this.error = true;
                    this.hAa = "play audio fail";
                }
            } else if (str.equalsIgnoreCase("pause")) {
                ab.d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", this.ckD);
                tVar2 = new t();
                tVar2.csI.action = 2;
                tVar2.csI.ckD = str;
                com.tencent.mm.plugin.music.b.a.a(tVar2);
                if (tVar2.csJ.csN) {
                    ab.i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
                } else {
                    this.error = true;
                    this.hAa = "pause audio fail";
                }
            } else if (str.equalsIgnoreCase("seek")) {
                ab.i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", Integer.valueOf(this.csK));
                if (this.csK < 0) {
                    ab.e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(this.csK));
                    this.error = true;
                    this.hAa = "currentTime is invalid";
                } else {
                    ab.i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", this.ckD, Integer.valueOf(this.csK));
                    tVar = new t();
                    tVar.csI.action = 4;
                    tVar.csI.ckD = str;
                    tVar.csI.csK = r1;
                    com.tencent.mm.plugin.music.b.a.a(tVar);
                    if (tVar.csJ.csN) {
                        ab.i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                    } else {
                        this.error = true;
                        this.hAa = "seek audio fail";
                    }
                }
            } else if (str.equalsIgnoreCase("stop")) {
                boolean z;
                str = this.ckD;
                tVar2 = new t();
                tVar2.csI.action = 13;
                tVar2.csI.ckD = str;
                com.tencent.mm.plugin.music.b.a.a(tVar2);
                if (tVar2.csJ.csN) {
                    ab.i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str);
                    tVar2 = new t();
                    tVar2.csI.action = 14;
                    tVar2.csI.ckD = str;
                    com.tencent.mm.plugin.music.b.a.a(tVar2);
                    z = tVar2.csJ.csN;
                } else {
                    tVar2 = new t();
                    tVar2.csI.action = 17;
                    tVar2.csI.ckD = str;
                    com.tencent.mm.plugin.music.b.a.a(tVar2);
                    if (tVar2.csJ.csN) {
                        z = true;
                    } else {
                        ab.i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
                        tVar2 = new t();
                        tVar2.csI.action = 3;
                        tVar2.csI.ckD = str;
                        com.tencent.mm.plugin.music.b.a.a(tVar2);
                        z = tVar2.csJ.csN;
                    }
                }
                if (z) {
                    ab.i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
                } else {
                    this.error = true;
                    this.hAa = "stop audio fail";
                }
            } else {
                ab.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
                this.error = true;
                this.hAa = "operationType is invalid";
            }
            if (this.error) {
                ab.e("MicroMsg.Audio.JsApiOperateAudio", this.hAa);
            }
            wM();
            AppMethodBeat.o(137745);
        }

        public final void wM() {
            AppMethodBeat.i(137746);
            super.wM();
            if (this.hxS == null) {
                ab.e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
                AppMethodBeat.o(137746);
            } else if (this.error) {
                this.hxS.M(this.hwi, this.hwz.j("fail:" + this.hAa, null));
                AppMethodBeat.o(137746);
            } else {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(137746);
            }
        }
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        long j = 0;
        AppMethodBeat.i(137747);
        if (!com.tencent.mm.plugin.appbrand.media.a.a.Ct(cVar.getAppId())) {
            ab.e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            cVar.M(i, j("fail:App is paused or background", null));
            AppMethodBeat.o(137747);
        } else if (jSONObject == null) {
            ab.e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(137747);
        } else {
            ab.i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", cVar.getAppId(), jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            String optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                ab.e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                cVar.M(i, j("fail:audioId is empty", null));
                AppMethodBeat.o(137747);
            } else if (TextUtils.isEmpty(optString2)) {
                ab.e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                cVar.M(i, j("fail:operationType is empty", null));
                AppMethodBeat.o(137747);
            } else {
                if (this.hAm == null) {
                    this.hAm = new com.tencent.mm.plugin.appbrand.jsapi.audio.k.a(this, cVar, i);
                }
                this.hAm.appId = cVar.getAppId();
                this.hAm.aCr();
                a aVar = new a(this, cVar, i);
                aVar.appId = cVar.getAppId();
                aVar.ckD = optString;
                aVar.csK = optInt;
                aVar.hAn = optString2;
                if (optString2.equalsIgnoreCase("play")) {
                    long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (optLong > 0 && optLong < currentTimeMillis) {
                        j = currentTimeMillis - optLong;
                    }
                    aVar.fqP = j;
                    aVar.fqQ = currentTimeMillis;
                }
                com.tencent.mm.plugin.appbrand.media.a.c Cr = com.tencent.mm.plugin.appbrand.media.a.a.Cr(optString);
                if (Cr != null) {
                    aVar.hAo = Cr.hAo;
                    aVar.gSP = Cr.gSP;
                    aVar.ckz = Cr.ckz;
                }
                aVar.processName = ah.getProcessName();
                aVar.aCr();
                AppMethodBeat.o(137747);
            }
        }
    }
}
