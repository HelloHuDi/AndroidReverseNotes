package com.tencent.p177mm.plugin.p1617o;

import android.content.Context;
import android.graphics.Typeface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.pluginsdk.wallet.C30158b.C30159a;
import com.tencent.p177mm.protocal.protobuf.biv;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.p649c.C24156o;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.o.a */
public final class C43352a implements C30158b {
    /* renamed from: ex */
    public final Typeface mo48438ex(Context context) {
        AppMethodBeat.m2504i(55855);
        Typeface ex = C36391e.m60009ex(context);
        AppMethodBeat.m2505o(55855);
        return ex;
    }

    /* renamed from: a */
    public final void mo48435a(Map<String, Object> map, String str, String str2, int i, C30159a c30159a) {
        AppMethodBeat.m2504i(55856);
        C4990ab.m7416i("MicroMsg.WxPaySevice", "start jsapi securetunnel");
        C1207m c24156o = new C24156o(map, str, str2, i, c30159a);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c24156o, 0);
        AppMethodBeat.m2505o(55856);
    }

    public final biv bQO() {
        AppMethodBeat.m2504i(55857);
        biv bQO = C22594k.bQO();
        AppMethodBeat.m2505o(55857);
        return bQO;
    }

    /* renamed from: eA */
    public final void mo48437eA(int i, int i2) {
        AppMethodBeat.m2504i(55858);
        C4990ab.m7417i("MicroMsg.WxPaySevice", "reportLocation %s %s", Integer.valueOf(i), Integer.valueOf(i2));
        C22594k.m34292Hp(i);
        if (C22594k.cPy() != null) {
            C7060h.pYm.mo8381e(17162, Integer.valueOf(i2), C22594k.cPy().vCI, C22594k.cPy().vCH, C22594k.cPy().vCJ);
        }
        AppMethodBeat.m2505o(55858);
    }
}
