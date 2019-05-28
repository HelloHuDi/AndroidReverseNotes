package com.tencent.mm.plugin.label.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog gqo;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public int getLayoutId() {
        return 0;
    }

    public final void PI(String str) {
        AppMethodBeat.i(22537);
        getString(R.string.tz);
        this.gqo = h.b((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(22536);
                aw.Rg().cancel(636);
                AppMethodBeat.o(22536);
            }
        });
        AppMethodBeat.o(22537);
    }

    public final void bJc() {
        AppMethodBeat.i(22538);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.o(22538);
    }

    public final void JN(String str) {
        AppMethodBeat.i(22539);
        h.a((Context) this, str, "", new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(22539);
    }
}
