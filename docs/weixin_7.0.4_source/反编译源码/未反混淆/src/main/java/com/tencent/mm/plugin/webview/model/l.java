package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aff;
import com.tencent.mm.protocal.protobuf.afg;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class l extends m implements k {
    private f ehi;
    public final b fAT;

    public l(List<atz> list, String str) {
        AppMethodBeat.i(6598);
        a aVar = new a();
        aVar.fsJ = new aff();
        aVar.fsK = new afg();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconsingroup";
        this.fAT = aVar.acD();
        aff aff = (aff) this.fAT.fsG.fsP;
        aff.wmF.addAll(list);
        aff.csB = str;
        ab.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang]getBeaconsInGroupRequest.beacons.size:%d", Integer.valueOf(aff.wmF.size()));
        AppMethodBeat.o(6598);
    }

    public final int getType() {
        return 1704;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(6599);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(6599);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(6600);
        ab.i("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            ab.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end ok");
        } else {
            ab.d("MicroMsg.NetSceneGetBeaconSinGroup", "[oneliang][NetSceneGetBeaconSinGroup]:net end not ok");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(6600);
    }
}
