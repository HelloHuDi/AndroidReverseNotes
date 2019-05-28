package com.tencent.p177mm.plugin.emoji.p726f;

import com.facebook.internal.Utility;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.modelstat.C45457b;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p181af.C1191k;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.protocal.protobuf.C15398yd;
import com.tencent.p177mm.protocal.protobuf.C30245yc;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.cky;
import com.tencent.p177mm.protocal.protobuf.ckz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.emoji.f.r */
public final class C38882r extends C1207m implements C1918k {
    private EmojiInfo cuc;
    private final C7472b ehh;
    private C1202f ehi;
    private long fDH;
    private boolean kWx;

    public C38882r(String str, String str2, EmojiInfo emojiInfo, long j) {
        this(str, str2, emojiInfo, j, (byte) 0);
    }

    private C38882r(String str, String str2, EmojiInfo emojiInfo, long j, byte b) {
        int i;
        AppMethodBeat.m2504i(53150);
        this.kWx = true;
        this.fDH = 0;
        boolean z = (str2 == null || str2.length() <= 0 || emojiInfo == null) ? false : true;
        Assert.assertTrue(z);
        this.fDH = j;
        this.cuc = emojiInfo;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new cky();
        c1196a.fsK = new ckz();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendemoji";
        c1196a.fsI = ErrorCode.NEEDDOWNLOAD_FALSE_5;
        c1196a.fsL = 68;
        c1196a.fsM = 1000000068;
        this.ehh = c1196a.acD();
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48566a(C4996ah.getContext(), emojiInfo);
        cky cky = (cky) this.ehh.fsG.fsP;
        C30245yc c30245yc = new C30245yc();
        C4990ab.m7417i("MicroMsg.emoji.NetSceneUploadEmoji", "NetSceneUploadEmoji: md5 %s, size %s", emojiInfo.mo20410Aq(), Integer.valueOf(emojiInfo.field_size));
        c30245yc.wdO = emojiInfo.mo20410Aq();
        c30245yc.wdS = str;
        c30245yc.ndF = str2;
        c30245yc.ptw = emojiInfo.field_size;
        c30245yc.wdQ = emojiInfo.getContent();
        c30245yc.jCt = emojiInfo.field_type;
        c30245yc.vEG = C1831bh.aae();
        c30245yc.wdT = 0;
        if (C1855t.m3896kH(str2)) {
            i = 2;
        } else {
            i = 1;
        }
        if (emojiInfo.field_catalog == EmojiInfo.yaA) {
            c30245yc.wdR = "56,2,".concat(String.valueOf(i));
        } else if (emojiInfo.field_catalog == EmojiInfo.yaz) {
            c30245yc.wdR = "56,1,".concat(String.valueOf(i));
        }
        cky.wdV.add(c30245yc);
        cky.xiJ = cky.wdV.size();
        AppMethodBeat.m2505o(53150);
    }

