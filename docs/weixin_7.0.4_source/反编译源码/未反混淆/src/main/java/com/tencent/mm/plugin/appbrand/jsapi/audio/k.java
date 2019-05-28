package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.text.TextUtils;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.e;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.u;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import org.json.JSONObject;

public class k extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 292;
    public static final String NAME = "setAudioState";
    private a hAm;

    public static class a extends a {
        public int action;
        public String appId = "";
        private com.tencent.mm.sdk.b.c hAX = new com.tencent.mm.sdk.b.c<u>() {
            {
                AppMethodBeat.i(137761);
                this.xxI = u.class.getName().hashCode();
                AppMethodBeat.o(137761);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(137762);
                u uVar = (u) bVar;
                if (a.this.appId.equals(uVar.csP.appId)) {
                    HashMap hashMap = new HashMap();
                    String str = uVar.csP.state;
                    ab.d("MicroMsg.Audio.JsApiSetAudioState", "mAudioListener callback action:%d， audioId:%s, state:%s", Integer.valueOf(uVar.csP.action), uVar.csP.ckD, str);
                    hashMap.put("state", str);
                    hashMap.put("audioId", r4);
                    a.this.action = uVar.csP.action;
                    if (a.this.action == 4) {
                        hashMap.put("errMsg", uVar.csP.aIm);
                        hashMap.put("errCode", Integer.valueOf(uVar.csP.errCode));
                    }
                    a.this.hAz = new JSONObject(hashMap).toString();
                    a.this.wM();
                    AppMethodBeat.o(137762);
                    return true;
                }
                ab.i("MicroMsg.Audio.JsApiSetAudioState", "appId is not equals preAppId, don't send any event, appId:%s, eventAppId:%s, action:%d", a.this.appId, uVar.csP.appId, Integer.valueOf(uVar.csP.action));
                AppMethodBeat.o(137762);
                return false;
            }
        };
        public String hAz;
        public int hwi;
        private m hwz;
        public com.tencent.mm.plugin.appbrand.jsapi.c hxS;

        public a(m mVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i) {
            AppMethodBeat.i(137763);
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
            AppMethodBeat.o(137763);
        }

        public final void Dp() {
            AppMethodBeat.i(137764);
            ab.d("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask, runTask");
            com.tencent.mm.plugin.appbrand.media.a.a.Cs(this.appId);
            com.tencent.mm.plugin.appbrand.media.a.a.a(this.appId, this.hAX);
            AppMethodBeat.o(137764);
        }

        public final void wM() {
            AppMethodBeat.i(137765);
            if (this.hxS == null) {
                ab.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.o(137765);
                return;
            }
            ab.i("MicroMsg.Audio.JsApiSetAudioState", "AudioListenerTask action:%d, retJson:%s", Integer.valueOf(this.action), this.hAz);
            if (bo.isNullOrNil(this.hAz)) {
                ab.e("MicroMsg.Audio.JsApiSetAudioState", "jsonResult is null, err");
                AppMethodBeat.o(137765);
                return;
            }
            new b().j(this.hxS).AM(this.hAz).aCj();
            AppMethodBeat.o(137765);
        }
    }

    static class c extends a {
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
        private m hwz;
        public com.tencent.mm.plugin.appbrand.jsapi.c hxS;
        public String processName = "";
        public int startTime = 0;

        public c(m mVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i) {
            this.hwz = mVar;
            this.hxS = cVar;
            this.hwi = i;
        }

        public final void Dp() {
            AppMethodBeat.i(137766);
            ab.i("MicroMsg.Audio.JsApiSetAudioState", "SetAudioTask runTask");
            this.error = false;
            this.hAa = "";
            com.tencent.mm.ag.b pO = com.tencent.mm.ag.c.pO(this.ckD);
            com.tencent.mm.ag.b bVar = new com.tencent.mm.ag.b();
            bVar.ckD = this.ckD;
            bVar.clP = this.ckz;
            bVar.startTime = this.startTime;
            bVar.fqJ = this.startTime;
            bVar.fqK = this.fqK;
            bVar.fqL = this.fqL;
            bVar.processName = this.processName;
            bVar.fqN = this.fqN;
            bVar.appId = this.appId;
            bVar.fromScene = 0;
            bVar.fqR = this.fqP;
            bVar.fqS = this.fqQ;
            t tVar;
            if (pO != null && this.ckz.equalsIgnoreCase(pO.clP) && com.tencent.mm.ag.c.pN(this.ckD)) {
                ab.i("MicroMsg.Audio.JsApiSetAudioState", "same src is playing audio, not to start again, but setAudioParam to update");
                ab.i("MicroMsg.AudioPlayerHelper", "setAudioParam, audioId:%s, src:%s", bVar.ckD, bVar.clP);
                tVar = new t();
                tVar.csI.action = 18;
                tVar.csI.ckD = bVar.ckD;
                tVar.csI.csL = bVar;
                com.tencent.mm.plugin.music.b.a.a(tVar);
                if (!tVar.csJ.csN) {
                    this.error = true;
                    this.hAa = "not to set audio param, the audioId is err";
                    ab.e("MicroMsg.Audio.JsApiSetAudioState", "not to set audio param, the audioId is err");
                }
                wM();
                AppMethodBeat.o(137766);
                return;
            }
            ab.i("MicroMsg.Audio.JsApiSetAudioState", "appId:%s, audioId:%s, src:%s, startTime:%d", this.appId, this.ckD, this.ckz, Integer.valueOf(this.startTime));
            if (this.ckz.startsWith("file://")) {
                bVar.filePath = this.ckz.substring(7);
                ab.i("MicroMsg.Audio.JsApiSetAudioState", "filePath:%s", bVar.filePath);
            } else if (!(this.ckz.startsWith("http://") || this.ckz.startsWith("https://"))) {
                e cC = f.cC(this.ckz, this.gSP);
                if (cC.isOpen()) {
                    String str;
                    com.tencent.mm.ag.b bVar2;
                    if (pO == null || !this.ckz.equalsIgnoreCase(pO.clP) || TextUtils.isEmpty(pO.filePath)) {
                        com.tencent.mm.plugin.appbrand.jsapi.c cVar = this.hxS;
                        str = this.ckz;
                        if (bo.isNullOrNil(str)) {
                            ab.e("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg src is empty");
                            bVar2 = bVar;
                        } else if (cVar.asE() == null) {
                            ab.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]service.getFileSystem() is null");
                            bVar2 = bVar;
                        } else {
                            File yg = cVar.asE().yg(str);
                            if (yg == null || !yg.exists()) {
                                ab.e("MicroMsg.WxaAudioUtils", "[getLocalFilePathFromWxaPkg]localFile is null");
                                bVar2 = bVar;
                            } else {
                                str = yg.getAbsolutePath();
                                ab.i("MicroMsg.WxaAudioUtils", "getLocalFilePathFromWxaPkg:path:%s", str);
                                bVar2 = bVar;
                            }
                        }
                    } else {
                        str = pO.filePath;
                        bVar2 = bVar;
                    }
                    bVar2.filePath = str;
                    bVar.fqV = cC;
                } else {
                    this.error = true;
                    this.hAa = "the file not exist for src";
                    ab.e("MicroMsg.Audio.JsApiSetAudioState", "the wxa audioDataSource not found for src %s", this.ckz);
                    wM();
                    AppMethodBeat.o(137766);
                    return;
                }
            }
            if (!this.error) {
                ab.d("MicroMsg.AudioPlayerHelper", "startAudio, audioId:%s", bVar.ckD);
                tVar = new t();
                tVar.csI.action = 0;
                tVar.csI.ckD = bVar.ckD;
                tVar.csI.csL = bVar;
                com.tencent.mm.plugin.music.b.a.a(tVar);
            }
            wM();
            AppMethodBeat.o(137766);
        }

        public final void wM() {
            AppMethodBeat.i(137767);
            super.wM();
            if (this.hxS == null) {
                ab.e("MicroMsg.Audio.JsApiSetAudioState", "server is null");
                AppMethodBeat.o(137767);
            } else if (this.error) {
                this.hxS.M(this.hwi, this.hwz.j("fail:" + this.hAa, null));
                AppMethodBeat.o(137767);
            } else {
                this.hxS.M(this.hwi, this.hwz.j("ok", null));
                AppMethodBeat.o(137767);
            }
        }
    }

    public static final class b extends ah {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAudioStateChange";
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137768);
        if (!com.tencent.mm.plugin.appbrand.media.a.a.Ct(cVar.getAppId())) {
            ab.e("MicroMsg.Audio.JsApiSetAudioState", "can't do operateAudio, App is paused or background");
            cVar.M(i, j("fail:App is paused or background", null));
            AppMethodBeat.o(137768);
        } else if (jSONObject == null) {
            ab.e("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data is null");
            cVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(137768);
        } else {
            ab.i("MicroMsg.Audio.JsApiSetAudioState", "setAudioState data:%s", jSONObject.toString());
            String optString = jSONObject.optString("audioId");
            int optInt = jSONObject.optInt("startTime", 0);
            CharSequence optString2 = jSONObject.optString("src");
            if (bo.isNullOrNil(optString2)) {
                ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]src is empty");
                optString2 = "";
            } else if (!optString2.startsWith("wxfile://")) {
                ab.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
            } else if (cVar.asE() == null) {
                ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]service.getRuntime().getFileSystem() is null");
                optString2 = "";
            } else {
                File yg = cVar.asE().yg(optString2);
                if (yg == null || !yg.exists()) {
                    ab.e("MicroMsg.WxaAudioUtils", "[getRealSrc]localFile is null");
                    optString2 = "";
                } else {
                    optString2 = yg.getAbsolutePath();
                    if (!(optString2 == null || optString2.startsWith("file://"))) {
                        optString2 = "file://".concat(String.valueOf(optString2));
                    }
                    ab.i("MicroMsg.WxaAudioUtils", "getRealSrc:src:%s", optString2);
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
                ab.e("MicroMsg.Audio.JsApiSetAudioState", "audioId is empty");
                cVar.M(i, j("fail:audioId is empty", null));
                AppMethodBeat.o(137768);
            } else if (TextUtils.isEmpty(optString2)) {
                ab.e("MicroMsg.Audio.JsApiSetAudioState", "src is empty");
                cVar.M(i, j("fail:src is empty", null));
                AppMethodBeat.o(137768);
            } else {
                if (this.hAm == null) {
                    this.hAm = new a(this, cVar, i);
                }
                this.hAm.appId = cVar.getAppId();
                this.hAm.aCr();
                c cVar2 = new c(this, cVar, i);
                cVar2.appId = cVar.getAppId();
                cVar2.ckD = optString;
                cVar2.ckz = optString2;
                cVar2.startTime = optInt;
                cVar2.fqK = optBoolean;
                cVar2.fqL = optBoolean2;
                cVar2.gSP = f(cVar, optString2);
                cVar2.fqN = optDouble;
                cVar2.processName = com.tencent.mm.sdk.platformtools.ah.getProcessName();
                cVar2.fqP = valueOf2.longValue();
                cVar2.fqQ = valueOf3.longValue();
                cVar2.aCr();
                com.tencent.mm.plugin.appbrand.media.a.c cVar3 = new com.tencent.mm.plugin.appbrand.media.a.c();
                cVar3.gSP = cVar2.gSP;
                cVar3.hAo = jSONObject.toString();
                cVar3.ckz = optString2;
                com.tencent.mm.plugin.appbrand.media.a.a.a(optString, cVar3);
                AppMethodBeat.o(137768);
            }
        }
    }

    public String f(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
        return "";
    }
}
