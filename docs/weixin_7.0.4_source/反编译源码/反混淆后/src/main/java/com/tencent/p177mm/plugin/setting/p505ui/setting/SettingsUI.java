package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C37914bx;
import com.tencent.p177mm.model.C6665av;
import com.tencent.p177mm.modelsimple.C32822ab;
import com.tencent.p177mm.modelsimple.C32828p;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.modelstat.C37957c;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16107a.C16108a;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p182ah.C37439m;
import com.tencent.p177mm.p182ah.C41730b;
import com.tencent.p177mm.p182ah.C41732d;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p230g.p231a.C18251em;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6484gj;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.SwitchKeyValuePreference;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l;
import com.tencent.p177mm.plugin.account.friend.p272a.C38033l.C38034a;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.plugin.expt.p394a.C43014c;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C14714c;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14987n;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4978c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.util.ArrayList;

@C18524i
/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI */
public class SettingsUI extends MMPreference implements C4937b {
    private C15541f ehK;
    private C7564ap fJs = null;
    private C1202f fQS = null;
    private C7564ap gyS;
    private C36356d iHZ;
    private View nVX;
    private ProgressDialog qlZ = null;
    private C7564ap qma;
    private C1202f qmb = null;
    private PersonalPreference qpt = null;
    private C1202f qpu = null;
    private C16108a qpv = new C132361();
    private Dialog qpw = null;
    private C5653c qpx;
    private CheckBox qpy;
    private C1202f qpz = null;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$24 */
    class C381524 implements C36073c {
        C381524() {
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(127587);
            if (c44273l.dzR()) {
                c44273l.mo70063ax(1, C25738R.string.cpf, C1318a.menu_logout_single);
                c44273l.mo70063ax(2, C25738R.string.cpd, C1318a.menu_close_wechat);
            }
            AppMethodBeat.m2505o(127587);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$25 */
    class C381625 implements C15994a {
        C381625() {
        }

        public final void onDismiss() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$27 */
    class C381727 implements OnClickListener {
        C381727() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(127589);
            C4978c.m7375a(SettingsUI.this.nDp);
            AppMethodBeat.m2505o(127589);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$2 */
    class C38182 implements DialogInterface.OnClickListener {
        C38182() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127561);
            C7060h.pYm.mo8381e(11545, Integer.valueOf(3));
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
            C7060h.pYm.mo8378a(99, 145, 1, false);
            if (!(C1720g.m3540Rg() == null || C1720g.m3540Rg().ftA == null)) {
                C1720g.m3540Rg().ftA.mo5532cG(false);
            }
            if (SettingsUI.this.qpw != null) {
                SettingsUI.this.qpw.dismiss();
            }
            SettingsUI.m45978g(SettingsUI.this);
            AppMethodBeat.m2505o(127561);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$26 */
    class C708326 implements C5279d {
        C708326() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(127588);
            switch (menuItem.getItemId()) {
                case 1:
                    SettingsUI.m45974c(SettingsUI.this);
                    AppMethodBeat.m2505o(127588);
                    return;
                case 2:
                    SettingsUI.m45975d(SettingsUI.this);
                    break;
            }
            AppMethodBeat.m2505o(127588);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$12 */
    class C1323512 implements Runnable {
        C1323512() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127572);
            C1720g.m3536RP().mo5239Ry().dsb();
            AppMethodBeat.m2505o(127572);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$1 */
    class C132361 implements C16108a {
        C132361() {
        }

        /* renamed from: p */
        public final void mo25292p(int i, String str) {
            AppMethodBeat.m2504i(127559);
            if (i == 262145 || i == 262157 || i == 262158) {
                SettingsUI.m45972a(SettingsUI.this);
            }
            AppMethodBeat.m2505o(127559);
        }

        /* renamed from: b */
        public final void mo25291b(C5127a c5127a) {
            AppMethodBeat.m2504i(127560);
            if (c5127a != null && c5127a == C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                SettingsUI.m45973b(SettingsUI.this);
            }
            AppMethodBeat.m2505o(127560);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$28 */
    class C1323728 implements DialogInterface.OnClickListener {
        C1323728() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127590);
            SettingsUI.m45976e(SettingsUI.this);
            AppMethodBeat.m2505o(127590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$9 */
    class C132399 implements C1202f {
        C132399() {
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(127569);
            C4990ab.m7410d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(127568);
                    C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                    SettingsUI.this.qmb = null;
                    if (SettingsUI.this.qma != null) {
                        SettingsUI.this.qma.stopTimer();
                        SettingsUI.this.qma = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    if (c1207m.getType() == 255 && ((C9706r) c1207m).fPr == 2) {
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(SettingsUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", SettingsUI.this.getString(C25738R.string.dlz));
                            SettingsUI.this.startActivityForResult(intent, 5);
                            AppMethodBeat.m2505o(127568);
                            return;
                        }
                        SettingsUI.m45993u(SettingsUI.this);
                    }
                    AppMethodBeat.m2505o(127568);
                }
            });
            AppMethodBeat.m2505o(127569);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$14 */
    class C2179514 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$14$1 */
        class C217961 implements Runnable {
            C217961() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127574);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                SettingsUI.this.fQS = null;
                AppMethodBeat.m2505o(127574);
            }
        }

        C2179514() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(127575);
            C5004al.m7441d(new C217961());
            AppMethodBeat.m2505o(127575);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$13 */
    class C2896413 implements DialogInterface.OnClickListener {
        C2896413() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127573);
            SettingsUI.m45978g(SettingsUI.this);
            AppMethodBeat.m2505o(127573);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$20 */
    class C2896520 implements C1202f {
        C2896520() {
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(127583);
            C4990ab.m7410d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(127582);
                    C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                    SettingsUI.this.qmb = null;
                    if (SettingsUI.this.qma != null) {
                        SettingsUI.this.qma.stopTimer();
                        SettingsUI.this.qma = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    if (c1207m.getType() == 255 && ((C9706r) c1207m).fPr == 1) {
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(SettingsUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", SettingsUI.this.getString(C25738R.string.dlz));
                            SettingsUI.this.startActivityForResult(intent, 0);
                            AppMethodBeat.m2505o(127582);
                            return;
                        }
                        SettingsUI.m45971B(SettingsUI.this);
                    }
                    AppMethodBeat.m2505o(127582);
                }
            });
            AppMethodBeat.m2505o(127583);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$23 */
    class C2896923 implements OnMenuItemClickListener {
        C2896923() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127586);
            SettingsUI.this.finish();
            AppMethodBeat.m2505o(127586);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$3 */
    class C289703 implements DialogInterface.OnClickListener {
        C289703() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127562);
            C7060h.pYm.mo8381e(11545, Integer.valueOf(2));
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
            if (SettingsUI.this.qpw != null) {
                SettingsUI.this.qpw.dismiss();
            }
            AppMethodBeat.m2505o(127562);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$4 */
    class C289714 implements DialogInterface.OnClickListener {
        C289714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127563);
            C37957c.akc().commitNow();
            ((C43014c) C1720g.m3528K(C43014c.class)).logout();
            if (SettingsUI.this.qpy == null || !SettingsUI.this.qpy.isChecked()) {
                C4990ab.m7416i("MicroMsg.SettingsUI", "normally exit");
                C7060h.pYm.mo8378a(99, 144, 1, false);
                C7060h.pYm.mo8381e(11545, Integer.valueOf(7));
                C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
                if (!(C1720g.m3540Rg() == null || C1720g.m3540Rg().ftA == null)) {
                    C1720g.m3540Rg().ftA.mo5532cG(false);
                }
                C4879a.xxA.mo10055m(new C6484gj());
                SettingsUI.m45981j(SettingsUI.this);
                AppMethodBeat.m2505o(127563);
                return;
            }
            C4990ab.m7416i("MicroMsg.SettingsUI", "push notify mode exit");
            C7060h.pYm.mo8378a(99, 143, 1, false);
            C7060h.pYm.mo8381e(11545, Integer.valueOf(6));
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
            C1892aa.anh().edit().putBoolean("is_in_notify_mode", true).commit();
            SettingsUI.m45980i(SettingsUI.this);
            AppMethodBeat.m2505o(127563);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$19 */
    class C2897419 implements C1202f {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$19$1 */
        class C289751 implements Runnable {
            C289751() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127580);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, SettingsUI.this.fQS);
                SettingsUI.this.qpu = null;
                AppMethodBeat.m2505o(127580);
            }
        }

        C2897419() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(127581);
            String Yz = C1853r.m3846Yz();
            if (C37914bx.fnB.mo60670oL(Yz)) {
                C37914bx.fnB.mo60668n(Yz, "last_logout_no_pwd_ticket", "");
            }
            C5004al.m7441d(new C289751());
            AppMethodBeat.m2505o(127581);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$29 */
    class C2897629 implements Runnable {
        C2897629() {
        }

        public final void run() {
            AppMethodBeat.m2504i(127591);
            C45287c.aNX();
            AppMethodBeat.m2505o(127591);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$6 */
    class C289776 implements C1202f {
        C289776() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(127565);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
            SettingsUI.this.qpz = null;
            if (SettingsUI.this.fJs != null) {
                SettingsUI.this.fJs.stopTimer();
                SettingsUI.this.fJs = null;
            }
            if (SettingsUI.this.qlZ != null) {
                SettingsUI.this.qlZ.dismiss();
            }
            SettingsUI.m45988p(SettingsUI.this);
            AppMethodBeat.m2505o(127565);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$18 */
    class C2897818 implements OnCancelListener {
        C2897818() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(127579);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
            SettingsUI.this.fQS = null;
            SettingsUI.this.qpu = null;
            if (SettingsUI.this.qma != null) {
                SettingsUI.this.qma.stopTimer();
                SettingsUI.this.qma = null;
            }
            if (SettingsUI.this.qlZ != null) {
                SettingsUI.this.qlZ.dismiss();
            }
            AppMethodBeat.m2505o(127579);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$17 */
    class C2898017 implements C5015a {
        C2898017() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(127578);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
            SettingsUI.this.fQS = null;
            SettingsUI.this.qpu = null;
            if (SettingsUI.this.gyS != null) {
                SettingsUI.this.gyS.stopTimer();
            }
            if (SettingsUI.this.qlZ != null) {
                SettingsUI.this.qlZ.cancel();
            }
            SettingsUI.m45998z(SettingsUI.this);
            AppMethodBeat.m2505o(127578);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsUI$5 */
    class C289815 implements DialogInterface.OnClickListener {
        C289815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127564);
            C7060h.pYm.mo8381e(11545, Integer.valueOf(5));
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
            AppMethodBeat.m2505o(127564);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsUI() {
        AppMethodBeat.m2504i(127592);
        AppMethodBeat.m2505o(127592);
    }

    /* renamed from: a */
    static /* synthetic */ void m45972a(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127612);
        settingsUI.ciE();
        AppMethodBeat.m2505o(127612);
    }

    /* renamed from: b */
    static /* synthetic */ void m45973b(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127613);
        settingsUI.cji();
        AppMethodBeat.m2505o(127613);
    }

    /* renamed from: c */
    static /* synthetic */ boolean m45974c(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127614);
        boolean cjm = settingsUI.cjm();
        AppMethodBeat.m2505o(127614);
        return cjm;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m45975d(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127615);
        boolean cjn = settingsUI.cjn();
        AppMethodBeat.m2505o(127615);
        return cjn;
    }

    /* renamed from: e */
    static /* synthetic */ void m45976e(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127616);
        settingsUI.cjl();
        AppMethodBeat.m2505o(127616);
    }

    /* renamed from: i */
    static /* synthetic */ void m45980i(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127618);
        settingsUI.m45983kr(false);
        AppMethodBeat.m2505o(127618);
    }

    /* renamed from: p */
    static /* synthetic */ void m45988p(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127620);
        settingsUI.cjp();
        AppMethodBeat.m2505o(127620);
    }

    /* renamed from: z */
    static /* synthetic */ void m45998z(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127622);
        settingsUI.cje();
        AppMethodBeat.m2505o(127622);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8544bs;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127593);
        super.onCreate(bundle);
        initView();
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        C16112c.m24429PK().mo28543a(this.qpv);
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1 && (C1720g.m3536RP().mo5239Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
            C4990ab.m7416i("MicroMsg.SettingsUI", "unset more tab dot");
        }
        AppMethodBeat.m2505o(127593);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127594);
        if (C1720g.m3531RK()) {
            C1720g.m3536RP().mo5239Ry().mo10121b(this);
            C16112c.m24429PK().mo28549b(this.qpv);
        }
        if (this.fQS != null) {
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, this.fQS);
        }
        if (this.qmb != null) {
            C1720g.m3540Rg().mo14546b(255, this.qmb);
        }
        if (this.qpz != null) {
            C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, this.qpz);
        }
        super.onDestroy();
        AppMethodBeat.m2505o(127594);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127595);
        C4990ab.m7418v("MicroMsg.SettingsUI", "settings handle");
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.m2505o(127595);
                    return;
                }
                h = C14987n.m23320h(getApplicationContext(), intent, C43217c.m76863XW());
                if (h == null) {
                    AppMethodBeat.m2505o(127595);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                C17884o.acd();
                intent2.putExtra("CropImage_OutputPath", C41732d.m73515D(C1853r.m3846Yz(), true));
                intent2.putExtra("CropImage_ImgPath", h);
                C24824b.gkE.mo38891a((Activity) this, intent, intent2, C43217c.m76863XW(), 4, null);
                AppMethodBeat.m2505o(127595);
                return;
            case 3:
                h = C14987n.m23320h(getApplicationContext(), intent, C43217c.m76863XW());
                if (h == null) {
                    AppMethodBeat.m2505o(127595);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h);
                intent3.putExtra("CropImage_ImgPath", h);
                C24824b.gkE.mo38890a(this.mController.ylL, intent3, 4);
                AppMethodBeat.m2505o(127595);
                return;
            case 4:
                if (intent == null) {
                    AppMethodBeat.m2505o(127595);
                    return;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                if (h == null) {
                    C4990ab.m7412e("MicroMsg.SettingsUI", "crop picture failed");
                } else {
                    new C37439m(this.mController.ylL, h).mo60330w(null);
                }
                super.onActivityResult(i, i2, intent);
                AppMethodBeat.m2505o(127595);
                return;
            case 5:
                if (i2 == -1) {
                    cje();
                }
                AppMethodBeat.m2505o(127595);
                return;
            default:
                AppMethodBeat.m2505o(127595);
                return;
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(127596);
        super.onPause();
        C1720g.m3539RS().mo10303ae(new C1323512());
        AppMethodBeat.m2505o(127596);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127597);
        PersonalPreference personalPreference = (PersonalPreference) this.ehK.aqO("settings_account");
        if (personalPreference != null) {
            String Yz = C1853r.m3846Yz();
            personalPreference.fru = null;
            personalPreference.qkZ = -1;
            personalPreference.qla = Yz;
            if (personalPreference.moN != null) {
                C40460b.m69434b(personalPreference.moN, personalPreference.qla);
            }
        }
        C18251em c18251em = new C18251em();
        C4879a.xxA.mo10055m(c18251em);
        if (!c18251em.cxZ.cwB) {
            this.ehK.mo27716d(this.ehK.aqO("settings_about_device"));
        }
        cji();
        cjk();
        ciE();
        cjj();
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_welab");
        C14714c c14714c = (C14714c) C1720g.m3528K(C14714c.class);
        if (c14714c.ddo()) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
        } else {
            iconPreference.mo48763NL(8);
        }
        if (!c14714c.ddp()) {
            iconPreference.mo48776hm(8, -1);
        } else if (c14714c.ddn()) {
            iconPreference.mo48776hm(0, C25738R.drawable.a4h);
        } else {
            iconPreference.mo48776hm(0, C1318a.welab_icon_grey);
        }
        C4990ab.m7418v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
        AppMethodBeat.m2505o(127597);
    }

    private void cji() {
        AppMethodBeat.m2504i(127598);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_account_info");
        if (iconPreference == null) {
            C4990ab.m7412e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            AppMethodBeat.m2505o(127598);
            return;
        }
        iconPreference.mo48768NQ(8);
        if (C16112c.m24429PK().mo28545a(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257)) {
            iconPreference.mo48765NN(0);
        } else {
            iconPreference.mo48765NN(8);
        }
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1) {
            if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            } else if ((C1720g.m3536RP().mo5239Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                iconPreference.mo48763NL(0);
                C4990ab.m7416i("MicroMsg.SettingsUI", "show voiceprint dot");
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(127598);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127599);
        setMMTitle((int) C25738R.string.ebr);
        this.ehK = this.yCw;
        setBackBtn(new C2896923());
        this.iHZ = new C36356d(this, 1, false);
        this.iHZ.rBl = new C381524();
        this.iHZ.zQf = new C381625();
        this.iHZ.rBm = new C708326();
        C381727 c381727 = new C381727();
        cjk();
        ciE();
        cjj();
        this.ehK.mo27715ce("settings_redesign", true);
        AppMethodBeat.m2505o(127599);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127600);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(127600);
            return;
        }
        if (4 == g) {
            C1720g.m3536RP().mo5239Ry().get(2, null);
            C1720g.m3536RP().mo5239Ry().get(4, null);
        }
        if (6 == g) {
            cjk();
            AppMethodBeat.m2505o(127600);
            return;
        }
        if (64 == g) {
            cji();
        }
        AppMethodBeat.m2505o(127600);
    }

    private void ciE() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(127601);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_about_micromsg");
        boolean a = C5046bo.m7517a(Boolean.valueOf(C16112c.m24429PK().mo28551bX(262145, 266243)), false);
        boolean bY = C16112c.m24429PK().mo28552bY(262157, 266262);
        if (C5059g.xyg) {
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
        } else if (a) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
        } else if (bY) {
            iconPreference.mo48765NN(0);
        } else {
            iconPreference.mo48765NN(8);
            iconPreference.mo48774ey("", -1);
            iconPreference.mo48763NL(8);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_about_system");
        if (C16112c.m24429PK().mo28552bY(262158, 266265)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.mo48765NN(i);
        C16841a.bVv();
        if (!C1301c.m2776lQ(C32321b.fKD)) {
            i2 = 8;
        }
        iconPreference.mo48765NN(i2);
        AppMethodBeat.m2505o(127601);
    }

    private void cjj() {
        AppMethodBeat.m2504i(127602);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_about_privacy");
        if (iconPreference != null) {
            if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue() > ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                iconPreference.mo48765NN(0);
                AppMethodBeat.m2505o(127602);
                return;
            }
            iconPreference.mo48765NN(8);
        }
        AppMethodBeat.m2505o(127602);
    }

    private void cjk() {
        AppMethodBeat.m2504i(127603);
        C38034a apS = C38033l.apS();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.ehK.aqO("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = apS == C38034a.SUCC || apS == C38034a.SUCC_UNLOAD;
            switchKeyValuePreference.mo70137qk(z);
            int i = (apS == C38034a.SUCC || apS == C38034a.SUCC_UNLOAD) ? C25738R.string.e_8 : C25738R.string.e_7;
            switchKeyValuePreference.setSummary(i);
        }
        AppMethodBeat.m2505o(127603);
    }

    private void cjl() {
        AppMethodBeat.m2504i(127605);
        Intent intent = new Intent(this, SettingsSwitchAccountUI.class);
        intent.putExtra("key_scene", 0);
        startActivity(intent);
        AppMethodBeat.m2505o(127605);
    }

    private void cje() {
        AppMethodBeat.m2504i(127606);
        C4990ab.m7416i("MicroMsg.SettingsUI", "oneliang logout mm");
        C24824b.gkF.mo38849BY();
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        C26171jl c26171jl = new C26171jl();
        c26171jl.cEK.status = 0;
        c26171jl.cEK.boZ = 0;
        C4879a.xxA.mo10055m(c26171jl);
        C45382z c45382z = new C45382z();
        c45382z.csU.csV = true;
        C4879a.xxA.mo10055m(c45382z);
        C4997aj.amB("show_whatsnew");
        C1737l.m3593m(this, true);
        C4996ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        C24824b.gkE.mo38931p(intent, this.mController.ylL);
        C26529w.m42350I(this, null);
        finish();
        AppMethodBeat.m2505o(127606);
    }

    private boolean cjm() {
        AppMethodBeat.m2504i(127607);
        C7060h.pYm.mo8381e(11545, Integer.valueOf(1));
        C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.qpw != null) {
            this.qpw.show();
            AppMethodBeat.m2505o(127607);
        } else {
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.qpw = C30379h.m48466d(this, getString(C25738R.string.e84), "", getString(C25738R.string.e80), getString(C25738R.string.e83), new C38182(), new C289703());
            AppMethodBeat.m2505o(127607);
        }
        return true;
    }

    private boolean cjn() {
        AppMethodBeat.m2504i(127608);
        C7060h.pYm.mo8381e(11545, Integer.valueOf(4));
        C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.nVX == null) {
            this.nVX = View.inflate(this.mController.ylL, 2130970633, null);
            this.qpy = (CheckBox) this.nVX.findViewById(2131827388);
            this.qpy.setChecked(true);
        }
        if (this.qpx == null) {
            this.qpx = C30379h.m48437a(this.mController.ylL, null, this.nVX, getString(C25738R.string.cpd), getString(C25738R.string.f9076or), new C289714(), new C289815());
        } else {
            this.qpx.show();
        }
        AppMethodBeat.m2505o(127608);
        return true;
    }

    private void cjo() {
        AppMethodBeat.m2504i(127609);
        C6300p Rg = C1720g.m3540Rg();
        C1202f c2897419 = new C2897419();
        this.qpu = c2897419;
        Rg.mo14539a((int) C31128d.MIC_PTU_BAIXI, c2897419);
        C1720g.m3540Rg().mo14541a(new C32828p(), 0);
        AppMethodBeat.m2505o(127609);
    }

    /* renamed from: kr */
    private void m45983kr(boolean z) {
        AppMethodBeat.m2504i(127610);
        C4997aj.amB("welcome_page_show");
        if (z) {
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41569II();
        } else {
            ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41583k(-1, null);
        }
        C45382z c45382z = new C45382z();
        c45382z.csU.csV = false;
        C4879a.xxA.mo10055m(c45382z);
        C24824b.gkF.mo38846BV();
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41568IH();
        finish();
        if (C40423e.vdx != null) {
            C40423e.vdx.mo20428k(this.mController.ylL, z);
        }
        AppMethodBeat.m2505o(127610);
    }

    private void cjp() {
        AppMethodBeat.m2504i(127611);
        C6300p Rg = C1720g.m3540Rg();
        C1202f c2896520 = new C2896520();
        this.qmb = c2896520;
        Rg.mo14539a(255, c2896520);
        final C1207m c9706r = new C9706r(2);
        c9706r.fPr = 1;
        C1720g.m3540Rg().mo14541a(c9706r, 0);
        this.qma = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(127584);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.m45971B(SettingsUI.this);
                AppMethodBeat.m2505o(127584);
                return false;
            }
        }, false);
        this.qma.mo16770ae(3000, 3000);
        Context context = this.mController.ylL;
        getString(C25738R.string.f9238tz);
        this.qlZ = C30379h.m48458b(context, getString(C25738R.string.g34), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127585);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.m2505o(127585);
            }
        });
        AppMethodBeat.m2505o(127611);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127604);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsUI", str + " item has been clicked!");
        Intent intent;
        boolean cjn;
        if ("settings_welab".equals(str)) {
            intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add("labs_browse");
            intent.putStringArrayListExtra("key_exclude_apps", arrayList);
            ((C14714c) C1720g.m3528K(C14714c.class)).mo26978D(this, intent);
            AppMethodBeat.m2505o(127604);
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1 && (C1720g.m3536RP().mo5239Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
                C4990ab.m7416i("MicroMsg.SettingsUI", "unset setting account info dot show");
            }
            C16112c.m24429PK().mo28547b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257);
            mo17383aA(SettingsAccountInfoUI.class);
            AppMethodBeat.m2505o(127604);
            return true;
        } else if ("settings_account".equals(str)) {
            this.mController.ylL.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent2 = new Intent(this, BindMContactIntroUI.class);
            intent2.putExtra("key_upload_scene", 4);
            MMWizardActivity.m23791J(this, intent2);
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if (intValue > ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            }
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_about_system")) {
            C16112c.m24429PK().mo28553bZ(262158, 266265);
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            C16112c.m24429PK().mo28553bZ(262145, 266243);
            C16112c.m24429PK().mo28553bZ(262157, 266262);
            this.mController.ylL.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new C7306ak().postDelayed(new C2897629(), 100);
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_about_device")) {
            C25985d.m41467b(this.mController.ylL, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_logout")) {
            if (C17950b.ahP()) {
                C4990ab.m7416i("MicroMsg.SettingsUI", "oversea user logout");
                C30379h.m48453a(this.mController.ylL, true, getResources().getString(C25738R.string.e84), "", getResources().getString(C25738R.string.e80), getString(C25738R.string.f9076or), new C2896413(), null);
                AppMethodBeat.m2505o(127604);
                return true;
            }
            C7060h.pYm.mo8381e(11545, Integer.valueOf(8));
            C4990ab.m7416i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            if (C37914bx.fnB.aat().size() > 1) {
                C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(10), C37914bx.fnB.aau());
            } else {
                C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(10), C37914bx.fnB.aau());
            }
            this.iHZ.cpD();
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_exit")) {
            cjn = cjn();
            AppMethodBeat.m2505o(127604);
            return cjn;
        } else if (str.equals("settings_logout_option")) {
            cjn = cjm();
            AppMethodBeat.m2505o(127604);
            return cjn;
        } else if (str.equals("settings_notification_preference")) {
            startActivity(new Intent(this, SettingsNotificationUI.class));
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_chatting")) {
            mo17383aA(SettingsChattingUI.class);
            AppMethodBeat.m2505o(127604);
            return true;
        } else if (str.equals("settings_active_time")) {
            C7060h.pYm.mo8381e(11351, Integer.valueOf(1), Integer.valueOf(0));
            mo17383aA(SettingsActiveTimeUI.class);
            AppMethodBeat.m2505o(127604);
            return true;
        } else {
            if (str.equals("settings_feedback")) {
                if (!C5059g.xyg && C4988aa.dor().equals("zh_CN")) {
                    str = getString(C25738R.string.g0f);
                } else if (C4988aa.dor().equals("zh_HK")) {
                    str = getString(C25738R.string.g0g);
                } else if (C4988aa.dor().equals("zh_TW")) {
                    str = getString(C25738R.string.g0h);
                } else {
                    str = getString(C25738R.string.g0i);
                }
                C4990ab.m7410d("MicroMsg.SettingsUI", "using faq webpage");
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_feedback", false);
                intent.putExtra("KShowFixToolsBtn", true);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            } else if (str.equals("settings_switch_account")) {
                if (C37914bx.fnB.aat().size() > 1) {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(1), Integer.valueOf(6), C37914bx.fnB.aau());
                } else {
                    C7060h.pYm.mo8381e(14978, Integer.valueOf(0), Integer.valueOf(6), C37914bx.fnB.aau());
                }
                if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, true)) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, Boolean.FALSE);
                    C30379h.m48447a((Context) this, getString(C25738R.string.ebb), getString(C25738R.string.ebc), getString(C25738R.string.f9151r4), false, new C1323728());
                } else {
                    cjl();
                }
            } else if (str.equals("settings_redesign")) {
                startActivity(new Intent(this, SettingRedesign.class));
                AppMethodBeat.m2505o(127604);
                return true;
            }
            AppMethodBeat.m2505o(127604);
            return false;
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m45978g(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127617);
        Object[] objArr = new Object[1];
        C1720g.m3534RN();
        objArr[0] = Integer.valueOf(C1668a.m3383QF());
        C4990ab.m7421w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        C4879a.xxA.mo10055m(new C6484gj());
        C37957c.akc().commitNow();
        ((C43014c) C1720g.m3528K(C43014c.class)).logout();
        C6300p Rg = C1720g.m3540Rg();
        C1202f c132399 = new C132399();
        settingsUI.qmb = c132399;
        Rg.mo14539a(255, c132399);
        final C1207m c9706r = new C9706r(2);
        c9706r.fPr = 2;
        C1720g.m3540Rg().mo14541a(c9706r, 0);
        settingsUI.qma = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(127570);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.m45993u(SettingsUI.this);
                AppMethodBeat.m2505o(127570);
                return false;
            }
        }, false);
        settingsUI.qma.mo16770ae(12000, 12000);
        settingsUI.getString(C25738R.string.f9238tz);
        settingsUI.qlZ = C30379h.m48458b((Context) settingsUI, settingsUI.getString(C25738R.string.g35), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127571);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.m2505o(127571);
            }
        });
        if (C1720g.m3531RK()) {
            C6665av.fly.mo14899ou(C41730b.m73505pX(C1853r.m3846Yz()));
        }
        AppMethodBeat.m2505o(127617);
    }

    /* renamed from: j */
    static /* synthetic */ void m45981j(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127619);
        Object[] objArr = new Object[1];
        C1720g.m3534RN();
        objArr[0] = Integer.valueOf(C1668a.m3383QF());
        C4990ab.m7421w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
            C6300p Rg = C1720g.m3540Rg();
            C1202f c289776 = new C289776();
            settingsUI.qpz = c289776;
            Rg.mo14539a((int) C31128d.MIC_PTU_TRANS_KONGCHENG, c289776);
            final C1207m c32822ab = new C32822ab(2);
            C1720g.m3540Rg().mo14541a(c32822ab, 0);
            settingsUI.fJs = new C7564ap(new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(127566);
                    C1720g.m3540Rg().mo14547c(c32822ab);
                    C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
                    SettingsUI.this.qpz = null;
                    if (SettingsUI.this.fJs != null) {
                        SettingsUI.this.fJs.stopTimer();
                        SettingsUI.this.fJs = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    SettingsUI.m45988p(SettingsUI.this);
                    AppMethodBeat.m2505o(127566);
                    return false;
                }
            }, false);
            settingsUI.fJs.mo16770ae(5000, 5000);
            Context context = settingsUI.mController.ylL;
            settingsUI.getString(C25738R.string.f9238tz);
            settingsUI.qlZ = C30379h.m48458b(context, settingsUI.getString(C25738R.string.g05), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(127567);
                    C1720g.m3540Rg().mo14547c(c32822ab);
                    C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
                    SettingsUI.this.qpz = null;
                    if (SettingsUI.this.fJs != null) {
                        SettingsUI.this.fJs.stopTimer();
                        SettingsUI.this.fJs = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    AppMethodBeat.m2505o(127567);
                }
            });
            AppMethodBeat.m2505o(127619);
            return;
        }
        settingsUI.cjp();
        AppMethodBeat.m2505o(127619);
    }

    /* renamed from: u */
    static /* synthetic */ void m45993u(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127621);
        if (!C1668a.m3404jP(C1720g.m3534RN().eIV) || C5058f.EX_DEVICE_LOGIN) {
            settingsUI.cjo();
            settingsUI.gyS = new C7564ap(Looper.getMainLooper(), new C2898017(), false);
            settingsUI.gyS.mo16770ae(3000, 3000);
            settingsUI.getString(C25738R.string.f9238tz);
            settingsUI.qlZ = C30379h.m48458b((Context) settingsUI, settingsUI.getString(C25738R.string.g35), true, new C2897818());
            AppMethodBeat.m2505o(127621);
            return;
        }
        C6300p Rg = C1720g.m3540Rg();
        C1202f c2179514 = new C2179514();
        settingsUI.fQS = c2179514;
        Rg.mo14539a((int) C31128d.MIC_PTU_TRANS_KONGCHENG, c2179514);
        final C1207m c32822ab = new C32822ab(2);
        C1720g.m3540Rg().mo14541a(c32822ab, 0);
        settingsUI.cjo();
        settingsUI.qma = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(127576);
                C1720g.m3540Rg().mo14547c(c32822ab);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                SettingsUI.this.fQS = null;
                SettingsUI.this.qpu = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.m45998z(SettingsUI.this);
                AppMethodBeat.m2505o(127576);
                return false;
            }
        }, false);
        settingsUI.qma.mo16770ae(5000, 5000);
        settingsUI.getString(C25738R.string.f9238tz);
        settingsUI.qlZ = C30379h.m48458b((Context) settingsUI, settingsUI.getString(C25738R.string.g05), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127577);
                C1720g.m3540Rg().mo14547c(c32822ab);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                SettingsUI.this.fQS = null;
                SettingsUI.this.qpu = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.m2505o(127577);
            }
        });
        AppMethodBeat.m2505o(127621);
    }

    /* renamed from: B */
    static /* synthetic */ void m45971B(SettingsUI settingsUI) {
        AppMethodBeat.m2504i(127623);
        settingsUI.m45983kr(true);
        AppMethodBeat.m2505o(127623);
    }
}
