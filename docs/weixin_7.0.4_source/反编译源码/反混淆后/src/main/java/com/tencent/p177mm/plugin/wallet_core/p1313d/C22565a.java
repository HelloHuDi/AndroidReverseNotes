package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C40114n;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.a */
public final class C22565a extends C7563j<C40114n> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C40114n.ccO, "LoanEntryInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(47049);
        AppMethodBeat.m2505o(47049);
    }

    public C22565a(C4927e c4927e) {
        super(c4927e, C40114n.ccO, "LoanEntryInfo", null);
        this.bSd = c4927e;
    }

    public final C40114n cQZ() {
        C40114n c40114n = null;
        AppMethodBeat.m2504i(47047);
        Cursor a = this.bSd.mo10104a("select * from LoanEntryInfo", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47047);
        } else {
            if (a.moveToFirst()) {
                c40114n = new C40114n();
                c40114n.mo8995d(a);
            }
            a.close();
            AppMethodBeat.m2505o(47047);
        }
        return c40114n;
    }

    public final boolean apM() {
        AppMethodBeat.m2504i(47048);
        boolean hY = this.bSd.mo10108hY("LoanEntryInfo", "delete from LoanEntryInfo");
        AppMethodBeat.m2505o(47048);
        return hY;
    }
}
