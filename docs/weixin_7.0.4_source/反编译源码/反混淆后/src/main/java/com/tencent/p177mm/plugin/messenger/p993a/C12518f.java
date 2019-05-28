package com.tencent.p177mm.plugin.messenger.p993a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.p930c.C20118a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buu;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.messenger.a.f */
public final class C12518f extends C1207m implements C1918k {
    public final C7472b ehh;
    private C1202f ehi;
    public final boolean opS;

    public C12518f(String str) {
        this(str, 0);
    }

    public C12518f(String str, int i) {
        this(str, i, (byte) 0);
    }

    private C12518f(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public C12518f(String str, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(111114);
        this.opS = z;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new buu();
        c1196a.fsK = new buv();
        c1196a.uri = "/cgi-bin/micromsg-bin/searchcontact";
        c1196a.fsI = 106;
        c1196a.fsL = 34;
        c1196a.fsM = 1000000034;
        this.ehh = c1196a.acD();
        C4990ab.m7411d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        buu buu = (buu) this.ehh.fsG.fsP;
        buu.wcB = new bts().alV(str);
        buu.wOo = i;
        buu.wWi = i2;
        AppMethodBeat.m2505o(111114);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(111115);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(111115);
        return a;
    }

    public final int getType() {
        return 106;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        C17880h c17880h;
        AppMethodBeat.m2504i(111116);
        buv buv = (buv) this.ehh.fsH.fsP;
        if (buv != null && buv.wod > 0) {
            Iterator it = buv.woe.iterator();
            while (it.hasNext()) {
                but but = (but) it.next();
                C4990ab.m7411d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", but.wcB);
                C17880h c17880h2 = new C17880h();
                c17880h2.username = C1946aa.m4148a(but.wcB);
                c17880h2.frW = but.vXm;
                c17880h2.frV = but.vXn;
                c17880h2.bJt = -1;
                C4990ab.m7411d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", c17880h2.getUsername(), c17880h2.ack(), c17880h2.acl());
                c17880h2.dtR = 3;
                c17880h2.mo33385cB(true);
                C17884o.act().mo33391b(c17880h2);
            }
        } else if (!(buv == null || C5046bo.isNullOrNil(C1946aa.m4148a(buv.wcB)))) {
            String a = C1946aa.m4148a(buv.wcB);
            c17880h = new C17880h();
            c17880h.username = a;
            c17880h.frW = buv.vXm;
            c17880h.frV = buv.vXn;
            c17880h.bJt = -1;
            C4990ab.m7411d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
            c17880h.dtR = 3;
            c17880h.mo33385cB(true);
            C17884o.act().mo33391b(c17880h);
        }
        if (buv != null) {
            Iterator it2 = buv.wWn.iterator();
            while (it2.hasNext()) {
                bvk bvk = (bvk) it2.next();
                c17880h = new C17880h();
                c17880h.username = bvk.jBB;
                c17880h.frW = bvk.vXm;
                c17880h.frV = bvk.vXn;
                c17880h.bJt = -1;
                C4990ab.m7411d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", c17880h.getUsername(), c17880h.ack(), c17880h.acl());
                c17880h.dtR = 3;
                c17880h.mo33385cB(true);
                C17884o.act().mo33391b(c17880h);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(111116);
    }

    public final buv bOj() {
        AppMethodBeat.m2504i(111117);
        buv buv = (buv) this.ehh.fsH.fsP;
        if (buv != null) {
            Iterator it = buv.woe.iterator();
            while (it.hasNext()) {
                but but = (but) it.next();
                C20118a.ask().mo35364Yn().mo56747ia(but.wcB.wVI, but.wlF);
            }
        }
        AppMethodBeat.m2505o(111117);
        return buv;
    }
}
