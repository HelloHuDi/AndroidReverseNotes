package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.protobuf.ctp;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.IOException;

public final class e extends c {
    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26443);
        int size = ((j) g.K(j.class)).bOr().bOC().size();
        ctp ctp = new ctp();
        ctp.ndE = a.cUn().tXv.adr(r.Yz()).id;
        ctp.Title = ah.getContext().getString(R.string.ru);
        ctp.ncM = ah.getContext().getString(R.string.d8h, new Object[]{Integer.valueOf(size)});
        try {
            a.cUn();
            com.tencent.mm.plugin.wear.model.e.r.b(20005, ctp.toByteArray(), true);
            AppMethodBeat.o(26443);
        } catch (IOException e) {
            AppMethodBeat.o(26443);
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
