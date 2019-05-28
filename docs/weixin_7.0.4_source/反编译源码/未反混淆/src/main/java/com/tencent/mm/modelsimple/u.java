package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bkt;
import com.tencent.mm.protocal.protobuf.buf;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

public final class u extends m implements k {
    public long cvx = -1;
    public com.tencent.mm.ai.b ehh;
    private f ehi;
    public int errCode;
    public int errType;
    private final long fPJ = 60000;
    private Runnable fPK;

    public static final class a {
        public String desc = "";
        public String ffv = "";
        public String link = "";
        public int type = 5;
    }

    public static final class b {
        public String desc;
        public LinkedList<a> fPL;
        public String title;

        public static LinkedList<a> f(Map<String, String> map, String str) {
            AppMethodBeat.i(78587);
            LinkedList<a> linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 1000) {
                    String str2 = str + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    try {
                        i = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                        a aVar = new a();
                        if (i == 5) {
                            aVar.ffv = bo.nullAsNil((String) map.get(str2 + ".iconurl"));
                            aVar.desc = bo.nullAsNil((String) map.get(str2 + ".desc"));
                            aVar.link = bo.nullAsNil((String) map.get(str2 + ".link"));
                            if (bo.isNullOrNil(aVar.ffv) && bo.isNullOrNil(aVar.desc) && bo.isNullOrNil(aVar.link)) {
                                AppMethodBeat.o(78587);
                                return linkedList;
                            }
                            linkedList.add(aVar);
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.o(78587);
                            return linkedList;
                        }
                    } catch (Exception e) {
                        ab.w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                        AppMethodBeat.o(78587);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(78587);
                return linkedList;
            }
        }
    }

    public u(float f, float f2, long j) {
        AppMethodBeat.i(78588);
        bkt bkt = new bkt();
        bkt.vRp = f;
        bkt.vRq = f2;
        bkt.wfJ = 1;
        bkt.wfG = 0;
        a(bkt, 1, -10000.0f, -10000.0f);
        this.cvx = j;
        AppMethodBeat.o(78588);
    }

    public u(buf buf) {
        AppMethodBeat.i(78589);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = buf;
        aVar.fsK = new bug();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.fsI = v2helper.EMethodSetSpkEnhance;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(78589);
    }

    public u(bkt bkt, float f, float f2) {
        AppMethodBeat.i(78590);
        a(bkt, 0, f, f2);
        AppMethodBeat.o(78590);
    }

    private void a(bkt bkt, int i, float f, float f2) {
        AppMethodBeat.i(78591);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new buf();
        aVar.fsK = new bug();
        aVar.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        aVar.fsI = v2helper.EMethodSetSpkEnhance;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        buf buf = (buf) this.ehh.fsG.fsP;
        buf.wVW = bkt;
        buf.Scene = i;
        buf.wVX = f;
        buf.wVY = f2;
        AppMethodBeat.o(78591);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78592);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78592);
        return a;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        AppMethodBeat.i(78593);
        com.tencent.mm.ai.m.b bVar;
        if (((buf) ((com.tencent.mm.ai.b) qVar).fsG.fsP).wVW == null) {
            ab.e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
            bVar = com.tencent.mm.ai.m.b.EFailed;
            AppMethodBeat.o(78593);
            return bVar;
        }
        bVar = com.tencent.mm.ai.m.b.EOk;
        AppMethodBeat.o(78593);
        return bVar;
    }

    public final bug ajC() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (bug) this.ehh.fsH.fsP;
    }

    public final int acn() {
        return 10;
    }

    public final void a(com.tencent.mm.ai.m.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78594);
        ab.d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        } else {
            ab.e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        ab.d("MicroMsg.NetSceneScanStreetView", "xml is %s", ajC().vOt);
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.o(78594);
    }

    public final int getType() {
        return v2helper.EMethodSetSpkEnhance;
    }

    public static String tu(String str) {
        AppMethodBeat.i(78595);
        Map z = br.z(str, "streetview");
        if (z == null) {
            AppMethodBeat.o(78595);
            return null;
        }
        String str2 = (String) z.get(".streetview.link");
        AppMethodBeat.o(78595);
        return str2;
    }
}
