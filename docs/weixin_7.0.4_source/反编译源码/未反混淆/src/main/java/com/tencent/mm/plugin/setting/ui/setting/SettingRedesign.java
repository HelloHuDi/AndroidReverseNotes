package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.setting.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingRedesign extends MMPreference {
    private f ehK;
    private boolean qlP;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingRedesign settingRedesign) {
        AppMethodBeat.i(127079);
        settingRedesign.refresh();
        AppMethodBeat.o(127079);
    }

    public final int JC() {
        return R.xml.bl;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127074);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127074);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.i(127075);
        setMMTitle("Redesign");
        this.ehK = this.yCw;
        this.qlP = ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("redesign_actionbar");
        if (checkBoxPreference != null) {
            if (!this.qlP) {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127073);
                SettingRedesign.this.finish();
                SettingRedesign.a(SettingRedesign.this);
                AppMethodBeat.o(127073);
                return true;
            }
        });
        AppMethodBeat.o(127075);
    }

    private void refresh() {
        AppMethodBeat.i(127077);
        if (this.qlP != ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            b.gkE.p(intent, this.mController.ylL);
        }
        AppMethodBeat.o(127077);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(127078);
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            refresh();
            AppMethodBeat.o(127078);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(127078);
        return onKeyDown;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127076);
        if (preference.mKey.equals("redesign_actionbar")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
            } else {
                ah.getContext().getSharedPreferences(ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
            }
        }
        AppMethodBeat.o(127076);
        return false;
    }
}
