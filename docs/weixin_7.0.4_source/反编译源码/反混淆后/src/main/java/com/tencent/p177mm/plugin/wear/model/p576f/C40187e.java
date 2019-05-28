package com.tencent.p177mm.plugin.wear.model.p576f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.wear.model.C43841a;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.protocal.protobuf.ctp;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.io.IOException;

/* renamed from: com.tencent.mm.plugin.wear.model.f.e */
public final class C40187e extends C29724c {
    /* Access modifiers changed, original: protected|final */
    public final void send() {
        AppMethodBeat.m2504i(26443);
        int size = ((C6982j) C1720g.m3528K(C6982j.class)).bOr().bOC().size();
        ctp ctp = new ctp();
        ctp.ndE = C43841a.cUn().tXv.adr(C1853r.m3846Yz()).f4403id;
        ctp.Title = C4996ah.getContext().getString(C25738R.string.f9176ru);
        ctp.ncM = C4996ah.getContext().getString(C25738R.string.d8h, new Object[]{Integer.valueOf(size)});
        try {
            C43841a.cUn();
            C40185r.m68920b(20005, ctp.toByteArray(), true);
            AppMethodBeat.m2505o(26443);
        } catch (IOException e) {
            AppMethodBeat.m2505o(26443);
        }
    }

    public final String getName() {
        return "WearFailMsgCreateTask";
    }
}
