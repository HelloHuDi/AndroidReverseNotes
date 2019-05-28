package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f ehK;
    private int state;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127391);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127391);
    }

    public void onResume() {
        AppMethodBeat.i(127393);
        super.onResume();
        ciB();
        AppMethodBeat.o(127393);
    }

    public final int JC() {
        return -1;
    }

    private void ciB() {
        AppMethodBeat.i(127395);
        this.ehK.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle((int) R.string.e_1);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(R.layout.ae4);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(R.layout.ag0);
        } else {
            preference.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(preference);
        preference = new Preference(this);
        preference.setTitle((int) R.string.e_2);
        preference.setKey("settings_plugings_disturb_on_night");
        preference.setLayoutResource(R.layout.ae4);
        if (this.state == 1) {
            preference.setWidgetLayoutResource(R.layout.ag0);
        } else {
            preference.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(preference);
        preference = new Preference(this);
        preference.setTitle((int) R.string.e_0);
        preference.setKey("settings_plugings_disturb_off");
        preference.setLayoutResource(R.layout.ae4);
        if (this.state == 2) {
            preference.setWidgetLayoutResource(R.layout.ag0);
        } else {
            preference.setWidgetLayoutResource(R.layout.ag1);
        }
        this.ehK.b(preference);
        preference = new Preference(this);
        preference.setTitle((int) R.string.e_3);
        preference.setLayoutResource(R.layout.afn);
        this.ehK.b(preference);
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127395);
    }

    private void Cq(int i) {
        AppMethodBeat.i(127396);
        this.state = i;
        if (this.state == 1 || this.state == 0) {
            g.RP().Ry().set(8200, Boolean.TRUE);
            if (this.state == 1) {
                g.RP().Ry().set(8201, Integer.valueOf(22));
                g.RP().Ry().set(8208, Integer.valueOf(8));
                ((j) g.K(j.class)).XL().c(new k(true, 22, 8));
            } else {
                g.RP().Ry().set(8201, Integer.valueOf(0));
                g.RP().Ry().set(8208, Integer.valueOf(0));
                ((j) g.K(j.class)).XL().c(new k(true, 0, 0));
            }
        } else {
            g.RP().Ry().set(8200, Boolean.FALSE);
            ((j) g.K(j.class)).XL().c(new k());
        }
        ciB();
        AppMethodBeat.o(127396);
    }

    public final void initView() {
        AppMethodBeat.i(127397);
        this.state = getState();
        this.ehK = this.yCw;
        setMMTitle((int) R.string.e_4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127390);
                SettingsPluginsNotifyUI.this.aqX();
                SettingsPluginsNotifyUI.this.finish();
                AppMethodBeat.o(127390);
                return true;
            }
        });
        AppMethodBeat.o(127397);
    }

    private int getState() {
        AppMethodBeat.i(127392);
        g.RQ();
        Boolean valueOf = Boolean.valueOf(bo.e((Boolean) g.RP().Ry().get(8200, null)));
        g.RQ();
        int a = bo.a((Integer) g.RP().Ry().get(8201, null), 22);
        g.RQ();
        int a2 = bo.a((Integer) g.RP().Ry().get(8208, null), 8);
        if (valueOf.booleanValue()) {
            this.state = a == a2 ? 0 : 1;
        } else {
            this.state = 2;
        }
        ab.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + a + " ed " + a2 + "  state " + this.state);
        int i = this.state;
        AppMethodBeat.o(127392);
        return i;
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127394);
        String str = preference.mKey;
        if (str.equals("settings_plugings_disturb_on")) {
            Cq(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            Cq(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            Cq(2);
        }
        AppMethodBeat.o(127394);
        return false;
    }
}
