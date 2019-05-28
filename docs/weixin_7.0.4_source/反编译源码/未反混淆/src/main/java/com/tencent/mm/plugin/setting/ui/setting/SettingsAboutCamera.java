package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera extends MMPreference {
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127081);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127081);
    }

    public final int JC() {
        return R.xml.bw;
    }

    private void ciB() {
        AppMethodBeat.i(127083);
        boolean booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_auto_mul_terminal_sync");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = booleanValue;
        booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_take_photo_auto_save_photo");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = booleanValue;
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_take_photo_auto_save_video");
        checkBoxPreference.uOT = ((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        checkBoxPreference.yDf = false;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127083);
    }

    public final boolean a(f fVar, Preference preference) {
        boolean booleanValue;
        boolean z = true;
        AppMethodBeat.i(127082);
        String str = preference.mKey;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            g.RP().Ry().set(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(!((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            z Ry = g.RP().Ry();
            a aVar = a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            Ry.set(aVar, Boolean.valueOf(booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            booleanValue = ((Boolean) g.RP().Ry().get(a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            z Ry2 = g.RP().Ry();
            a aVar2 = a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN;
            if (booleanValue) {
                z = false;
            }
            Ry2.set(aVar2, Boolean.valueOf(z));
        }
        AppMethodBeat.o(127082);
        return false;
    }

    public final void initView() {
        AppMethodBeat.i(127084);
        this.ehK = this.yCw;
        setMMTitle((int) R.string.e9y);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127080);
                SettingsAboutCamera.this.aqX();
                SettingsAboutCamera.this.finish();
                AppMethodBeat.o(127080);
                return true;
            }
        });
        ciB();
        AppMethodBeat.o(127084);
    }
}
