package com.tencent.p177mm.p612ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p069v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.ttpic.util.ActUtil;

/* renamed from: com.tencent.mm.ui.AlertActivity */
public class AlertActivity extends AppCompatActivity {
    private static C5652a vkm;
    private OnDismissListener cMR;
    private OnCancelListener yes;

    /* renamed from: com.tencent.mm.ui.AlertActivity$1 */
    class C51661 implements OnDismissListener {
        C51661() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112440);
            if (AlertActivity.this.cMR != null) {
                AlertActivity.this.cMR.onDismiss(dialogInterface);
            }
            AlertActivity.this.finish();
            AppMethodBeat.m2505o(112440);
        }
    }

    /* renamed from: com.tencent.mm.ui.AlertActivity$2 */
    class C51672 implements OnCancelListener {
        C51672() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(112441);
            if (AlertActivity.this.yes != null) {
                AlertActivity.this.yes.onCancel(dialogInterface);
            }
            AlertActivity.this.finish();
            AppMethodBeat.m2505o(112441);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(112442);
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(ActUtil.HEIGHT);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(17170445));
        }
        if (vkm != null) {
            vkm.mContext = this;
            this.cMR = vkm.zQe.f1335Uf;
            this.yes = vkm.zQe.f1334Ue;
            vkm.mo11458a(new C51661());
            vkm.mo11478f(new C51672());
            vkm.aMb().show();
        }
        AppMethodBeat.m2505o(112442);
    }

    /* renamed from: a */
    public static void m13630a(C5652a c5652a) {
        vkm = c5652a;
    }

    public void onPause() {
        AppMethodBeat.m2504i(112443);
        overridePendingTransition(0, 0);
        super.onPause();
        AppMethodBeat.m2505o(112443);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(112444);
        super.onDestroy();
        vkm = null;
        AppMethodBeat.m2505o(112444);
    }
}
