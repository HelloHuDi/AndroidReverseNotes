package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.video.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends m implements k {
    private b ehh;
    private f ehi;
    private ArrayList<Long> puy;

    public r(ArrayList<Long> arrayList) {
        AppMethodBeat.i(67978);
        this.puy = arrayList;
        a aVar = new a();
        aVar.fsJ = new c();
        aVar.fsK = new d();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.fsI = g.CTRL_INDEX;
        this.ehh = aVar.acD();
        AppMethodBeat.o(67978);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(67979);
        ab.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if ((i2 == 0 && i3 == 0) || this.ehi == null) {
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.o(67979);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(67979);
    }

    public final int getType() {
        return g.CTRL_INDEX;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(67980);
        this.ehi = fVar;
        c cVar = (c) this.ehh.fsG.fsP;
        cVar.jBv = this.puy.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.puy.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            h hVar = new h();
            hVar.ptF = longValue;
            linkedList.add(hVar);
            ab.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", Long.valueOf(longValue));
        }
        cVar.ptt = linkedList;
        ab.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", Integer.valueOf(cVar.jBv), Integer.valueOf(cVar.ptt.size()));
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(67980);
        return a;
    }

    public final LinkedList<g> ccu() {
        return ((d) this.ehh.fsH.fsP).ptu;
    }
}
