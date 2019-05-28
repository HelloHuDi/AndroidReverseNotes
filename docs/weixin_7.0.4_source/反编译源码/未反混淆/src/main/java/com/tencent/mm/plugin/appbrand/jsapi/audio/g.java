package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.media.record.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class g extends a {
    public static final int CTRL_INDEX = 469;
    public static final String NAME = "getAvailableAudioSources";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137729);
        String str = "MicroMsg.JsApiGetAvailableAudioSources";
        String str2 = "getAvailableAudioSources data:%s";
        Object[] objArr = new Object[1];
        objArr[0] = jSONObject != null ? jSONObject.toString() : "";
        ab.i(str, str2, objArr);
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add(b.AUTO.toString().toLowerCase());
        arrayList.add(b.MIC.toString().toLowerCase());
        arrayList.add(b.CAMCORDER.toString().toLowerCase());
        arrayList.add(b.VOICE_RECOGNITION.toString().toLowerCase());
        arrayList.add(b.VOICE_COMMUNICATION.toString().toLowerCase());
        if (d.iW(24)) {
            arrayList.add(b.UNPROCESSED.toString().toLowerCase());
        }
        JSONArray jSONArray = new JSONArray();
        for (String put : arrayList) {
            jSONArray.put(put);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("audioSources", jSONArray);
        ab.i("MicroMsg.JsApiGetAvailableAudioSources", "getAvailableAudioSources ret:%s", hashMap.toString());
        cVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(137729);
    }
}
