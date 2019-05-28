package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.setting.model.C34848k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI */
public class SettingsPluginsNotifyUI extends MMPreference {
    private C15541f ehK;
    private int state;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI$1 */
    class C38101 implements OnMenuItemClickListener {
        C38101() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127390);
            SettingsPluginsNotifyUI.this.aqX();
            SettingsPluginsNotifyUI.this.finish();
            AppMethodBeat.m2505o(127390);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127391);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127391);
    }

    public void onResume() {
        AppMethodBeat.m2504i(127393);
        super.onResume();
        ciB();
        AppMethodBeat.m2505o(127393);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return -1;
    }

    private void ciB() {
        AppMethodBeat.m2504i(127395);
        this.ehK.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle((int) C25738R.string.e_1);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(2130970127);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(2130970197);
        } else {
            preference.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(preference);
        preference = new Preference(this);
        preference.setTitle((int) C25738R.string.e_2);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(2130970127);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(2130970197);
        } else {
            preference.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(preference);
        preference = new Preference(this);
        preference.setTitle((int) C25738R.string.e_0);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(2130970127);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(2130970197);
        } else {
            preference.setWidgetLayoutResource(2130970198);
        }
        this.ehK.mo27713b(preference);
        preference = new Preference(this);
        preference.setTitle((int) C25738R.string.e_3);
        preference.setLayoutResource(2130970184);
        this.ehK.mo27713b(preference);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127395);
    }

    /* renamed from: Cq */
    private void m33314Cq(int i) {
        AppMethodBeat.m2504i(127396);
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            C1720g.m3536RP().mo5239Ry().set(8200, Boolean.TRUE);
            if (this.state == 1) {
                C1720g.m3536RP().mo5239Ry().set(8201, Integer.valueOf(22));
                C1720g.m3536RP().mo5239Ry().set(8208, Integer.valueOf(8));
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C34848k(true, 22, 8));
            } else {
                C1720g.m3536RP().mo5239Ry().set(8201, Integer.valueOf(0));
                C1720g.m3536RP().mo5239Ry().set(8208, Integer.valueOf(0));
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C34848k(true, 0, 0));
            }
        } else {
            C1720g.m3536RP().mo5239Ry().set(8200, Boolean.FALSE);
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C34848k());
        }
        ciB();
        AppMethodBeat.m2505o(127396);
    }

    public final void initView() {
        AppMethodBeat.m2504i(127397);
        this.state = getState();
        this.ehK = this.yCw;
        setMMTitle((int) C25738R.string.e_4);
        setBackBtn(new C38101());
        AppMethodBeat.m2505o(127397);
    }

    private int getState() {
        AppMethodBeat.m2504i(127392);
        C1720g.m3537RQ();
        Boolean valueOf = Boolean.valueOf(C5046bo.m7546e((Boolean) C1720g.m3536RP().mo5239Ry().get(8200, null)));
        C1720g.m3537RQ();
        int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(8201, null), 22);
        C1720g.m3537RQ();
        int a2 = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(8208, null), 8);
        if (valueOf.booleanValue()) {
            this.state = a == a2 ? 0 : 1;
        } else {
            this.state = 2;
        }
        C4990ab.m7410d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + a + " ed " + a2 + "  state " + this.state);
        int i = this.state;
        AppMethodBeat.m2505o(127392);
        return i;
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127394);
        String str = preference.mKey;
        if (str.equals("settings_plugings_disturb_on")) {
            m33314Cq(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            m33314Cq(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            m33314Cq(2);
        }
        AppMethodBeat.m2505o(127394);
        return false;
    }
}
