package com.tencent.p177mm.plugin.wallet_payu.order.p570ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.wallet_payu.order.p1318a.C40159c;
import com.tencent.p177mm.protocal.protobuf.bjn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;

/* renamed from: com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI */
public class PayUMallOrderDetailUI extends WalletBaseUI {
    private TextView iqw;
    private TextView nSC;
    private String oXY = "";
    private TextView pSi;
    private bjn tTD;
    private LinearLayout tTE;
    private LinearLayout tTF;
    private LinearLayout tTG;
    private LinearLayout tTH;
    private LinearLayout tTI;
    private LinearLayout tTJ;
    private LinearLayout tTK;
    private TextView tTL;
    private TextView tTM;
    private TextView tTN;
    private TextView tTO;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(48426);
        super.onCreate(bundle);
        mo39992nf(1520);
        this.oXY = this.mBundle.getString("key_trans_id");
        if (C5046bo.isNullOrNil(this.oXY)) {
            C4990ab.m7412e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        mo39970a(new C40159c(this.oXY), true, true);
        this.tTE = (LinearLayout) findViewById(2131826486);
        this.tTF = (LinearLayout) findViewById(2131826488);
        this.tTG = (LinearLayout) findViewById(2131826490);
        this.tTH = (LinearLayout) findViewById(2131826492);
        this.tTI = (LinearLayout) findViewById(2131826498);
        this.tTJ = (LinearLayout) findViewById(2131826494);
        this.tTK = (LinearLayout) findViewById(2131826496);
        this.tTL = (TextView) findViewById(2131826487);
        this.tTM = (TextView) findViewById(2131826489);
        this.tTN = (TextView) findViewById(2131826491);
        this.pSi = (TextView) findViewById(2131826493);
        this.nSC = (TextView) findViewById(2131826499);
        this.iqw = (TextView) findViewById(2131826495);
        this.tTO = (TextView) findViewById(2131826497);
        caf();
        AppMethodBeat.m2505o(48426);
    }

    private void caf() {
        AppMethodBeat.m2504i(48427);
        if (this.tTD == null) {
            AppMethodBeat.m2505o(48427);
            return;
        }
        if (C5046bo.isNullOrNil(this.tTD.pcU)) {
            this.tTE.setVisibility(8);
        } else {
            this.tTE.setVisibility(0);
            this.tTL.setText(this.tTD.pcU);
        }
        if (C5046bo.isNullOrNil(this.tTD.pde)) {
            this.tTF.setVisibility(8);
        } else {
            this.tTF.setVisibility(0);
            this.tTM.setText(this.tTD.pde);
        }
        if (C5046bo.isNullOrNil(this.tTD.pcW)) {
            this.tTG.setVisibility(8);
        } else {
            this.tTG.setVisibility(0);
            this.tTN.setText(this.tTD.pcW);
        }
        if (C5046bo.isNullOrNil(this.tTD.pda)) {
            this.tTH.setVisibility(8);
        } else {
            this.tTH.setVisibility(0);
            this.pSi.setText(C36391e.m60006e(((double) this.tTD.wMU) / 100.0d, this.tTD.pda));
        }
        if (this.tTD.pcX >= 0) {
            this.tTI.setVisibility(0);
            this.nSC.setText(C36391e.m60014kC(this.tTD.pcX));
        } else {
            this.tTI.setVisibility(8);
        }
        if (C5046bo.isNullOrNil(this.tTD.pcY)) {
            this.tTJ.setVisibility(8);
        } else {
            this.tTJ.setVisibility(0);
            this.iqw.setText(this.tTD.pcY);
        }
        switch (this.tTD.pdc) {
            case 3:
                this.tTO.setText(C25738R.string.f9a);
                AppMethodBeat.m2505o(48427);
                return;
            case 5:
                this.tTO.setText(C25738R.string.fge);
                AppMethodBeat.m2505o(48427);
                return;
            default:
                this.tTO.setText(C25738R.string.fp7);
                AppMethodBeat.m2505o(48427);
                return;
        }
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(48428);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C40159c) {
                this.tTD = ((C40159c) c1207m).tTC;
                caf();
            }
            AppMethodBeat.m2505o(48428);
            return true;
        }
        AppMethodBeat.m2505o(48428);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(48429);
        super.onDestroy();
        mo39993ng(1520);
        AppMethodBeat.m2505o(48429);
    }

    public final int getLayoutId() {
        return 2130970350;
    }
}
