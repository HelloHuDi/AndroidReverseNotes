package com.tencent.p177mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.hellhound.core.p1258a.C20599b;
import com.tencent.p177mm.protocal.protobuf.C44102bf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.stack.c */
public final class C27895c {
    public static C44102bf bqs() {
        AppMethodBeat.m2504i(73359);
        C44102bf bqt = C27895c.bqt();
        if (bqt == null) {
            bqt = new C44102bf();
            C27895c.m44357a(bqt);
        }
        AppMethodBeat.m2505o(73359);
        return bqt;
    }

    /* renamed from: a */
    public static void m44357a(C44102bf c44102bf) {
        AppMethodBeat.m2504i(73360);
        if (c44102bf == null) {
            AppMethodBeat.m2505o(73360);
            return;
        }
        byte[] bArr = null;
        try {
            bArr = c44102bf.toByteArray();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ActivityStackDao", e, "ActivityStackDao write", new Object[0]);
        }
        C20599b.m31826v("hell_astackd_mmkv_key", bArr);
        AppMethodBeat.m2505o(73360);
    }

    private static C44102bf bqt() {
        AppMethodBeat.m2504i(73361);
        byte[] bytes = C20599b.getBytes("hell_astackd_mmkv_key");
        if (bytes == null || bytes.length <= 0) {
            AppMethodBeat.m2505o(73361);
            return null;
        }
        C44102bf c44102bf = new C44102bf();
        try {
            c44102bf.parseFrom(bytes);
            AppMethodBeat.m2505o(73361);
            return c44102bf;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("ActivityStackDao", e, "ActivityStackDao read", new Object[0]);
            AppMethodBeat.m2505o(73361);
            return null;
        }
    }
}
