package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.sdk.platformtools.ab;

public final class ae extends m implements k {
    private f ehi;
    public final b fAT;

    public ae(String str, String str2, String str3) {
        AppMethodBeat.i(6656);
        a aVar = new a();
        aVar.fsJ = new cmq();
        aVar.fsK = new cmr();
        aVar.uri = "/cgi-bin/mmo2o-bin/verifybeaconjspermission";
        this.fAT = aVar.acD();
        cmq cmq = (cmq) this.fAT.fsG.fsP;
        cmq.Url = str;
        cmq.csB = str2;
        cmq.cxb = str3;
        AppMethodBeat.o(6656);
    }

    public final int getType() {
        return 1702;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6657);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(6657);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6658);
        ab.i("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end ok");
        } else {
            ab.d("MicroMsg.NetSceneVerifyBeaconJsPermission", "[oneliang][NetSceneVerifyBeaconJsPermission]:net end not ok");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6658);
    }
}
