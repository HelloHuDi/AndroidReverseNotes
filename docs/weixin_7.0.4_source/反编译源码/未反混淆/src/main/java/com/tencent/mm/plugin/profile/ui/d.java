package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import junit.framework.Assert;

public final class d implements a {
    private final Context context;
    private f ehK;
    private ad ehM;
    b pkh;

    public d(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23499);
        if (str.equals("contact_profile_say_hi")) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.ehM.field_username);
            intent.putExtra("Contact_Scene", 25);
            intent.putExtra(e.b.yfT, this.ehM.dus);
            com.tencent.mm.plugin.profile.b.gkE.a(intent, this.context);
        }
        AppMethodBeat.o(23499);
        return true;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        AppMethodBeat.i(23500);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (bo.nullAsNil(adVar.field_username).length() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        if (fVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        this.ehM = adVar;
        ((MMActivity) this.context).getIntent().putExtra("Contact_Scene", 25);
        if (this.pkh == null) {
            this.pkh = new b((MMActivity) this.context, adVar);
        }
        biV();
        this.ehK = fVar;
        fVar.removeAll();
        fVar.addPreferencesFromResource(R.xml.t);
        NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) fVar.aqO("contact_info_header_normal");
        if (normalProfileHeaderPreference != null) {
            normalProfileHeaderPreference.iFE = fVar;
            normalProfileHeaderPreference.a(adVar, 25, z, null);
        }
        KeyValuePreference keyValuePreference = (KeyValuePreference) fVar.aqO("contact_info_signature");
        if (adVar.signature == null || adVar.signature.trim().equals("")) {
            fVar.d(keyValuePreference);
        } else if (keyValuePreference != null) {
            keyValuePreference.yCj = false;
            keyValuePreference.setTitle((CharSequence) this.context.getString(R.string.b0a));
            keyValuePreference.setSummary((CharSequence) j.b(this.context, adVar.signature));
            keyValuePreference.qi(false);
            keyValuePreference.NW(8);
        }
        ((MultiButtonPreference) fVar.aqO("contact_profile_multi_button")).a(this.context.getString(R.string.a9n), new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23498);
                d.this.pkh.cax();
                AppMethodBeat.o(23498);
            }
        });
        AppMethodBeat.o(23500);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.i(23501);
        if (this.ehK == null) {
            AppMethodBeat.o(23501);
        } else {
            NormalProfileHeaderPreference normalProfileHeaderPreference = (NormalProfileHeaderPreference) this.ehK.aqO("contact_info_header_normal");
            if (normalProfileHeaderPreference != null) {
                normalProfileHeaderPreference.onDetach();
            }
            AppMethodBeat.o(23501);
        }
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
