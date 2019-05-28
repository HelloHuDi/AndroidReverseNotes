package com.tencent.mm.plugin.product.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.g;

public abstract class MallBaseUI extends MMActivity {
    protected String hxN;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44026);
                MallBaseUI.this.finish();
                AppMethodBeat.o(44026);
                return true;
            }
        });
    }

    /* Access modifiers changed, original: protected|final */
    public final void UJ(String str) {
        this.hxN = str;
        showDialog(-10001);
    }

    /* Access modifiers changed, original: protected */
    public Dialog onCreateDialog(int i) {
        switch (i) {
            case -10002:
                return g.a(this.mController.ylL, false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
            case -10001:
                if (bo.isNullOrNil(this.hxN)) {
                    this.hxN = getString(R.string.cxc);
                }
                return h.a((Context) this, this.hxN, null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(44027);
                        MallBaseUI.this.finish();
                        AppMethodBeat.o(44027);
                    }
                });
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

    public final void AM(int i) {
        this.mController.contentView.setVisibility(i);
        if (i == 0) {
            this.mController.showTitleView();
        } else {
            this.mController.hideTitleView();
        }
    }
}
