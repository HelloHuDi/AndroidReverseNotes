package com.tencent.p177mm.wallet_core.tenpay.model;

import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.wallet.C30160d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cgr;
import com.tencent.p177mm.protocal.protobuf.cgs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.p649c.C16080v;
import com.tencent.p177mm.wallet_core.p649c.C40927ac;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tencent.p177mm.wallet_core.p649c.C46720ab;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.Vector;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.tenpay.model.m */
public abstract class C5749m extends C44430q {
    public static Vector<String> AgC = new Vector();
    protected boolean AgB = false;

    public abstract int bgI();

    public int cOo() {
        return bgI();
    }

    /* renamed from: U */
    public void mo11719U(boolean z, boolean z2) {
        C7472b acD;
        C7472b dNN = dNN();
        if (dNN == null) {
            boolean z3;
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cgr();
            c1196a.fsK = new cgs();
            String uri = getUri();
            int ZU = mo9382ZU();
            c1196a.uri = uri;
            c1196a.fsI = ZU;
            c1196a.fsL = 185;
            c1196a.fsM = 1000000185;
            acD = c1196a.acD();
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
        mo70332f(acD);
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
        for (Object add : C30160d.vwq) {
            AgC.add(add);
        }
    }

    /* renamed from: g */
    private int m8664g(C7472b c7472b) {
        String str;
        cgr cgr = (cgr) c7472b.fsG.fsP;
        if (cgr.wxz != null) {
            str = new String(cgr.wxz.getBufferToBytes());
        }
        if (cgr.wNd != null) {
            str = new String(cgr.wNd.getBufferToBytes());
        }
        C4996ah.getContext();
        C40927ac.dOb();
        if (!this.AgB) {
            return -1;
        }
        cgs cgs = (cgs) c7472b.fsH.fsP;
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
            C4990ab.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
        }
        mo4498a(1, 0, 0, "", c7472b, null);
        return 1;
    }

    public final void dOq() {
        this.AgB = true;
    }

    /* renamed from: a */
    public int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        if (AgC.contains(this.ehh.uri)) {
            C4990ab.m7411d("MicroMsg.NetSenceTenPayBase", "black cgi bye bye %s", this.ehh.uri);
        } else {
            Object[] objArr = new Object[1];
            C40928b.dNJ();
            objArr[0] = Integer.valueOf(C40928b.getLastError());
            C4990ab.m7417i("MicroMsg.NetSenceTenPayBase", "cert try get errormsg %s", objArr);
            long currentTimeMillis = System.currentTimeMillis();
            C40928b.dNJ();
            C40928b.init(C4996ah.getContext());
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
            C46720ab.dNZ();
            String dNY = C46720ab.dNY();
            C40928b.dNJ();
            if (C40928b.isCertExist(dNY)) {
                C7060h.pYm.mo8378a(414, 20, 1, true);
                C40928b.dNJ();
                String genUserSig = C40928b.genUserSig(dNY, str3);
                C7060h.pYm.mo8378a(414, 21, System.currentTimeMillis() - currentTimeMillis, true);
                C4990ab.m7419v("MicroMsg.NetSenceTenPayBase", "sign ret src:%s sign:%s", str3, genUserSig);
                cgr.sign = genUserSig;
                cgr.xfz = dNY;
            } else {
                objArr = new Object[2];
                objArr[0] = dNY;
                C40928b.dNJ();
                objArr[1] = Integer.valueOf(C40928b.getLastError());
                C4990ab.m7417i("MicroMsg.NetSenceTenPayBase", "cert not exist cn %s %s", objArr);
            }
            C4990ab.m7417i("MicroMsg.NetSenceTenPayBase", "sign cost time %s cn %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), dNY);
        }
        if (this.AgB) {
            int g = m8664g(this.ehh);
            if (g != -1) {
                return g;
            }
        }
        if (C1853r.m3831YM()) {
            C4990ab.m7412e("MicroMsg.NetSenceTenPayBase", "hy: serious error: is payupay");
            c1202f.onSceneEnd(1000, -100868, "Pay Method Err", this);
            return 1;
        }
        return mo4457a(c1902e, this.ehh, this);
    }

    public String getUri() {
        return "/cgi-bin/micromsg-bin/tenpay";
    }

    /* renamed from: ZU */
    public int mo9382ZU() {
        return 385;
    }

    /* renamed from: a */
    public final void mo11720a(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) c7472b.fsG.fsP).wxz = sKBuiltinBuffer_t;
    }

    /* renamed from: b */
    public final void mo11722b(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) c7472b.fsG.fsP).wNd = sKBuiltinBuffer_t;
    }

    /* renamed from: e */
    public final C16080v mo11727e(C7472b c7472b) {
        cgs cgs = (cgs) c7472b.fsH.fsP;
        C16080v c16080v = new C16080v();
        c16080v.wxD = cgs.wxD;
        c16080v.wxC = cgs.wxC;
        c16080v.wxB = cgs.wxB;
        c16080v.wxA = cgs.wxA;
        c16080v.luU = cgs.wNf;
        c16080v.AfP = cgs.wNe;
        return c16080v;
    }
}
