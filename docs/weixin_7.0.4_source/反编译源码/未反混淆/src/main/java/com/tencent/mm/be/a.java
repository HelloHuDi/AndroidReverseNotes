package com.tencent.mm.be;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.bxd;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;
    String fNi;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        AppMethodBeat.i(78524);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new bxd();
        aVar.fsK = new bxe();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        aVar.fsI = TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
        this.ehh = aVar.acD();
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
        AppMethodBeat.o(78524);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78525);
        ab.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.fNi = ((bxe) ((b) qVar).fsH.fsP).ncM;
        } else {
            ab.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(78525);
    }

    public final int getType() {
        return TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78526);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78526);
        return a;
    }
}
