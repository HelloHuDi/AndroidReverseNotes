package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.Map.Entry;

public class SettingsAddMeUI extends MMPreference {
    private f ehK;
    private HashMap<Integer, Integer> gsc = new HashMap();
    private long kFU;
    private int qmL;
    private int status;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAddMeUI() {
        AppMethodBeat.i(127169);
        AppMethodBeat.o(127169);
    }

    public final h a(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(127170);
        a aVar = new a(this, this.nDp, sharedPreferences);
        AppMethodBeat.o(127170);
        return aVar;
    }

    public final int JC() {
        return R.xml.bo;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127171);
        super.onCreate(bundle);
        this.ehK = this.yCw;
        this.qmL = r.YF();
        this.status = r.YD();
        this.kFU = r.YE();
        initView();
        AppMethodBeat.o(127171);
    }

    public void onPause() {
        AppMethodBeat.i(127172);
        super.onPause();
        ab.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qmL + ",status:" + this.status + ",extstatus:" + this.kFU);
        g.RP().Ry().set(7, Integer.valueOf(this.status));
        g.RP().Ry().set(40, Integer.valueOf(this.qmL));
        g.RP().Ry().set(147457, Long.valueOf(this.kFU));
        for (Entry entry : this.gsc.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            act act = new act();
            act.wkw = intValue;
            act.pvD = intValue2;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(23, act));
            ab.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.gsc.clear();
        AppMethodBeat.o(127172);
    }

    private void e(boolean z, int i, int i2) {
        AppMethodBeat.i(127174);
        ab.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(127174);
    }

    private void f(boolean z, int i, int i2) {
        AppMethodBeat.i(127175);
        ab.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.kFU |= (long) i;
        } else {
            this.kFU &= (long) (i ^ -1);
        }
        this.gsc.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(127175);
    }

    public final void initView() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(127176);
        setMMTitle((int) R.string.e5m);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127168);
                SettingsAddMeUI.this.aqX();
                SettingsAddMeUI.this.finish();
                AppMethodBeat.o(127168);
                return true;
            }
        });
        ab.d("MicroMsg.SettingsAddMeUI", "plug:" + this.qmL + ",status:" + this.status + ",extstatus:" + this.kFU);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.bo);
        Integer num = (Integer) g.RP().Ry().get(9, null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_QQ");
        checkBoxPreference.yDf = false;
        if (num == null || num.intValue() == 0) {
            this.ehK.d(checkBoxPreference);
        } else {
            if (Be(8) && Be(16)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        String str = (String) g.RP().Ry().get(6, null);
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_mobile");
        checkBoxPreference.yDf = false;
        if (str == null || str.length() <= 0) {
            this.ehK.d(checkBoxPreference);
        } else {
            if (Be(512)) {
                z = false;
            } else {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_weixin");
        checkBoxPreference2.yDf = false;
        if ((this.qmL & 512) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_find_me_by_google");
        if (Be(SQLiteGlobal.journalSizeLimit)) {
            z2 = false;
        } else {
            z2 = true;
        }
        checkBoxPreference2.uOT = z2;
        checkBoxPreference2.yDf = false;
        String str2 = (String) g.RP().Ry().get(208903, null);
        if (!bo.gT(this) || TextUtils.isEmpty(str2)) {
            this.ehK.d(checkBoxPreference2);
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_chatroom");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 1) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_qrcode");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 2) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        checkBoxPreference2 = (CheckBoxPreference) this.ehK.aqO("settings_add_me_by_namecard");
        checkBoxPreference2.yDf = false;
        if ((this.kFU & 4) != 0) {
            checkBoxPreference2.uOT = false;
        } else {
            checkBoxPreference2.uOT = true;
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127176);
    }

    private boolean Be(int i) {
        return (this.status & i) != 0;
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127173);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.aqO("settings_find_me_by_QQ")).isChecked();
            e(z2, 8, 2);
            e(z2, 16, 3);
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            int i;
            if (!((CheckBoxPreference) fVar.aqO("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            ab.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.qmL |= 512;
            } else {
                this.qmL &= -513;
            }
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            this.gsc.put(Integer.valueOf(25), Integer.valueOf(i));
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.aqO("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            e(z, 512, 8);
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.aqO("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            e(z, SQLiteGlobal.journalSizeLimit, 30);
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.aqO("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            f(z, 1, 38);
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.aqO("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            f(z, 2, 39);
            AppMethodBeat.o(127173);
            return true;
        } else if (str.equals("settings_add_me_by_namecard")) {
            if (!((CheckBoxPreference) fVar.aqO("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            f(z, 4, 40);
            AppMethodBeat.o(127173);
            return true;
        } else {
            AppMethodBeat.o(127173);
            return false;
        }
    }
}
