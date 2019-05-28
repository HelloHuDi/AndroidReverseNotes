package com.tencent.p177mm.plugin.wallet_core.p1313d;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet_core.model.C22583ab;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.wallet_core.d.g */
public final class C22566g extends C7563j<C22583ab> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C22583ab.ccO, "WalletLuckyMoney")};
    public static Map<String, C22583ab> gms = new HashMap();
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(47080);
        AppMethodBeat.m2505o(47080);
    }

    public C22566g(C4927e c4927e) {
        super(c4927e, C22583ab.ccO, "WalletLuckyMoney", null);
        this.bSd = c4927e;
    }

    public final C22583ab acN(String str) {
        AppMethodBeat.m2504i(47077);
        Cursor rawQuery = this.bSd.rawQuery("select * from WalletLuckyMoney where mNativeUrl=?", new String[]{str});
        if (rawQuery == null) {
            AppMethodBeat.m2505o(47077);
            return null;
        } else if (rawQuery.getCount() == 0) {
            rawQuery.close();
            AppMethodBeat.m2505o(47077);
            return null;
        } else {
            rawQuery.moveToFirst();
            C22583ab c22583ab = new C22583ab();
            c22583ab.mo8995d(rawQuery);
            rawQuery.close();
            AppMethodBeat.m2505o(47077);
            return c22583ab;
        }
    }

    /* renamed from: a */
    public final boolean mo38091a(C22583ab c22583ab) {
        AppMethodBeat.m2504i(47078);
        if (c22583ab != null && gms.containsKey(c22583ab.field_mNativeUrl)) {
            gms.put(c22583ab.field_mNativeUrl, c22583ab);
        }
        boolean a = super.mo10099a(c22583ab);
        AppMethodBeat.m2505o(47078);
        return a;
    }
}
