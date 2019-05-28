package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C17875b;
import com.tencent.p177mm.p1176ag.C17876c;
import com.tencent.p177mm.p1176ag.C45139e;
import com.tencent.p177mm.p230g.p231a.C18405u;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C19600a;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C2389c;
import com.tencent.p177mm.plugin.appbrand.media.p325a.C33446f;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.k */
public class C42473k extends C10296a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private C19304a hAm;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.k$a */
    public static class C19304a extends C2223a {
        public int action;
        public String appId = "";
        private C4884c hAX = new C193051();
        public String hAz;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.k$a$1 */
        class C193051 extends C4884c<C18405u> {
            C193051() {
                AppMethodBeat.m2504i(137761);
                this.xxI = C18405u.class.getName().hashCode();
                AppMethodBeat.m2505o(137761);
            }

            /* renamed from: a */
            public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                AppMethodBeat.m2504i(137762);
                C18405u c18405u = (C18405u) c4883b;
                if (C19304a.this.appId.equals(c18405u.csP.appId)) {
                    HashMap hashMap = new HashMap();
                    String str = c18405u.csP.state;
                    C4990ab.m7411d("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", Integer.valueOf(c18405u.csP.action), c18405u.csP.ckD, str);
                    hashMap.put("state", str);
                    hashMap.put("audioId", r4);
                    C19304a.this.action = c18405u.csP.action;
                    if (C19304a.this.action == 4) {
                        hashMap.put("errMsg", c18405u.csP.aIm);
                        hashMap.put("errCode", Integer.valueOf(c18405u.csP.errCode));
                    }
                    C19304a.this.hAz = new JSONObject(hashMap).toString();
                    C19304a.this.mo6087wM();
                    AppMethodBeat.m2505o(137762);
                    return true;
                }
                C4990ab.m7417i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", C19304a.this.appId, c18405u.csP.appId, Integer.valueOf(c18405u.csP.action));
                AppMethodBeat.m2505o(137762);
                return false;
            }
        }

        public C19304a(C45608m c45608m, C2241c c2241c, int i) {
            AppMethodBeat.m2504i(137763);
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
            AppMethodBeat.m2505o(137763);
        }

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137764);
            C4990ab.m7410d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
            C19600a.m30385Cs(this.appId);
            C19600a.m30388a(this.appId, this.hAX);
            AppMethodBeat.m2505o(137764);
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137765);
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.m2505o(137765);
                return;
            }
            C4990ab.m7417i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", Integer.valueOf(this.action), this.hAz);
            if (C5046bo.isNullOrNil(this.hAz)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                AppMethodBeat.m2505o(137765);
                return;
            }
            new C42474b().mo61032j(this.hxS).mo61028AM(this.hAz).aCj();
            AppMethodBeat.m2505o(137765);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.k$c */
    static class C42472c extends C2223a {
        public String appId = "";
        public String ckD = "";
        public String ckz = "";
        public boolean error = false;
        public boolean fqK = false;
        public boolean fqL = false;
        public double fqN;
        public long fqP;
        public long fqQ;
        public String gSP;
        public String hAa;
        public int hwi;
        private C45608m hwz;
        public C2241c hxS;
        public String processName = "";
        public int startTime = 0;

        public C42472c(C45608m c45608m, C2241c c2241c, int i) {
            this.hwz = c45608m;
            this.hxS = c2241c;
            this.hwi = i;
        }

        /* renamed from: Dp */
        public final void mo21758Dp() {
            AppMethodBeat.m2504i(137766);
            C4990ab.m7416i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
            this.error = false;
            this.hAa = "";
            C17875b pO = C17876c.m28040pO(this.ckD);
            C17875b c17875b = new C17875b();
            c17875b.ckD = this.ckD;
            c17875b.clP = this.ckz;
            c17875b.startTime = this.startTime;
            c17875b.fqJ = this.startTime;
            c17875b.fqK = this.fqK;
            c17875b.fqL = this.fqL;
            c17875b.processName = this.processName;
            c17875b.fqN = this.fqN;
            c17875b.appId = this.appId;
            c17875b.fromScene = 0;
            c17875b.fqR = this.fqP;
            c17875b.fqS = this.fqQ;
            C42063t c42063t;
            if (pO != null && this.ckz.equalsIgnoreCase(pO.clP) && C17876c.m28039pN(this.ckD)) {
                C4990ab.m7416i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
                C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", c17875b.ckD, c17875b.clP);
                c42063t = new C42063t();
                c42063t.csI.action = 18;
                c42063t.csI.ckD = c17875b.ckD;
                c42063t.csI.csL = c17875b;
                C46093a.m85964a(c42063t);
                if (!c42063t.csJ.csN) {
                    this.error = true;
                    this.hAa = "not to set audio param, the audioId is err";
                    C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
                }
                mo6087wM();
                AppMethodBeat.m2505o(137766);
                return;
            }
            C4990ab.m7417i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", this.appId, this.ckD, this.ckz, Integer.valueOf(this.startTime));
            if (this.ckz.startsWith("file://")) {
                c17875b.filePath = this.ckz.substring(7);
                C4990ab.m7417i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", c17875b.filePath);
            } else if (!(this.ckz.startsWith("http://") || this.ckz.startsWith("https://"))) {
                C45139e cC = C33446f.m54656cC(this.ckz, this.gSP);
                if (cC.isOpen()) {
                    String str;
                    C17875b c17875b2;
                    if (pO == null || !this.ckz.equalsIgnoreCase(pO.clP) || TextUtils.isEmpty(pO.filePath)) {
                        C2241c c2241c = this.hxS;
                        str = this.ckz;
                        if (C5046bo.isNullOrNil(str)) {
                            C4990ab.m7412e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
                            c17875b2 = c17875b;
                        } else if (c2241c.asE() == null) {
                            C4990ab.m7412e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
                            c17875b2 = c17875b;
                        } else {
                            File yg = c2241c.asE().mo34314yg(str);
                            if (yg == null || !yg.exists()) {
                                C4990ab.m7412e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
                                c17875b2 = c17875b;
                            } else {
                                str = yg.getAbsolutePath();
                                C4990ab.m7417i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", str);
                                c17875b2 = c17875b;
                            }
                        }
                    } else {
                        str = pO.filePath;
                        c17875b2 = c17875b;
                    }
                    c17875b2.filePath = str;
                    c17875b.fqV = cC;
                } else {
                    this.error = true;
                    this.hAa = "the file not exist for src";
                    C4990ab.m7413e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", this.ckz);
                    mo6087wM();
                    AppMethodBeat.m2505o(137766);
                    return;
                }
            }
            if (!this.error) {
                C4990ab.m7411d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", c17875b.ckD);
                c42063t = new C42063t();
                c42063t.csI.action = 0;
                c42063t.csI.ckD = c17875b.ckD;
                c42063t.csI.csL = c17875b;
                C46093a.m85964a(c42063t);
            }
            mo6087wM();
            AppMethodBeat.m2505o(137766);
        }

        /* renamed from: wM */
        public final void mo6087wM() {
            AppMethodBeat.m2504i(137767);
            super.mo6087wM();
            if (this.hxS == null) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.m2505o(137767);
            } else if (this.error) {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("fail:" + this.hAa, null));
                AppMethodBeat.m2505o(137767);
            } else {
                this.hxS.mo6107M(this.hwi, this.hwz.mo73394j("ok", null));
                AppMethodBeat.m2505o(137767);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.k$b */
    public static final class C42474b extends C42467ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAudioStateChange";
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137768);
        if (!C19600a.m30386Ct(c2241c.getAppId())) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            c2241c.mo6107M(i, mo73394j("fail:App is paused or background", null));
            AppMethodBeat.m2505o(137768);
        } else if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            c2241c.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(137768);
        } else {
            C4990ab.m7417i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            CharSequence optString2 = jSONObject.optString("src");
            if (C5046bo.isNullOrNil(optString2)) {
                C4990ab.m7412e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
                optString2 = "";
            } else if (!optString2.startsWith("wxfile://")) {
                C4990ab.m7417i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
            } else if (c2241c.asE() == null) {
                C4990ab.m7412e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
                optString2 = "";
            } else {
                File yg = c2241c.asE().mo34314yg(optString2);
                if (yg == null || !yg.exists()) {
                    C4990ab.m7412e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
                    optString2 = "";
                } else {
                    optString2 = yg.getAbsolutePath();
                    if (!(optString2 == null || optString2.startsWith("file://"))) {
                        optString2 = "file://".concat(String.valueOf(optString2));
                    }
                    C4990ab.m7417i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
                }
            }
            boolean optBoolean = jSONObject.optBoolean("autoplay", false);
            boolean optBoolean2 = jSONObject.optBoolean("loop", false);
            double optDouble = jSONObject.optDouble("volume", 1.0d);
            Long valueOf = Long.valueOf(jSONObject.optLong(Param.TIMESTAMP, 0));
            Long valueOf2 = Long.valueOf(0);
            Long valueOf3 = Long.valueOf(System.currentTimeMillis());
            if (!optBoolean) {
                valueOf3 = Long.valueOf(0);
            } else if (valueOf.longValue() > 0 && valueOf.longValue() <= valueOf3.longValue()) {
                valueOf2 = Long.valueOf(valueOf3.longValue() - valueOf.longValue());
            }
            if (TextUtils.isEmpty(optString)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                c2241c.mo6107M(i, mo73394j("fail:audioId is empty", null));
                AppMethodBeat.m2505o(137768);
            } else if (TextUtils.isEmpty(optString2)) {
                C4990ab.m7412e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                c2241c.mo6107M(i, mo73394j("fail:src is empty", null));
                AppMethodBeat.m2505o(137768);
            } else {
                if (this.hAm == null) {
                    this.hAm = new C19304a(this, c2241c, i);
                }
                this.hAm.appId = c2241c.getAppId();
                this.hAm.aCr();
                C42472c c42472c = new C42472c(this, c2241c, i);
                c42472c.appId = c2241c.getAppId();
                c42472c.ckD = optString;
                c42472c.ckz = optString2;
                c42472c.startTime = optInt;
                c42472c.fqK = optBoolean;
                c42472c.fqL = optBoolean2;
                c42472c.gSP = mo67977f(c2241c, optString2);
                c42472c.fqN = optDouble;
                c42472c.processName = C4996ah.getProcessName();
                c42472c.fqP = valueOf2.longValue();
                c42472c.fqQ = valueOf3.longValue();
                c42472c.aCr();
                C2389c c2389c = new C2389c();
                c2389c.gSP = c42472c.gSP;
                c2389c.hAo = jSONObject.toString();
                c2389c.ckz = optString2;
                C19600a.m30387a(optString, c2389c);
                AppMethodBeat.m2505o(137768);
            }
        }
    }

    /* renamed from: f */
    public String mo67977f(C2241c c2241c, String str) {
        return "";
    }
}
