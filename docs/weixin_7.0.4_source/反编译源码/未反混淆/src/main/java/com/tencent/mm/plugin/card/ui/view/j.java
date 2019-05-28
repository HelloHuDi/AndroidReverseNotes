package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class j extends g {
    public final boolean f(b bVar) {
        AppMethodBeat.i(88747);
        if (this.kaS == null) {
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(88747);
            return true;
        } else if (bVar == null) {
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(88747);
            return false;
        } else {
            String str = this.kaS.aZW().code;
            String str2 = bVar.aZW().code;
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || str.equals(str2)) {
                AppMethodBeat.o(88747);
                return false;
            }
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            AppMethodBeat.o(88747);
            return true;
        }
    }

    public final String e(c cVar) {
        AppMethodBeat.i(88748);
        String str = this.kaS.aZW().code;
        AppMethodBeat.o(88748);
        return str;
    }

    public final ab bey() {
        AppMethodBeat.i(88749);
        v vVar = new v(this, this.jiE);
        AppMethodBeat.o(88749);
        return vVar;
    }

    public final ab bez() {
        AppMethodBeat.i(88750);
        f fVar = new f(this, this.jiE);
        AppMethodBeat.o(88750);
        return fVar;
    }

    public final ab beA() {
        AppMethodBeat.i(88751);
        t tVar = new t(this, this.jiE);
        AppMethodBeat.o(88751);
        return tVar;
    }
}
