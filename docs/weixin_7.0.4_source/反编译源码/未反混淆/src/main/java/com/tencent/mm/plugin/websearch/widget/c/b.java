package com.tencent.mm.plugin.websearch.widget.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    private String cOS;
    private int x;
    private int y;

    public b(int i, int i2, String str) {
        this.x = i;
        this.y = i2;
        this.cOS = str;
    }

    public final String getName() {
        return "onTap";
    }

    public final String cVS() {
        AppMethodBeat.i(91461);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_X, this.x);
            jSONObject.put(VideoMaterialUtil.CRAZYFACE_Y, this.y);
            jSONObject.put("eventId", this.cOS);
        } catch (JSONException e) {
            ab.printErrStackTrace("onTap", e, "", new Object[0]);
        }
        String jSONObject2 = jSONObject.toString();
        AppMethodBeat.o(91461);
        return jSONObject2;
    }
}
