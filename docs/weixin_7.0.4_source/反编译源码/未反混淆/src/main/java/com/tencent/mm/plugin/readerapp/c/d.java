package com.tencent.mm.plugin.readerapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

public final class d extends c<ng> {
    public d() {
        AppMethodBeat.i(76759);
        this.xxI = ng.class.getName().hashCode();
        AppMethodBeat.o(76759);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(76760);
        ng ngVar = (ng) bVar;
        switch (ngVar.cJw.opType) {
            case 3:
                boolean a;
                ng.b bVar2 = ngVar.cJx;
                cl clVar = ngVar.cJw.cJy;
                int i = ngVar.cJw.cJz;
                ab.i("MicroMsg.Sns.GetFavDataSource", "fav info, newsSvrid is %d, tweetId is %s", Integer.valueOf(i), ngVar.cJw.cJA);
                List fn = g.cdZ().fn((long) i);
                if (!fn.isEmpty()) {
                    ab.i("MicroMsg.Sns.GetFavDataSource", "fav news msgs");
                    String bc = bo.bc(r1, "");
                    for (int i2 = 0; i2 < fn.size(); i2++) {
                        if (bc.equals(((bl) fn.get(i2)).aaj())) {
                            a = b.a(clVar, (bl) fn.get(i2), i2);
                            bVar2.cvi = a;
                            break;
                        }
                    }
                }
                clVar.cvA.cvG = R.string.boh;
                a = false;
                bVar2.cvi = a;
            case 4:
                g.cdZ().kJ(ngVar.cJw.cJB);
                break;
        }
        AppMethodBeat.o(76760);
        return false;
    }
}
