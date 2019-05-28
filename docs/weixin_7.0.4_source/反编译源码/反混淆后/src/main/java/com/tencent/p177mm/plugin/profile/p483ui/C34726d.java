package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5510e.C5495b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.KeyValuePreference;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p1286a.C43387b;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.d */
public final class C34726d implements C23233a {
    private final Context context;
    private C15541f ehK;
    private C7616ad ehM;
    C43387b pkh;

    /* renamed from: com.tencent.mm.plugin.profile.ui.d$1 */
    class C36321 implements OnClickListener {
        C36321() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23498);
            C34726d.this.pkh.cax();
            AppMethodBeat.m2505o(23498);
        }
    }

    public C34726d(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23499);
        if (str.equals("contact_profile_say_hi")) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.ehM.field_username);
            intent.putExtra("Contact_Scene", 25);
            intent.putExtra(C5495b.yfT, this.ehM.dus);
            C39503b.gkE.mo38897a(intent, this.context);
        }
        AppMethodBeat.m2505o(23499);
        return true;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        AppMethodBeat.m2504i(23500);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (C5046bo.nullAsNil(c7616ad.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (c15541f != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.ehM = c7616ad;
        ((MMActivity) this.context).getIntent().putExtra("Contact_Scene", 25);
        if (this.pkh == null) {
            this.pkh = new C43387b((MMActivity) this.context, c7616ad);
        }
        biV();
        this.ehK = c15541f;
        c15541f.removeAll();
        c15541f.addPreferencesFromResource(C25738R.xml.f8478t);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) c15541f.aqO("contact_info_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.iFE = c15541f;
            normalProfileHeaderPreference.mo8202a(c7616ad, 25, z, null);
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) c15541f.aqO("contact_info_signature");
        if (c7616ad.signature == null || c7616ad.signature.trim().equals("")) {
            c15541f.mo27716d(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.yCj = false;
            keyValuePreference.setTitle((CharSequence) this.context.getString(C25738R.string.b0a));
            keyValuePreference.setSummary((CharSequence) C44089j.m79292b(this.context, c7616ad.signature));
            keyValuePreference.mo41844qi(false);
            keyValuePreference.mo39406NW(8);
        }
        ((MultiButtonPreference) c15541f.aqO("contact_profile_multi_button")).mo62464a(this.context.getString(C25738R.string.a9n), new C36321());
        AppMethodBeat.m2505o(23500);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23501);
        if (this.ehK == null) {
            AppMethodBeat.m2505o(23501);
        } else {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_info_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.onDetach();
            }
            AppMethodBeat.m2505o(23501);
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
