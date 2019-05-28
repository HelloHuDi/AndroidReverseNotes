package com.tencent.p177mm.plugin.profile.p483ui;

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
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.profile.C39503b;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import java.util.Timer;
import java.util.TimerTask;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.plugin.profile.ui.n */
public final class C46138n implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;

    /* renamed from: com.tencent.mm.plugin.profile.ui.n$1 */
    class C286991 implements OnClickListener {
        C286991() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23601);
            C46138n.m86109u(C46138n.this.context, false);
            AppMethodBeat.m2505o(23601);
        }
    }

    public C46138n(Context context) {
        this.context = context;
    }

    private static boolean cba() {
        AppMethodBeat.m2504i(23604);
        if ((C1853r.m3829YK() & 33554432) == 0) {
            AppMethodBeat.m2505o(23604);
            return true;
        }
        AppMethodBeat.m2505o(23604);
        return false;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23605);
        C4990ab.m7410d("MicroMsg.ContactWidgetVoiceInput", "handleEvent : key = ".concat(String.valueOf(str)));
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23605);
            return false;
        } else if (str.equals("contact_info_voiceinput_install")) {
            C46138n.m86109u(this.context, true);
            AppMethodBeat.m2505o(23605);
            return true;
        } else if (str.equals("contact_info_voiceinput_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C286991(), null);
            AppMethodBeat.m2505o(23605);
            return true;
        } else {
            C4990ab.m7412e("MicroMsg.ContactWidgetVoiceInput", "handleEvent : unExpected key = ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(23605);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        boolean z2 = false;
        AppMethodBeat.m2504i(23606);
        Assert.assertTrue(c15541f != null);
        if (c7616ad != null) {
            z2 = true;
        }
        Assert.assertTrue(z2);
        Assert.assertTrue(C1855t.m3951nt(c7616ad.field_username));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehM = c7616ad;
        this.ehK = c15541f;
        c15541f.addPreferencesFromResource(C25738R.xml.f8497af);
        biW();
        AppMethodBeat.m2505o(23606);
        return true;
    }

    private void biW() {
        boolean z = true;
        AppMethodBeat.m2504i(23607);
        boolean cba = C46138n.cba();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.b27));
        helperHeaderPreference.mo74732sd(cba ? 1 : 0);
        this.ehK.mo27715ce("contact_info_voiceinput_install", cba);
        C15541f c15541f = this.ehK;
        String str = "contact_info_voiceinput_uninstall";
        if (cba) {
            z = false;
        }
        c15541f.mo27715ce(str, z);
        AppMethodBeat.m2505o(23607);
    }

    /* renamed from: u */
    public static void m86109u(Context context, final boolean z) {
        AppMethodBeat.m2504i(23608);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        final C214912 c214912 = new C7306ak() {
            final /* synthetic */ C46692p ooo = null;

            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(23602);
                int YK = C1853r.m3829YK();
                if (z) {
                    YK &= -33554433;
                } else {
                    YK |= 33554432;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 33554432;
                bko.wNJ = z ? 0 : 1;
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C3465a(39, bko));
                if (this.ooo != null) {
                    this.ooo.mo5248a(null, null);
                }
                AppMethodBeat.m2505o(23602);
            }
        };
        new Timer().schedule(new TimerTask() {
            public final void run() {
                AppMethodBeat.m2504i(23603);
                if (b != null) {
                    b.dismiss();
                    c214912.sendEmptyMessage(0);
                }
                AppMethodBeat.m2505o(23603);
            }
        }, 1500);
        AppMethodBeat.m2505o(23608);
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23609);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        C39503b.gkF.mo38844BS();
        AppMethodBeat.m2505o(23609);
        return true;
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23610);
        int g = C5046bo.m7550g(obj, 0);
        C4990ab.m7411d("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i), Integer.valueOf(g), c7298n);
        C9638aw.m17190ZK();
        if (c7298n != C18628c.m29072Ry() || g <= 0) {
            C4990ab.m7413e("MicroMsg.ContactWidgetVoiceInput", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(g), c7298n);
            AppMethodBeat.m2505o(23610);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(23610);
        } else {
            AppMethodBeat.m2505o(23610);
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }
}
