package com.tencent.p177mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.sandbox.C15411c;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sandbox.updater.C44215j.C23491a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.sandbox.updater.AppInstallerUI */
public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI xvC = null;
    private String cvZ;
    private String desc;
    private C5653c gud = null;
    private int rlf;
    private C5653c xvB = null;
    private OnClickListener xvD = new C48522();

    /* renamed from: com.tencent.mm.sandbox.updater.AppInstallerUI$2 */
    class C48522 implements OnClickListener {
        C48522() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28798);
            C4990ab.m7410d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (AppInstallerUI.this.rlf == 2) {
                C44212i.m79788aq(AppInstallerUI.this, 3);
            }
            String RP = C15412c.m23693RP(AppInstallerUI.this.cvZ);
            C4990ab.m7410d("MicroMsg.AppInstallerUI", RP);
            if (RP != null) {
                C23491a.xxg.mo69850aB(1, true);
                C7060h.pYm.mo8378a(405, 72, 1, true);
                AppInstallerUI.m70016a(AppInstallerUI.this, RP);
                AppMethodBeat.m2505o(28798);
                return;
            }
            C7060h.pYm.mo8378a(405, 73, 1, true);
            C4990ab.m7412e("MicroMsg.AppInstallerUI", "pack not found!");
            C30379h.m48465bQ(AppInstallerUI.this, AppInstallerUI.this.getString(C25738R.string.eyr));
            C44212i.dnB();
            AppInstallerUI.this.finish();
            AppMethodBeat.m2505o(28798);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppInstallerUI$1 */
    class C302751 implements OnCancelListener {
        C302751() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(28797);
            AppInstallerUI.m70015a(AppInstallerUI.this);
            AppMethodBeat.m2505o(28797);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppInstallerUI$5 */
    class C359775 implements OnClickListener {
        C359775() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28801);
            C7060h.pYm.mo8378a(405, 75, 1, true);
            if (!(AppInstallerUI.this.gud == null || AppInstallerUI.this.gud.isShowing())) {
                AppInstallerUI.this.gud.show();
            }
            AppMethodBeat.m2505o(28801);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppInstallerUI$4 */
    class C406054 implements OnClickListener {
        C406054() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28800);
            C4990ab.m7410d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
            if (AppInstallerUI.this.gud != null && AppInstallerUI.this.gud.isShowing()) {
                AppInstallerUI.this.gud.dismiss();
            }
            C23491a.xxg.mo69850aB(2, true);
            if (AppInstallerUI.this.rlf == 2) {
                C44212i.m79788aq(AppInstallerUI.this, 4);
            }
            C7060h.pYm.mo8378a(405, 74, 1, true);
            C44212i.dnw();
            AppInstallerUI.m70019d(AppInstallerUI.this);
            AppMethodBeat.m2505o(28800);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppInstallerUI() {
        AppMethodBeat.m2504i(28802);
        AppMethodBeat.m2505o(28802);
    }

    public static AppInstallerUI dng() {
        return xvC;
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(28803);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.AppInstallerUI", "onCreate");
        C15411c.m23691l(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppUpdaterUI.dnh() != null && !AppUpdaterUI.dnh().isFinishing()) {
            C4990ab.m7410d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
            AppMethodBeat.m2505o(28803);
        } else if (xvC == null || xvC.isFinishing() || xvC == this) {
            xvC = this;
            this.cvZ = C44212i.dhU();
            if (C5046bo.isNullOrNil(this.cvZ) || C15412c.m23693RP(this.cvZ) == null) {
                finish();
                AppMethodBeat.m2505o(28803);
                return;
            }
            this.desc = C44212i.dnt();
            this.rlf = C44212i.dnu();
            setContentView(2130969389);
            C5652a c5652a = new C5652a(this);
            c5652a.mo11446PV(C25738R.string.byv);
            c5652a.mo11482rc(true);
            c5652a.mo11478f(new C302751());
            c5652a.asE(getString(C25738R.string.byy, new Object[]{this.desc}));
            c5652a.mo11453Qc(C25738R.string.cdx).mo11462a(false, this.xvD);
            c5652a.mo11454Qd(C25738R.string.eyp).mo11476b(null);
            this.gud = c5652a.aMb();
            this.gud.setCanceledOnTouchOutside(false);
            this.gud.show();
            C7060h.pYm.mo8378a(405, 71, 1, true);
            if (this.rlf == 2) {
                C44212i.m79789d(this, 2, C44212i.dnv() + 1);
            }
            AppMethodBeat.m2505o(28803);
        } else {
            C4990ab.m7410d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
            AppMethodBeat.m2505o(28803);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(28804);
        C4990ab.m7410d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.gud != null && this.gud.isShowing()) {
            this.gud.dismiss();
        }
        if (this.xvB != null && this.xvB.isShowing()) {
            this.xvB.dismiss();
        }
        if (xvC == this) {
            xvC = null;
        }
        C15411c.m23692m(hashCode(), this);
        super.onDestroy();
        AppMethodBeat.m2505o(28804);
    }

    /* renamed from: a */
    static /* synthetic */ void m70015a(AppInstallerUI appInstallerUI) {
        AppMethodBeat.m2504i(28805);
        C4990ab.m7410d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.gud != null && appInstallerUI.gud.isShowing()) {
            appInstallerUI.gud.dismiss();
        }
        if (appInstallerUI.xvB == null || !appInstallerUI.xvB.isShowing()) {
            appInstallerUI.xvB = C30379h.m48429a((Context) appInstallerUI, (int) C25738R.string.ac0, (int) C25738R.string.f9238tz, (int) C25738R.string.ac1, (int) C25738R.string.b33, false, new C406054(), new C359775());
            AppMethodBeat.m2505o(28805);
            return;
        }
        C4990ab.m7410d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
        AppMethodBeat.m2505o(28805);
    }

    /* renamed from: a */
    static /* synthetic */ void m70016a(AppInstallerUI appInstallerUI, final String str) {
        AppMethodBeat.m2504i(28806);
        new C7306ak().postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(28799);
                C30035i.m47536aC(AppInstallerUI.this, str);
                AppInstallerUI.m70019d(AppInstallerUI.this);
                AppMethodBeat.m2505o(28799);
            }
        }, 300);
        AppMethodBeat.m2505o(28806);
    }

    /* renamed from: d */
    static /* synthetic */ void m70019d(AppInstallerUI appInstallerUI) {
        AppMethodBeat.m2504i(28807);
        appInstallerUI.finish();
        AppMethodBeat.m2505o(28807);
    }
}
