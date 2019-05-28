package com.tencent.p177mm.plugin.remittance.p497ui;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C45350oc;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30396s;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.plugin.remittance.model.C7040x;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

@C5271a(7)
/* renamed from: com.tencent.mm.plugin.remittance.ui.RemittanceResendMsgUI */
public class RemittanceResendMsgUI extends WalletBaseUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45110);
        super.onCreate(bundle);
        this.mController.contentView.setVisibility(8);
        setTitleVisibility(8);
        String stringExtra = getIntent().getStringExtra(C8741b.TRANSACTION_ID);
        String stringExtra2 = getIntent().getStringExtra("transfer_id");
        String stringExtra3 = getIntent().getStringExtra("receiver_name");
        int intExtra = getIntent().getIntExtra("resend_msg_from_flag", 1);
        int intExtra2 = getIntent().getIntExtra("invalid_time", 0);
        if (C5046bo.isNullOrNil(stringExtra3)) {
            C4990ab.m7416i("MicroMsg.RemittanceResendMsgUI", "onCreate() receiverName == null");
            AppMethodBeat.m2505o(45110);
            return;
        }
        mo26637f(stringExtra, stringExtra2, stringExtra3, intExtra2, intExtra);
        AppMethodBeat.m2505o(45110);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: f */
    public void mo26637f(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(45111);
        C1207m c7040x = new C7040x(str, str2, str3, i, i2);
        c7040x.eHT = "RemittanceProcess";
        mo39970a(c7040x, true, true);
        AppMethodBeat.m2505o(45111);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45112);
        C4990ab.m7416i("MicroMsg.RemittanceResendMsgUI", "onSceneEnd() errType:" + i + " errCode:" + i2 + " errMsg:" + str + " netsceneType:" + c1207m.getType());
        if (!(c1207m instanceof C7040x)) {
            AppMethodBeat.m2505o(45112);
            return false;
        } else if (i == 0 && i2 == 0) {
            C30396s.m48490a(this.mController.ylL.getResources().getString(C25738R.string.cbn), this.mController.ylL);
            finish();
            C4879a.xxA.mo10055m(new C45350oc());
            AppMethodBeat.m2505o(45112);
            return true;
        } else {
            C30379h.m48465bQ(this, str);
            finish();
            AppMethodBeat.m2505o(45112);
            return true;
        }
    }

    public final int getLayoutId() {
        return -1;
    }
}
