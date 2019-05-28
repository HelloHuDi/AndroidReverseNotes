package com.tencent.mm.plugin.setting.ui.setting;

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
import com.tencent.mm.R;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.em;
import com.tencent.mm.g.a.gj;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.g.a.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.r;
import com.tencent.mm.network.aa;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.x.a.a;
import java.util.ArrayList;

@i
public class SettingsUI extends MMPreference implements b {
    private f ehK;
    private ap fJs = null;
    private com.tencent.mm.ai.f fQS = null;
    private ap gyS;
    private d iHZ;
    private View nVX;
    private ProgressDialog qlZ = null;
    private ap qma;
    private com.tencent.mm.ai.f qmb = null;
    private PersonalPreference qpt = null;
    private com.tencent.mm.ai.f qpu = null;
    private a qpv = new a() {
        public final void p(int i, String str) {
            AppMethodBeat.i(127559);
            if (i == 262145 || i == 262157 || i == 262158) {
                SettingsUI.a(SettingsUI.this);
            }
            AppMethodBeat.o(127559);
        }

        public final void b(ac.a aVar) {
            AppMethodBeat.i(127560);
            if (aVar != null && aVar == ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                SettingsUI.b(SettingsUI.this);
            }
            AppMethodBeat.o(127560);
        }
    };
    private Dialog qpw = null;
    private c qpx;
    private CheckBox qpy;
    private com.tencent.mm.ai.f qpz = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsUI() {
        AppMethodBeat.i(127592);
        AppMethodBeat.o(127592);
    }

    static /* synthetic */ void a(SettingsUI settingsUI) {
        AppMethodBeat.i(127612);
        settingsUI.ciE();
        AppMethodBeat.o(127612);
    }

    static /* synthetic */ void b(SettingsUI settingsUI) {
        AppMethodBeat.i(127613);
        settingsUI.cji();
        AppMethodBeat.o(127613);
    }

    static /* synthetic */ boolean c(SettingsUI settingsUI) {
        AppMethodBeat.i(127614);
        boolean cjm = settingsUI.cjm();
        AppMethodBeat.o(127614);
        return cjm;
    }

    static /* synthetic */ boolean d(SettingsUI settingsUI) {
        AppMethodBeat.i(127615);
        boolean cjn = settingsUI.cjn();
        AppMethodBeat.o(127615);
        return cjn;
    }

    static /* synthetic */ void e(SettingsUI settingsUI) {
        AppMethodBeat.i(127616);
        settingsUI.cjl();
        AppMethodBeat.o(127616);
    }

    static /* synthetic */ void i(SettingsUI settingsUI) {
        AppMethodBeat.i(127618);
        settingsUI.kr(false);
        AppMethodBeat.o(127618);
    }

    static /* synthetic */ void p(SettingsUI settingsUI) {
        AppMethodBeat.i(127620);
        settingsUI.cjp();
        AppMethodBeat.o(127620);
    }

    static /* synthetic */ void z(SettingsUI settingsUI) {
        AppMethodBeat.i(127622);
        settingsUI.cje();
        AppMethodBeat.o(127622);
    }

    public final int JC() {
        return R.xml.bs;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127593);
        super.onCreate(bundle);
        initView();
        g.RP().Ry().a(this);
        com.tencent.mm.x.c.PK().a(this.qpv);
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1 && (g.RP().Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
            g.RP().Ry().set(ac.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
            ab.i("MicroMsg.SettingsUI", "unset more tab dot");
        }
        AppMethodBeat.o(127593);
    }

