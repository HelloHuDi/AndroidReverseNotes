package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.protocal.protobuf.ayn;
import com.tencent.p177mm.protocal.protobuf.ayo;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al.C5002a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ag */
public final class C32957ag extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;

    public C32957ag(String str, List<String[]> list) {
        int i = 0;
        AppMethodBeat.m2504i(108471);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ayn();
        c1196a.fsK = new ayo();
        c1196a.uri = "/cgi-bin/micromsg-bin/listmfriend";
        c1196a.fsI = 431;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
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
                if (!C5046bo.isNullOrNil(strArr[2])) {
                    ayn.wCo.add(new bts().alV(strArr[2]));
                }
            }
        }
        AppMethodBeat.m2505o(108471);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108472);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108472);
        return a;
    }

    public final LinkedList<aym> aqj() {
        AppMethodBeat.m2504i(108473);
        LinkedList linkedList = ((ayo) this.ehh.fsH.fsP).wCr;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aym aym = (aym) it.next();
                C20118a.ask().mo35364Yn().mo56747ia(aym.jBB, aym.wlF);
            }
        }
        linkedList = ((ayo) this.ehh.fsH.fsP).wCr;
        AppMethodBeat.m2505o(108473);
        return linkedList;
    }

    public final int getType() {
        return 431;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108474);
        final ayo ayo = (ayo) this.ehh.fsH.fsP;
        C1720g.m3539RS().mo10300a(new C5002a() {
            public final boolean acg() {
                return false;
            }

            public final boolean acf() {
                AppMethodBeat.m2504i(108469);
                if (ayo != null && ayo.wCr.size() > 0) {
                    Iterator it = ayo.wCr.iterator();
                    while (it.hasNext()) {
                        aym aym = (aym) it.next();
                        if (aym.jBT == 1) {
                            C17880h c17880h = new C17880h();
                            c17880h.username = aym.jBB;
                            c17880h.frW = aym.vXm;
                            c17880h.frV = aym.vXn;
                            c17880h.bJt = -1;
                            C4990ab.m7411d("MicroMsg.NetSceneListMFriend", "getmlist  %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
                            c17880h.dtR = 3;
                            c17880h.mo33385cB(true);
                            C17884o.act().mo33391b(c17880h);
                        }
                    }
                }
                AppMethodBeat.m2505o(108469);
                return true;
            }

            public final String toString() {
                AppMethodBeat.m2504i(108470);
                String str = super.toString() + "|onGYNetEnd";
                AppMethodBeat.m2505o(108470);
                return str;
            }
        });
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108474);
    }
}
