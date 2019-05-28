package com.tencent.mm.modelstat;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.jsapi.k.a;
import com.tencent.mm.plugin.appbrand.jsapi.storage.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.view.d;
import com.tencent.wcdb.database.SQLiteGlobal;

public final class n {
    static {
        AppMethodBeat.i(78767);
        bn.reset();
        AppMethodBeat.o(78767);
    }

    public static void cm(int i, int i2) {
        AppMethodBeat.i(78763);
        if (ab.ch(ah.getContext())) {
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            I(i, i2, 0);
            AppMethodBeat.o(78763);
            return;
        }
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        J(i, i2, 0);
        AppMethodBeat.o(78763);
    }

    public static void I(int i, int i2, int i3) {
        AppMethodBeat.i(78764);
        k kVar = new k();
        kVar.fTj = i;
        kVar.fTv = i2;
        kVar.bJt = 8390656;
        c(kVar);
        a(kVar, i3);
        q.aks().a(kVar);
        AppMethodBeat.o(78764);
    }

    public static void J(int i, int i2, int i3) {
        AppMethodBeat.i(78765);
        k kVar = new k();
        kVar.fTi = i;
        kVar.fTu = i2;
        kVar.bJt = 4195328;
        c(kVar);
        a(kVar, i3);
        q.aks().a(kVar);
        AppMethodBeat.o(78765);
    }

    private static void c(k kVar) {
        AppMethodBeat.i(78766);
        bn.update();
        kVar.fTk = (int) bn.dpx();
        kVar.fTw = (int) bn.dpw();
        kVar.fTl = (int) bn.dpv();
        kVar.fTx = (int) bn.dpu();
        kVar.fTy = (int) bn.mv(0);
        kVar.fTA = (int) bn.mu(0);
        kVar.fTz = (int) bn.dpy();
        kVar.fTB = (int) bn.mt(0);
        kVar.bJt = (((((((kVar.bJt | Utility.DEFAULT_STREAM_BUFFER_SIZE) | 33554432) | 4096) | 16777216) | 134217728) | 536870912) | 67108864) | 268435456;
        AppMethodBeat.o(78766);
    }

    private static void a(k kVar, int i) {
        switch (i) {
            case 109:
            case 123:
                kVar.fTd = kVar.fTi + kVar.fTj;
                kVar.bJt |= 32;
                return;
            case 110:
                kVar.fTp = kVar.fTu + kVar.fTv;
                kVar.bJt |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                return;
            case d.MIC_SketchMark /*127*/:
                kVar.fTr = kVar.fTu + kVar.fTv;
                kVar.bJt |= SQLiteGlobal.journalSizeLimit;
                return;
            case 128:
                kVar.fTf = kVar.fTi + kVar.fTj;
                kVar.bJt |= 128;
                return;
            case 138:
            case a.CTRL_INDEX /*139*/:
                kVar.fTb = kVar.fTi + kVar.fTj;
                kVar.bJt |= 8;
                return;
            case 149:
                kVar.fTt = kVar.fTu + kVar.fTv;
                kVar.bJt |= 2097152;
                return;
            case 150:
                kVar.fTh = kVar.fTi + kVar.fTj;
                kVar.bJt |= 512;
                return;
            case c.CTRL_INDEX /*522*/:
                kVar.fTn = kVar.fTu + kVar.fTv;
                kVar.bJt |= 32768;
                return;
            default:
                return;
        }
    }
}
