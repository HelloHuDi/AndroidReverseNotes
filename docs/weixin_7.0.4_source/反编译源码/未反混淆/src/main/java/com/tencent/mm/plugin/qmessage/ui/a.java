package com.tencent.mm.plugin.qmessage.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.qmessage.a.b;
import com.tencent.mm.plugin.qmessage.a.d;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.ui.preference.NormalUserHeaderPreference;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

public final class a implements f, com.tencent.mm.pluginsdk.b.a {
    Context context;
    private ProgressDialog ehJ;
    private com.tencent.mm.ui.base.preference.f ehK;
    private ad ehM;

    public final class a {
        private String country;
        private String duc;
        private String dud;
        private String fBg;
        private String psX;
        private String psY;
        private String psZ;

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        private a() {
            this.psX = "";
            this.psY = "";
            this.fBg = "";
            this.psZ = "";
            this.country = "";
            this.dud = "";
            this.duc = "";
        }

        public final void parse(String str) {
            AppMethodBeat.i(24098);
            if (bo.nullAsNil(str).length() <= 0) {
                ab.e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
                AppMethodBeat.o(24098);
                return;
            }
            Map z = br.z(str, Constants.EXTINFO);
            if (z != null) {
                this.psX = (String) z.get(".extinfo.sex");
                this.psY = (String) z.get(".extinfo.age");
                this.psZ = (String) z.get(".extinfo.bd");
                this.country = (String) z.get(".extinfo.country");
                this.duc = (String) z.get(".extinfo.province");
                this.dud = (String) z.get(".extinfo.city");
            }
            if (this.psX == null || !this.psX.equals("1")) {
                this.psX = a.this.context.getString(R.string.eds);
            } else {
                this.psX = a.this.context.getString(R.string.edt);
            }
            if (this.country != null) {
                this.fBg += this.country + " ";
            }
            if (this.duc != null) {
                this.fBg += this.duc + " ";
            }
            if (this.dud != null) {
                this.fBg += this.dud;
            }
            AppMethodBeat.o(24098);
        }

        public final String ccd() {
            return this.psX == null ? "" : this.psX;
        }

        public final String cce() {
            return this.psY == null ? "" : this.psY;
        }

        public final String ccf() {
            return this.fBg == null ? "" : this.fBg;
        }

        public final String ccg() {
            return this.psZ == null ? "" : this.psZ;
        }
    }

    public a(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        return true;
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, ad adVar, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.i(24099);
        Assert.assertTrue(fVar != null);
        if (adVar != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(ad.aow(adVar.field_username));
        aw.Rg().a(140, (f) this);
        this.ehM = adVar;
        this.ehK = fVar;
        fVar.addPreferencesFromResource(R.xml.a5);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) fVar.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.vrj = "ContactWidgetQContact";
            normalUserHeaderPreference.a(adVar, 0, null);
        }
        biW();
        d Vb = g.cca().Vb(this.ehM.field_username);
        if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
            ab.e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            Vb = new d();
            Vb.username = this.ehM.field_username;
            Vb.bJt = -1;
            g.cca().a(Vb);
        }
        if (Vb.psK == 1) {
            String str = this.ehM.field_username;
            if (bo.nullAsNil(Vb.cbY()).length() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (bo.nullAsNil(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            HashSet hashSet = new HashSet();
            hashSet.add(str);
            final b bVar = new b(hashSet);
            new ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(24096);
                    aw.Rg().a(bVar, 0);
                    AppMethodBeat.o(24096);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(R.string.tz);
                this.ehJ = h.b(context, this.context.getString(R.string.re), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(24097);
                        aw.Rg().c(bVar);
                        AppMethodBeat.o(24097);
                    }
                });
            }
        }
        AppMethodBeat.o(24099);
        return true;
    }

    private void biW() {
        AppMethodBeat.i(24100);
        d Vb = g.cca().Vb(this.ehM.field_username);
        if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
            ab.e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            AppMethodBeat.o(24100);
            return;
        }
        if (bo.nullAsNil(Vb.cbY()).length() <= 0) {
            ab.e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference aqO = this.ehK.aqO("contact_info_qcontact_sex");
        Preference aqO2 = this.ehK.aqO("contact_info_qcontact_age");
        Preference aqO3 = this.ehK.aqO("contact_info_qcontact_birthday");
        Preference aqO4 = this.ehK.aqO("contact_info_qcontact_address");
        a aVar = new a(this, (byte) 0);
        aVar.parse(Vb.cbY());
        if (aqO != null) {
            aqO.setSummary(aVar.ccd());
        }
        if (aqO2 != null) {
            aqO2.setSummary(aVar.cce());
        }
        if (aqO3 != null) {
            aqO3.setSummary(aVar.ccg());
        }
        if (aqO4 != null) {
            aqO4.setSummary(aVar.ccf());
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(24100);
    }

    public final boolean biV() {
        AppMethodBeat.i(24101);
        aw.Rg().b(140, (f) this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        AppMethodBeat.o(24101);
        return true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 1;
        AppMethodBeat.i(24102);
        if (mVar.getType() != 140) {
            AppMethodBeat.o(24102);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
            switch (i) {
                case 1:
                    if (ae.ghN) {
                        Toast.makeText(this.context, this.context.getString(R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                        break;
                    }
                case 2:
                    if (ae.ghN) {
                        Toast.makeText(this.context, this.context.getString(R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                        break;
                    }
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                AppMethodBeat.o(24102);
                return;
            }
        }
        if (i == 0 && i2 == 0) {
            d Vb = g.cca().Vb(this.ehM.field_username);
            if (Vb == null || bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                ab.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.ehM.field_username);
            } else {
                Vb.bJt = 8;
                Vb.psK = 0;
                if (!g.cca().a(this.ehM.field_username, Vb)) {
                    ab.e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.ehM.field_username);
                }
            }
            biW();
        }
        AppMethodBeat.o(24102);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
