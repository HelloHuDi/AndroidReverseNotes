package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;

/* renamed from: com.tencent.mm.plugin.fav.ui.FavTipsUI */
public class FavTipsUI extends MMBaseActivity {

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTipsUI$2 */
    class C118752 implements OnCancelListener {
        C118752() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(74166);
            FavTipsUI.this.finish();
            AppMethodBeat.m2505o(74166);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.FavTipsUI$1 */
    class C280001 implements OnClickListener {
        C280001() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(74165);
            FavTipsUI.this.finish();
            AppMethodBeat.m2505o(74165);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(74167);
        super.onCreate(bundle);
        C5652a c5652a = new C5652a(this);
        c5652a.asD(getString(C25738R.string.bpb));
        c5652a.asE(getString(C25738R.string.bp_) + "\n\n" + getString(C25738R.string.bpa));
        c5652a.mo11453Qc(C25738R.string.bp9).mo11457a(new C280001());
        c5652a.mo11478f(new C118752());
        c5652a.aMb().show();
        AppMethodBeat.m2505o(74167);
    }
}
