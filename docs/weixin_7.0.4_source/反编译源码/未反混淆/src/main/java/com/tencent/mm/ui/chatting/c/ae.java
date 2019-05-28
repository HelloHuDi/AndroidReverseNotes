package com.tencent.mm.ui.chatting.c;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d.a;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

public class ae extends a implements v {
    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(31629);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(31629);
    }

    public final void dxx() {
        AppMethodBeat.i(31630);
        final Intent intent = this.cgL.yTx.getContext().getIntent();
        if (intent.getIntExtra("SendAppMessageWrapper_Scene", 0) != 3) {
            AppMethodBeat.o(31630);
            return;
        }
        intent.setClass(this.cgL.yTx.getContext(), SendAppMessageWrapperUI.class);
        intent.putExtra("Select_Conv_User", this.cgL.getTalkerUserName());
        this.cgL.a(intent, 228, new a() {
            public final void onActivityResult(int i, int i2, Intent intent) {
                AppMethodBeat.i(31628);
                intent.removeExtra("SendAppMessageWrapper_Scene");
                if (i == 228) {
                    if (i2 != -1) {
                        ReportUtil.a(ae.this.cgL.yTx.getContext(), ReportUtil.c(intent.getExtras(), 0), true);
                        if (!ae.this.cgL.yTx.getContext().isFinishing()) {
                            ae.this.cgL.yTx.getContext().finish();
                        }
                    } else if (intent != null && intent.getBooleanExtra("Select_stay_in_wx", false)) {
                        ReportUtil.F(false, 0);
                        AppMethodBeat.o(31628);
                        return;
                    } else if (!ae.this.cgL.yTx.getContext().isFinishing()) {
                        ae.this.cgL.yTx.getContext().finish();
                        AppMethodBeat.o(31628);
                        return;
                    }
                }
                AppMethodBeat.o(31628);
            }
        });
        AppMethodBeat.o(31630);
    }
}
