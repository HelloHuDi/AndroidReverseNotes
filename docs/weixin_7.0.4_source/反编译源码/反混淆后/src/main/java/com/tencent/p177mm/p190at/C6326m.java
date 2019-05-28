package com.tencent.p177mm.p190at;

import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.clk;
import com.tencent.p177mm.protocal.protobuf.cll;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;

/* renamed from: com.tencent.mm.at.m */
public final class C6326m extends C1207m implements C1918k {
    private int eFn;
    private final C7472b ehh;
    private C1202f ehi;
    private C25822e fFJ;
    private C6327a fFK;

    /* renamed from: com.tencent.mm.at.m$a */
    public interface C6327a {
        /* renamed from: a */
        void mo4586a(long j, int i, int i2, int i3);
    }

    public C6326m(int i, clk clk, C25822e c25822e, C9545d c9545d, C6327a c6327a) {
        int i2;
        AppMethodBeat.m2504i(78354);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new clk();
        c1196a.fsK = new cll();
        c1196a.uri = "/cgi-bin/micromsg-bin/uploadmsgimg";
        this.ehh = c1196a.acD();
        this.fFK = c6327a;
        this.eFn = i;
        this.fFJ = c25822e;
        clk clk2 = (clk) this.ehh.fsG.fsP;
        clk2.vEB = clk.vEB;
        clk2.vEC = clk.vEC;
        clk2.xja = clk.xja;
        clk2.nao = clk.nao;
        clk2.vEG = clk.vEG;
        clk2.vRz = clk.vRz;
        Options amj = C5056d.amj(C32291o.ahl().mo73118q(c25822e.fDB, "", ""));
        clk2.xji = amj != null ? amj.outWidth : 0;
        if (amj != null) {
            i2 = amj.outHeight;
        } else {
            i2 = 0;
        }
        clk2.xjh = i2;
        clk2.xjf = c9545d.field_fileId;
        clk2.xjg = c9545d.field_thumbimgLength;
        clk2.ptw = c9545d.field_thumbimgLength;
        clk2.ptx = 0;
        clk2.pty = c9545d.field_thumbimgLength;
        clk2.ptz = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        clk2.fKh = clk.fKh;
        clk2.vCs = clk.vCs;
        clk2.vCu = clk.vCu;
        clk2.vCt = clk.vCt;
        clk2.vRx = 1;
        if (c9545d.mo20809Jm()) {
            C4990ab.m7417i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn isUploadBySafeCDNWithMD5 field_upload_by_safecdn[%b], field_UploadHitCacheType[%d], crc[%d], aeskey[%s]", Boolean.valueOf(c9545d.field_upload_by_safecdn), Integer.valueOf(c9545d.field_UploadHitCacheType), Integer.valueOf(c9545d.field_filecrc), c9545d.field_aesKey);
            clk2.wWT = 1;
            clk2.vRw = "";
            clk2.wxW = "";
        } else {
            clk2.vRw = c9545d.field_aesKey;
            clk2.wxW = c9545d.field_aesKey;
        }
        clk2.wqw = clk.wqw;
        if (clk.wqw == 1) {
            clk2.xjd = c9545d.field_fileLength;
            clk2.xje = c9545d.field_midimgLength;
            clk2.xjb = c9545d.field_fileId;
            clk2.xjc = c9545d.field_fileId;
        } else {
            clk2.xjd = 0;
            clk2.xje = c9545d.field_fileLength;
            clk2.xjb = "";
            clk2.xjc = c9545d.field_fileId;
        }
        clk2.vRy = c9545d.field_filecrc;
        clk2.Md5 = c9545d.field_filemd5;
        C4990ab.m7417i("MicroMsg.NetSceneUploadMsgImgForCdn", "summersafecdn NetSceneUploadMsgImgForCdn MsgForwardType[%d], hitmd5[%d], key[%s], crc[%d]", Integer.valueOf(clk2.vRz), Integer.valueOf(clk2.wWT), C5046bo.anv(clk2.vRw), Integer.valueOf(clk2.vRy));
        AppMethodBeat.m2505o(78354);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(78355);
        C4990ab.m7417i("MicroMsg.NetSceneUploadMsgImgForCdn", "cdntra req[%s]", ((clk) this.ehh.fsG.fsP).toString());
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(78355);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(78356);
        C4990ab.m7416i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd errtype:" + i2 + " errcode:" + i3);
        cll cll = (cll) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneUploadMsgImgForCdn", "onGYNetEnd createtime:%d msgId:%d ", Integer.valueOf(cll.pcX), Long.valueOf(cll.ptF));
        if (this.fFK != null) {
            this.fFK.mo4586a(cll.ptF, cll.pcX, i2, i3);
        }
        this.ehi.onSceneEnd(0, 0, "", this);
        AppMethodBeat.m2505o(78356);
    }

    public final int getType() {
        return 110;
    }
}
