package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.m.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

public final class j implements a, b {
    private static boolean isDeleteCancel = false;
    private Context context;
    private f ehK;
    private ad ehM;

    public j(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23556);
        ab.d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23556);
            return false;
        } else if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            com.tencent.mm.plugin.profile.b.gkE.d(intent, this.context);
            com.tencent.mm.plugin.profile.b.gkF.BS();
            AppMethodBeat.o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (r.Ze()) {
                jQ(((CheckBoxPreference) this.ehK.aqO(str)).isChecked());
            } else {
                h.a(this.context, (int) R.string.axq, (int) R.string.axp, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(23548);
                        com.tencent.mm.plugin.profile.b.gkE.g(new Intent(), j.this.context);
                        AppMethodBeat.o(23548);
                    }
                }, null);
                biW();
            }
            AppMethodBeat.o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23549);
                    j.eI(j.this.context);
                    AppMethodBeat.o(23549);
                }
            }, null);
            AppMethodBeat.o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            u(this.context, true);
            AppMethodBeat.o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23550);
                    j.u(j.this.context, false);
                    AppMethodBeat.o(23550);
                }
            }, null);
            AppMethodBeat.o(23556);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23556);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.i(23557);
        if ((r.YK() & 16) == 0) {
            AppMethodBeat.o(23557);
            return true;
        }
        AppMethodBeat.o(23557);
        return false;
    }

    private static boolean cbb() {
        AppMethodBeat.i(23558);
        int YD = r.YD();
        if (!r.Ze()) {
            if ((YD & 16384) != 0) {
                YD &= -16385;
                aw.ZK();
                c.Ry().set(7, Integer.valueOf(YD));
            }
            AppMethodBeat.o(23558);
            return false;
        } else if ((YD & 16384) != 0) {
            AppMethodBeat.o(23558);
            return true;
        } else {
            AppMethodBeat.o(23558);
            return false;
        }
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.i(23559);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.no(adVar.field_username));
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.a2);
        biW();
        AppMethodBeat.o(23559);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(23560);
        boolean isOpen = isOpen();
        boolean cbb = cbb();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.axr));
        helperHeaderPreference.sd(isOpen ? 1 : 0);
        this.ehK.ce("contact_info_medianote_install", isOpen);
        f fVar = this.ehK;
        String str = "contact_info_medianote_view";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        if (!isOpen || r.Ze()) {
            z = isOpen;
        } else {
            if (bo.getInt(g.Nu().getValue("BindQQSwitch"), 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            ab.i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        fVar = this.ehK;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_medianote_clear_data";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        f fVar2 = this.ehK;
        String str2 = "contact_info_medianote_uninstall";
        if (isOpen) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        ((CheckBoxPreference) this.ehK.aqO("contact_info_medianote_sync_to_qqmail")).uOT = cbb;
        AppMethodBeat.o(23560);
    }

    public static void u(final Context context, final boolean z) {
        AppMethodBeat.i(23561);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass4 anonymousClass4 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(23551);
                if (z) {
                    j.jQ(true);
                }
                int YK = r.YK();
                if (z) {
                    i = YK & -17;
                } else {
                    i = YK | 16;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    j.eI(context);
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(23551);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(23552);
                if (b != null) {
                    b.dismiss();
                    anonymousClass4.sendEmptyMessage(0);
                }
                AppMethodBeat.o(23552);
            }
        }, 1500);
        AppMethodBeat.o(23561);
    }

    public final boolean biV() {
        AppMethodBeat.i(23562);
        aw.ZK();
        c.Ry().b(this);
        com.tencent.mm.plugin.profile.b.gkF.BS();
        AppMethodBeat.o(23562);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23563);
        int g = bo.g(obj, 0);
        ab.d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), nVar);
        aw.ZK();
        if (nVar != c.Ry() || g <= 0) {
            ab.e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), nVar);
            AppMethodBeat.o(23563);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(23563);
        } else {
            AppMethodBeat.o(23563);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    static void jQ(boolean z) {
        AppMethodBeat.i(23564);
        int YD = r.YD();
        if (z) {
            YD |= 16384;
        } else {
            YD &= -16385;
        }
        aw.ZK();
        c.Ry().set(7, Integer.valueOf(YD));
        YD = z ? 1 : 2;
        aw.ZK();
        c.XL().c(new com.tencent.mm.az.g(13, YD));
        AppMethodBeat.o(23564);
    }

    static /* synthetic */ void eI(Context context) {
        AppMethodBeat.i(23565);
        isDeleteCancel = false;
        context.getString(R.string.tz);
        final p b = h.b(context, context.getString(R.string.un), true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(23553);
                j.isDeleteCancel = true;
                AppMethodBeat.o(23553);
            }
        });
        bf.a("medianote", new bf.a() {
            public final boolean JU() {
                AppMethodBeat.i(23554);
                boolean access$200 = j.isDeleteCancel;
                AppMethodBeat.o(23554);
                return access$200;
            }

            public final void JV() {
                AppMethodBeat.i(23555);
                if (b != null) {
                    b.dismiss();
                }
                AppMethodBeat.o(23555);
            }
        });
        aw.ZK();
        c.XR().aoX("medianote");
        AppMethodBeat.o(23565);
    }
}
