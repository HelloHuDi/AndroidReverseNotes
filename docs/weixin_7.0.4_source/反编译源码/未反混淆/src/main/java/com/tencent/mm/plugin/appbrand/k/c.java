package com.tencent.mm.plugin.appbrand.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awd;
import com.tencent.mm.protocal.protobuf.cxh;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends m implements k {
    private f eIc;
    public final b ehh;
    private a<c> iod;

    public interface a<T extends m> {
        void a(int i, int i2, String str, T t);
    }

    public c(String str, String str2, String str3, int i, int i2, int i3, a<c> aVar) {
        this(str, str2, str3, i, i2, i3);
        this.iod = aVar;
    }

    private c(String str, String str2, String str3, int i, int i2, int i3) {
        AppMethodBeat.i(132312);
        ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new awc();
        aVar.fsK = new awd();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.fsI = 1133;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        awc awc = (awc) this.ehh.fsG.fsP;
        awc.fKh = str;
        awc.jBi = new com.tencent.mm.bt.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        awc.wzR = str3;
        awc.wzF = i;
        awc.wzE = i2;
        if (i3 > 0) {
            awc.wzG = new cxh();
            awc.wzG.scene = i3;
        }
        AppMethodBeat.o(132312);
    }

    public final void pm(int i) {
        AppMethodBeat.i(132313);
        awc awc = (awc) this.ehh.fsG.fsP;
        if (awc.wzG == null) {
            awc.wzG = new cxh();
        }
        awc.wzG.xsJ = i;
        AppMethodBeat.o(132313);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(132314);
        ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.eIc != null) {
            this.eIc.onSceneEnd(i2, i3, str, this);
        }
        if (this.iod != null) {
            this.iod.a(i2, i3, str, this);
        }
        AppMethodBeat.o(132314);
    }

    public final int getType() {
        return 1133;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(132315);
        ab.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.eIc = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(132315);
        return a;
    }
}
