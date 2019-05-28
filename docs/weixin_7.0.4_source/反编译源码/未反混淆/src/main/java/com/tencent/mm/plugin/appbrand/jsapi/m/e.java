package com.tencent.mm.plugin.appbrand.jsapi.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

public final class e extends a<com.tencent.mm.plugin.appbrand.jsapi.e> {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(126345);
        com.tencent.mm.plugin.appbrand.jsapi.e eVar = (com.tencent.mm.plugin.appbrand.jsapi.e) cVar;
        String optString = jSONObject.optString("mode");
        if (FFmpegMetadataRetriever.METADATA_KEY_DATE.equals(optString)) {
            new a().a(this, eVar, jSONObject, i);
            AppMethodBeat.o(126345);
        } else if ("time".equals(optString)) {
            new j().a(this, eVar, jSONObject, i);
            AppMethodBeat.o(126345);
        } else {
            eVar.M(i, j("fail:invalid data", null));
            AppMethodBeat.o(126345);
        }
    }
}
