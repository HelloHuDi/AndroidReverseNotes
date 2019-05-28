package com.tencent.p177mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.card.model.j */
public final class C7603j extends C7563j<C20149i> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C20149i.ccO, "CardQrCodeConfi")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(87841);
        AppMethodBeat.m2505o(87841);
    }

    public C7603j(C4927e c4927e) {
        super(c4927e, C20149i.ccO, "CardQrCodeConfi", null);
        this.bSd = c4927e;
    }

    /* renamed from: Gv */
    public final C20149i mo17030Gv(String str) {
        AppMethodBeat.m2504i(87840);
        C20149i c20149i = new C20149i();
        c20149i.field_card_id = str;
        if (mo10102b((C4925c) c20149i, new String[0])) {
            AppMethodBeat.m2505o(87840);
            return c20149i;
        }
        AppMethodBeat.m2505o(87840);
        return null;
    }
}
