package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ag extends m implements k {
    private final b ehh;
    private f ehi = null;

    public ag(String str, List<String[]> list) {
        int i = 0;
        AppMethodBeat.i(108471);
        a aVar = new a();
        aVar.fsJ = new ayn();
        aVar.fsK = new ayo();
        aVar.uri = "/cgi-bin/micromsg-bin/listmfriend";
        aVar.fsI = 431;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ayn ayn = (ayn) this.ehh.fsG.fsP;
        ayn.wdB = str;
        ayn.wCp = 0;
        if (list != null) {
            i = list.size();
        }
        ayn.wCn = i;
        ayn.wCq = new LinkedList();
        ayn.wCo = new LinkedList();
        if (list != null) {
            for (String[] strArr : list) {
                if (!bo.isNullOrNil(strArr[2])) {
                    ayn.wCo.add(new bts().alV(strArr[2]));
                }
            }
        }
        AppMethodBeat.o(108471);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108472);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108472);
        return a;
    }

    public final LinkedList<aym> aqj() {
        AppMethodBeat.i(108473);
        LinkedList linkedList = ((ayo) this.ehh.fsH.fsP).wCr;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aym aym = (aym) it.next();
                com.tencent.mm.plugin.c.a.ask().Yn().ia(aym.jBB, aym.wlF);
            }
        }
        linkedList = ((ayo) this.ehh.fsH.fsP).wCr;
        AppMethodBeat.o(108473);
        return linkedList;
    }

    public final int getType() {
        return 431;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108474);
        final ayo ayo = (ayo) this.ehh.fsH.fsP;
        g.RS().a(new al.a() {
            public final boolean acg() {
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.i(108469);
                if (ayo != null && ayo.wCr.size() > 0) {
                    Iterator it = ayo.wCr.iterator();
                    while (it.hasNext()) {
                        aym aym = (aym) it.next();
                        if (aym.jBT == 1) {
                            h hVar = new h();
                            hVar.username = aym.jBB;
                            hVar.frW = aym.vXm;
                            hVar.frV = aym.vXn;
                            hVar.bJt = -1;
                            ab.d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", hVar.getUsername(), hVar.ack(), hVar.acl());
                            hVar.dtR = 3;
                            hVar.cB(true);
                            o.act().b(hVar);
                        }
                    }
                }
                AppMethodBeat.o(108469);
                return true;
            }

            public final String toString() {
                AppMethodBeat.i(108470);
                String str = super.toString() + "|onGYNetEnd";
                AppMethodBeat.o(108470);
                return str;
            }
        });
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108474);
    }
}
