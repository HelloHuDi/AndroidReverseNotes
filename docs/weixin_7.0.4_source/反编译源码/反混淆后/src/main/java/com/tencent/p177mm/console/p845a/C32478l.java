package com.tencent.p177mm.console.p845a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.console.a.l */
public final class C32478l implements C44041a {
    static {
        AppMethodBeat.m2504i(16147);
        C44042b.m79163a(new C32478l(), "//pay");
        AppMethodBeat.m2505o(16147);
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16146);
        if (strArr.length < 2) {
            AppMethodBeat.m2505o(16146);
            return true;
        }
        String str2 = strArr[1];
        int i = -1;
        switch (str2.hashCode()) {
            case -1943286194:
                if (str2.equals("forcenewcashier")) {
                    i = 3;
                    break;
                }
                break;
            case -1326045846:
                if (str2.equals("dorder")) {
                    i = 0;
                    break;
                }
                break;
            case 99657:
                if (str2.equals("dot")) {
                    i = 2;
                    break;
                }
                break;
            case 174797075:
                if (str2.equals("sethassource")) {
                    boolean i2 = true;
                    break;
                }
                break;
        }
        switch (i2) {
            case 0:
                C25985d.m41448H(context, "wallet", ".pwd.ui.WalletUniversalPayOrderUI");
                AppMethodBeat.m2505o(16146);
                return true;
            case 1:
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_LUCKY_MONEY_ENVELOPE_HAS_SOURCE_INT_SYNC, Integer.valueOf(1));
                AppMethodBeat.m2505o(16146);
                return true;
            case 2:
                C16112c.m24429PK().mo28548b(C5127a.USERINFO_WALLET_New_MY_ENTRY_TAB_REDDOT_STRING_SYNC, true);
                AppMethodBeat.m2505o(16146);
                return true;
            case 3:
                if (strArr.length >= 3) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_FORCE_USE_NEW_CASHIER_INT_SYNC, Integer.valueOf(C5046bo.getInt(strArr[2], 0)));
                }
                AppMethodBeat.m2505o(16146);
                return true;
            default:
                AppMethodBeat.m2505o(16146);
                return false;
        }
    }

    public static void init() {
    }
}
