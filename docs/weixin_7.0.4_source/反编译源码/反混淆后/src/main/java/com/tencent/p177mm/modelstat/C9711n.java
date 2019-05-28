package com.tencent.p177mm.modelstat;

import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19482c;
import com.tencent.p177mm.sdk.platformtools.C15427bn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.view.C31128d;
import com.tencent.wcdb.database.SQLiteGlobal;

/* renamed from: com.tencent.mm.modelstat.n */
public final class C9711n {
    static {
        AppMethodBeat.m2504i(78767);
        C15427bn.reset();
        AppMethodBeat.m2505o(78767);
    }

    /* renamed from: cm */
    public static void m17287cm(int i, int i2) {
        AppMethodBeat.m2504i(78763);
        if (C32856ab.m53750ch(C4996ah.getContext())) {
            C4990ab.m7417i("MicroMsg.NetStatStorageLogic", "dknetflow wifi recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
            C9711n.m17283I(i, i2, 0);
            AppMethodBeat.m2505o(78763);
            return;
        }
        C4990ab.m7417i("MicroMsg.NetStatStorageLogic", "dknetflow mobile recv:%d send:%d type:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(0));
        C9711n.m17284J(i, i2, 0);
        AppMethodBeat.m2505o(78763);
    }

    /* renamed from: I */
    public static void m17283I(int i, int i2, int i3) {
        AppMethodBeat.m2504i(78764);
        C42223k c42223k = new C42223k();
        c42223k.fTj = i;
        c42223k.fTv = i2;
        c42223k.bJt = 8390656;
        C9711n.m17286c(c42223k);
        C9711n.m17285a(c42223k, i3);
        C42225q.aks().mo51237a(c42223k);
        AppMethodBeat.m2505o(78764);
    }

    /* renamed from: J */
    public static void m17284J(int i, int i2, int i3) {
        AppMethodBeat.m2504i(78765);
        C42223k c42223k = new C42223k();
        c42223k.fTi = i;
        c42223k.fTu = i2;
        c42223k.bJt = 4195328;
        C9711n.m17286c(c42223k);
        C9711n.m17285a(c42223k, i3);
        C42225q.aks().mo51237a(c42223k);
        AppMethodBeat.m2505o(78765);
    }

    /* renamed from: c */
    private static void m17286c(C42223k c42223k) {
        AppMethodBeat.m2504i(78766);
        C15427bn.update();
        c42223k.fTk = (int) C15427bn.dpx();
        c42223k.fTw = (int) C15427bn.dpw();
        c42223k.fTl = (int) C15427bn.dpv();
        c42223k.fTx = (int) C15427bn.dpu();
        c42223k.fTy = (int) C15427bn.m23707mv(0);
        c42223k.fTA = (int) C15427bn.m23706mu(0);
        c42223k.fTz = (int) C15427bn.dpy();
        c42223k.fTB = (int) C15427bn.m23705mt(0);
        c42223k.bJt = (((((((c42223k.bJt | Utility.DEFAULT_STREAM_BUFFER_SIZE) | 33554432) | 4096) | 16777216) | 134217728) | 536870912) | 67108864) | 268435456;
        AppMethodBeat.m2505o(78766);
    }

    /* renamed from: a */
    private static void m17285a(C42223k c42223k, int i) {
        switch (i) {
            case 109:
            case 123:
                c42223k.fTd = c42223k.fTi + c42223k.fTj;
                c42223k.bJt |= 32;
                return;
            case 110:
                c42223k.fTp = c42223k.fTu + c42223k.fTv;
                c42223k.bJt |= WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
                return;
            case C31128d.MIC_SketchMark /*127*/:
                c42223k.fTr = c42223k.fTu + c42223k.fTv;
                c42223k.bJt |= SQLiteGlobal.journalSizeLimit;
                return;
            case 128:
                c42223k.fTf = c42223k.fTi + c42223k.fTj;
                c42223k.bJt |= 128;
                return;
            case 138:
            case C33333a.CTRL_INDEX /*139*/:
                c42223k.fTb = c42223k.fTi + c42223k.fTj;
                c42223k.bJt |= 8;
                return;
            case 149:
                c42223k.fTt = c42223k.fTu + c42223k.fTv;
                c42223k.bJt |= 2097152;
                return;
            case 150:
                c42223k.fTh = c42223k.fTi + c42223k.fTj;
                c42223k.bJt |= 512;
                return;
            case C19482c.CTRL_INDEX /*522*/:
                c42223k.fTn = c42223k.fTu + c42223k.fTv;
                c42223k.bJt |= 32768;
                return;
            default:
                return;
        }
    }
}
