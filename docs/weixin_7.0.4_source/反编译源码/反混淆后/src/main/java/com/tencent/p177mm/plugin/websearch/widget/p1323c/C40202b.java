package com.tencent.p177mm.plugin.websearch.widget.p1323c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.websearch.widget.c.b */
public final class C40202b extends C29760a {
    private String cOS;
    /* renamed from: x */
    private int f16194x;
    /* renamed from: y */
    private int f16195y;

    public C40202b(int i, int i2, String str) {
        this.f16194x = i;
        this.f16195y = i2;
        this.cOS = str;
    }

    public final String getName() {
        return "onTap";
    }

    public final String cVS() {
        AppMethodBeat.m2504i(91461);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, this.f16194x);
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, this.f16195y);
            jSONObject.put("eventId", this.cOS);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("onTap", e, "", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.m2505o(91461);
        return jSONObject2;
    }
}
