package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.bko;
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

public final class n implements a, b {
    Context context;
    private f ehK;
    private ad ehM;

    public n(Context context) {
        this.context = context;
    }

    private static boolean cba() {
        AppMethodBeat.i(23604);
        if ((r.YK() & 33554432) == 0) {
            AppMethodBeat.o(23604);
            return true;
        }
        AppMethodBeat.o(23604);
        return false;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23605);
        ab.d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23605);
            return false;
        } else if (str.equals("contact_info_voiceinput_install")) {
            u(this.context, true);
            AppMethodBeat.o(23605);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23601);
                    n.u(n.this.context, false);
                    AppMethodBeat.o(23601);
                }
            }, null);
            AppMethodBeat.o(23605);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23605);
            return false;
        }
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(23606);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nt(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.af);
        biW();
        AppMethodBeat.o(23606);
        return true;
    }

    private void biW() {
        boolean z = true;
        AppMethodBeat.i(23607);
        boolean cba = cba();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.b27));
        helperHeaderPreference.sd(cba ? 1 : 0);
        this.ehK.ce("contact_info_voiceinput_install", cba);
        f fVar = this.ehK;
        String str = "contact_info_voiceinput_uninstall";
        if (cba) {
            z = false;
        }
        fVar.ce(str, z);
        AppMethodBeat.o(23607);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(23608);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass2 anonymousClass2 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                AppMethodBeat.i(23602);
                int YK = r.YK();
                if (z) {
                    YK &= -33554433;
                } else {
                    YK |= 33554432;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 33554432;
                bko.wNJ = z ? 0 : 1;
                aw.ZK();
                c.XL().c(new j.a(39, bko));
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(23602);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(23603);
                if (b != null) {
                    b.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
                AppMethodBeat.o(23603);
            }
        }, 1500);
        AppMethodBeat.o(23608);
    }

    public final boolean biV() {
        AppMethodBeat.i(23609);
        aw.ZK();
        c.Ry().b(this);
        com.tencent.mm.plugin.profile.b.gkF.BS();
        AppMethodBeat.o(23609);
        return true;
    }

    public final void a(int i, com.tencent.mm.sdk.e.n nVar, Object obj) {
        AppMethodBeat.i(23610);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(23610);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(23610);
        } else {
            AppMethodBeat.o(23610);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
