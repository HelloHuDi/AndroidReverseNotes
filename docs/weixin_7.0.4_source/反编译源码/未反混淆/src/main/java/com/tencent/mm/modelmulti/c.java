package com.tencent.mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.afh;
import com.tencent.mm.protocal.protobuf.afi;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aub;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class c extends m implements k {
    private f ehi;
    public final b fAT;

    public c(List<atz> list, long j, aub aub) {
        AppMethodBeat.i(16494);
        a aVar = new a();
        aVar.fsJ = new afh();
        aVar.fsK = new afi();
        aVar.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        this.fAT = aVar.acD();
        afh afh = (afh) this.fAT.fsG.fsP;
        afh.wmF.addAll(list);
        afh.wmI = j;
        afh.wmH = aub;
        ab.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(afh.wmF.size()));
        AppMethodBeat.o(16494);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16495);
        ab.i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        afh afh = (afh) this.fAT.fsG.fsP;
        atz atz = (atz) afh.wmF.get(0);
        aub aub = afh.wmH;
        afi afi = (afi) ((b) qVar).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            if (afi.result != 0) {
                h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), atz.eCq, Integer.valueOf(atz.major), Integer.valueOf(atz.minor), String.valueOf(aub.latitude), String.valueOf(aub.longitude), Integer.valueOf(2), Integer.valueOf(afi.result));
            }
            ab.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            AppMethodBeat.o(16495);
            return;
        }
        h.pYm.e(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), atz.eCq, Integer.valueOf(atz.major), Integer.valueOf(atz.minor), String.valueOf(aub.latitude), String.valueOf(aub.longitude), Integer.valueOf(1), Integer.valueOf(afi.result));
        ab.d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
        AppMethodBeat.o(16495);
    }

    public final int getType() {
        return 1708;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16496);
        this.ehi = fVar;
        int a = a(eVar, this.fAT, this);
        AppMethodBeat.o(16496);
        return a;
    }
}
