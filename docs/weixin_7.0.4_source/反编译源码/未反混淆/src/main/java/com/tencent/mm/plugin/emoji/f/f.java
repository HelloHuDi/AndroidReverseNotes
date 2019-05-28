package com.tencent.mm.plugin.emoji.f;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ckw;
import com.tencent.mm.protocal.protobuf.ckx;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class f extends m implements k {
    private EmojiInfo cuc;
    private final b ehh;
    private com.tencent.mm.ai.f ehi;
    private long eyR = System.currentTimeMillis();
    private boolean kWx = true;
    private int kWy = 256;

    public f(EmojiInfo emojiInfo) {
        AppMethodBeat.i(53102);
        ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "start upload at " + this.eyR);
        this.cuc = emojiInfo;
        a aVar = new a();
        aVar.fsJ = new ye();
        aVar.fsK = new yf();
        aVar.uri = "/cgi-bin/micromsg-bin/mmemojiupload";
        aVar.fsI = 703;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ye yeVar = (ye) this.ehh.fsG.fsP;
        ckw ckw = new ckw();
        if (this.cuc != null) {
            h.pYm.k(164, 13, 1);
            ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "NetSceneEmojiUpload: %s", this.cuc.Aq());
            ((d) g.M(d.class)).getEmojiStorageMgr().xYn.a(ah.getContext(), this.cuc);
            ckw.wdO = this.cuc.Aq();
            ckw.ptw = this.cuc.field_size;
            yeVar.wdV.add(ckw);
            this.kWy = (this.cuc.field_size / Utility.DEFAULT_STREAM_BUFFER_SIZE) * 2;
        }
        AppMethodBeat.o(53102);
    }

    public final int getType() {
        return 703;
    }

    public final int a(e eVar, com.tencent.mm.ai.f fVar) {
        int i = -1;
        AppMethodBeat.i(53103);
        this.ehi = fVar;
        ckw ckw = (ckw) ((ye) this.ehh.fsG.fsP).wdV.get(0);
        int i2;
        int i3;
        byte[] l;
        byte[] bArr;
        if (this.kWx) {
            ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, firstSend. md5=" + ckw.wdO);
            ckw.ptx = 0;
            i2 = this.cuc.field_size + 0;
            i3 = i2 > Utility.DEFAULT_STREAM_BUFFER_SIZE ? Utility.DEFAULT_STREAM_BUFFER_SIZE : i2;
            if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                l = ((d) g.M(d.class)).getEmojiMgr().l(this.cuc);
                if (bo.cb(l)) {
                    ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i3];
                    ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d ", Integer.valueOf(l.length), Integer.valueOf(i3));
                    System.arraycopy(l, 0, bArr, 0, i3);
                }
            } else {
                bArr = this.cuc.gZ(0, i3);
            }
            if (bArr == null || bArr.length <= 0) {
                ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.o(53103);
                return -1;
            }
            int i4;
            ckw.ptx = 0;
            ckw.xiD = new com.tencent.mm.bt.b(bArr);
            String str = "MicroMsg.emoji.NetSceneEmojiUpload";
            String str2 = "buf len:%d, string len:%d dispatcher, first emoji start:%d emoji total:%d";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(bArr.length);
            objArr[1] = Integer.valueOf(ckw.xiD.wR.length);
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
            ab.i(str, str2, objArr);
            i = a(eVar, this.ehh, this);
            AppMethodBeat.o(53103);
            return i;
        } else if (this.cuc == null || this.cuc.field_start == 0) {
            ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "emoji info is null. or start position is 0.");
            AppMethodBeat.o(53103);
            return -1;
        } else {
            i2 = this.cuc.field_size - this.cuc.field_start;
            i3 = i2 > Utility.DEFAULT_STREAM_BUFFER_SIZE ? Utility.DEFAULT_STREAM_BUFFER_SIZE : i2;
            if ((this.cuc.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                l = ((d) g.M(d.class)).getEmojiMgr().l(this.cuc);
                if (bo.cb(l)) {
                    ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "buffer is null.");
                    bArr = new byte[0];
                } else {
                    bArr = new byte[i3];
                    ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "total length:%d dataLen:%d", Integer.valueOf(l.length), Integer.valueOf(i3));
                    System.arraycopy(l, this.cuc.field_start, bArr, 0, i3);
                }
            } else {
                bArr = this.cuc.gZ(this.cuc.field_start, i3);
            }
            if (bArr == null || bArr.length <= 0) {
                ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "readFromFile is null.");
                AppMethodBeat.o(53103);
                return -1;
            }
            i3 = bArr.length;
            ckw.ptx = this.cuc.field_start;
            ckw.xiD = new com.tencent.mm.bt.b(bArr);
            ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "buf len:%d, string len:%d", Integer.valueOf(bArr.length), Integer.valueOf(ckw.xiD.wR.length));
            ab.d("MicroMsg.emoji.NetSceneEmojiUpload", "dispatcher, start:" + this.cuc.field_start + ", total:" + this.cuc.field_size + ", len:" + i3);
            i = a(eVar, this.ehh, this);
            AppMethodBeat.o(53103);
            return i;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(53104);
        ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd  errtype:" + i2 + " errcode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ye yeVar = (ye) ((b) qVar).fsG.fsP;
            yf yfVar = (yf) ((b) qVar).fsH.fsP;
            if (yeVar.wdV.size() != yfVar.wdV.size()) {
                ab.e("MicroMsg.emoji.NetSceneEmojiUpload", "onGYNetEnd failed. RequestSize not equal RespSize. req size:" + yeVar.wdV.size() + ", resp size:" + yfVar.wdV.size());
                bkv();
                this.ehi.onSceneEnd(i2, i3, str, this);
                e(this.cuc, false);
                AppMethodBeat.o(53104);
                return;
            }
            ckx ckx = null;
            if (yfVar.wdV != null && yfVar.wdV.size() > 0) {
                ckx = (ckx) yfVar.wdV.get(0);
            }
            String str2;
            if (ckx == null || ckx.wdO == null || !ckx.wdO.equals(this.cuc.Aq()) || ckx.ptx < this.cuc.field_start) {
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
                ab.e(str3, str2, objArr);
                bkv();
                this.ehi.onSceneEnd(4, -2, "", this);
                e(this.cuc, false);
                AppMethodBeat.o(53104);
                return;
            } else if (ckx != null && this.cuc != null && ckx.Ret != 0 && ckx.ptx == ckx.ptw && ckx.ptx > 0) {
                ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success, but md5 backup faild.try to do batch emoji backup. %s respInfo.Ret:%d respInfo.StartPos:%d respInfo.TotalLen:%d", this.cuc.Aq(), Integer.valueOf(ckx.Ret), Integer.valueOf(ckx.ptx), Integer.valueOf(ckx.ptw));
                bkv();
                this.ehi.onSceneEnd(i2, i3, "", this);
                AppMethodBeat.o(53104);
                return;
            } else if (yfVar.BaseResponse.Ret == 0 && (ckx == null || ckx.Ret == 0)) {
                if (this.kWx) {
                    this.kWx = false;
                }
                if (ckx.ptx >= ckx.ptw) {
                    this.cuc.field_start = 0;
                    this.cuc.field_state = EmojiInfo.zZb;
                    this.cuc.field_needupload = EmojiInfo.zZg;
                    ((d) g.M(d.class)).getEmojiStorageMgr().xYn.G(this.cuc);
                    this.ehi.onSceneEnd(i2, i3, "", this);
                    e(this.cuc, true);
                    ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] emoji upload success.");
                    AppMethodBeat.o(53104);
                    return;
                }
                ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "next start pos is :%d", Integer.valueOf(ckx.ptx));
                this.cuc.field_start = ckx.ptx;
                ((d) g.M(d.class)).getEmojiStorageMgr().xYn.G(this.cuc);
                if (a(this.ftf, this.ehi) < 0) {
                    this.ehi.onSceneEnd(3, -1, "", this);
                    e(this.cuc, false);
                }
                AppMethodBeat.o(53104);
                return;
            } else {
                str2 = "MicroMsg.emoji.NetSceneEmojiUpload";
                String str4 = "onGYNetEnd failed. resp.BaseResponse.Ret:%d respInfo.Ret:%d";
                Object[] objArr2 = new Object[2];
                objArr2[0] = Integer.valueOf(yfVar.BaseResponse.Ret);
                objArr2[1] = Integer.valueOf(ckx == null ? -1 : ckx.Ret);
                ab.e(str2, str4, objArr2);
                bkv();
                this.ehi.onSceneEnd(i2, i3, "", this);
                AppMethodBeat.o(53104);
                return;
            }
        }
        bkv();
        this.ehi.onSceneEnd(i2, i3, str, this);
        e(this.cuc, false);
        AppMethodBeat.o(53104);
    }

    public final int acn() {
        return this.kWy;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    private void bkv() {
        AppMethodBeat.i(53105);
        this.cuc.field_start = 0;
        ((d) g.M(d.class)).getEmojiStorageMgr().xYn.G(this.cuc);
        AppMethodBeat.o(53105);
    }

    private void e(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(53106);
        if (!(emojiInfo == null || bo.isNullOrNil(emojiInfo.Aq()))) {
            ab.i("MicroMsg.emoji.NetSceneEmojiUpload", "[cpan] publicEmojiSyncTaskEvent emoji md5:%s success:%b", emojiInfo.Aq(), Boolean.valueOf(z));
            cx cxVar = new cx();
            cxVar.cvY.cvZ = emojiInfo.Aq();
            cxVar.cvY.cuy = 0;
            cxVar.cvY.success = z;
            com.tencent.mm.sdk.b.a.xxA.m(cxVar);
            long currentTimeMillis = System.currentTimeMillis() - this.eyR;
            ab.w("MicroMsg.emoji.NetSceneEmojiUpload", "finish cost " + currentTimeMillis + " size " + emojiInfo.field_size + " rate " + (((long) emojiInfo.field_size) / currentTimeMillis));
        }
        AppMethodBeat.o(53106);
    }
}
