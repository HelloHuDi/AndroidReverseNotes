package com.tencent.p177mm.p612ui.chatting.p616c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.transmit.SendAppMessageWrapperUI;
import com.tencent.p177mm.p842bp.C25985d.C25987a;
import com.tencent.p177mm.pluginsdk.model.app.ReportUtil;

/* renamed from: com.tencent.mm.ui.chatting.c.ae */
public class C23712ae extends C44291a implements C5326v {
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(31629);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(31629);
    }

    public final void dxx() {
        AppMethodBeat.m2504i(31630);
        final Intent intent = this.cgL.yTx.getContext().getIntent();
        if (intent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3) {
            AppMethodBeat.m2505o(31630);
            return;
        }
        intent.setClass(this.cgL.yTx.getContext(), SendAppMessageWrapperUI.class);
        intent.putExtra("Select_Conv_User", this.cgL.getTalkerUserName());
        this.cgL.mo74855a(intent, 228, new C25987a() {
            public final void onActivityResult(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(31628);
                intent.removeExtra("SendAppMessageWrapper_Scene");
                if (i == 228) {
                    if (i2 != -1) {
                        ReportUtil.m79192a(C23712ae.this.cgL.yTx.getContext(), ReportUtil.m79195c(intent.getExtras(), 0), true);
                        if (!C23712ae.this.cgL.yTx.getContext().isFinishing()) {
                            C23712ae.this.cgL.yTx.getContext().finish();
                        }
                    } else if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        ReportUtil.m79190F(false, 0);
                        AppMethodBeat.m2505o(31628);
                        return;
                    } else if (!C23712ae.this.cgL.yTx.getContext().isFinishing()) {
                        C23712ae.this.cgL.yTx.getContext().finish();
                        AppMethodBeat.m2505o(31628);
                        return;
                    }
                }
                AppMethodBeat.m2505o(31628);
            }
        });
        AppMethodBeat.m2505o(31630);
    }
}
