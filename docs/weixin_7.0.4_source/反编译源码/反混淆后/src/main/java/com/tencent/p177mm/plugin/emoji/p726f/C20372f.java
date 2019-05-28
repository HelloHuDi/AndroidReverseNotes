package com.tencent.p177mm.plugin.emoji.p726f;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C15399ye;
import com.tencent.p177mm.protocal.protobuf.C15400yf;
import com.tencent.p177mm.protocal.protobuf.ckw;
import com.tencent.p177mm.protocal.protobuf.ckx;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;

/* renamed from: com.tencent.mm.plugin.emoji.f.f */
public final class C20372f extends C1207m implements C1918k {
    private EmojiInfo cuc;
    private final C7472b ehh;
    private C1202f ehi;
    private long eyR = System.currentTimeMillis();
    private boolean kWx = true;
    private int kWy = 256;

    public C20372f(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(53102);
        C4990ab.m7420w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.eyR);
        this.cuc = emojiInfo;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15399ye();
        c1196a.fsK = new C15400yf();
        c1196a.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        c1196a.fsI = 703;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C15399ye c15399ye = (C15399ye) this.ehh.fsG.fsP;
        ckw ckw = new ckw();
        if (this.cuc != null) {
            C7060h.pYm.mo15419k(164, 13, 1);
            C4990ab.m7417i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", this.cuc.mo20410Aq());
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48566a(C4996ah.getContext(), this.cuc);
            ckw.wdO = this.cuc.mo20410Aq();
            ckw.ptw = this.cuc.field_size;
            c15399ye.wdV.add(ckw);
            this.kWy = (this.cuc.field_size / Utility.DEFAULT_STREAM_BUFFER_SIZE) * 2;
        }
        AppMethodBeat.m2505o(53102);
    }

    public final int getType() {
        return 703;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        int i = -1;
        AppMethodBeat.m2504i(53103);
        this.ehi = c1202f;
        ckw ckw = (ckw) ((C15399ye) this.ehh.fsG.fsP).wdV.get(0);
        int i2;
        int i3;
        byte[] l;
        byte[] bArr;
        if (this.kWx) {
            C4990ab.m7410d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + ckw.wdO);
            ckw.ptx = 0;
            i2 = this.cuc.field_size + 0;
            i3 = i2 > Utility.DEFAULT_STREAM_BUFFER_SIZE ? Utility.DEFAULT_STREAM_BUFFER_SIZE : i2;
            if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(this.cuc);
                if (C5046bo.m7540cb(l)) {
                    C4990ab.m7420w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i3];
                    C4990ab.m7411d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(l.length), Integer.valueOf(i3));
                    System.arraycopy(l, 0, bArr, 0, i3);
                }
            } else {
                bArr = this.cuc.mo48536gZ(0, i3);
            }
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.m2505o(53103);
                return -1;
            }
            int i4;
            ckw.ptx = 0;
            ckw.xiD = new C1332b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(ckw.xiD.f1226wR.length);
            if (this.cuc == null) {
                i4 = -1;
            } else {
                i4 = this.cuc.field_start;
            }
            objArr[2] = Integer.valueOf(i4);
            if (this.cuc != null) {
                i = this.cuc.field_size;
            }
            objArr[3] = Integer.valueOf(i);
            C4990ab.m7417i(str, str2, objArr);
            i = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(53103);
            return i;
        } else if (this.cuc == null || this.cuc.field_start == 0) {
            C4990ab.m7412e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            AppMethodBeat.m2505o(53103);
            return -1;
        } else {
            i2 = this.cuc.field_size - this.cuc.field_start;
            i3 = i2 > Utility.DEFAULT_STREAM_BUFFER_SIZE ? Utility.DEFAULT_STREAM_BUFFER_SIZE : i2;
            if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                l = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(this.cuc);
                if (C5046bo.m7540cb(l)) {
                    C4990ab.m7420w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i3];
                    C4990ab.m7411d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", Integer.valueOf(l.length), Integer.valueOf(i3));
                    System.arraycopy(l, this.cuc.field_start, bArr, 0, i3);
                }
            } else {
                bArr = this.cuc.mo48536gZ(this.cuc.field_start, i3);
            }
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.m2505o(53103);
                return -1;
            }
            i3 = bArr.length;
            ckw.ptx = this.cuc.field_start;
            ckw.xiD = new C1332b(bArr);
            C4990ab.m7417i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", Integer.valueOf(bArr.length), Integer.valueOf(ckw.xiD.f1226wR.length));
            C4990ab.m7410d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.cuc.field_start + ", total:" + this.cuc.field_size + ", len:" + i3);
            i = mo4457a(c1902e, this.ehh, this);
            AppMethodBeat.m2505o(53103);
            return i;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(53104);
        C4990ab.m7416i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            C15399ye c15399ye = (C15399ye) ((C7472b) c1929q).fsG.fsP;
            C15400yf c15400yf = (C15400yf) ((C7472b) c1929q).fsH.fsP;
            if (c15399ye.wdV.size() != c15400yf.wdV.size()) {
                C4990ab.m7412e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + c15399ye.wdV.size() + ", resp size:" + c15400yf.wdV.size());
                bkv();
                this.ehi.onSceneEnd(i2, i3, str, this);
                m31528e(this.cuc, false);
                AppMethodBeat.m2505o(53104);
                return;
            }
            ckx ckx = null;
            if (c15400yf.wdV != null && c15400yf.wdV.size() > 0) {
                ckx = (ckx) c15400yf.wdV.get(0);
            }
            String str2;
            if (ckx == null || ckx.wdO == null || !ckx.wdO.equals(this.cuc.mo20410Aq()) || ckx.ptx < this.cuc.field_start) {
                int i4;
                String str3 = "MicroMsg.emoji.NetSceneEmojiUpload";
                str2 = "md5:%s invalid server return value. respInfo.TotalLen:%d respInfo.StartPos:%d emoji.getStart():%d emoji total:%d";
                Object[] objArr = new Object[5];
                objArr[0] = ckx.wdO;
                objArr[1] = Integer.valueOf(ckx.ptw);
                objArr[2] = Integer.valueOf(ckx == null ? -1 : ckx.ptx);
                if (this.cuc == null) {
                    i4 = -1;
                } else {
                    i4 = this.cuc.field_start;
                }
                objArr[3] = Integer.valueOf(i4);
                if (this.cuc == null) {
                    i4 = -1;
                } else {
                    i4 = this.cuc.field_size;
                }
                objArr[4] = Integer.valueOf(i4);
                C4990ab.m7413e(str3, str2, objArr);
                bkv();
                this.ehi.onSceneEnd(4, -2, "", this);
                m31528e(this.cuc, false);
                AppMethodBeat.m2505o(53104);
                return;
            } else if (ckx != null && this.cuc != null && ckx.Ret != 0 && ckx.ptx == ckx.ptw && ckx.ptx > 0) {
                C4990ab.m7417i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", this.cuc.mo20410Aq(), Integer.valueOf(ckx.Ret), Integer.valueOf(ckx.ptx), Integer.valueOf(ckx.ptw));
                bkv();
                this.ehi.onSceneEnd(i2, i3, "", this);
                AppMethodBeat.m2505o(53104);
                return;
            } else if (c15400yf.BaseResponse.Ret == 0 && (ckx == null || ckx.Ret == 0)) {
                if (this.kWx) {
                    this.kWx = false;
                }
                if (ckx.ptx >= ckx.ptw) {
                    this.cuc.field_start = 0;
                    this.cuc.field_state = EmojiInfo.zZb;
                    this.cuc.field_needupload = EmojiInfo.zZg;
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(this.cuc);
                    this.ehi.onSceneEnd(i2, i3, "", this);
                    m31528e(this.cuc, true);
                    C4990ab.m7416i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    AppMethodBeat.m2505o(53104);
                    return;
                }
                C4990ab.m7417i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", Integer.valueOf(ckx.ptx));
                this.cuc.field_start = ckx.ptx;
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(this.cuc);
                if (mo4456a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                    m31528e(this.cuc, false);
                }
                AppMethodBeat.m2505o(53104);
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(c15400yf.BaseResponse.Ret);
                objArr2[1] = Integer.valueOf(ckx == null ? -1 : ckx.Ret);
                C4990ab.m7413e(str2, str4, objArr2);
                bkv();
                this.ehi.onSceneEnd(i2, i3, "", this);
                AppMethodBeat.m2505o(53104);
                return;
            }
        }
        bkv();
        this.ehi.onSceneEnd(i2, i3, str, this);
        m31528e(this.cuc, false);
        AppMethodBeat.m2505o(53104);
    }

    public final int acn() {
        return this.kWy;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    private void bkv() {
        AppMethodBeat.m2504i(53105);
        this.cuc.field_start = 0;
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(this.cuc);
        AppMethodBeat.m2505o(53105);
    }

    /* renamed from: e */
    private void m31528e(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(53106);
        if (!(emojiInfo == null || C5046bo.isNullOrNil(emojiInfo.mo20410Aq()))) {
            C4990ab.m7417i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", emojiInfo.mo20410Aq(), Boolean.valueOf(z));
            C26107cx c26107cx = new C26107cx();
            c26107cx.cvY.cvZ = emojiInfo.mo20410Aq();
            c26107cx.cvY.cuy = 0;
            c26107cx.cvY.success = z;
            C4879a.xxA.mo10055m(c26107cx);
            long currentTimeMillis = System.currentTimeMillis() - this.eyR;
            C4990ab.m7420w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + currentTimeMillis + " size " + emojiInfo.field_size + " rate " + (((long) emojiInfo.field_size) / currentTimeMillis));
        }
        AppMethodBeat.m2505o(53106);
    }
}
