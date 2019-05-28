package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.l */
abstract class C43388l implements C23233a, C4937b {
    protected Context context;
    protected C15541f ehK;
    protected C7616ad ehM;
    protected C39507a pnp;

    /* renamed from: com.tencent.mm.plugin.profile.ui.l$2 */
    class C128602 implements OnClickListener {
        C128602() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23590);
            C43388l.this.mo55336jP(false);
            AppMethodBeat.m2505o(23590);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.l$1 */
    class C433891 implements OnClickListener {
        C433891() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23589);
            C43388l.this.clear();
            AppMethodBeat.m2505o(23589);
        }
    }

    public abstract boolean caZ();

    public abstract void clear();

    /* renamed from: jP */
    public abstract void mo55336jP(boolean z);

    public C43388l(Context context, C39507a c39507a) {
        this.context = context;
        this.pnp = c39507a;
    }

    /* renamed from: a */
    public void mo10136a(int i, C7298n c7298n, Object obj) {
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
        }
    }

    /* renamed from: a */
    public boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
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
            z3 = true;
        }
        Assert.assertTrue(z3);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        biW();
        return true;
    }

    public boolean biV() {
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        this.ehK.aqO("contact_info_header_helper");
        return true;
    }

    /* renamed from: IO */
    public boolean mo7077IO(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C433891(), null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            mo55336jP(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C128602(), null);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(str)));
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void biW() {
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8481w);
        boolean caZ = caZ();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.mo62462a(this.ehM, this.pnp);
        }
        if (caZ) {
            this.ehK.aqP("contact_info_plugin_install");
            return;
        }
        this.ehK.aqP("contact_info_plugin_view");
        this.ehK.aqP("contact_info_plugin_clear_data");
        this.ehK.aqP("contact_info_plugin_uninstall");
    }
}
