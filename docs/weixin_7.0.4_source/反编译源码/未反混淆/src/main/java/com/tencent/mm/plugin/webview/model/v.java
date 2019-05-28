package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azl;
import com.tencent.mm.sdk.platformtools.ab;

public final class v extends m implements k {
    private f eIc;
    private final b ehh;
    public String kKw;
    public String kKx;
    public String sign;
    public String ulZ;
    public int uma;

    public v(String str, String str2, String str3) {
        AppMethodBeat.i(6628);
        a aVar = new a();
        aVar.fsJ = new azk();
        aVar.fsK = new azl();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        this.ehh = aVar.acD();
        azk azk = (azk) this.ehh.fsG.fsP;
        azk.app_id = str;
        azk.wmb = str2;
        azk.kfT = str3;
        AppMethodBeat.o(6628);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6629);
        ab.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            azl azl = (azl) this.ehh.fsH.fsP;
            this.ulZ = azl.ulZ;
            this.sign = azl.sign;
            this.kKx = azl.kKx;
            this.kKw = azl.kKw;
            this.uma = azl.uma;
            ab.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", this.ulZ, this.sign, this.kKx, this.kKw, Integer.valueOf(this.uma));
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6629);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6630);
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(6630);
        return a;
    }
}
