package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera */
public class SettingsAboutCamera extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera$1 */
    class C396681 implements OnMenuItemClickListener {
        C396681() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127080);
            SettingsAboutCamera.this.aqX();
            SettingsAboutCamera.this.finish();
            AppMethodBeat.m2505o(127080);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127081);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127081);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8548bw;
    }

    private void ciB() {
        AppMethodBeat.m2504i(127083);
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_auto_mul_terminal_sync");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = booleanValue;
        booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_take_photo_auto_save_photo");
        checkBoxPreference.yDf = false;
        checkBoxPreference.uOT = booleanValue;
        checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("settings_take_photo_auto_save_video");
        checkBoxPreference.uOT = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        checkBoxPreference.yDf = false;
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127083);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean booleanValue;
        boolean z = true;
        AppMethodBeat.m2504i(127082);
        String str = preference.mKey;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            C7580z Ry = C1720g.m3536RP().mo5239Ry();
            C5127a c5127a = C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN;
            if (booleanValue) {
                booleanValue = false;
            } else {
                booleanValue = true;
            }
            Ry.set(c5127a, Boolean.valueOf(booleanValue));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            C7580z Ry2 = C1720g.m3536RP().mo5239Ry();
            C5127a c5127a2 = C5127a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN;
            if (booleanValue) {
                z = false;
            }
            Ry2.set(c5127a2, Boolean.valueOf(z));
        }
        AppMethodBeat.m2505o(127082);
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127084);
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.e9y);
        setBackBtn(new C396681());
        ciB();
        AppMethodBeat.m2505o(127084);
    }
}
