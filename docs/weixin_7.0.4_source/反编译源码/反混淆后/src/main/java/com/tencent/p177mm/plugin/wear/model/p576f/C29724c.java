package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.p177mm.p230g.p231a.C42076vi;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.wear.model.f.c */
public abstract class C29724c extends C40186d {
    public abstract void send();

    /* Access modifiers changed, original: protected|final */
    public final void execute() {
        if (C43841a.cUn().tXt.cUs()) {
            C42076vi c42076vi = new C42076vi();
            c42076vi.cSq.cuy = 11;
            C4879a.xxA.mo10055m(c42076vi);
            send();
            return;
        }
        C4990ab.m7416i("MicroMsg.WearBaseSendTask", "can not send message to wear");
    }
}
