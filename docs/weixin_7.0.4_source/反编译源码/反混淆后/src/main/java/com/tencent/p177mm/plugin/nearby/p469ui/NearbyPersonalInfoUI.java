package com.tencent.p177mm.plugin.nearby.p469ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.ChoicePreference;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.nearby.C39456a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI */
public class NearbyPersonalInfoUI extends MMPreference {
    private int dtS = -1;
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI$2 */
    class C213562 implements OnMenuItemClickListener {
        C213562() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            C32782bp aao;
            AppMethodBeat.m2504i(55484);
            if (NearbyPersonalInfoUI.this.dtS != -1) {
                aao = C32782bp.aao();
                aao.dtS = NearbyPersonalInfoUI.this.dtS;
                C32782bp.m53559a(aao);
            }
            aao = C32782bp.aap();
            if (aao == null) {
                NearbyPersonalInfoUI.m56785b(NearbyPersonalInfoUI.this);
            } else {
                String nullAsNil = C5046bo.nullAsNil(aao.getProvince());
                C5046bo.nullAsNil(aao.getCity());
                int i = aao.dtS;
                if (C5046bo.isNullOrNil(nullAsNil) || i == 0) {
                    NearbyPersonalInfoUI.m56785b(NearbyPersonalInfoUI.this);
                } else {
                    NearbyPersonalInfoUI.this.startActivity(new Intent(NearbyPersonalInfoUI.this, NearbyFriendsUI.class));
                    C32782bp aao2 = C32782bp.aao();
                    if (i != -1) {
                        aao2.dtS = i;
                    }
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(1, C32782bp.m53559a(aao2)));
                    NearbyPersonalInfoUI.this.finish();
                }
            }
            AppMethodBeat.m2505o(55484);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI$1 */
    class C285991 implements OnMenuItemClickListener {
        C285991() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(55483);
            NearbyPersonalInfoUI.this.finish();
            AppMethodBeat.m2505o(55483);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI$3 */
    class C286003 implements C23632a {
        C286003() {
        }

        /* renamed from: a */
        public final boolean mo39405a(Preference preference, Object obj) {
            AppMethodBeat.m2504i(55485);
            String str = (String) obj;
            if ("male".equalsIgnoreCase(str)) {
                NearbyPersonalInfoUI.this.dtS = 1;
            } else if ("female".equalsIgnoreCase(str)) {
                NearbyPersonalInfoUI.this.dtS = 2;
            }
            AppMethodBeat.m2505o(55485);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI$4 */
    class C346164 implements OnClickListener {
        C346164() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(55486);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(55486);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(55487);
        super.onDestroy();
        AppMethodBeat.m2505o(55487);
    }

    public final void initView() {
        AppMethodBeat.m2504i(55488);
        setMMTitle((int) C25738R.string.d5a);
        this.ehK = this.yCw;
        ((KeyValuePreference) this.ehK.aqO("settings_signature")).yCj = false;
        setBackBtn(new C285991());
        addTextOptionMenu(0, getString(C25738R.string.f9182s1), new C213562());
        ((ChoicePreference) this.ehK.aqO("settings_sex")).yBv = new C286003();
        bVg();
        AppMethodBeat.m2505o(55488);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8519b4;
    }

    private void bVg() {
        AppMethodBeat.m2504i(55491);
        int a = C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12290, null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.ehK.aqO("settings_sex");
        choicePreference.setTitle((CharSequence) Html.fromHtml(getString(C25738R.string.eac) + "<font color='red'>*</font>"));
        switch (a) {
            case 1:
                choicePreference.setValue("male");
                AppMethodBeat.m2505o(55491);
                return;
            case 2:
                choicePreference.setValue("female");
                AppMethodBeat.m2505o(55491);
                return;
            default:
                choicePreference.setValue("unknown");
                AppMethodBeat.m2505o(55491);
                return;
        }
    }

    public void onResume() {
        AppMethodBeat.m2504i(55489);
        C32782bp aao = C32782bp.aao();
        String province = aao.getProvince();
        String city = aao.getCity();
        Preference aqO = this.ehK.aqO("settings_district");
        aqO.setSummary(C1854s.m3868mL(province) + " " + city);
        aqO.setTitle(Html.fromHtml(getString(C25738R.string.e6i) + "<font color='red'>*</font>"));
        Preference aqO2 = this.ehK.aqO("settings_signature");
        CharSequence nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(12291, null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(C25738R.string.eal);
        }
        aqO2.setSummary(C44089j.m79292b((Context) this, nullAsNil));
        super.onResume();
        AppMethodBeat.m2505o(55489);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(55490);
        String str = preference.mKey;
        if ("settings_district".equals(str)) {
            C39456a.gkE.mo38904b(null, (Context) this);
            AppMethodBeat.m2505o(55490);
            return true;
        } else if ("settings_signature".equals(str)) {
            C39456a.gkE.mo38907bf(this);
            overridePendingTransition(C25738R.anim.f8375cg, C25738R.anim.f8374cf);
            AppMethodBeat.m2505o(55490);
            return true;
        } else {
            AppMethodBeat.m2505o(55490);
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m56785b(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        AppMethodBeat.m2504i(55492);
        C30379h.m48431a(nearbyPersonalInfoUI.mController.ylL, (int) C25738R.string.d5b, (int) C25738R.string.f9238tz, new C346164());
        AppMethodBeat.m2505o(55492);
    }
}
