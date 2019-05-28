package com.tencent.mm.plugin.qmessage.ui;

import android.app.Activity;
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
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
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

public final class b implements a, com.tencent.mm.sdk.e.n.b {
    Context context;
    private f ehK;
    private ad ehM;
    private boolean pli;

    public b(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(24110);
        ab.d("MicroMsg.ContactWidgetQMessage", "handleEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(24110);
            return false;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent(this.context, QConversationUI.class);
            if (this.pli) {
                ((Activity) this.context).setResult(-1, intent);
            } else {
                this.context.startActivity(intent);
            }
            ((Activity) this.context).finish();
            AppMethodBeat.o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_recv_offline_msg")) {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO(str);
            if (checkBoxPreference.isChecked()) {
                f(64, true, 5);
            } else if (Bn(Utility.DEFAULT_STREAM_BUFFER_SIZE)) {
                h.a(this.context, (int) R.string.ayj, (int) R.string.tz, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24103);
                        b.f(Utility.DEFAULT_STREAM_BUFFER_SIZE, false, 12);
                        b.f(64, false, 5);
                        AppMethodBeat.o(24103);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24104);
                        checkBoxPreference.uOT = true;
                        b.this.biW();
                        AppMethodBeat.o(24104);
                    }
                });
            } else {
                f(64, false, 5);
                AppMethodBeat.o(24110);
                return true;
            }
            AppMethodBeat.o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_display_weixin_online")) {
            f(Utility.DEFAULT_STREAM_BUFFER_SIZE, ((CheckBoxPreference) this.ehK.aqO(str)).isChecked(), 12);
            AppMethodBeat.o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_clear_data")) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(24105);
                    g.ccc();
                    AppMethodBeat.o(24105);
                }
            }, null);
            AppMethodBeat.o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_install")) {
            aw.ZK();
            if (bo.h((Integer) c.Ry().get(9, null)) == 0) {
                h.b(this.context, (int) R.string.ed5, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(24106);
                        d.a(b.this.context, "account", "com.tencent.mm.plugin.account.bind.ui.BindQQUI", null);
                        AppMethodBeat.o(24106);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AppMethodBeat.o(24110);
                return true;
            }
            u(this.context, true);
            AppMethodBeat.o(24110);
            return true;
        } else if (str.equals("contact_info_qmessage_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(24107);
                    b.u(b.this.context, false);
                    AppMethodBeat.o(24107);
                }
            }, null);
            AppMethodBeat.o(24110);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetQMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(24110);
            return false;
        }
    }

    public static void u(Context context, final boolean z) {
        AppMethodBeat.i(24111);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        final AnonymousClass7 anonymousClass7 = new ak() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.i(24108);
                b.f(64, z, 5);
                b.f(Utility.DEFAULT_STREAM_BUFFER_SIZE, z, 12);
                int YK = r.YK();
                if (z) {
                    i = YK & -33;
                } else {
                    i = YK | 32;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    g.ccc();
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                AppMethodBeat.o(24108);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.i(24109);
                if (b != null) {
                    b.dismiss();
                    anonymousClass7.sendEmptyMessage(0);
                }
                AppMethodBeat.o(24109);
            }
        }, 5000);
        AppMethodBeat.o(24111);
    }

    private static boolean isOpen() {
        AppMethodBeat.i(24112);
        if ((r.YK() & 32) == 0) {
            AppMethodBeat.o(24112);
            return true;
        }
        AppMethodBeat.o(24112);
        return false;
    }

    private static boolean Bn(int i) {
        AppMethodBeat.i(24113);
        if ((r.YD() & i) != 0) {
            AppMethodBeat.o(24113);
            return true;
        }
        AppMethodBeat.o(24113);
        return false;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(24114);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.ng(adVar.field_username));
        if (fVar != null) {
            z3 = true;
        }
        Assert.assertTrue(z3);
        aw.ZK();
        c.Ry().a(this);
        this.ehM = adVar;
        this.pli = z;
        this.ehK = fVar;
        biW();
        AppMethodBeat.o(24114);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        AppMethodBeat.i(24115);
        boolean isOpen = isOpen();
        boolean Bn = Bn(64);
        Bn(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.a6);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.aym));
        helperHeaderPreference.sd(isOpen ? 1 : 0);
        if (isOpen) {
            this.ehK.aqP("contact_info_qmessage_install");
            ((CheckBoxPreference) this.ehK.aqO("contact_info_qmessage_recv_offline_msg")).uOT = Bn;
            AppMethodBeat.o(24115);
            return;
        }
        this.ehK.aqP("contact_info_view_message");
        this.ehK.aqP("contact_info_qmessage_recv_offline_msg");
        this.ehK.aqP("contact_info_qmessage_uninstall");
        this.ehK.aqP("contact_info_qmessage_clear_data");
        AppMethodBeat.o(24115);
    }

    static void f(int i, boolean z, int i2) {
        AppMethodBeat.i(24116);
        int YD = r.YD();
        if (z) {
            YD |= i;
        } else {
            YD &= i ^ -1;
        }
        aw.ZK();
        c.Ry().set(7, Integer.valueOf(YD));
        YD = z ? 1 : 2;
        aw.ZK();
        c.XL().c(new com.tencent.mm.az.g(i2, YD));
        AppMethodBeat.o(24116);
    }

    public final boolean biV() {
        AppMethodBeat.i(24117);
        aw.ZK();
        c.Ry().b(this);
        com.tencent.mm.plugin.qmessage.a.psH.BS();
        AppMethodBeat.o(24117);
        return true;
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(24118);
        aw.ZK();
        if (nVar != c.Ry()) {
            AppMethodBeat.o(24118);
            return;
        }
        biW();
        AppMethodBeat.o(24118);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
