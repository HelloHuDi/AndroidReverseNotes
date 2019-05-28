package com.tencent.mm.plugin.order.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "OrderCommonMsgXml")};
    private e bSd;

    public final /* bridge */ /* synthetic */ boolean b(c cVar) {
        AppMethodBeat.i(43796);
        boolean b = super.b((a) cVar);
        AppMethodBeat.o(43796);
        return b;
    }

    public final /* bridge */ /* synthetic */ boolean c(c cVar, String[] strArr) {
        AppMethodBeat.i(43795);
        boolean c = super.c((a) cVar, strArr);
        AppMethodBeat.o(43795);
        return c;
    }

    static {
        AppMethodBeat.i(43797);
        AppMethodBeat.o(43797);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "OrderCommonMsgXml", null);
        this.bSd = eVar;
    }

    public final Cursor baR() {
        AppMethodBeat.i(43793);
        Cursor rawQuery = this.bSd.rawQuery("select * from OrderCommonMsgXml order by msgId desc", null);
        AppMethodBeat.o(43793);
        return rawQuery;
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(43794);
        boolean b = super.b((c) aVar);
        AppMethodBeat.o(43794);
        return b;
    }
}
