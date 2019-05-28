package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

final class f extends a {
    public f(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        super(walletCheckPwdNewUI);
    }

    public final void acQ(String str) {
        AppMethodBeat.i(47130);
        Intent intent = new Intent();
        intent.putExtra("encrypt_pwd", str);
        this.tDN.setResult(-1, intent);
        this.tDN.finish();
        AppMethodBeat.o(47130);
    }

    public final void onCreate() {
        AppMethodBeat.i(47129);
        String stringExtra = this.tDN.getIntent().getStringExtra("title");
        if (!bo.isNullOrNil(stringExtra)) {
            this.tDN.tGT.setText(stringExtra);
        }
        AppMethodBeat.o(47129);
    }
}
