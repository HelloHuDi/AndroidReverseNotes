package com.tencent.mm.wallet_core.tenpay.model;

import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.model.r;
import com.tencent.mm.network.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.wallet_core.c.ac;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

public abstract class m extends q {
    public static Vector<String> AgC = new Vector();
    protected boolean AgB = false;

    public abstract int bgI();

    public int cOo() {
        return bgI();
    }

    public void U(boolean z, boolean z2) {
        b acD;
        b dNN = dNN();
        if (dNN == null) {
            boolean z3;
            a aVar = new a();
            aVar.fsJ = new cgr();
            aVar.fsK = new cgs();
            String uri = getUri();
            int ZU = ZU();
            aVar.uri = uri;
            aVar.fsI = ZU;
            aVar.fsL = 185;
            aVar.fsM = 1000000185;
            acD = aVar.acD();
            if (dOi()) {
                z3 = false;
            } else {
                z3 = true;
            }
            acD.ftb = z3;
        } else {
            acD = dNN;
        }
        cgr cgr = (cgr) acD.fsG.fsP;
        if (z) {
            cgr.wxx = bgI();
        }
        if (z2) {
            cgr.wxy = 1;
        }
        f(acD);
    }

    public boolean dOi() {
        return true;
    }

    public int getType() {
        return 385;
    }

    public final String acv(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    static {
        for (Object add : d.vwq) {
            AgC.add(add);
        }
    }

    private int g(b bVar) {
        String str;
        cgr cgr = (cgr) bVar.fsG.fsP;
        if (cgr.wxz != null) {
            str = new String(cgr.wxz.getBufferToBytes());
        }
        if (cgr.wNd != null) {
            str = new String(cgr.wNd.getBufferToBytes());
        }
        ah.getContext();
        ac.dOb();
        if (!this.AgB) {
            return -1;
        }
        cgs cgs = (cgs) bVar.fsH.fsP;
        if (cgs == null) {
            cgs = new cgs();
        }
        cgs.wxA = new SKBuiltinBuffer_t().setBuffer("".getBytes());
        cgs.wxD = cOo();
        cgs.wxB = 0;
        try {
            JSONObject jSONObject = new JSONObject(null);
            cgs.wNe = jSONObject.optInt("TenpayErrType");
            cgs.wNf = jSONObject.optString("TenpayErrMsg");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        a(1, 0, 0, "", bVar, null);
        return 1;
    }

    public final void dOq() {
        this.AgB = true;
    }

    public int a(e eVar, f fVar) {
        this.ehi = fVar;
        if (AgC.contains(this.ehh.uri)) {
            ab.d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", this.ehh.uri);
        } else {
            Object[] objArr = new Object[1];
            com.tencent.mm.wallet_core.c.b.dNJ();
            objArr[0] = Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError());
            ab.i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mm.wallet_core.c.b.dNJ();
            com.tencent.mm.wallet_core.c.b.init(ah.getContext());
            cgr cgr = (cgr) this.ehh.fsG.fsP;
            String str = "";
            String str2 = "";
            if (cgr.wxz != null) {
                str = new String(cgr.wxz.getBufferToBytes());
            }
            if (cgr.wNd != null) {
                str2 = new String(cgr.wNd.getBufferToBytes());
            }
            String str3 = new String((str + "&&" + str2).getBytes());
            com.tencent.mm.wallet_core.c.ab.dNZ();
            String dNY = com.tencent.mm.wallet_core.c.ab.dNY();
            com.tencent.mm.wallet_core.c.b.dNJ();
            if (com.tencent.mm.wallet_core.c.b.isCertExist(dNY)) {
                h.pYm.a(414, 20, 1, true);
                com.tencent.mm.wallet_core.c.b.dNJ();
                String genUserSig = com.tencent.mm.wallet_core.c.b.genUserSig(dNY, str3);
                h.pYm.a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                ab.v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", str3, genUserSig);
                cgr.sign = genUserSig;
                cgr.xfz = dNY;
            } else {
                objArr = new Object[2];
                objArr[0] = dNY;
                com.tencent.mm.wallet_core.c.b.dNJ();
                objArr[1] = Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError());
                ab.i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            ab.i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dNY);
        }
        if (this.AgB) {
            int g = g(this.ehh);
            if (g != -1) {
                return g;
            }
        }
        if (r.YM()) {
            ab.e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            fVar.onSceneEnd(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return a(eVar, this.ehh, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    public int ZU() {
        return 385;
    }

    public final void a(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) bVar.fsG.fsP).wxz = sKBuiltinBuffer_t;
    }

    public final void b(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) bVar.fsG.fsP).wNd = sKBuiltinBuffer_t;
    }

    public final v e(b bVar) {
        cgs cgs = (cgs) bVar.fsH.fsP;
        v vVar = new v();
        vVar.wxD = cgs.wxD;
        vVar.wxC = cgs.wxC;
        vVar.wxB = cgs.wxB;
        vVar.wxA = cgs.wxA;
        vVar.luU = cgs.wNf;
        vVar.AfP = cgs.wNe;
        return vVar;
    }
}
