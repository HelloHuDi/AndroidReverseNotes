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

public class SettingsSpecialSceneNotificationUI extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.c2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127491);
        super.onCreate(bundle);
        setMMTitle((int) R.string.eb7);
        AppMethodBeat.o(127491);
    }

    public void onPause() {
        AppMethodBeat.i(127493);
        super.onPause();
        AppMethodBeat.o(127493);
    }

    public void onResume() {
        AppMethodBeat.i(127494);
        super.onResume();
        initView();
        AppMethodBeat.o(127494);
    }

    public void onDestroy() {
        AppMethodBeat.i(127496);
        super.onDestroy();
        AppMethodBeat.o(127496);
    }

    public final void initView() {
        AppMethodBeat.i(127492);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.c2);
        this.ehK.ce("settings_specail_scene_sound", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_specail_scene_sound")).uOT = a.ML();
        this.ehK.ce("settings_specail_scene_shake", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_specail_scene_shake")).uOT = a.MM();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127490);
                SettingsSpecialSceneNotificationUI.this.aqX();
                SettingsSpecialSceneNotificationUI.this.finish();
                AppMethodBeat.o(127490);
                return true;
            }
        });
        AppMethodBeat.o(127492);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127495);
        String str = preference.mKey;
        if (str.equals("settings_specail_scene_sound")) {
            com.tencent.mm.m.f.bQ(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.o(127495);
            return true;
        } else if (str.equals("settings_specail_scene_shake")) {
            com.tencent.mm.m.f.bR(((CheckBoxPreference) preference).isChecked());
            initView();
            bo.z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(127495);
            return true;
        } else {
            AppMethodBeat.o(127495);
            return false;
        }
    }
}
