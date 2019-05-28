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
import com.tencent.mm.g.a.hy;
import com.tencent.mm.g.a.hz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;
import com.tencent.mm.plugin.account.friend.ui.FindMContactAddUI;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public final class n implements f, b {
    private String elr = null;
    private MobileVerifyUI gEE;
    private String gsy = "";
    private int gsz = 2;

    public final void a(MobileVerifyUI mobileVerifyUI) {
        AppMethodBeat.i(125247);
        this.gEE = mobileVerifyUI;
        this.elr = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_ticket");
        this.gsy = mobileVerifyUI.getIntent().getStringExtra("regsetinfo_NextStep");
        this.gsz = mobileVerifyUI.getIntent().getIntExtra("regsetinfo_NextStyle", 2);
        AppMethodBeat.o(125247);
    }

    public final void start() {
    }

    public final void stop() {
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(125248);
        hy hyVar;
        String str;
        hz hzVar;
        String str2;
        final m xVar;
        MobileVerifyUI mobileVerifyUI;
        Context context;
        switch (aVar) {
            case GoNext:
                hyVar = new hy();
                hyVar.cCS.context = this.gEE;
                a.xxA.m(hyVar);
                str = hyVar.cCT.cCU;
                hzVar = new hz();
                a.xxA.m(hzVar);
                str2 = hzVar.cCV.cCW;
                g.Rg().a(132, (f) this);
                xVar = new x(this.gEE.cFl, 2, this.gEE.grL.getText().toString().trim(), "", str, str2);
                g.Rg().a(xVar, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(R.string.tz);
                mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125245);
                        g.Rg().c(xVar);
                        g.Rg().b(132, n.this);
                        AppMethodBeat.o(125245);
                    }
                });
                break;
            case DoSend:
                g.Rg().a(132, (f) this);
                g.Rg().a(new x(this.gEE.cFl, 1, "", 0, ""), 0);
                break;
            case DoProcessSMS:
                hyVar = new hy();
                hyVar.cCS.context = this.gEE;
                a.xxA.m(hyVar);
                str = hyVar.cCT.cCU;
                hzVar = new hz();
                a.xxA.m(hzVar);
                str2 = hzVar.cCV.cCW;
                g.Rg().a(132, (f) this);
                xVar = new x(this.gEE.cFl, 2, this.gEE.grL.getText().toString().trim(), "", str, str2);
                g.Rg().a(xVar, 0);
                mobileVerifyUI = this.gEE;
                context = this.gEE;
                this.gEE.getString(R.string.tz);
                mobileVerifyUI.ehJ = h.b(context, this.gEE.getString(R.string.a7n), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125244);
                        g.Rg().c(xVar);
                        g.Rg().b(132, n.this);
                        AppMethodBeat.o(125244);
                    }
                });
                break;
        }
        AppMethodBeat.o(125248);
        return false;
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(125249);
        ab.i("MicroMsg.MobileVerifyQQRegLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gEE.ehJ != null) {
            this.gEE.ehJ.dismiss();
            this.gEE.ehJ = null;
        }
        if (mVar.getType() == 132) {
            g.Rg().b(132, (f) this);
            if (((x) mVar).Ah() == 2 && i == 0 && i2 == 0) {
                com.tencent.mm.kernel.a.unhold();
                if (com.tencent.mm.pluginsdk.a.fB(this.gEE).size() != 0) {
                    i3 = 1;
                }
                Intent bh;
                if (this.gsy == null || !this.gsy.contains("1") || i3 == 0) {
                    bh = com.tencent.mm.plugin.account.a.a.gkE.bh(this.gEE);
                    bh.addFlags(67108864);
                    this.gEE.startActivity(bh);
                    this.gEE.gFj = 4;
                    this.gEE.finish();
                    AppMethodBeat.o(125249);
                    return;
                }
                com.tencent.mm.plugin.b.a.wA("R300_300_QQ");
                bh = new Intent(this.gEE, FindMContactAddUI.class);
                bh.addFlags(67108864);
                bh.putExtra("regsetinfo_ticket", this.elr);
                bh.putExtra("regsetinfo_NextStep", this.gsy);
                bh.putExtra("regsetinfo_NextStyle", this.gsz);
                bh.putExtra("login_type", 1);
                Intent bh2 = com.tencent.mm.plugin.account.a.a.gkE.bh(this.gEE);
                bh2.addFlags(67108864);
                MMWizardActivity.b(this.gEE, bh, bh2);
                this.gEE.finish();
                AppMethodBeat.o(125249);
                return;
            }
            AppMethodBeat.o(125249);
        } else if (this.gEE.j(i, i2, str)) {
            AppMethodBeat.o(125249);
        } else {
            if (!(i == 0 && i2 == 0)) {
                Toast.makeText(this.gEE, this.gEE.getString(R.string.a7r, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
            AppMethodBeat.o(125249);
        }
    }
}
