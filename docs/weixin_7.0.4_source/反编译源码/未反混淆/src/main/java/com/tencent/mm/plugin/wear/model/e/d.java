package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.cb.b;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.ctm;
import com.tencent.mm.protocal.protobuf.ctn;
import com.tencent.mm.protocal.protobuf.cto;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class d extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26393);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS));
        arrayList.add(Integer.valueOf(11004));
        AppMethodBeat.o(26393);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        byte[] q;
        Throwable e;
        AppMethodBeat.i(26394);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_CONNECT_SUCCESS) {
            ctm ctm = new ctm();
            try {
                ctm.parseFrom(bArr);
            } catch (IOException e2) {
            }
            if (b.dqD().xFH > ctm.woY) {
                InputStream open;
                try {
                    open = ah.getContext().getAssets().open("color_emoji");
                    try {
                        q = e.q(open);
                        e.p(open);
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            ab.printErrStackTrace("MicroMsg.Wear.EmojiServer", e, "", new Object[0]);
                            e.p(open);
                            q = null;
                            AppMethodBeat.o(26394);
                            return q;
                        } catch (Throwable th) {
                            e = th;
                            e.p(open);
                            AppMethodBeat.o(26394);
                            throw e;
                        }
                    }
                } catch (IOException e4) {
                    e = e4;
                    open = null;
                } catch (Throwable th2) {
                    e = th2;
                    open = null;
                    e.p(open);
                    AppMethodBeat.o(26394);
                    throw e;
                }
                AppMethodBeat.o(26394);
                return q;
            }
        } else if (i == 11004) {
            a.HH(9);
            ctn ctn = new ctn();
            try {
                ctn.parseFrom(bArr);
            } catch (IOException e5) {
            }
            cto cto = new cto();
            if (((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() != null) {
                List<EmojiInfo> Jg = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jg(ctn.vQq);
                if (Jg != null) {
                    for (EmojiInfo emojiInfo : Jg) {
                        if (!bo.isNullOrNil(emojiInfo.Aq())) {
                            cto.vII.add(emojiInfo.Aq());
                        }
                    }
                }
            }
            if (cto.vII.size() == 0) {
                vh vhVar = new vh();
                String[] strArr = new String[]{ctn.vQq};
                vhVar.cSo.cSp = strArr;
                vhVar.cSo.cuy = 1;
                com.tencent.mm.sdk.b.a.xxA.m(vhVar);
            }
            try {
                q = cto.toByteArray();
                AppMethodBeat.o(26394);
                return q;
            } catch (IOException e6) {
            }
        }
        AppMethodBeat.o(26394);
        return null;
    }
}
