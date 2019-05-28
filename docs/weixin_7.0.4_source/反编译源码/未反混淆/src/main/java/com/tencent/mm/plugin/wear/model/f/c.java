package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.g.a.vi;
import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.ab;

public abstract class c extends d {
    public abstract void send();

    /* Access modifiers changed, original: protected|final */
    public final void execute() {
        if (a.cUn().tXt.cUs()) {
            vi viVar = new vi();
            viVar.cSq.cuy = 11;
            com.tencent.mm.sdk.b.a.xxA.m(viVar);
            send();
            return;
        }
        ab.i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
