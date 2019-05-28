package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(7)
public class IPCallFeedbackDialogUI extends MMActivity {
    private g nDd;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(22174);
        super.onCreate(bundle);
        ab.i("MicroMsg.IPCallFeedbackDialogUI", "onCreate");
        this.nDd = new g(this, this.mController.ylL, getIntent().getIntExtra("IPCallFeedbackDialogUI_KRoomId", 0), getIntent().getLongExtra("IPCallFeedbackDialogUI_KCallseq", 0));
        this.nDd.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(22173);
                IPCallFeedbackDialogUI.this.finish();
                AppMethodBeat.o(22173);
            }
        });
        this.nDd.getWindow().setSoftInputMode(16);
        this.nDd.show();
        AppMethodBeat.o(22174);
    }

    public final int getLayoutId() {
        return -1;
    }

    public void onResume() {
        AppMethodBeat.i(22175);
        ab.d("MicroMsg.IPCallFeedbackDialogUI", "onResume");
        super.onResume();
        AppMethodBeat.o(22175);
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(22176);
        ab.d("MicroMsg.IPCallFeedbackDialogUI", "onNewIntent");
        super.onNewIntent(intent);
        AppMethodBeat.o(22176);
    }

    public void onDestroy() {
        AppMethodBeat.i(22177);
        ab.d("MicroMsg.IPCallFeedbackDialogUI", "onDestroy");
        super.onDestroy();
        AppMethodBeat.o(22177);
    }

    public void finish() {
        AppMethodBeat.i(22178);
        ab.i("MicroMsg.IPCallFeedbackDialogUI", "finish");
        if (this.nDd != null && this.nDd.isShowing()) {
            this.nDd.dismiss();
            this.nDd = null;
        }
        super.finish();
        AppMethodBeat.o(22178);
    }
}
