package com.tencent.mm.plugin.sns.ui.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.protocal.protobuf.aao;
import com.tencent.mm.sdk.platformtools.ab;

public final class d extends a {
    public boolean czr;
    public String userName;

    public d(String str, boolean z) {
        super(new n());
        AppMethodBeat.i(39956);
        this.userName = str;
        this.czr = z;
        dLZ();
        AppMethodBeat.o(39956);
    }

    public final Cursor cuR() {
        boolean z;
        AppMethodBeat.i(39957);
        init();
        g.RQ();
        if (this.userName.equals((String) g.RP().Ry().get(2, null))) {
            z = true;
        } else {
            z = false;
        }
        ab.d("MicroMsg.SnsUserPageVending", "prepareCursorAsynchronous");
        Cursor e = af.cnF().e(this.userName, z, cuO());
        AppMethodBeat.o(39957);
        return e;
    }

    public final String w(long j, String str) {
        AppMethodBeat.i(39958);
        ab.d("MicroMsg.SnsUserPageVending", "updateLitmitSeq %s %s", Integer.valueOf(af.cnv().cod()), str);
        String jW = i.jW(af.cnF().a(j, af.cnv().Yc(this.userName), this.userName, this.czr));
        if (!this.rmL.equals("") && jW.compareTo(this.rmL) >= 0) {
            jW = this.rmL;
        }
        aao cqL = af.cnJ().YX(this.userName).cqL();
        if (cqL.wfM == 0) {
            AppMethodBeat.o(39958);
            return jW;
        }
        String jW2 = i.jW(cqL.wfM);
        if (jW.equals("")) {
            AppMethodBeat.o(39958);
            return jW2;
        } else if (jW2.compareTo(jW) > 0) {
            AppMethodBeat.o(39958);
            return jW2;
        } else {
            AppMethodBeat.o(39958);
            return jW;
        }
    }
}
