package com.tencent.p177mm.wallet_core.p650ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p760d.C30868i;
import com.tencent.p177mm.wallet_core.p760d.C40932f;
import com.tencent.p177mm.wallet_core.p760d.C44432g;

@C5271a(3)
/* renamed from: com.tencent.mm.wallet_core.ui.WalletPreferenceUI */
public abstract class WalletPreferenceUI extends MMPreference implements C40932f {
    protected C40931c Ahq = null;
    protected C30868i Ahr = null;
    protected C44432g Ahs = null;

    /* renamed from: com.tencent.mm.wallet_core.ui.WalletPreferenceUI$1 */
    class C308771 implements OnClickListener {
        C308771() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(49334);
            WalletPreferenceUI.this.finish();
            AppMethodBeat.m2505o(49334);
        }
    }

    /* renamed from: f */
    public abstract boolean mo24791f(int i, int i2, String str, C1207m c1207m);

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final C30868i dOM() {
        if (this.Ahr == null) {
            this.Ahr = new C30868i(this, this);
        }
        return this.Ahr;
    }

    /* renamed from: b */
    public final void mo24300b(int i, int i2, String str, C1207m c1207m, boolean z) {
        if (!mo24791f(i, i2, str, c1207m) && i2 != 0) {
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fdx);
            }
            C30379h.m48448a((Context) this, str, null, false, new C308771());
        }
    }

    public void onDestroy() {
        this.Ahr.mo49373ng(385);
        this.Ahr.mo49373ng(1518);
        this.Ahr = null;
        super.onDestroy();
    }

    public void onCreate(Bundle bundle) {
        this.yll = true;
        super.onCreate(bundle);
        bht();
        this.Ahr = new C30868i(this, this);
        this.Ahr.mo49372nf(385);
        this.Ahr.mo49372nf(1518);
        if (getLayoutId() > 0) {
            C36391e.dOJ();
        }
    }

    /* Access modifiers changed, original: protected */
    public void bht() {
        mo17446xE(this.mController.dyj());
    }
}
