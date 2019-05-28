package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bdz;
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.LinkedList;

public final class aa extends m implements k {
    public final b ehh;
    private f ehi;

    public aa(int i) {
        AppMethodBeat.i(108441);
        a aVar = new a();
        aVar.fsJ = new bdz();
        aVar.fsK = new bea();
        aVar.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX;
        this.ehh = aVar.acD();
        ((bdz) this.ehh.fsG.fsP).wyY = i;
        AppMethodBeat.o(108441);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108442);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108442);
        return a;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108443);
        bea bea = (bea) this.ehh.fsH.fsP;
        ab.d("MicroMsg.NetSceneGetInviteFriend", "friend:" + bea.ndm.size() + " group:" + bea.vFk.size());
        HashSet hashSet = new HashSet();
        LinkedList linkedList = new LinkedList();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < bea.wHF) {
                if (!hashSet.contains(((bed) bea.ndm.get(i5)).jBB)) {
                    linkedList.add(bea.ndm.get(i5));
                    hashSet.add(((bed) bea.ndm.get(i5)).jBB);
                }
                i4 = i5 + 1;
            } else {
                bea.ndm = linkedList;
                bea.wHF = linkedList.size();
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(108443);
                return;
            }
        }
    }
}
