package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C43799ad;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.h */
public final class C22567h extends C7563j<C43799ad> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C43799ad.ccO, "WalletPrefInfo")};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(47083);
        AppMethodBeat.m2505o(47083);
    }

    public C22567h(C4927e c4927e) {
        super(c4927e, C43799ad.ccO, "WalletPrefInfo", null);
        this.bSd = c4927e;
    }

    public final C43799ad acO(String str) {
        C43799ad c43799ad = null;
        AppMethodBeat.m2504i(47081);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47081);
        } else {
            Cursor a = this.bSd.mo10104a("select * from WalletPrefInfo where pref_key=?", new String[]{str}, 2);
            if (a == null) {
                AppMethodBeat.m2505o(47081);
            } else {
                if (a.moveToFirst()) {
                    c43799ad = new C43799ad();
                    c43799ad.mo8995d(a);
                }
                a.close();
                AppMethodBeat.m2505o(47081);
            }
        }
        return c43799ad;
    }

    public final boolean acP(String str) {
        AppMethodBeat.m2504i(47082);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(47082);
            return false;
        }
        boolean hY = this.bSd.mo10108hY("WalletPrefInfo", "delete from WalletPrefInfo where pref_key='" + str + "'");
        AppMethodBeat.m2505o(47082);
        return hY;
    }
}
