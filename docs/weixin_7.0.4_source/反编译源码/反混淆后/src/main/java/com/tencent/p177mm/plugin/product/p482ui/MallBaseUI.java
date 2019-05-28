package com.tencent.p177mm.plugin.product.p482ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;

/* renamed from: com.tencent.mm.plugin.product.ui.MallBaseUI */
public abstract class MallBaseUI extends MMActivity {
    protected String hxN;

    /* renamed from: com.tencent.mm.plugin.product.ui.MallBaseUI$1 */
    class C214401 implements OnMenuItemClickListener {
        C214401() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44026);
            MallBaseUI.this.finish();
            AppMethodBeat.m2505o(44026);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallBaseUI$2 */
    class C286732 implements OnClickListener {
        C286732() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44027);
            MallBaseUI.this.finish();
            AppMethodBeat.m2505o(44027);
        }
    }

    /* renamed from: com.tencent.mm.plugin.product.ui.MallBaseUI$3 */
    class C286743 implements OnCancelListener {
        C286743() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new C214401());
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: UJ */
    public final void mo46815UJ(String str) {
        this.hxN = str;
        showDialog(-10001);
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case -10002:
                return C30901g.m49317a(this.mController.ylL, false, new C286743());
            case -10001:
                if (C5046bo.isNullOrNil(this.hxN)) {
                    this.hxN = getString(C25738R.string.cxc);
                }
                return C30379h.m48448a((Context) this, this.hxN, null, false, new C286732());
            default:
                return super.onCreateDialog(i);
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1) {
            this.mController.callBackMenu();
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* renamed from: AM */
    public final void mo9439AM(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }
}
