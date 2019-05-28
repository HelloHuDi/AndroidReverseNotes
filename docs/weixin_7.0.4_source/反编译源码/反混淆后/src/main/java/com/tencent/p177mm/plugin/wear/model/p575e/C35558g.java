package com.tencent.p177mm.plugin.wear.model.p575e;

import android.graphics.Bitmap;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.loader.p848c.C18198b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p190at.C25822e;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.protocal.protobuf.cti;
import com.tencent.p177mm.protocal.protobuf.ctj;
import com.tencent.p177mm.protocal.protobuf.cua;
import com.tencent.p177mm.protocal.protobuf.cub;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.g */
public final class C35558g extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26399);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE));
        AppMethodBeat.m2505o(26399);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* JADX WARNING: Missing block: B:77:0x021d, code skipped:
            if (com.tencent.p177mm.modelsfs.FileOp.m64138ct(r0) == false) goto L_0x021f;
     */
    /* JADX WARNING: Missing block: B:84:0x0251, code skipped:
            if (com.tencent.p177mm.modelsfs.FileOp.m64138ct(r0) != false) goto L_0x0253;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        Throwable e;
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(26400);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_HANDSHAKE_FAIL) {
            cti cti = new cti();
            try {
                cti.parseFrom(bArr);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e2, "", new Object[0]);
            }
            ctj ctj = new ctj();
            Bitmap adv = C43845h.adv(cti.vHl);
            if (adv != null) {
                ctj.xqp = System.currentTimeMillis();
                byte[] ad = C43845h.m78627ad(adv);
                C4990ab.m7417i("MicroMsg.Wear.HttpImageServer", "return avatar data username=%s", cti.vHl);
                ctj.jBi = new C1332b(ad);
                try {
                    bArr2 = ctj.toByteArray();
                    AppMethodBeat.m2505o(26400);
                    return bArr2;
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e3, "", new Object[0]);
                }
            } else {
                C4990ab.m7421w("MicroMsg.Wear.HttpImageServer", "get avatar fail, %s", cti.vHl);
            }
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_FAILED) {
            try {
                EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(new String(bArr, "utf8"));
                if (Jd != null) {
                    if (Jd.mo48552xy()) {
                        bArr2 = C43845h.m78627ad(Jd.mo48543hl(C4996ah.getContext()));
                        AppMethodBeat.m2505o(26400);
                        return bArr2;
                    } else if (Jd.field_catalog == EmojiGroupInfo.yar) {
                        InputStream bJ;
                        try {
                            bJ = EmojiInfo.m48210bJ(C4996ah.getContext(), Jd.getName());
                            try {
                                bArr2 = C1173e.m2574q(bJ);
                                C1173e.m2573p(bJ);
                                AppMethodBeat.m2505o(26400);
                                return bArr2;
                            } catch (Exception e4) {
                                e = e4;
                                try {
                                    C4990ab.m7413e("MicroMsg.Wear.HttpImageServer", "exception:%s", C5046bo.m7574l(e));
                                    C1173e.m2573p(bJ);
                                    AppMethodBeat.m2505o(26400);
                                    return bArr2;
                                } catch (Throwable th) {
                                    e = th;
                                    C1173e.m2573p(bJ);
                                    AppMethodBeat.m2505o(26400);
                                    throw e;
                                }
                            }
                        } catch (Exception e5) {
                            e = e5;
                            bJ = bArr2;
                        } catch (Throwable th2) {
                            e = th2;
                            bJ = bArr2;
                            C1173e.m2573p(bJ);
                            AppMethodBeat.m2505o(26400);
                            throw e;
                        }
                    } else if (C5730e.asZ(Jd.dve()) > 819200) {
                        C4990ab.m7417i("MicroMsg.Wear.HttpImageServer", "handleData: emoji file size too large, %s", Jd.mo20410Aq());
                        if (C5730e.m8628ct(Jd.dvf())) {
                            bArr2 = C5730e.m8632e(Jd.dvf(), 0, -1);
                            AppMethodBeat.m2505o(26400);
                            return bArr2;
                        }
                        C4990ab.m7416i("MicroMsg.Wear.HttpImageServer", "handleData: emoji thumb not exist");
                        C18198b.m28641d(Jd);
                        bArr2 = C5730e.m8632e(Jd.dvf(), 0, -1);
                        AppMethodBeat.m2505o(26400);
                        return bArr2;
                    } else {
                        bArr2 = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35656l(Jd);
                        AppMethodBeat.m2505o(26400);
                        return bArr2;
                    }
                }
            } catch (UnsupportedEncodingException e6) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e6, "", new Object[0]);
                AppMethodBeat.m2505o(26400);
                return bArr2;
            }
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_SERVER_REFUSE) {
            cua cua = new cua();
            try {
                cua.parseFrom(bArr);
            } catch (IOException e22) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpImageServer", e22, "", new Object[0]);
            }
            C9638aw.m17190ZK();
            C7620bi jf = C18628c.m29080XO().mo15340jf(cua.vIs);
            String q;
            if (cua.xqC) {
                cub cub = new cub();
                cub.xqp = System.currentTimeMillis();
                C25822e fJ;
                if (jf.field_isSend == 1) {
                    fJ = C32291o.ahl().mo73113fJ(jf.field_msgId);
                    q = C32291o.ahl().mo73118q(C32291o.ahl().mo73109d(fJ), "", "");
                    if (!FileOp.m64138ct(q)) {
                        q = C32291o.ahl().mo73118q(fJ.fDz, "", "");
                    }
                } else {
                    fJ = C32291o.ahl().mo73112fI(jf.field_msgSvrId);
                    if (fJ.agP()) {
                        if (fJ.agQ()) {
                            q = C32291o.ahl().mo73118q(C32291o.ahl().mo73109d(fJ), "", "");
                        }
                        q = bArr2;
                        if (C5046bo.isNullOrNil(q)) {
                            String q2 = C32291o.ahl().mo73118q(fJ.fDz, "", "");
                            if (FileOp.m64138ct(q2)) {
                                q = q2;
                            }
                        }
                    }
                    q = bArr2;
                }
                if (!C5046bo.isNullOrNil(q)) {
                    cub.jBi = new C1332b(FileOp.m64146te(q));
                    try {
                        bArr2 = cub.toByteArray();
                        AppMethodBeat.m2505o(26400);
                        return bArr2;
                    } catch (IOException e7) {
                    }
                }
            } else {
                q = C32291o.ahl().mo73119sj(jf.field_imgPath);
                if (!C5046bo.isNullOrNil(q)) {
                    cub cub2 = new cub();
                    cub2.xqp = System.currentTimeMillis();
                    cub2.jBi = new C1332b(FileOp.m64146te(q));
                    try {
                        bArr2 = cub2.toByteArray();
                        AppMethodBeat.m2505o(26400);
                        return bArr2;
                    } catch (IOException e8) {
                    }
                }
            }
        }
        AppMethodBeat.m2505o(26400);
        return bArr2;
    }
}
