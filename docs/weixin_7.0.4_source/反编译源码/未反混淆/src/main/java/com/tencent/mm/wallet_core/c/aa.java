package com.tencent.mm.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class aa {
    public String AfX = "";
    public String AfY = "";
    public int AfZ = 0;
    public String xfz = "";
    public String xoz = "";

    public aa(JSONObject jSONObject) {
        AppMethodBeat.i(49092);
        this.AfX = jSONObject.optString("device_id");
        this.xoz = jSONObject.optString("device_name");
        this.AfY = jSONObject.optString("device_os");
        this.AfZ = jSONObject.optInt("Is_cur_device");
        this.xfz = jSONObject.optString("crt_no");
        AppMethodBeat.o(49092);
    }
}
