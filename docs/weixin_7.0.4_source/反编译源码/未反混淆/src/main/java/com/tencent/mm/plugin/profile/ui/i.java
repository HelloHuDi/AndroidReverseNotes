package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class i implements a, b {
    Context context;
    private f ehK;
    private ad ehM;
    private HelperHeaderPreference.a pmY;

    public i(Context context) {
        AppMethodBeat.i(23539);
        this.context = context;
        this.pmY = new s(context);
        AppMethodBeat.o(23539);
    }

    private static boolean cba() {
        AppMethodBeat.i(23540);
        if ((r.YK() & 16777216) == 0) {
            AppMethodBeat.o(23540);
            return true;
        }
        AppMethodBeat.o(23540);
        return false;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23541);
        ab.d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23541);
            return false;
        } else if (str.equals("contact_info_linkedin_install")) {
            u(this.context, true);
            AppMethodBeat.o(23541);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23537);
                    i.u(i.this.context, false);
                    AppMethodBeat.o(23537);
                }
            }, null);
            AppMethodBeat.o(23541);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                ((Activity) this.context).startActivityForResult(new Intent(this.context, BindLinkedInUI.class), 1);
            }
            ab.e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23541);
            return false;
        }
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(23542);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nu(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        biW();
        AppMethodBeat.o(23542);
        return true;
    }

    private void biW() {
        AppMethodBeat.i(23543);
        boolean cba = cba();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.a0);
        ((HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper")).a(this.ehM, this.pmY);
        if (cba) {
            this.ehK.ce("contact_info_linkedin_account", false);
            this.ehK.aqP("contact_info_linkedin_install");
            AppMethodBeat.o(23543);
            return;
        }
        this.ehK.ce("contact_info_linkedin_account", true);
        this.ehK.aqP("contact_info_linkedin_uninstall");
        AppMethodBeat.o(23543);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(23544);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        new ap(new ap.a() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final boolean BI() {
                AppMethodBeat.i(23538);
                if (b != null) {
                    b.dismiss();
                }
                int YK = r.YK();
                if (z) {
                    YK &= -16777217;
                } else {
                    YK |= 16777216;
                    aw.ZK();
                    c.Ry().set(286722, (Object) "");
                    aw.ZK();
                    c.Ry().set(286721, (Object) "");
                    aw.ZK();
                    c.Ry().set(286723, (Object) "");
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 16777216;
                bko.wNJ = z ? 0 : 1;
                aw.ZK();
                c.XL().c(new j.a(39, bko));
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(23538);
                return false;
            }
        }, false).ae(1500, 1500);
        AppMethodBeat.o(23544);
    }

    public final boolean biV() {
        AppMethodBeat.i(23545);
        aw.ZK();
        c.Ry().b(this);
        this.ehK.aqO("contact_info_header_helper");
        com.tencent.mm.plugin.profile.b.gkF.BS();
        AppMethodBeat.o(23545);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23546);
        if (i == 1 && i2 == -1) {
            biW();
        }
        AppMethodBeat.o(23546);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23547);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                biW();
            }
        }
        AppMethodBeat.o(23547);
    }
}
