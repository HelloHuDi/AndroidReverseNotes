package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kernel.C18524i;
import com.tencent.p177mm.modelsimple.C32822ab;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.modelstat.C37957c;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.IconSummaryPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.tools.C44385r;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.plugin.expt.p394a.C43014c;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.p1283p.C21427b;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p1079f.C40423e;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.aph;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;

@C18524i
/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI */
public class SettingsAboutMicroMsgUI extends MMPreference implements C1202f {
    private C15541f ehK;
    private boolean qlV = false;
    private aph qlW;
    private int qlX = 0;
    Intent qlY = null;
    private ProgressDialog qlZ;
    private C7564ap qma;
    private C1202f qmb = null;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI$1 */
    class C217491 implements OnMenuItemClickListener {
        C217491() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127087);
            SettingsAboutMicroMsgUI.this.aqX();
            SettingsAboutMicroMsgUI.this.finish();
            AppMethodBeat.m2505o(127087);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI$2 */
    class C217502 implements OnClickListener {
        private C7564ap fJs = null;
        private C1202f fQS = null;

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI$2$1 */
        class C217531 implements C1202f {
            C217531() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(127088);
                C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, C217502.this.fQS);
                C217502.this.fQS = null;
                if (C217502.this.fJs != null) {
                    C217502.this.fJs.stopTimer();
                    C217502.this.fJs = null;
                }
                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                }
                SettingsAboutMicroMsgUI.m33293b(SettingsAboutMicroMsgUI.this);
                AppMethodBeat.m2505o(127088);
            }
        }

        C217502() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127091);
            C37957c.akc().commitNow();
            ((C43014c) C1720g.m3528K(C43014c.class)).logout();
            C1720g.m3537RQ();
            if (C1668a.m3404jP(C1720g.m3534RN().eIV)) {
                C6300p Rg = C1720g.m3540Rg();
                C1202f c217531 = new C217531();
                this.fQS = c217531;
                Rg.mo14539a((int) C31128d.MIC_PTU_TRANS_KONGCHENG, c217531);
                final C1207m c32822ab = new C32822ab(2);
                C1720g.m3540Rg().mo14541a(c32822ab, 0);
                this.fJs = new C7564ap(new C5015a() {
                    /* renamed from: BI */
                    public final boolean mo4499BI() {
                        AppMethodBeat.m2504i(127089);
                        C1720g.m3540Rg().mo14547c(c32822ab);
                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, C217502.this.fQS);
                        C217502.this.fQS = null;
                        if (C217502.this.fJs != null) {
                            C217502.this.fJs.stopTimer();
                            C217502.this.fJs = null;
                        }
                        if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                            SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                        }
                        SettingsAboutMicroMsgUI.m33293b(SettingsAboutMicroMsgUI.this);
                        AppMethodBeat.m2505o(127089);
                        return false;
                    }
                }, false);
                this.fJs.mo16770ae(5000, 5000);
                SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = SettingsAboutMicroMsgUI.this;
                Context context = SettingsAboutMicroMsgUI.this.mController.ylL;
                SettingsAboutMicroMsgUI.this.getString(C25738R.string.f9238tz);
                settingsAboutMicroMsgUI.qlZ = C30379h.m48458b(context, SettingsAboutMicroMsgUI.this.getString(C25738R.string.g05), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(127090);
                        C1720g.m3540Rg().mo14547c(c32822ab);
                        C1720g.m3540Rg().mo14546b((int) C31128d.MIC_PTU_TRANS_KONGCHENG, C217502.this.fQS);
                        C217502.this.fQS = null;
                        if (C217502.this.fJs != null) {
                            C217502.this.fJs.stopTimer();
                            C217502.this.fJs = null;
                        }
                        if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                            SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                        }
                        AppMethodBeat.m2505o(127090);
                    }
                });
                AppMethodBeat.m2505o(127091);
                return;
            }
            SettingsAboutMicroMsgUI.m33293b(SettingsAboutMicroMsgUI.this);
            AppMethodBeat.m2505o(127091);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI$3 */
    class C217553 implements C1202f {
        C217553() {
        }

        public final void onSceneEnd(final int i, final int i2, String str, final C1207m c1207m) {
            AppMethodBeat.m2504i(127093);
            C4990ab.m7410d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(127092);
                    C1720g.m3540Rg().mo14546b(255, SettingsAboutMicroMsgUI.this.qmb);
                    SettingsAboutMicroMsgUI.this.qmb = null;
                    if (SettingsAboutMicroMsgUI.this.qma != null) {
                        SettingsAboutMicroMsgUI.this.qma.stopTimer();
                        SettingsAboutMicroMsgUI.this.qma = null;
                    }
                    if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                        SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                    }
                    if (c1207m.getType() == 255 && ((C9706r) c1207m).fPr == 1) {
                        if (i2 == -3 && i == 4) {
                            Intent intent = new Intent(SettingsAboutMicroMsgUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", SettingsAboutMicroMsgUI.this.getString(C25738R.string.dlz));
                            SettingsAboutMicroMsgUI.this.startActivityForResult(intent, 0);
                            AppMethodBeat.m2505o(127092);
                            return;
                        }
                        SettingsAboutMicroMsgUI.m33298g(SettingsAboutMicroMsgUI.this);
                    }
                    AppMethodBeat.m2505o(127092);
                }
            });
            AppMethodBeat.m2505o(127093);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutMicroMsgUI$6 */
    class C217576 implements OnCancelListener {
        C217576() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(127096);
            C7060h.pYm.mo8378a(405, 23, 1, true);
            AppMethodBeat.m2505o(127096);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8545bt;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127098);
        super.onCreate(bundle);
        dyb();
        initView();
        C1720g.m3540Rg().mo14539a(11, (C1202f) this);
        if (C21429d.bQU() != null) {
            C1720g.m3540Rg().mo14541a((C1207m) C21429d.bQU().bQT(), 0);
            C7060h.pYm.mo8378a(405, 15, 1, true);
        }
        AppMethodBeat.m2505o(127098);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127099);
        super.onResume();
        ciD();
        AppMethodBeat.m2505o(127099);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127100);
        C1720g.m3540Rg().mo14546b(11, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(127100);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127101);
        setMMTitle("");
        mo17446xE(getResources().getColor(C25738R.color.f11677d4));
        setBackGroundColorResource(C25738R.color.f11677d4);
        setBackBtn(new C217491());
        if (this.nDp != null) {
            int dimensionPixelSize = this.mController.ylL.getResources().getDimensionPixelSize(C25738R.dimen.f9806g9);
            this.nDp.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.nDp.setBackgroundColor(getResources().getColor(C25738R.color.f11677d4));
        }
        ciD();
        AppMethodBeat.m2505o(127101);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127104);
        C4990ab.m7410d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        C21427b c21427b = (C21427b) c1207m;
        C4990ab.m7410d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + c21427b.bQQ());
        C4990ab.m7410d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + c21427b.bQP());
        C4990ab.m7410d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + C7243d.vxo);
        if (C21429d.oEm || (i == 0 && i2 == 0)) {
            this.qlX = c21427b.bQP();
            if (this.qlX <= 0 || this.qlX <= C7243d.vxo) {
                this.qlV = false;
                if (C1720g.m3534RN().mo5161QY()) {
                    C16112c.m24429PK().mo28556x(262145, false);
                } else {
                    C4990ab.m7412e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.qlV = true;
                if (C1720g.m3534RN().mo5161QY()) {
                    C16112c.m24429PK().mo28556x(262145, true);
                } else {
                    C4990ab.m7412e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.qlW = c21427b.bQR();
        }
        ciD();
        AppMethodBeat.m2505o(127104);
    }

    public final View ciC() {
        AppMethodBeat.m2504i(127097);
        LinearLayout linearLayout = (LinearLayout) C5616v.m8409hu(this.mController.ylL).inflate(2130970627, null);
        TextView textView = (TextView) linearLayout.findViewById(2131827373);
        TextView textView2 = (TextView) linearLayout.findViewById(2131827374);
        String obj = C1720g.m3536RP().mo5239Ry().get(274436, (Object) "").toString();
        if (C5046bo.isNullOrNil(obj)) {
            obj = C4988aa.doq();
        }
        if (!(C5046bo.isNullOrNil(obj) || C5046bo.amU(obj))) {
            obj = "";
        }
        obj = getString(C25738R.string.g7o, new Object[]{C4988aa.dor(), obj, "setting", Integer.valueOf(0), Integer.valueOf(0)});
        textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{getString(C25738R.string.ezj), getString(C25738R.string.cmg)}));
        textView2.setText(String.format("<a href='%s'>%s</a>", new Object[]{obj, getString(C25738R.string.dei)}));
        C44089j.m79307h(textView, 1);
        C44089j.m79307h(textView2, 1);
        ((TextView) linearLayout.findViewById(2131827375)).setText(linearLayout.getResources().getString(C25738R.string.f9084p0, new Object[]{Integer.valueOf(2019)}));
        AppMethodBeat.m2505o(127097);
        return linearLayout;
    }

    private void ciD() {
        IconPreference iconPreference;
        boolean z;
        AppMethodBeat.m2504i(127102);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8545bt);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.ehK.aqO("settings_about_mm_header");
        String ar = C5059g.m7672ar(this.mController.ylL, C7243d.vxo);
        if (C7243d.vxr) {
            ar = ar + " " + getString(C25738R.string.f8807fk);
        }
        settingsAboutMMHeaderPreference.qlS = ar;
        if (C4988aa.doo()) {
            int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(12304, null));
            iconPreference = (IconPreference) this.ehK.aqO("settings_update");
            if (h > 0) {
                iconPreference.mo48763NL(0);
                iconPreference.mo48774ey(String.valueOf(h), C44385r.m80243ik(this.mController.ylL));
            } else {
                iconPreference.mo48763NL(8);
                iconPreference.mo48774ey("", -1);
            }
        }
        if ((C5059g.cdh & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.qlV && !C5059g.xyg) {
            iconSummaryPreference = (IconSummaryPreference) this.ehK.aqO("funtion_update");
            iconSummaryPreference.qlf = 0;
            CharSequence ar2 = C5059g.m7672ar(null, this.qlX);
            iconSummaryPreference.aqR(getString(C25738R.string.f9181s0));
            iconSummaryPreference.setSummary(ar2);
            iconSummaryPreference.dAA();
            this.ehK.aqP("funtion_check_update");
        } else if (z || this.qlW == null || this.qlW.wtp == 0 || C5046bo.isNullOrNil(this.qlW.wtq) || C5059g.xyg) {
            this.ehK.aqP("funtion_update");
        } else {
            C4990ab.m7417i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", this.qlW.wtq, Integer.valueOf(this.qlW.wtr));
            if (this.qlW.wtr != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.ehK.aqO("funtion_update");
                iconSummaryPreference.qlf = 0;
                iconSummaryPreference.aqR(getString(C25738R.string.f9181s0));
                this.ehK.aqP("funtion_check_update");
            } else {
                this.ehK.aqP("funtion_update");
            }
        }
        if (!C4988aa.doo()) {
            this.ehK.mo27715ce("settings_report", true);
        }
        if (!C40423e.vdx.mo20425Ch()) {
            this.ehK.mo27715ce("funtion_about_wechat", true);
        }
        if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null))) {
            this.ehK.aqP("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.ehK.aqO("funtion_crowdtest_update");
            if (C16112c.m24429PK().mo28552bY(262157, 266263)) {
                iconPreference.mo48765NN(0);
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127102);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127103);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (C4988aa.doo()) {
                C1720g.m3534RN();
                int QF = C1668a.m3383QF();
                int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(12304, null));
                str = getString(C25738R.string.ebk, new Object[]{Integer.valueOf(QF), Integer.valueOf(h)});
                if (str == null) {
                    AppMethodBeat.m2505o(127103);
                    return true;
                }
                C1720g.m3536RP().mo5239Ry().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(C25738R.string.ebj));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(127103);
                return true;
            }
            if (C4988aa.doo()) {
                str = getString(C25738R.string.e7b, new Object[]{C4988aa.dor(), Integer.valueOf(C7243d.vxo)});
            } else {
                str = "https://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127103);
            return true;
        } else if (str.equals("funtion_update")) {
            C7060h.pYm.mo8378a(405, 16, 1, true);
            str = "";
            if (this.qlV) {
                str = getString(C25738R.string.e7c, new Object[]{C4988aa.dor(), Integer.valueOf(this.qlX)});
            } else if (!(this.qlW == null || this.qlW.wtp == 0 || C5046bo.isNullOrNil(this.qlW.wtq))) {
                str = this.qlW.wtq;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127103);
            return true;
        } else if (str.equals("funtion_check_update")) {
            C7060h.pYm.mo8378a(405, 17, 1, true);
            if (C21429d.bQU() != null) {
                C21429d.bQU().bQS();
                if ((C5059g.cdh & 1) != 0) {
                    C4990ab.m7412e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(C5059g.xyc);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                    if (parse == null || intent == null || !C5046bo.m7572k(this.mController.ylL, intent)) {
                        C4990ab.m7412e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                        C7060h.pYm.mo8378a(405, 18, 1, true);
                    } else {
                        C4990ab.m7416i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                        startActivity(intent);
                        C7060h.pYm.mo8378a(405, 19, 1, true);
                    }
                    AppMethodBeat.m2505o(127103);
                    return true;
                } else if (this.qlW == null || this.qlW.wtp == 0 || C5046bo.isNullOrNil(this.qlW.wtq)) {
                    C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT()).commit();
                    C21426a c = C21429d.bQU().mo36878c(this, new C217576());
                    if (c == null) {
                        C7060h.pYm.mo8378a(405, 21, 1, true);
                    } else {
                        C7060h.pYm.mo8378a(405, 22, 1, true);
                        c.update(3);
                        AppMethodBeat.m2505o(127103);
                        return true;
                    }
                } else {
                    str = this.qlW.wtq;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    C7060h.pYm.mo8378a(405, 20, 1, true);
                    AppMethodBeat.m2505o(127103);
                    return true;
                }
            }
            AppMethodBeat.m2505o(127103);
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            C25985d.m41467b((Context) this, "whatsnew", ".ui.WhatsNewUI", new Intent());
            AppMethodBeat.m2505o(127103);
            return true;
        } else if (str.equals("settings_report")) {
            intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("show_feedback", false);
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127103);
            return true;
        } else if (str.equals("settings_quit_wechat")) {
            C30379h.m48428a(this.mController.ylL, (int) C25738R.string.cw1, (int) C25738R.string.cw0, (int) C25738R.string.f9262up, (int) C25738R.string.f9183s2, new C217502(), null);
            AppMethodBeat.m2505o(127103);
            return true;
        } else if (str.equals("funtion_crowdtest_update")) {
            C16112c.m24429PK().mo28553bZ(262157, 266263);
            str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null);
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(127103);
            return true;
        } else {
            AppMethodBeat.m2505o(127103);
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m33293b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.m2504i(127105);
        C6300p Rg = C1720g.m3540Rg();
        C1202f c217553 = new C217553();
        settingsAboutMicroMsgUI.qmb = c217553;
        Rg.mo14539a(255, c217553);
        final C1207m c9706r = new C9706r(2);
        c9706r.fPr = 1;
        C1720g.m3540Rg().mo14541a(c9706r, 0);
        settingsAboutMicroMsgUI.qma = new C7564ap(Looper.getMainLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(127094);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsAboutMicroMsgUI.this.qmb);
                SettingsAboutMicroMsgUI.this.qmb = null;
                if (SettingsAboutMicroMsgUI.this.qma != null) {
                    SettingsAboutMicroMsgUI.this.qma.stopTimer();
                    SettingsAboutMicroMsgUI.this.qma = null;
                }
                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                    SettingsAboutMicroMsgUI.this.qlZ.cancel();
                }
                SettingsAboutMicroMsgUI.m33298g(SettingsAboutMicroMsgUI.this);
                AppMethodBeat.m2505o(127094);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.qma.mo16770ae(3000, 3000);
        Context context = settingsAboutMicroMsgUI.mController.ylL;
        settingsAboutMicroMsgUI.getString(C25738R.string.f9238tz);
        settingsAboutMicroMsgUI.qlZ = C30379h.m48458b(context, settingsAboutMicroMsgUI.getString(C25738R.string.g34), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127095);
                C1720g.m3540Rg().mo14547c(c9706r);
                C1720g.m3540Rg().mo14546b(255, SettingsAboutMicroMsgUI.this.qmb);
                SettingsAboutMicroMsgUI.this.qmb = null;
                if (SettingsAboutMicroMsgUI.this.qma != null) {
                    SettingsAboutMicroMsgUI.this.qma.stopTimer();
                    SettingsAboutMicroMsgUI.this.qma = null;
                }
                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                }
                AppMethodBeat.m2505o(127095);
            }
        });
        AppMethodBeat.m2505o(127105);
    }

    /* renamed from: g */
    static /* synthetic */ void m33298g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.m2504i(127106);
        C4997aj.amB("welcome_page_show");
        C1737l.m3593m(settingsAboutMicroMsgUI, true);
        C24824b.gkF.mo38846BV();
        ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41568IH();
        C40423e.vdx.mo20426bd(settingsAboutMicroMsgUI.mController.ylL);
        settingsAboutMicroMsgUI.finish();
        AppMethodBeat.m2505o(127106);
    }
}
