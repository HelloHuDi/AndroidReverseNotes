package com.tencent.p177mm.plugin.profile.p483ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindLinkedInUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C7616ad;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.i */
public final class C28697i implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private C39507a pmY;

    /* renamed from: com.tencent.mm.plugin.profile.ui.i$1 */
    class C286961 implements OnClickListener {
        C286961() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23537);
            C28697i.m45588u(C28697i.this.context, false);
            AppMethodBeat.m2505o(23537);
        }
    }

    public C28697i(Context context) {
        AppMethodBeat.m2504i(23539);
        this.context = context;
        this.pmY = new C21504s(context);
        AppMethodBeat.m2505o(23539);
    }

    private static boolean cba() {
        AppMethodBeat.m2504i(23540);
        if ((C1853r.m3829YK() & 16777216) == 0) {
            AppMethodBeat.m2505o(23540);
            return true;
        }
        AppMethodBeat.m2505o(23540);
        return false;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23541);
        C4990ab.m7410d("MicroMsg.ContactWidgetLinkedIn", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23541);
            return false;
        } else if (str.equals("contact_info_linkedin_install")) {
            C28697i.m45588u(this.context, true);
            AppMethodBeat.m2505o(23541);
            return true;
        } else if (str.equals("contact_info_linkedin_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C286961(), null);
            AppMethodBeat.m2505o(23541);
            return true;
        } else {
            if (str.equals("contact_info_linkedin_account")) {
                ((Activity) this.context).startActivityForResult(new Intent(this.context, BindLinkedInUI.class), 1);
            }
            C4990ab.m7412e("MicroMsg.ContactWidgetLinkedIn", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23541);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(23542);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3952nu(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        biW();
        AppMethodBeat.m2505o(23542);
        return true;
    }

    private void biW() {
        AppMethodBeat.m2504i(23543);
        boolean cba = C28697i.cba();
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(C25738R.xml.f8484a0);
        ((HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper")).mo62462a(this.ehM, this.pmY);
        if (cba) {
            this.ehK.mo27715ce("contact_info_linkedin_account", false);
            this.ehK.aqP("contact_info_linkedin_install");
            AppMethodBeat.m2505o(23543);
            return;
        }
        this.ehK.mo27715ce("contact_info_linkedin_account", true);
        this.ehK.aqP("contact_info_linkedin_uninstall");
        AppMethodBeat.m2505o(23543);
    }

    /* renamed from: u */
    public static void m45588u(Context context, final boolean z) {
        AppMethodBeat.m2504i(23544);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        new C7564ap(new C5015a() {
            final /* synthetic */ C46692p ooo = null;

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(23538);
                if (b != null) {
                    b.dismiss();
                }
                int YK = C1853r.m3829YK();
                if (z) {
                    YK &= -16777217;
                } else {
                    YK |= 16777216;
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286722, (Object) "");
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286721, (Object) "");
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(286723, (Object) "");
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 16777216;
                bko.wNJ = z ? 0 : 1;
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C3465a(39, bko));
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(23538);
                return false;
            }
        }, false).mo16770ae(1500, 1500);
        AppMethodBeat.m2505o(23544);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23545);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        this.ehK.aqO("contact_info_header_helper");
        C39503b.gkF.mo38844BS();
        AppMethodBeat.m2505o(23545);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(23546);
        if (i == 1 && i2 == -1) {
            biW();
        }
        AppMethodBeat.m2505o(23546);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23547);
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            if (intValue == 40 || intValue == 34) {
                biW();
            }
        }
        AppMethodBeat.m2505o(23547);
    }
}
