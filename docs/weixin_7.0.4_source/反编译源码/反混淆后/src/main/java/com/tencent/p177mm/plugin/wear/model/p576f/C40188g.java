package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.C43845h;
import com.tencent.p177mm.plugin.wear.model.p1662c.C46393a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.ctx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C7620bi;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.f.g */
public final class C40188g extends C14413b {
    private C7620bi cKd;

    public C40188g(C7620bi c7620bi) {
        this.cKd = c7620bi;
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26445);
        ctx ctx = new ctx();
        String str = this.cKd.field_content;
        if (str != null) {
            C8910b X = C8910b.m16058X(str, this.cKd.field_reserved);
            if (X == null || !X.fhZ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao")) {
                C4990ab.m7416i("MicroMsg.Wear.WearLuckyCreateTask", "biz c2c message, do not send to watch!");
                AppMethodBeat.m2505o(26445);
                return;
            }
            ctx.vIs = this.cKd.field_msgId;
            ctx.wyw = this.cKd.field_talker;
            str = this.cKd.field_isSend == 1 ? X.fhT : X.fhS;
            ctx.Title = C43845h.adw(this.cKd.field_talker);
            if (C1855t.m3896kH(this.cKd.field_talker)) {
                String c = C14413b.m22632c(this.cKd.field_talker, this.cKd);
                ctx.ncM = String.format(C4996ah.getContext().getString(C25738R.string.d9m), new Object[]{C43845h.adw(c), Character.valueOf(8203), str});
            } else {
                ctx.ncM = str;
            }
            try {
                C43841a.cUn();
                C40185r.m68920b(20014, ctx.toByteArray(), true);
                C46393a.m87276gn(10, 0);
                C46393a.m87275HH(10);
                AppMethodBeat.m2505o(26445);
                return;
            } catch (IOException e) {
                AppMethodBeat.m2505o(26445);
                return;
            }
        }
        C4990ab.m7420w("MicroMsg.Wear.WearLuckyCreateTask", "xml is null!");
        AppMethodBeat.m2505o(26445);
    }

    public final String getName() {
        return "WearLuckyCreateTask";
    }
}
