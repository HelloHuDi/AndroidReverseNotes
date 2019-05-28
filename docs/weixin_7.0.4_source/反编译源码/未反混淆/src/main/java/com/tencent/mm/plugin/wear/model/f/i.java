package com.tencent.mm.plugin.wear.model.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.protobuf.cuf;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.util.ArrayList;

public final class i extends c {
    private boolean FL = true;
    private ArrayList<Integer> tYN;

    public i(ArrayList<Integer> arrayList) {
        this.tYN = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.i(26447);
        ab.i("MicroMsg.WearCancelNotificationTask", "Id List=%s", this.tYN);
        cuf cuf = new cuf();
        if (this.tYN != null) {
            cuf.xqG.addAll(this.tYN);
        }
        cuf.xqH = this.FL;
        try {
            a.cUn();
            r.b(20004, cuf.toByteArray(), false);
            AppMethodBeat.o(26447);
        } catch (IOException e) {
            AppMethodBeat.o(26447);
        }
    }
}
