package com.tencent.p177mm.plugin.expt.hellhound.p958a.p959a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import com.tencent.p177mm.protocal.protobuf.acp;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.a.a.a */
public final class C11752a {
    C11752a() {
    }

    /* renamed from: gR */
    public static void m19559gR(boolean z) {
        AppMethodBeat.m2504i(73446);
        acp bqE = C11752a.bqE();
        if (bqE == null) {
            bqE = new acp();
        }
        bqE.wkq = z;
        C4990ab.m7410d("FrontBackDao", "habbyge-mali, logout8EventFromAdd: " + bqE.wkq);
        C11752a.m19558a(bqE);
        AppMethodBeat.m2505o(73446);
    }

    /* renamed from: uY */
    public static void m19560uY(int i) {
        AppMethodBeat.m2504i(73447);
        acp bqE = C11752a.bqE();
        if (bqE == null) {
            bqE = new acp();
        }
        bqE.wkl = i;
        C4990ab.m7410d("FrontBackDao", "habbyge-mali, setFrontBackEvent_LastTime: ".concat(String.valueOf(i)));
        C11752a.m19558a(bqE);
        AppMethodBeat.m2505o(73447);
    }

    /* renamed from: a */
    static void m19558a(acp acp) {
        AppMethodBeat.m2504i(73448);
        try {
            C20599b.m31826v("hell_fntbck_pter_mmkv_key", acp.toByteArray());
            AppMethodBeat.m2505o(73448);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("FrontBackDao", e, "habbyge-mali, writeBackFrontBack", new Object[0]);
            AppMethodBeat.m2505o(73448);
        }
    }

    static acp bqE() {
        AppMethodBeat.m2504i(73449);
        byte[] bytes = C20599b.getBytes("hell_fntbck_pter_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.m2505o(73449);
            return null;
        }
        acp acp = new acp();
        try {
            acp.parseFrom(bytes);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("FrontBackDao", e, "habbyge-mali, _doReadFrontBack parse", new Object[0]);
            acp = null;
        }
        AppMethodBeat.m2505o(73449);
        return acp;
    }
}
