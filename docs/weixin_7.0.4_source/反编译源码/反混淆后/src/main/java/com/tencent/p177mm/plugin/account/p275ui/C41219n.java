package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C18288hy;
import com.tencent.p177mm.p230g.p231a.C6494hz;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.friend.p272a.C38037x;
import com.tencent.p177mm.plugin.account.friend.p273ui.FindMContactAddUI;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7703b;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI.C7711a;
import com.tencent.p177mm.plugin.account.p765a.C24679a;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.ui.n */
public final class C41219n implements C1202f, C7703b {
    private String elr = null;
    private MobileVerifyUI gEE;
    private String gsy = "";
    private int gsz = 2;

    /* renamed from: a */
    public final void mo17520a(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.m2504i(125247);
        this.gEE = mobileVerifyUI;
        this.elr = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        AppMethodBeat.m2505o(125247);
    }

    public final void start() {
    }

    public final void stop() {
    }

    /* renamed from: a */
    public final boolean mo17521a(C7711a c7711a) {
        AppMethodBeat.m2504i(125248);
        C18288hy c18288hy;
        String str;
        C6494hz c6494hz;
        String str2;
        final C1207m c38037x;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (c7711a) {
            case GoNext:
                c18288hy = new C18288hy();
                c18288hy.cCS.context = this.gEE;
                C4879a.xxA.mo10055m(c18288hy);
                str = c18288hy.cCT.cCU;
                c6494hz = new C6494hz();
                C4879a.xxA.mo10055m(c6494hz);
                str2 = c6494hz.cCV.cCW;
                C1720g.m3540Rg().mo14539a(132, (C1202f) this);
                c38037x = new C38037x(this.gEE.cFl, 2, this.gEE.grL.getText().toString().trim(), "", str, str2);
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(C25738R.string.f9238tz);
                mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125245);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        C1720g.m3540Rg().mo14546b(132, C41219n.this);
                        AppMethodBeat.m2505o(125245);
                    }
                });
                break;
            case DoSend:
                C1720g.m3540Rg().mo14539a(132, (C1202f) this);
                C1720g.m3540Rg().mo14541a(new C38037x(this.gEE.cFl, 1, "", 0, ""), 0);
                break;
            case DoProcessSMS:
                c18288hy = new C18288hy();
                c18288hy.cCS.context = this.gEE;
                C4879a.xxA.mo10055m(c18288hy);
                str = c18288hy.cCT.cCU;
                c6494hz = new C6494hz();
                C4879a.xxA.mo10055m(c6494hz);
                str2 = c6494hz.cCV.cCW;
                C1720g.m3540Rg().mo14539a(132, (C1202f) this);
                c38037x = new C38037x(this.gEE.cFl, 2, this.gEE.grL.getText().toString().trim(), "", str, str2);
                C1720g.m3540Rg().mo14541a(c38037x, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(C25738R.string.f9238tz);
                mobileVerifyUI.ehJ = C30379h.m48458b(context, this.gEE.getString(C25738R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(125244);
                        C1720g.m3540Rg().mo14547c(c38037x);
                        C1720g.m3540Rg().mo14546b(132, C41219n.this);
                        AppMethodBeat.m2505o(125244);
                    }
                });
                break;
        }
        AppMethodBeat.m2505o(125248);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(125249);
        C4990ab.m7416i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        if (c1207m.getType() == 132) {
            C1720g.m3540Rg().mo14546b(132, (C1202f) this);
            if (((C38037x) c1207m).mo60786Ah() == 2 && i == 0 && i2 == 0) {
                C1668a.unhold();
                if (C46482a.m87695fB(this.gEE).size() != 0) {
                    i3 = 1;
                }
                Intent bh;
                if (this.gsy == null || !this.gsy.contains("1") || i3 == 0) {
                    bh = C24679a.gkE.mo38909bh(this.gEE);
                    bh.addFlags(67108864);
                    this.gEE.startActivity(bh);
                    this.gEE.gFj = 4;
                    this.gEE.finish();
                    AppMethodBeat.m2505o(125249);
                    return;
                }
                C42756a.m75796wA("R300_300_QQ");
                bh = new Intent(this.gEE, FindMContactAddUI.class);
                bh.addFlags(67108864);
                bh.putExtra("regsetinfo_ticket", this.elr);
                bh.putExtra("regsetinfo_NextStep", this.gsy);
                bh.putExtra("regsetinfo_NextStyle", this.gsz);
                bh.putExtra("login_type", 1);
                Intent bh2 = C24679a.gkE.mo38909bh(this.gEE);
                bh2.addFlags(67108864);
                MMWizardActivity.m23792b(this.gEE, bh, bh2);
                this.gEE.finish();
                AppMethodBeat.m2505o(125249);
                return;
            }
            AppMethodBeat.m2505o(125249);
        } else if (this.gEE.mo17511j(i, i2, str)) {
            AppMethodBeat.m2505o(125249);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.gEE, this.gEE.getString(C25738R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.m2505o(125249);
        }
    }
}
