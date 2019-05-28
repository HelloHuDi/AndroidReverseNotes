package com.tencent.mm.ui.chatting;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.c.b.r;
import com.tencent.mm.ui.chatting.d.a;
import java.util.ArrayList;
import java.util.List;

public final class x implements aq {
    public a cgL;
    public aa yLx = new aa();

    public x(a aVar) {
        AppMethodBeat.i(30904);
        this.cgL = aVar;
        AppMethodBeat.o(30904);
    }

    public final void a(bi biVar) {
        AppMethodBeat.i(30905);
        if (this.cgL.aF(r.class) == null) {
            ab.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui maybe has exit!");
            AppMethodBeat.o(30905);
            return;
        }
        ((r) this.cgL.aF(r.class)).dEm();
        if (biVar.field_talker.equals(this.cgL.getTalkerUserName()) && biVar.isText()) {
            aL(biVar);
            AppMethodBeat.o(30905);
            return;
        }
        AppMethodBeat.o(30905);
    }

    public final void L(List<bi> list) {
        AppMethodBeat.i(30906);
        if (this.cgL == null) {
            ab.w("MicroMsg.ChattingUIKeywordChecker", "chatting ui is null.");
            AppMethodBeat.o(30906);
        } else if (t.kH(this.cgL.getTalkerUserName())) {
            AppMethodBeat.o(30906);
        } else {
            ArrayList arrayList = new ArrayList();
            for (bi biVar : list) {
                if (biVar.field_talker.equals(this.cgL.getTalkerUserName()) && biVar.isText()) {
                    arrayList.add(biVar);
                }
            }
            eV(arrayList);
            AppMethodBeat.o(30906);
        }
    }

    public final void ard(String str) {
        AppMethodBeat.i(30907);
        if (ah.isNullOrNil(str)) {
            AppMethodBeat.o(30907);
            return;
        }
        bi biVar = new bi();
        biVar.setContent(str);
        biVar.hO(1);
        aL(biVar);
        AppMethodBeat.o(30907);
    }

    private void aL(bi biVar) {
        AppMethodBeat.i(30908);
        if (biVar == null) {
            AppMethodBeat.o(30908);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(biVar);
        eV(arrayList);
        AppMethodBeat.o(30908);
    }

    private void eV(List<bi> list) {
        AppMethodBeat.i(30909);
        if (!(this.yLx == null || this.cgL == null)) {
            this.yLx.a(this.cgL.yTx.getContext(), (List) list);
        }
        AppMethodBeat.o(30909);
    }

    public final Looper getLooper() {
        AppMethodBeat.i(30910);
        Looper mainLooper = Looper.getMainLooper();
        AppMethodBeat.o(30910);
        return mainLooper;
    }

    public final void a(int i, String str, String str2, String str3, String str4, Bundle bundle) {
    }
}
