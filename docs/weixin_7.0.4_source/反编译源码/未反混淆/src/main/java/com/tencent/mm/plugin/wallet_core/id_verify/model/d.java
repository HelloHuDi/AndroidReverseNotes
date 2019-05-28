package com.tencent.mm.plugin.wallet_core.id_verify.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cgr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.c.v;
import com.tenpay.android.wechat.TenpayUtil;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends q {
    public String token;

    public d(String str, String str2, int i) {
        AppMethodBeat.i(46641);
        HashMap hashMap = new HashMap();
        hashMap.put("flag", "1");
        hashMap.put("true_name", str);
        hashMap.put("identify_card", str2);
        hashMap.put("cre_type", "1");
        hashMap.put("realname_scene", String.valueOf(i));
        ab.i("MicroMsg.NetSceneRealNameVerify", "realname_scene=%d", Integer.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(46641);
    }

    public final int cOo() {
        return 0;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46642);
        if (i == 0) {
            this.token = jSONObject.optString("token");
        }
        AppMethodBeat.o(46642);
    }

    public final void U(boolean z, boolean z2) {
        AppMethodBeat.i(46643);
        b dNN = dNN();
        if (dNN == null) {
            a aVar = new a();
            aVar.fsJ = new cgr();
            aVar.fsK = new cgs();
            aVar.uri = "/cgi-bin/mmpay-bin/tenpay/realnameauthen";
            aVar.fsI = 1616;
            aVar.fsL = 185;
            aVar.fsM = 1000000185;
            dNN = aVar.acD();
            dNN.ftb = true;
        }
        b bVar = dNN;
        cgr cgr = (cgr) bVar.fsG.fsP;
        if (z2) {
            cgr.wxy = 1;
        }
        f(bVar);
        AppMethodBeat.o(46643);
    }

    public final String acv(String str) {
        AppMethodBeat.i(46644);
        String signWith3Des = TenpayUtil.signWith3Des(str);
        AppMethodBeat.o(46644);
        return signWith3Des;
    }

    public final int getType() {
        return 1616;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(46646);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(46646);
        return a;
    }

    public final void a(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) bVar.fsG.fsP).wxz = sKBuiltinBuffer_t;
    }

    public final void b(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t) {
        ((cgr) bVar.fsG.fsP).wNd = sKBuiltinBuffer_t;
    }

    public final v e(b bVar) {
        AppMethodBeat.i(46645);
        cgs cgs = (cgs) bVar.fsH.fsP;
        v vVar = new v();
        vVar.wxD = cgs.wxD;
        vVar.wxC = cgs.wxC;
        vVar.wxB = cgs.wxB;
        vVar.wxA = cgs.wxA;
        vVar.luU = cgs.wNf;
        vVar.AfP = cgs.wNe;
        AppMethodBeat.o(46645);
        return vVar;
    }
}
