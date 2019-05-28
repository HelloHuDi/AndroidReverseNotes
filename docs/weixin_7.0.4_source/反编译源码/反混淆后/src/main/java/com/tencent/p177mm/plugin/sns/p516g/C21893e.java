package com.tencent.p177mm.plugin.sns.p516g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.sns.g.e */
public final class C21893e {
    /* renamed from: YB */
    public static void m33453YB(String str) {
        AppMethodBeat.m2504i(36804);
        C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(str)));
        C5141c ll = C18624c.abi().mo17131ll(str);
        if (!ll.isValid()) {
            C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (ll.dru() != null) {
            C4990ab.m7416i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + ll.field_rawXML);
        }
        AppMethodBeat.m2505o(36804);
    }
}
