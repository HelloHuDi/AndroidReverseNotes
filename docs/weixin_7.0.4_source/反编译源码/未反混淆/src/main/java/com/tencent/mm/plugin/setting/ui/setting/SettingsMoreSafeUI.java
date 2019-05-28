package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.model.d;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.c;
import junit.framework.Assert;

public class SettingsMoreSafeUI extends MMPreference implements f, b {
    private ProgressDialog ehJ;
    private com.tencent.mm.ui.base.preference.f ehK;
    private SparseIntArray qmC = new SparseIntArray();
    private String qnZ = null;
    private String qoa;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsMoreSafeUI() {
        AppMethodBeat.i(127327);
        this.qmC.put(0, R.string.e6f);
        this.qmC.put(-82, R.string.e4r);
        this.qmC.put(-83, R.string.e4o);
        this.qmC.put(-84, R.string.e4p);
        this.qmC.put(-85, R.string.e4i);
        this.qmC.put(-86, R.string.e4t);
        AppMethodBeat.o(127327);
    }

    public final int JC() {
        return R.xml.bz;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127328);
        super.onCreate(bundle);
        initView();
        g.Rg().a(256, (f) this);
        AppMethodBeat.o(127328);
    }

    public void onDestroy() {
        AppMethodBeat.i(127329);
        super.onDestroy();
        g.Rg().b(256, (f) this);
        AppMethodBeat.o(127329);
    }

    public final void initView() {
        AppMethodBeat.i(127330);
        setMMTitle((int) R.string.e8w);
        this.ehK = this.yCw;
        if (((Integer) g.RP().Ry().get(9, Integer.valueOf(0))).intValue() != 0) {
            ab.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
        } else if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("BindQQSwitch"), 1) != 1) {
            this.ehK.ce("settings_uin", true);
            ab.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
        }
        this.qnZ = com.tencent.mm.m.g.Nu().getValue("CloseAcctUrl");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127324);
                SettingsMoreSafeUI.this.aqX();
                SettingsMoreSafeUI.this.finish();
                AppMethodBeat.o(127324);
                return true;
            }
        });
        AppMethodBeat.o(127330);
    }

    public void onResume() {
        AppMethodBeat.i(127331);
        ciW();
        ciT();
        ciV();
        String value = com.tencent.mm.m.g.Nu().getValue("ShowExportUserDataEntry");
        if (bo.isNullOrNil(value)) {
            this.qoa = "";
            this.ehK.ce("settings_dump_personal_data", true);
        } else {
            this.qoa = value;
        }
        ciU();
        this.ehK.d(this.ehK.aqO("settings_about_domainmail"));
        if (bo.isNullOrNil(this.qnZ)) {
            this.ehK.d(this.ehK.aqO("settings_delete_account"));
        }
        super.onResume();
        AppMethodBeat.o(127331);
    }

    public void onPause() {
        AppMethodBeat.i(127332);
        super.onPause();
        AppMethodBeat.o(127332);
    }

    private void ciT() {
        AppMethodBeat.i(127334);
        Preference aqO = this.ehK.aqO("settings_email_addr");
        Assert.assertNotNull(aqO);
        String str = (String) g.RP().Ry().get(5, null);
        Integer num = (Integer) g.RP().Ry().get(7, null);
        if (num != null && (num.intValue() & 2) != 0) {
            aqO.setSummary((int) R.string.e6m);
            AppMethodBeat.o(127334);
        } else if (str != null) {
            aqO.setSummary((int) R.string.e6l);
            AppMethodBeat.o(127334);
        } else {
            aqO.setSummary((int) R.string.e4h);
            AppMethodBeat.o(127334);
        }
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(127335);
        ciW();
        ciT();
        ciV();
        ciU();
        AppMethodBeat.o(127335);
    }

    private void ciU() {
        AppMethodBeat.i(127336);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.ehK.aqO("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            ab.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
            AppMethodBeat.o(127336);
        } else if (com.tencent.mm.sdk.platformtools.g.dnY()) {
            this.ehK.ce("settings_phone_security", true);
            AppMethodBeat.o(127336);
        } else if (c.PK().a(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC)) {
            iconSwitchKeyValuePreference.NN(0);
            AppMethodBeat.o(127336);
        } else {
            iconSwitchKeyValuePreference.NN(8);
            AppMethodBeat.o(127336);
        }
    }

    private void ciV() {
        AppMethodBeat.i(127337);
        Preference aqO = this.ehK.aqO("settings_facebook");
        if (aqO == null) {
            ab.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
            AppMethodBeat.o(127337);
        } else if (!r.YX()) {
            this.ehK.d(aqO);
            AppMethodBeat.o(127337);
        } else if (r.Za()) {
            aqO.setSummary((String) g.RP().Ry().get(65826, null));
            AppMethodBeat.o(127337);
        } else {
            aqO.setSummary(getString(R.string.e61));
            AppMethodBeat.o(127337);
        }
    }

    private void ciW() {
        AppMethodBeat.i(127338);
        Preference aqO = this.ehK.aqO("settings_bind_qq");
        if (aqO == null) {
            ab.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
            AppMethodBeat.o(127338);
            return;
        }
        int intValue = ((Integer) g.RP().Ry().get(9, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            ab.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("BindQQSwitch"), 1) != 1) {
                this.ehK.ce("settings_uin", true);
                AppMethodBeat.o(127338);
                return;
            }
            aqO.setSummary((int) R.string.e61);
            AppMethodBeat.o(127338);
            return;
        }
        aqO.setSummary(new p(intValue));
        AppMethodBeat.o(127338);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127339);
        ab.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
        }
        if (mVar.getType() == 256) {
            if (!(i == 0 && i2 == 0) && com.tencent.mm.plugin.setting.b.gkF.a((Context) this, i, i2, str)) {
                AppMethodBeat.o(127339);
                return;
            }
            int i3 = this.qmC.get(i2);
            String string = getString(R.string.e6e, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (i3 != 0) {
                try {
                    string = getString(i3);
                } catch (Exception e) {
                    ab.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", Integer.valueOf(i3), e.getMessage());
                    ab.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", e, "", new Object[0]);
                }
            }
            h.bQ(this.mController.ylL, string);
        }
        AppMethodBeat.o(127339);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127340);
        super.onActivityResult(i, i2, intent);
        if (i == 2) {
            switch (i2) {
                case -1:
                    if (!(g.Rg() == null || g.Rg().ftA == null)) {
                        g.Rg().ftA.cG(false);
                    }
                    com.tencent.mm.sdk.b.a.xxA.m(new gj());
                    com.tencent.mm.plugin.setting.b.gkF.BY();
                    g.RP().Ry().b(this);
                    jl jlVar = new jl();
                    jlVar.cEK.status = 0;
                    jlVar.cEK.boZ = 3;
                    com.tencent.mm.sdk.b.a.xxA.m(jlVar);
                    z zVar = new z();
                    zVar.csU.csV = true;
                    com.tencent.mm.sdk.b.a.xxA.m(zVar);
                    aj.amB("show_whatsnew");
                    l.m(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    com.tencent.mm.plugin.setting.b.gkE.p(intent2, this.mController.ylL);
                    w.I(this, null);
                    finish();
                    break;
            }
        }
        AppMethodBeat.o(127340);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127333);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsMoreSafeUI", str + " item has been clicked!");
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(127333);
            return false;
        }
        Intent intent;
        if (str.equals("settings_facebook")) {
            aA(FacebookAuthUI.class);
        } else if (str.equals("settings_email_addr")) {
            Integer num = (Integer) g.RP().Ry().get(7, null);
            if (!(num == null || (num.intValue() & 2) == 0)) {
                z = true;
            }
            str = (String) g.RP().Ry().get(5, null);
            if (z || !bo.isNullOrNil(str)) {
                startActivity(new Intent(this.mController.ylL, SettingsModifyEmailAddrUI.class));
            } else {
                if (this.ehJ != null) {
                    ab.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                h.a(this.mController.ylL, getString(R.string.e8i), bo.bc(w.ct(this.mController.ylL), ""), getString(R.string.e8j), 50, new h.b() {
                    public final boolean s(CharSequence charSequence) {
                        AppMethodBeat.i(127326);
                        if (bo.amW(charSequence.toString())) {
                            com.tencent.mm.plugin.setting.b.gkF.BS();
                            final m dVar = new d(d.gyK, charSequence.toString());
                            g.Rg().a(dVar, 0);
                            SettingsMoreSafeUI settingsMoreSafeUI = SettingsMoreSafeUI.this;
                            Context context = SettingsMoreSafeUI.this.mController.ylL;
                            SettingsMoreSafeUI.this.getString(R.string.tz);
                            settingsMoreSafeUI.ehJ = h.b(context, SettingsMoreSafeUI.this.getString(R.string.e62), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(127325);
                                    g.Rg().c(dVar);
                                    AppMethodBeat.o(127325);
                                }
                            });
                            AppMethodBeat.o(127326);
                            return true;
                        }
                        h.bQ(SettingsMoreSafeUI.this.mController.ylL, SettingsMoreSafeUI.this.getString(R.string.f0o));
                        AppMethodBeat.o(127326);
                        return false;
                    }
                });
            }
            AppMethodBeat.o(127333);
            return true;
        } else if (str.equals("settings_bind_qq")) {
            com.tencent.mm.plugin.setting.b.gkE.g(new Intent(), (Context) this);
            AppMethodBeat.o(127333);
            return true;
        } else if (str.equals("settings_phone_security")) {
            Intent intent2 = new Intent();
            int i = c.PK().a(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) ? 1 : 0;
            c.PK().b(a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
            ((IconPreference) preference).NN(8);
            int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, Integer.valueOf(0))).intValue();
            com.tencent.mm.plugin.report.service.h.pYm.e(10939, Integer.valueOf(intValue));
            if (bo.bH(this, "com.tencent.server.back.BackEngine")) {
                str = getString(R.string.g8n, new Object[]{Integer.valueOf(intValue), Integer.valueOf(1), Integer.valueOf(i)});
            } else {
                str = getString(R.string.g8n, new Object[]{Integer.valueOf(intValue), Integer.valueOf(0), Integer.valueOf(i)});
            }
            intent2.putExtra("rawUrl", str);
            intent2.putExtra("show_bottom", false);
            intent2.putExtra("showShare", false);
            com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (str.equals("settings_delete_account")) {
            intent = new Intent();
            if (!bo.isNullOrNil(this.qnZ)) {
                intent.putExtra("rawUrl", this.qnZ + "&lang=" + aa.gw(this.mController.ylL));
                intent.putExtra("showShare", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent, 2);
            }
        } else if (str.equals("settings_dump_personal_data")) {
            intent = new Intent();
            if (!bo.isNullOrNil(this.qoa)) {
                intent.putExtra("rawUrl", this.qoa);
                intent.putExtra("showShare", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", false);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            }
        }
        AppMethodBeat.o(127333);
        return false;
    }
}
