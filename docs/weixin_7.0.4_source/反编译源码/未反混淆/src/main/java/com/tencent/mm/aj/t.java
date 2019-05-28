package com.tencent.mm.aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class t extends m implements k {
    private Object data;
    public b ehh;
    private f ehi;

    public static void a(f fVar) {
        AppMethodBeat.i(11444);
        g.RO().eJo.a(1285, fVar);
        AppMethodBeat.o(11444);
    }

    public static void b(f fVar) {
        AppMethodBeat.i(11445);
        g.RO().eJo.b(1285, fVar);
        AppMethodBeat.o(11445);
    }

    public static boolean o(String str, String str2, String str3) {
        AppMethodBeat.i(11446);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            boolean a = g.RO().eJo.a(new t(str, jSONObject.toString()), 0);
            AppMethodBeat.o(11446);
            return a;
        } catch (Exception e) {
            AppMethodBeat.o(11446);
            return false;
        }
    }

    private t(String str, String str2) {
        AppMethodBeat.i(11447);
        a aVar = new a();
        aVar.fsJ = new afx();
        aVar.fsK = new afy();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        this.ehh = aVar.acD();
        afx afx = (afx) this.ehh.fsG.fsP;
        afx.wbO = str;
        afx.Cn = 1;
        afx.data = str2;
        this.data = null;
        AppMethodBeat.o(11447);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(11448);
        ab.d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(11448);
    }

    public final int getType() {
        return 1285;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(11449);
        this.ehi = fVar;
        ab.i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(11449);
        return a;
    }
}
