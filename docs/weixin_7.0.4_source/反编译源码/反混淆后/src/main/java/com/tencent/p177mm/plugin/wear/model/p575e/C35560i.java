package com.tencent.p177mm.plugin.wear.model.p575e;

import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p230g.p231a.C42075vh;
import com.tencent.p177mm.p230g.p231a.C42076vi;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.protocal.protobuf.ctv;
import com.tencent.p177mm.protocal.protobuf.ctw;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.i */
public final class C35560i extends C46394a {
    public ctv tYz;

    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26403);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN));
        AppMethodBeat.m2505o(26403);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        AppMethodBeat.m2504i(26404);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN) {
            C46393a.m87276gn(1, 0);
            C46393a.m87275HH(0);
            C42075vh c42075vh = new C42075vh();
            c42075vh.cSo.cSp = C4996ah.getContext().getResources().getStringArray(C25738R.array.f12612l);
            c42075vh.cSo.cuy = 1;
            C4879a.xxA.mo10055m(c42075vh);
            byte[] bB = C43841a.cUn().tXt.mo56291bB(bArr);
            if (bB != null) {
                try {
                    ctv ctv = new ctv();
                    ctv.parseFrom(bB);
                    ctw ctw = new ctw();
                    int i2 = 20;
                    String str = null;
                    while (i2 > 0) {
                        str = C1853r.m3846Yz();
                        if (C5046bo.isNullOrNil(str)) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                            }
                            i2--;
                        }
                    }
                    if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(26404);
                        return null;
                    }
                    ctw.vHl = str;
                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
                    C4996ah.getContext();
                    str = C4988aa.m7405h(sharedPreferences);
                    String dor = C4988aa.dor();
                    if (str.equals("language_default")) {
                        ctw.luQ = dor;
                    } else {
                        ctw.luQ = str;
                    }
                    bB = C43841a.cUn().tXt.mo56292bC(ctw.toByteArray());
                    if (bB != null) {
                        this.tYz = ctv;
                        C4883b c42076vi = new C42076vi();
                        c42076vi.cSq.cuy = 9;
                        C4879a.xxA.mo10048a(c42076vi, Looper.getMainLooper());
                        AppMethodBeat.m2505o(26404);
                        return bB;
                    }
                    AppMethodBeat.m2505o(26404);
                    return null;
                } catch (IOException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.m2505o(26404);
        return null;
    }
}
