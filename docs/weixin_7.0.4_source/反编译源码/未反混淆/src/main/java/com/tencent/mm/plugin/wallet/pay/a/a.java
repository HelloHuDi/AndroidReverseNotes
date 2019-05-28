package com.tencent.mm.plugin.wallet.pay.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.pay.a.a.b;
import com.tencent.mm.plugin.wallet.pay.a.a.d;
import com.tencent.mm.plugin.wallet.pay.a.a.e;
import com.tencent.mm.plugin.wallet.pay.a.a.g;
import com.tencent.mm.plugin.wallet.pay.a.a.h;
import com.tencent.mm.plugin.wallet.pay.a.a.i;
import com.tencent.mm.plugin.wallet.pay.a.a.j;
import com.tencent.mm.plugin.wallet.pay.a.a.l;
import com.tencent.mm.plugin.wallet.pay.a.a.m;
import com.tencent.mm.plugin.wallet.pay.a.a.n;
import com.tencent.mm.plugin.wallet.pay.a.d.c;
import com.tencent.mm.plugin.wallet.pay.a.d.f;
import com.tencent.mm.plugin.wallet.pay.a.d.k;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a {
    public static b a(Authen authen, Orders orders, boolean z) {
        AppMethodBeat.i(45907);
        if (authen == null || orders == null) {
            ab.i("MicroMsg.CgiManager", "empty authen or orders");
            AppMethodBeat.o(45907);
            return null;
        }
        PayInfo payInfo = authen.pGr;
        String str = "";
        if (payInfo != null) {
            ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.czZ;
        }
        if (bo.isNullOrNil(str) && orders != null) {
            ab.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.czZ;
        }
        b bVar;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.CgiManager", "empty reqKey!");
            bVar = new b(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        }
        ab.i("MicroMsg.CgiManager", "authen reqKey: %s", str);
        if (!(payInfo == null || orders == null)) {
            ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
        }
        ab.i("MicroMsg.CgiManager", "authen go new split cgi");
        if (str.startsWith("sns_aa_")) {
            bVar = new com.tencent.mm.plugin.wallet.pay.a.a.a(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("sns_tf_")) {
            bVar = new m(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("sns_ff_")) {
            bVar = new e(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("ts_")) {
            bVar = new g(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("sns_")) {
            bVar = new j(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("offline_")) {
            bVar = new h(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("up_")) {
            bVar = new n(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("seb_ff_")) {
            bVar = new i(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("tax_")) {
            bVar = new l(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else if (str.startsWith("dc_")) {
            bVar = new d(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        } else {
            bVar = new b(authen, orders, z);
            AppMethodBeat.o(45907);
            return bVar;
        }
    }

    public static f a(s sVar, Orders orders) {
        AppMethodBeat.i(45908);
        if (sVar == null || orders == null) {
            ab.e("MicroMsg.CgiManager", "empty verify or orders");
            AppMethodBeat.o(45908);
            return null;
        }
        PayInfo payInfo = sVar.pGr;
        String str = "";
        if (payInfo != null) {
            ab.i("MicroMsg.CgiManager", "get reqKey from payInfo");
            str = payInfo.czZ;
        }
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.CgiManager", "get reqKey from orders");
            str = orders.czZ;
        }
        f fVar;
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.CgiManager", "empty reqKey!");
            fVar = new f(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        }
        if (payInfo != null) {
            ab.d("MicroMsg.CgiManager", "reqKey: %s, %s", payInfo.czZ, orders.czZ);
        }
        ab.i("MicroMsg.CgiManager", "verify reqKey: %s", str);
        ab.i("MicroMsg.CgiManager", "verify go new split cgi");
        if (str.startsWith("sns_aa_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.a(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("sns_tf_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.j(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("sns_ff_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.d(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("ts_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.e(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("sns_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.h(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("up_")) {
            fVar = new k(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("seb_ff_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.g(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("tax_")) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.d.i(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else if (str.startsWith("dc_")) {
            fVar = new c(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        } else {
            fVar = new f(sVar, orders);
            AppMethodBeat.o(45908);
            return fVar;
        }
    }

    public static com.tencent.mm.plugin.wallet.pay.a.a.c b(Authen authen, Orders orders, boolean z) {
        boolean z2;
        boolean z3;
        AppMethodBeat.i(45909);
        com.tencent.mm.plugin.wallet.a.s.cNC();
        if (com.tencent.mm.plugin.wallet.a.s.cND().tCZ == null || authen.pGr == null || z) {
            z2 = false;
            z3 = false;
        } else if (authen.pGr.cIf == 31 || authen.pGr.cIf == 32 || authen.pGr.cIf == 33 || authen.pGr.cIf == 42 || authen.pGr.cIf == 37) {
            z2 = false;
            z3 = true;
        } else {
            z2 = true;
            z3 = false;
        }
        ab.i("MicroMsg.CgiManager", "isLqtSns: %s, isLqtTs: %s, isBalance: %s", Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(z));
        com.tencent.mm.plugin.wallet.pay.a.a.c fVar;
        if (z3) {
            com.tencent.mm.plugin.wallet.pay.a.a.k kVar = new com.tencent.mm.plugin.wallet.pay.a.a.k(authen, orders, z);
            AppMethodBeat.o(45909);
            return kVar;
        } else if (z2) {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.a.f(authen, orders, z);
            AppMethodBeat.o(45909);
            return fVar;
        } else {
            fVar = new com.tencent.mm.plugin.wallet.pay.a.a.c(authen, orders, z);
            AppMethodBeat.o(45909);
            return fVar;
        }
    }
}
