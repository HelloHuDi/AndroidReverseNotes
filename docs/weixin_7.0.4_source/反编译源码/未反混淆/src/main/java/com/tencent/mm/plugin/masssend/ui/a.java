package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.b.a, b {
    Context context;
    private f ehK;
    private ad ehM;
    private Map<String, Preference> gAX = new HashMap();

    public a(Context context) {
        AppMethodBeat.i(22758);
        this.context = context;
        AppMethodBeat.o(22758);
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(22759);
        ab.d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(22759);
            return false;
        } else if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            AppMethodBeat.o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22754);
                    a.clearData();
                    AppMethodBeat.o(22754);
                }
            }, null);
            AppMethodBeat.o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            u(this.context, true);
            AppMethodBeat.o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(22755);
                    a.u(a.this.context, false);
                    AppMethodBeat.o(22755);
                }
            }, null);
            AppMethodBeat.o(22759);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(22759);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(22760);
        if ((r.YK() & 65536) == 0) {
            AppMethodBeat.o(22760);
            return true;
        }
        AppMethodBeat.o(22760);
        return false;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(22761);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.ni(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.a1);
        biW();
        AppMethodBeat.o(22761);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(22762);
        boolean isOpen = isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_masssend_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.axn));
        helperHeaderPreference.sd(isOpen ? 1 : 0);
        this.ehK.ce("contact_info_masssend_install", isOpen);
        f fVar = this.ehK;
        String str = "contact_info_masssend_view";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_masssend_clear_data";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        f fVar2 = this.ehK;
        String str2 = "contact_info_masssend_uninstall";
        if (isOpen) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        AppMethodBeat.o(22762);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(22763);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass3 anonymousClass3 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(22756);
                int YK = r.YK();
                if (z) {
                    i = YK & -65537;
                } else {
                    i = YK | 65536;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    a.clearData();
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(22756);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(22757);
                if (b != null) {
                    b.dismiss();
                    anonymousClass3.sendEmptyMessage(0);
                }
                AppMethodBeat.o(22757);
            }
        }, 1500);
        AppMethodBeat.o(22763);
    }

    public static void clearData() {
        AppMethodBeat.i(22764);
        com.tencent.mm.plugin.masssend.a.b bNE = com.tencent.mm.plugin.masssend.a.h.bNE();
        if (bNE.fni.hY("massendinfo", "delete from massendinfo")) {
            bNE.doNotify();
        }
        aw.ZK();
        c.XR().aoX("masssendapp");
        AppMethodBeat.o(22764);
    }

    public final boolean biV() {
        AppMethodBeat.i(22765);
        aw.ZK();
        c.Ry().b(this);
        com.tencent.mm.plugin.masssend.a.gkF.BS();
        AppMethodBeat.o(22765);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(22766);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(22766);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(22766);
        } else {
            AppMethodBeat.o(22766);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
