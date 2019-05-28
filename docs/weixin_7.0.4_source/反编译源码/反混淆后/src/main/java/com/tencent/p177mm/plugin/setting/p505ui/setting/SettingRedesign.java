package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingRedesign */
public class SettingRedesign extends MMPreference {
    private C15541f ehK;
    private boolean qlP;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingRedesign$1 */
    class C289411 implements OnMenuItemClickListener {
        C289411() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127073);
            SettingRedesign.this.finish();
            SettingRedesign.m86361a(SettingRedesign.this);
            AppMethodBeat.m2505o(127073);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m86361a(SettingRedesign settingRedesign) {
        AppMethodBeat.m2504i(127079);
        settingRedesign.refresh();
        AppMethodBeat.m2505o(127079);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8537bl;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127074);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127074);
    }

    public final void initView() {
        boolean z = false;
        AppMethodBeat.m2504i(127075);
        setMMTitle("Redesign");
        this.ehK = this.yCw;
        this.qlP = C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("redesign_actionbar");
        if (checkBoxPreference != null) {
            if (!this.qlP) {
                z = true;
            }
            checkBoxPreference.uOT = z;
        }
        setBackBtn(new C289411());
        AppMethodBeat.m2505o(127075);
    }

    private void refresh() {
        AppMethodBeat.m2504i(127077);
        if (this.qlP != C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).getBoolean("dark_actionbar", false)) {
            Intent intent = new Intent();
            intent.putExtra("Intro_Need_Clear_Top ", true);
            C24824b.gkE.mo38931p(intent, this.mController.ylL);
        }
        AppMethodBeat.m2505o(127077);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(127078);
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            refresh();
            AppMethodBeat.m2505o(127078);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(127078);
        return onKeyDown;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127076);
        if (preference.mKey.equals("redesign_actionbar")) {
            if (((CheckBoxPreference) preference).isChecked()) {
                C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", false).commit();
            } else {
                C4996ah.getContext().getSharedPreferences(C4996ah.doA() + "_redesign", 4).edit().putBoolean("dark_actionbar", true).commit();
            }
        }
        AppMethodBeat.m2505o(127076);
        return false;
    }
}
