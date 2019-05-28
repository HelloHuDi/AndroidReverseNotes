package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements k, e {
    private int cOi;
    public b ehh;
    private f ehi;
    private String gHr = null;
    private int msp;
    private com.tencent.soter.a.f.b<e.b> msq = null;

    public final /* synthetic */ void bR(Object obj) {
        AppMethodBeat.i(41583);
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.fsJ = new ccu();
        aVar2.fsK = new ccv();
        aVar2.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar2.fsI = 1665;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        this.ehh = aVar2.acD();
        ccu ccu = (ccu) this.ehh.fsG.fsP;
        ccu.xcb = this.gHr;
        ccu.xcc = aVar.AvZ;
        ccu.xcd = aVar.Awa;
        ccu.cDo = TenpayUtil.signWith3Des("passwd=" + ccu.xcb);
        ccu.xbY = this.msp;
        ccu.xbZ = this.cOi;
        try {
            JSONObject jSONObject = new JSONObject(aVar.AvZ);
            com.tencent.mm.plugin.soter.d.d.gu(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
        ab.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "json: %s, sign: %s", aVar.AvZ, aVar.Awa);
        AppMethodBeat.o(41583);
    }

    public c(String str, int i) {
        this.gHr = str;
        this.msp = i;
        this.cOi = i;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(41578);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(41578);
        return a;
    }

    public final void d(int i, int i2, String str, q qVar) {
        AppMethodBeat.i(41579);
        ab.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        if (this.msq != null) {
            if (i == 0 && i2 == 0) {
                this.msq.dd(new e.b(true));
                AppMethodBeat.o(41579);
                return;
            }
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(41579);
    }

    public final void bxO() {
        AppMethodBeat.i(41580);
        ab.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        if (this.msq != null) {
            ab.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.msq.dd(new e.b(false));
        }
        AppMethodBeat.o(41580);
    }

    public final void vL(int i) {
        AppMethodBeat.i(41581);
        ab.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", Integer.valueOf(3), Integer.valueOf(i));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(4, -1, "", this);
        }
        AppMethodBeat.o(41581);
    }

    public final void execute() {
        AppMethodBeat.i(41582);
        g.Rg().a((m) this, 0);
        AppMethodBeat.o(41582);
    }

    public final void a(com.tencent.soter.a.f.b<e.b> bVar) {
        this.msq = bVar;
    }
}
