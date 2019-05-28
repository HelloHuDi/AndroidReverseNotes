package com.tencent.mm.plugin.emoji.f;

import com.facebook.internal.Utility;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.t;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.cky;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.yc;
import com.tencent.mm.protocal.protobuf.yd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import junit.framework.Assert;

public final class r extends m implements k {
    private EmojiInfo cuc;
    private final b ehh;
    private f ehi;
    private long fDH;
    private boolean kWx;

    public r(String str, String str2, EmojiInfo emojiInfo, long j) {
        this(str, str2, emojiInfo, j, (byte) 0);
    }

    private r(String str, String str2, EmojiInfo emojiInfo, long j, byte b) {
        int i;
        AppMethodBeat.i(53150);
        this.kWx = true;
        this.fDH = 0;
        boolean z = (str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true;
        Assert.assertTrue(z);
        this.fDH = j;
        this.cuc = emojiInfo;
        a aVar = new a();
        aVar.fsJ = new cky();
        aVar.fsK = new ckz();
        aVar.uri = "/cgi-bin/micromsg-bin/sendemoji";
        aVar.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_5;
        aVar.fsL = 68;
        aVar.fsM = 1000000068;
        this.ehh = aVar.acD();
        ((d) g.M(d.class)).getEmojiStorageMgr().xYn.a(ah.getContext(), emojiInfo);
        cky cky = (cky) this.ehh.fsG.fsP;
        yc ycVar = new yc();
        ab.i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", emojiInfo.Aq(), Integer.valueOf(emojiInfo.field_size));
        ycVar.wdO = emojiInfo.Aq();
        ycVar.wdS = str;
        ycVar.ndF = str2;
        ycVar.ptw = emojiInfo.field_size;
        ycVar.wdQ = emojiInfo.getContent();
        ycVar.jCt = emojiInfo.field_type;
        ycVar.vEG = bh.aae();
        ycVar.wdT = 0;
        if (t.kH(str2)) {
            i = 2;
        } else {
            i = 1;
        }
        if (emojiInfo.field_catalog == EmojiInfo.yaA) {
            ycVar.wdR = "56,2,".concat(String.valueOf(i));
        } else if (emojiInfo.field_catalog == EmojiInfo.yaz) {
            ycVar.wdR = "56,1,".concat(String.valueOf(i));
        }
        cky.wdV.add(ycVar);
        cky.xiJ = cky.wdV.size();
        AppMethodBeat.o(53150);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_5;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(53151);
        this.ehi = fVar;
        yc ycVar = (yc) ((cky) this.ehh.fsG.fsP).wdV.get(0);
        int a;
        if (this.kWx) {
            ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + ycVar.wdO);
            ycVar.wdP = new SKBuiltinBuffer_t();
            ycVar.ptx = 0;
            a = a(eVar, this.ehh, this);
            AppMethodBeat.o(53151);
            return a;
        }
        byte[] bArr;
        int i = this.cuc.field_size - this.cuc.field_start;
        if (i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            i = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
            byte[] l = ((d) g.M(d.class)).getEmojiMgr().l(this.cuc);
            if (bo.cb(l)) {
                ab.w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                bArr = new byte[i];
                ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", Integer.valueOf(l.length), Integer.valueOf(i));
                System.arraycopy(l, this.cuc.field_start, bArr, 0, i);
            }
        } else {
            bArr = this.cuc.gZ(this.cuc.field_start, i);
        }
        if (com.tencent.mm.plugin.emoji.h.b.aF(bArr) == EmojiInfo.yaq && this.kWx) {
            ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.cuc.duQ();
            AppMethodBeat.o(53151);
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            AppMethodBeat.o(53151);
            return -1;
        } else {
            i = bArr.length;
            ycVar.ptx = this.cuc.field_start;
            ycVar.wdP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.bt.b.bI(bArr));
            if (com.tencent.mm.aj.f.kq(ycVar.ndF)) {
                ycVar.vEG = com.tencent.mm.aj.a.e.rw(((j) g.K(j.class)).bOr().jf(this.fDH).dqJ);
                ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", ycVar.vEG);
            }
            ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.cuc.field_start + ", total:" + this.cuc.field_size + ", len:" + i);
            a = a(eVar, this.ehh, this);
            AppMethodBeat.o(53151);
            return a;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53152);
        if (i2 == 0 && i3 == 0) {
            cky cky = (cky) ((b) qVar).fsG.fsP;
            ckz ckz = (ckz) ((b) qVar).fsH.fsP;
            if (cky.wdV.size() != ckz.wdV.size()) {
                ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + ckz.wdV.size() + ", resp size:" + cky.wdV.size());
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.o(53152);
                return;
            }
            yd ydVar = (yd) ckz.wdV.get(0);
            if (ydVar.wdO == null || !ydVar.wdO.equals(this.cuc.Aq()) || ydVar.ptx < this.cuc.field_start) {
                ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + ydVar.ptx + ", size=" + this.cuc.field_size);
                this.ehi.onSceneEnd(4, -2, "", this);
                this.cuc.field_start = 0;
                ((d) g.M(d.class)).getEmojiStorageMgr().xYn.H(this.cuc);
                AppMethodBeat.o(53152);
                return;
            } else if (ckz.BaseResponse.Ret != 0) {
                ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", Integer.valueOf(ckz.BaseResponse.Ret));
                this.ehi.onSceneEnd(4, -2, "", this);
                AppMethodBeat.o(53152);
                return;
            } else {
                if (this.kWx) {
                    this.kWx = false;
                }
                if (ydVar.ptx >= ydVar.ptw) {
                    ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + ydVar.wdU);
                    bi jf = ((j) g.K(j.class)).bOr().jf(this.fDH);
                    ab.d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(ydVar.ptF), Integer.valueOf(ae.giA));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == ae.giz && ae.giA != 0) {
                        ydVar.wdU = ae.giA;
                        ae.giA = 0;
                    }
                    jf.eI(ydVar.ptF);
                    ((j) g.K(j.class)).bOr().a(this.fDH, jf);
                    this.cuc.field_start = 0;
                    this.cuc.field_lastUseTime = System.currentTimeMillis();
                    this.cuc.field_state = EmojiInfo.zZb;
                    ((d) g.M(d.class)).getEmojiStorageMgr().xYn.H(this.cuc);
                    if (jf.bAA()) {
                        com.tencent.mm.modelstat.b.fRa.a(jf, com.tencent.mm.af.k.k(jf));
                    } else {
                        com.tencent.mm.modelstat.b.fRa.j(jf);
                    }
                    this.ehi.onSceneEnd(i2, i3, "", this);
                    AppMethodBeat.o(53152);
                    return;
                }
                this.cuc.field_start = ydVar.ptx;
                this.cuc.field_lastUseTime = System.currentTimeMillis();
                ((d) g.M(d.class)).getEmojiStorageMgr().xYn.H(this.cuc);
                if (a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.o(53152);
                return;
            }
        }
        ab.e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(53152);
    }

    public final int acn() {
        return 256;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }
}
