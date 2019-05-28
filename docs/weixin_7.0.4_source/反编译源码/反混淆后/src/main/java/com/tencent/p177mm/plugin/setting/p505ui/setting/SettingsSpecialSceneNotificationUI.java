package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p249m.C18559f;
import com.tencent.p177mm.p249m.C37885a;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI */
public class SettingsSpecialSceneNotificationUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI$1 */
    class C38131 implements OnMenuItemClickListener {
        C38131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127490);
            SettingsSpecialSceneNotificationUI.this.aqX();
            SettingsSpecialSceneNotificationUI.this.finish();
            AppMethodBeat.m2505o(127490);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8554c2;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127491);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.eb7);
        AppMethodBeat.m2505o(127491);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127493);
        super.onPause();
        AppMethodBeat.m2505o(127493);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127494);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(127494);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127496);
        super.onDestroy();
        AppMethodBeat.m2505o(127496);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127492);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8554c2);
        this.ehK.mo27715ce("settings_specail_scene_sound", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_specail_scene_sound")).uOT = C37885a.m63959ML();
        this.ehK.mo27715ce("settings_specail_scene_shake", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_specail_scene_shake")).uOT = C37885a.m63960MM();
        setBackBtn(new C38131());
        AppMethodBeat.m2505o(127492);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127495);
        String str = preference.mKey;
        if (str.equals("settings_specail_scene_sound")) {
            C18559f.m28893bQ(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.m2505o(127495);
            return true;
        } else if (str.equals("settings_specail_scene_shake")) {
            C18559f.m28894bR(((CheckBoxPreference) preference).isChecked());
            initView();
            C5046bo.m7589z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.m2505o(127495);
            return true;
        } else {
            AppMethodBeat.m2505o(127495);
            return false;
        }
    }
}
