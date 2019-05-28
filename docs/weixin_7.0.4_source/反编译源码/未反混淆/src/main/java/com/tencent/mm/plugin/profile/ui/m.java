package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bv;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.net.URI;
import java.net.URL;

public final class m implements a, b {
    Context context;
    private f ehK;
    private ad ehM;
    private boolean enable;

    public m(Context context) {
        this.context = context;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23595);
        if (bo.nullAsNil(str).length() <= 0) {
            AppMethodBeat.o(23595);
            return false;
        } else if ("contact_info_go_to_sync".equals(str)) {
            if (p.u(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(268435456);
                this.context.startActivity(launchIntentForPackage);
            } else {
                h.a(this.context, (int) R.string.az1, (int) R.string.tz, (int) R.string.p_, (int) R.string.or, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(23592);
                        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
                        if (g.cdf == 1) {
                            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(268435456);
                            if (bo.k(m.this.context, addFlags)) {
                                m.this.context.startActivity(addFlags);
                                AppMethodBeat.o(23592);
                                return;
                            }
                            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
                        }
                        try {
                            URL url = new URL(str);
                            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                            e.a aVar = new e.a();
                            aVar.Iv("qqpim.apk");
                            aVar.It(toURL.toString());
                            aVar.ga(true);
                            aVar.tN(1);
                            d.bij().a(aVar.kNl);
                            AppMethodBeat.o(23592);
                        } catch (Exception e) {
                            ab.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", e.toString());
                            AppMethodBeat.o(23592);
                        }
                    }
                }, null);
            }
            AppMethodBeat.o(23595);
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            String str2;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.ehK.aqO("contact_info_remind_me_syncing");
            aw.ZK();
            c.Ry().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            if (checkBoxPreference.isChecked()) {
                str2 = "1";
            } else {
                str2 = "2";
            }
            bv.s(6, str2);
            AppMethodBeat.o(23595);
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            s(this.context, true);
            AppMethodBeat.o(23595);
            return true;
        } else if (str.equals("contact_info_qqsync_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23591);
                    m.this.s(m.this.context, false);
                    AppMethodBeat.o(23591);
                }
            }, null);
            AppMethodBeat.o(23595);
            return true;
        } else {
            AppMethodBeat.o(23595);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void s(Context context, final boolean z) {
        AppMethodBeat.i(23596);
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final com.tencent.mm.ui.base.p b = h.b(context, string, true, null);
        aw.RS().aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(23594);
                boolean z = z;
                bv.s(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
                int YK = r.YK();
                if (z) {
                    i = YK & -129;
                } else {
                    i = YK | 128;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    bf.oD("qqsync");
                    aw.ZK();
                    c.XR().aoX("qqsync");
                }
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(23593);
                        b.dismiss();
                        AppMethodBeat.o(23593);
                    }
                });
                AppMethodBeat.o(23594);
            }
        });
        AppMethodBeat.o(23596);
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(23597);
        aw.ZK();
        c.Ry().a(this);
        this.ehK = fVar;
        this.ehM = adVar;
        fVar.addPreferencesFromResource(R.xml.a9);
        biW();
        AppMethodBeat.o(23597);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.i(23598);
        aw.ZK();
        c.Ry().b(this);
        AppMethodBeat.o(23598);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23599);
        if (this.enable != r.YU()) {
            biW();
        }
        AppMethodBeat.o(23599);
    }

    private void biW() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(23600);
        this.enable = r.YU();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.az3));
        helperHeaderPreference.sd(this.enable ? 1 : 0);
        f fVar = this.ehK;
        String str = "contact_info_go_to_sync";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        fVar = this.ehK;
        str = "contact_info_remind_me_syncing_tip";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        fVar.ce(str, z);
        this.ehK.ce("contact_info_qqsync_install", this.enable);
        f fVar2 = this.ehK;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.enable) {
            z2 = false;
        }
        fVar2.ce(str2, z2);
        AppMethodBeat.o(23600);
    }
}
