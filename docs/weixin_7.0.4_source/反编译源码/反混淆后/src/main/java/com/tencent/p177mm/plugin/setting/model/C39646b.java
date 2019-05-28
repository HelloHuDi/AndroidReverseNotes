package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23379cv;
import com.tencent.p177mm.protocal.protobuf.C30175cu;
import com.tencent.p177mm.protocal.protobuf.ciu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.model.b */
public final class C39646b extends C1207m implements C1918k {
    private C1202f ehi;
    private List<String> lQs;

    public C39646b(List<String> list) {
        this.lQs = list;
    }

    public final int getType() {
        return 583;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(126841);
        this.ehi = c1202f;
        C1196a c1196a = new C1196a();
        C30175cu c30175cu = new C30175cu();
        ArrayList arrayList = new ArrayList();
        if (this.lQs != null) {
            for (int i = 0; i < this.lQs.size(); i++) {
                ciu ciu = new ciu();
                ciu.jBB = (String) this.lQs.get(i);
                arrayList.add(ciu);
            }
        }
        c30175cu.vET.addAll(arrayList);
        c1196a.fsJ = c30175cu;
        c1196a.fsK = new C23379cv();
        c1196a.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        c1196a.fsI = 583;
        c1196a.fsL = 0;
        c1196a.fsL = 0;
        int a = mo4457a(c1902e, c1196a.acD(), this);
        AppMethodBeat.m2505o(126841);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(126840);
        this.fth = i;
        if (!(i2 == 0 && i3 == 0)) {
            C4990ab.m7413e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(126840);
    }
}
