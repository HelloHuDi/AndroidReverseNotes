package com.tencent.mm.plugin.brandservice.ui.timeline.offenread;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.z;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.chb;
import com.tencent.mm.protocal.protobuf.chc;
import com.tencent.mm.protocal.protobuf.chd;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends m implements k {
    b ehh;
    private f ehi;

    public g() {
        LinkedList linkedList = null;
        AppMethodBeat.i(14359);
        a aVar = new a();
        aVar.fsJ = new chb();
        aVar.fsK = new chc();
        aVar.uri = "/cgi-bin/mmbiz-bin/bizattr/timeline_often_read_biz";
        this.ehh = aVar.acD();
        chb chb = (chb) this.ehh.fsG.fsP;
        chc aWL = d.aWL();
        if (aWL != null) {
            LinkedList linkedList2 = aWL.xfW;
            if (!bo.ek(linkedList2)) {
                LinkedList linkedList3 = new LinkedList();
                Iterator it = linkedList2.iterator();
                while (it.hasNext()) {
                    chd chd = (chd) it.next();
                    if (chd != null) {
                        sr srVar = new sr();
                        srVar.vGE = chd.vGE;
                        q mE = z.aeX().mE(((j) com.tencent.mm.kernel.g.K(j.class)).XM().aoP(chd.vGE));
                        if (mE != null) {
                            srVar.wag = (int) (mE.field_createTime / 1000);
                        }
                        linkedList3.add(srVar);
                    }
                }
                linkedList = linkedList3;
            }
        }
        chb.xfV = linkedList;
        AppMethodBeat.o(14359);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(14360);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(14360);
    }

    public final int getType() {
        return 2768;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(14361);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(14361);
        return a;
    }
}
