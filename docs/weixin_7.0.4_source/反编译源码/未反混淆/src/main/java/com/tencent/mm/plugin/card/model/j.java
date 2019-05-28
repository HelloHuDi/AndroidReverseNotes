package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;

public final class j extends com.tencent.mm.sdk.e.j<i> {
    public static final String[] fnj = new String[]{com.tencent.mm.sdk.e.j.a(i.ccO, "CardQrCodeConfi")};
    private e bSd;

    static {
        AppMethodBeat.i(87841);
        AppMethodBeat.o(87841);
    }

    public j(e eVar) {
        super(eVar, i.ccO, "CardQrCodeConfi", null);
        this.bSd = eVar;
    }

    public final i Gv(String str) {
        AppMethodBeat.i(87840);
        i iVar = new i();
        iVar.field_card_id = str;
        if (b((c) iVar, new String[0])) {
            AppMethodBeat.o(87840);
            return iVar;
        }
        AppMethodBeat.o(87840);
        return null;
    }
}
