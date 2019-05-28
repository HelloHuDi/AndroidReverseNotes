package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.base.h;

public final class j implements f, b {
    protected String elr = null;
    private MobileInputUI gDo;
    protected String gsy = "";
    protected int gsz = 2;

    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125109);
        this.gDo = mobileInputUI;
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.showVKB();
        this.elr = mobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = mobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = mobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        String string = mobileInputUI.getString(R.string.dm9);
        if (d.vxr) {
            string = string + mobileInputUI.getString(R.string.fk);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDK.setVisibility(0);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDN.setText(R.string.cpa);
        AppMethodBeat.o(125109);
    }

    public final void start() {
        AppMethodBeat.i(125110);
        g.Rg().a(132, (f) this);
        AppMethodBeat.o(125110);
    }

    public final void stop() {
        AppMethodBeat.i(125111);
        g.Rg().b(132, (f) this);
        AppMethodBeat.o(125111);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125112);
        switch (aVar) {
            case GoNext:
                this.gDo.gDU = av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDH.getText().toString();
                String str = this.gDo.gDU + this.gDo.gDV;
                if (this.gDo.guc == null) {
                    MobileInputUI mobileInputUI = this.gDo;
                    Context context = this.gDo;
                    this.gDo.getString(R.string.tz);
                    mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    g.Rg().a(new x(str, 1, "", 0, ""), 0);
                    break;
                }
                ab.d("MicroMsg.MobileInputRegLogic", "already checking ");
                AppMethodBeat.o(125112);
                return;
        }
        AppMethodBeat.o(125112);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(125113);
        ab.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (mVar.getType() != 132) {
            AppMethodBeat.o(125113);
        } else if (i == 0 && i2 == 0) {
            if (((x) mVar).Ah() == 1) {
                Intent intent = new Intent();
                intent.putExtra("bindmcontact_mobile", this.gDo.gDU + " " + this.gDo.gDH.getText().toString());
                intent.putExtra("bindmcontact_shortmobile", this.gDo.gDH.getText().toString());
                intent.putExtra("country_name", this.gDo.fHE);
                intent.putExtra("couttry_code", this.gDo.countryCode);
                intent.putExtra("mobile_verify_purpose", 4);
                intent.putExtra("regsetinfo_ticket", this.elr);
                intent.putExtra("regsetinfo_NextStep", this.gsy);
                intent.putExtra("regsetinfo_NextStyle", this.gsz);
                intent.setClass(this.gDo, MobileVerifyUI.class);
                this.gDo.startActivity(intent);
                this.gDo.finish();
            }
            AppMethodBeat.o(125113);
        } else if (a.gkF.a(this.gDo, i, i2, str)) {
            AppMethodBeat.o(125113);
        } else {
            Toast.makeText(this.gDo, this.gDo.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125113);
        }
    }
}
