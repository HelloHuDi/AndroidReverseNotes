package com.tencent.mm.plugin.card.ui.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class q extends g {
    public String knw = "";

    public final boolean f(b bVar) {
        AppMethodBeat.i(88775);
        if (this.kaS == null) {
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain mCardInfo is null！");
            AppMethodBeat.o(88775);
            return true;
        } else if (bVar == null) {
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain false  newCardInfo null！");
            AppMethodBeat.o(88775);
            return false;
        } else {
            String str = this.kaS.aZW().code;
            String str2 = bVar.aZW().code;
            if (bo.isNullOrNil(str) || bo.isNullOrNil(str2) || str.equals(str2)) {
                tm tmVar = this.kaS.aZV().vUA;
                tm tmVar2 = bVar.aZV().vUA;
                if ((tmVar == null && tmVar2 != null) || (tmVar != null && tmVar2 == null)) {
                    ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field  is diffrent！");
                    AppMethodBeat.o(88775);
                    return true;
                } else if (tmVar != null && tmVar2 != null && tmVar.title != null && tmVar2.title != null && !tmVar.title.equals(tmVar2.title)) {
                    ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field title is diffrent！");
                    AppMethodBeat.o(88775);
                    return true;
                } else if (tmVar != null && tmVar2 != null && tmVar.kbX != null && tmVar2.kbX != null && !tmVar.kbX.equals(tmVar2.kbX)) {
                    ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain pay_and_qrcode_field aux_title  is diffrent！");
                    AppMethodBeat.o(88775);
                    return true;
                } else if (!this.kaS.aZQ() || bo.isNullOrNil(this.knw)) {
                    AppMethodBeat.o(88775);
                    return false;
                } else {
                    ab.i("MicroMsg.CardCodeView", "dynamicCode updated！");
                    AppMethodBeat.o(88775);
                    return true;
                }
            }
            ab.i("MicroMsg.CardCodeView", "isNeedUpdateViewAgain   code  is diffrent！");
            AppMethodBeat.o(88775);
            return true;
        }
    }

    public final String e(c cVar) {
        AppMethodBeat.i(88776);
        String str;
        if (!bo.isNullOrNil(this.kaS.aZW().vSo)) {
            str = this.kaS.aZW().vSo;
            AppMethodBeat.o(88776);
            return str;
        } else if (!this.kaS.aZQ() || bo.isNullOrNil(this.knw)) {
            str = this.kaS.aZW().code;
            AppMethodBeat.o(88776);
            return str;
        } else {
            str = this.knw;
            AppMethodBeat.o(88776);
            return str;
        }
    }

    public final ab bey() {
        AppMethodBeat.i(88777);
        s sVar = new s(this, this.jiE);
        AppMethodBeat.o(88777);
        return sVar;
    }

    public final ab bez() {
        AppMethodBeat.i(88778);
        p pVar = new p(this, this.jiE);
        AppMethodBeat.o(88778);
        return pVar;
    }

    public final ab beA() {
        AppMethodBeat.i(88779);
        r rVar = new r(this, this.jiE);
        AppMethodBeat.o(88779);
        return rVar;
    }
}
