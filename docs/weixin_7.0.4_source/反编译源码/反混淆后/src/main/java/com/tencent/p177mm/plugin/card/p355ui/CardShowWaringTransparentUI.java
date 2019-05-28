package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI */
public class CardShowWaringTransparentUI extends MMActivity {

    /* renamed from: com.tencent.mm.plugin.card.ui.CardShowWaringTransparentUI$1 */
    class C201711 implements OnClickListener {
        C201711() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(88651);
            dialogInterface.dismiss();
            CardShowWaringTransparentUI.this.finish();
            AppMethodBeat.m2505o(88651);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final int getLayoutId() {
        return 2130968985;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(88652);
        super.onCreate(bundle);
        C30379h.m48443a((Context) this, getString(C25738R.string.ai4, new Object[]{getIntent().getStringExtra("KEY_BRAND_NAME")}), getString(C25738R.string.ai5), getString(C25738R.string.aew), new C201711());
        AppMethodBeat.m2505o(88652);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(88653);
        if (i == 4) {
            finish();
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(88653);
        return onKeyUp;
    }
}