    public void onDestroy() {
        AppMethodBeat.i(127594);
        if (g.RK()) {
            g.RP().Ry().b(this);
            com.tencent.mm.x.c.PK().b(this.qpv);
        }
        if (this.fQS != null) {
            g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, this.fQS);
        }
        if (this.qmb != null) {
            g.Rg().b(255, this.qmb);
        }
        if (this.qpz != null) {
            g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, this.qpz);
        }
        super.onDestroy();
        AppMethodBeat.o(127594);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(127595);
        ab.v("MicroMsg.SettingsUI", "settings handle");
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(127595);
                    return;
                }
                h = n.h(getApplicationContext(), intent, com.tencent.mm.plugin.i.c.XW());
                if (h == null) {
                    AppMethodBeat.o(127595);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                o.acd();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.ah.d.D(r.Yz(), true));
                intent2.putExtra("CropImage_ImgPath", h);
                com.tencent.mm.plugin.setting.b.gkE.a((Activity) this, intent, intent2, com.tencent.mm.plugin.i.c.XW(), 4, null);
                AppMethodBeat.o(127595);
                return;
            case 3:
                h = n.h(getApplicationContext(), intent, com.tencent.mm.plugin.i.c.XW());
                if (h == null) {
                    AppMethodBeat.o(127595);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h);
                intent3.putExtra("CropImage_ImgPath", h);
                com.tencent.mm.plugin.setting.b.gkE.a(this.mController.ylL, intent3, 4);
                AppMethodBeat.o(127595);
                return;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(127595);
                    return;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                if (h == null) {
                    ab.e("MicroMsg.SettingsUI", "crop picture failed");
                } else {
                    new m(this.mController.ylL, h).w(null);
                }
                super.onActivityResult(i, i2, intent);
                AppMethodBeat.o(127595);
                return;
            case 5:
                if (i2 == -1) {
                    cje();
                }
                AppMethodBeat.o(127595);
                return;
            default:
                AppMethodBeat.o(127595);
                return;
        }
    }

    public void onPause() {
        AppMethodBeat.i(127596);
        super.onPause();
        g.RS().ae(new Runnable() {
            public final void run() {
                AppMethodBeat.i(127572);
                g.RP().Ry().dsb();
                AppMethodBeat.o(127572);
            }
        });
        AppMethodBeat.o(127596);
    }

    public void onResume() {
        AppMethodBeat.i(127597);
        PersonalPreference personalPreference = (PersonalPreference) this.ehK.aqO("settings_account");
        if (personalPreference != null) {
            String Yz = r.Yz();
            personalPreference.fru = null;
            personalPreference.qkZ = -1;
            personalPreference.qla = Yz;
            if (personalPreference.moN != null) {
                com.tencent.mm.pluginsdk.ui.a.b.b(personalPreference.moN, personalPreference.qla);
            }
        }
        em emVar = new em();
        com.tencent.mm.sdk.b.a.xxA.m(emVar);
        if (!emVar.cxZ.cwB) {
            this.ehK.d(this.ehK.aqO("settings_about_device"));
        }
        cji();
        cjk();
        ciE();
        cjj();
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_welab");
        com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) g.K(com.tencent.mm.plugin.welab.a.a.c.class);
        if (cVar.ddo()) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
        } else {
            iconPreference.NL(8);
        }
        if (!cVar.ddp()) {
            iconPreference.hm(8, -1);
        } else if (cVar.ddn()) {
            iconPreference.hm(0, R.drawable.a4h);
        } else {
            iconPreference.hm(0, R.raw.welab_icon_grey);
        }
        ab.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
        AppMethodBeat.o(127597);
    }

    private void cji() {
        AppMethodBeat.i(127598);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_account_info");
        if (iconPreference == null) {
            ab.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            AppMethodBeat.o(127598);
            return;
        }
        iconPreference.NQ(8);
        if (com.tencent.mm.x.c.PK().a(ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257)) {
            iconPreference.NN(0);
        } else {
            iconPreference.NN(8);
        }
        if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1) {
            if (!((Boolean) g.RP().Ry().get(ac.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            } else if ((g.RP().Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                iconPreference.ey(getString(R.string.s0), R.drawable.w3);
                iconPreference.NL(0);
                ab.i("MicroMsg.SettingsUI", "show voiceprint dot");
            }
            this.ehK.notifyDataSetChanged();
        }
        AppMethodBeat.o(127598);
    }

    public final void initView() {
        AppMethodBeat.i(127599);
        setMMTitle((int) R.string.ebr);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127586);
                SettingsUI.this.finish();
                AppMethodBeat.o(127586);
                return true;
            }
        });
        this.iHZ = new d(this, 1, false);
        this.iHZ.rBl = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                AppMethodBeat.i(127587);
                if (lVar.dzR()) {
                    lVar.ax(1, R.string.cpf, R.raw.menu_logout_single);
                    lVar.ax(2, R.string.cpd, R.raw.menu_close_wechat);
                }
                AppMethodBeat.o(127587);
            }
        };
        this.iHZ.zQf = new d.a() {
            public final void onDismiss() {
            }
        };
        this.iHZ.rBm = new com.tencent.mm.ui.base.n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(127588);
                switch (menuItem.getItemId()) {
                    case 1:
                        SettingsUI.c(SettingsUI.this);
                        AppMethodBeat.o(127588);
                        return;
                    case 2:
                        SettingsUI.d(SettingsUI.this);
                        break;
                }
                AppMethodBeat.o(127588);
            }
        };
        AnonymousClass27 anonymousClass27 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(127589);
                BackwardSupportUtil.c.a(SettingsUI.this.nDp);
                AppMethodBeat.o(127589);
            }
        };
        cjk();
        ciE();
        cjj();
        this.ehK.ce("settings_redesign", true);
        AppMethodBeat.o(127599);
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(127600);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        if (nVar != g.RP().Ry() || g <= 0) {
            ab.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(127600);
            return;
        }
        if (4 == g) {
            g.RP().Ry().get(2, null);
            g.RP().Ry().get(4, null);
        }
        if (6 == g) {
            cjk();
            AppMethodBeat.o(127600);
            return;
        }
        if (64 == g) {
            cji();
        }
        AppMethodBeat.o(127600);
    }

    private void ciE() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(127601);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_about_micromsg");
        boolean a = bo.a(Boolean.valueOf(com.tencent.mm.x.c.PK().bX(262145, 266243)), false);
        boolean bY = com.tencent.mm.x.c.PK().bY(262157, 266262);
        if (com.tencent.mm.sdk.platformtools.g.xyg) {
            iconPreference.ey("", -1);
            iconPreference.NL(8);
        } else if (a) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
        } else if (bY) {
            iconPreference.NN(0);
        } else {
            iconPreference.NN(8);
            iconPreference.ey("", -1);
            iconPreference.NL(8);
        }
        iconPreference = (IconPreference) this.ehK.aqO("settings_about_system");
        if (com.tencent.mm.x.c.PK().bY(262158, 266265)) {
            i = 0;
        } else {
            i = 8;
        }
        iconPreference.NN(i);
        com.tencent.mm.plugin.r.a.bVv();
        if (!com.tencent.mm.ax.c.lQ(com.tencent.mm.ax.b.fKD)) {
            i2 = 8;
        }
        iconPreference.NN(i2);
        AppMethodBeat.o(127601);
    }

    private void cjj() {
        AppMethodBeat.i(127602);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_about_privacy");
        if (iconPreference != null) {
            if (((Integer) g.RP().Ry().get(ac.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue() > ((Integer) g.RP().Ry().get(ac.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                iconPreference.NN(0);
                AppMethodBeat.o(127602);
                return;
            }
            iconPreference.NN(8);
        }
        AppMethodBeat.o(127602);
    }

    private void cjk() {
        AppMethodBeat.i(127603);
        com.tencent.mm.plugin.account.friend.a.l.a apS = com.tencent.mm.plugin.account.friend.a.l.apS();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.ehK.aqO("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            boolean z = apS == com.tencent.mm.plugin.account.friend.a.l.a.SUCC || apS == com.tencent.mm.plugin.account.friend.a.l.a.SUCC_UNLOAD;
            switchKeyValuePreference.qk(z);
            int i = (apS == com.tencent.mm.plugin.account.friend.a.l.a.SUCC || apS == com.tencent.mm.plugin.account.friend.a.l.a.SUCC_UNLOAD) ? R.string.e_8 : R.string.e_7;
            switchKeyValuePreference.setSummary(i);
        }
        AppMethodBeat.o(127603);
    }

    private void cjl() {
        AppMethodBeat.i(127605);
        Intent intent = new Intent(this, SettingsSwitchAccountUI.class);
        intent.putExtra("key_scene", 0);
        startActivity(intent);
        AppMethodBeat.o(127605);
    }

    private void cje() {
        AppMethodBeat.i(127606);
        ab.i("MicroMsg.SettingsUI", "oneliang logout mm");
        com.tencent.mm.plugin.setting.b.gkF.BY();
        g.RP().Ry().b(this);
        jl jlVar = new jl();
        jlVar.cEK.status = 0;
        jlVar.cEK.boZ = 0;
        com.tencent.mm.sdk.b.a.xxA.m(jlVar);
        z zVar = new z();
        zVar.csU.csV = true;
        com.tencent.mm.sdk.b.a.xxA.m(zVar);
        aj.amB("show_whatsnew");
        com.tencent.mm.kernel.l.m(this, true);
        ah.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.b.gkE.p(intent, this.mController.ylL);
        w.I(this, null);
        finish();
        AppMethodBeat.o(127606);
    }

    private boolean cjm() {
        AppMethodBeat.i(127607);
        h.pYm.e(11545, Integer.valueOf(1));
        ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.qpw != null) {
            this.qpw.show();
            AppMethodBeat.o(127607);
        } else {
            ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.qpw = com.tencent.mm.ui.base.h.d(this, getString(R.string.e84), "", getString(R.string.e80), getString(R.string.e83), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127561);
                    h.pYm.e(11545, Integer.valueOf(3));
                    ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
                    h.pYm.a(99, 145, 1, false);
                    if (!(g.Rg() == null || g.Rg().ftA == null)) {
                        g.Rg().ftA.cG(false);
                    }
                    if (SettingsUI.this.qpw != null) {
                        SettingsUI.this.qpw.dismiss();
                    }
                    SettingsUI.g(SettingsUI.this);
                    AppMethodBeat.o(127561);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127562);
                    h.pYm.e(11545, Integer.valueOf(2));
                    ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
                    if (SettingsUI.this.qpw != null) {
                        SettingsUI.this.qpw.dismiss();
                    }
                    AppMethodBeat.o(127562);
                }
            });
            AppMethodBeat.o(127607);
        }
        return true;
    }

    private boolean cjn() {
        AppMethodBeat.i(127608);
        h.pYm.e(11545, Integer.valueOf(4));
        ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.nVX == null) {
            this.nVX = View.inflate(this.mController.ylL, R.layout.arr, null);
            this.qpy = (CheckBox) this.nVX.findViewById(R.id.e_0);
            this.qpy.setChecked(true);
        }
        if (this.qpx == null) {
            this.qpx = com.tencent.mm.ui.base.h.a(this.mController.ylL, null, this.nVX, getString(R.string.cpd), getString(R.string.or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127563);
                    com.tencent.mm.modelstat.c.akc().commitNow();
                    ((com.tencent.mm.plugin.expt.a.c) g.K(com.tencent.mm.plugin.expt.a.c.class)).logout();
                    if (SettingsUI.this.qpy == null || !SettingsUI.this.qpy.isChecked()) {
                        ab.i("MicroMsg.SettingsUI", "normally exit");
                        h.pYm.a(99, 144, 1, false);
                        h.pYm.e(11545, Integer.valueOf(7));
                        ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
                        if (!(g.Rg() == null || g.Rg().ftA == null)) {
                            g.Rg().ftA.cG(false);
                        }
                        com.tencent.mm.sdk.b.a.xxA.m(new gj());
                        SettingsUI.j(SettingsUI.this);
                        AppMethodBeat.o(127563);
                        return;
                    }
                    ab.i("MicroMsg.SettingsUI", "push notify mode exit");
                    h.pYm.a(99, 143, 1, false);
                    h.pYm.e(11545, Integer.valueOf(6));
                    ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
                    aa.anh().edit().putBoolean("is_in_notify_mode", true).commit();
                    SettingsUI.i(SettingsUI.this);
                    AppMethodBeat.o(127563);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127564);
                    h.pYm.e(11545, Integer.valueOf(5));
                    ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
                    AppMethodBeat.o(127564);
                }
            });
        } else {
            this.qpx.show();
        }
        AppMethodBeat.o(127608);
        return true;
    }

    private void cjo() {
        AppMethodBeat.i(127609);
        p Rg = g.Rg();
        com.tencent.mm.ai.f anonymousClass19 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(127581);
                String Yz = r.Yz();
                if (bx.fnB.oL(Yz)) {
                    bx.fnB.n(Yz, "last_logout_no_pwd_ticket", "");
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127580);
                        g.Rg().b((int) com.tencent.view.d.MIC_PTU_BAIXI, SettingsUI.this.fQS);
                        SettingsUI.this.qpu = null;
                        AppMethodBeat.o(127580);
                    }
                });
                AppMethodBeat.o(127581);
            }
        };
        this.qpu = anonymousClass19;
        Rg.a((int) com.tencent.view.d.MIC_PTU_BAIXI, anonymousClass19);
        g.Rg().a(new com.tencent.mm.modelsimple.p(), 0);
        AppMethodBeat.o(127609);
    }

    private void kr(boolean z) {
        AppMethodBeat.i(127610);
        aj.amB("welcome_page_show");
        if (z) {
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().II();
        } else {
            ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().k(-1, null);
        }
        z zVar = new z();
        zVar.csU.csV = false;
        com.tencent.mm.sdk.b.a.xxA.m(zVar);
        com.tencent.mm.plugin.setting.b.gkF.BV();
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IH();
        finish();
        if (e.vdx != null) {
            e.vdx.k(this.mController.ylL, z);
        }
        AppMethodBeat.o(127610);
    }

    private void cjp() {
        AppMethodBeat.i(127611);
        p Rg = g.Rg();
        com.tencent.mm.ai.f anonymousClass20 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(final int i, final int i2, String str, final com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(127583);
                ab.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127582);
                        g.Rg().b(255, SettingsUI.this.qmb);
                        SettingsUI.this.qmb = null;
                        if (SettingsUI.this.qma != null) {
                            SettingsUI.this.qma.stopTimer();
                            SettingsUI.this.qma = null;
                        }
                        if (SettingsUI.this.qlZ != null) {
                            SettingsUI.this.qlZ.dismiss();
                        }
                        if (mVar.getType() == 255 && ((com.tencent.mm.modelsimple.r) mVar).fPr == 1) {
                            if (i2 == -3 && i == 4) {
                                Intent intent = new Intent(SettingsUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsUI.this.getString(R.string.dlz));
                                SettingsUI.this.startActivityForResult(intent, 0);
                                AppMethodBeat.o(127582);
                                return;
                            }
                            SettingsUI.B(SettingsUI.this);
                        }
                        AppMethodBeat.o(127582);
                    }
                });
                AppMethodBeat.o(127583);
            }
        };
        this.qmb = anonymousClass20;
        Rg.a(255, anonymousClass20);
        final com.tencent.mm.ai.m rVar = new com.tencent.mm.modelsimple.r(2);
        rVar.fPr = 1;
        g.Rg().a(rVar, 0);
        this.qma = new ap(Looper.getMainLooper(), new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(127584);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.B(SettingsUI.this);
                AppMethodBeat.o(127584);
                return false;
            }
        }, false);
        this.qma.ae(3000, 3000);
        Context context = this.mController.ylL;
        getString(R.string.tz);
        this.qlZ = com.tencent.mm.ui.base.h.b(context, getString(R.string.g34), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127585);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.o(127585);
            }
        });
        AppMethodBeat.o(127611);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127604);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        Intent intent;
        boolean cjn;
        if ("settings_welab".equals(str)) {
            intent = new Intent();
            ArrayList arrayList = new ArrayList();
            arrayList.add("labs_browse");
            intent.putStringArrayListExtra("key_exclude_apps", arrayList);
            ((com.tencent.mm.plugin.welab.a.a.c) g.K(com.tencent.mm.plugin.welab.a.a.c.class)).D(this, intent);
            AppMethodBeat.o(127604);
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (bo.getInt(com.tencent.mm.m.g.Nu().getValue("VoiceprintEntry"), 0) == 1 && (g.RP().Ry().getInt(40, 0) & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0) {
                g.RP().Ry().set(ac.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
                ab.i("MicroMsg.SettingsUI", "unset setting account info dot show");
            }
            com.tencent.mm.x.c.PK().b(ac.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257);
            aA(SettingsAccountInfoUI.class);
            AppMethodBeat.o(127604);
            return true;
        } else if ("settings_account".equals(str)) {
            this.mController.ylL.startActivity(new Intent(this, SettingsPersonalInfoUI.class));
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent2 = new Intent(this, BindMContactIntroUI.class);
            intent2.putExtra("key_upload_scene", 4);
            MMWizardActivity.J(this, intent2);
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            int intValue = ((Integer) g.RP().Ry().get(ac.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, Integer.valueOf(0))).intValue();
            if (intValue > ((Integer) g.RP().Ry().get(ac.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(0))).intValue()) {
                g.RP().Ry().set(ac.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            }
            startActivity(new Intent(this, SettingsPrivacyUI.class));
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_about_system")) {
            com.tencent.mm.x.c.PK().bZ(262158, 266265);
            startActivity(new Intent(this, SettingsAboutSystemUI.class));
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            com.tencent.mm.x.c.PK().bZ(262145, 266243);
            com.tencent.mm.x.c.PK().bZ(262157, 266262);
            this.mController.ylL.startActivity(new Intent(this, SettingsAboutMicroMsgUI.class));
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(127591);
                    com.tencent.mm.cj.c.aNX();
                    AppMethodBeat.o(127591);
                }
            }, 100);
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_about_device")) {
            com.tencent.mm.bp.d.b(this.mController.ylL, "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.au.b.ahP()) {
                ab.i("MicroMsg.SettingsUI", "oversea user logout");
                com.tencent.mm.ui.base.h.a(this.mController.ylL, true, getResources().getString(R.string.e84), "", getResources().getString(R.string.e80), getString(R.string.or), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127573);
                        SettingsUI.g(SettingsUI.this);
                        AppMethodBeat.o(127573);
                    }
                }, null);
                AppMethodBeat.o(127604);
                return true;
            }
            h.pYm.e(11545, Integer.valueOf(8));
            ab.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            if (bx.fnB.aat().size() > 1) {
                h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(10), bx.fnB.aau());
            } else {
                h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(10), bx.fnB.aau());
            }
            this.iHZ.cpD();
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_exit")) {
            cjn = cjn();
            AppMethodBeat.o(127604);
            return cjn;
        } else if (str.equals("settings_logout_option")) {
            cjn = cjm();
            AppMethodBeat.o(127604);
            return cjn;
        } else if (str.equals("settings_notification_preference")) {
            startActivity(new Intent(this, SettingsNotificationUI.class));
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_chatting")) {
            aA(SettingsChattingUI.class);
            AppMethodBeat.o(127604);
            return true;
        } else if (str.equals("settings_active_time")) {
            h.pYm.e(11351, Integer.valueOf(1), Integer.valueOf(0));
            aA(SettingsActiveTimeUI.class);
            AppMethodBeat.o(127604);
            return true;
        } else {
            if (str.equals("settings_feedback")) {
                if (!com.tencent.mm.sdk.platformtools.g.xyg && com.tencent.mm.sdk.platformtools.aa.dor().equals("zh_CN")) {
                    str = getString(R.string.g0f);
                } else if (com.tencent.mm.sdk.platformtools.aa.dor().equals("zh_HK")) {
                    str = getString(R.string.g0g);
                } else if (com.tencent.mm.sdk.platformtools.aa.dor().equals("zh_TW")) {
                    str = getString(R.string.g0h);
                } else {
                    str = getString(R.string.g0i);
                }
                ab.d("MicroMsg.SettingsUI", "using faq webpage");
                intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", str);
                intent.putExtra("show_feedback", false);
                intent.putExtra("KShowFixToolsBtn", true);
                com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            } else if (str.equals("settings_switch_account")) {
                if (bx.fnB.aat().size() > 1) {
                    h.pYm.e(14978, Integer.valueOf(1), Integer.valueOf(6), bx.fnB.aau());
                } else {
                    h.pYm.e(14978, Integer.valueOf(0), Integer.valueOf(6), bx.fnB.aau());
                }
                if (g.RP().Ry().getBoolean(ac.a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, true)) {
                    g.RP().Ry().set(ac.a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, Boolean.FALSE);
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ebb), getString(R.string.ebc), getString(R.string.r4), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(127590);
                            SettingsUI.e(SettingsUI.this);
                            AppMethodBeat.o(127590);
                        }
                    });
                } else {
                    cjl();
                }
            } else if (str.equals("settings_redesign")) {
                startActivity(new Intent(this, SettingRedesign.class));
                AppMethodBeat.o(127604);
                return true;
            }
            AppMethodBeat.o(127604);
            return false;
        }
    }

    static /* synthetic */ void g(SettingsUI settingsUI) {
        AppMethodBeat.i(127617);
        Object[] objArr = new Object[1];
        g.RN();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.QF());
        ab.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", objArr);
        com.tencent.mm.sdk.b.a.xxA.m(new gj());
        com.tencent.mm.modelstat.c.akc().commitNow();
        ((com.tencent.mm.plugin.expt.a.c) g.K(com.tencent.mm.plugin.expt.a.c.class)).logout();
        p Rg = g.Rg();
        com.tencent.mm.ai.f anonymousClass9 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(final int i, final int i2, String str, final com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(127569);
                ab.d("MicroMsg.SettingsUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127568);
                        g.Rg().b(255, SettingsUI.this.qmb);
                        SettingsUI.this.qmb = null;
                        if (SettingsUI.this.qma != null) {
                            SettingsUI.this.qma.stopTimer();
                            SettingsUI.this.qma = null;
                        }
                        if (SettingsUI.this.qlZ != null) {
                            SettingsUI.this.qlZ.dismiss();
                        }
                        if (mVar.getType() == 255 && ((com.tencent.mm.modelsimple.r) mVar).fPr == 2) {
                            if (i2 == -3 && i == 4) {
                                Intent intent = new Intent(SettingsUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsUI.this.getString(R.string.dlz));
                                SettingsUI.this.startActivityForResult(intent, 5);
                                AppMethodBeat.o(127568);
                                return;
                            }
                            SettingsUI.u(SettingsUI.this);
                        }
                        AppMethodBeat.o(127568);
                    }
                });
                AppMethodBeat.o(127569);
            }
        };
        settingsUI.qmb = anonymousClass9;
        Rg.a(255, anonymousClass9);
        final com.tencent.mm.ai.m rVar = new com.tencent.mm.modelsimple.r(2);
        rVar.fPr = 2;
        g.Rg().a(rVar, 0);
        settingsUI.qma = new ap(Looper.getMainLooper(), new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(127570);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.u(SettingsUI.this);
                AppMethodBeat.o(127570);
                return false;
            }
        }, false);
        settingsUI.qma.ae(12000, 12000);
        settingsUI.getString(R.string.tz);
        settingsUI.qlZ = com.tencent.mm.ui.base.h.b((Context) settingsUI, settingsUI.getString(R.string.g35), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127571);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsUI.this.qmb);
                SettingsUI.this.qmb = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.o(127571);
            }
        });
        if (g.RK()) {
            av.fly.ou(com.tencent.mm.ah.b.pX(r.Yz()));
        }
        AppMethodBeat.o(127617);
    }

    static /* synthetic */ void j(SettingsUI settingsUI) {
        AppMethodBeat.i(127619);
        Object[] objArr = new Object[1];
        g.RN();
        objArr[0] = Integer.valueOf(com.tencent.mm.kernel.a.QF());
        ab.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", objArr);
        if (com.tencent.mm.kernel.a.jP(g.RN().eIV)) {
            p Rg = g.Rg();
            com.tencent.mm.ai.f anonymousClass6 = new com.tencent.mm.ai.f() {
                public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                    AppMethodBeat.i(127565);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
                    SettingsUI.this.qpz = null;
                    if (SettingsUI.this.fJs != null) {
                        SettingsUI.this.fJs.stopTimer();
                        SettingsUI.this.fJs = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    SettingsUI.p(SettingsUI.this);
                    AppMethodBeat.o(127565);
                }
            };
            settingsUI.qpz = anonymousClass6;
            Rg.a((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, anonymousClass6);
            final com.tencent.mm.ai.m abVar = new com.tencent.mm.modelsimple.ab(2);
            g.Rg().a(abVar, 0);
            settingsUI.fJs = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(127566);
                    g.Rg().c(abVar);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
                    SettingsUI.this.qpz = null;
                    if (SettingsUI.this.fJs != null) {
                        SettingsUI.this.fJs.stopTimer();
                        SettingsUI.this.fJs = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    SettingsUI.p(SettingsUI.this);
                    AppMethodBeat.o(127566);
                    return false;
                }
            }, false);
            settingsUI.fJs.ae(5000, 5000);
            Context context = settingsUI.mController.ylL;
            settingsUI.getString(R.string.tz);
            settingsUI.qlZ = com.tencent.mm.ui.base.h.b(context, settingsUI.getString(R.string.g05), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(127567);
                    g.Rg().c(abVar);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.qpz);
                    SettingsUI.this.qpz = null;
                    if (SettingsUI.this.fJs != null) {
                        SettingsUI.this.fJs.stopTimer();
                        SettingsUI.this.fJs = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    AppMethodBeat.o(127567);
                }
            });
            AppMethodBeat.o(127619);
            return;
        }
        settingsUI.cjp();
        AppMethodBeat.o(127619);
    }

    static /* synthetic */ void u(SettingsUI settingsUI) {
        AppMethodBeat.i(127621);
        if (!com.tencent.mm.kernel.a.jP(g.RN().eIV) || com.tencent.mm.sdk.platformtools.f.EX_DEVICE_LOGIN) {
            settingsUI.cjo();
            settingsUI.gyS = new ap(Looper.getMainLooper(), new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(127578);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                    SettingsUI.this.fQS = null;
                    SettingsUI.this.qpu = null;
                    if (SettingsUI.this.gyS != null) {
                        SettingsUI.this.gyS.stopTimer();
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.cancel();
                    }
                    SettingsUI.z(SettingsUI.this);
                    AppMethodBeat.o(127578);
                    return false;
                }
            }, false);
            settingsUI.gyS.ae(3000, 3000);
            settingsUI.getString(R.string.tz);
            settingsUI.qlZ = com.tencent.mm.ui.base.h.b((Context) settingsUI, settingsUI.getString(R.string.g35), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(127579);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                    g.Rg().b((int) com.tencent.view.d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                    SettingsUI.this.fQS = null;
                    SettingsUI.this.qpu = null;
                    if (SettingsUI.this.qma != null) {
                        SettingsUI.this.qma.stopTimer();
                        SettingsUI.this.qma = null;
                    }
                    if (SettingsUI.this.qlZ != null) {
                        SettingsUI.this.qlZ.dismiss();
                    }
                    AppMethodBeat.o(127579);
                }
            });
            AppMethodBeat.o(127621);
            return;
        }
        p Rg = g.Rg();
        com.tencent.mm.ai.f anonymousClass14 = new com.tencent.mm.ai.f() {
            public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                AppMethodBeat.i(127575);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127574);
                        g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                        SettingsUI.this.fQS = null;
                        AppMethodBeat.o(127574);
                    }
                });
                AppMethodBeat.o(127575);
            }
        };
        settingsUI.fQS = anonymousClass14;
        Rg.a((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, anonymousClass14);
        final com.tencent.mm.ai.m abVar = new com.tencent.mm.modelsimple.ab(2);
        g.Rg().a(abVar, 0);
        settingsUI.cjo();
        settingsUI.qma = new ap(Looper.getMainLooper(), new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(127576);
                g.Rg().c(abVar);
                g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                g.Rg().b((int) com.tencent.view.d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                SettingsUI.this.fQS = null;
                SettingsUI.this.qpu = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.cancel();
                }
                SettingsUI.z(SettingsUI.this);
                AppMethodBeat.o(127576);
                return false;
            }
        }, false);
        settingsUI.qma.ae(5000, 5000);
        settingsUI.getString(R.string.tz);
        settingsUI.qlZ = com.tencent.mm.ui.base.h.b((Context) settingsUI, settingsUI.getString(R.string.g05), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127577);
                g.Rg().c(abVar);
                g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, SettingsUI.this.fQS);
                g.Rg().b((int) com.tencent.view.d.MIC_PTU_BAIXI, SettingsUI.this.qpu);
                SettingsUI.this.fQS = null;
                SettingsUI.this.qpu = null;
                if (SettingsUI.this.qma != null) {
                    SettingsUI.this.qma.stopTimer();
                    SettingsUI.this.qma = null;
                }
                if (SettingsUI.this.qlZ != null) {
                    SettingsUI.this.qlZ.dismiss();
                }
                AppMethodBeat.o(127577);
            }
        });
        AppMethodBeat.o(127621);
    }

    static /* synthetic */ void B(SettingsUI settingsUI) {
        AppMethodBeat.i(127623);
        settingsUI.kr(true);
        AppMethodBeat.o(127623);
    }
}
