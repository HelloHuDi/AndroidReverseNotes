package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clu;
import com.tencent.mm.protocal.protobuf.clv;
import com.tencent.mm.protocal.protobuf.clw;
import com.tencent.mm.protocal.protobuf.coa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public final class c extends m implements k {
    private int Scene;
    private final String TAG = "MicroMsg.NetSceneUploadVoiceForTrans";
    private String cMr;
    private b fsB;
    private String mFileName;
    private f oRe;
    private String svJ;
    private coa svL;
    private String svN;
    public clu svS;

    public c(c cVar) {
        AppMethodBeat.i(25584);
        this.svJ = cVar.svJ;
        this.svL = cVar.svL;
        this.svS = cVar.svS;
        this.mFileName = cVar.mFileName;
        this.Scene = cVar.Scene;
        this.svN = cVar.svN;
        this.cMr = cVar.cMr;
        ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans constructor scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(cVar.Scene), cVar.svN, cVar.cMr);
        cDS();
        AppMethodBeat.o(25584);
    }

    public c(String str, clu clu, int i, String str2) {
        boolean z;
        AppMethodBeat.i(25585);
        if (str2 != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        this.svJ = str;
        this.svS = clu;
        this.svL = d.bm(i, str2);
        this.mFileName = str2;
        cDS();
        AppMethodBeat.o(25585);
    }

    public c(String str, clu clu, int i, String str2, int i2, String str3, String str4) {
        AppMethodBeat.i(25586);
        Assert.assertTrue(str2 != null);
        ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "alvinluo voiceTrans scene: %d, fromUser: %s, toUser: %s", Integer.valueOf(i2), str3, str4);
        this.svJ = str;
        this.svS = clu;
        this.svL = d.bm(i, str2);
        this.mFileName = str2;
        this.Scene = i2;
        this.svN = str3;
        this.cMr = str4;
        cDS();
        AppMethodBeat.o(25586);
    }

    public final int getType() {
        return 547;
    }

    public final int a(e eVar, f fVar) {
        Object obj;
        AppMethodBeat.i(25587);
        this.oRe = fVar;
        if (bo.isNullOrNil(this.mFileName) || bo.isNullOrNil(this.svJ) || this.svS == null || this.svL == null) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            ab.e("MicroMsg.NetSceneUploadVoiceForTrans", "doScene: Value not Valid, so, do nothing.");
            AppMethodBeat.o(25587);
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
        com.tencent.mm.modelvoice.b uN = q.uN(str);
        if (uN != null) {
            sKBuiltinBuffer_t = aa.ad(uN.cF(i, i2).buf);
        }
        clv.ptz = sKBuiltinBuffer_t;
        clv.Scene = this.Scene;
        clv.ndG = this.svN;
        clv.ndF = this.cMr;
        int a = a(eVar, this.fsB, this);
        AppMethodBeat.o(25587);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(25588);
        if (i2 == 0 && i3 == 0) {
            this.svS = ((clw) this.fsB.fsH.fsP).vZA;
        } else {
            ab.d("MicroMsg.NetSceneUploadVoiceForTrans", "error upload: errType:%d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
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
            ab.i(str2, str3, objArr);
            AppMethodBeat.o(25588);
            return;
        }
        AppMethodBeat.o(25588);
    }

    private void cDS() {
        AppMethodBeat.i(25589);
        a aVar = new a();
        aVar.fsJ = new clv();
        aVar.fsK = new clw();
        aVar.uri = "/cgi-bin/micromsg-bin/uploadvoicefortrans";
        aVar.fsI = 547;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fsB = aVar.acD();
        AppMethodBeat.o(25589);
    }

    public final boolean cDT() {
        if (this.svS == null || this.svS.pty <= 0) {
            return true;
        }
        return false;
    }
}
