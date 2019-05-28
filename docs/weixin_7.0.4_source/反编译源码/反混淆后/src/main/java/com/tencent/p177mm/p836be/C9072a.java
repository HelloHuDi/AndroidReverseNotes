package com.tencent.p177mm.p836be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.axx;
import com.tencent.p177mm.protocal.protobuf.bxd;
import com.tencent.p177mm.protocal.protobuf.bxe;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

/* renamed from: com.tencent.mm.be.a */
public final class C9072a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    String fNi;

    public C9072a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        AppMethodBeat.m2504i(78524);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bxd();
        c1196a.fsK = new bxe();
        c1196a.uri = "/cgi-bin/micromsg-bin/sensewhere";
        c1196a.fsI = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
        this.ehh = c1196a.acD();
        axx axx = new axx();
        axx.wfI = str2;
        axx.wfJ = i2;
        axx.vRq = f2;
        axx.vRp = f;
        axx.wfH = str;
        axx.wfG = i;
        bxd bxd = (bxd) this.ehh.fsG.fsP;
        bxd.wcn = axx;
        bxd.wXm = i3;
        bxd.Scene = i4;
        bxd.ncM = str3;
        AppMethodBeat.m2505o(78524);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78525);
        C4990ab.m7417i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.fNi = ((bxe) ((C7472b) c1929q).fsH.fsP).ncM;
        } else {
            C4990ab.m7420w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(78525);
    }

    public final int getType() {
        return TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78526);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78526);
        return a;
    }
}
