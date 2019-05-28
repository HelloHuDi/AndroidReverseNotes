package com.tencent.mm.plugin.shake.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.model.as;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements as, com.tencent.mm.pluginsdk.b.a, b {
    Context context;
    private f ehK;
    private ad ehM;

    public a(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(24692);
        ab.d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(24692);
            return false;
        } else if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            AppMethodBeat.o(24692);
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            u(this.context, true);
            AppMethodBeat.o(24692);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(24689);
                    a.u(a.this.context, false);
                    AppMethodBeat.o(24689);
                }
            }, null);
            AppMethodBeat.o(24692);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(24692);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(24693);
        if ((r.YK() & 256) == 0) {
            AppMethodBeat.o(24693);
            return true;
        }
        AppMethodBeat.o(24693);
        return false;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(24694);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nn(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        aw.ZK();
        c.a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.ab);
        biW();
        AppMethodBeat.o(24694);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(24695);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.b0_));
            helperHeaderPreference.sd(isOpen ? 1 : 0);
        }
        this.ehK.ce("contact_info_shake_install", isOpen);
        f fVar = this.ehK;
        String str = "contact_info_shake_go_shake";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        f fVar2 = this.ehK;
        String str2 = "contact_info_shake_uninstall";
        if (isOpen) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        AppMethodBeat.o(24695);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(24696);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass2 anonymousClass2 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(24690);
                int YK = r.YK();
                if (z) {
                    i = YK & -257;
                } else {
                    i = YK | 256;
                }
                ab.i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", Boolean.valueOf(z), Integer.valueOf(YK), Integer.valueOf(i));
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    m.cjV();
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(24690);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(24691);
                if (b != null) {
                    b.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
                AppMethodBeat.o(24691);
            }
        }, 1500);
        AppMethodBeat.o(24696);
    }

    public final boolean biV() {
        AppMethodBeat.i(24697);
        aw.ZK();
        c.Ry().b(this);
        aw.ZK();
        c.b(this);
        com.tencent.mm.plugin.shake.a.gkF.BS();
        AppMethodBeat.o(24697);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void ZB() {
        AppMethodBeat.i(24698);
        biW();
        AppMethodBeat.o(24698);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(24699);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(24699);
        } else if (g == 7 || g == 34) {
            biW();
            AppMethodBeat.o(24699);
        } else {
            AppMethodBeat.o(24699);
        }
    }
}
