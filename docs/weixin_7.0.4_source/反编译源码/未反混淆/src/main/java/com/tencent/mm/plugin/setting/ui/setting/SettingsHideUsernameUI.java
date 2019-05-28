package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI extends MMPreference {
    private f ehK;
    private boolean imK;
    private long kFU;
    private int qmL;
    private CheckBoxPreference qnm;
    private String username;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127231);
        super.onCreate(bundle);
        this.username = r.YA();
        if (bo.isNullOrNil(this.username)) {
            this.username = r.Yz();
        }
        this.ehK = this.yCw;
        this.kFU = r.YE();
        this.qmL = r.YF();
        initView();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127230);
                SettingsHideUsernameUI.this.finish();
                AppMethodBeat.o(127230);
                return true;
            }
        });
        AppMethodBeat.o(127231);
    }

    public final void initView() {
        boolean z = true;
        AppMethodBeat.i(127232);
        setMMTitle((int) R.string.ecn);
        this.ehK.aqO("settings_my_username").setSummary(this.username);
        boolean z2 = (this.kFU & 16384) != 0;
        this.imK = z2;
        ab.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", Boolean.valueOf(z2));
        this.qnm = (CheckBoxPreference) this.ehK.aqO("settings_show_username");
        this.qnm.yDf = false;
        CheckBoxPreference checkBoxPreference = this.qnm;
        if (z2) {
            z = false;
        }
        checkBoxPreference.uOT = z;
        if (bo.isNullOrNil(r.YB())) {
            this.qnm.setEnabled(false);
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127232);
    }

    public final int JC() {
        return R.xml.br;
    }

    private void ciO() {
        AppMethodBeat.i(127234);
        if (this.imK) {
            this.qnm.setSummary((CharSequence) getString(R.string.eah));
            AppMethodBeat.o(127234);
        } else if (this.qnm.isEnabled()) {
            this.qnm.setSummary((CharSequence) getString(R.string.eaf));
            AppMethodBeat.o(127234);
        } else {
            this.qnm.setSummary((CharSequence) getString(R.string.eag));
            AppMethodBeat.o(127234);
        }
    }

    public void onResume() {
        AppMethodBeat.i(127235);
        super.onResume();
        ciO();
        AppMethodBeat.o(127235);
    }

    public void onPause() {
        boolean z = false;
        int i = 1;
        AppMethodBeat.i(127236);
        super.onPause();
        ab.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", Boolean.valueOf(this.imK));
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
            g.RQ();
            g.RP().Ry().set(147457, Long.valueOf(this.kFU));
            g.RQ();
            g.RP().Ry().set(40, Integer.valueOf(this.qmL));
            act act = new act();
            act.wkw = 46;
            if (this.imK) {
                i = 2;
            }
            act.pvD = i;
            ((j) g.K(j.class)).XL().c(new a(23, act));
        }
        AppMethodBeat.o(127236);
    }

    public final boolean a(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(127233);
        if (preference.mKey.equals("settings_show_username")) {
            if (!((CheckBoxPreference) preference).isChecked()) {
                z = true;
            }
            this.imK = z;
            ciO();
            AppMethodBeat.o(127233);
            return true;
        }
        AppMethodBeat.o(127233);
        return false;
    }
}
