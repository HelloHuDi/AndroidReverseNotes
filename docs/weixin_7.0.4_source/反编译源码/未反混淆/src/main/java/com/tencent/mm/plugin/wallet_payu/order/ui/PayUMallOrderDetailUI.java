package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

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
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(48426);
        super.onCreate(bundle);
        nf(1520);
        this.oXY = this.mBundle.getString("key_trans_id");
        if (bo.isNullOrNil(this.oXY)) {
            ab.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
            finish();
        }
        a(new c(this.oXY), true, true);
        this.tTE = (LinearLayout) findViewById(R.id.dlm);
        this.tTF = (LinearLayout) findViewById(R.id.dlo);
        this.tTG = (LinearLayout) findViewById(R.id.dlq);
        this.tTH = (LinearLayout) findViewById(R.id.dls);
        this.tTI = (LinearLayout) findViewById(R.id.dly);
        this.tTJ = (LinearLayout) findViewById(R.id.dlu);
        this.tTK = (LinearLayout) findViewById(R.id.dlw);
        this.tTL = (TextView) findViewById(R.id.dln);
        this.tTM = (TextView) findViewById(R.id.dlp);
        this.tTN = (TextView) findViewById(R.id.dlr);
        this.pSi = (TextView) findViewById(R.id.dlt);
        this.nSC = (TextView) findViewById(R.id.dlz);
        this.iqw = (TextView) findViewById(R.id.dlv);
        this.tTO = (TextView) findViewById(R.id.dlx);
        caf();
        AppMethodBeat.o(48426);
    }

    private void caf() {
        AppMethodBeat.i(48427);
        if (this.tTD == null) {
            AppMethodBeat.o(48427);
            return;
        }
        if (bo.isNullOrNil(this.tTD.pcU)) {
            this.tTE.setVisibility(8);
        } else {
            this.tTE.setVisibility(0);
            this.tTL.setText(this.tTD.pcU);
        }
        if (bo.isNullOrNil(this.tTD.pde)) {
            this.tTF.setVisibility(8);
        } else {
            this.tTF.setVisibility(0);
            this.tTM.setText(this.tTD.pde);
        }
        if (bo.isNullOrNil(this.tTD.pcW)) {
            this.tTG.setVisibility(8);
        } else {
            this.tTG.setVisibility(0);
            this.tTN.setText(this.tTD.pcW);
        }
        if (bo.isNullOrNil(this.tTD.pda)) {
            this.tTH.setVisibility(8);
        } else {
            this.tTH.setVisibility(0);
            this.pSi.setText(e.e(((double) this.tTD.wMU) / 100.0d, this.tTD.pda));
        }
        if (this.tTD.pcX >= 0) {
            this.tTI.setVisibility(0);
            this.nSC.setText(e.kC(this.tTD.pcX));
        } else {
            this.tTI.setVisibility(8);
        }
        if (bo.isNullOrNil(this.tTD.pcY)) {
            this.tTJ.setVisibility(8);
        } else {
            this.tTJ.setVisibility(0);
            this.iqw.setText(this.tTD.pcY);
        }
        switch (this.tTD.pdc) {
            case 3:
                this.tTO.setText(R.string.f9a);
                AppMethodBeat.o(48427);
                return;
            case 5:
                this.tTO.setText(R.string.fge);
                AppMethodBeat.o(48427);
                return;
            default:
                this.tTO.setText(R.string.fp7);
                AppMethodBeat.o(48427);
                return;
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(48428);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof c) {
                this.tTD = ((c) mVar).tTC;
                caf();
            }
            AppMethodBeat.o(48428);
            return true;
        }
        AppMethodBeat.o(48428);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(48429);
        super.onDestroy();
        ng(1520);
        AppMethodBeat.o(48429);
    }

    public final int getLayoutId() {
        return R.layout.ak4;
    }
}
