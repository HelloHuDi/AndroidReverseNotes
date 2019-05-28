package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bxn;
import com.tencent.mm.protocal.protobuf.bxo;
import com.tencent.mm.sdk.platformtools.ab;

public final class ah extends x {
    private int cmdId;
    private String vcC;

    public ah(String str, String str2) {
        AppMethodBeat.i(27366);
        a aVar = new a();
        aVar.fsJ = new bxn();
        aVar.fsK = new bxo();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        this.lty = aVar.acD();
        bxn bxn = (bxn) this.lty.fsG.fsP;
        bxn.mZr = str;
        bxn.wXy = 0;
        bxn.wXz = str2;
        this.cmdId = 0;
        this.vcC = str2;
        AppMethodBeat.o(27366);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(27367);
        ab.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            bxo bxo = (bxo) this.lty.fsH.fsP;
            if (bxo != null) {
                i bYO = com.tencent.mm.plugin.s.a.a.a.bYQ().bYO();
                f bT = g.bT(bxo.mZr, false);
                if (bT != null) {
                    bT.field_authFlag = bxo.vGY;
                    ab.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bYO.a(bT, new String[0]) + ", appId = " + bxo.mZr);
                }
            }
        }
        AppMethodBeat.o(27367);
    }

    public final byte[] dhj() {
        AppMethodBeat.i(27368);
        try {
            byte[] ZT = ((b) this.lty.acF()).ZT();
            AppMethodBeat.o(27368);
            return ZT;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            AppMethodBeat.o(27368);
            return null;
        }
    }

    public final void bG(byte[] bArr) {
        AppMethodBeat.i(27369);
        if (bArr == null) {
            ab.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            AppMethodBeat.o(27369);
            return;
        }
        try {
            this.lty.fsH.P(bArr);
            AppMethodBeat.o(27369);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
            AppMethodBeat.o(27369);
        }
    }

    public final int getType() {
        return 2;
    }
}
