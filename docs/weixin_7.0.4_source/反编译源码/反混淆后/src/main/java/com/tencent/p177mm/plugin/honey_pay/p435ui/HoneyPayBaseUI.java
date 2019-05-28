package com.tencent.p177mm.plugin.honey_pay.p435ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI */
public abstract class HoneyPayBaseUI extends WalletBaseUI {
    protected final String TAG = ("MicroMsg." + getClass().getSimpleName());
    protected int nqT = C25738R.color.a69;

    /* renamed from: com.tencent.mm.plugin.honey_pay.ui.HoneyPayBaseUI$1 */
    class C32881 implements OnMenuItemClickListener {
        C32881() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(41770);
            HoneyPayBaseUI.this.aqX();
            HoneyPayBaseUI.this.aoB();
            HoneyPayBaseUI.this.finish();
            AppMethodBeat.m2505o(41770);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bFY();
        setBackBtn(new C32881());
    }

    /* Access modifiers changed, original: protected */
    public void bFY() {
        mo17446xE(getResources().getColor(this.nqT));
        dyb();
    }
}
