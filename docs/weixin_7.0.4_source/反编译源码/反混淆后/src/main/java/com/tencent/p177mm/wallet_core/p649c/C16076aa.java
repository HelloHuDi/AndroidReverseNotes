package com.tencent.p177mm.wallet_core.p649c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.aa */
public final class C16076aa {
    public String AfX = "";
    public String AfY = "";
    public int AfZ = 0;
    public String xfz = "";
    public String xoz = "";

    public C16076aa(JSONObject jSONObject) {
        AppMethodBeat.m2504i(49092);
        this.AfX = jSONObject.optString("device_id");
        this.xoz = jSONObject.optString("device_name");
        this.AfY = jSONObject.optString("device_os");
        this.AfZ = jSONObject.optInt("Is_cur_device");
        this.xfz = jSONObject.optString("crt_no");
        AppMethodBeat.m2505o(49092);
    }
}
