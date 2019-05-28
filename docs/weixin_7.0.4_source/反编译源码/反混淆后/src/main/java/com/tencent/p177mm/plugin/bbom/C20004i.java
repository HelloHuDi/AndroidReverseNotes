package com.tencent.p177mm.plugin.bbom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1831bh;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C12527m;
import com.tencent.p177mm.protocal.protobuf.bbe;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.plugin.bbom.i */
public final class C20004i implements C12527m {
    private String jEs = null;

    public C20004i(String str) {
        this.jEs = str;
    }

    /* renamed from: a */
    public final void mo24450a(bbe bbe, C7620bi c7620bi) {
        AppMethodBeat.m2504i(18259);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.jEs + "\"></strangerantispamticket>");
        stringBuilder.append(C5046bo.nullAsNil(C1831bh.aad()));
        String str = (C5046bo.isNullOrNil(bbe.vEG) || !bbe.vEG.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : bbe.vEG;
        bbe.vEG = str;
        bbe.vEG = bbe.vEG.replace("<msgsource>", stringBuilder.toString());
        AppMethodBeat.m2505o(18259);
    }
}
