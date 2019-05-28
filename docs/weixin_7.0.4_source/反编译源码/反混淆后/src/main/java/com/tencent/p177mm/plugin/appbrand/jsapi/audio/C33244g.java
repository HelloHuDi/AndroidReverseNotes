package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.media.record.C38444b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.g */
public final class C33244g extends C10296a {
    public static final int CTRL_INDEX = 469;
    public static final String NAME = "getAvailableAudioSources";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137729);
        String str = "MicroMsg.JsApiGetAvailableAudioSources";
        String str2 = "getAvailableAudioSources data:%s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject != null ? jSONObject.toString() : "";
        C4990ab.m7417i(str, str2, objArr);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(C38444b.AUTO.toString().toLowerCase());
        arrayList.add(C38444b.MIC.toString().toLowerCase());
        arrayList.add(C38444b.CAMCORDER.toString().toLowerCase());
        arrayList.add(C38444b.VOICE_RECOGNITION.toString().toLowerCase());
        arrayList.add(C38444b.VOICE_COMMUNICATION.toString().toLowerCase());
        if (C1443d.m3068iW(24)) {
            arrayList.add(C38444b.UNPROCESSED.toString().toLowerCase());
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : arrayList) {
            jSONArray.put(put);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("audioSources", jSONArray);
        C4990ab.m7417i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", hashMap.toString());
        c2241c.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(137729);
    }
}
