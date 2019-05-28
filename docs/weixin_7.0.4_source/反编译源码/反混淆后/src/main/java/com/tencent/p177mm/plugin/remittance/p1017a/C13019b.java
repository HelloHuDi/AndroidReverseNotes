package com.tencent.p177mm.plugin.remittance.p1017a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.plugin.remittance.C28856a;
import com.tencent.p177mm.plugin.remittance.model.NetSceneTenpayRemittanceQuery.ResendMsgInfo;
import com.tencent.p177mm.plugin.remittance.p497ui.C46178d;

/* renamed from: com.tencent.mm.plugin.remittance.a.b */
public final class C13019b implements C28856a {
    /* renamed from: a */
    public final void mo25073a(Context context, String str, String str2, String str3, String str4, String str5, C5662c c5662c) {
        AppMethodBeat.m2504i(44425);
        C46178d c46178d = new C46178d(context);
        ResendMsgInfo resendMsgInfo = new ResendMsgInfo();
        resendMsgInfo.title = str;
        resendMsgInfo.pQx = str2;
        resendMsgInfo.description = str3;
        resendMsgInfo.nZb = str4;
        resendMsgInfo.nZc = str5;
        c46178d.mo74162a(resendMsgInfo, c5662c);
        AppMethodBeat.m2505o(44425);
    }
}
