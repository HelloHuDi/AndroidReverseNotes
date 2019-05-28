package com.tencent.mm.wallet_core.e.a;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bka;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

public abstract class a extends q {
    public abstract int cOX();

    public final int cOo() {
        return cOX();
    }

    public final void U(boolean z, boolean z2) {
        b dNN = dNN();
        if (dNN == null) {
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsJ = new bjz();
            aVar.fsK = new bka();
            aVar.uri = "/cgi-bin/mmpay-bin/payu";
            aVar.fsI = 1518;
            aVar.fsL = 0;
            aVar.fsM = 0;
            dNN = aVar.acD();
            dNN.ftb = true;
        }
        b bVar = dNN;
        bjz bjz = (bjz) bVar.fsG.fsP;
        if (z) {
            bjz.wxx = cOX();
        }
        if (z2) {
            bjz.wxy = 1;
        }
        f(bVar);
    }

    public final int getType() {
        return 1518;
    }

    public final String acv(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    public int a(e eVar, f fVar) {
        this.ehi = fVar;
        if (r.YM()) {
            return a(eVar, this.ehh, this);
        }
        ab.e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        fVar.onSceneEnd(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    public final void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }

    public final void a(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((bjz) bVar.fsG.fsP).wxz = sKBuiltinBuffer_t;
    }

    public final void b(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((bjz) bVar.fsG.fsP).wNd = sKBuiltinBuffer_t;
    }

    public final v e(b bVar) {
        bka bka = (bka) bVar.fsH.fsP;
        v vVar = new v();
        vVar.wxD = bka.wxD;
        vVar.wxC = bka.wxC;
        vVar.wxB = bka.wxB;
        vVar.wxA = bka.wxA;
        vVar.luU = bka.wNf;
        vVar.AfP = bka.wNe;
        return vVar;
    }
}
