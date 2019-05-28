package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p230g.p231a.C45382z;
import com.tencent.p177mm.p230g.p231a.C6484gj;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30387b;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.account.model.C42285d;
import com.tencent.p177mm.plugin.account.p275ui.FacebookAuthUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4997aj;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI */
public class SettingsMoreSafeUI extends MMPreference implements C1202f, C4937b {
    private ProgressDialog ehJ;
    private C15541f ehK;
    private SparseIntArray qmC = new SparseIntArray();
    private String qnZ = null;
    private String qoa;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI$1 */
    class C217711 implements OnMenuItemClickListener {
        C217711() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127324);
            SettingsMoreSafeUI.this.aqX();
            SettingsMoreSafeUI.this.finish();
            AppMethodBeat.m2505o(127324);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI$2 */
    class C217722 implements C30387b {
        C217722() {
        }

        /* renamed from: s */
        public final boolean mo4760s(CharSequence charSequence) {
            AppMethodBeat.m2504i(127326);
            if (C5046bo.amW(charSequence.toString())) {
                C24824b.gkF.mo38844BS();
                final C1207m c42285d = new C42285d(C42285d.gyK, charSequence.toString());
                C1720g.m3540Rg().mo14541a(c42285d, 0);
                SettingsMoreSafeUI settingsMoreSafeUI = SettingsMoreSafeUI.this;
                Context context = SettingsMoreSafeUI.this.mController.ylL;
                SettingsMoreSafeUI.this.getString(C25738R.string.f9238tz);
                settingsMoreSafeUI.ehJ = C30379h.m48458b(context, SettingsMoreSafeUI.this.getString(C25738R.string.e62), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(127325);
                        C1720g.m3540Rg().mo14547c(c42285d);
                        AppMethodBeat.m2505o(127325);
                    }
                });
                AppMethodBeat.m2505o(127326);
                return true;
            }
            C30379h.m48465bQ(SettingsMoreSafeUI.this.mController.ylL, SettingsMoreSafeUI.this.getString(C25738R.string.f0o));
            AppMethodBeat.m2505o(127326);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsMoreSafeUI() {
        AppMethodBeat.m2504i(127327);
        this.qmC.put(0, C25738R.string.e6f);
        this.qmC.put(-82, C25738R.string.e4r);
        this.qmC.put(-83, C25738R.string.e4o);
        this.qmC.put(-84, C25738R.string.e4p);
        this.qmC.put(-85, C25738R.string.e4i);
        this.qmC.put(-86, C25738R.string.e4t);
        AppMethodBeat.m2505o(127327);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8551bz;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127328);
        super.onCreate(bundle);
        initView();
        C1720g.m3540Rg().mo14539a(256, (C1202f) this);
        AppMethodBeat.m2505o(127328);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127329);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(256, (C1202f) this);
        AppMethodBeat.m2505o(127329);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127330);
        setMMTitle((int) C25738R.string.e8w);
        this.ehK = this.yCw;
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(9, Integer.valueOf(0))).intValue() != 0) {
            C4990ab.m7416i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
        } else if (C5046bo.getInt(C26373g.m41964Nu().getValue("BindQQSwitch"), 1) != 1) {
            this.ehK.mo27715ce("settings_uin", true);
            C4990ab.m7416i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
        }
        this.qnZ = C26373g.m41964Nu().getValue("CloseAcctUrl");
        setBackBtn(new C217711());
        AppMethodBeat.m2505o(127330);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127331);
        ciW();
        ciT();
        ciV();
        String value = C26373g.m41964Nu().getValue("ShowExportUserDataEntry");
        if (C5046bo.isNullOrNil(value)) {
            this.qoa = "";
            this.ehK.mo27715ce("settings_dump_personal_data", true);
        } else {
            this.qoa = value;
        }
        ciU();
        this.ehK.mo27716d(this.ehK.aqO("settings_about_domainmail"));
        if (C5046bo.isNullOrNil(this.qnZ)) {
            this.ehK.mo27716d(this.ehK.aqO("settings_delete_account"));
        }
        super.onResume();
        AppMethodBeat.m2505o(127331);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127332);
        super.onPause();
        AppMethodBeat.m2505o(127332);
    }

    private void ciT() {
        AppMethodBeat.m2504i(127334);
        Preference aqO = this.ehK.aqO("settings_email_addr");
        Assert.assertNotNull(aqO);
        String str = (String) C1720g.m3536RP().mo5239Ry().get(5, null);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            aqO.setSummary((int) C25738R.string.e6m);
            AppMethodBeat.m2505o(127334);
        } else if (str != null) {
            aqO.setSummary((int) C25738R.string.e6l);
            AppMethodBeat.m2505o(127334);
        } else {
            aqO.setSummary((int) C25738R.string.e4h);
            AppMethodBeat.m2505o(127334);
        }
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127335);
        ciW();
        ciT();
        ciV();
        ciU();
        AppMethodBeat.m2505o(127335);
    }

    private void ciU() {
        AppMethodBeat.m2504i(127336);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ehK.aqO("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            C4990ab.m7412e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
            AppMethodBeat.m2505o(127336);
        } else if (C5059g.dnY()) {
            this.ehK.mo27715ce("settings_phone_security", true);
            AppMethodBeat.m2505o(127336);
        } else if (C16112c.m24429PK().mo28544a(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC)) {
            iconSwitchKeyValuePreference.mo48765NN(0);
            AppMethodBeat.m2505o(127336);
        } else {
            iconSwitchKeyValuePreference.mo48765NN(8);
            AppMethodBeat.m2505o(127336);
        }
    }

    private void ciV() {
        AppMethodBeat.m2504i(127337);
        Preference aqO = this.ehK.aqO("settings_facebook");
        if (aqO == null) {
            C4990ab.m7412e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
            AppMethodBeat.m2505o(127337);
        } else if (!C1853r.m3842YX()) {
            this.ehK.mo27716d(aqO);
            AppMethodBeat.m2505o(127337);
        } else if (C1853r.m3847Za()) {
            aqO.setSummary((String) C1720g.m3536RP().mo5239Ry().get(65826, null));
            AppMethodBeat.m2505o(127337);
        } else {
            aqO.setSummary(getString(C25738R.string.e61));
            AppMethodBeat.m2505o(127337);
        }
    }

    private void ciW() {
        AppMethodBeat.m2504i(127338);
        Preference aqO = this.ehK.aqO("settings_bind_qq");
        if (aqO == null) {
            C4990ab.m7412e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
            AppMethodBeat.m2505o(127338);
            return;
        }
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(9, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            C4990ab.m7416i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("BindQQSwitch"), 1) != 1) {
                this.ehK.mo27715ce("settings_uin", true);
                AppMethodBeat.m2505o(127338);
                return;
            }
            aqO.setSummary((int) C25738R.string.e61);
            AppMethodBeat.m2505o(127338);
            return;
        }
        aqO.setSummary(new C1183p(intValue));
        AppMethodBeat.m2505o(127338);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(127339);
        C4990ab.m7410d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (c1207m.getType() == 256) {
            if (!(i == 0 && i2 == 0) && C24824b.gkF.mo38859a((Context) this, i, i2, str)) {
                AppMethodBeat.m2505o(127339);
                return;
            }
            int i3 = this.qmC.get(i2);
            String string = getString(C25738R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i3 != 0) {
                try {
                    string = getString(i3);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", Integer.valueOf(i3), e.getMessage());
                    C4990ab.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", e, "", new Object[0]);
                }
            }
            C30379h.m48465bQ(this.mController.ylL, string);
        }
        AppMethodBeat.m2505o(127339);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(127340);
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            switch (i2) {
                case -1:
                    if (!(C1720g.m3540Rg() == null || C1720g.m3540Rg().ftA == null)) {
                        C1720g.m3540Rg().ftA.mo5532cG(false);
                    }
                    C4879a.xxA.mo10055m(new C6484gj());
                    C24824b.gkF.mo38849BY();
                    C1720g.m3536RP().mo5239Ry().mo10121b(this);
                    C26171jl c26171jl = new C26171jl();
                    c26171jl.cEK.status = 0;
                    c26171jl.cEK.boZ = 3;
                    C4879a.xxA.mo10055m(c26171jl);
                    C45382z c45382z = new C45382z();
                    c45382z.csU.csV = true;
                    C4879a.xxA.mo10055m(c45382z);
                    C4997aj.amB("show_whatsnew");
                    C1737l.m3593m(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    C24824b.gkE.mo38931p(intent2, this.mController.ylL);
                    C26529w.m42350I(this, null);
                    finish();
                    break;
            }
        }
        AppMethodBeat.m2505o(127340);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127333);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsMoreSafeUI", str + " item has been clicked!");
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(127333);
            return false;
        }
        Intent intent;
        if (str.equals("settings_facebook")) {
            mo17383aA(FacebookAuthUI.class);
        } else if (str.equals("settings_email_addr")) {
            Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(7, null);
            if (!(num == null || (num.intValue() & 2) == 0)) {
                z = true;
            }
            str = (String) C1720g.m3536RP().mo5239Ry().get(5, null);
            if (z || !C5046bo.isNullOrNil(str)) {
                startActivity(new Intent(this.mController.ylL, SettingsModifyEmailAddrUI.class));
            } else {
                if (this.ehJ != null) {
                    C4990ab.m7420w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                C30379h.m48442a(this.mController.ylL, getString(C25738R.string.e8i), C5046bo.m7532bc(C26529w.m42363ct(this.mController.ylL), ""), getString(C25738R.string.e8j), 50, new C217722());
            }
            AppMethodBeat.m2505o(127333);
            return true;
        } else if (str.equals("settings_bind_qq")) {
            C24824b.gkE.mo38921g(new Intent(), (Context) this);
            AppMethodBeat.m2505o(127333);
            return true;
        } else if (str.equals("settings_phone_security")) {
            Intent intent2 = new Intent();
            int i = C16112c.m24429PK().mo28544a(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) ? 1 : 0;
            C16112c.m24429PK().mo28548b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
            ((IconPreference) preference).mo48765NN(8);
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(0))).intValue();
            C7060h.pYm.mo8381e(10939, Integer.valueOf(intValue));
            if (C5046bo.m7528bH(this, "com.tencent.server.back.BackEngine")) {
                str = getString(C25738R.string.g8n, new Object[]{Integer.valueOf(intValue), Integer.valueOf(1), Integer.valueOf(i)});
            } else {
                str = getString(C25738R.string.g8n, new Object[]{Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(i)});
            }
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (str.equals("settings_delete_account")) {
            intent = new Intent();
            if (!C5046bo.isNullOrNil(this.qnZ)) {
                intent.putExtra("rawUrl", this.qnZ + "&lang=" + C4988aa.m7403gw(this.mController.ylL));
                intent.putExtra("showShare", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                C25985d.m41468b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 2);
            }
        } else if (str.equals("settings_dump_personal_data")) {
            intent = new Intent();
            if (!C5046bo.isNullOrNil(this.qoa)) {
                intent.putExtra("rawUrl", this.qoa);
                intent.putExtra("showShare", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", false);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                C25985d.m41467b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
        }
        AppMethodBeat.m2505o(127333);
        return false;
    }
}
