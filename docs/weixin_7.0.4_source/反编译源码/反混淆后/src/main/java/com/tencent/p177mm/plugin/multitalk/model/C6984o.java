package com.tencent.p177mm.plugin.multitalk.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.bdo;
import com.tencent.p177mm.protocal.protobuf.bdp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.multitalk.model.o */
public final class C6984o extends C1207m implements C1918k {
    byte[] cQr;
    private final C7472b ehh;
    private C1202f ehi;
    int lqx;
    int lqy;

    public C6984o(int i, int i2, byte[] bArr) {
        String str;
        AppMethodBeat.m2504i(54085);
        this.lqx = i;
        this.lqy = i2;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bdo();
        c1196a.fsK = new bdp();
        switch (i2) {
            case 1918:
                str = "/cgi-bin/qcwxmultitalk-bin/createtalkroom";
                break;
            case 1919:
                str = "/cgi-bin/qcwxmultitalk-bin/entertalkroom";
                break;
            case 1927:
                str = "/cgi-bin/qcwxmultitalk-bin/exittalkroom";
                break;
            case 1928:
                str = "/cgi-bin/qcwxmultitalk-bin/cancelcreatetalkroom";
                break;
            case 1929:
                str = "/cgi-bin/qcwxmultitalk-bin/rejectentertalkroom";
                break;
            case 1931:
                str = "/cgi-bin/qcwxmultitalk-bin/addmembers";
                break;
            case 1932:
                str = "/cgi-bin/qcwxmultitalk-bin/hellotalkroom";
                break;
            case 1933:
                str = "/cgi-bin/qcwxmultitalk-bin/miscinfo";
                break;
            case 1935:
                str = "/cgi-bin/qcwxmultitalk-bin/voiceackreq";
                break;
            case 1937:
                str = "/cgi-bin/qcwxmultitalk-bin/oiceredirectreq";
                break;
            case 1938:
                str = "/cgi-bin/qcwxmultitalk-bin/getgroupinfobatch";
                break;
            case 1939:
                str = "/cgi-bin/qcwxmultitalk-bin/memberwhisper";
                break;
            default:
                str = "";
                break;
        }
        C4990ab.m7417i("MicroMsg.MT.NetSceneMultiTalk", "netSceneMultiTalk cmdid %d cgiName %s", Integer.valueOf(i2), str);
        c1196a.uri = str;
        c1196a.fsI = this.lqy;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((bdo) this.ehh.fsG.fsP).vJd = new SKBuiltinBuffer_t().setBuffer(bArr);
        AppMethodBeat.m2505o(54085);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(54086);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(54086);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(54087);
        C4990ab.m7410d("MicroMsg.MT.NetSceneMultiTalk", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " " + this.lqy);
        this.cQr = C1946aa.m4150a(((bdp) ((C7472b) c1929q).fsH.fsP).vJd);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(54087);
    }

    public final int getType() {
        return this.lqy;
    }
}
