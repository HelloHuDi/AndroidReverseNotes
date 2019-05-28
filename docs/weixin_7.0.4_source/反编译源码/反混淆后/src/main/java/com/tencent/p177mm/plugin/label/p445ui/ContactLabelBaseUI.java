package com.tencent.p177mm.plugin.label.p445ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;

/* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelBaseUI */
public class ContactLabelBaseUI extends MMActivity {
    private ProgressDialog gqo;

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelBaseUI$2 */
    class C211622 implements OnClickListener {
        C211622() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.label.ui.ContactLabelBaseUI$1 */
    class C211631 implements OnCancelListener {
        C211631() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(22536);
            C9638aw.m17182Rg().cancel(636);
            AppMethodBeat.m2505o(22536);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public int getLayoutId() {
        return 0;
    }

    /* renamed from: PI */
    public final void mo36484PI(String str) {
        AppMethodBeat.m2504i(22537);
        getString(C25738R.string.f9238tz);
        this.gqo = C30379h.m48458b((Context) this, str, true, new C211631());
        AppMethodBeat.m2505o(22537);
    }

    public final void bJc() {
        AppMethodBeat.m2504i(22538);
        if (this.gqo != null && this.gqo.isShowing()) {
            this.gqo.dismiss();
        }
        AppMethodBeat.m2505o(22538);
    }

    /* renamed from: JN */
    public final void mo36483JN(String str) {
        AppMethodBeat.m2504i(22539);
        C30379h.m48438a((Context) this, str, "", new C211622());
        AppMethodBeat.m2505o(22539);
    }
}
