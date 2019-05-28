package com.tencent.mm.plugin.choosemsgfile.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.c.g;
import com.tencent.mm.plugin.s.a;
import com.tencent.mm.storage.bi;

public final class b extends g {
    private com.tencent.mm.af.j.b kul;
    private String kum;

    private com.tencent.mm.af.j.b bfv() {
        AppMethodBeat.i(54287);
        if (this.kul == null) {
            this.kul = com.tencent.mm.af.j.b.me(this.kua.field_content);
        }
        com.tencent.mm.af.j.b bVar = this.kul;
        AppMethodBeat.o(54287);
        return bVar;
    }

    public final String bfo() {
        AppMethodBeat.i(54288);
        String str;
        if (bfv() != null) {
            str = bfv().fgp;
            AppMethodBeat.o(54288);
            return str;
        }
        str = "";
        AppMethodBeat.o(54288);
        return str;
    }

    public final String getFileName() {
        AppMethodBeat.i(54289);
        String str;
        if (bfv() != null) {
            str = bfv().title;
            AppMethodBeat.o(54289);
            return str;
        }
        str = "";
        AppMethodBeat.o(54289);
        return str;
    }

    public final int bfp() {
        AppMethodBeat.i(54290);
        if (bfv() != null) {
            int i = bfv().fgo;
            AppMethodBeat.o(54290);
            return i;
        }
        AppMethodBeat.o(54290);
        return 0;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aan() {
        AppMethodBeat.i(54291);
        if (this.kum == null && bfv() != null && bfv().csD != null && bfv().csD.length() > 0) {
            com.tencent.mm.pluginsdk.model.app.b aiE = a.aUq().aiE(bfv().csD);
            if (aiE != null) {
                this.kum = aiE.field_fileFullPath;
            }
        }
        String str;
        if (this.kum != null) {
            str = this.kum;
            AppMethodBeat.o(54291);
            return str;
        }
        str = "";
        AppMethodBeat.o(54291);
        return str;
    }

    public b(g gVar, bi biVar) {
        super(gVar, biVar);
    }
}
