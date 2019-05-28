package com.tencent.mm.plugin.sns.ui.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.sdk.platformtools.ab;

public final class c extends a {
    public c() {
        super(new n());
        AppMethodBeat.i(39954);
        dLZ();
        AppMethodBeat.o(39954);
    }

    public final String w(long j, String str) {
        AppMethodBeat.i(39955);
        ab.d("MicroMsg.SnsTimeLineVending", "updateLitmitSeq %s %s", Integer.valueOf(af.cnv().cod()), str);
        String jW = i.jW(af.cnF().g(j, str.equals("") ? af.cnv().cod() / 2 : af.cnv().cod(), false));
        String cuP = cuP();
        if (!cuP.equals("") && jW.compareTo(cuP) >= 0) {
            jW = cuP;
        }
        aao cqL = af.cnJ().YX("@__weixintimtline").cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.o(39955);
            return jW;
        }
        cuP = i.jW(cqL.wfM);
        if (jW.equals("")) {
            AppMethodBeat.o(39955);
            return cuP;
        } else if (cuP.compareTo(jW) > 0) {
            AppMethodBeat.o(39955);
            return cuP;
        } else {
            AppMethodBeat.o(39955);
            return jW;
        }
    }
}
