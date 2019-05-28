package com.tencent.mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.protobuf.bbe;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class i implements m {
    private String jEs = null;

    public i(String str) {
        this.jEs = str;
    }

    public final void a(bbe bbe, bi biVar) {
        AppMethodBeat.i(18259);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.jEs + "\"></strangerantispamticket>");
        stringBuilder.append(bo.nullAsNil(bh.aad()));
        String str = (bo.isNullOrNil(bbe.vEG) || !bbe.vEG.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : bbe.vEG;
        bbe.vEG = str;
        bbe.vEG = bbe.vEG.replace("<msgsource>", stringBuilder.toString());
        AppMethodBeat.o(18259);
    }
}
