package com.tencent.p177mm.plugin.shake.p511ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1815as;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.plugin.shake.C46193a;
import com.tencent.p177mm.plugin.shake.p1019b.C28987m;
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

/* renamed from: com.tencent.mm.plugin.shake.ui.a */
public final class C13297a implements C1815as, C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;

    /* renamed from: com.tencent.mm.plugin.shake.ui.a$1 */
    class C132981 implements OnClickListener {
        C132981() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(24689);
            C13297a.m21362u(C13297a.this.context, false);
            AppMethodBeat.m2505o(24689);
        }
    }

    public C13297a(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(24692);
        C4990ab.m7410d("MicroMsg.ContactWidgetShake", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(24692);
            return false;
        } else if (str.equals("contact_info_shake_go_shake")) {
            Intent intent = new Intent();
            intent.setClass(this.context, ShakeReportUI.class);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
            AppMethodBeat.m2505o(24692);
            return true;
        } else if (str.equals("contact_info_shake_install")) {
            C13297a.m21362u(this.context, true);
            AppMethodBeat.m2505o(24692);
            return true;
        } else if (str.equals("contact_info_shake_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C132981(), null);
            AppMethodBeat.m2505o(24692);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetShake", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(24692);
            return false;
        }
    }

    private static boolean isOpen() {
        AppMethodBeat.m2504i(24693);
        if ((C1853r.m3829YK() & 256) == 0) {
            AppMethodBeat.m2505o(24693);
            return true;
        }
        AppMethodBeat.m2505o(24693);
        return false;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(24694);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3945nn(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        C9638aw.m17190ZK();
        C18628c.m29103a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8494ab);
        biW();
        AppMethodBeat.m2505o(24694);
        return true;
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(24695);
        boolean isOpen = C13297a.isOpen();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        if (helperHeaderPreference != null) {
            helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.b0_));
            helperHeaderPreference.mo74732sd(isOpen ? 1 : 0);
        }
        this.ehK.mo27715ce("contact_info_shake_install", isOpen);
        C15541f c15541f = this.ehK;
        String str = "contact_info_shake_go_shake";
        if (isOpen) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_shake_uninstall";
        if (isOpen) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        AppMethodBeat.m2505o(24695);
    }

    /* renamed from: u */
    public static void m21362u(Context context, final boolean z) {
        AppMethodBeat.m2504i(24696);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C133002 c133002 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                int i;
                AppMethodBeat.m2504i(24690);
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -257;
                } else {
                    i = YK | 256;
                }
                C4990ab.m7417i("MicroMsg.ContactWidgetShake", "setInstall pluginFlag install:%b  pluginFlag : %d -> %d", Boolean.valueOf(z), Integer.valueOf(YK), Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C28987m.cjV();
                }
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(24690);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(24691);
                if (b != null) {
                    b.dismiss();
                    c133002.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(24691);
            }
        }, 1500);
        AppMethodBeat.m2505o(24696);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(24697);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C9638aw.m17190ZK();
        C18628c.m29104b(this);
        C46193a.gkF.mo38844BS();
        AppMethodBeat.m2505o(24697);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* renamed from: ZB */
    public final void mo5390ZB() {
        AppMethodBeat.m2504i(24698);
        biW();
        AppMethodBeat.m2505o(24698);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(24699);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetShake", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetShake", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(24699);
        } else if (g == 7 || g == 34) {
            biW();
            AppMethodBeat.m2505o(24699);
        } else {
            AppMethodBeat.m2505o(24699);
        }
    }
}
