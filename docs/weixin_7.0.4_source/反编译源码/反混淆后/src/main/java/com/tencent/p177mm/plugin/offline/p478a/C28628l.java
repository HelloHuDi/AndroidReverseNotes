package com.tencent.p177mm.plugin.offline.p478a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1929q;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.l */
public final class C28628l extends C46117h {
    public String oXv;

    public final int bgI() {
        return 78;
    }

    /* renamed from: a */
    public final void mo36860a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43405);
        this.oXv = jSONObject.optString("barcode");
        AppMethodBeat.m2505o(43405);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43406);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        AppMethodBeat.m2505o(43406);
    }
}
