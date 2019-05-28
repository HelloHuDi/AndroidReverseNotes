package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI */
public class IPCallFeedbackDialogUI extends MMActivity {
    private C39274g nDd;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.IPCallFeedbackDialogUI$1 */
    class C77781 implements OnDismissListener {
        C77781() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22173);
            IPCallFeedbackDialogUI.this.finish();
            AppMethodBeat.m2505o(22173);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(22174);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.nDd = new C39274g(this, this.mController.ylL, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0));
        this.nDd.setOnDismissListener(new C77781());
        this.nDd.getWindow().setSoftInputMode(16);
        this.nDd.show();
        AppMethodBeat.m2505o(22174);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.m2504i(22175);
        C4990ab.m7410d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
        AppMethodBeat.m2505o(22175);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(22176);
        C4990ab.m7410d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.m2505o(22176);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(22177);
        C4990ab.m7410d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
        AppMethodBeat.m2505o(22177);
    }

    public void finish() {
        AppMethodBeat.m2504i(22178);
        C4990ab.m7416i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.nDd != null && this.nDd.isShowing()) {
            this.nDd.dismiss();
            this.nDd = null;
        }
        super.finish();
        AppMethodBeat.m2505o(22178);
    }
}
