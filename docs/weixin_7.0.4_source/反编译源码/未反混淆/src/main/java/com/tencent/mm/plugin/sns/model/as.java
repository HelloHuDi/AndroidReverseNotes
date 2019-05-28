package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.g.b.a;
import java.io.OutputStream;

public final class as extends k<g, String, Boolean> {
    private String cHr;
    private String fileName;
    private String fsd;
    private OutputStream output = null;
    private String qJc;
    private String qJg = "";

    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.i(36668);
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        af.cnA().p(this.qJg, -1, true);
        AppMethodBeat.o(36668);
    }

    public final /* synthetic */ void v(Object[] objArr) {
        AppMethodBeat.i(36669);
        g[] gVarArr = (g[]) objArr;
        super.v(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.cHr = gVar.cHr;
            this.qJc = an.fZ(af.getAccSnsPath(), this.cHr);
            this.qJg = i.bd(gVar.requestType, this.cHr);
            this.fsd = "sns_tmpt_" + this.cHr;
            this.fileName = "snst_" + this.cHr;
        }
        AppMethodBeat.o(36669);
    }

    public final a cin() {
        AppMethodBeat.i(36667);
        a cnr = af.cnr();
        AppMethodBeat.o(36667);
        return cnr;
    }

    public final /* bridge */ /* synthetic */ Object dv() {
        return Boolean.TRUE;
    }
}
