package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C37907bv;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p201az.C6335k;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.pluginsdk.model.app.C35799p;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URI;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.profile.ui.m */
public final class C39526m implements C23233a, C4937b {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private boolean enable;

    /* renamed from: com.tencent.mm.plugin.profile.ui.m$2 */
    class C214882 implements OnClickListener {
        C214882() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23592);
            String str = "http://tools.3g.qq.com/j/wechatandriodpim";
            if (C5059g.cdf == 1) {
                Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
                if (C5046bo.m7572k(C39526m.this.context, addFlags)) {
                    C39526m.this.context.startActivity(addFlags);
                    AppMethodBeat.m2505o(23592);
                    return;
                }
                str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
            }
            try {
                URL url = new URL(str);
                URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                C2901a c2901a = new C2901a();
                c2901a.mo7057Iv("qqpim.apk");
                c2901a.mo7055It(toURL.toString());
                c2901a.mo7063ga(true);
                c2901a.mo7069tN(1);
                C2896d.bij().mo7042a(c2901a.kNl);
                AppMethodBeat.m2505o(23592);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", e.toString());
                AppMethodBeat.m2505o(23592);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.m$1 */
    class C286981 implements OnClickListener {
        C286981() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(23591);
            C39526m.this.mo62486s(C39526m.this.context, false);
            AppMethodBeat.m2505o(23591);
        }
    }

    public C39526m(Context context) {
        this.context = context;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(23595);
        if (C5046bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.m2505o(23595);
            return false;
        } else if ("contact_info_go_to_sync".equals(str)) {
            if (C35799p.m58695u(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(268435456);
                this.context.startActivity(launchIntentForPackage);
            } else {
                C30379h.m48428a(this.context, (int) C25738R.string.az1, (int) C25738R.string.f9238tz, (int) C25738R.string.f9093p_, (int) C25738R.string.f9076or, new C214882(), null);
            }
            AppMethodBeat.m2505o(23595);
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            String str2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_remind_me_syncing");
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            if (checkBoxPreference.isChecked()) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            C37907bv.m64020s(6, str2);
            AppMethodBeat.m2505o(23595);
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            mo62486s(this.context, true);
            AppMethodBeat.m2505o(23595);
            return true;
        } else if (str.equals("contact_info_qqsync_uninstall")) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C286981(), null);
            AppMethodBeat.m2505o(23595);
            return true;
        } else {
            AppMethodBeat.m2505o(23595);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final void mo62486s(Context context, final boolean z) {
        AppMethodBeat.m2504i(23596);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        C9638aw.m17180RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.profile.ui.m$3$1 */
            class C214901 implements Runnable {
                C214901() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(23593);
                    b.dismiss();
                    AppMethodBeat.m2505o(23593);
                }
            }

            public final void run() {
                int i;
                AppMethodBeat.m2504i(23594);
                boolean z = z;
                C37907bv.m64020s(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
                int YK = C1853r.m3829YK();
                if (z) {
                    i = YK & -129;
                } else {
                    i = YK | 128;
                }
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(34, Integer.valueOf(i));
                C9638aw.m17190ZK();
                C18628c.m29077XL().mo7920c(new C6335k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    C1829bf.m3757oD("qqsync");
                    C9638aw.m17190ZK();
                    C18628c.m29083XR().aoX("qqsync");
                }
                C5004al.m7441d(new C214901());
                AppMethodBeat.m2505o(23594);
            }
        });
        AppMethodBeat.m2505o(23596);
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(23597);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10118a(this);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        c15541f.addPreferencesFromResource(C25738R.xml.f8492a9);
        biW();
        AppMethodBeat.m2505o(23597);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(23598);
        C9638aw.m17190ZK();
        C18628c.m29072Ry().mo10121b(this);
        AppMethodBeat.m2505o(23598);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(23599);
        if (this.enable != C1853r.m3839YU()) {
            biW();
        }
        AppMethodBeat.m2505o(23599);
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(23600);
        this.enable = C1853r.m3839YU();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.az3));
        helperHeaderPreference.mo74732sd(this.enable ? 1 : 0);
        C15541f c15541f = this.ehK;
        String str = "contact_info_go_to_sync";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_remind_me_syncing_tip";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        this.ehK.mo27715ce("contact_info_qqsync_install", this.enable);
        C15541f c15541f2 = this.ehK;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.enable) {
            z2 = false;
        }
        c15541f2.mo27715ce(str2, z2);
        AppMethodBeat.m2505o(23600);
    }
}
