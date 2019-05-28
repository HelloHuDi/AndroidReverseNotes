package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.a.e;
import com.tencent.mm.aj.f;
import com.tencent.mm.plugin.messenger.foundation.a.g;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class m implements g, com.tencent.mm.plugin.messenger.foundation.a.m {
    public final void a(bbe bbe, bi biVar) {
        AppMethodBeat.i(18269);
        if (f.kq(biVar.field_talker)) {
            bbe.vEG = biVar.dqJ;
            if (bo.isNullOrNil(bbe.vEG)) {
                bbe.vEG = e.rw(biVar.dqJ);
                AppMethodBeat.o(18269);
                return;
            }
        }
        bbe.vEG = biVar.dqJ;
        AppMethodBeat.o(18269);
    }

    public final String B(bi biVar) {
        AppMethodBeat.i(18270);
        if (f.kq(biVar.field_talker)) {
            String aae = e.aae();
            AppMethodBeat.o(18270);
            return aae;
        }
        AppMethodBeat.o(18270);
        return null;
    }
}
