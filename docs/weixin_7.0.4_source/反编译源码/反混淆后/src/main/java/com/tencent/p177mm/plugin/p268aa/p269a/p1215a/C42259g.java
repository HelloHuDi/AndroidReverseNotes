package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C40524h;
import com.tencent.p177mm.protocal.protobuf.C40532j;
import com.tencent.p177mm.protocal.protobuf.C46549i;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.a.a.g */
public final class C42259g extends C1207m implements C1918k {
    public String chatroomName;
    private C1202f ehi;
    private C7472b gme;
    private C40524h gmj;
    public C46549i gmk;

    public C42259g(String str, long j, List<C40532j> list, int i, String str2, long j2) {
        AppMethodBeat.m2504i(40651);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40524h();
        c1196a.fsK = new C46549i();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gmj = (C40524h) this.gme.fsG.fsP;
        this.gme.ftb = true;
        try {
            this.gmj.title = C18178q.encode(str, "UTF-8");
            this.gmj.vzU = j;
            this.gmj.vzQ = new LinkedList();
            this.gmj.vzQ.addAll(list);
            this.gmj.scene = i;
            this.gmj.vzM = str2;
            this.gmj.vzR = C22594k.cPy();
            this.gmj.vzS = j2;
            C4990ab.m7411d("MicroMsg.NetSceneAALaunchByPerson", "location %s", this.gmj.vzR);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", e.getMessage());
        }
        this.chatroomName = str2;
        C4990ab.m7417i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", this.gmj.title, Long.valueOf(this.gmj.vzU), this.gmj.vzQ, Integer.valueOf(this.gmj.scene), this.gmj.vzM, Long.valueOf(this.gmj.vzS));
        AppMethodBeat.m2505o(40651);
    }

    public final int getType() {
        return 1655;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40652);
        C4990ab.m7410d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40652);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40653);
        C4990ab.m7417i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmk = (C46549i) ((C7472b) c1929q).fsH.fsP;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gmk.kCl);
        objArr[1] = this.gmk.kCm;
        objArr[2] = this.gmk.vzL;
        objArr[3] = Boolean.valueOf(this.gmk.vzN == null);
        C4990ab.m7417i(str2, str3, objArr);
        C4990ab.m7411d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", this.gmk.vzN);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40653);
    }
}
