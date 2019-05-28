package com.tencent.p177mm.plugin.remittance.p497ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity */
public class RemittanceMsgAlertActivity extends AppCompatActivity {

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity$1 */
    class C70441 implements C5662c {
        C70441() {
        }

        /* renamed from: d */
        public final void mo5699d(boolean z, String str) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceMsgAlertActivity$2 */
    class C76442 implements OnDismissListener {
        C76442() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(45082);
            RemittanceMsgAlertActivity.this.finish();
            AppMethodBeat.m2505o(45082);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45083);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        C5659a b = new C5659a(this).asL(C4996ah.getContext().getString(getIntent().getBooleanExtra("key_is_no_contact", false) ? C25738R.string.dpa : C25738R.string.dp_)).mo11510Qh(C4996ah.getContext().getResources().getColor(C25738R.color.a61)).mo11509Qg(C25738R.string.cd_).mo11522b(new C70441());
        b.mo11521b(new C76442());
        b.show();
        AppMethodBeat.m2505o(45083);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45084);
        super.onDestroy();
        overridePendingTransition(0, 0);
        AppMethodBeat.m2505o(45084);
    }
}
