package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C33008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C38070b;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;

/* renamed from: com.tencent.mm.plugin.account.ui.j */
public final class C45504j implements C1202f, C38070b {
    protected String elr = null;
    private MobileInputUI gDo;
    protected String gsy = "";
    protected int gsz = 2;

    /* renamed from: com.tencent.mm.plugin.account.ui.j$1 */
    class C423031 implements OnCancelListener {
        C423031() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: a */
    public final void mo21369a(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125109);
        this.gDo = mobileInputUI;
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.showVKB();
        this.elr = mobileInputUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = mobileInputUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = mobileInputUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        String string = mobileInputUI.getString(C25738R.string.dm9);
        if (C7243d.vxr) {
            string = string + mobileInputUI.getString(C25738R.string.f8807fk);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDK.setVisibility(0);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDN.setText(C25738R.string.cpa);
        AppMethodBeat.m2505o(125109);
    }

    public final void start() {
        AppMethodBeat.m2504i(125110);
        C1720g.m3540Rg().mo14539a(132, (C1202f) this);
        AppMethodBeat.m2505o(125110);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125111);
        C1720g.m3540Rg().mo14546b(132, (C1202f) this);
        AppMethodBeat.m2505o(125111);
    }

    /* renamed from: a */
    public final void mo21368a(C33008a c33008a) {
        AppMethodBeat.m2504i(125112);
        switch (c33008a) {
            case GoNext:
                this.gDo.gDU = C5025av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDH.getText().toString();
                String str = this.gDo.gDU + this.gDo.gDV;
                if (this.gDo.guc == null) {
                    MobileInputUI mobileInputUI = this.gDo;
                    Context context = this.gDo;
                    this.gDo.getString(C25738R.string.f9238tz);
                    mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C423031());
                    C1720g.m3540Rg().mo14541a(new C38037x(str, 1, "", 0, ""), 0);
                    break;
                }
                C4990ab.m7410d("MicroMsg.MobileInputRegLogic", "already checking ");
                AppMethodBeat.m2505o(125112);
                return;
        }
        AppMethodBeat.m2505o(125112);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125113);
        C4990ab.m7416i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if (c1207m.getType() != 132) {
            AppMethodBeat.m2505o(125113);
        } else if (i == 0 && i2 == 0) {
            if (((C38037x) c1207m).mo60786Ah() == 1) {
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
            AppMethodBeat.m2505o(125113);
        } else if (C24679a.gkF.mo38859a(this.gDo, i, i2, str)) {
            AppMethodBeat.m2505o(125113);
        } else {
            Toast.makeText(this.gDo, this.gDo.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125113);
        }
    }
}
