package com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44166sf;
import com.tencent.p177mm.protocal.protobuf.C44167sg;
import com.tencent.p177mm.protocal.protobuf.bod;
import com.tencent.p177mm.protocal.protobuf.clu;
import com.tencent.p177mm.protocal.protobuf.coa;
import com.tencent.p177mm.protocal.protobuf.cof;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.a */
public final class C35277a extends C1207m implements C1918k {
    public static int svO = 1;
    public static int svP = 2;
    public static int svQ = 3;
    private int Scene;
    private String cMr;
    private C7472b fsB;
    private String mFileName;
    public int mState = -1;
    private C1202f oRe;
    private String svJ;
    private int svK;
    private coa svL;
    private long svM;
    private String svN;
    public cof svR;
    public clu svS;
    public bod svT;
    int svU;

    public C35277a(String str, int i, String str2) {
        AppMethodBeat.m2504i(25572);
        m57945a(str, i, -1, -1, str2, 0, "", "");
        AppMethodBeat.m2505o(25572);
    }

    public C35277a(String str, int i, int i2, long j, String str2) {
        AppMethodBeat.m2504i(25573);
        m57945a(str, i, i2, j, str2, 0, "", "");
        AppMethodBeat.m2505o(25573);
    }

    public C35277a(String str, int i, String str2, int i2, String str3, String str4) {
        AppMethodBeat.m2504i(25574);
        m57945a(str, i, -1, -1, str2, i2, str3, str4);
        AppMethodBeat.m2505o(25574);
    }

    public C35277a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(25575);
        m57945a(str, i, i2, j, str2, i3, str3, str4);
        AppMethodBeat.m2505o(25575);
    }

    /* renamed from: a */
    private void m57945a(String str, int i, int i2, long j, String str2, int i3, String str3, String str4) {
        AppMethodBeat.m2504i(25576);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44166sf();
        c1196a.fsK = new C44167sg();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkvoicetrans";
        c1196a.fsI = 546;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.mFileName = str2;
        this.fsB = c1196a.acD();
        C4990ab.m7417i("MicroMsg.NetSceneCheckVoiceTrans", "voiceId:%s, totalLen:%d, encodeType: %d, svrMsgId: %s", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j));
        if (i2 >= 0) {
            this.svL = C35279d.m57950bm(i2, str2);
        }
        if (j > 0) {
            this.svM = j;
        }
        this.svJ = str;
        this.svK = i;
        this.Scene = i3;
        this.svN = str3;
        this.cMr = str4;
        AppMethodBeat.m2505o(25576);
    }

    public final int getType() {
        return 546;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(25577);
        this.oRe = c1202f;
        C44166sf c44166sf = (C44166sf) this.fsB.fsG.fsP;
        c44166sf.vZx = this.svJ;
        c44166sf.ptw = this.svK;
        c44166sf.vZy = this.svL;
        c44166sf.ptF = this.svM;
        c44166sf.Scene = this.Scene;
        c44166sf.ndG = this.svN;
        c44166sf.ndF = this.cMr;
        int a = mo4457a(c1902e, this.fsB, this);
        AppMethodBeat.m2505o(25577);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25578);
        if (i2 == 0 && i3 == 0) {
            C44167sg c44167sg = (C44167sg) this.fsB.fsH.fsP;
            if (c44167sg == null) {
                AppMethodBeat.m2505o(25578);
                return;
            }
            this.svR = c44167sg.vZz;
            this.mState = c44167sg.jBT;
            this.svS = c44167sg.vZA;
            this.svT = c44167sg.vZB;
            this.svU = c44167sg.vZC;
        } else {
            C4990ab.m7417i("MicroMsg.NetSceneCheckVoiceTrans", "end checkVoiceTrans, & errType:%d, errCode:%d, voiceId: %s ", Integer.valueOf(i2), Integer.valueOf(i3), this.svJ);
        }
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(25578);
    }

    public final boolean cDR() {
        AppMethodBeat.m2504i(25579);
        if (this.svR == null || C5046bo.isNullOrNil(this.svR.xlH)) {
            AppMethodBeat.m2505o(25579);
            return false;
        }
        AppMethodBeat.m2505o(25579);
        return true;
    }
}
