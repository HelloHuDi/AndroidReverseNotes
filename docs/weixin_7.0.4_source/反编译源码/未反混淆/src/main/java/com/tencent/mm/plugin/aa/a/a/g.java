package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.h;
import com.tencent.mm.protocal.protobuf.i;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class g extends m implements k {
    public String chatroomName;
    private f ehi;
    private b gme;
    private h gmj;
    public i gmk;

    public g(String str, long j, List<j> list, int i, String str2, long j2) {
        AppMethodBeat.i(40651);
        a aVar = new a();
        aVar.fsJ = new h();
        aVar.fsK = new i();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gmj = (h) this.gme.fsG.fsP;
        this.gme.ftb = true;
        try {
            this.gmj.title = q.encode(str, "UTF-8");
            this.gmj.vzU = j;
            this.gmj.vzQ = new LinkedList();
            this.gmj.vzQ.addAll(list);
            this.gmj.scene = i;
            this.gmj.vzM = str2;
            this.gmj.vzR = com.tencent.mm.plugin.wallet_core.model.k.cPy();
            this.gmj.vzS = j2;
            ab.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", this.gmj.vzR);
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", e.getMessage());
        }
        this.chatroomName = str2;
        ab.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", this.gmj.title, Long.valueOf(this.gmj.vzU), this.gmj.vzQ, Integer.valueOf(this.gmj.scene), this.gmj.vzM, Long.valueOf(this.gmj.vzS));
        AppMethodBeat.o(40651);
    }

    public final int getType() {
        return 1655;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(40652);
        ab.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40652);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(40653);
        ab.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmk = (i) ((b) qVar).fsH.fsP;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gmk.kCl);
        objArr[1] = this.gmk.kCm;
        objArr[2] = this.gmk.vzL;
        objArr[3] = Boolean.valueOf(this.gmk.vzN == null);
        ab.i(str2, str3, objArr);
        ab.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", this.gmk.vzN);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40653);
    }
}
