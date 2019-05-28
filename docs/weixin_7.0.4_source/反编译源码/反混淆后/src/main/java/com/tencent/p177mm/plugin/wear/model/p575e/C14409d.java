package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p230g.p231a.C42075vh;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.ctm;
import com.tencent.p177mm.protocal.protobuf.ctn;
import com.tencent.p177mm.protocal.protobuf.cto;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.d */
public final class C14409d extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26393);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
        arrayList.add(Integer.valueOf(11004));
        AppMethodBeat.m2505o(26393);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        byte[] q;
        Throwable e;
        AppMethodBeat.m2504i(26394);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
            ctm ctm = new ctm();
            try {
                ctm.parseFrom(bArr);
            } catch (IOException e2) {
            }
            if (C37626b.dqD().xFH > ctm.woY) {
                InputStream open;
                try {
                    open = C4996ah.getContext().getAssets().open("color_emoji");
                    try {
                        q = C1173e.m2574q(open);
                        C1173e.m2573p(open);
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            C1173e.m2573p(open);
                            q = null;
                            AppMethodBeat.m2505o(26394);
                            return q;
                        } catch (Throwable th) {
                            e = th;
                            C1173e.m2573p(open);
                            AppMethodBeat.m2505o(26394);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    C1173e.m2573p(open);
                    AppMethodBeat.m2505o(26394);
                    throw e;
                }
                AppMethodBeat.m2505o(26394);
                return q;
            }
        } else if (i == 11004) {
            C46393a.m87275HH(9);
            ctn ctn = new ctn();
            try {
                ctn.parseFrom(bArr);
            } catch (IOException e5) {
            }
            cto cto = new cto();
            if (((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr() != null) {
                List<EmojiInfo> Jg = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35599Jg(ctn.vQq);
                if (Jg != null) {
                    for (EmojiInfo emojiInfo : Jg) {
                        if (!C5046bo.isNullOrNil(emojiInfo.mo20410Aq())) {
                            cto.vII.add(emojiInfo.mo20410Aq());
                        }
                    }
                }
            }
            if (cto.vII.size() == 0) {
                C42075vh c42075vh = new C42075vh();
                String[] strArr = new String[]{ctn.vQq};
                c42075vh.cSo.cSp = strArr;
                c42075vh.cSo.cuy = 1;
                C4879a.xxA.mo10055m(c42075vh);
            }
            try {
                q = cto.toByteArray();
                AppMethodBeat.m2505o(26394);
                return q;
            } catch (IOException e6) {
            }
        }
        AppMethodBeat.m2505o(26394);
        return null;
    }
}
