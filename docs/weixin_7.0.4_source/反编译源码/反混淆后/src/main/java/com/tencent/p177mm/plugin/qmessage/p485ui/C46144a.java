package com.tencent.p177mm.plugin.qmessage.p485ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.widget.Toast;
import com.facebook.appevents.codeless.internal.Constants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.qmessage.p739a.C12873d;
import com.tencent.p177mm.plugin.qmessage.p739a.C46142g;
import com.tencent.p177mm.plugin.qmessage.p739a.C7025b;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.NormalUserHeaderPreference;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashSet;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.qmessage.ui.a */
public final class C46144a implements C1202f, C23233a {
    Context context;
    private ProgressDialog ehJ;
    private C15541f ehK;
    private C7616ad ehM;

    /* renamed from: com.tencent.mm.plugin.qmessage.ui.a$a */
    public final class C43400a {
        private String country;
        private String duc;
        private String dud;
        private String fBg;
        private String psX;
        private String psY;
        private String psZ;

        /* synthetic */ C43400a(C46144a c46144a, byte b) {
            this();
        }

        private C43400a() {
            this.psX = "";
            this.psY = "";
            this.fBg = "";
            this.psZ = "";
            this.country = "";
            this.dud = "";
            this.duc = "";
        }

        public final void parse(String str) {
            AppMethodBeat.m2504i(24098);
            if (C5046bo.nullAsNil(str).length() <= 0) {
                C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "QExtInfoContent : parse xml, but xml is null");
                AppMethodBeat.m2505o(24098);
                return;
            }
            Map z = C5049br.m7595z(str, Constants.EXTINFO);
            if (z != null) {
                this.psX = (String) z.get(".extinfo.sex");
                this.psY = (String) z.get(".extinfo.age");
                this.psZ = (String) z.get(".extinfo.bd");
                this.country = (String) z.get(".extinfo.country");
                this.duc = (String) z.get(".extinfo.province");
                this.dud = (String) z.get(".extinfo.city");
            }
            if (this.psX == null || !this.psX.equals("1")) {
                this.psX = C46144a.this.context.getString(C25738R.string.eds);
            } else {
                this.psX = C46144a.this.context.getString(C25738R.string.edt);
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
            AppMethodBeat.m2505o(24098);
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

    public C46144a(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        return true;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2;
        boolean z3 = false;
        AppMethodBeat.m2504i(24099);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        } else {
            z2 = false;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C7616ad.aow(c7616ad.field_username));
        C9638aw.m17182Rg().mo14539a(140, (C1202f) this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8489a5);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) c15541f.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.vrj = "ContactWidgetQContact";
            normalUserHeaderPreference.mo56681a(c7616ad, 0, null);
        }
        biW();
        C12873d Vb = C46142g.cca().mo55344Vb(this.ehM.field_username);
        if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "getProfileOrNot: QContact is null, should not in this way");
            Vb = new C12873d();
            Vb.username = this.ehM.field_username;
            Vb.bJt = -1;
            C46142g.cca().mo55345a(Vb);
        }
        if (Vb.psK == 1) {
            String str = this.ehM.field_username;
            if (C5046bo.nullAsNil(Vb.cbY()).length() <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (C5046bo.nullAsNil(str).length() > 0) {
                z3 = true;
            }
            Assert.assertTrue(z3);
            HashSet hashSet = new HashSet();
            hashSet.add(str);
            final C7025b c7025b = new C7025b(hashSet);
            new C7306ak().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(24096);
                    C9638aw.m17182Rg().mo14541a(c7025b, 0);
                    AppMethodBeat.m2505o(24096);
                }
            });
            if (z2) {
                Context context = this.context;
                this.context.getString(C25738R.string.f9238tz);
                this.ehJ = C30379h.m48458b(context, this.context.getString(C25738R.string.f9161re), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(24097);
                        C9638aw.m17182Rg().mo14547c(c7025b);
                        AppMethodBeat.m2505o(24097);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(24099);
        return true;
    }

    private void biW() {
        AppMethodBeat.m2504i(24100);
        C12873d Vb = C46142g.cca().mo55344Vb(this.ehM.field_username);
        if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "updateProfile : Qcontact is null");
            AppMethodBeat.m2505o(24100);
            return;
        }
        if (C5046bo.nullAsNil(Vb.cbY()).length() <= 0) {
            C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "updateProfile: QContact extInfo is null");
        }
        Preference aqO = this.ehK.aqO("contact_info_qcontact_sex");
        Preference aqO2 = this.ehK.aqO("contact_info_qcontact_age");
        Preference aqO3 = this.ehK.aqO("contact_info_qcontact_birthday");
        Preference aqO4 = this.ehK.aqO("contact_info_qcontact_address");
        C43400a c43400a = new C43400a(this, (byte) 0);
        c43400a.parse(Vb.cbY());
        if (aqO != null) {
            aqO.setSummary(c43400a.ccd());
        }
        if (aqO2 != null) {
            aqO2.setSummary(c43400a.cce());
        }
        if (aqO3 != null) {
            aqO3.setSummary(c43400a.ccg());
        }
        if (aqO4 != null) {
            aqO4.setSummary(c43400a.ccf());
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.m2505o(24100);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(24101);
        C9638aw.m17182Rg().mo14546b(140, (C1202f) this);
        NormalUserHeaderPreference normalUserHeaderPreference = (NormalUserHeaderPreference) this.ehK.aqO("contact_info_header_normal");
        if (normalUserHeaderPreference != null) {
            normalUserHeaderPreference.onDetach();
        }
        AppMethodBeat.m2505o(24101);
        return true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 1;
        AppMethodBeat.m2504i(24102);
        if (c1207m.getType() != 140) {
            AppMethodBeat.m2505o(24102);
            return;
        }
        if (this.ehJ != null) {
            this.ehJ.dismiss();
            this.ehJ = null;
            switch (i) {
                case 1:
                    if (C1947ae.ghN) {
                        Toast.makeText(this.context, this.context.getString(C25738R.string.bx8, new Object[]{Integer.valueOf(1), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                        break;
                    }
                case 2:
                    if (C1947ae.ghN) {
                        Toast.makeText(this.context, this.context.getString(C25738R.string.bx9, new Object[]{Integer.valueOf(2), Integer.valueOf(i2)}), AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS).show();
                        break;
                    }
                default:
                    i3 = 0;
                    break;
            }
            if (i3 != 0) {
                AppMethodBeat.m2505o(24102);
                return;
            }
        }
        if (i == 0 && i2 == 0) {
            C12873d Vb = C46142g.cca().mo55344Vb(this.ehM.field_username);
            if (Vb == null || C5046bo.nullAsNil(Vb.getUsername()).length() <= 0) {
                C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: did not find this QContact, username = " + this.ehM.field_username);
            } else {
                Vb.bJt = 8;
                Vb.psK = 0;
                if (!C46142g.cca().mo55346a(this.ehM.field_username, Vb)) {
                    C4990ab.m7412e("MicroMsg.ContactWidgetQContact", "resetUpdateStatus: update Qcontact failed, username = " + this.ehM.field_username);
                }
            }
            biW();
        }
        AppMethodBeat.m2505o(24102);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
