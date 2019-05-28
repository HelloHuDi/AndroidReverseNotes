package com.tencent.mm.plugin.aa.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.g;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends m implements k {
    public String chatroomName;
    private com.tencent.mm.ai.f ehi;
    private b gme;
    private com.tencent.mm.protocal.protobuf.f gmh;
    public g gmi;

    public f(long j, String str, List<String> list, int i, long j2, String str2) {
        AppMethodBeat.i(40647);
        a aVar = new a();
        aVar.fsJ = new com.tencent.mm.protocal.protobuf.f();
        aVar.fsK = new g();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.chatroomName = str2;
        this.gme = aVar.acD();
        this.gmh = (com.tencent.mm.protocal.protobuf.f) this.gme.fsG.fsP;
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
                    this.gmh.vzR = com.tencent.mm.plugin.wallet_core.model.k.cPy();
                    this.gmh.vzS = j2;
                    ab.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.gmh.vzR);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
            }
        }
        ab.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", Integer.valueOf(this.gmh.vzO), Long.valueOf(this.gmh.vzP), this.gmh.title, this.gmh.vzQ, Integer.valueOf(this.gmh.scene), this.gmh.vzM, Long.valueOf(this.gmh.vzS));
        AppMethodBeat.o(40647);
    }

    public f(long j, String str, int i, int i2, long j2, String str2) {
        AppMethodBeat.i(40648);
        a aVar = new a();
        aVar.fsJ = new com.tencent.mm.protocal.protobuf.f();
        aVar.fsK = new g();
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.gme = aVar.acD();
        this.gmh = (com.tencent.mm.protocal.protobuf.f) this.gme.fsG.fsP;
        this.chatroomName = str2;
        try {
            this.gmh.vzO = i;
            this.gmh.vzP = j;
            this.gmh.title = URLEncoder.encode(str, "UTF-8");
            this.gmh.vzQ = new LinkedList();
            this.gmh.scene = i2;
            this.gmh.vzM = str2;
            this.gmh.vzR = com.tencent.mm.plugin.wallet_core.model.k.cPy();
            ab.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", this.gmh.vzR);
            this.gmh.vzS = j2;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", e.getMessage());
        }
        ab.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", Integer.valueOf(this.gmh.vzO), Long.valueOf(this.gmh.vzP), this.gmh.title, this.gmh.vzQ, Integer.valueOf(this.gmh.scene), this.gmh.vzM, Long.valueOf(this.gmh.vzS));
        AppMethodBeat.o(40648);
    }

    public final int getType() {
        return 1624;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        AppMethodBeat.i(40649);
        ab.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.ehi = fVar;
        int a = a(eVar, this.gme, this);
        AppMethodBeat.o(40649);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(40650);
        ab.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gmi = (g) ((b) qVar).fsH.fsP;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.gmi.kCl);
        objArr[1] = this.gmi.kCm;
        objArr[2] = Boolean.valueOf(this.gmi.vzN == null);
        objArr[3] = this.gmi.vzL;
        ab.i(str2, str3, objArr);
        ab.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", this.gmi.vzN);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.o(40650);
    }
}
