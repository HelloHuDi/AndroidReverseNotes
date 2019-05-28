package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C32782bp;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.DialogPreference;
import com.tencent.p177mm.p612ui.base.preference.MMPreference;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.base.preference.Preference.C23632a;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindLinkedInUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.setting.C24824b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI */
public class SettingsPersonalMoreUI extends MMPreference implements C4937b {
    private int dtS = -1;
    private C15541f ehK;

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI$2 */
    class C217802 implements OnMenuItemClickListener {
        C217802() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(127382);
            SettingsPersonalMoreUI.this.aqX();
            SettingsPersonalMoreUI.this.finish();
            AppMethodBeat.m2505o(127382);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI$1 */
    class C248251 implements C23632a {
        C248251() {
        }

        /* renamed from: a */
        public final boolean mo39405a(Preference preference, Object obj) {
            AppMethodBeat.m2504i(127381);
            String str = (String) obj;
            if ("male".equalsIgnoreCase(str)) {
                SettingsPersonalMoreUI.this.dtS = 1;
            } else if ("female".equalsIgnoreCase(str)) {
                SettingsPersonalMoreUI.this.dtS = 2;
            }
            AppMethodBeat.m2505o(127381);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(127383);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(127383);
    }

    /* renamed from: JC */
    public final int mo8452JC() {
        return C25738R.xml.f8556c4;
    }

    public final void initView() {
        AppMethodBeat.m2504i(127384);
        setMMTitle((int) C25738R.string.e9x);
        this.ehK = this.yCw;
        ((DialogPreference) this.ehK.aqO("settings_sex")).yBv = new C248251();
        setBackBtn(new C217802());
        AppMethodBeat.m2505o(127384);
    }

    public void onResume() {
        boolean z = true;
        AppMethodBeat.m2504i(127385);
        super.onResume();
        DialogPreference dialogPreference = (DialogPreference) this.ehK.aqO("settings_sex");
        switch (C5046bo.m7512a((Integer) C1720g.m3536RP().mo5239Ry().get(12290, null), 0)) {
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
        C32782bp aao = C32782bp.aao();
        this.ehK.aqO("settings_district").setSummary(C1854s.m3868mL(C5046bo.nullAsNil(aao.getProvince())) + " " + C5046bo.nullAsNil(aao.getCity()));
        ciZ();
        boolean z2 = (C1853r.m3829YK() & 16777216) == 0;
        String value = C26373g.m41964Nu().getValue("LinkedinPluginClose");
        int i;
        if (C5046bo.isNullOrNil(value) || Integer.valueOf(value).intValue() == 0) {
            i = true;
        } else {
            i = 0;
        }
        if (!z2 || i == 0) {
            this.ehK.mo27715ce("settings_linkedin", true);
            AppMethodBeat.m2505o(127385);
            return;
        }
        Preference aqO = this.ehK.aqO("settings_linkedin");
        if (C5046bo.isNullOrNil((String) C1720g.m3536RP().mo5239Ry().get(286721, null))) {
            z = false;
        }
        if (!z) {
            aqO.setSummary(getString(C25738R.string.e7w));
            AppMethodBeat.m2505o(127385);
        } else if ((C1853r.m3822YD() & 4194304) == 0) {
            aqO.setSummary(getString(C25738R.string.e7x));
            AppMethodBeat.m2505o(127385);
        } else {
            aqO.setSummary(getString(C25738R.string.e7y));
            AppMethodBeat.m2505o(127385);
        }
    }

    public void onPause() {
        AppMethodBeat.m2504i(127386);
        super.onPause();
        C32782bp aao = C32782bp.aao();
        if (this.dtS != -1) {
            aao.dtS = this.dtS;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(1, C32782bp.m53559a(aao)));
        AppMethodBeat.m2505o(127386);
    }

    private void ciZ() {
        AppMethodBeat.m2504i(127387);
        Preference aqO = this.ehK.aqO("settings_signature");
        CharSequence nullAsNil = C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(12291, null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(C25738R.string.eal);
        }
        aqO.setSummary(C44089j.m79292b((Context) this, nullAsNil));
        AppMethodBeat.m2505o(127387);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(127389);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            C4990ab.m7413e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(127389);
            return;
        }
        if (12291 == g) {
            ciZ();
        }
        AppMethodBeat.m2505o(127389);
    }

    /* renamed from: a */
    public final boolean mo8453a(C15541f c15541f, Preference preference) {
        AppMethodBeat.m2504i(127388);
        String str = preference.mKey;
        if (str.equals("settings_district")) {
            C24824b.gkE.mo38904b(new Intent(), this.mController.ylL);
            AppMethodBeat.m2505o(127388);
            return true;
        } else if (str.equals("settings_signature")) {
            startActivity(new Intent(this, EditSignatureUI.class));
            AppMethodBeat.m2505o(127388);
            return true;
        } else if (str.equals("settings_linkedin")) {
            Intent intent = new Intent(this, BindLinkedInUI.class);
            intent.putExtra("oversea_entry", true);
            startActivity(intent);
            AppMethodBeat.m2505o(127388);
            return true;
        } else {
            AppMethodBeat.m2505o(127388);
            return false;
        }
    }
}
