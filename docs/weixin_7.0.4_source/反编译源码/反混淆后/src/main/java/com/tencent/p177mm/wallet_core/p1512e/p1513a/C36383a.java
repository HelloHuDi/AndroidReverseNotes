package com.tencent.p177mm.wallet_core.p1512e.p1513a;

import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bjz;
import com.tencent.p177mm.protocal.protobuf.bka;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C16080v;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tenpay.android.wechat.TenpayUtil;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.wallet_core.e.a.a */
public abstract class C36383a extends C44430q {
    public abstract int cOX();

    public final int cOo() {
        return cOX();
    }

    /* renamed from: U */
    public final void mo11719U(boolean z, boolean z2) {
        C7472b dNN = dNN();
        if (dNN == null) {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new bjz();
            c1196a.fsK = new bka();
            c1196a.uri = "/cgi-bin/mmpay-bin/payu";
            c1196a.fsI = 1518;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            dNN = c1196a.acD();
            dNN.ftb = true;
        }
        C7472b c7472b = dNN;
        bjz bjz = (bjz) c7472b.fsG.fsP;
        if (z) {
            bjz.wxx = cOX();
        }
        if (z2) {
            bjz.wxy = 1;
        }
        mo70332f(c7472b);
    }

    public final int getType() {
        return 1518;
    }

    public final String acv(String str) {
        return TenpayUtil.signWith3Des(str);
    }

    /* renamed from: a */
    public int mo4456a(C1902e c1902e, C1202f c1202f) {
        this.ehi = c1202f;
        if (C1853r.m3831YM()) {
            return mo4457a(c1902e, this.ehh, this);
        }
        C4990ab.m7412e("MicroMsg.NetScenePayUBase", "hy: serious error: not payupay");
        c1202f.onSceneEnd(1000, -100868, "Pay Method Err", this);
        return 1;
    }

    /* renamed from: b */
    public final void mo57301b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(URLEncoder.encode(str));
    }

    /* renamed from: a */
    public final void mo11720a(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((bjz) c7472b.fsG.fsP).wxz = sKBuiltinBuffer_t;
    }

    /* renamed from: b */
    public final void mo11722b(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((bjz) c7472b.fsG.fsP).wNd = sKBuiltinBuffer_t;
    }

    /* renamed from: e */
    public final C16080v mo11727e(C7472b c7472b) {
        bka bka = (bka) c7472b.fsH.fsP;
        C16080v c16080v = new C16080v();
        c16080v.wxD = bka.wxD;
        c16080v.wxC = bka.wxC;
        c16080v.wxB = bka.wxB;
        c16080v.wxA = bka.wxA;
        c16080v.luU = bka.wNf;
        c16080v.AfP = bka.wNe;
        return c16080v;
    }
}
