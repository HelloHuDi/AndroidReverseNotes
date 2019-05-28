package com.tencent.p177mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.cbf;
import com.tencent.p177mm.protocal.protobuf.cbg;
import com.tencent.p177mm.protocal.protobuf.cbh;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.sns.model.q */
public final class C39761q extends C1207m implements C1918k {
    public static List<Long> qIU = new Vector();
    private long cND;
    public C7472b ehh;
    public C1202f ehi;

    static {
        AppMethodBeat.m2504i(36275);
        AppMethodBeat.m2505o(36275);
    }

    /* renamed from: kf */
    public static boolean m68004kf(long j) {
        AppMethodBeat.m2504i(36270);
        if (qIU.contains(Long.valueOf(j))) {
            AppMethodBeat.m2505o(36270);
            return false;
        }
        qIU.add(Long.valueOf(j));
        AppMethodBeat.m2505o(36270);
        return true;
    }

    /* renamed from: ke */
    private static boolean m68003ke(long j) {
        AppMethodBeat.m2504i(36271);
        qIU.remove(Long.valueOf(j));
        AppMethodBeat.m2505o(36271);
        return true;
    }

    public C39761q(long j) {
        AppMethodBeat.m2504i(36272);
        this.cND = j;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cbg();
        c1196a.fsK = new cbh();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmsnsobjectdetail";
        this.ehh = c1196a.acD();
        ((cbg) this.ehh.fsG.fsP).vQE = j;
        C4990ab.m7410d("MicroMsg.NetSceneSnsObjectDetial", "req snsId ".concat(String.valueOf(j)));
        AppMethodBeat.m2505o(36272);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(36273);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(36273);
        return a;
    }

    public final int getType() {
        return 210;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(36274);
        if (i2 == 0 && i3 == 0) {
            cbf cbf = ((cbh) this.ehh.fsH.fsP).xaI;
            if (cbf != null) {
                C4990ab.m7416i("MicroMsg.NetSceneSnsObjectDetial", "snsdetail xml " + C1946aa.m4153b(cbf.xam));
            }
            C34955aj.m57404d(cbf);
            this.ehi.onSceneEnd(i2, i3, str, this);
            C39761q.m68003ke(this.cND);
            AppMethodBeat.m2505o(36274);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        C39761q.m68003ke(this.cND);
        AppMethodBeat.m2505o(36274);
    }
}
