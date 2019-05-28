package com.tencent.mm.plugin.offline.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.q;
import org.json.JSONObject;

public final class l extends h {
    public String oXv;

    public final int bgI() {
        return 78;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43405);
        this.oXv = jSONObject.optString("barcode");
        AppMethodBeat.o(43405);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(43406);
        super.a(i, i2, i3, str, qVar, bArr);
        AppMethodBeat.o(43406);
    }
}
