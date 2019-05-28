package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p230g.p231a.C26090bb;
import com.tencent.p177mm.p230g.p231a.C45354os;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.PluginTextPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactIntroUI;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI */
public class SettingsAccountInfoUI extends MMPreference implements C4937b {
    private C15541f ehK;
    private EditText qmA;
    private boolean qmB;
    private SparseIntArray qmC = new SparseIntArray();
    private View qmy;
    private TextView qmz;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI$1 */
    class C132071 implements OnMenuItemClickListener {
        C132071() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127142);
            SettingsAccountInfoUI.this.aqX();
            SettingsAccountInfoUI.this.finish();
            AppMethodBeat.m2505o(127142);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsAccountInfoUI() {
        AppMethodBeat.m2504i(127143);
        this.qmC.put(0, C25738R.string.e6f);
        this.qmC.put(-82, C25738R.string.e4r);
        this.qmC.put(-83, C25738R.string.e4o);
        this.qmC.put(-84, C25738R.string.e4p);
        this.qmC.put(-85, C25738R.string.e4i);
        this.qmC.put(-86, C25738R.string.e4t);
        AppMethodBeat.m2505o(127143);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8546bu;
    }

    public final boolean aqT() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127144);
        super.onCreate(bundle);
        initView();
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        AppMethodBeat.m2505o(127144);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127145);
        super.onDestroy();
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        AppMethodBeat.m2505o(127145);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127146);
        setMMTitle((int) C25738R.string.e5c);
        this.ehK = this.yCw;
        this.qmy = View.inflate(this, 2130970617, null);
        this.qmz = (TextView) this.qmy.findViewById(2131827352);
        this.qmz.setText(getString(C25738R.string.e7i));
        this.qmA = (EditText) this.qmy.findViewById(2131827353);
        this.qmA.setInputType(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) != 1) {
            this.ehK.mo27715ce("settings_voiceprint_title", true);
        } else if (C1720g.m3531RK()) {
            IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_voiceprint_title");
            if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue() && (C1720g.m3536RP().mo5239Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
                iconPreference.mo48763NL(0);
                C4990ab.m7416i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                this.ehK.notifyDataSetChanged();
            }
        } else {
            C4990ab.m7412e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            AppMethodBeat.m2505o(127146);
            return;
        }
        setBackBtn(new C132071());
        AppMethodBeat.m2505o(127146);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127147);
        ciI();
        ciK();
        this.qmB = false;
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_more_safe");
        if (C16112c.m24429PK().mo28550b(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC)) {
            iconPreference.mo48765NN(0);
        } else {
            iconPreference.mo48765NN(8);
        }
        ciJ();
        ciL();
        this.ehK.mo27715ce("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.ehK.aqO("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.ehK.aqO("settings_about_vuserinfo");
        Preference aqO = this.ehK.aqO("settings_about_vuser_about");
        int h = C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(66049, null));
        if (h != 0) {
            Bitmap i;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.mo48780NV(C25738R.string.b24);
            if (C26417a.flw != null) {
                i = C4977b.m7374i(C26417a.flw.mo37872ky(h), 2.0f);
            } else {
                i = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), i);
            selfVuserPreference.text = (String) C1720g.m3536RP().mo5239Ry().get(66050, null);
        } else {
            this.ehK.mo27716d(pluginTextPreference);
            this.ehK.mo27716d(selfVuserPreference);
            this.ehK.mo27716d(aqO);
        }
        super.onResume();
        AppMethodBeat.m2505o(127147);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127149);
        ciI();
        ciK();
        ciJ();
        ciL();
        AppMethodBeat.m2505o(127149);
    }

    private void ciI() {
        AppMethodBeat.m2504i(127150);
        Preference aqO = this.ehK.aqO("settings_username");
        CharSequence YA = C1853r.m3819YA();
        if (C5046bo.isNullOrNil(YA)) {
            YA = C1853r.m3846Yz();
            if (C7616ad.aoA(YA)) {
                aqO.setSummary(getString(C25738R.string.e9q));
            } else {
                aqO.setSummary(YA);
            }
            if (!C7616ad.aoB(C1853r.m3846Yz())) {
                aqO.mo39406NW(8);
            }
            AppMethodBeat.m2505o(127150);
            return;
        }
        aqO.setSummary(YA);
        aqO.mo39406NW(8);
        AppMethodBeat.m2505o(127150);
    }

    private void ciJ() {
        AppMethodBeat.m2504i(127151);
        if (this.ehK.aqO("settings_manage_login_device") == null) {
            C4990ab.m7412e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            AppMethodBeat.m2505o(127151);
            return;
        }
        this.ehK.mo27715ce("settings_manage_login_device", false);
        AppMethodBeat.m2505o(127151);
    }

    private void ciK() {
        AppMethodBeat.m2504i(127152);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ehK.aqO("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            C4990ab.m7412e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            AppMethodBeat.m2505o(127152);
            return;
        }
        String str = (String) C1720g.m3536RP().mo5239Ry().get(6, null);
        C4990ab.m7410d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary((CharSequence) getString(C25738R.string.e61));
            iconSwitchKeyValuePreference.mo51421NS(0);
            AppMethodBeat.m2505o(127152);
            return;
        }
        iconSwitchKeyValuePreference.setSummary((CharSequence) str);
        iconSwitchKeyValuePreference.mo51421NS(1);
        AppMethodBeat.m2505o(127152);
    }

    private void ciL() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(127153);
        C26090bb c26090bb = new C26090bb();
        C4879a.xxA.mo10055m(c26090bb);
        if (c26090bb.cuk.cul && c26090bb.cuk.cum && c26090bb.cuk.cun) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", Boolean.valueOf(c26090bb.cuk.cul), Boolean.valueOf(c26090bb.cuk.cum), Boolean.valueOf(c26090bb.cuk.cun));
        C15541f c15541f = this.ehK;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        c15541f.mo27715ce(str, z2);
        AppMethodBeat.m2505o(127153);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127148);
        String str = preference.mKey;
        C4990ab.m7416i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        C1853r.m3846Yz();
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(127148);
            return false;
        }
        if (str.equals("settings_username") && C5046bo.isNullOrNil(C1853r.m3819YA()) && C7616ad.aoB(C1853r.m3846Yz())) {
            mo17383aA(SettingsAliasUI.class);
        }
        if (str.equals("settings_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.m23791J(this, intent);
            AppMethodBeat.m2505o(127148);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            C5046bo.m7506M(this.mController.ylL, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{C4988aa.dor()}));
        } else if (str.equals("settings_independent_password")) {
            Intent intent2 = new Intent();
            intent2.putExtra("kintent_hint", getString(C25738R.string.e8s));
            mo17381a(RegByMobileSetPwdUI.class, intent2);
        } else if (str.equals("settings_manage_login_device")) {
            C25985d.m41448H(this, "account", ".security.ui.MySafeDeviceListUI");
        } else if (str.equals("settings_security_center")) {
            str = getString(C25738R.string.g0n) + C4988aa.dor();
            Context context = this.mController.ylL;
            Intent intent3 = new Intent();
            intent3.putExtra("rawUrl", str);
            intent3.putExtra("showShare", true);
            intent3.putExtra("show_bottom", false);
            intent3.putExtra("needRedirect", false);
            intent3.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
            intent3.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
            C25985d.m41467b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent3);
        } else if (str.equals("settings_voiceprint_title")) {
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("VoiceprintEntry"), 0) == 1 && (C1720g.m3536RP().mo5239Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
                ((IconPreference) this.ehK.aqO("settings_voiceprint_title")).mo48763NL(8);
                this.ehK.notifyDataSetChanged();
                C4990ab.m7416i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
            }
            C25985d.m41448H(this.mController.ylL, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            C45354os c45354os = new C45354os();
            c45354os.cLf.context = this;
            C4879a.xxA.mo10055m(c45354os);
            C4990ab.m7417i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", Boolean.valueOf(c45354os.cLg.cKV));
            if (!c45354os.cLg.cKV) {
                C23639t.makeText(this.mController.ylL, getString(C25738R.string.blj), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            mo17383aA(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            C16112c.m24429PK().mo28554c(C5127a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, C5127a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC);
            mo17383aA(SettingsMoreSafeUI.class);
        }
        AppMethodBeat.m2505o(127148);
        return false;
    }
}
