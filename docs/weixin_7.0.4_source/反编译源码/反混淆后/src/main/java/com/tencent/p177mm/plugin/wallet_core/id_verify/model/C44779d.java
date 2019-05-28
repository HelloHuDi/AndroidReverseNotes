package com.tencent.p177mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cgr;
import com.tencent.p177mm.protocal.protobuf.cgs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C16080v;
import com.tencent.p177mm.wallet_core.p649c.C44430q;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet_core.id_verify.model.d */
public final class C44779d extends C44430q {
    public String token;

    public C44779d(String str, String str2, int i) {
        AppMethodBeat.m2504i(46641);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        C4990ab.m7417i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", Integer.valueOf(i));
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46641);
    }

    public final int cOo() {
        return 0;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46642);
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.m2505o(46642);
    }

    /* renamed from: U */
    public final void mo11719U(boolean z, boolean z2) {
        AppMethodBeat.m2504i(46643);
        C7472b dNN = dNN();
        if (dNN == null) {
            C1196a c1196a = new C1196a();
            c1196a.fsJ = new cgr();
            c1196a.fsK = new cgs();
            c1196a.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            c1196a.fsI = 1616;
            c1196a.fsL = 185;
            c1196a.fsM = 1000000185;
            dNN = c1196a.acD();
            dNN.ftb = true;
        }
        C7472b c7472b = dNN;
        cgr cgr = (cgr) c7472b.fsG.fsP;
        if (z2) {
            cgr.wxy = 1;
        }
        mo70332f(c7472b);
        AppMethodBeat.m2505o(46643);
    }

    public final String acv(String str) {
        AppMethodBeat.m2504i(46644);
        String signWith3Des = TenpayUtil.signWith3Des(str);
        AppMethodBeat.m2505o(46644);
        return signWith3Des;
    }

    public final int getType() {
        return 1616;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(46646);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(46646);
        return a;
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
        AppMethodBeat.m2504i(46645);
        cgs cgs = (cgs) c7472b.fsH.fsP;
        C16080v c16080v = new C16080v();
        c16080v.wxD = cgs.wxD;
        c16080v.wxC = cgs.wxC;
        c16080v.wxB = cgs.wxB;
        c16080v.wxA = cgs.wxA;
        c16080v.luU = cgs.wNf;
        c16080v.AfP = cgs.wNe;
        AppMethodBeat.m2505o(46645);
        return c16080v;
    }
}
