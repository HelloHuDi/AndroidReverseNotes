package com.tencent.mm.plugin.wear.model.e;

import android.graphics.Bitmap;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.at.o;
import com.tencent.mm.bt.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.cua;
import com.tencent.mm.protocal.protobuf.cub;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class g extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26399);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE));
        AppMethodBeat.o(26399);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:77:0x021d, code skipped:
            if (com.tencent.mm.modelsfs.FileOp.ct(r0) == false) goto L_0x021f;
     */
    /* JADX WARNING: Missing block: B:84:0x0251, code skipped:
            if (com.tencent.mm.modelsfs.FileOp.ct(r0) != false) goto L_0x0253;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] p(int i, byte[] bArr) {
        Throwable e;
        byte[] bArr2 = null;
        AppMethodBeat.i(26400);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL) {
            cti cti = new cti();
            try {
                cti.parseFrom(bArr);
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e2, "", new Object[0]);
            }
            ctj ctj = new ctj();
            Bitmap adv = h.adv(cti.vHl);
            if (adv != null) {
                ctj.xqp = System.currentTimeMillis();
                byte[] ad = h.ad(adv);
                ab.i("MicroMsg.Wear.HttpImageServer", "return avatar data username=%s", cti.vHl);
                ctj.jBi = new b(ad);
                try {
                    bArr2 = ctj.toByteArray();
                    AppMethodBeat.o(26400);
                    return bArr2;
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e3, "", new Object[0]);
                }
            } else {
                ab.w("MicroMsg.Wear.HttpImageServer", "get avatar fail, %s", cti.vHl);
            }
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED) {
            try {
                EmojiInfo Jd = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().Jd(new String(bArr, "utf8"));
                if (Jd != null) {
                    if (Jd.xy()) {
                        bArr2 = h.ad(Jd.hl(ah.getContext()));
                        AppMethodBeat.o(26400);
                        return bArr2;
                    } else if (Jd.field_catalog == EmojiGroupInfo.yar) {
                        InputStream bJ;
                        try {
                            bJ = EmojiInfo.bJ(ah.getContext(), Jd.getName());
                            try {
                                bArr2 = e.q(bJ);
                                e.p(bJ);
                                AppMethodBeat.o(26400);
                                return bArr2;
                            } catch (Exception e4) {
                                e = e4;
                                try {
                                    ab.e("MicroMsg.Wear.HttpImageServer", "exception:%s", bo.l(e));
                                    e.p(bJ);
                                    AppMethodBeat.o(26400);
                                    return bArr2;
                                } catch (Throwable th) {
                                    e = th;
                                    e.p(bJ);
                                    AppMethodBeat.o(26400);
                                    throw e;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            bJ = bArr2;
                        } catch (Throwable th2) {
                            e = th2;
                            bJ = bArr2;
                            e.p(bJ);
                            AppMethodBeat.o(26400);
                            throw e;
                        }
                    } else if (com.tencent.mm.vfs.e.asZ(Jd.dve()) > 819200) {
                        ab.i("MicroMsg.Wear.HttpImageServer", "handleData: emoji file size too large, %s", Jd.Aq());
                        if (com.tencent.mm.vfs.e.ct(Jd.dvf())) {
                            bArr2 = com.tencent.mm.vfs.e.e(Jd.dvf(), 0, -1);
                            AppMethodBeat.o(26400);
                            return bArr2;
                        }
                        ab.i("MicroMsg.Wear.HttpImageServer", "handleData: emoji thumb not exist");
                        com.tencent.mm.emoji.loader.c.b.d(Jd);
                        bArr2 = com.tencent.mm.vfs.e.e(Jd.dvf(), 0, -1);
                        AppMethodBeat.o(26400);
                        return bArr2;
                    } else {
                        bArr2 = ((d) com.tencent.mm.kernel.g.M(d.class)).getEmojiMgr().l(Jd);
                        AppMethodBeat.o(26400);
                        return bArr2;
                    }
                }
            } catch (UnsupportedEncodingException e6) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e6, "", new Object[0]);
                AppMethodBeat.o(26400);
                return bArr2;
            }
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE) {
            cua cua = new cua();
            try {
                cua.parseFrom(bArr);
            } catch (IOException e22) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e22, "", new Object[0]);
            }
            aw.ZK();
            bi jf = c.XO().jf(cua.vIs);
            String q;
            if (cua.xqC) {
                cub cub = new cub();
                cub.xqp = System.currentTimeMillis();
                com.tencent.mm.at.e fJ;
                if (jf.field_isSend == 1) {
                    fJ = o.ahl().fJ(jf.field_msgId);
                    q = o.ahl().q(o.ahl().d(fJ), "", "");
                    if (!FileOp.ct(q)) {
                        q = o.ahl().q(fJ.fDz, "", "");
                    }
                } else {
                    fJ = o.ahl().fI(jf.field_msgSvrId);
                    if (fJ.agP()) {
                        if (fJ.agQ()) {
                            q = o.ahl().q(o.ahl().d(fJ), "", "");
                        }
                        q = bArr2;
                        if (bo.isNullOrNil(q)) {
                            String q2 = o.ahl().q(fJ.fDz, "", "");
                            if (FileOp.ct(q2)) {
                                q = q2;
                            }
                        }
                    }
                    q = bArr2;
                }
                if (!bo.isNullOrNil(q)) {
                    cub.jBi = new b(FileOp.te(q));
                    try {
                        bArr2 = cub.toByteArray();
                        AppMethodBeat.o(26400);
                        return bArr2;
                    } catch (IOException e7) {
                    }
                }
            } else {
                q = o.ahl().sj(jf.field_imgPath);
                if (!bo.isNullOrNil(q)) {
                    cub cub2 = new cub();
                    cub2.xqp = System.currentTimeMillis();
                    cub2.jBi = new b(FileOp.te(q));
                    try {
                        bArr2 = cub2.toByteArray();
                        AppMethodBeat.o(26400);
                        return bArr2;
                    } catch (IOException e8) {
                    }
                }
            }
        }
        AppMethodBeat.o(26400);
        return bArr2;
    }
}
