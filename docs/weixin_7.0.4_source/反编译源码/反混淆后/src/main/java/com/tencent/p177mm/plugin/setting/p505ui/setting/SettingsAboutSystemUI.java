package com.tencent.p177mm.plugin.setting.p505ui.setting;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p223i.C1436b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C32794m;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p199ax.C1301c;
import com.tencent.p177mm.p199ax.C32321b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.IconPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.p1140r.C16841a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI */
public class SettingsAboutSystemUI extends MMPreference {
    private C15541f ehK;
    private boolean isDeleteCancel = false;
    private ProgressDialog qlZ = null;
    private boolean qmh = false;
    private int qmi = -1;
    private int qmj = -1;
    private boolean qmk = false;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$7 */
    class C37867 implements OnClickListener {
        C37867() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127118);
            C4990ab.m7416i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user cancel go set system nfc switch");
            AppMethodBeat.m2505o(127118);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$9 */
    class C37879 implements OnClickListener {
        C37879() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127119);
            SettingsAboutSystemUI.this.ehZ.edit().putBoolean("settings_voicerecorder_mode", true).commit();
            ((CheckBoxPreference) SettingsAboutSystemUI.this.ehK.aqO("settings_voicerecorder_mode")).uOT = true;
            SettingsAboutSystemUI.this.ehK.notifyDataSetChanged();
            AppMethodBeat.m2505o(127119);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$6 */
    class C37886 implements OnClickListener {
        C37886() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127117);
            C4990ab.m7416i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch user go set system nfc switch");
            SettingsAboutSystemUI.this.qmh = true;
            SettingsAboutSystemUI.this.startActivity(new Intent("android.settings.NFC_SETTINGS"));
            AppMethodBeat.m2505o(127117);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$8 */
    class C37898 implements OnClickListener {
        C37898() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$5 */
    class C37935 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$5$2 */
        class C37942 implements C1827a {
            C37942() {
            }

            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(127114);
                boolean b = SettingsAboutSystemUI.this.isDeleteCancel;
                AppMethodBeat.m2505o(127114);
                return b;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(127115);
                if (SettingsAboutSystemUI.this.qlZ != null) {
                    SettingsAboutSystemUI.this.qlZ.dismiss();
                    SettingsAboutSystemUI.this.qlZ = null;
                }
                AppMethodBeat.m2505o(127115);
            }
        }

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$5$1 */
        class C37951 implements OnCancelListener {
            C37951() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(127113);
                SettingsAboutSystemUI.this.isDeleteCancel = true;
                AppMethodBeat.m2505o(127113);
            }
        }

        C37935() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(127116);
            SettingsAboutSystemUI.this.isDeleteCancel = false;
            SettingsAboutSystemUI settingsAboutSystemUI = SettingsAboutSystemUI.this;
            Context context = SettingsAboutSystemUI.this;
            SettingsAboutSystemUI.this.getString(C25738R.string.f9238tz);
            settingsAboutSystemUI.qlZ = C30379h.m48458b(context, SettingsAboutSystemUI.this.getString(C25738R.string.f9260un), true, new C37951());
            List dsO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().dsO();
            if (dsO.size() > 0) {
                List S = C32794m.m53571S(dsO);
                if (S != null) {
                    while (i2 < S.size()) {
                        if (((Boolean) S.get(i2)).booleanValue()) {
                            C24824b.gkF.mo38867dl((String) dsO.get(i2));
                        }
                        i2++;
                    }
                }
            }
            C1829bf.m3742a(new C37942());
            AppMethodBeat.m2505o(127116);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$1 */
    class C37961 implements OnMenuItemClickListener {
        C37961() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127107);
            SettingsAboutSystemUI.this.aqX();
            SettingsAboutSystemUI.this.finish();
            AppMethodBeat.m2505o(127107);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$3 */
    class C37973 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$3$1 */
        class C37981 implements Runnable {
            C37981() {
            }

            public final void run() {
                AppMethodBeat.m2504i(127110);
                Process.killProcess(Process.myPid());
                AppMethodBeat.m2505o(127110);
            }
        }

        C37973() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(127111);
            C1436b.m3062bK(!C1436b.m3061Ml());
            C1720g.m3537RQ().releaseAll();
            C5004al.m7441d(new C37981());
            AppMethodBeat.m2505o(127111);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: e */
    static /* synthetic */ void m6102e(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.m2504i(127134);
        settingsAboutSystemUI.ciG();
        AppMethodBeat.m2505o(127134);
    }

    /* renamed from: f */
    static /* synthetic */ void m6103f(SettingsAboutSystemUI settingsAboutSystemUI) {
        AppMethodBeat.m2504i(127135);
        settingsAboutSystemUI.ciH();
        AppMethodBeat.m2505o(127135);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8559c8;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127122);
        super.onCreate(bundle);
        this.qmh = false;
        initView();
        AppMethodBeat.m2505o(127122);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127123);
        setMMTitle((int) C25738R.string.e5b);
        this.ehK = this.yCw;
        setBackBtn(new C37961());
        this.ehK.mo27715ce("settings_swipeback_mode", !C1443d.m3068iW(19));
        if (!C25985d.afj("backup")) {
            this.ehK.mo27715ce("settings_bak_chat", true);
        }
        ciE();
        this.ehK.mo27715ce("settings_traffic_statistic", C25985d.dlL());
        if (C1947ae.gjt) {
            this.ehK.mo27715ce("settings_take_photo", true);
        }
        AppMethodBeat.m2505o(127123);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127124);
        super.onResume();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_voice_play_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(26, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(66832, Boolean.FALSE)).booleanValue();
            checkBoxPreference.yDf = false;
        }
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_swipeback_mode");
        if (checkBoxPreference != null) {
            checkBoxPreference.uOT = C1436b.m3061Ml();
            checkBoxPreference.yDf = false;
        }
        Preference aqO = this.ehK.aqO("settings_language");
        if (aqO != null) {
            aqO.setSummary(C4988aa.m7404gx(this.mController.ylL));
        }
        ciE();
        ciH();
        ciH();
        ciG();
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_nfc_switch");
        if (defaultAdapter == null) {
            this.ehK.mo27715ce("settings_nfc_switch", true);
            AppMethodBeat.m2505o(127124);
            return;
        }
        this.ehK.mo27715ce("settings_nfc_switch", false);
        checkBoxPreference.setSummary((CharSequence) C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_OPEN_SWITCH_WORDING_STRING_SYNC, null)));
        if (this.qmh) {
            C4990ab.m7416i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-updateNfcOpenSwitch go setSystemNfc and back");
            if (defaultAdapter.isEnabled()) {
                m6104jC(true);
                m6105kp(true);
                AppMethodBeat.m2505o(127124);
                return;
            }
        }
        int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
        if (intValue == 0) {
            if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
                m6105kp(true);
            } else {
                m6105kp(false);
            }
        } else if (intValue == 1) {
            m6105kp(true);
        } else {
            m6105kp(false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127124);
    }

    public void onDestroy() {
        boolean z = true;
        AppMethodBeat.m2504i(127125);
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
            C4990ab.m7417i(str, str2, objArr);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr2 = new Object[3];
            objArr2[0] = Integer.valueOf(1);
            objArr2[1] = Integer.valueOf(this.qmj);
            if (this.qmi != this.qmj) {
                z = false;
            }
            objArr2[2] = Boolean.valueOf(z);
            c7060h.mo8381e(11437, objArr2);
        }
        AppMethodBeat.m2505o(127125);
    }

    private void ciE() {
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(127127);
        IconPreference iconPreference = (IconPreference) this.ehK.aqO("settings_plugins");
        if (C5046bo.m7517a((Boolean) C1720g.m3536RP().mo5239Ry().get(-2046825377, null), false)) {
            iconPreference.mo48763NL(0);
            iconPreference.mo48774ey(getString(C25738R.string.f9181s0), C25738R.drawable.f6940w3);
        } else {
            iconPreference.mo48763NL(8);
            iconPreference.mo48774ey("", -1);
        }
        if (C16112c.m24429PK().mo28552bY(262158, 266266)) {
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
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127127);
    }

    private boolean ciF() {
        AppMethodBeat.m2504i(127128);
        startActivity(new Intent(this, SettingsFontUI.class));
        AppMethodBeat.m2505o(127128);
        return true;
    }

    /* renamed from: jC */
    private void m6104jC(boolean z) {
        AppMethodBeat.m2504i(127129);
        if (z) {
            getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 1, 1);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(1));
            AppMethodBeat.m2505o(127129);
            return;
        }
        getPackageManager().setComponentEnabledSetting(new ComponentName(C4996ah.getPackageName(), "com.tencent.mm.plugin.nfc_open.ui.NfcWebViewUI"), 2, 1);
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(2));
        AppMethodBeat.m2505o(127129);
    }

    /* renamed from: kp */
    private void m6105kp(boolean z) {
        AppMethodBeat.m2504i(127130);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_nfc_switch");
        C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0).edit().putBoolean("settings_nfc_switch", z).commit();
        checkBoxPreference.uOT = z;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127130);
    }

    private void ciG() {
        boolean z = true;
        AppMethodBeat.m2504i(127131);
        boolean z2 = C5046bo.ank(C26373g.m41964Nu().getValue("SilentDownloadApkAtWiFi")) != 0;
        if ((C5059g.cdh & 1) != 0) {
            C4990ab.m7410d("MicroMsg.SettingsAboutSystemUI", "channel pack, not silence download.");
            z2 = true;
        }
        if (z2) {
            this.ehK.mo27715ce("settings_silence_update_mode", true);
            AppMethodBeat.m2505o(127131);
            return;
        }
        this.ehK.mo27715ce("settings_silence_update_mode", false);
        if ((((Integer) C1720g.m3536RP().mo5239Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) != 0) {
            z = false;
        }
        this.ehK.aqO("settings_silence_update_mode").setSummary(getString(z ? C25738R.string.eao : C25738R.string.ean));
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127131);
    }

    private void ciH() {
        AppMethodBeat.m2504i(127133);
        int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(327686, null), C5046bo.getInt(C26373g.m41964Nu().getValue("SIGHTAutoLoadNetwork"), 1));
        C4990ab.m7417i("MicroMsg.SettingsAboutSystemUI", "auto getSightViewSummary %d, %d", Integer.valueOf(r1), Integer.valueOf(a));
        if (this.qmi == -1) {
            this.qmi = a;
        }
        this.qmj = a;
        if (3 == a) {
            a = C25738R.string.eaz;
        } else if (2 == a) {
            a = C25738R.string.eb1;
        } else {
            a = C25738R.string.eay;
        }
        Preference aqO = this.ehK.aqO("settings_sns_sight_auto_download");
        if (aqO != null) {
            aqO.setSummary(getString(a));
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127133);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127126);
        String str = preference.mKey;
        boolean z2;
        int intValue;
        boolean booleanValue;
        C5652a c5652a;
        final LinearLayout linearLayout;
        boolean z3;
        C5653c aMb;
        boolean ciF;
        Intent intent;
        if (str.equals("settings_landscape_mode")) {
            if (this.ehZ.getBoolean("settings_landscape_mode", false)) {
                setRequestedOrientation(-1);
            } else {
                setRequestedOrientation(1);
            }
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_voicerecorder_mode")) {
            if (C1427q.etd.epO == 1) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!this.ehZ.getBoolean("settings_voicerecorder_mode", z2)) {
                C30379h.m48432a(this.mController.ylL, (int) C25738R.string.ed1, (int) C25738R.string.f9238tz, new C37898(), new C37879());
            }
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_nfc_switch")) {
            NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(this);
            if (defaultAdapter == null) {
                C4990ab.m7416i("MicroMsg.SettingsAboutSystemUI", "lo-nfc-goTosetNfcSwitch phone not suppot nfc");
            } else {
                int intValue2 = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_OPEN_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
                intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_NFC_OPEN_DEFAULT_SWITCH_INT_SYNC, Integer.valueOf(0))).intValue();
                if ((intValue2 == 2 || (intValue2 == 0 && intValue != 1)) && !defaultAdapter.isEnabled() && this.ehZ.getBoolean("settings_nfc_switch", false)) {
                    m6105kp(false);
                    C30379h.m48466d(this.mController.ylL, getString(C25738R.string.d6w), "", getString(C25738R.string.d6x), getString(C25738R.string.f9076or), new C37886(), new C37867());
                } else {
                    m6104jC(this.ehZ.getBoolean("settings_nfc_switch", false));
                }
            }
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_voice_play_mode")) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(26, Boolean.FALSE)).booleanValue();
            String str2 = "MicroMsg.SettingsAboutSystemUI";
            String str3 = "set voice mode from %B to %B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(booleanValue);
            objArr[1] = Boolean.valueOf(!booleanValue);
            C4990ab.m7411d(str2, str3, objArr);
            C7580z Ry = C1720g.m3536RP().mo5239Ry();
            if (!booleanValue) {
                z = true;
            }
            Ry.set(26, Boolean.valueOf(z));
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_enter_button_send")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_enter_button_send");
            if (checkBoxPreference != null) {
                C4990ab.m7411d("MicroMsg.SettingsAboutSystemUI", "set enter button send : %s", Boolean.valueOf(checkBoxPreference.isChecked()));
                C1720g.m3536RP().mo5239Ry().set(66832, Boolean.valueOf(z2));
            }
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_sns_sight_auto_download")) {
            c5652a = new C5652a(this.mController.ylL);
            c5652a.mo11454Qd(C25738R.string.f9076or);
            c5652a.mo11446PV(C25738R.string.eb0);
            View inflate = View.inflate(this.mController.ylL, 2130970095, null);
            linearLayout = (LinearLayout) inflate.findViewById(2131825985);
            final int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(327686, null), C5046bo.getInt(C26373g.m41964Nu().getValue("SIGHTAutoLoadNetwork"), 1));
            C37902 c37902 = new View.OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(127109);
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (2131823800 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    C4990ab.m7417i("MicroMsg.SettingsAboutSystemUI", "choice: %d, %d", Integer.valueOf(a), Integer.valueOf(intValue));
                    if (a == intValue) {
                        AppMethodBeat.m2505o(127109);
                        return;
                    }
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(127108);
                            ((Dialog) linearLayout.getTag()).dismiss();
                            C1720g.m3536RP().mo5239Ry().set(327686, Integer.valueOf(intValue));
                            C1720g.m3536RP().mo5239Ry().dsb();
                            SettingsAboutSystemUI.m6103f(SettingsAboutSystemUI.this);
                            AppMethodBeat.m2505o(127108);
                        }
                    });
                    AppMethodBeat.m2505o(127109);
                }
            };
            m6097a(linearLayout, C25738R.string.eay, 1, 1 == a, c37902);
            if (2 == a) {
                z3 = true;
            } else {
                z3 = false;
            }
            m6097a(linearLayout, C25738R.string.eb1, 2, z3, c37902);
            if (3 == a) {
                z3 = true;
            } else {
                z3 = false;
            }
            m6097a(linearLayout, C25738R.string.eaz, 3, z3, c37902);
            c5652a.mo11479fn(inflate);
            aMb = c5652a.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            addDialog(aMb);
            this.qmk = true;
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_silence_update_mode")) {
            c5652a = new C5652a(this.mController.ylL);
            c5652a.mo11454Qd(C25738R.string.f9076or);
            c5652a.mo11446PV(C25738R.string.eam);
            View inflate2 = View.inflate(this.mController.ylL, 2130970095, null);
            linearLayout = (LinearLayout) inflate2.findViewById(2131825985);
            C378410 c378410 = new View.OnClickListener() {

                /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutSystemUI$10$1 */
                class C37851 implements Runnable {
                    C37851() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(127120);
                        ((Dialog) linearLayout.getTag()).dismiss();
                        SettingsAboutSystemUI.m6102e(SettingsAboutSystemUI.this);
                        AppMethodBeat.m2505o(127120);
                    }
                }

                public final void onClick(View view) {
                    int i;
                    int i2 = 0;
                    AppMethodBeat.m2504i(127121);
                    for (i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (2131823800 != textView.getId()) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_off, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
                    int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(7, Integer.valueOf(0))).intValue();
                    int intValue2 = ((Integer) view.getTag()).intValue();
                    C4990ab.m7411d("MicroMsg.SettingsAboutSystemUI", "settings_silence_update_mode choice: %d", Integer.valueOf(intValue2));
                    if ((intValue2 == 0 ? 1 : 0) == ((intValue & 16777216) == 0 ? 1 : 0)) {
                        AppMethodBeat.m2505o(127121);
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
                    C1720g.m3536RP().mo5239Ry().set(7, Integer.valueOf(i));
                    act act = new act();
                    act.wkw = 35;
                    act.pvD = i3;
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
                    C24824b.gkF.mo38844BS();
                    view.post(new C37851());
                    AppMethodBeat.m2505o(127121);
                }
            };
            z3 = (((Integer) C1720g.m3536RP().mo5239Ry().get(7, Integer.valueOf(0))).intValue() & 16777216) == 0;
            m6097a(linearLayout, C25738R.string.eao, 0, z3, c378410);
            if (z3) {
                z3 = false;
            } else {
                z3 = true;
            }
            m6097a(linearLayout, C25738R.string.ean, 1, z3, c378410);
            c5652a.mo11479fn(inflate2);
            aMb = c5652a.aMb();
            linearLayout.setTag(aMb);
            aMb.show();
            addDialog(aMb);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_language")) {
            startActivity(new Intent(this.mController.ylL, SettingsLanguageUI.class));
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_text_size")) {
            ciF = ciF();
            AppMethodBeat.m2505o(127126);
            return ciF;
        } else if (str.equals("settings_chatting_bg")) {
            intent = new Intent();
            intent.setClass(this, SettingsChattingBackgroundUI.class);
            this.mController.ylL.startActivity(intent);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_manage_findmoreui")) {
            intent = new Intent();
            intent.setClass(this, SettingsManageFindMoreUI.class);
            startActivity(intent);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_plugins")) {
            C1720g.m3536RP().mo5239Ry().set(-2046825377, Boolean.FALSE);
            intent = new Intent();
            intent.setClass(this, SettingsPluginsUI.class);
            startActivity(intent);
            C16112c.m24429PK().mo28553bZ(262158, 266266);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_reset")) {
            C30379h.m48466d(this.mController.ylL, getResources().getString(C25738R.string.e_y), "", getString(C25738R.string.f9078ou), getString(C25738R.string.f9076or), new C37935(), null);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_emoji_manager")) {
            intent = new Intent();
            intent.putExtra("10931", 2);
            C25985d.m41467b(this.mController.ylL, "emoji", ".ui.EmojiMineUI", intent);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settngs_clean")) {
            if (C1720g.m3536RP().isSDCardAvailable()) {
                C25985d.m41467b(this.mController.ylL, "clean", ".ui.CleanUI", new Intent());
                AppMethodBeat.m2505o(127126);
                return true;
            }
            C23639t.m36492hO(this.mController.ylL);
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_traffic_statistic")) {
            startActivity(new Intent(this, SettingsNetStatUI.class));
            AppMethodBeat.m2505o(127126);
            return true;
        } else if (str.equals("settings_text_size")) {
            ciF = ciF();
            AppMethodBeat.m2505o(127126);
            return ciF;
        } else if (str.equals("settings_swipeback_mode")) {
            final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
            booleanValue = C1436b.m3061Ml();
            if (booleanValue) {
                intValue = C25738R.string.eb9;
            } else {
                intValue = C25738R.string.eb_;
            }
            C30379h.m48440a(this.mController.ylL, getString(intValue), null, new C37973(), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(127112);
                    checkBoxPreference2.uOT = booleanValue;
                    SettingsAboutSystemUI.this.ehK.notifyDataSetChanged();
                    AppMethodBeat.m2505o(127112);
                }
            });
            AppMethodBeat.m2505o(127126);
            return true;
        } else {
            if (str.equals("settings_take_photo")) {
                startActivity(new Intent(this, SettingsAboutCamera.class));
            }
            AppMethodBeat.m2505o(127126);
            return false;
        }
    }

    /* renamed from: a */
    private void m6097a(LinearLayout linearLayout, int i, int i2, boolean z, View.OnClickListener onClickListener) {
        AppMethodBeat.m2504i(127132);
        TextView textView = (TextView) View.inflate(this.mController.ylL, 2130970442, null);
        textView.setText(i);
        textView.setTag(Integer.valueOf(i2));
        linearLayout.addView(textView);
        textView.setOnClickListener(onClickListener);
        if (z) {
            textView.setCompoundDrawablesWithIntrinsicBounds(C1318a.radio_on, 0, 0, 0);
        }
        AppMethodBeat.m2505o(127132);
    }
}
