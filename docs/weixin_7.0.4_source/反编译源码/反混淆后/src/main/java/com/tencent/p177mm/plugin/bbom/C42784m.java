package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p184aj.C17903f;
import com.tencent.p177mm.p184aj.p185a.C25754e;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12527m;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C46071g;
import com.tencent.p177mm.protocal.protobuf.bbe;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.bbom.m */
public final class C42784m implements C46071g, C12527m {
    /* renamed from: a */
    public final void mo24450a(bbe bbe, C7620bi c7620bi) {
        AppMethodBeat.m2504i(18269);
        if (C17903f.m28103kq(c7620bi.field_talker)) {
            bbe.vEG = c7620bi.dqJ;
            if (C5046bo.isNullOrNil(bbe.vEG)) {
                bbe.vEG = C25754e.m40909rw(c7620bi.dqJ);
                AppMethodBeat.m2505o(18269);
                return;
            }
        }
        bbe.vEG = c7620bi.dqJ;
        AppMethodBeat.m2505o(18269);
    }

    /* renamed from: B */
    public final String mo68249B(C7620bi c7620bi) {
        AppMethodBeat.m2504i(18270);
        if (C17903f.m28103kq(c7620bi.field_talker)) {
            String aae = C25754e.aae();
            AppMethodBeat.m2505o(18270);
            return aae;
        }
        AppMethodBeat.m2505o(18270);
        return null;
    }
}
