package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.bwv;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.List;

public final class ai extends m implements k {
    private final b ehh;
    private f ehi = null;

    public ai(String str, List<String> list) {
        AppMethodBeat.i(108478);
        a aVar = new a();
        aVar.fsJ = new bwv();
        aVar.fsK = new bww();
        aVar.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        aVar.fsI = v2helper.EMethodSetSendToNetworkOn;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        bwv bwv = (bwv) this.ehh.fsG.fsP;
        bwv.wdB = str;
        bwv.wCo = new LinkedList();
        bwv.wCn = list.size();
        for (String str2 : list) {
            if (!bo.isNullOrNil(str2)) {
                bwv.wCo.add(new bts().alV(str2));
            }
        }
        AppMethodBeat.o(108478);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108479);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108479);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOn;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108480);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108480);
    }
}
