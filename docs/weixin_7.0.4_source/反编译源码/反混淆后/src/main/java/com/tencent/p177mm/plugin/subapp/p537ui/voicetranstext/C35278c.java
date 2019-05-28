package com.tencent.p177mm.plugin.subapp.p537ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelvoice.C26497b;
import com.tencent.p177mm.modelvoice.C32850q;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clu;
import com.tencent.p177mm.protocal.protobuf.clv;
import com.tencent.p177mm.protocal.protobuf.clw;
import com.tencent.p177mm.protocal.protobuf.coa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.subapp.ui.voicetranstext.c */
public final class C35278c extends C1207m implements C1918k {
    private int Scene;
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String cMr;
    private C7472b fsB;
    private String mFileName;
    private C1202f oRe;
    private String svJ;
    private coa svL;
    private String svN;
    public clu svS;

    public C35278c(C35278c c35278c) {
        AppMethodBeat.m2504i(25584);
        this.svJ = c35278c.svJ;
        this.svL = c35278c.svL;
        this.svS = c35278c.svS;
        this.mFileName = c35278c.mFileName;
        this.Scene = c35278c.Scene;
        this.svN = c35278c.svN;
        this.cMr = c35278c.cMr;
        C4990ab.m7411d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(c35278c.Scene), c35278c.svN, c35278c.cMr);
        cDS();
        AppMethodBeat.m2505o(25584);
    }

    public C35278c(String str, clu clu, int i, String str2) {
        boolean z;
        AppMethodBeat.m2504i(25585);
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.svJ = str;
        this.svS = clu;
        this.svL = C35279d.m57950bm(i, str2);
        this.mFileName = str2;
        cDS();
        AppMethodBeat.m2505o(25585);
    }

    public C35278c(String str, clu clu, int i, String str2, int i2, String str3, String str4) {
        AppMethodBeat.m2504i(25586);
        Assert.assertTrue(str2 != null);
        C4990ab.m7411d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(i2), str3, str4);
        this.svJ = str;
        this.svS = clu;
        this.svL = C35279d.m57950bm(i, str2);
        this.mFileName = str2;
        this.Scene = i2;
        this.svN = str3;
        this.cMr = str4;
        cDS();
        AppMethodBeat.m2505o(25586);
    }

    public final int getType() {
        return 547;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        Object obj;
        AppMethodBeat.m2504i(25587);
        this.oRe = c1202f;
        if (C5046bo.isNullOrNil(this.mFileName) || C5046bo.isNullOrNil(this.svJ) || this.svS == null || this.svL == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            C4990ab.m7412e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            AppMethodBeat.m2505o(25587);
            return -1;
        }
        clv clv = (clv) this.fsB.fsG.fsP;
        clv.vZx = this.svJ;
        clv.vZy = this.svL;
        clv.vZA = this.svS;
        String str = this.mFileName;
        int i = this.svS.ptx;
        int i2 = this.svS.pty;
        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
        C26497b uN = C32850q.m53727uN(str);
        if (uN != null) {
            sKBuiltinBuffer_t = C1946aa.m4152ad(uN.mo5461cF(i, i2).buf);
        }
        clv.ptz = sKBuiltinBuffer_t;
        clv.Scene = this.Scene;
        clv.ndG = this.svN;
        clv.ndF = this.cMr;
        int a = mo4457a(c1902e, this.fsB, this);
        AppMethodBeat.m2505o(25587);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(25588);
        if (i2 == 0 && i3 == 0) {
            this.svS = ((clw) this.fsB.fsH.fsP).vZA;
        } else {
            C4990ab.m7411d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        }
        this.oRe.onSceneEnd(i2, i3, str, this);
        if (cDT()) {
            boolean z;
            String str2 = "MicroMsg.NetSceneUploadVoiceForTrans";
            String str3 = "succeeed finish: %B";
            Object[] objArr = new Object[1];
            if (this.svS != null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            C4990ab.m7417i(str2, str3, objArr);
            AppMethodBeat.m2505o(25588);
            return;
        }
        AppMethodBeat.m2505o(25588);
    }

    private void cDS() {
        AppMethodBeat.m2504i(25589);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clv();
        c1196a.fsK = new clw();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        c1196a.fsI = 547;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fsB = c1196a.acD();
        AppMethodBeat.m2505o(25589);
    }

    public final boolean cDT() {
        if (this.svS == null || this.svS.pty <= 0) {
            return true;
        }
        return false;
    }
}
