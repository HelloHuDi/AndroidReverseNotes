package com.tencent.p177mm.plugin.shake.p509d.p510a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelstat.C18698o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.byt;
import com.tencent.p177mm.protocal.protobuf.byu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.shake.d.a.g */
public final class C34898g extends C13261e {
    private final C7472b ehh;
    private C1202f ehi;

    public C34898g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        AppMethodBeat.m2504i(24616);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byt();
        c1196a.fsK = new byu();
        c1196a.uri = "/cgi-bin/micromsg-bin/shaketv";
        c1196a.fsL = i5;
        c1196a.fsM = i5;
        this.ehh = c1196a.acD();
        byt byt = (byt) this.ehh.fsG.fsP;
        byt.ptz = new SKBuiltinBuffer_t().setBuffer(bArr);
        byt.wXO = i2;
        byt.fJT = z ? 1 : i5;
        byt.wXP = (float) i;
        if (!C32856ab.m53750ch(C4996ah.getContext())) {
            i4 = 2;
        }
        byt.vZF = i4;
        byt.vFE = i3;
        try {
            C9638aw.m17190ZK();
            f = C5046bo.getFloat((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            try {
                C9638aw.m17190ZK();
                float f3 = C5046bo.getFloat((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
                try {
                    C9638aw.m17190ZK();
                    i5 = C5046bo.ank((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
                    f2 = f3;
                } catch (Exception e) {
                    f2 = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        byt.vRq = f;
        byt.wXQ = f2;
        C18698o.m29222a(2009, byt.wXQ, byt.vRq, i5);
        AppMethodBeat.m2505o(24616);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24617);
        byt byt = (byt) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(byt.wXO), Integer.valueOf(byt.ptz.getILen()), Integer.valueOf(byt.fJT), Float.valueOf(byt.wXP), Integer.valueOf(byt.vZF), Integer.valueOf(byt.vFE));
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24617);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24618);
        byt byt = (byt) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(byt.wXO), Integer.valueOf(((byu) this.ehh.fsH.fsP).fJT));
        if (i2 == 0 && i3 == 0 && r1.fJT == 1) {
            this.qtI = true;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24618);
    }

    public final btd ckw() {
        return (byu) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 408;
    }
}
