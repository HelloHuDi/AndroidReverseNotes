package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p230g.p231a.C45360qp;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.C40675h;
import com.tencent.p177mm.p612ui.base.preference.C41341a;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.game.p1268a.C43155a;
import com.tencent.p177mm.plugin.game.p1268a.C43155a.C20928a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C40193m;
import com.tencent.p177mm.plugin.welab.p1072a.p1073a.C23167a;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f;
import com.tencent.p177mm.pluginsdk.p1079f.C44044f.C14834b;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI */
public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> gsc = new HashMap();
    private long kFU;
    private HashMap<Integer, Integer> qnC = new HashMap();
    private HashMap<Integer, Integer> qnD = new HashMap();
    private int qnE;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI$3 */
    class C38023 implements OnMenuItemClickListener {
        C38023() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127270);
            SettingsManageFindMoreUI.this.finish();
            AppMethodBeat.m2505o(127270);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public SettingsManageFindMoreUI() {
        AppMethodBeat.m2504i(127271);
        AppMethodBeat.m2505o(127271);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127272);
        super.onCreate(bundle);
        this.kFU = C1853r.m3823YE();
        this.qnE = C1853r.m3829YK();
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", Long.valueOf(this.kFU), Integer.valueOf(this.qnE));
        initView();
        AppMethodBeat.m2505o(127272);
    }

    /* renamed from: a */
    public final C40675h mo14627a(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(127273);
        C41341a c41341a = new C41341a(this, this.nDp, sharedPreferences);
        AppMethodBeat.m2505o(127273);
        return c41341a;
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8550by;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        int i = false;
        AppMethodBeat.m2504i(127274);
        if (preference instanceof CheckBoxPreference) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            String str = preference.mKey;
            C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", str);
            int i2 = -1;
            if (str.equals("settings_sns_switch")) {
                m57269B(checkBoxPreference.isChecked(), 32768);
                i2 = 0;
            } else if (str.equals("settings_scan_switch")) {
                m57273f(checkBoxPreference.isChecked(), 1048576, 49);
                i2 = 1;
            } else if (str.equals("settings_search_switch")) {
                if (checkBoxPreference.isChecked()) {
                    m57273f(checkBoxPreference.isChecked(), 2097152, 50);
                    i2 = 3;
                } else {
                    if (((C40193m) C1720g.m3528K(C40193m.class)).mo63532b(this, new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(127269);
                            checkBoxPreference.uOT = false;
                            SettingsManageFindMoreUI.m57272a(SettingsManageFindMoreUI.this, checkBoxPreference.isChecked());
                            AppMethodBeat.m2505o(127269);
                        }
                    })) {
                        C5004al.m7442n(new Runnable() {
                            public final void run() {
                                checkBoxPreference.uOT = true;
                            }
                        }, 500);
                    }
                    i2 = 3;
                }
            } else if (str.equals("settings_shopping_switch")) {
                i2 = 6;
                m57273f(checkBoxPreference.isChecked(), 4194304, 51);
            } else if (str.equals("settings_game_switch")) {
                m57273f(checkBoxPreference.isChecked(), 8388608, 52);
                C7060h.pYm.mo8378a(848, checkBoxPreference.isChecked() ? 0 : 1, 1, false);
                i2 = 7;
            } else if (str.equals("settings_miniprogram_switch")) {
                i2 = 8;
                m57273f(checkBoxPreference.isChecked(), 16777216, 53);
            } else if (str.equals("settings_wechatout_switch")) {
                i2 = 9;
                m57273f(checkBoxPreference.isChecked(), 33554432, 54);
            } else if (str.equals("settings_shake_switch")) {
                i2 = 2;
                m57269B(checkBoxPreference.isChecked(), 256);
            } else if (str.equals("settings_nearby_switch")) {
                i2 = 4;
                m57269B(checkBoxPreference.isChecked(), 512);
            } else if (str.equals("settings_look_switch")) {
                ((C23167a) C1720g.m3528K(C23167a.class)).mo38784bK("labs_browse", checkBoxPreference.isChecked());
                if (checkBoxPreference.isChecked()) {
                    this.kFU &= -67108865;
                    i2 = 10;
                } else {
                    this.kFU |= 67108864;
                    i2 = 10;
                }
            }
            if (checkBoxPreference.isChecked()) {
                i = 1;
            }
            if (i2 >= 0) {
                this.qnD.put(Integer.valueOf(i2), Integer.valueOf(i));
            }
            AppMethodBeat.m2505o(127274);
        } else {
            AppMethodBeat.m2505o(127274);
        }
        return true;
    }

    public final void initView() {
        boolean z;
        boolean z2;
        String value;
        String cDA;
        AppMethodBeat.m2504i(127275);
        setMMTitle((int) C25738R.string.e85);
        setBackBtn(new C38023());
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_sns_switch");
        checkBoxPreference.yDf = false;
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", Boolean.valueOf(m57271Co(32768)));
        if (m57271Co(32768)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(0), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(0), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_scan_switch");
        checkBoxPreference.yDf = false;
        if (m57270Cn(1048576)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(1), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(1), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_shake_switch");
        checkBoxPreference.yDf = false;
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", Boolean.valueOf(m57271Co(256)));
        if (m57271Co(256)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(2), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(2), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_look_switch");
        checkBoxPreference.yDf = false;
        if (m57270Cn(67108864)) {
            z = false;
        } else {
            z = true;
        }
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            this.yCw.mo27715ce("settings_look_switch", true);
            C4990ab.m7416i("MicroMsg.SettingsManageFindMoreUI", "european user");
            z2 = false;
            z = false;
        } else {
            z2 = true;
        }
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        if (z2 && z) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(10), Integer.valueOf(1));
        } else if (z2) {
            this.yCw.mo27715ce("settings_look_switch", false);
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(10), Integer.valueOf(0));
        } else {
            this.yCw.mo27715ce("settings_look_switch", true);
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_search_switch");
        checkBoxPreference.yDf = false;
        if (m57270Cn(2097152)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(3), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(3), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_nearby_switch");
        checkBoxPreference.yDf = false;
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", Boolean.valueOf(m57271Co(512)));
        if (m57271Co(512)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(4), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(4), Integer.valueOf(0));
        }
        if (C4988aa.doo()) {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigName");
        } else if (C4988aa.dop()) {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = C26373g.m41964Nu().getValue("JDEntranceConfigNameEN");
        }
        String value2 = C26373g.m41964Nu().getValue("JDEntranceConfigIconUrl");
        C14834b c14834b = C44044f.vdy;
        if (c14834b != null) {
            cDA = c14834b.cDA();
        } else {
            cDA = null;
        }
        if (C5046bo.m7510Q(value, value2, cDA)) {
            z2 = false;
        } else {
            z2 = true;
        }
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", Boolean.valueOf(z2));
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_shopping_switch");
        checkBoxPreference.yDf = false;
        if (z2) {
            this.yCw.mo27715ce("settings_shopping_switch", false);
        } else {
            this.yCw.mo27715ce("settings_shopping_switch", true);
        }
        if (m57270Cn(4194304)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(6), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(6), Integer.valueOf(1));
        }
        C43155a bDb = C20928a.bDb();
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_game_switch");
        checkBoxPreference.yDf = false;
        if (bDb == null || !bDb.bCS()) {
            this.yCw.mo27715ce("settings_game_switch", true);
        } else if (m57270Cn(8388608)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(7), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(7), Integer.valueOf(1));
        }
        C45360qp c45360qp = new C45360qp();
        c45360qp.cMH.cMJ = true;
        C4879a.xxA.mo10055m(c45360qp);
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", Boolean.valueOf(c45360qp.cMI.cMK));
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_miniprogram_switch");
        checkBoxPreference.yDf = false;
        if (!c45360qp.cMI.cMK) {
            this.yCw.mo27715ce("settings_miniprogram_switch", true);
        } else if (m57270Cn(16777216)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(8), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(8), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_wechatout_switch");
        if (C26373g.m41964Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", Boolean.valueOf(z2));
        if (z2) {
            checkBoxPreference.yDf = false;
            if (m57270Cn(33554432)) {
                checkBoxPreference.uOT = false;
                this.qnC.put(Integer.valueOf(9), Integer.valueOf(0));
            } else {
                checkBoxPreference.uOT = true;
                this.qnC.put(Integer.valueOf(9), Integer.valueOf(1));
            }
        } else {
            this.yCw.mo27715ce("settings_wechatout_switch", true);
        }
        Preference aqO = this.yCw.aqO("settings_switch_bottom_tip");
        if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
            aqO.setTitle((int) C25738R.string.e89);
        }
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.m2505o(127275);
    }

    /* renamed from: f */
    private void m57273f(boolean z, int i, int i2) {
        AppMethodBeat.m2504i(127276);
        C4990ab.m7416i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.kFU &= (long) (i ^ -1);
        } else {
            this.kFU |= (long) i;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.m2505o(127276);
    }

    public void finish() {
        AppMethodBeat.m2504i(127277);
        super.finish();
        C4990ab.m7416i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.kFU + ",pluginFlag:" + this.qnE);
        C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(this.kFU));
        C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(this.qnE));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
            C4990ab.m7410d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", this.qnE, "", ""));
        bHT();
        AppMethodBeat.m2505o(127277);
    }

    /* renamed from: Cn */
    private boolean m57270Cn(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    /* renamed from: Co */
    private boolean m57271Co(int i) {
        return (this.qnE & i) == 0;
    }

    /* renamed from: B */
    private void m57269B(boolean z, int i) {
        AppMethodBeat.m2504i(127278);
        C4990ab.m7417i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            this.qnE &= i ^ -1;
            AppMethodBeat.m2505o(127278);
            return;
        }
        this.qnE |= i;
        AppMethodBeat.m2505o(127278);
    }

    private void bHT() {
        AppMethodBeat.m2504i(127279);
        for (Integer intValue : this.qnD.keySet()) {
            int intValue2 = intValue.intValue();
            if (this.qnC.containsKey(Integer.valueOf(intValue2)) && this.qnC.get(Integer.valueOf(intValue2)) != this.qnD.get(Integer.valueOf(intValue2))) {
                C7060h.pYm.mo8381e(15185, Integer.valueOf(intValue2), this.qnD.get(Integer.valueOf(intValue2)));
                if (intValue2 == 0) {
                    if (((Integer) this.qnD.get(Integer.valueOf(intValue2))).intValue() == 0) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_ENTRY_SWITCH_INT, Integer.valueOf(-1));
                    } else if (((Integer) this.qnD.get(Integer.valueOf(intValue2))).intValue() == 1) {
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SNS_ENTRY_SWITCH_INT, Integer.valueOf(1));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(127279);
    }
}
