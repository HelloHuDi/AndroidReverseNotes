package com.tencent.mm.plugin.remittance.ui;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

@a(7)
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45110);
        super.onCreate(bundle);
        this.mController.contentView.setVisibility(8);
        setTitleVisibility(8);
        String stringExtra = getIntent().getStringExtra(b.TRANSACTION_ID);
        String stringExtra2 = getIntent().getStringExtra("transfer_id");
        String stringExtra3 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (bo.isNullOrNil(stringExtra3)) {
            ab.i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
            AppMethodBeat.o(45110);
            return;
        }
        f(stringExtra, stringExtra2, stringExtra3, intExtra2, intExtra);
        AppMethodBeat.o(45110);
    }

    /* Access modifiers changed, original: protected */
    public void f(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(45111);
        m xVar = new x(str, str2, str3, i, i2);
        xVar.eHT = "RemittanceProcess";
        a(xVar, true, true);
        AppMethodBeat.o(45111);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45112);
        ab.i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + mVar.getType());
        if (!(mVar instanceof x)) {
            AppMethodBeat.o(45112);
            return false;
        } else if (i == 0 && i2 == 0) {
            s.a(this.mController.ylL.getResources().getString(R.string.cbn), this.mController.ylL);
            finish();
            com.tencent.mm.sdk.b.a.xxA.m(new oc());
            AppMethodBeat.o(45112);
            return true;
        } else {
            h.bQ(this, str);
            finish();
            AppMethodBeat.o(45112);
            return true;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
