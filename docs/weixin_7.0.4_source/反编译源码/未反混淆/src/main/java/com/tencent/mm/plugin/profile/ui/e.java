package com.tencent.mm.plugin.profile.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.g;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import junit.framework.Assert;

public final class e implements a {
    Context context;
    private f ehK;
    private ad ehM;
    boolean isDeleteCancel = false;
    private boolean pli;
    private HelperHeaderPreference.a pmQ;
    private int status;
    p tipDialog = null;

    public e(Context context) {
        AppMethodBeat.i(23504);
        this.context = context;
        this.pmQ = new o(context);
        this.status = -1;
        AppMethodBeat.o(23504);
    }

    public final boolean IO(String str) {
        boolean z = false;
        AppMethodBeat.i(23505);
        ab.d("MicroMsg.ContactWidgetFMessage", "handlerEvent : key = ".concat(String.valueOf(str)));
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23505);
            return false;
        } else if (str.equals("contact_info_recommend_qqfriends_to_me")) {
            boolean z2;
            if (((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_qqfriends_to_me")).isChecked()) {
                z2 = false;
            } else {
                z2 = true;
            }
            e(z2, 128, 6);
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_recommend_mobilefriends_to_me")) {
            if (!((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_mobilefriends_to_me")).isChecked()) {
                z = true;
            }
            e(z, 256, 7);
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_recommend_fbfriends_to_me")) {
            z = ((CheckBoxPreference) this.ehK.aqO("contact_info_recommend_fbfriends_to_me")).isChecked();
            ab.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = 4 functionId = 18");
            int YF = r.YF();
            if (z) {
                YF |= 4;
            } else {
                YF &= -5;
            }
            aw.ZK();
            c.Ry().set(40, Integer.valueOf(YF));
            YF = z ? 1 : 2;
            aw.ZK();
            c.XL().c(new g(18, YF));
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_view_message")) {
            Intent intent = new Intent();
            if (this.pli) {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                ((Activity) this.context).setResult(-1, intent);
                ((Activity) this.context).finish();
            } else {
                intent.putExtra("Chat_User", this.ehM.field_username);
                intent.putExtra("Chat_Mode", 1);
                intent.addFlags(67108864);
                b.gkE.d(intent, this.context);
                ((Activity) this.context).finish();
            }
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_bind_mobile_entry")) {
            b.gkE.f(new Intent(), this.context);
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_bind_qq_entry")) {
            b.gkE.g(new Intent(), this.context);
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_bind_fb_entry")) {
            d.b(this.context, "account", ".ui.FacebookAuthUI", new Intent());
            AppMethodBeat.o(23505);
            return true;
        } else if (str.equals("contact_info_fmessage_clear_data")) {
            h.d(this.context, this.context.getString(R.string.av9), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23502);
                    e eVar = e.this;
                    eVar.isDeleteCancel = false;
                    Context context = eVar.context;
                    eVar.context.getString(R.string.tz);
                    eVar.tipDialog = h.b(context, eVar.context.getString(R.string.un), true, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            e.this.isDeleteCancel = true;
                        }
                    });
                    bf.a("fmessage", new bf.a() {
                        public final boolean JU() {
                            return e.this.isDeleteCancel;
                        }

                        public final void JV() {
                            AppMethodBeat.i(23503);
                            if (e.this.tipDialog != null) {
                                e.this.tipDialog.dismiss();
                                e.this.tipDialog = null;
                            }
                            AppMethodBeat.o(23503);
                        }
                    });
                    aw.ZK();
                    c.XR().aoX("fmessage");
                    AppMethodBeat.o(23502);
                }
            }, null);
            AppMethodBeat.o(23505);
            return true;
        } else {
            ab.e("MicroMsg.ContactWidgetFMessage", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.o(23505);
            return false;
        }
    }

    private void e(boolean z, int i, int i2) {
        AppMethodBeat.i(23506);
        ab.d("MicroMsg.ContactWidgetFMessage", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        aw.ZK();
        c.Ry().set(7, Integer.valueOf(this.status));
        int i3 = z ? 1 : 2;
        aw.ZK();
        c.XL().c(new g(i2, i3));
        AppMethodBeat.o(23506);
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        boolean z3;
        boolean z4 = false;
        AppMethodBeat.i(23507);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(t.nd(adVar.field_username));
        this.ehK = fVar;
        this.pli = z;
        this.ehM = adVar;
        if (this.status == -1) {
            this.status = r.YD();
        }
        fVar.addPreferencesFromResource(R.xml.x);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) fVar.aqO("contact_info_recommend_qqfriends_to_me");
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) fVar.aqO("contact_info_recommend_mobilefriends_to_me");
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) fVar.aqO("contact_info_recommend_fbfriends_to_me");
        if (Be(256)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference2.uOT = z3;
        if (Be(128)) {
            z3 = false;
        } else {
            z3 = true;
        }
        checkBoxPreference.uOT = z3;
        if ((r.YF() & 4) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        checkBoxPreference3.uOT = z3;
        ((HelperHeaderPreference) fVar.aqO("contact_info_header_helper")).a(adVar, this.pmQ);
        aw.ZK();
        if (bo.h((Integer) c.Ry().get(9, null)) != 0) {
            fVar.d(fVar.aqO("contact_info_bind_qq_entry"));
            fVar.d(fVar.aqO("contact_info_bind_qq_entry_tip"));
        } else {
            fVar.d(checkBoxPreference);
            if (!com.tencent.mm.au.b.ahM()) {
                fVar.d(fVar.aqO("contact_info_bind_qq_entry"));
                fVar.d(fVar.aqO("contact_info_bind_qq_entry_tip"));
            }
        }
        if (l.apS() == l.a.SUCC) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            fVar.d(fVar.aqO("contact_info_bind_mobile_entry"));
            fVar.d(fVar.aqO("contact_info_bind_mobile_entry_tip"));
        } else {
            fVar.d(checkBoxPreference2);
            fVar.aqO("contact_info_bind_mobile_entry").setSummary((int) R.string.e61);
        }
        if ((r.YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            z4 = true;
        }
        if (z4) {
            z2 = r.Za();
            com.tencent.mm.au.b.ahN();
            fVar.d(checkBoxPreference3);
            if (z2) {
                fVar.aqO("contact_info_bind_fb_entry").setSummary((int) R.string.avz);
            } else {
                fVar.aqO("contact_info_bind_fb_entry").setSummary((int) R.string.e61);
            }
        } else {
            fVar.d(fVar.aqO("contact_info_bind_fb_entry"));
            fVar.d(fVar.aqO("contact_info_bind_fb_entry_tip"));
            fVar.d(checkBoxPreference3);
        }
        AppMethodBeat.o(23507);
        return true;
    }

    private boolean Be(int i) {
        return (this.status & i) != 0;
    }

    public final boolean biV() {
        AppMethodBeat.i(23508);
        b.gkF.BS();
        this.ehK.aqO("contact_info_header_helper");
        AppMethodBeat.o(23508);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
