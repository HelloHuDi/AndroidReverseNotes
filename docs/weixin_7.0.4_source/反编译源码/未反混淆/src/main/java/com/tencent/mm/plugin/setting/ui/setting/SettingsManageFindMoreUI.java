package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.au.b;
import com.tencent.mm.az.k;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.websearch.api.m;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> gsc = new HashMap();
    private long kFU;
    private HashMap<Integer, Integer> qnC = new HashMap();
    private HashMap<Integer, Integer> qnD = new HashMap();
    private int qnE;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsManageFindMoreUI() {
        AppMethodBeat.i(127271);
        AppMethodBeat.o(127271);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127272);
        super.onCreate(bundle);
        this.kFU = r.YE();
        this.qnE = r.YK();
        ab.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", Long.valueOf(this.kFU), Integer.valueOf(this.qnE));
        initView();
        AppMethodBeat.o(127272);
    }

    public final h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(127273);
        a aVar = new a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(127273);
        return aVar;
    }

    public final int JC() {
        return R.xml.by;
    }

    public final boolean a(f fVar, Preference preference) {
        int i = false;
        AppMethodBeat.i(127274);
        if (preference instanceof CheckBoxPreference) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            String str = preference.mKey;
            ab.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", str);
            int i2 = -1;
            if (str.equals("settings_sns_switch")) {
                B(checkBoxPreference.isChecked(), 32768);
                i2 = 0;
            } else if (str.equals("settings_scan_switch")) {
                f(checkBoxPreference.isChecked(), 1048576, 49);
                i2 = 1;
            } else if (str.equals("settings_search_switch")) {
                if (checkBoxPreference.isChecked()) {
                    f(checkBoxPreference.isChecked(), 2097152, 50);
                    i2 = 3;
                } else {
                    if (((m) g.K(m.class)).b(this, new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(127269);
                            checkBoxPreference.uOT = false;
                            SettingsManageFindMoreUI.a(SettingsManageFindMoreUI.this, checkBoxPreference.isChecked());
                            AppMethodBeat.o(127269);
                        }
                    })) {
                        al.n(new Runnable() {
                            public final void run() {
                                checkBoxPreference.uOT = true;
                            }
                        }, 500);
                    }
                    i2 = 3;
                }
            } else if (str.equals("settings_shopping_switch")) {
                i2 = 6;
                f(checkBoxPreference.isChecked(), 4194304, 51);
            } else if (str.equals("settings_game_switch")) {
                f(checkBoxPreference.isChecked(), 8388608, 52);
                com.tencent.mm.plugin.report.service.h.pYm.a(848, checkBoxPreference.isChecked() ? 0 : 1, 1, false);
                i2 = 7;
            } else if (str.equals("settings_miniprogram_switch")) {
                i2 = 8;
                f(checkBoxPreference.isChecked(), 16777216, 53);
            } else if (str.equals("settings_wechatout_switch")) {
                i2 = 9;
                f(checkBoxPreference.isChecked(), 33554432, 54);
            } else if (str.equals("settings_shake_switch")) {
                i2 = 2;
                B(checkBoxPreference.isChecked(), 256);
            } else if (str.equals("settings_nearby_switch")) {
                i2 = 4;
                B(checkBoxPreference.isChecked(), 512);
            } else if (str.equals("settings_look_switch")) {
                ((com.tencent.mm.plugin.welab.a.a.a) g.K(com.tencent.mm.plugin.welab.a.a.a.class)).bK("labs_browse", checkBoxPreference.isChecked());
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
            AppMethodBeat.o(127274);
        } else {
            AppMethodBeat.o(127274);
        }
        return true;
    }

    public final void initView() {
        boolean z;
        boolean z2;
        String value;
        String cDA;
        AppMethodBeat.i(127275);
        setMMTitle((int) R.string.e85);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127270);
                SettingsManageFindMoreUI.this.finish();
                AppMethodBeat.o(127270);
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_sns_switch");
        checkBoxPreference.yDf = false;
        ab.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", Boolean.valueOf(Co(32768)));
        if (Co(32768)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(0), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(0), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_scan_switch");
        checkBoxPreference.yDf = false;
        if (Cn(1048576)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(1), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(1), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_shake_switch");
        checkBoxPreference.yDf = false;
        ab.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", Boolean.valueOf(Co(256)));
        if (Co(256)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(2), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(2), Integer.valueOf(0));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_look_switch");
        checkBoxPreference.yDf = false;
        if (Cn(67108864)) {
            z = false;
        } else {
            z = true;
        }
        if (b.sO((String) g.RP().Ry().get(274436, null))) {
            this.yCw.ce("settings_look_switch", true);
            ab.i("MicroMsg.SettingsManageFindMoreUI", "european user");
            z2 = false;
            z = false;
        } else {
            z2 = true;
        }
        ab.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s", Boolean.valueOf(z2), Boolean.valueOf(z));
        if (z2 && z) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(10), Integer.valueOf(1));
        } else if (z2) {
            this.yCw.ce("settings_look_switch", false);
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(10), Integer.valueOf(0));
        } else {
            this.yCw.ce("settings_look_switch", true);
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_search_switch");
        checkBoxPreference.yDf = false;
        if (Cn(2097152)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(3), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(3), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_nearby_switch");
        checkBoxPreference.yDf = false;
        ab.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", Boolean.valueOf(Co(512)));
        if (Co(512)) {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(4), Integer.valueOf(1));
        } else {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(4), Integer.valueOf(0));
        }
        if (aa.doo()) {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigName");
        } else if (aa.dop()) {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigNameHKTW");
        } else {
            value = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigNameEN");
        }
        String value2 = com.tencent.mm.m.g.Nu().getValue("JDEntranceConfigIconUrl");
        com.tencent.mm.pluginsdk.f.f.b bVar = com.tencent.mm.pluginsdk.f.f.vdy;
        if (bVar != null) {
            cDA = bVar.cDA();
        } else {
            cDA = null;
        }
        if (bo.Q(value, value2, cDA)) {
            z2 = false;
        } else {
            z2 = true;
        }
        ab.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", Boolean.valueOf(z2));
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_shopping_switch");
        checkBoxPreference.yDf = false;
        if (z2) {
            this.yCw.ce("settings_shopping_switch", false);
        } else {
            this.yCw.ce("settings_shopping_switch", true);
        }
        if (Cn(4194304)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(6), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(6), Integer.valueOf(1));
        }
        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_game_switch");
        checkBoxPreference.yDf = false;
        if (bDb == null || !bDb.bCS()) {
            this.yCw.ce("settings_game_switch", true);
        } else if (Cn(8388608)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(7), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(7), Integer.valueOf(1));
        }
        qp qpVar = new qp();
        qpVar.cMH.cMJ = true;
        com.tencent.mm.sdk.b.a.xxA.m(qpVar);
        ab.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s", Boolean.valueOf(qpVar.cMI.cMK));
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_miniprogram_switch");
        checkBoxPreference.yDf = false;
        if (!qpVar.cMI.cMK) {
            this.yCw.ce("settings_miniprogram_switch", true);
        } else if (Cn(16777216)) {
            checkBoxPreference.uOT = false;
            this.qnC.put(Integer.valueOf(8), Integer.valueOf(0));
        } else {
            checkBoxPreference.uOT = true;
            this.qnC.put(Integer.valueOf(8), Integer.valueOf(1));
        }
        checkBoxPreference = (CheckBoxPreference) this.yCw.aqO("settings_wechatout_switch");
        if (com.tencent.mm.m.g.Nu().getInt("WCOEntranceSwitch", 0) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        ab.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", Boolean.valueOf(z2));
        if (z2) {
            checkBoxPreference.yDf = false;
            if (Cn(33554432)) {
                checkBoxPreference.uOT = false;
                this.qnC.put(Integer.valueOf(9), Integer.valueOf(0));
            } else {
                checkBoxPreference.uOT = true;
                this.qnC.put(Integer.valueOf(9), Integer.valueOf(1));
            }
        } else {
            this.yCw.ce("settings_wechatout_switch", true);
        }
        Preference aqO = this.yCw.aqO("settings_switch_bottom_tip");
        if (b.sO((String) g.RP().Ry().get(274436, null))) {
            aqO.setTitle((int) R.string.e89);
        }
        this.yCw.notifyDataSetChanged();
        AppMethodBeat.o(127275);
    }

    private void f(boolean z, int i, int i2) {
        AppMethodBeat.i(127276);
        ab.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.kFU &= (long) (i ^ -1);
        } else {
            this.kFU |= (long) i;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(127276);
    }

    public void finish() {
        AppMethodBeat.i(127277);
        super.finish();
        ab.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.kFU + ",pluginFlag:" + this.qnE);
        g.RP().Ry().set(147457, Long.valueOf(this.kFU));
        g.RP().Ry().set(34, Integer.valueOf(this.qnE));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            ab.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        ((j) g.K(j.class)).XL().c(new k("", "", "", "", "", "", "", "", this.qnE, "", ""));
        bHT();
        AppMethodBeat.o(127277);
    }

    private boolean Cn(int i) {
        return (this.kFU & ((long) i)) != 0;
    }

    private boolean Co(int i) {
        return (this.qnE & i) == 0;
    }

    private void B(boolean z, int i) {
        AppMethodBeat.i(127278);
        ab.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", Boolean.valueOf(z), Integer.valueOf(i));
        if (z) {
            this.qnE &= i ^ -1;
            AppMethodBeat.o(127278);
            return;
        }
        this.qnE |= i;
        AppMethodBeat.o(127278);
    }

    private void bHT() {
        AppMethodBeat.i(127279);
        for (Integer intValue : this.qnD.keySet()) {
            int intValue2 = intValue.intValue();
            if (this.qnC.containsKey(Integer.valueOf(intValue2)) && this.qnC.get(Integer.valueOf(intValue2)) != this.qnD.get(Integer.valueOf(intValue2))) {
                com.tencent.mm.plugin.report.service.h.pYm.e(15185, Integer.valueOf(intValue2), this.qnD.get(Integer.valueOf(intValue2)));
                if (intValue2 == 0) {
                    if (((Integer) this.qnD.get(Integer.valueOf(intValue2))).intValue() == 0) {
                        g.RP().Ry().set(ac.a.USERINFO_SNS_ENTRY_SWITCH_INT, Integer.valueOf(-1));
                    } else if (((Integer) this.qnD.get(Integer.valueOf(intValue2))).intValue() == 1) {
                        g.RP().Ry().set(ac.a.USERINFO_SNS_ENTRY_SWITCH_INT, Integer.valueOf(1));
                    }
                }
            }
        }
        AppMethodBeat.o(127279);
    }
}
