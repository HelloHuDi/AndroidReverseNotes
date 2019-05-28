package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.bb;
import com.tencent.mm.g.a.os;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao;
import com.tencent.mm.model.r;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.x.c;

public class SettingsAccountInfoUI extends MMPreference implements b {
    private f ehK;
    private EditText qmA;
    private boolean qmB;
    private SparseIntArray qmC = new SparseIntArray();
    private View qmy;
    private TextView qmz;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAccountInfoUI() {
        AppMethodBeat.i(127143);
        this.qmC.put(0, R.string.e6f);
        this.qmC.put(-82, R.string.e4r);
        this.qmC.put(-83, R.string.e4o);
        this.qmC.put(-84, R.string.e4p);
        this.qmC.put(-85, R.string.e4i);
        this.qmC.put(-86, R.string.e4t);
        AppMethodBeat.o(127143);
    }

    public final int JC() {
        return R.xml.bu;
    }

    public final boolean aqT() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127144);
        super.onCreate(bundle);
        initView();
        g.RP().Ry().a(this);
        AppMethodBeat.o(127144);
    }

    public void onDestroy() {
        AppMethodBeat.i(127145);
        super.onDestroy();
        g.RP().Ry().b(this);
        AppMethodBeat.o(127145);
    }

    public final void initView() {
        AppMethodBeat.i(127146);
        setMMTitle((int) R.string.e5c);
        this.ehK = this.yCw;
        this.qmy = View.inflate(this, R.layout.arb, null);
        this.qmz = (TextView) this.qmy.findViewById(R.id.e91);
        this.qmz.setText(getString(R.string.e7i));
        this.qmA = (EditText) this.qmy.findViewById(R.id.e92);
        this.qmA.setInputType(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) != 1) {
            this.ehK.ce("settings_voiceprint_title", true);
        } else if (g.RK()) {
            IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_voiceprint_title");
            if (((Boolean) g.RP().Ry().get(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue() && (g.RP().Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                iconPreference.NL(0);
                ab.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                this.ehK.notifyDataSetChanged();
            }
        } else {
            ab.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            AppMethodBeat.o(127146);
            return;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127142);
                SettingsAccountInfoUI.this.aqX();
                SettingsAccountInfoUI.this.finish();
                AppMethodBeat.o(127142);
                return true;
            }
        });
        AppMethodBeat.o(127146);
    }

    public void onResume() {
        AppMethodBeat.i(127147);
        ciI();
        ciK();
        this.qmB = false;
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_more_safe");
        if (c.PK().b(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC)) {
            iconPreference.NN(0);
        } else {
            iconPreference.NN(8);
        }
        ciJ();
        ciL();
        this.ehK.ce("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.ehK.aqO("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.ehK.aqO("settings_about_vuserinfo");
        Preference aqO = this.ehK.aqO("settings_about_vuser_about");
        int h = bo.h((Integer) g.RP().Ry().get(66049, null));
        if (h != 0) {
            Bitmap i;
            pluginTextPreference.visibility = 8;
            pluginTextPreference.NV(R.string.b24);
            if (ao.a.flw != null) {
                i = BackwardSupportUtil.b.i(ao.a.flw.ky(h), 2.0f);
            } else {
                i = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), i);
            selfVuserPreference.text = (String) g.RP().Ry().get(66050, null);
        } else {
            this.ehK.d(pluginTextPreference);
            this.ehK.d(selfVuserPreference);
            this.ehK.d(aqO);
        }
        super.onResume();
        AppMethodBeat.o(127147);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(127149);
        ciI();
        ciK();
        ciJ();
        ciL();
        AppMethodBeat.o(127149);
    }

    private void ciI() {
        AppMethodBeat.i(127150);
        Preference aqO = this.ehK.aqO("settings_username");
        CharSequence YA = r.YA();
        if (bo.isNullOrNil(YA)) {
            YA = r.Yz();
            if (ad.aoA(YA)) {
                aqO.setSummary(getString(R.string.e9q));
            } else {
                aqO.setSummary(YA);
            }
            if (!ad.aoB(r.Yz())) {
                aqO.NW(8);
            }
            AppMethodBeat.o(127150);
            return;
        }
        aqO.setSummary(YA);
        aqO.NW(8);
        AppMethodBeat.o(127150);
    }

    private void ciJ() {
        AppMethodBeat.i(127151);
        if (this.ehK.aqO("settings_manage_login_device") == null) {
            ab.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            AppMethodBeat.o(127151);
            return;
        }
        this.ehK.ce("settings_manage_login_device", false);
        AppMethodBeat.o(127151);
    }

    private void ciK() {
        AppMethodBeat.i(127152);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ehK.aqO("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            ab.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            AppMethodBeat.o(127152);
            return;
        }
        String str = (String) g.RP().Ry().get(6, null);
        ab.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary((CharSequence) getString(R.string.e61));
            iconSwitchKeyValuePreference.NS(0);
            AppMethodBeat.o(127152);
            return;
        }
        iconSwitchKeyValuePreference.setSummary((CharSequence) str);
        iconSwitchKeyValuePreference.NS(1);
        AppMethodBeat.o(127152);
    }

    private void ciL() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(127153);
        bb bbVar = new bb();
        com.tencent.mm.sdk.b.a.xxA.m(bbVar);
        if (bbVar.cuk.cul && bbVar.cuk.cum && bbVar.cuk.cun) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", Boolean.valueOf(bbVar.cuk.cul), Boolean.valueOf(bbVar.cuk.cum), Boolean.valueOf(bbVar.cuk.cun));
        f fVar = this.ehK;
        String str = "settings_fingerprint_title";
        if (z) {
            z2 = false;
        }
        fVar.ce(str, z2);
        AppMethodBeat.o(127153);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127148);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        r.Yz();
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(127148);
            return false;
        }
        if (str.equals("settings_username") && bo.isNullOrNil(r.YA()) && ad.aoB(r.Yz())) {
            aA(SettingsAliasUI.class);
        }
        if (str.equals("settings_mobile")) {
            Intent intent = new Intent(this, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 4);
            MMWizardActivity.J(this, intent);
            AppMethodBeat.o(127148);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            bo.M(this.mController.ylL, String.format("https://weixin.qq.com/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s", new Object[]{aa.dor()}));
        } else if (str.equals("settings_independent_password")) {
            Intent intent2 = new Intent();
            intent2.putExtra("kintent_hint", getString(R.string.e8s));
            a(RegByMobileSetPwdUI.class, intent2);
        } else if (str.equals("settings_manage_login_device")) {
            d.H(this, "account", ".security.ui.MySafeDeviceListUI");
        } else if (str.equals("settings_security_center")) {
            str = getString(R.string.g0n) + aa.dor();
            Context context = this.mController.ylL;
            Intent intent3 = new Intent();
            intent3.putExtra("rawUrl", str);
            intent3.putExtra("showShare", true);
            intent3.putExtra("show_bottom", false);
            intent3.putExtra("needRedirect", false);
            intent3.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
            intent3.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
            d.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent3);
        } else if (str.equals("settings_voiceprint_title")) {
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1 && (g.RP().Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                g.RP().Ry().set(a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
                ((IconPreference) this.ehK.aqO("settings_voiceprint_title")).NL(8);
                this.ehK.notifyDataSetChanged();
                ab.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
            }
            d.H(this.mController.ylL, "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            os osVar = new os();
            osVar.cLf.context = this;
            com.tencent.mm.sdk.b.a.xxA.m(osVar);
            ab.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", Boolean.valueOf(osVar.cLg.cKV));
            if (!osVar.cLg.cKV) {
                t.makeText(this.mController.ylL, getString(R.string.blj), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            aA(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            c.PK().c(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC);
            aA(SettingsMoreSafeUI.class);
        }
        AppMethodBeat.o(127148);
        return false;
    }
}
