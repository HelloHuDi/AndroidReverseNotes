package com.tencent.mm.plugin.wxcredit.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class WalletCheckIdentityUI extends WalletBaseUI {
    private WalletFormView tEq;
    private WalletFormView trX;
    private String uYV;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48682);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(48682);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        return false;
    }

    public final int getLayoutId() {
        return R.layout.b6l;
    }

    public final void initView() {
        AppMethodBeat.i(48683);
        setMMTitle((int) R.string.fd3);
        this.tEq = (WalletFormView) findViewById(R.id.f7y);
        a.e(this, this.tEq);
        this.trX = (WalletFormView) findViewById(R.id.f90);
        a.c(this.trX);
        e(this.trX, 1, false);
        String string = this.mBundle.getString("key_pre_name");
        this.uYV = this.mBundle.getString("key_pre_indentity");
        if (!bo.isNullOrNil(string)) {
            this.tEq.getPrefilledTv().setText(string);
            this.tEq.setHint(getString(R.string.fcs));
        }
        if (!bo.isNullOrNil(this.uYV)) {
            this.trX.setMaxInputLength(4);
            this.trX.getPrefilledTv().setText(this.uYV);
            this.trX.setHint(getString(R.string.fbj));
        }
        findViewById(R.id.ay8).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(48681);
                if (WalletCheckIdentityUI.a(WalletCheckIdentityUI.this, WalletCheckIdentityUI.this.tEq.getText(), WalletCheckIdentityUI.this.trX.getText())) {
                    WalletCheckIdentityUI.this.dOE().p(r0, r1);
                }
                AppMethodBeat.o(48681);
            }
        });
        AppMethodBeat.o(48683);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ boolean a(WalletCheckIdentityUI walletCheckIdentityUI, String str, String str2) {
        AppMethodBeat.i(48684);
        if (bo.isNullOrNil(str)) {
            t.makeText(walletCheckIdentityUI, R.string.fd1, 0).show();
            AppMethodBeat.o(48684);
            return false;
        } else if (bo.isNullOrNil(str2) || str2.length() < 4 || (bo.isNullOrNil(walletCheckIdentityUI.uYV) && !walletCheckIdentityUI.trX.asa())) {
            t.makeText(walletCheckIdentityUI, R.string.fbg, 0).show();
            AppMethodBeat.o(48684);
            return false;
        } else {
            AppMethodBeat.o(48684);
            return true;
        }
    }
}
