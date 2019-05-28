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
import com.tencent.p177mm.p198aw.C25847d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.protocal.protobuf.byp;
import com.tencent.p177mm.protocal.protobuf.byq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;

/* renamed from: com.tencent.mm.plugin.shake.d.a.f */
public final class C34897f extends C13261e {
    private final C7472b ehh;
    private C1202f ehi;

    public C34897f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        int ank;
        super(j);
        AppMethodBeat.m2504i(24613);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new byp();
        c1196a.fsK = new byq();
        c1196a.uri = "/cgi-bin/micromsg-bin/shakemusic";
        c1196a.fsL = ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING;
        c1196a.fsM = 1000000177;
        this.ehh = c1196a.acD();
        byp byp = (byp) this.ehh.fsG.fsP;
        byp.ptz = new SKBuiltinBuffer_t().setBuffer(bArr);
        byp.wXO = i2;
        byp.fJT = z ? 1 : 0;
        byp.wXP = (float) i;
        byp.vZF = C32856ab.m53750ch(C4996ah.getContext()) ? 1 : 2;
        byp.vFE = i3;
        float f = 0.0f;
        float f2 = 0.0f;
        try {
            C9638aw.m17190ZK();
            f = C5046bo.getFloat((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_LATITUDE_STRING, null), 0.0f);
            C9638aw.m17190ZK();
            f2 = C5046bo.getFloat((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_LONGTITUDE_STRING, null), 0.0f);
            C9638aw.m17190ZK();
            ank = C5046bo.ank((String) C18628c.m29072Ry().get(C5127a.USERINFO_SHAKE_TV_ACCURACY_STRING, null));
        } catch (Exception e) {
            ank = 0;
        }
        byp.vRq = f;
        byp.wXQ = f2;
        byp.wrA = C25847d.aio() ? 0 : 1;
        byp.wrB = C25847d.ain() ? 1 : 0;
        C18698o.m29222a(2014, byp.wXQ, byp.vRq, ank);
        AppMethodBeat.m2505o(24613);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(24614);
        byp byp = (byp) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", Integer.valueOf(byp.wXO), Integer.valueOf(byp.ptz.getILen()), Integer.valueOf(byp.fJT), Float.valueOf(byp.wXP), Integer.valueOf(byp.vZF), Integer.valueOf(byp.vFE));
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(24614);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(24615);
        byp byp = (byp) this.ehh.fsG.fsP;
        C4990ab.m7411d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(byp.wXO), Integer.valueOf(((byq) this.ehh.fsH.fsP).fJT));
        if (i2 == 0 && i3 == 0 && r1.fJT == 1) {
            this.qtI = true;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(24615);
    }

    public final btd ckw() {
        return (byq) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 367;
    }
}
