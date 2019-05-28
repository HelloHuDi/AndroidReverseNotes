package com.tencent.p177mm.p612ui.tools;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C6686q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.applet.SecurityImage.C15492a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.account.p275ui.DisasterUI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ui.tools.NewTaskUI */
public class NewTaskUI extends MMBaseActivity implements C1202f {
    static NewTaskUI zGD;
    private ProgressDialog ehJ = null;
    private C4884c gAY = new C240361();
    private SecurityImage gue = null;
    private C31504g zGE = new C31504g();

    /* renamed from: com.tencent.mm.ui.tools.NewTaskUI$1 */
    class C240361 extends C4884c<C37745jk> {
        C240361() {
            AppMethodBeat.m2504i(34915);
            this.xxI = C37745jk.class.getName().hashCode();
            AppMethodBeat.m2505o(34915);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34916);
            C37745jk c37745jk = (C37745jk) c4883b;
            if (c37745jk == null || c37745jk.cEJ == null) {
                AppMethodBeat.m2505o(34916);
                return false;
            }
            C4990ab.m7417i("MicroMsg.NewTaskUI", "summerdiz loginDisasterListener callback content[%s], url[%s]", c37745jk.cEJ.content, c37745jk.cEJ.url);
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", c37745jk.cEJ.content);
            intent.putExtra("key_disaster_url", c37745jk.cEJ.url);
            intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
            C4996ah.getContext().startActivity(intent);
            AppMethodBeat.m2505o(34916);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.NewTaskUI$3 */
    class C408853 implements OnClickListener {
        C408853() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34919);
            C4990ab.m7416i("MicroMsg.NewTaskUI", "dkwt dlg imgSid:" + NewTaskUI.this.zGE.guh + " img len" + NewTaskUI.this.zGE.gug.length + " " + C1447g.m3075Mq());
            if (NewTaskUI.this.gue == null) {
                C4990ab.m7410d("MicroMsg.NewTaskUI", "[arthurdan.SecurityImageCrash] fatal error!!! secimg is null!");
                AppMethodBeat.m2505o(34919);
                return;
            }
            final C1207m c6686q = new C6686q(NewTaskUI.this.zGE.gCL, NewTaskUI.this.gue.getSecImgCode(), NewTaskUI.this.gue.getSecImgSid(), NewTaskUI.this.gue.getSecImgEncryptKey());
            C9638aw.m17182Rg().mo14541a(c6686q, 0);
            NewTaskUI newTaskUI = NewTaskUI.this;
            Context context = NewTaskUI.this;
            NewTaskUI.this.getString(C25738R.string.f9238tz);
            newTaskUI.ehJ = C30379h.m48458b(context, NewTaskUI.this.getString(C25738R.string.cou), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(34918);
                    C9638aw.m17182Rg().mo14547c(c6686q);
                    AppMethodBeat.m2505o(34918);
                }
            });
            AppMethodBeat.m2505o(34919);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.NewTaskUI$4 */
    class C408864 implements OnCancelListener {
        C408864() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34920);
            if (NewTaskUI.zGD != null) {
                NewTaskUI.zGD = null;
                NewTaskUI.this.finish();
            }
            AppMethodBeat.m2505o(34920);
        }
    }

    /* renamed from: com.tencent.mm.ui.tools.NewTaskUI$5 */
    class C408875 implements OnDismissListener {
        C408875() {
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(34921);
            NewTaskUI.this.gue = null;
            AppMethodBeat.m2505o(34921);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NewTaskUI() {
        AppMethodBeat.m2504i(34922);
        AppMethodBeat.m2505o(34922);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(34923);
        super.onCreate(bundle);
        C4990ab.m7417i("MicroMsg.NewTaskUI", "onCreate :%d", Integer.valueOf(hashCode()));
        setContentView(2130968794);
        C9638aw.m17182Rg().mo14539a(701, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(252, (C1202f) this);
        zGD = this;
        final C1207m c6686q = new C6686q(0, "", "", "");
        C9638aw.m17182Rg().mo14541a(c6686q, 0);
        getString(C25738R.string.f9238tz);
        this.ehJ = C30379h.m48458b((Context) this, getString(C25738R.string.cou), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(34917);
                C9638aw.m17182Rg().mo14547c(c6686q);
                AppMethodBeat.m2505o(34917);
            }
        });
        AppMethodBeat.m2505o(34923);
    }

    public void onResume() {
        AppMethodBeat.m2504i(34924);
        C4879a.xxA.mo10052c(this.gAY);
        super.onResume();
        AppMethodBeat.m2505o(34924);
    }

    public void onPause() {
        AppMethodBeat.m2504i(34925);
        super.onPause();
        C4879a.xxA.mo10053d(this.gAY);
        AppMethodBeat.m2505o(34925);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34926);
        C4990ab.m7417i("MicroMsg.NewTaskUI", "onDestroy :%d", Integer.valueOf(hashCode()));
        if (equals(zGD)) {
            zGD = null;
        }
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (this.gue != null) {
            this.gue.dismiss();
        }
        C9638aw.m17182Rg().mo14546b(701, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(252, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(34926);
    }

    public static NewTaskUI dJR() {
        return zGD;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34927);
        C4990ab.m7417i("MicroMsg.NewTaskUI", "onSceneEnd :%d  [%d,%d,%s]", Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), str);
        if (this.ehJ != null && this.ehJ.isShowing()) {
            this.ehJ.dismiss();
        }
        if (i == 4 && i2 == -3) {
            C4990ab.m7417i("MicroMsg.NewTaskUI", "summerauth MM_ERR_PASSWORD need kick out acc ready[%b]", Boolean.valueOf(C9638aw.m17179RK()));
            if (C30777u.m49118a(zGD, i, i2, new Intent().setClass(zGD, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                AppMethodBeat.m2505o(34927);
                return;
            }
        }
        if (i == 4 && (i2 == -6 || i2 == -311 || i2 == -310)) {
            if (c1207m instanceof C6686q) {
                C6686q c6686q = (C6686q) c1207m;
                this.zGE.gCL = c6686q.getSecCodeType();
                this.zGE.gug = c6686q.ajo();
                this.zGE.guh = c6686q.ajn();
                this.zGE.gui = c6686q.ajp();
                C4990ab.m7416i("MicroMsg.NewTaskUI", "onSceneEnd dkwt imgSid:" + this.zGE.guh + " img len" + this.zGE.gug.length + " " + C1447g.m3075Mq());
            }
            if (this.gue == null) {
                this.gue = C15492a.m23811a(this, this.zGE.gCL, this.zGE.gug, this.zGE.guh, this.zGE.gui, new C408853(), new C408864(), new C408875(), this.zGE);
                AppMethodBeat.m2505o(34927);
                return;
            }
            C4990ab.m7410d("MicroMsg.NewTaskUI", "imgSid:" + this.zGE.guh + " img len" + this.zGE.gug.length + " " + C1447g.m3075Mq());
            this.gue.mo27573b(this.zGE.gCL, this.zGE.gug, this.zGE.guh, this.zGE.gui);
            AppMethodBeat.m2505o(34927);
            return;
        }
        zGD = null;
        finish();
        AppMethodBeat.m2505o(34927);
    }
}
