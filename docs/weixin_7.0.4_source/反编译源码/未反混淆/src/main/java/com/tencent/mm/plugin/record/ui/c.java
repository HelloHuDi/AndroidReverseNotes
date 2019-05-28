package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ge;
import com.tencent.mm.plugin.record.ui.h.a;
import com.tencent.mm.plugin.record.ui.h.a.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements a {
    public c(Context context) {
        AppMethodBeat.i(24190);
        ge geVar = new ge();
        geVar.cAt.context = context;
        com.tencent.mm.sdk.b.a.xxA.m(geVar);
        AppMethodBeat.o(24190);
    }

    public final void a(a.a aVar) {
        AppMethodBeat.i(24191);
        ab.d("MicroMsg.FavImageServiceProxy", "attachThumb favLocalId %s", Long.valueOf(aVar.pKv));
        ge geVar = new ge();
        geVar.cAt.opType = 1;
        geVar.cAt.cAw = aVar.cAw;
        geVar.cAt.cAv = aVar.cAv;
        geVar.cAt.cvv = aVar.pKv;
        geVar.cAt.cAx = aVar.cAx;
        geVar.cAt.width = aVar.width;
        geVar.cAt.height = aVar.height;
        com.tencent.mm.sdk.b.a.xxA.m(geVar);
        AppMethodBeat.o(24191);
    }

    public final Bitmap a(com.tencent.mm.plugin.record.ui.h.a.c cVar) {
        AppMethodBeat.i(24192);
        ge geVar = new ge();
        geVar.cAt.opType = 0;
        geVar.cAt.cAv = cVar.cAv;
        geVar.cAt.cvv = cVar.pKv;
        com.tencent.mm.sdk.b.a.xxA.m(geVar);
        ab.d("MicroMsg.FavImageServiceProxy", "getThumb favLocalId %s, retBmp %s", Long.valueOf(cVar.pKv), geVar.cAu.cAB);
        Bitmap bitmap = geVar.cAu.cAB;
        AppMethodBeat.o(24192);
        return bitmap;
    }

    public final Bitmap a(b bVar) {
        AppMethodBeat.i(24193);
        ge geVar = new ge();
        geVar.cAt.opType = 2;
        geVar.cAt.cAA = false;
        if (bVar.cAy) {
            geVar.cAt.cAv = bVar.cAv;
            geVar.cAt.cAy = bVar.cAy;
        } else {
            geVar.cAt.cAv = bVar.cAv;
            geVar.cAt.cvv = bVar.pKv;
            geVar.cAt.maxWidth = bVar.maxWidth;
            geVar.cAt.cAz = bVar.cAz;
        }
        com.tencent.mm.sdk.b.a.xxA.m(geVar);
        ab.d("MicroMsg.FavImageServiceProxy", "getSuitableBigImg favLocalId %s, dataId %s, retBmp %s, fromCache", Long.valueOf(bVar.pKv), bVar.cAv.mnd, geVar.cAu.cAB, Boolean.valueOf(geVar.cAt.cAy));
        Bitmap bitmap = geVar.cAu.cAB;
        AppMethodBeat.o(24193);
        return bitmap;
    }

    public final void ceH() {
        AppMethodBeat.i(24194);
        ge geVar = new ge();
        geVar.cAt.opType = 4;
        com.tencent.mm.sdk.b.a.xxA.m(geVar);
        AppMethodBeat.o(24194);
    }
}
