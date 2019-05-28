package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.afd;
import com.tencent.mm.protocal.protobuf.afe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;

public final class c extends m implements k {
    private b ehh;
    private f ehi;
    public LinkedList<String> ttN;

    public c(LinkedList<String> linkedList) {
        AppMethodBeat.i(46495);
        ab.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo call");
        a aVar = new a();
        aVar.fsJ = new afd();
        aVar.fsK = new afe();
        aVar.uri = "/cgi-bin/mmpay-bin/bankresource";
        this.ehh = aVar.acD();
        this.ehh.ftb = true;
        afd afd = (afd) this.ehh.fsG.fsP;
        afd.wmD = linkedList;
        afd.vRP = com.tencent.mm.plugin.wallet_core.model.k.cPy();
        if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
            afd.vWV = com.tencent.mm.pluginsdk.wallet.f.dlI();
        }
        e.QS(42);
        AppMethodBeat.o(46495);
    }

    public final int getType() {
        return 1650;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(46496);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46496);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(46497);
        ab.i("MicroMsg.NetSceneGetBankcardLogo", "NetSceneGetBankcardLogo onGYNetEnd,errType=" + i2 + "errCode=" + i3);
        if (i2 == 0 && i3 == 0) {
            afe afe = (afe) ((b) qVar).fsH.fsP;
            ab.i("MicroMsg.NetSceneGetBankcardLogo", "respone %s", afe.wmE);
            this.ttN = afe.ttN;
            LinkedList linkedList = this.ttN;
            if (linkedList == null || linkedList.size() == 0) {
                ab.d("MicroMsg.NetSceneGetBankcardLogo", "empty bank logo list");
            } else {
                pl plVar = new pl();
                plVar.cLE.cLG = linkedList;
                com.tencent.mm.sdk.b.a.xxA.m(plVar);
            }
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_STRING_SYNC, bo.bc(afe.wmE, ""));
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_BANKCARD_DETAIL_URL_TIMESTAMP_LONG_SYNC, Long.valueOf(System.currentTimeMillis() / 1000));
        } else {
            e.QS(43);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(46497);
    }
}
