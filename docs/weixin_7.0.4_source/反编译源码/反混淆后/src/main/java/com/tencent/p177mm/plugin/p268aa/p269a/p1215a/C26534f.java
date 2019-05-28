package com.tencent.p177mm.plugin.p268aa.p269a.p1215a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.protocal.protobuf.C23389g;
import com.tencent.p177mm.protocal.protobuf.C30181f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.a.a.f */
public final class C26534f extends C1207m implements C1918k {
    public String chatroomName;
    private C1202f ehi;
    private C7472b gme;
    private C30181f gmh;
    public C23389g gmi;

    public C26534f(long j, String str, List<String> list, int i, long j2, String str2) {
        AppMethodBeat.m2504i(40647);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30181f();
        c1196a.fsK = new C23389g();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.chatroomName = str2;
        this.gme = c1196a.acD();
        this.gmh = (C30181f) this.gme.fsG.fsP;
        this.gme.ftb = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.gmh.vzO = list.size();
                    this.gmh.vzP = j;
                    this.gmh.title = URLEncoder.encode(str, "UTF-8");
                    this.gmh.vzQ = new LinkedList();
                    this.gmh.vzQ.addAll(list);
                    this.gmh.scene = i;
                    this.gmh.vzM = str2;
                    this.gmh.vzR = C22594k.cPy();
                    this.gmh.vzS = j2;
                    C4990ab.m7411d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.gmh.vzR);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
            }
        }
        C4990ab.m7417i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", Integer.valueOf(this.gmh.vzO), Long.valueOf(this.gmh.vzP), this.gmh.title, this.gmh.vzQ, Integer.valueOf(this.gmh.scene), this.gmh.vzM, Long.valueOf(this.gmh.vzS));
        AppMethodBeat.m2505o(40647);
    }

    public C26534f(long j, String str, int i, int i2, long j2, String str2) {
        AppMethodBeat.m2504i(40648);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C30181f();
        c1196a.fsK = new C23389g();
        c1196a.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.gme = c1196a.acD();
        this.gmh = (C30181f) this.gme.fsG.fsP;
        this.chatroomName = str2;
        try {
            this.gmh.vzO = i;
            this.gmh.vzP = j;
            this.gmh.title = URLEncoder.encode(str, "UTF-8");
            this.gmh.vzQ = new LinkedList();
            this.gmh.scene = i2;
            this.gmh.vzM = str2;
            this.gmh.vzR = C22594k.cPy();
            C4990ab.m7411d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.gmh.vzR);
            this.gmh.vzS = j2;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
        }
        C4990ab.m7417i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", Integer.valueOf(this.gmh.vzO), Long.valueOf(this.gmh.vzP), this.gmh.title, this.gmh.vzQ, Integer.valueOf(this.gmh.scene), this.gmh.vzM, Long.valueOf(this.gmh.vzS));
        AppMethodBeat.m2505o(40648);
    }

    public final int getType() {
        return 1624;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40649);
        C4990ab.m7416i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.gme, this);
        AppMethodBeat.m2505o(40649);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40650);
        C4990ab.m7417i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmi = (C23389g) ((C7472b) c1929q).fsH.fsP;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gmi.kCl);
        objArr[1] = this.gmi.kCm;
        objArr[2] = Boolean.valueOf(this.gmi.vzN == null);
        objArr[3] = this.gmi.vzL;
        C4990ab.m7417i(str2, str3, objArr);
        C4990ab.m7411d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", this.gmi.vzN);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40650);
    }
}
