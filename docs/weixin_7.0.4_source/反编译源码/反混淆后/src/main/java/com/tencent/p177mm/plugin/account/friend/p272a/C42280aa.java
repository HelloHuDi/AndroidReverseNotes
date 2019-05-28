package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.protocal.protobuf.bdz;
import com.tencent.p177mm.protocal.protobuf.bea;
import com.tencent.p177mm.protocal.protobuf.bed;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashSet;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.a.aa */
public final class C42280aa extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;

    public C42280aa(int i) {
        AppMethodBeat.m2504i(108441);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bdz();
        c1196a.fsK = new bea();
        c1196a.uri = "/cgi-bin/micromsg-bin/newgetinvitefriend";
        c1196a.fsI = C44697b.CTRL_INDEX;
        this.ehh = c1196a.acD();
        ((bdz) this.ehh.fsG.fsP).wyY = i;
        AppMethodBeat.m2505o(108441);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108442);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108442);
        return a;
    }

    public final int getType() {
        return C44697b.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108443);
        bea bea = (bea) this.ehh.fsH.fsP;
        C4990ab.m7410d("MicroMsg.NetSceneGetInviteFriend", "friend:" + bea.ndm.size() + " group:" + bea.vFk.size());
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
                AppMethodBeat.m2505o(108443);
                return;
            }
        }
    }
}
