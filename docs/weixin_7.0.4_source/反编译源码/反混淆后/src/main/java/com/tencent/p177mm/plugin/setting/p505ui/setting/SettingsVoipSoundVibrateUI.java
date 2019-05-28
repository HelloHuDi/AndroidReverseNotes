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

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI */
public class SettingsVoipSoundVibrateUI extends MMPreference {
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI$1 */
    class C217971 implements OnMenuItemClickListener {
        C217971() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127624);
            SettingsVoipSoundVibrateUI.this.aqX();
            SettingsVoipSoundVibrateUI.this.finish();
            AppMethodBeat.m2505o(127624);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8555c3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127625);
        super.onCreate(bundle);
        setMMTitle((int) C25738R.string.ed3);
        AppMethodBeat.m2505o(127625);
    }

    public void onPause() {
        AppMethodBeat.m2504i(127627);
        super.onPause();
        AppMethodBeat.m2505o(127627);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127628);
        super.onResume();
        initView();
        AppMethodBeat.m2505o(127628);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(127630);
        super.onDestroy();
        AppMethodBeat.m2505o(127630);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127626);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8555c3);
        this.ehK.mo27715ce("settings_voip_sound", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_voip_sound")).uOT = C37885a.m63961MN();
        this.ehK.mo27715ce("settings_voip_shake", false);
        ((CheckBoxPreference) this.ehK.aqO("settings_voip_shake")).uOT = C37885a.m63962MO();
        setBackBtn(new C217971());
        AppMethodBeat.m2505o(127626);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127629);
        String str = preference.mKey;
        if (str.equals("settings_voip_sound")) {
            C18559f.m28895bS(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.m2505o(127629);
            return true;
        } else if (str.equals("settings_voip_shake")) {
            C18559f.m28897bT(((CheckBoxPreference) preference).isChecked());
            initView();
            C5046bo.m7589z((Context) this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.m2505o(127629);
            return true;
        } else {
            AppMethodBeat.m2505o(127629);
            return false;
        }
    }
}
