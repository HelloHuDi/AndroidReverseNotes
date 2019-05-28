package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(19)
public class WalletWXCreditOpenResultUI extends WalletBaseUI {
    private CheckBox uZE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(WalletWXCreditOpenResultUI walletWXCreditOpenResultUI) {
        AppMethodBeat.i(48749);
        walletWXCreditOpenResultUI.ari();
        AppMethodBeat.o(48749);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6q;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48745);
        super.onCreate(bundle);
        g.RQ();
        g.RP().Ry().set(196658, Boolean.TRUE);
        r.cPI().tDa = bo.anT();
        initView();
        AppMethodBeat.o(48745);
    }

    public final void initView() {
        AppMethodBeat.i(48746);
        setMMTitle((int) R.string.fx3);
        TextView textView = (TextView) findViewById(R.id.fi5);
        this.uZE = (CheckBox) findViewById(R.id.fi6);
        if (((Bankcard) this.mBundle.getParcelable("key_bankcard")) != null) {
            this.uZE.setText(getString(R.string.fx5, new Object[]{r1.field_bankName}));
            textView.setText(R.string.fx6);
        }
        ((Button) findViewById(R.id.ay8)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48744);
                WalletWXCreditOpenResultUI.a(WalletWXCreditOpenResultUI.this);
                AppMethodBeat.o(48744);
            }
        });
        AppMethodBeat.o(48746);
    }

    private void ari() {
        AppMethodBeat.i(48747);
        dOE().p(Boolean.valueOf(this.uZE.isChecked()));
        AppMethodBeat.o(48747);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(48748);
        if (i == 4) {
            ari();
            AppMethodBeat.o(48748);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(48748);
        return onKeyUp;
    }
}
