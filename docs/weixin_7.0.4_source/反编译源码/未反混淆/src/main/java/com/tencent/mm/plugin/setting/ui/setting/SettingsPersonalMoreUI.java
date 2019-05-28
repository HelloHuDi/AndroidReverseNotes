package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.preference.DialogPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.Preference.a;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPersonalMoreUI extends MMPreference implements b {
    private int dtS = -1;
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127383);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(127383);
    }

    public final int JC() {
        return R.xml.c4;
    }

    public final void initView() {
        AppMethodBeat.i(127384);
        setMMTitle((int) R.string.e9x);
        this.ehK = this.yCw;
        ((DialogPreference) this.ehK.aqO("settings_sex")).yBv = new a() {
            public final boolean a(Preference preference, Object obj) {
                AppMethodBeat.i(127381);
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    SettingsPersonalMoreUI.this.dtS = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    SettingsPersonalMoreUI.this.dtS = 2;
                }
                AppMethodBeat.o(127381);
                return false;
            }
        };
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127382);
                SettingsPersonalMoreUI.this.aqX();
                SettingsPersonalMoreUI.this.finish();
                AppMethodBeat.o(127382);
                return true;
            }
        });
        AppMethodBeat.o(127384);
    }

    public void onResume() {
        boolean z = true;
        AppMethodBeat.i(127385);
        super.onResume();
        DialogPreference dialogPreference = (DialogPreference) this.ehK.aqO("settings_sex");
        switch (bo.a((Integer) g.RP().Ry().get(12290, null), 0)) {
            case 1:
                dialogPreference.setValue("male");
                break;
            case 2:
                dialogPreference.setValue("female");
                break;
            default:
                dialogPreference.setValue("unknown");
                break;
        }
        bp aao = bp.aao();
        this.ehK.aqO("settings_district").setSummary(s.mL(bo.nullAsNil(aao.getProvince())) + " " + bo.nullAsNil(aao.getCity()));
        ciZ();
        boolean z2 = (r.YK() & 16777216) == 0;
        String value = com.tencent.mm.m.g.Nu().getValue("LinkedinPluginClose");
        int i;
        if (bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
            i = true;
        } else {
            i = 0;
        }
        if (!z2 || i == 0) {
            this.ehK.ce("settings_linkedin", true);
            AppMethodBeat.o(127385);
            return;
        }
        Preference aqO = this.ehK.aqO("settings_linkedin");
        if (bo.isNullOrNil((String) g.RP().Ry().get(286721, null))) {
            z = false;
        }
        if (!z) {
            aqO.setSummary(getString(R.string.e7w));
            AppMethodBeat.o(127385);
        } else if ((r.YD() & 4194304) == 0) {
            aqO.setSummary(getString(R.string.e7x));
            AppMethodBeat.o(127385);
        } else {
            aqO.setSummary(getString(R.string.e7y));
            AppMethodBeat.o(127385);
        }
    }

    public void onPause() {
        AppMethodBeat.i(127386);
        super.onPause();
        bp aao = bp.aao();
        if (this.dtS != -1) {
            aao.dtS = this.dtS;
        }
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(1, bp.a(aao)));
        AppMethodBeat.o(127386);
    }

    private void ciZ() {
        AppMethodBeat.i(127387);
        Preference aqO = this.ehK.aqO("settings_signature");
        CharSequence nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(12291, null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(R.string.eal);
        }
        aqO.setSummary(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, nullAsNil));
        AppMethodBeat.o(127387);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(127389);
        int g = bo.g(obj, 0);
        ab.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        if (nVar != g.RP().Ry() || g <= 0) {
            ab.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(127389);
            return;
        }
        if (12291 == g) {
            ciZ();
        }
        AppMethodBeat.o(127389);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(127388);
        String str = preference.mKey;
        if (str.equals("settings_district")) {
            com.tencent.mm.plugin.setting.b.gkE.b(new Intent(), this.mController.ylL);
            AppMethodBeat.o(127388);
            return true;
        } else if (str.equals("settings_signature")) {
            startActivity(new Intent(this, EditSignatureUI.class));
            AppMethodBeat.o(127388);
            return true;
        } else if (str.equals("settings_linkedin")) {
            Intent intent = new Intent(this, BindLinkedInUI.class);
            intent.putExtra("oversea_entry", true);
            startActivity(intent);
            AppMethodBeat.o(127388);
            return true;
        } else {
            AppMethodBeat.o(127388);
            return false;
        }
    }
}
