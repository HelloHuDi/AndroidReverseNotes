package com.tencent.p177mm.plugin.fingerprint.p413b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42005if;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tenpay.android.wechat.TenpayUtil;

/* renamed from: com.tencent.mm.plugin.fingerprint.b.g */
public final class C11926g extends C4884c<C42005if> {
    public C11926g() {
        AppMethodBeat.m2504i(41478);
        this.xxI = C42005if.class.getName().hashCode();
        AppMethodBeat.m2505o(41478);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(41479);
        C42005if c42005if = (C42005if) c4883b;
        if (c42005if != null) {
            c42005if.cDm.cDo = TenpayUtil.signWith3Des("passwd=" + c42005if.cDl.cDn);
            C4990ab.m7419v("MicroMsg.GetWcPaySignEventListener", "alvinluo wcpaysign: %s", c42005if.cDm.cDo);
        }
        AppMethodBeat.m2505o(41479);
        return false;
    }
}
