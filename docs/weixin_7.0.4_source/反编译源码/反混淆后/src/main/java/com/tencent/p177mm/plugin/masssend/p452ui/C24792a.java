package com.tencent.p177mm.plugin.masssend.p452ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.plugin.masssend.C12490a;
import com.tencent.p177mm.plugin.masssend.p992a.C21270h;
import com.tencent.p177mm.plugin.masssend.p992a.C46069b;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.masssend.ui.a */
public final class C24792a implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private Map<String, Preference> gAX = new HashMap();

    /* renamed from: com.tencent.mm.plugin.masssend.ui.a$1 */
    class C247931 implements OnClickListener {
        C247931() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22754);
            C24792a.clearData();
            AppMethodBeat.m2505o(22754);
        }
    }

    /* renamed from: com.tencent.mm.plugin.masssend.ui.a$2 */
    class C247942 implements OnClickListener {
        C247942() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(22755);
            C24792a.m38727u(C24792a.this.context, false);
            AppMethodBeat.m2505o(22755);
        }
    }

    public C24792a(Context context) {
        AppMethodBeat.m2504i(22758);
        this.context = context;
        AppMethodBeat.m2505o(22758);
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(22759);
        C4990ab.m7410d("MicroMsg.ContactWidgetMassSend", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(22759);
            return false;
        } else if (str.equals("contact_info_masssend_view")) {
            this.context.startActivity(new Intent(this.context, MassSendHistoryUI.class));
            AppMethodBeat.m2505o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_clear_data")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C247931(), null);
            AppMethodBeat.m2505o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_install")) {
            C24792a.m38727u(this.context, true);
            AppMethodBeat.m2505o(22759);
            return true;
        } else if (str.equals("contact_info_masssend_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C247942(), null);
            AppMethodBeat.m2505o(22759);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetMassSend", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(22759);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(22760);
        if ((C1853r.m3829YK() & 65536) == 0) {
            AppMethodBeat.m2505o(22760);
            return true;
        }
        AppMethodBeat.m2505o(22760);
        return false;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(22761);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3940ni(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8485a1);
        biW();
        AppMethodBeat.m2505o(22761);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(22762);
        boolean isOpen = C24792a.isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_masssend_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.axn));
        helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        this.ehK.mo27715ce("contact_info_masssend_install", isOpen);
        C15541f c15541f = this.ehK;
        String str = "contact_info_masssend_view";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_masssend_clear_data";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_masssend_uninstall";
        if (isOpen) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        AppMethodBeat.m2505o(22762);
    }

    /* renamed from: u */
    public static void m38727u(Context context, final boolean z) {
        AppMethodBeat.m2504i(22763);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C247953 c247953 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(22756);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -65537;
                } else {
                    i = YK | 65536;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C24792a.clearData();
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(22756);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(22757);
                if (b != null) {
                    b.dismiss();
                    c247953.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(22757);
            }
        }, 1500);
        AppMethodBeat.m2505o(22763);
    }

    public static void clearData() {
        AppMethodBeat.m2504i(22764);
        C46069b bNE = C21270h.bNE();
        if (bNE.fni.mo10108hY("massendinfo", "delete from massendinfo")) {
            bNE.doNotify();
        }
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX("masssendapp");
        AppMethodBeat.m2505o(22764);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(22765);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C12490a.gkF.mo38844BS();
        AppMethodBeat.m2505o(22765);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(22766);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetMassSend", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetMassSend", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(22766);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(22766);
        } else {
            AppMethodBeat.m2505o(22766);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
