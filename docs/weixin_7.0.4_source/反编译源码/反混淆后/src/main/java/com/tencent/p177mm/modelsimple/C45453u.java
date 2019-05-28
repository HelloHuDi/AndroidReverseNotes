package com.tencent.p177mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1205a;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bkt;
import com.tencent.p177mm.protocal.protobuf.buf;
import com.tencent.p177mm.protocal.protobuf.bug;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.modelsimple.u */
public final class C45453u extends C1207m implements C1918k {
    public long cvx = -1;
    public C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public int errType;
    private final long fPJ = 60000;
    private Runnable fPK;

    /* renamed from: com.tencent.mm.modelsimple.u$a */
    public static final class C26474a {
        public String desc = "";
        public String ffv = "";
        public String link = "";
        public int type = 5;
    }

    /* renamed from: com.tencent.mm.modelsimple.u$b */
    public static final class C37949b {
        public String desc;
        public LinkedList<C26474a> fPL;
        public String title;

        /* renamed from: f */
        public static LinkedList<C26474a> m64159f(Map<String, String> map, String str) {
            AppMethodBeat.m2504i(78587);
            LinkedList<C26474a> linkedList = new LinkedList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 1000) {
                    String str2 = str + ".action" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    try {
                        i = Integer.valueOf((String) map.get(str2 + ".$type")).intValue();
                        C26474a c26474a = new C26474a();
                        if (i == 5) {
                            c26474a.ffv = C5046bo.nullAsNil((String) map.get(str2 + ".iconurl"));
                            c26474a.desc = C5046bo.nullAsNil((String) map.get(str2 + ".desc"));
                            c26474a.link = C5046bo.nullAsNil((String) map.get(str2 + ".link"));
                            if (C5046bo.isNullOrNil(c26474a.ffv) && C5046bo.isNullOrNil(c26474a.desc) && C5046bo.isNullOrNil(c26474a.link)) {
                                AppMethodBeat.m2505o(78587);
                                return linkedList;
                            }
                            linkedList.add(c26474a);
                            i = i2 + 1;
                        } else {
                            AppMethodBeat.m2505o(78587);
                            return linkedList;
                        }
                    } catch (Exception e) {
                        C4990ab.m7420w("MicroMsg.NetSceneScanStreetView", "parseVendorsFromXml() " + e.getMessage());
                        AppMethodBeat.m2505o(78587);
                        return linkedList;
                    }
                }
                AppMethodBeat.m2505o(78587);
                return linkedList;
            }
        }
    }

    public C45453u(float f, float f2, long j) {
        AppMethodBeat.m2504i(78588);
        bkt bkt = new bkt();
        bkt.vRp = f;
        bkt.vRq = f2;
        bkt.wfJ = 1;
        bkt.wfG = 0;
        m83728a(bkt, 1, -10000.0f, -10000.0f);
        this.cvx = j;
        AppMethodBeat.m2505o(78588);
    }

    public C45453u(buf buf) {
        AppMethodBeat.m2504i(78589);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = buf;
        c1196a.fsK = new bug();
        c1196a.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        c1196a.fsI = v2helper.EMethodSetSpkEnhance;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(78589);
    }

    public C45453u(bkt bkt, float f, float f2) {
        AppMethodBeat.m2504i(78590);
        m83728a(bkt, 0, f, f2);
        AppMethodBeat.m2505o(78590);
    }

    /* renamed from: a */
    private void m83728a(bkt bkt, int i, float f, float f2) {
        AppMethodBeat.m2504i(78591);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new buf();
        c1196a.fsK = new bug();
        c1196a.uri = "/cgi-bin/micromsg-bin/scanstreetview";
        c1196a.fsI = v2helper.EMethodSetSpkEnhance;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        buf buf = (buf) this.ehh.fsG.fsP;
        buf.wVW = bkt;
        buf.Scene = i;
        buf.wVX = f;
        buf.wVY = f2;
        AppMethodBeat.m2505o(78591);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78592);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78592);
        return a;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        AppMethodBeat.m2504i(78593);
        C1206b c1206b;
        if (((buf) ((C7472b) c1929q).fsG.fsP).wVW == null) {
            C4990ab.m7412e("MicroMsg.NetSceneScanStreetView", "req.rImpl.UserPos == null");
            c1206b = C1206b.EFailed;
            AppMethodBeat.m2505o(78593);
            return c1206b;
        }
        c1206b = C1206b.EOk;
        AppMethodBeat.m2505o(78593);
        return c1206b;
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

    /* renamed from: a */
    public final void mo4458a(C1205a c1205a) {
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78594);
        C4990ab.m7410d("MicroMsg.NetSceneScanStreetView", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        } else {
            C4990ab.m7412e("MicroMsg.NetSceneScanStreetView", "callback null");
        }
        C4990ab.m7411d("MicroMsg.NetSceneScanStreetView", "xml is %s", ajC().vOt);
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.m2505o(78594);
    }

    public final int getType() {
        return v2helper.EMethodSetSpkEnhance;
    }

    /* renamed from: tu */
    public static String m83729tu(String str) {
        AppMethodBeat.m2504i(78595);
        Map z = C5049br.m7595z(str, "streetview");
        if (z == null) {
            AppMethodBeat.m2505o(78595);
            return null;
        }
        String str2 = (String) z.get(".streetview.link");
        AppMethodBeat.m2505o(78595);
        return str2;
    }
}
