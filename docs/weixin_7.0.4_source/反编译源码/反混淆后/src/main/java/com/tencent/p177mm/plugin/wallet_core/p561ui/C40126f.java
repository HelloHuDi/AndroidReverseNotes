package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.f */
final class C40126f extends C43815a {
    public C40126f(WalletCheckPwdNewUI walletCheckPwdNewUI) {
        super(walletCheckPwdNewUI);
    }

    public final void acQ(String str) {
        AppMethodBeat.m2504i(47130);
        Intent intent = new Intent();
        intent.putExtra("encrypt_pwd", str);
        this.tDN.setResult(-1, intent);
        this.tDN.finish();
        AppMethodBeat.m2505o(47130);
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(47129);
        String stringExtra = this.tDN.getIntent().getStringExtra("title");
        if (!C5046bo.isNullOrNil(stringExtra)) {
            this.tDN.tGT.setText(stringExtra);
        }
        AppMethodBeat.m2505o(47129);
    }
}
