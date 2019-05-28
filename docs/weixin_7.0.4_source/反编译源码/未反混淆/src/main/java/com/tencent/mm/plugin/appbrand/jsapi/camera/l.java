package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import org.json.JSONObject;

public final class l extends a {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    public final void a(final c cVar, final JSONObject jSONObject, final int i) {
        AppMethodBeat.i(126252);
        if (jSONObject == null) {
            cVar.M(i, j("fail:data is null or nil", null));
            AppMethodBeat.o(126252);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                e eVar;
                AppMethodBeat.i(126251);
                int optInt = jSONObject.optInt("cameraId");
                String optString = jSONObject.optString("type");
                ab.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", Integer.valueOf(optInt), optString);
                a aDb = a.hGl;
                Integer valueOf = Integer.valueOf(optInt);
                if (aDb.hGk.containsKey(valueOf)) {
                    eVar = (e) aDb.hGk.get(valueOf);
                } else {
                    eVar = null;
                }
                if (eVar == null) {
                    cVar.M(i, l.this.j("fail:no such camera", null));
                    AppMethodBeat.o(126251);
                    return;
                }
                eVar.setOperateCallBack(new c() {
                    public final void a(int i, String str, String str2, int i2, int i3) {
                        AppMethodBeat.i(126247);
                        if (i == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempImagePath", str);
                            hashMap.put("width", Integer.valueOf(i2));
                            hashMap.put("height", Integer.valueOf(i3));
                            cVar.M(i, l.this.j("ok", hashMap));
                            AppMethodBeat.o(126247);
                            return;
                        }
                        cVar.M(i, l.this.j("fail:".concat(String.valueOf(str2)), null));
                        AppMethodBeat.o(126247);
                    }

                    public final void Q(int i, String str) {
                        AppMethodBeat.i(126248);
                        if (i == 0) {
                            cVar.M(i, l.this.j("ok", null));
                            AppMethodBeat.o(126248);
                            return;
                        }
                        cVar.M(i, l.this.j("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(126248);
                    }

                    public final void d(int i, String str, String str2, String str3) {
                        AppMethodBeat.i(126249);
                        ab.d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s", Integer.valueOf(i), str2, str3);
                        if (i == 0) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("tempThumbPath", str2);
                            hashMap.put("tempVideoPath", str3);
                            cVar.M(i, l.this.j("ok", hashMap));
                            AppMethodBeat.o(126249);
                            return;
                        }
                        cVar.M(i, l.this.j("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(126249);
                    }

                    public final void g(String str, int i, int i2, int i3) {
                        AppMethodBeat.i(126250);
                        if (bo.isNullOrNil(str)) {
                            ab.d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                            HashMap hashMap = new HashMap();
                            hashMap.put("bufferId", Integer.valueOf(i));
                            hashMap.put("width", Integer.valueOf(i2));
                            hashMap.put("height", Integer.valueOf(i3));
                            cVar.M(i, l.this.j("ok", hashMap));
                            AppMethodBeat.o(126250);
                            return;
                        }
                        cVar.M(i, l.this.j("fail:".concat(String.valueOf(str)), null));
                        AppMethodBeat.o(126250);
                    }
                });
                optInt = -1;
                switch (optString.hashCode()) {
                    case -2144140699:
                        if (optString.equals("closeFrameChange")) {
                            optInt = 4;
                            break;
                        }
                        break;
                    case -1909077165:
                        if (optString.equals(JsApiStartRecordVoice.NAME)) {
                            optInt = 1;
                            break;
                        }
                        break;
                    case -1391995149:
                        if (optString.equals(JsApiStopRecordVoice.NAME)) {
                            optInt = 2;
                            break;
                        }
                        break;
                    case -374265034:
                        if (optString.equals("listenFrameChange")) {
                            optInt = 3;
                            break;
                        }
                        break;
                    case 1484838379:
                        if (optString.equals("takePhoto")) {
                            optInt = 0;
                            break;
                        }
                        break;
                }
                switch (optInt) {
                    case 0:
                        eVar.setQuality(jSONObject.optString("quality", "high"));
                        eVar.aDd();
                        AppMethodBeat.o(126251);
                        return;
                    case 1:
                        eVar.aDm();
                        AppMethodBeat.o(126251);
                        return;
                    case 2:
                        eVar.aDn();
                        AppMethodBeat.o(126251);
                        return;
                    case 3:
                        jSONObject.optString("size");
                        eVar.n(cVar);
                        AppMethodBeat.o(126251);
                        return;
                    case 4:
                        eVar.aDg();
                        cVar.M(i, l.this.j("ok", null));
                        AppMethodBeat.o(126251);
                        return;
                    default:
                        ab.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", optString);
                        cVar.M(i, l.this.j("fail:operateType not supported", null));
                        AppMethodBeat.o(126251);
                        return;
                }
            }
        });
        AppMethodBeat.o(126252);
    }
}
