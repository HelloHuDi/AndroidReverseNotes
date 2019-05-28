package com.tencent.mm.at;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.i.d;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.clk;
import com.tencent.mm.protocal.protobuf.cll;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class m extends com.tencent.mm.ai.m implements k {
    private int eFn;
    private final b ehh;
    private f ehi;
    private e fFJ;
    private a fFK;

    public interface a {
        void a(long j, int i, int i2, int i3);
    }

    public m(int i, clk clk, e eVar, d dVar, a aVar) {
        int i2;
        AppMethodBeat.i(78354);
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new clk();
        aVar2.fsK = new cll();
        aVar2.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        this.ehh = aVar2.acD();
        this.fFK = aVar;
        this.eFn = i;
        this.fFJ = eVar;
        clk clk2 = (clk) this.ehh.fsG.fsP;
        clk2.vEB = clk.vEB;
        clk2.vEC = clk.vEC;
        clk2.xja = clk.xja;
        clk2.nao = clk.nao;
        clk2.vEG = clk.vEG;
        clk2.vRz = clk.vRz;
        Options amj = com.tencent.mm.sdk.platformtools.d.amj(o.ahl().q(eVar.fDB, "", ""));
        clk2.xji = amj != null ? amj.outWidth : 0;
        if (amj != null) {
            i2 = amj.outHeight;
        } else {
            i2 = 0;
        }
        clk2.xjh = i2;
        clk2.xjf = dVar.field_fileId;
        clk2.xjg = dVar.field_thumbimgLength;
        clk2.ptw = dVar.field_thumbimgLength;
        clk2.ptx = 0;
        clk2.pty = dVar.field_thumbimgLength;
        clk2.ptz = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        clk2.fKh = clk.fKh;
        clk2.vCs = clk.vCs;
        clk2.vCu = clk.vCu;
        clk2.vCt = clk.vCt;
        clk2.vRx = 1;
        if (dVar.Jm()) {
            ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(dVar.field_upload_by_safecdn), Integer.valueOf(dVar.field_UploadHitCacheType), Integer.valueOf(dVar.field_filecrc), dVar.field_aesKey);
            clk2.wWT = 1;
            clk2.vRw = "";
            clk2.wxW = "";
        } else {
            clk2.vRw = dVar.field_aesKey;
            clk2.wxW = dVar.field_aesKey;
        }
        clk2.wqw = clk.wqw;
        if (clk.wqw == 1) {
            clk2.xjd = dVar.field_fileLength;
            clk2.xje = dVar.field_midimgLength;
            clk2.xjb = dVar.field_fileId;
            clk2.xjc = dVar.field_fileId;
        } else {
            clk2.xjd = 0;
            clk2.xje = dVar.field_fileLength;
            clk2.xjb = "";
            clk2.xjc = dVar.field_fileId;
        }
        clk2.vRy = dVar.field_filecrc;
        clk2.Md5 = dVar.field_filemd5;
        ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(clk2.vRz), Integer.valueOf(clk2.wWT), bo.anv(clk2.vRw), Integer.valueOf(clk2.vRy));
        AppMethodBeat.o(78354);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(78355);
        ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((clk) this.ehh.fsG.fsP).toString());
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(78355);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(78356);
        ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        cll cll = (cll) ((b) qVar).fsH.fsP;
        ab.i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(cll.pcX), Long.valueOf(cll.ptF));
        if (this.fFK != null) {
            this.fFK.a(cll.ptF, cll.pcX, i2, i3);
        }
        this.ehi.onSceneEnd(0, 0, "", this);
        AppMethodBeat.o(78356);
    }

    public final int getType() {
        return 110;
    }
}
