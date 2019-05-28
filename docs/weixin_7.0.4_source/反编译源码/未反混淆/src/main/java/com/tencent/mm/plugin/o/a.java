package com.tencent.mm.plugin.o;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.o;
import com.tencent.mm.wallet_core.ui.e;
import java.util.Map;

public final class a implements b {
    public final Typeface ex(Context context) {
        AppMethodBeat.i(55855);
        Typeface ex = e.ex(context);
        AppMethodBeat.o(55855);
        return ex;
    }

    public final void a(Map<String, Object> map, String str, String str2, int i, com.tencent.mm.pluginsdk.wallet.b.a aVar) {
        AppMethodBeat.i(55856);
        ab.i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
        m oVar = new o(map, str, str2, i, aVar);
        g.RQ();
        g.RO().eJo.a(oVar, 0);
        AppMethodBeat.o(55856);
    }

    public final biv bQO() {
        AppMethodBeat.i(55857);
        biv bQO = k.bQO();
        AppMethodBeat.o(55857);
        return bQO;
    }

    public final void eA(int i, int i2) {
        AppMethodBeat.i(55858);
        ab.i("MicroMsg.WxPaySevice", "reportLocation %s %s", Integer.valueOf(i), Integer.valueOf(i2));
        k.Hp(i);
        if (k.cPy() != null) {
            h.pYm.e(17162, Integer.valueOf(i2), k.cPy().vCI, k.cPy().vCH, k.cPy().vCJ);
        }
        AppMethodBeat.o(55858);
    }
}