    public final int getType() {
        return ErrorCode.NEEDDOWNLOAD_FALSE_5;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(53151);
        this.ehi = c1202f;
        C30245yc c30245yc = (C30245yc) ((cky) this.ehh.fsG.fsP).wdV.get(0);
        int a;
        if (this.kWx) {
            C4990ab.m7410d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, firstSend. md5=" + c30245yc.wdO);
            c30245yc.wdP = new SKBuiltinBuffer_t();
            c30245yc.ptx = 0;
            a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(53151);
            return a;
        }
        byte[] bArr;
        int i = this.cuc.field_size - this.cuc.field_start;
        if (i > Utility.DEFAULT_STREAM_BUFFER_SIZE) {
            i = Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
            byte[] l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(this.cuc);
            if (C5046bo.m7540cb(l)) {
                C4990ab.m7420w("MicroMsg.emoji.NetSceneUploadEmoji", "buffer is null.");
                bArr = new byte[0];
            } else {
                bArr = new byte[i];
                C4990ab.m7411d("MicroMsg.emoji.NetSceneUploadEmoji", "total length:%d dataLen:%d", Integer.valueOf(l.length), Integer.valueOf(i));
                System.arraycopy(l, this.cuc.field_start, bArr, 0, i);
            }
        } else {
            bArr = this.cuc.mo48536gZ(this.cuc.field_start, i);
        }
        if (C2933b.m5223aF(bArr) == EmojiInfo.yaq && this.kWx) {
            C4990ab.m7412e("MicroMsg.emoji.NetSceneUploadEmoji", "Bitmap type error. delete emoji file.");
            this.cuc.duQ();
            AppMethodBeat.m2505o(53151);
            return -1;
        } else if (bArr == null || bArr.length <= 0) {
            C4990ab.m7412e("MicroMsg.emoji.NetSceneUploadEmoji", "readFromFile is null.");
            AppMethodBeat.m2505o(53151);
            return -1;
        } else {
            i = bArr.length;
            c30245yc.ptx = this.cuc.field_start;
            c30245yc.wdP = new SKBuiltinBuffer_t().setBuffer(C1332b.m2847bI(bArr));
            if (C17903f.m28103kq(c30245yc.ndF)) {
                c30245yc.vEG = C25754e.m40909rw(((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.fDH).dqJ);
                C4990ab.m7411d("MicroMsg.emoji.NetSceneUploadEmoji", "MsgSource:%s", c30245yc.vEG);
            }
            C4990ab.m7410d("MicroMsg.emoji.NetSceneUploadEmoji", "dispatcher, start:" + this.cuc.field_start + ", total:" + this.cuc.field_size + ", len:" + i);
            a = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(53151);
            return a;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53152);
        if (i2 == 0 && i3 == 0) {
            cky cky = (cky) ((C7472b) c1929q).fsG.fsP;
            ckz ckz = (ckz) ((C7472b) c1929q).fsH.fsP;
            if (cky.wdV.size() != ckz.wdV.size()) {
                C4990ab.m7412e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + ckz.wdV.size() + ", resp size:" + cky.wdV.size());
                this.ehi.onSceneEnd(i2, i3, str, this);
                AppMethodBeat.m2505o(53152);
                return;
            }
            C15398yd c15398yd = (C15398yd) ckz.wdV.get(0);
            if (c15398yd.wdO == null || !c15398yd.wdO.equals(this.cuc.mo20410Aq()) || c15398yd.ptx < this.cuc.field_start) {
                C4990ab.m7412e("MicroMsg.emoji.NetSceneUploadEmoji", "invalid server return value; start=" + c15398yd.ptx + ", size=" + this.cuc.field_size);
                this.ehi.onSceneEnd(4, -2, "", this);
                this.cuc.field_start = 0;
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48556H(this.cuc);
                AppMethodBeat.m2505o(53152);
                return;
            } else if (ckz.BaseResponse.Ret != 0) {
                C4990ab.m7413e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed. resp.BaseResponse.Ret:%d", Integer.valueOf(ckz.BaseResponse.Ret));
                this.ehi.onSceneEnd(4, -2, "", this);
                AppMethodBeat.m2505o(53152);
                return;
            } else {
                if (this.kWx) {
                    this.kWx = false;
                }
                if (c15398yd.ptx >= c15398yd.ptw) {
                    C4990ab.m7410d("MicroMsg.emoji.NetSceneUploadEmoji", "respInfo.getMsgID() " + c15398yd.wdU);
                    C7620bi jf = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15340jf(this.fDH);
                    C4990ab.m7411d("MicroMsg.emoji.NetSceneUploadEmoji", "dkmsgid  set svrmsgid %d -> %d", Long.valueOf(c15398yd.ptF), Integer.valueOf(C1947ae.giA));
                    if (CdnLogic.kMediaTypeFavoriteBigFile == C1947ae.giz && C1947ae.giA != 0) {
                        c15398yd.wdU = C1947ae.giA;
                        C1947ae.giA = 0;
                    }
                    jf.mo14774eI(c15398yd.ptF);
                    ((C6982j) C1720g.m3528K(C6982j.class)).bOr().mo15284a(this.fDH, jf);
                    this.cuc.field_start = 0;
                    this.cuc.field_lastUseTime = System.currentTimeMillis();
                    this.cuc.field_state = EmojiInfo.zZb;
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48556H(this.cuc);
                    if (jf.bAA()) {
                        C45457b.fRa.mo73256a(jf, C1191k.m2615k(jf));
                    } else {
                        C45457b.fRa.mo73265j(jf);
                    }
                    this.ehi.onSceneEnd(i2, i3, "", this);
                    AppMethodBeat.m2505o(53152);
                    return;
                }
                this.cuc.field_start = c15398yd.ptx;
                this.cuc.field_lastUseTime = System.currentTimeMillis();
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48556H(this.cuc);
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                }
                AppMethodBeat.m2505o(53152);
                return;
            }
        }
        C4990ab.m7412e("MicroMsg.emoji.NetSceneUploadEmoji", "onGYNetEnd failed errtype:" + i2 + " errcode:" + i3);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(53152);
    }

    public final int acn() {
        return 256;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }
}
