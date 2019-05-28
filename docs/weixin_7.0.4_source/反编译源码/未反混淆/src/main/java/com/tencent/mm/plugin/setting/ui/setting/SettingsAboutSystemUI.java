package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.os.Process;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.i.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.x.c;
import java.util.List;

public class SettingsAboutSystemUI extends MMPreference {
    private f ehK;
    private boolean isDeleteCancel = false;
    private ProgressDialog qlZ = null;
    private boolean qmh = false;
    private int qmi = -1;
    private int qmj = -1;
    private boolean qmk = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.i(127134);
        settingsAboutSystemUI.ciG();
        AppMethodBeat.o(127134);
    }

    static /* synthetic */ void f(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.i(127135);
        settingsAboutSystemUI.ciH();
        AppMethodBeat.o(127135);
    }

    public final int JC() {
        return R.xml.c8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127122);
        super.onCreate(bundle);
        this.qmh = false;
        initView();
        AppMethodBeat.o(127122);
    }

    public final void initView() {
        AppMethodBeat.i(127123);
        setMMTitle((int) R.string.e5b);
        this.ehK = this.yCw;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127107);
                SettingsAboutSystemUI.this.aqX();
                SettingsAboutSystemUI.this.finish();
                AppMethodBeat.o(127107);
                return true;
            }
        });
        this.ehK.ce("settings_swipeback_mode", !d.iW(19));
        if (!com.tencent.mm.bp.d.afj("backup")) {
            this.ehK.ce("settings_bak_chat", true);
        }
        ciE();
        this.ehK.ce("settings_traffic_statistic", com.tencent.mm.bp.d.dlL());
        if (ae.gjt) {
            this.ehK.ce("settings_take_photo", true);
        }
        AppMethodBeat.o(127123);
    }

    public void onResume() {
        AppMethodBeat.i(127124);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) g.RP().Ry().get(26, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) g.RP().Ry().get(66832, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = b.Ml();
            checkBoxPreference.yDf = false;
        }
        Preference aqO = this.ehK.aqO("settings_language");
        if (aqO != null) {
            aqO.setSummary(aa.gx(this.mController.ylL));
        }
        ciE();
        ciH();
        ciH();
        ciG();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.ehK.ce("settings_nfc_switch", true);
            AppMethodBeat.o(127124);
            return;
        }
        this.ehK.ce("settings_nfc_switch", false);
        checkBoxPreference.setSummary((CharSequence) bo.nullAsNil((String) g.RP().Ry().get(a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, null)));
        if (this.qmh) {
            ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                jC(true);
                kp(true);
                AppMethodBeat.o(127124);
                return;
            }
        }
        int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            if (((Integer) g.RP().Ry().get(a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                kp(true);
            } else {
                kp(false);
            }
        } else if (intValue == 1) {
            kp(true);
        } else {
            kp(false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127124);
    }

    public void onDestroy() {
        boolean z = true;
        AppMethodBeat.i(127125);
        super.onDestroy();
        if (this.qmk) {
            boolean z2;
            String str = "MicroMsg.SettingsAboutSystemUI";
            String str2 = "kvstat, autodownload sight change: %d, %b";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.qmj);
            if (this.qmi == this.qmj) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            ab.i(str, str2, objArr);
            h hVar = h.pYm;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.qmj);
            if (this.qmi != this.qmj) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            hVar.e(11437, objArr2);
        }
        AppMethodBeat.o(127125);
    }

    private void ciE() {
        int i;
        int i2 = 0;
        AppMethodBeat.i(127127);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_plugins");
        if (bo.a((Boolean) g.RP().Ry().get(-2046825377, null), false)) {
            iconPreference.NL(0);
            iconPreference.ey(getString(R.string.s0), R.drawable.w3);
        } else {
            iconPreference.NL(8);
            iconPreference.ey("", -1);
        }
        if (c.PK().bY(262158, 266266)) {
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
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127127);
    }

    private boolean ciF() {
        AppMethodBeat.i(127128);
        startActivity(new Intent(this, SettingsFontUI.class));
        AppMethodBeat.o(127128);
        return true;
    }

    private void jC(boolean z) {
        AppMethodBeat.i(127129);
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            g.RP().Ry().set(a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(1));
            AppMethodBeat.o(127129);
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        g.RP().Ry().set(a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(2));
        AppMethodBeat.o(127129);
    }

    private void kp(boolean z) {
        AppMethodBeat.i(127130);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_nfc_switch");
        ah.getContext().getSharedPreferences(ah.doA(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.uOT = z;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127130);
    }

    private void ciG() {
        boolean z = true;
        AppMethodBeat.i(127131);
        boolean z2 = bo.ank(com.tencent.mm.m.g.Nu().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
            ab.d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.ehK.ce("settings_silence_update_mode", true);
            AppMethodBeat.o(127131);
            return;
        }
        this.ehK.ce("settings_silence_update_mode", false);
        if ((((Integer) g.RP().Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.ehK.aqO("settings_silence_update_mode").setSummary(getString(z ? R.string.eao : R.string.ean));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127131);
    }

    private void ciH() {
        AppMethodBeat.i(127133);
        int a = bo.a((Integer) g.RP().Ry().get(327686, null), bo.getInt(com.tencent.mm.m.g.Nu().getValue("SIGHTAutoLoadNetwork"), 1));
        ab.i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", Integer.valueOf(r1), Integer.valueOf(a));
        if (this.qmi == -1) {
            this.qmi = a;
        }
        this.qmj = a;
        if (3 == a) {
            a = R.string.eaz;
        } else if (2 == a) {
            a = R.string.eb1;
        } else {
            a = R.string.eay;
        }
        Preference aqO = this.ehK.aqO("settings_sns_sight_auto_download");
        if (aqO != null) {
            aqO.setSummary(getString(a));
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127133);
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127126);
        String str = preference.mKey;
        boolean z2;
        int intValue;
        boolean booleanValue;
        com.tencent.mm.ui.widget.a.c.a aVar;
        final LinearLayout linearLayout;
        boolean z3;
        com.tencent.mm.ui.widget.a.c aMb;
        boolean ciF;
        Intent intent;
        if (str.equals("settings_landscape_mode")) {
            if (this.ehZ.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (q.etd.epO == 1) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!this.ehZ.getBoolean("settings_voicerecorder_mode", z2)) {
                com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.ed1, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(127119);
                        SettingsAboutSystemUI.this.ehZ.edit().putBoolean("settings_voicerecorder_mode", true).commit();
                        ((CheckBoxPreference) SettingsAboutSystemUI.this.ehK.aqO("settings_voicerecorder_mode")).uOT = true;
                        SettingsAboutSystemUI.this.ehK.notifyDataSetChanged();
                        AppMethodBeat.o(127119);
                    }
                });
            }
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
            } else {
                int intValue2 = ((Integer) g.RP().Ry().get(a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
                intValue = ((Integer) g.RP().Ry().get(a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
                if ((intValue2 == 2 || (intValue2 == 0 && intValue != 1)) && !defaultAdapter.isEnabled() && this.ehZ.getBoolean("settings_nfc_switch", false)) {
                    kp(false);
                    com.tencent.mm.ui.base.h.d(this.mController.ylL, getString(R.string.d6w), "", getString(R.string.d6x), getString(R.string.or), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(127117);
                            ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
                            SettingsAboutSystemUI.this.qmh = true;
                            SettingsAboutSystemUI.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
                            AppMethodBeat.o(127117);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(127118);
                            ab.i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
                            AppMethodBeat.o(127118);
                        }
                    });
                } else {
                    jC(this.ehZ.getBoolean("settings_nfc_switch", false));
                }
            }
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            booleanValue = ((Boolean) g.RP().Ry().get(26, Boolean.FALSE)).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            objArr[1] = Boolean.valueOf(!booleanValue);
            ab.d(str2, str3, objArr);
            z Ry = g.RP().Ry();
            if (!booleanValue) {
                z = true;
            }
            Ry.set(26, Boolean.valueOf(z));
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
            if (checkBoxPreference != null) {
                ab.d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
                g.RP().Ry().set(66832, Boolean.valueOf(z2));
            }
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            aVar = new com.tencent.mm.ui.widget.a.c.a(this.mController.ylL);
            aVar.Qd(R.string.or);
            aVar.PV(R.string.eb0);
            View inflate = View.inflate(this.mController.ylL, R.layout.ad9, null);
            linearLayout = (LinearLayout) inflate.findViewById(R.id.d93);
            final int a = bo.a((Integer) g.RP().Ry().get(327686, null), bo.getInt(com.tencent.mm.m.g.Nu().getValue("SIGHTAutoLoadNetwork"), 1));
            AnonymousClass2 anonymousClass2 = new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(127109);
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (R.id.bn0 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    ab.i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", Integer.valueOf(a), Integer.valueOf(intValue));
                    if (a == intValue) {
                        AppMethodBeat.o(127109);
                        return;
                    }
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127108);
                            ((Dialog) linearLayout.getTag()).dismiss();
                            g.RP().Ry().set(327686, Integer.valueOf(intValue));
                            g.RP().Ry().dsb();
                            SettingsAboutSystemUI.f(SettingsAboutSystemUI.this);
                            AppMethodBeat.o(127108);
                        }
                    });
                    AppMethodBeat.o(127109);
                }
            };
            a(linearLayout, R.string.eay, 1, 1 == a, anonymousClass2);
            if (2 == a) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(linearLayout, R.string.eb1, 2, z3, anonymousClass2);
            if (3 == a) {
                z3 = true;
            } else {
                z3 = false;
            }
            a(linearLayout, R.string.eaz, 3, z3, anonymousClass2);
            aVar.fn(inflate);
            aMb = aVar.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            addDialog(aMb);
            this.qmk = true;
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            aVar = new com.tencent.mm.ui.widget.a.c.a(this.mController.ylL);
            aVar.Qd(R.string.or);
            aVar.PV(R.string.eam);
            View inflate2 = View.inflate(this.mController.ylL, R.layout.ad9, null);
            linearLayout = (LinearLayout) inflate2.findViewById(R.id.d93);
            AnonymousClass10 anonymousClass10 = new View.OnClickListener() {
                public final void onClick(View view) {
                    int i;
                    int i2 = 0;
                    AppMethodBeat.i(127121);
                    for (i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (R.id.bn0 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                    int intValue = ((Integer) g.RP().Ry().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    ab.d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue2));
                    if ((intValue2 == 0 ? 1 : 0) == ((intValue & 16777216) == 0 ? 1 : 0)) {
                        AppMethodBeat.o(127121);
                        return;
                    }
                    if (intValue2 == 0) {
                        i2 = 1;
                    }
                    if (i2 != 0) {
                        i = -16777217 & intValue;
                    } else {
                        i = intValue | 16777216;
                    }
                    int i3 = i2 == 0 ? 1 : 2;
                    g.RP().Ry().set(7, Integer.valueOf(i));
                    act act = new act();
                    act.wkw = 35;
                    act.pvD = i3;
                    ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
                    com.tencent.mm.plugin.setting.b.gkF.BS();
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127120);
                            ((Dialog) linearLayout.getTag()).dismiss();
                            SettingsAboutSystemUI.e(SettingsAboutSystemUI.this);
                            AppMethodBeat.o(127120);
                        }
                    });
                    AppMethodBeat.o(127121);
                }
            };
            z3 = (((Integer) g.RP().Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            a(linearLayout, R.string.eao, 0, z3, anonymousClass10);
            if (z3) {
                z3 = false;
            } else {
                z3 = true;
            }
            a(linearLayout, R.string.ean, 1, z3, anonymousClass10);
            aVar.fn(inflate2);
            aMb = aVar.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            addDialog(aMb);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.mController.ylL, SettingsLanguageUI.class));
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_text_size")) {
            ciF = ciF();
            AppMethodBeat.o(127126);
            return ciF;
        } else if (str.equals("settings_chatting_bg")) {
            intent = new Intent();
            intent.setClass(this, SettingsChattingBackgroundUI.class);
            this.mController.ylL.startActivity(intent);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_manage_findmoreui")) {
            intent = new Intent();
            intent.setClass(this, SettingsManageFindMoreUI.class);
            startActivity(intent);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_plugins")) {
            g.RP().Ry().set(-2046825377, Boolean.FALSE);
            intent = new Intent();
            intent.setClass(this, SettingsPluginsUI.class);
            startActivity(intent);
            c.PK().bZ(262158, 266266);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_reset")) {
            com.tencent.mm.ui.base.h.d(this.mController.ylL, getResources().getString(R.string.e_y), "", getString(R.string.ou), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    int i2 = 0;
                    AppMethodBeat.i(127116);
                    SettingsAboutSystemUI.this.isDeleteCancel = false;
                    SettingsAboutSystemUI settingsAboutSystemUI = SettingsAboutSystemUI.this;
                    Context context = SettingsAboutSystemUI.this;
                    SettingsAboutSystemUI.this.getString(R.string.tz);
                    settingsAboutSystemUI.qlZ = com.tencent.mm.ui.base.h.b(context, SettingsAboutSystemUI.this.getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(127113);
                            SettingsAboutSystemUI.this.isDeleteCancel = true;
                            AppMethodBeat.o(127113);
                        }
                    });
                    List dsO = ((j) g.K(j.class)).XR().dsO();
                    if (dsO.size() > 0) {
                        List S = m.S(dsO);
                        if (S != null) {
                            while (i2 < S.size()) {
                                if (((Boolean) S.get(i2)).booleanValue()) {
                                    com.tencent.mm.plugin.setting.b.gkF.dl((String) dsO.get(i2));
                                }
                                i2++;
                            }
                        }
                    }
                    bf.a(new bf.a() {
                        public final boolean JU() {
                            AppMethodBeat.i(127114);
                            boolean b = SettingsAboutSystemUI.this.isDeleteCancel;
                            AppMethodBeat.o(127114);
                            return b;
                        }

                        public final void JV() {
                            AppMethodBeat.i(127115);
                            if (SettingsAboutSystemUI.this.qlZ != null) {
                                SettingsAboutSystemUI.this.qlZ.dismiss();
                                SettingsAboutSystemUI.this.qlZ = null;
                            }
                            AppMethodBeat.o(127115);
                        }
                    });
                    AppMethodBeat.o(127116);
                }
            }, null);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_emoji_manager")) {
            intent = new Intent();
            intent.putExtra("10931", 2);
            com.tencent.mm.bp.d.b(this.mController.ylL, "emoji", ".ui.EmojiMineUI", intent);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settngs_clean")) {
            if (g.RP().isSDCardAvailable()) {
                com.tencent.mm.bp.d.b(this.mController.ylL, "clean", ".ui.CleanUI", new Intent());
                AppMethodBeat.o(127126);
                return true;
            }
            t.hO(this.mController.ylL);
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_traffic_statistic")) {
            startActivity(new Intent(this, SettingsNetStatUI.class));
            AppMethodBeat.o(127126);
            return true;
        } else if (str.equals("settings_text_size")) {
            ciF = ciF();
            AppMethodBeat.o(127126);
            return ciF;
        } else if (str.equals("settings_swipeback_mode")) {
            final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
            booleanValue = b.Ml();
            if (booleanValue) {
                intValue = R.string.eb9;
            } else {
                intValue = R.string.eb_;
            }
            com.tencent.mm.ui.base.h.a(this.mController.ylL, getString(intValue), null, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127111);
                    b.bK(!b.Ml());
                    g.RQ().releaseAll();
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127110);
                            Process.killProcess(Process.myPid());
                            AppMethodBeat.o(127110);
                        }
                    });
                    AppMethodBeat.o(127111);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127112);
                    checkBoxPreference2.uOT = booleanValue;
                    SettingsAboutSystemUI.this.ehK.notifyDataSetChanged();
                    AppMethodBeat.o(127112);
                }
            });
            AppMethodBeat.o(127126);
            return true;
        } else {
            if (str.equals("settings_take_photo")) {
                startActivity(new Intent(this, SettingsAboutCamera.class));
            }
            AppMethodBeat.o(127126);
            return false;
        }
    }

    private void a(LinearLayout linearLayout, int i, int i2, boolean z, View.OnClickListener onClickListener) {
        AppMethodBeat.i(127132);
        TextView textView = (TextView) View.inflate(this.mController.ylL, R.layout.aml, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
        }
        AppMethodBeat.o(127132);
    }
}
