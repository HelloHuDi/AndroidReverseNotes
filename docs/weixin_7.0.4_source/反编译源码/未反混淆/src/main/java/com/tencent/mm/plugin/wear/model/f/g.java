package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.bi;
import java.io.IOException;

public final class g extends b {
    private bi cKd;

    public g(bi biVar) {
        this.cKd = biVar;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26445);
        ctx ctx = new ctx();
        String str = this.cKd.field_content;
        if (str != null) {
            b X = b.X(str, this.cKd.field_reserved);
            if (X == null || !X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                ab.i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                AppMethodBeat.o(26445);
                return;
            }
            ctx.vIs = this.cKd.field_msgId;
            ctx.wyw = this.cKd.field_talker;
            str = this.cKd.field_isSend == 1 ? X.fhT : X.fhS;
            ctx.Title = h.adw(this.cKd.field_talker);
            if (t.kH(this.cKd.field_talker)) {
                String c = b.c(this.cKd.field_talker, this.cKd);
                ctx.ncM = String.format(ah.getContext().getString(R.string.d9m), new Object[]{h.adw(c), Character.valueOf(8203), str});
            } else {
                ctx.ncM = str;
            }
            try {
                a.cUn();
                r.b(20014, ctx.toByteArray(), true);
                com.tencent.mm.plugin.wear.model.c.a.gn(10, 0);
                com.tencent.mm.plugin.wear.model.c.a.HH(10);
                AppMethodBeat.o(26445);
                return;
            } catch (IOException e) {
                AppMethodBeat.o(26445);
                return;
            }
        }
        ab.w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
        AppMethodBeat.o(26445);
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
