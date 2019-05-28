package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.C10360a.C10361a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.l */
public final class C19353l extends C10296a {
    private static final int CTRL_INDEX = 332;
    public static final String NAME = "operateCamera";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, final JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(126252);
        if (jSONObject == null) {
            c2241c.mo6107M(i, mo73394j("fail:data is null or nil", null));
            AppMethodBeat.m2505o(126252);
            return;
        }
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.l$1$1 */
            class C103641 implements C10362c {
                C103641() {
                }

                /* renamed from: a */
                public final void mo21843a(int i, String str, String str2, int i2, int i3) {
                    AppMethodBeat.m2504i(126247);
                    if (i == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempImagePath", str);
                        hashMap.put("width", Integer.valueOf(i2));
                        hashMap.put("height", Integer.valueOf(i3));
                        c2241c.mo6107M(i, C19353l.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(126247);
                        return;
                    }
                    c2241c.mo6107M(i, C19353l.this.mo73394j("fail:".concat(String.valueOf(str2)), null));
                    AppMethodBeat.m2505o(126247);
                }

                /* renamed from: Q */
                public final void mo21842Q(int i, String str) {
                    AppMethodBeat.m2504i(126248);
                    if (i == 0) {
                        c2241c.mo6107M(i, C19353l.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(126248);
                        return;
                    }
                    c2241c.mo6107M(i, C19353l.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                    AppMethodBeat.m2505o(126248);
                }

                /* renamed from: d */
                public final void mo21844d(int i, String str, String str2, String str3) {
                    AppMethodBeat.m2504i(126249);
                    C4990ab.m7411d("MicroMsg.JsApiOperateCamera", "onStopRecord ret %d, thumbPath %s,tempVideoPath %s", Integer.valueOf(i), str2, str3);
                    if (i == 0) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("tempThumbPath", str2);
                        hashMap.put("tempVideoPath", str3);
                        c2241c.mo6107M(i, C19353l.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(126249);
                        return;
                    }
                    c2241c.mo6107M(i, C19353l.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                    AppMethodBeat.m2505o(126249);
                }

                /* renamed from: g */
                public final void mo21845g(String str, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(126250);
                    if (C5046bo.isNullOrNil(str)) {
                        C4990ab.m7411d("MicroMsg.JsApiOperateCamera", "onListenFrameChange bufferId:%d width:%d height:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                        HashMap hashMap = new HashMap();
                        hashMap.put("bufferId", Integer.valueOf(i));
                        hashMap.put("width", Integer.valueOf(i2));
                        hashMap.put("height", Integer.valueOf(i3));
                        c2241c.mo6107M(i, C19353l.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(126250);
                        return;
                    }
                    c2241c.mo6107M(i, C19353l.this.mo73394j("fail:".concat(String.valueOf(str)), null));
                    AppMethodBeat.m2505o(126250);
                }
            }

            public final void run() {
                C33272e c33272e;
                AppMethodBeat.m2504i(126251);
                int optInt = jSONObject.optInt("cameraId");
                String optString = jSONObject.optString("type");
                C4990ab.m7417i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", Integer.valueOf(optInt), optString);
                C10360a aDb = C10361a.hGl;
                Integer valueOf = Integer.valueOf(optInt);
                if (aDb.hGk.containsKey(valueOf)) {
                    c33272e = (C33272e) aDb.hGk.get(valueOf);
                } else {
                    c33272e = null;
                }
                if (c33272e == null) {
                    c2241c.mo6107M(i, C19353l.this.mo73394j("fail:no such camera", null));
                    AppMethodBeat.m2505o(126251);
                    return;
                }
                c33272e.setOperateCallBack(new C103641());
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
                        c33272e.setQuality(jSONObject.optString("quality", "high"));
                        c33272e.aDd();
                        AppMethodBeat.m2505o(126251);
                        return;
                    case 1:
                        c33272e.aDm();
                        AppMethodBeat.m2505o(126251);
                        return;
                    case 2:
                        c33272e.aDn();
                        AppMethodBeat.m2505o(126251);
                        return;
                    case 3:
                        jSONObject.optString("size");
                        c33272e.mo30617n(c2241c);
                        AppMethodBeat.m2505o(126251);
                        return;
                    case 4:
                        c33272e.aDg();
                        c2241c.mo6107M(i, C19353l.this.mo73394j("ok", null));
                        AppMethodBeat.m2505o(126251);
                        return;
                    default:
                        C4990ab.m7421w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", optString);
                        c2241c.mo6107M(i, C19353l.this.mo73394j("fail:operateType not supported", null));
                        AppMethodBeat.m2505o(126251);
                        return;
                }
            }
        });
        AppMethodBeat.m2505o(126252);
    }
}
