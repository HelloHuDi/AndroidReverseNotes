package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.choosemsgfile.b.d.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.vfs.e;

public class g extends d {
    private String kum;

    public g(com.tencent.mm.plugin.choosemsgfile.b.c.g gVar, bi biVar) {
        super(gVar, biVar);
    }

    /* Access modifiers changed, original: protected */
    public String aan() {
        AppMethodBeat.i(54302);
        if (this.kum == null) {
            this.kum = o.ahl().c(this.kua.field_imgPath, false, false);
            if (!(bo.isNullOrNil(this.kum) || this.kum.endsWith("hd") || !e.ct(this.kum + "hd"))) {
                this.kum += "hd";
            }
        }
        String str = this.kum;
        AppMethodBeat.o(54302);
        return str;
    }

    public final int getType() {
        return 2;
    }

    public final void a(View view, a aVar) {
        AppMethodBeat.i(54303);
        b.a(this.kuj.bfy().getContext(), view, aVar);
        AppMethodBeat.o(54303);
    }
}
