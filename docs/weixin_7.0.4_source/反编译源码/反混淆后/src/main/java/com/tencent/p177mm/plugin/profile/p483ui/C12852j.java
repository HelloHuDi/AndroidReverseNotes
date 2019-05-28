package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1829bf.C1827a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p201az.C9064g;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.j */
public final class C12852j implements C23233a, C4937b {
    private static boolean isDeleteCancel = false;
    private Context context;
    private C15541f ehK;
    private C7616ad ehM;

    /* renamed from: com.tencent.mm.plugin.profile.ui.j$1 */
    class C36331 implements OnClickListener {
        C36331() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23548);
            C39503b.gkE.mo38921g(new Intent(), C12852j.this.context);
            AppMethodBeat.m2505o(23548);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.j$6 */
    static class C128546 implements OnCancelListener {
        C128546() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(23553);
            C12852j.isDeleteCancel = true;
            AppMethodBeat.m2505o(23553);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.j$2 */
    class C128552 implements OnClickListener {
        C128552() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23549);
            C12852j.m20847eI(C12852j.this.context);
            AppMethodBeat.m2505o(23549);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.j$3 */
    class C128563 implements OnClickListener {
        C128563() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23550);
            C12852j.m20849u(C12852j.this.context, false);
            AppMethodBeat.m2505o(23550);
        }
    }

    public C12852j(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23556);
        C4990ab.m7410d("MicroMsg.ContactWidgetMediaNote", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23556);
            return false;
        } else if (str.equals("contact_info_medianote_view")) {
            Intent intent = new Intent();
            intent.putExtra("Chat_User", "medianote");
            C39503b.gkE.mo38915d(intent, this.context);
            C39503b.gkF.mo38844BS();
            AppMethodBeat.m2505o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_sync_to_qqmail")) {
            if (C1853r.m3851Ze()) {
                C12852j.m20848jQ(((CheckBoxPreference) this.ehK.aqO(str)).isChecked());
            } else {
                C30379h.m48432a(this.context, (int) C25738R.string.axq, (int) C25738R.string.axp, new C36331(), null);
                biW();
            }
            AppMethodBeat.m2505o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_clear_data")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C128552(), null);
            AppMethodBeat.m2505o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_install")) {
            C12852j.m20849u(this.context, true);
            AppMethodBeat.m2505o(23556);
            return true;
        } else if (str.equals("contact_info_medianote_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C128563(), null);
            AppMethodBeat.m2505o(23556);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetMediaNote", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23556);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(23557);
        if ((C1853r.m3829YK() & 16) == 0) {
            AppMethodBeat.m2505o(23557);
            return true;
        }
        AppMethodBeat.m2505o(23557);
        return false;
    }

    private static boolean cbb() {
        AppMethodBeat.m2504i(23558);
        int YD = C1853r.m3822YD();
        if (!C1853r.m3851Ze()) {
            if ((YD & 16384) != 0) {
                YD &= -16385;
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(7, Integer.valueOf(YD));
            }
            AppMethodBeat.m2505o(23558);
            return false;
        } else if ((YD & 16384) != 0) {
            AppMethodBeat.m2505o(23558);
            return true;
        } else {
            AppMethodBeat.m2505o(23558);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(23559);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3946no(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8486a2);
        biW();
        AppMethodBeat.m2505o(23559);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(23560);
        boolean isOpen = C12852j.isOpen();
        boolean cbb = C12852j.cbb();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.axr));
        helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        this.ehK.mo27715ce("contact_info_medianote_install", isOpen);
        C15541f c15541f = this.ehK;
        String str = "contact_info_medianote_view";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        if (!isOpen || C1853r.m3851Ze()) {
            z = isOpen;
        } else {
            if (C5046bo.getInt(C26373g.m41964Nu().getValue("BindQQSwitch"), 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7416i("MicroMsg.ContactWidgetMediaNote", "summerqq BindQQSwitch off");
        }
        c15541f = this.ehK;
        str = "contact_info_medianote_sync_to_qqmail";
        if (z) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_medianote_clear_data";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_medianote_uninstall";
        if (isOpen) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        ((CheckBoxPreference) this.ehK.aqO("contact_info_medianote_sync_to_qqmail")).uOT = cbb;
        AppMethodBeat.m2505o(23560);
    }

    /* renamed from: u */
    public static void m20849u(final Context context, final boolean z) {
        AppMethodBeat.m2504i(23561);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C128574 c128574 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(23551);
                if (z) {
                    C12852j.m20848jQ(true);
                }
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -17;
                } else {
                    i = YK | 16;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C12852j.m20847eI(context);
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(23551);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(23552);
                if (b != null) {
                    b.dismiss();
                    c128574.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(23552);
            }
        }, 1500);
        AppMethodBeat.m2505o(23561);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23562);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C39503b.gkF.mo38844BS();
        AppMethodBeat.m2505o(23562);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23563);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetMediaNote", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetMediaNote", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(23563);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(23563);
        } else {
            AppMethodBeat.m2505o(23563);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* renamed from: jQ */
    static void m20848jQ(boolean z) {
        AppMethodBeat.m2504i(23564);
        int YD = C1853r.m3822YD();
        if (z) {
            YD |= 16384;
        } else {
            YD &= -16385;
        }
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(7, Integer.valueOf(YD));
        YD = z ? 1 : 2;
        C9638aw.m17190ZK();
        C18628c.m29077XL().mo7920c(new C9064g(13, YD));
        AppMethodBeat.m2505o(23564);
    }

    /* renamed from: eI */
    static /* synthetic */ void m20847eI(Context context) {
        AppMethodBeat.m2504i(23565);
        isDeleteCancel = false;
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, context.getString(C25738R.string.f9260un), true, new C128546());
        C1829bf.m3741a("medianote", new C1827a() {
            /* renamed from: JU */
            public final boolean mo5405JU() {
                AppMethodBeat.m2504i(23554);
                boolean access$200 = C12852j.isDeleteCancel;
                AppMethodBeat.m2505o(23554);
                return access$200;
            }

            /* renamed from: JV */
            public final void mo5406JV() {
                AppMethodBeat.m2504i(23555);
                if (b != null) {
                    b.dismiss();
                }
                AppMethodBeat.m2505o(23555);
            }
        });
        C9638aw.m17190ZK();
        C18628c.m29083XR().aoX("medianote");
        AppMethodBeat.m2505o(23565);
    }
}
