package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.cuf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.io.IOException;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.wear.model.f.i */
public final class C14414i extends C29724c {
    /* renamed from: FL */
    private boolean f2954FL = true;
    private ArrayList<Integer> tYN;

    public C14414i(ArrayList<Integer> arrayList) {
        this.tYN = arrayList;
    }

    public final String getName() {
        return "WearCancelNotificationTask";
    }

    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26447);
        C4990ab.m7417i("MicroMsg.WearCancelNotificationTask", "Id List=%s", this.tYN);
        cuf cuf = new cuf();
        if (this.tYN != null) {
            cuf.xqG.addAll(this.tYN);
        }
        cuf.xqH = this.f2954FL;
        try {
            C43841a.cUn();
            C40185r.m68920b(20004, cuf.toByteArray(), false);
            AppMethodBeat.m2505o(26447);
        } catch (IOException e) {
            AppMethodBeat.m2505o(26447);
        }
    }
}
