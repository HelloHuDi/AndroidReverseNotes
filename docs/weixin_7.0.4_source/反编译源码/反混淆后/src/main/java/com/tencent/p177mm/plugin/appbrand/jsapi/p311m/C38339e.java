package com.tencent.p177mm.plugin.appbrand.jsapi.p311m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.m.e */
public final class C38339e extends C10296a<C33303e> {
    public static final int CTRL_INDEX = 84;
    public static final String NAME = "showDatePickerView";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(126345);
        C33303e c33303e = (C33303e) c2241c;
        String optString = jSONObject.optString("mode");
        if (FFmpegMetadataRetriever.METADATA_KEY_DATE.equals(optString)) {
            new C19424a().mo44708a(this, c33303e, jSONObject, i);
            AppMethodBeat.m2505o(126345);
        } else if ("time".equals(optString)) {
            new C10464j().mo44708a(this, c33303e, jSONObject, i);
            AppMethodBeat.m2505o(126345);
        } else {
            c33303e.mo6107M(i, mo73394j("fail:invalid data", null));
            AppMethodBeat.m2505o(126345);
        }
    }
}
