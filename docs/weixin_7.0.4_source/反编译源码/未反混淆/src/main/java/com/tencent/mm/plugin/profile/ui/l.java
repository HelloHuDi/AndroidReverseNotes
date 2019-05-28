package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

abstract class l implements a, b {
    protected Context context;
    protected f ehK;
    protected ad ehM;
    protected HelperHeaderPreference.a pnp;

    public abstract boolean caZ();

    public abstract void clear();

    public abstract void jP(boolean z);

    public l(Context context, HelperHeaderPreference.a aVar) {
        this.context = context;
        this.pnp = aVar;
    }

    public void a(int i, n nVar, Object obj) {
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetPlugin", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetPlugin", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
        }
    }

    public boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
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
            z3 = true;
        }
        Assert.assertTrue(z3);
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        biW();
        return true;
    }

    public boolean biV() {
        aw.ZK();
        c.Ry().b(this);
        this.ehK.aqO("contact_info_header_helper");
        return true;
    }

    public boolean IO(String str) {
        if ("contact_info_plugin_clear_data".equals(str)) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23589);
                    l.this.clear();
                    AppMethodBeat.o(23589);
                }
            }, null);
            return true;
        } else if (str.equals("contact_info_plugin_install")) {
            jP(true);
            return true;
        } else if (str.equals("contact_info_plugin_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23590);
                    l.this.jP(false);
                    AppMethodBeat.o(23590);
                }
            }, null);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetPlugin", "handleEvent : unexpected key = ".concat(String.valueOf(str)));
            return false;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    private void biW() {
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.w);
        boolean caZ = caZ();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.a(this.ehM, this.pnp);
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
