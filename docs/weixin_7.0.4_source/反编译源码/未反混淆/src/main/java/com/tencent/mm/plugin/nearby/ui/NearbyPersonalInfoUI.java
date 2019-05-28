package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI extends MMPreference {
    private int dtS = -1;
    private f ehK;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55486);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(55486);
    }

    public void onDestroy() {
        AppMethodBeat.i(55487);
        super.onDestroy();
        AppMethodBeat.o(55487);
    }

    public final void initView() {
        AppMethodBeat.i(55488);
        setMMTitle((int) R.string.d5a);
        this.ehK = this.yCw;
        ((KeyValuePreference) this.ehK.aqO("settings_signature")).yCj = false;
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55483);
                NearbyPersonalInfoUI.this.finish();
                AppMethodBeat.o(55483);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.s1), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                bp aao;
                AppMethodBeat.i(55484);
                if (NearbyPersonalInfoUI.this.dtS != -1) {
                    aao = bp.aao();
                    aao.dtS = NearbyPersonalInfoUI.this.dtS;
                    bp.a(aao);
                }
                aao = bp.aap();
                if (aao == null) {
                    NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
                } else {
                    String nullAsNil = bo.nullAsNil(aao.getProvince());
                    bo.nullAsNil(aao.getCity());
                    int i = aao.dtS;
                    if (bo.isNullOrNil(nullAsNil) || i == 0) {
                        NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
                    } else {
                        NearbyPersonalInfoUI.this.startActivity(new Intent(NearbyPersonalInfoUI.this, NearbyFriendsUI.class));
                        bp aao2 = bp.aao();
                        if (i != -1) {
                            aao2.dtS = i;
                        }
                        ((j) g.K(j.class)).XL().c(new a(1, bp.a(aao2)));
                        NearbyPersonalInfoUI.this.finish();
                    }
                }
                AppMethodBeat.o(55484);
                return true;
            }
        });
        ((ChoicePreference) this.ehK.aqO("settings_sex")).yBv = new Preference.a() {
            public final boolean a(Preference preference, Object obj) {
                AppMethodBeat.i(55485);
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.dtS = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.dtS = 2;
                }
                AppMethodBeat.o(55485);
                return false;
            }
        };
        bVg();
        AppMethodBeat.o(55488);
    }

    public final int JC() {
        return R.xml.b4;
    }

    private void bVg() {
        AppMethodBeat.i(55491);
        int a = bo.a((Integer) g.RP().Ry().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.ehK.aqO("settings_sex");
        choicePreference.setTitle((CharSequence) Html.fromHtml(getString(R.string.eac) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                AppMethodBeat.o(55491);
                return;
            case 2:
                choicePreference.setValue("female");
                AppMethodBeat.o(55491);
                return;
            default:
                choicePreference.setValue("unknown");
                AppMethodBeat.o(55491);
                return;
        }
    }

    public void onResume() {
        AppMethodBeat.i(55489);
        bp aao = bp.aao();
        String province = aao.getProvince();
        String city = aao.getCity();
        Preference aqO = this.ehK.aqO("settings_district");
        aqO.setSummary(s.mL(province) + " " + city);
        aqO.setTitle(Html.fromHtml(getString(R.string.e6i) + "<font color='red'>*</font>"));
        Preference aqO2 = this.ehK.aqO("settings_signature");
        CharSequence nullAsNil = bo.nullAsNil((String) g.RP().Ry().get(12291, null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(R.string.eal);
        }
        aqO2.setSummary(com.tencent.mm.pluginsdk.ui.e.j.b((Context) this, nullAsNil));
        super.onResume();
        AppMethodBeat.o(55489);
    }

    public final boolean a(f fVar, Preference preference) {
        AppMethodBeat.i(55490);
        String str = preference.mKey;
        if ("settings_district".equals(str)) {
            com.tencent.mm.plugin.nearby.a.gkE.b(null, (Context) this);
            AppMethodBeat.o(55490);
            return true;
        } else if ("settings_signature".equals(str)) {
            com.tencent.mm.plugin.nearby.a.gkE.bf(this);
            overridePendingTransition(R.anim.cg, R.anim.cf);
            AppMethodBeat.o(55490);
            return true;
        } else {
            AppMethodBeat.o(55490);
            return false;
        }
    }

    static /* synthetic */ void b(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        AppMethodBeat.i(55492);
        h.a(nearbyPersonalInfoUI.mController.ylL, (int) R.string.d5b, (int) R.string.tz, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(55492);
    }
}
