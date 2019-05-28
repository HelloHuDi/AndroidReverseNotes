package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI */
public class SettingsHideUsernameUI extends MMPreference {
    private C15541f ehK;
    private boolean imK;
    private long kFU;
    private int qmL;
    private CheckBoxPreference qnm;
    private String username;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI$1 */
    class C38001 implements OnMenuItemClickListener {
        C38001() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127230);
            SettingsHideUsernameUI.this.finish();
            AppMethodBeat.m2505o(127230);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127231);
        super.onCreate(bundle);
        this.username = C1853r.m3819YA();
        if (C5046bo.isNullOrNil(this.username)) {
            this.username = C1853r.m3846Yz();
        }
        this.ehK = this.yCw;
        this.kFU = C1853r.m3823YE();
        this.qmL = C1853r.m3824YF();
        initView();
        setBackBtn(new C38001());
        AppMethodBeat.m2505o(127231);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.m2504i(127232);
        setMMTitle((int) C25738R.string.ecn);
        this.ehK.aqO("settings_my_username").setSummary(this.username);
        boolean z2 = (this.kFU & 16384) != 0;
        this.imK = z2;
        C4990ab.m7411d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", Boolean.valueOf(z2));
        this.qnm = (CheckBoxPreference) this.ehK.aqO("settings_show_username");
        this.qnm.yDf = false;
        CheckBoxPreference checkBoxPreference = this.qnm;
        if (z2) {
            z = false;
        }
        checkBoxPreference.uOT = z;
        if (C5046bo.isNullOrNil(C1853r.m3820YB())) {
            this.qnm.setEnabled(false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(127232);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8543br;
    }

    private void ciO() {
        AppMethodBeat.m2504i(127234);
        if (this.imK) {
            this.qnm.setSummary((CharSequence) getString(C25738R.string.eah));
            AppMethodBeat.m2505o(127234);
        } else if (this.qnm.isEnabled()) {
            this.qnm.setSummary((CharSequence) getString(C25738R.string.eaf));
            AppMethodBeat.m2505o(127234);
        } else {
            this.qnm.setSummary((CharSequence) getString(C25738R.string.eag));
            AppMethodBeat.m2505o(127234);
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(127235);
        super.onResume();
        ciO();
        AppMethodBeat.m2505o(127235);
    }

    public void onPause() {
        boolean z = false;
        int i = 1;
        AppMethodBeat.m2504i(127236);
        super.onPause();
        C4990ab.m7411d("MicroMsg.SettingsHideUsernameUI", "hide: %s", Boolean.valueOf(this.imK));
        if ((this.kFU & 16384) != 0) {
            z = true;
        }
        if (z != this.imK) {
            if (this.imK) {
                this.kFU |= 16384;
                this.qmL |= 512;
            } else {
                this.kFU &= -16385;
                this.qmL &= -513;
            }
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(147457, Long.valueOf(this.kFU));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(this.qmL));
            act act = new act();
            act.wkw = 46;
            if (this.imK) {
                i = 2;
            }
            act.pvD = i;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(23, act));
        }
        AppMethodBeat.m2505o(127236);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        boolean z = false;
        AppMethodBeat.m2504i(127233);
        if (preference.mKey.equals("settings_show_username")) {
            if (!((CheckBoxPreference) preference).isChecked()) {
                z = true;
            }
            this.imK = z;
            ciO();
            AppMethodBeat.m2505o(127233);
            return true;
        }
        AppMethodBeat.m2505o(127233);
        return false;
    }
}
