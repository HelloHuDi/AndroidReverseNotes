package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C17876c;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C42473k.C19304a;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C19600a;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C2389c;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C27196b;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.h */
public class C16633h extends C10296a {
    public static final int CTRL_INDEX = 297;
    public static final String NAME = "operateAudio";
    private C19304a hAm;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.h$a */
    static final class C16634a extends C2223a {
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
        private C45608m hwz;
        public C2241c hxS;
        public String processName = "";

        public C16634a(C45608m c45608m, C2241c c2241c, int i) {
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
        }

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137745);
            C4990ab.m7417i("MicroMsg.Audio.JsApiOperateAudio", "runTask operationType;%s", this.hAn);
            this.error = false;
            String str = this.hAn;
            C42063t c42063t;
            C42063t c42063t2;
            if (str.equalsIgnoreCase("play")) {
                C17875b pO = C17876c.m28040pO(this.ckD);
                if (pO == null) {
                    C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "play operate, playParam is null");
                    pO = C27196b.m43209b(this.appId, this.ckD, this.ckz, this.hAo, this.gSP, this.processName);
                }
                if (pO != null) {
                    pO.fqT = this.fqP;
                    pO.fqU = this.fqQ;
                }
                C4990ab.m7411d("MicroMsg.AudioPlayerHelper", "resumeAudio, audioId:%s", this.ckD);
                c42063t = new C42063t();
                c42063t.csI.action = 1;
                c42063t.csI.ckD = r1;
                c42063t.csI.csL = pO;
                C46093a.m85964a(c42063t);
                if (c42063t.csJ.csN) {
                    C4990ab.m7416i("MicroMsg.Audio.JsApiOperateAudio", "play audio ok");
                } else if (C17876c.m28039pN(this.ckD)) {
                    this.error = true;
                    this.hAa = "audio is playing, don't play again";
                } else {
                    this.error = true;
                    this.hAa = "play audio fail";
                }
            } else if (str.equalsIgnoreCase("pause")) {
                C4990ab.m7411d("MicroMsg.AudioPlayerHelper", "pauseAudio, audioId:%s", this.ckD);
                c42063t2 = new C42063t();
                c42063t2.csI.action = 2;
                c42063t2.csI.ckD = str;
                C46093a.m85964a(c42063t2);
                if (c42063t2.csJ.csN) {
                    C4990ab.m7416i("MicroMsg.Audio.JsApiOperateAudio", "pause audio ok");
                } else {
                    this.error = true;
                    this.hAa = "pause audio fail";
                }
            } else if (str.equalsIgnoreCase("seek")) {
                C4990ab.m7417i("MicroMsg.Audio.JsApiOperateAudio", "currentTime:%d", Integer.valueOf(this.csK));
                if (this.csK < 0) {
                    C4990ab.m7413e("MicroMsg.Audio.JsApiOperateAudio", "currentTime %d is invalid!", Integer.valueOf(this.csK));
                    this.error = true;
                    this.hAa = "currentTime is invalid";
                } else {
                    C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "seekToAudio, audioId:%s, currentTime:%d", this.ckD, Integer.valueOf(this.csK));
                    c42063t = new C42063t();
                    c42063t.csI.action = 4;
                    c42063t.csI.ckD = str;
                    c42063t.csI.csK = r1;
                    C46093a.m85964a(c42063t);
                    if (c42063t.csJ.csN) {
                        C4990ab.m7416i("MicroMsg.Audio.JsApiOperateAudio", "seek audio ok");
                    } else {
                        this.error = true;
                        this.hAa = "seek audio fail";
                    }
                }
            } else if (str.equalsIgnoreCase("stop")) {
                boolean z;
                str = this.ckD;
                c42063t2 = new C42063t();
                c42063t2.csI.action = 13;
                c42063t2.csI.ckD = str;
                C46093a.m85964a(c42063t2);
                if (c42063t2.csJ.csN) {
                    C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "stopAudioOnBackground, audioId:%s", str);
                    c42063t2 = new C42063t();
                    c42063t2.csI.action = 14;
                    c42063t2.csI.ckD = str;
                    C46093a.m85964a(c42063t2);
                    z = c42063t2.csJ.csN;
                } else {
                    c42063t2 = new C42063t();
                    c42063t2.csI.action = 17;
                    c42063t2.csI.ckD = str;
                    C46093a.m85964a(c42063t2);
                    if (c42063t2.csJ.csN) {
                        z = true;
                    } else {
                        C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "stopAudio, audioId:%s", str);
                        c42063t2 = new C42063t();
                        c42063t2.csI.action = 3;
                        c42063t2.csI.ckD = str;
                        C46093a.m85964a(c42063t2);
                        z = c42063t2.csJ.csN;
                    }
                }
                if (z) {
                    C4990ab.m7416i("MicroMsg.Audio.JsApiOperateAudio", "stop audio ok");
                } else {
                    this.error = true;
                    this.hAa = "stop audio fail";
                }
            } else {
                C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "operationType is invalid");
                this.error = true;
                this.hAa = "operationType is invalid";
            }
            if (this.error) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", this.hAa);
            }
            mo6087wM();
            AppMethodBeat.m2505o(137745);
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137746);
            super.mo6087wM();
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "server is null");
                AppMethodBeat.m2505o(137746);
            } else if (this.error) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:" + this.hAa, null));
                AppMethodBeat.m2505o(137746);
            } else {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(137746);
            }
        }
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        long j = 0;
        AppMethodBeat.m2504i(137747);
        if (!C19600a.m30386Ct(c2241c.getAppId())) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "can't do operateAudio, App is paused or background");
            c2241c.mo6107M(i, mo73394j("fail:App is paused or background", null));
            AppMethodBeat.m2505o(137747);
        } else if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "operateAudio data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(137747);
        } else {
            C4990ab.m7417i("MicroMsg.Audio.JsApiOperateAudio", "operateAudio appId:%s, data:%s", c2241c.getAppId(), jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("currentTime", 0);
            String optString2 = jSONObject.optString("operationType");
            if (TextUtils.isEmpty(optString)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "audioId is empty");
                c2241c.mo6107M(i, mo73394j("fail:audioId is empty", null));
                AppMethodBeat.m2505o(137747);
            } else if (TextUtils.isEmpty(optString2)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiOperateAudio", "operationType is empty");
                c2241c.mo6107M(i, mo73394j("fail:operationType is empty", null));
                AppMethodBeat.m2505o(137747);
            } else {
                if (this.hAm == null) {
                    this.hAm = new C19304a(this, c2241c, i);
                }
                this.hAm.appId = c2241c.getAppId();
                this.hAm.aCr();
                C16634a c16634a = new C16634a(this, c2241c, i);
                c16634a.appId = c2241c.getAppId();
                c16634a.ckD = optString;
                c16634a.csK = optInt;
                c16634a.hAn = optString2;
                if (optString2.equalsIgnoreCase("play")) {
                    long optLong = jSONObject.optLong(Param.TIMESTAMP, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (optLong > 0 && optLong < currentTimeMillis) {
                        j = currentTimeMillis - optLong;
                    }
                    c16634a.fqP = j;
                    c16634a.fqQ = currentTimeMillis;
                }
                C2389c Cr = C19600a.m30384Cr(optString);
                if (Cr != null) {
                    c16634a.hAo = Cr.hAo;
                    c16634a.gSP = Cr.gSP;
                    c16634a.ckz = Cr.ckz;
                }
                c16634a.processName = C4996ah.getProcessName();
                c16634a.aCr();
                AppMethodBeat.m2505o(137747);
            }
        }
    }
}
