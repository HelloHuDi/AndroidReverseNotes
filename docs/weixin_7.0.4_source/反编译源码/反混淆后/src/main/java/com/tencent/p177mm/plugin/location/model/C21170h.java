package com.tencent.p177mm.plugin.location.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.location.p446ui.impl.C43245f;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.als;
import com.tencent.p177mm.protocal.protobuf.alt;
import com.tencent.p177mm.protocal.protobuf.bhu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.location.model.h */
public final class C21170h extends C1207m implements C1918k {
    public String aIm;
    public int czE;
    public boolean eTf = false;
    public final C7472b ehh;
    private C1202f ehi;
    public int errCode;
    public int errType;
    private Runnable fPK;
    public String hlm;
    public List<C43245f> list = new ArrayList();
    public byte[] nJH;
    public byte[] nJI = null;
    public String nJJ = "";
    public int nJK;

    public C21170h(byte[] bArr, double d, double d2, int i, int i2, double d3, double d4, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(113315);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new als();
        c1196a.fsK = new alt();
        c1196a.fsK = new alt();
        c1196a.uri = "/cgi-bin/micromsg-bin/getpoilist";
        c1196a.fsI = 457;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        als als = (als) this.ehh.fsG.fsP;
        als.wpP = bArr == null ? new SKBuiltinBuffer_t() : new SKBuiltinBuffer_t().setBuffer(bArr);
        als.wkD = str2;
        als.vNI = d;
        als.vNH = d2;
        als.Scene = i;
        als.OpCode = i2;
        als.wqT = d4;
        als.wqS = d3;
        als.wpR = z ? 1 : 0;
        this.czE = als.OpCode;
        this.nJJ = str;
        this.nJH = bArr;
        C4990ab.m7417i("MicroMsg.NetSceneGetPoiList", "lat %f lng %f scene %d opcode %d oriLat %f oriLng %f isAutuQuery %s".concat(String.valueOf(bArr)), Double.valueOf(d), Double.valueOf(d2), Integer.valueOf(i), Integer.valueOf(i2), Double.valueOf(d4), Double.valueOf(d3), Boolean.valueOf(z));
        AppMethodBeat.m2505o(113315);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(113316);
        C4990ab.m7410d("MicroMsg.NetSceneGetPoiList", "scene done");
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(113316);
        return a;
    }

    public final int getType() {
        return 457;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(113317);
        C4990ab.m7410d("MicroMsg.NetSceneGetPoiList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + "errMsg:" + str);
        this.errType = i2;
        this.errCode = i3;
        this.aIm = str;
        alt alt = (alt) this.ehh.fsH.fsP;
        this.list.clear();
        C4990ab.m7410d("MicroMsg.NetSceneGetPoiList", "url " + alt.wpY + " " + alt.wdK + " " + alt.Url + " " + alt.vQg);
        C4990ab.m7411d("MicroMsg.NetSceneGetPoiList", "autoInterval: %d", Integer.valueOf(alt.wpZ));
        this.hlm = alt.vQg;
        this.nJK = alt.wpZ;
        if (alt.wqV != null) {
            C4990ab.m7411d("MicroMsg.NetSceneGetPoiList", "poi result %d ", Integer.valueOf(alt.wqV.size()));
            if (alt.wqV.size() > 0) {
                C4990ab.m7411d("MicroMsg.NetSceneGetPoiList", "addr %s, province %s, street %s, city %s", ((bhu) alt.wqV.get(0)).wKW, ((bhu) alt.wqV.get(0)).guO, ((bhu) alt.wqV.get(0)).wcm, ((bhu) alt.wqV.get(0)).guP);
            }
            Iterator it = alt.wqV.iterator();
            while (it.hasNext()) {
                this.list.add(new C43245f((bhu) it.next(), this.hlm));
            }
        }
        if (alt.wpP != null) {
            this.nJI = C1946aa.m4150a(alt.wpP);
        }
        this.eTf = alt.wqW == 1;
        this.ehi.onSceneEnd(i2, i3, str, this);
        if (this.fPK != null) {
            this.fPK.run();
        }
        AppMethodBeat.m2505o(113317);
    }

    public final boolean isFirst() {
        return this.nJH == null;
    }
}
