package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.m.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoipSoundVibrateUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.c3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127625);
        super.onCreate(bundle);
        setMMTitle((int) R.string.ed3);
        AppMethodBeat.o(127625);
    }

    public void onPause() {
        AppMethodBeat.i(127627);
        super.onPause();
        AppMethodBeat.o(127627);
    }

    public void onResume() {
        AppMethodBeat.i(127628);
        super.onResume();
        initView();
        AppMethodBeat.o(127628);
    }

    public void onDestroy() {
        AppMethodBeat.i(127630);
        super.onDestroy();
        AppMethodBeat.o(127630);
    }

    public final void initView() {
        AppMethodBeat.i(127626);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.c3);
        this.ehK.ce("settings_voip_sound", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_voip_sound")).uOT = a.MN();
        this.ehK.ce("settings_voip_shake", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_voip_shake")).uOT = a.MO();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127624);
                SettingsVoipSoundVibrateUI.this.aqX();
                SettingsVoipSoundVibrateUI.this.finish();
                AppMethodBeat.o(127624);
                return true;
            }
        });
        AppMethodBeat.o(127626);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127629);
        String str = preference.mKey;
        if (str.equals("settings_voip_sound")) {
            com.tencent.mm.m.f.bS(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.o(127629);
            return true;
        } else if (str.equals("settings_voip_shake")) {
            com.tencent.mm.m.f.bT(((CheckBoxPreference) preference).isChecked());
            initView();
            bo.z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(127629);
            return true;
        } else {
            AppMethodBeat.o(127629);
            return false;
        }
    }
}
