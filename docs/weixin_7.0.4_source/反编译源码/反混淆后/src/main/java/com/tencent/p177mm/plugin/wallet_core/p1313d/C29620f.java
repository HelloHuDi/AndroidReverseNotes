package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C22582aa;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.f */
public final class C29620f extends C7563j<C22582aa> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C22582aa.ccO, "WalletKindInfo")};
    public C4927e bSd;

    static {
        AppMethodBeat.m2504i(47076);
        AppMethodBeat.m2505o(47076);
    }

    public C29620f(C4927e c4927e) {
        super(c4927e, C22582aa.ccO, "WalletKindInfo", null);
        this.bSd = c4927e;
    }

    public final ArrayList<C22582aa> cRg() {
        ArrayList<C22582aa> arrayList = null;
        AppMethodBeat.m2504i(47075);
        Cursor a = this.bSd.mo10104a("select * from WalletKindInfo", null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(47075);
        } else {
            if (a.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    C22582aa c22582aa = new C22582aa();
                    c22582aa.mo8995d(a);
                    arrayList.add(c22582aa);
                } while (a.moveToNext());
            }
            a.close();
            AppMethodBeat.m2505o(47075);
        }
        return arrayList;
    }
}
