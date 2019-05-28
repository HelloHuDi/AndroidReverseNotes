package com.tencent.p177mm.plugin.wallet.pay.p554a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C14159d;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C22531f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C24863k;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C29596c;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C29597e;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C40075a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C43773h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C43774i;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C43775j;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p1048d.C46350g;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C14157b;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C16915h;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C16916i;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C16917j;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C29592a;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C29593c;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C35442l;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C35443m;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C35444n;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C40069d;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C40070f;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C4362k;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C46346e;
import com.tencent.p177mm.plugin.wallet.pay.p554a.p555a.C46347g;
import com.tencent.p177mm.plugin.wallet_core.model.Authen;
import com.tencent.p177mm.plugin.wallet_core.model.C14264s;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet.pay.a.a */
public final class C40071a {
    /* renamed from: a */
    public static C14157b m68666a(Authen authen, Orders orders, boolean z) {
        AppMethodBeat.m2504i(45907);
        if (authen == null || orders == null) {
            C4990ab.m7416i("MicroMsg.CgiManager", "empty authen or orders");
            AppMethodBeat.m2505o(45907);
            return null;
        }
        PayInfo payInfo = authen.pGr;
        String str = "";
        if (payInfo != null) {
            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.czZ;
        }
        if (C5046bo.isNullOrNil(str) && orders != null) {
            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.czZ;
        }
        C14157b c14157b;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.CgiManager", "empty reqKey!");
            c14157b = new C14157b(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        }
        C4990ab.m7417i("MicroMsg.CgiManager", "authen reqKey: %s", str);
        if (!(payInfo == null || orders == null)) {
            C4990ab.m7411d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
        }
        C4990ab.m7416i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            c14157b = new C29592a(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("sns_tf_")) {
            c14157b = new C35443m(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("sns_ff_")) {
            c14157b = new C46346e(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("ts_")) {
            c14157b = new C46347g(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("sns_")) {
            c14157b = new C16917j(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("offline_")) {
            c14157b = new C16915h(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("up_")) {
            c14157b = new C35444n(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("seb_ff_")) {
            c14157b = new C16916i(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("tax_")) {
            c14157b = new C35442l(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else if (str.startsWith("dc_")) {
            c14157b = new C40069d(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        } else {
            c14157b = new C14157b(authen, orders, z);
            AppMethodBeat.m2505o(45907);
            return c14157b;
        }
    }

    /* renamed from: a */
    public static C22531f m68667a(C14264s c14264s, Orders orders) {
        AppMethodBeat.m2504i(45908);
        if (c14264s == null || orders == null) {
            C4990ab.m7412e("MicroMsg.CgiManager", "empty verify or orders");
            AppMethodBeat.m2505o(45908);
            return null;
        }
        PayInfo payInfo = c14264s.pGr;
        String str = "";
        if (payInfo != null) {
            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.czZ;
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.czZ;
        }
        C22531f c22531f;
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.CgiManager", "empty reqKey!");
            c22531f = new C22531f(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        }
        if (payInfo != null) {
            C4990ab.m7411d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
        }
        C4990ab.m7417i("MicroMsg.CgiManager", "verify reqKey: %s", str);
        C4990ab.m7416i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            c22531f = new C40075a(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("sns_tf_")) {
            c22531f = new C43775j(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("sns_ff_")) {
            c22531f = new C14159d(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("ts_")) {
            c22531f = new C29597e(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("sns_")) {
            c22531f = new C43773h(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("up_")) {
            c22531f = new C24863k(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("seb_ff_")) {
            c22531f = new C46350g(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("tax_")) {
            c22531f = new C43774i(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else if (str.startsWith("dc_")) {
            c22531f = new C29596c(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        } else {
            c22531f = new C22531f(c14264s, orders);
            AppMethodBeat.m2505o(45908);
            return c22531f;
        }
    }

    /* renamed from: b */
    public static C29593c m68668b(Authen authen, Orders orders, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.m2504i(45909);
        C46332s.cNC();
        if (C46332s.cND().tCZ == null || authen.pGr == null || z) {
            z2 = false;
            z3 = false;
        } else if (authen.pGr.cIf == 31 || authen.pGr.cIf == 32 || authen.pGr.cIf == 33 || authen.pGr.cIf == 42 || authen.pGr.cIf == 37) {
            z2 = false;
            z3 = true;
        } else {
            z2 = true;
            z3 = false;
        }
        C4990ab.m7417i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        C29593c c40070f;
        if (z3) {
            C4362k c4362k = new C4362k(authen, orders, z);
            AppMethodBeat.m2505o(45909);
            return c4362k;
        } else if (z2) {
            c40070f = new C40070f(authen, orders, z);
            AppMethodBeat.m2505o(45909);
            return c40070f;
        } else {
            c40070f = new C29593c(authen, orders, z);
            AppMethodBeat.m2505o(45909);
            return c40070f;
        }
    }
}
