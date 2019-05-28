package com.tencent.mm.plugin.remittance.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.remittance.a;
import com.tencent.mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.mm.plugin.remittance.ui.d;
import com.tencent.mm.ui.widget.a.e.c;

public final class b implements a {
    public final void a(Context context, String str, String str2, String str3, String str4, String str5, c cVar) {
        AppMethodBeat.i(44425);
        d dVar = new d(context);
        ResendMsgInfo resendMsgInfo = new ResendMsgInfo();
        resendMsgInfo.title = str;
        resendMsgInfo.pQx = str2;
        resendMsgInfo.description = str3;
        resendMsgInfo.nZb = str4;
        resendMsgInfo.nZc = str5;
        dVar.a(resendMsgInfo, cVar);
        AppMethodBeat.o(44425);
    }
}
