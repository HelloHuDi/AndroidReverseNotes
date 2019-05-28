package com.tencent.mm.plugin.wear.model.e;

import android.content.SharedPreferences;
import android.os.Looper;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.vh;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.wear.model.c.a;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.protocal.protobuf.ctw;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i extends a {
    public ctv tYz;

    public final List<Integer> cUA() {
        AppMethodBeat.i(26403);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN));
        AppMethodBeat.o(26403);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        AppMethodBeat.i(26404);
        if (i == TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN) {
            a.gn(1, 0);
            a.HH(0);
            vh vhVar = new vh();
            vhVar.cSo.cSp = ah.getContext().getResources().getStringArray(R.array.l);
            vhVar.cSo.cuy = 1;
            com.tencent.mm.sdk.b.a.xxA.m(vhVar);
            byte[] bB = com.tencent.mm.plugin.wear.model.a.cUn().tXt.bB(bArr);
            if (bB != null) {
                try {
                    ctv ctv = new ctv();
                    ctv.parseFrom(bB);
                    ctw ctw = new ctw();
                    int i2 = 20;
                    String str = null;
                    while (i2 > 0) {
                        str = r.Yz();
                        if (bo.isNullOrNil(str)) {
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                            }
                            i2--;
                        }
                    }
                    if (bo.isNullOrNil(str)) {
                        AppMethodBeat.o(26404);
                        return null;
                    }
                    ctw.vHl = str;
                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
                    ah.getContext();
                    str = aa.h(sharedPreferences);
                    String dor = aa.dor();
                    if (str.equals("language_default")) {
                        ctw.luQ = dor;
                    } else {
                        ctw.luQ = str;
                    }
                    bB = com.tencent.mm.plugin.wear.model.a.cUn().tXt.bC(ctw.toByteArray());
                    if (bB != null) {
                        this.tYz = ctv;
                        b viVar = new vi();
                        viVar.cSq.cuy = 9;
                        com.tencent.mm.sdk.b.a.xxA.a(viVar, Looper.getMainLooper());
                        AppMethodBeat.o(26404);
                        return bB;
                    }
                    AppMethodBeat.o(26404);
                    return null;
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Wear.HttpLoginServer", e2, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(26404);
        return null;
    }
}
