package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bwj;
import com.tencent.p177mm.protocal.protobuf.bwk;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ah */
public final class C38031ah extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C38031ah(int[] iArr) {
        AppMethodBeat.m2504i(108475);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwj();
        c1196a.fsK = new bwk();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendinviteemail";
        this.ehh = c1196a.acD();
        LinkedList linkedList = new LinkedList();
        for (int valueOf : iArr) {
            linkedList.add(Integer.valueOf(valueOf));
        }
        ((bwj) this.ehh.fsG.fsP).wWY = linkedList;
        ((bwj) this.ehh.fsG.fsP).wWX = linkedList.size();
        AppMethodBeat.m2505o(108475);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108476);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108476);
        return a;
    }

    public final int getType() {
        return 116;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108477);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108477);
    }
}
