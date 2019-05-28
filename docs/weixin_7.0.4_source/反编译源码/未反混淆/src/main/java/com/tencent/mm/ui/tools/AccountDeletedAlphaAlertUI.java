package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.x;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;

@a(3)
public class AccountDeletedAlphaAlertUI extends MMActivity {
    private static AccountDeletedAlphaAlertUI zzW = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public static AccountDeletedAlphaAlertUI dJp() {
        return zzW;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(34741);
        super.onCreate(bundle);
        zzW = this;
        com.tencent.mm.sdk.b.a.xxA.m(new x());
        aw.hold();
        com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(getIntent().getStringExtra("errmsg"));
        if (jY != null) {
            jY.a(this, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(34739);
                    AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                    AppMethodBeat.o(34739);
                }
            }, null);
            AppMethodBeat.o(34741);
            return;
        }
        h.a((Context) this, getString(R.string.cvv), null, false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34740);
                AccountDeletedAlphaAlertUI.a(AccountDeletedAlphaAlertUI.this);
                AppMethodBeat.o(34740);
            }
        });
        AppMethodBeat.o(34741);
    }

    public void onDestroy() {
        AppMethodBeat.i(34742);
        if (equals(zzW)) {
            zzW = null;
        }
        super.onDestroy();
        AppMethodBeat.o(34742);
    }

    public final int getLayoutId() {
        return -1;
    }

    static /* synthetic */ void a(AccountDeletedAlphaAlertUI accountDeletedAlphaAlertUI) {
        AppMethodBeat.i(34743);
        accountDeletedAlphaAlertUI.finish();
        w.cn(accountDeletedAlphaAlertUI);
        Intent intent = new Intent(accountDeletedAlphaAlertUI.mController.ylL, LauncherUI.class);
        intent.putExtra("Intro_Switch", true).addFlags(67108864);
        accountDeletedAlphaAlertUI.mController.ylL.startActivity(intent);
        AppMethodBeat.o(34743);
    }
}
