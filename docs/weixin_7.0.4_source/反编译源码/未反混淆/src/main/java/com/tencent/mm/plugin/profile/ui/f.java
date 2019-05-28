package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class f implements a, b {
    Context context;
    private com.tencent.mm.ui.base.preference.f ehK;
    private ad ehM;
    private Map<String, Preference> gAX = new HashMap();
    private HelperHeaderPreference.a pmS;

    public f(Context context) {
        AppMethodBeat.i(23512);
        this.context = context;
        this.pmS = new q(context);
        aw.ZK();
        c.XR().apb("facebookapp");
        AppMethodBeat.o(23512);
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23513);
        ab.d("MicroMsg.ContactWidgetFacebookapp", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23513);
            return false;
        } else if (str.equals("contact_info_facebookapp_install")) {
            u(this.context, true);
            AppMethodBeat.o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23509);
                    f.u(f.this.context, false);
                    AppMethodBeat.o(23509);
                }
            }, null);
            AppMethodBeat.o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_listfriend")) {
            this.context.startActivity(new Intent(this.context, FacebookFriendUI.class));
            AppMethodBeat.o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_connect")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(23513);
            return true;
        } else if (str.equals("contact_info_facebookapp_addr")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(23513);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetFacebookapp", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23513);
            return false;
        }
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(23514);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nh(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.v);
        Preference aqO = fVar.aqO("contact_info_header_helper");
        if (aqO != null) {
            this.gAX.put("contact_info_header_helper", aqO);
        }
        aqO = fVar.aqO("contact_info_facebookapp_listfriend");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_listfriend", aqO);
        }
        aqO = fVar.aqO("contact_info_facebookapp_connect");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_connect", aqO);
        }
        PreferenceCategory preferenceCategory = (PreferenceCategory) fVar.aqO("contact_info_facebookapp_cat");
        if (preferenceCategory != null) {
            this.gAX.put("contact_info_facebookapp_cat", preferenceCategory);
        }
        aqO = fVar.aqO("contact_info_facebookapp_addr");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_addr", aqO);
        }
        preferenceCategory = (PreferenceCategory) fVar.aqO("contact_info_facebookapp_cat2");
        if (preferenceCategory != null) {
            this.gAX.put("contact_info_facebookapp_cat2", preferenceCategory);
        }
        aqO = fVar.aqO("contact_info_facebookapp_install");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_install", aqO);
        }
        aqO = fVar.aqO("contact_info_facebookapp_uninstall");
        if (aqO != null) {
            this.gAX.put("contact_info_facebookapp_uninstall", aqO);
        }
        biW();
        AppMethodBeat.o(23514);
        return true;
    }

    private static boolean isOpen() {
        AppMethodBeat.i(23515);
        if ((r.YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            AppMethodBeat.o(23515);
            return true;
        }
        AppMethodBeat.o(23515);
        return false;
    }

    private void biW() {
        AppMethodBeat.i(23516);
        this.ehK.removeAll();
        if (this.gAX.containsKey("contact_info_header_helper")) {
            HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.gAX.get("contact_info_header_helper");
            helperHeaderPreference.a(this.ehM, this.pmS);
            this.ehK.b(helperHeaderPreference);
        }
        if (this.gAX.containsKey("contact_info_facebookapp_cat")) {
            this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_cat"));
        }
        if (isOpen()) {
            if (r.Za()) {
                com.tencent.mm.au.b.ahN();
                if (this.gAX.containsKey("contact_info_facebookapp_addr")) {
                    this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_addr"));
                    Preference preference = (Preference) this.gAX.get("contact_info_facebookapp_addr");
                    aw.ZK();
                    preference.setSummary((String) c.Ry().get(65826, null));
                }
            } else if (this.gAX.containsKey("contact_info_facebookapp_connect")) {
                this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_connect"));
            }
            if (this.gAX.containsKey("contact_info_facebookapp_cat2")) {
                this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_cat2"));
            }
            if (this.gAX.containsKey("contact_info_facebookapp_uninstall")) {
                this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_uninstall"));
            }
            AppMethodBeat.o(23516);
            return;
        }
        if (this.gAX.containsKey("contact_info_facebookapp_install")) {
            this.ehK.b((Preference) this.gAX.get("contact_info_facebookapp_install"));
        }
        AppMethodBeat.o(23516);
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(23517);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass2 anonymousClass2 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(23510);
                int YK = r.YK();
                if (z) {
                    i = YK & -8193;
                } else {
                    i = YK | Utility.DEFAULT_STREAM_BUFFER_SIZE;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    com.tencent.mm.plugin.account.a.getFacebookFrdStg().apM();
                    aw.ZK();
                    c.Ry().set(65828, (Object) "");
                    aw.ZK();
                    c.XR().aoX("facebookapp");
                    aw.ZK();
                    c.XO().Rh("facebookapp");
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(23510);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(23511);
                if (b != null) {
                    b.dismiss();
                    anonymousClass2.sendEmptyMessage(0);
                }
                AppMethodBeat.o(23511);
            }
        }, 1500);
        AppMethodBeat.o(23517);
    }

    public final boolean biV() {
        AppMethodBeat.i(23518);
        aw.ZK();
        c.Ry().b(this);
        this.gAX.get("contact_info_header_helper");
        com.tencent.mm.plugin.profile.b.gkF.BS();
        AppMethodBeat.o(23518);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23519);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetFacebookapp", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(23519);
        } else if (g == 40 || g == 34 || g == 65825) {
            biW();
            AppMethodBeat.o(23519);
        } else {
            AppMethodBeat.o(23519);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
