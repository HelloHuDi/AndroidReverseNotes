package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.protocal.protobuf.ctu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.h */
public final class C35559h extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26401);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(CdnLogic.kMediaTypeExposeImage));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY));
        arrayList.add(Integer.valueOf(11035));
        AppMethodBeat.m2505o(26401);
        return arrayList;
    }

    public final boolean cUB() {
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        int i2 = 0;
        AppMethodBeat.m2504i(26402);
        String str;
        String str2;
        if (i == CdnLogic.kMediaTypeExposeImage) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = C5730e.m8631cy(str);
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e, "handleData", new Object[0]);
            }
            String[] split = str2.split("​​");
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < split.length; i3++) {
                arrayList.add(split[i3]);
                if (i3 % 50 == 9) {
                    C7060h.pYm.mo15420q("WearCrash", arrayList);
                    arrayList.clear();
                }
            }
            if (arrayList.size() > 0) {
                C7060h.pYm.mo15420q("WearCrash", arrayList);
                arrayList.clear();
            }
            C5730e.deleteFile(str);
        } else if (i == TXCStreamUploader.TXE_UPLOAD_INFO_NET_BUSY) {
            str = new String(bArr);
            str2 = "";
            try {
                str2 = C5730e.m8631cy(str);
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Wear.HttpLogServer", e2, "handleData", new Object[0]);
            }
            String[] split2 = str2.split("​​");
            int length = split2.length;
            while (i2 < length) {
                C4990ab.m7416i("MicroMsg.Wear.LOG", split2[i2]);
                i2++;
            }
            C5730e.deleteFile(str);
        } else if (i == 11035) {
            ctu ctu = new ctu();
            try {
                ctu.parseFrom(bArr);
            } catch (IOException e3) {
            }
            if (C43841a.cUn().tXt.tXK.tYz != null) {
                C4990ab.m7419v("MicroMsg.Wear.HttpLogServer", "report kv id=%d %s %s %s %s data=%s", Integer.valueOf(ctu.ndE), C43841a.cUn().tXt.tXK.tYz.jBG, C43841a.cUn().tXt.tXK.tYz.xqs, Integer.valueOf(C43841a.cUn().tXt.tXK.tYz.vFE), C43841a.cUn().tXt.tXK.tYz.xqt, ctu.xmI);
                C7060h.pYm.mo8381e(ctu.ndE, r2.jBG, r2.xqs, Integer.valueOf(r2.vFE), r2.xqt, ctu.xmI);
            }
        }
        AppMethodBeat.m2505o(26402);
        return null;
    }
}
