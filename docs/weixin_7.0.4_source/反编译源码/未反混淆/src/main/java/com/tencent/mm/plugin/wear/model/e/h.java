package com.tencent.mm.plugin.wear.model.e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.protobuf.ctu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class h extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26401);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(CdnLogic.kMediaTypeExposeImage));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY));
        arrayList.add(Integer.valueOf(11035));
        AppMethodBeat.o(26401);
        return arrayList;
    }

    public final boolean cUB() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.i(26402);
        String str;
        String str2;
        if (i == CdnLogic.kMediaTypeExposeImage) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = e.cy(str);
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    com.tencent.mm.plugin.report.service.h.pYm.q("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                com.tencent.mm.plugin.report.service.h.pYm.q("WearCrash", arrayList);
                arrayList.clear();
            }
            e.deleteFile(str);
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = e.cy(str);
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                ab.i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            e.deleteFile(str);
        } else if (i == 11035) {
            ctu ctu = new ctu();
            try {
                ctu.parseFrom(bArr);
            } catch (IOException e3) {
            }
            if (a.cUn().tXt.tXK.tYz != null) {
                ab.v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(ctu.ndE), a.cUn().tXt.tXK.tYz.jBG, a.cUn().tXt.tXK.tYz.xqs, Integer.valueOf(a.cUn().tXt.tXK.tYz.vFE), a.cUn().tXt.tXK.tYz.xqt, ctu.xmI);
                com.tencent.mm.plugin.report.service.h.pYm.e(ctu.ndE, r2.jBG, r2.xqs, Integer.valueOf(r2.vFE), r2.xqt, ctu.xmI);
            }
        }
        AppMethodBeat.o(26402);
        return null;
    }
}
