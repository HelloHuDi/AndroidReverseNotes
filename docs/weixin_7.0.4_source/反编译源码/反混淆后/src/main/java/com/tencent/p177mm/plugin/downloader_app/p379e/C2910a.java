package com.tencent.p177mm.plugin.downloader_app.p379e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C32798u;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.downloader_app.e.a */
public final class C2910a implements C23233a {
    Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private boolean enable;
    private CheckBoxPreference kRl;
    private CheckBoxPreference kRm;

    /* renamed from: com.tencent.mm.plugin.downloader_app.e.a$2 */
    class C29112 implements OnClickListener {
        C29112() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136317);
            C1720g.m3528K(C38855d.class);
            C2910a.this.mo7082s(C2910a.this.context, false);
            AppMethodBeat.m2505o(136317);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.e.a$4 */
    class C29124 implements OnClickListener {
        C29124() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136319);
            C1720g.m3528K(C38855d.class);
            C2910a.this.mo7082s(C2910a.this.context, false);
            AppMethodBeat.m2505o(136319);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.e.a$3 */
    class C29133 implements OnClickListener {
        C29133() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136318);
            ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(C2910a.this.context, null, null);
            AppMethodBeat.m2505o(136318);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.e.a$1 */
    class C29161 implements OnClickListener {
        C29161() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(136316);
            C1829bf.m3757oD("downloaderapp");
            AppMethodBeat.m2505o(136316);
        }
    }

    public C2910a(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(136322);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        c15541f.addPreferencesFromResource(C25738R.xml.f8479u);
        this.kRl = (CheckBoxPreference) c15541f.aqO("contact_info_top_downloader");
        this.kRm = (CheckBoxPreference) c15541f.aqO("contact_info_not_disturb");
        biW();
        AppMethodBeat.m2505o(136322);
        return true;
    }

    public final boolean biV() {
        return true;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(136323);
        Intent intent;
        if ("contact_info_go_to_downloader".equals(str)) {
            intent = new Intent();
            intent.putExtra("Chat_User", this.ehM.field_username);
            intent.putExtra("finish_direct", true);
            C25985d.m41473f(this.context, ".ui.chatting.ChattingUI", intent);
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_downloader_manager".equals(str)) {
            ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(this.context, null, null);
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_common_problem".equals(str)) {
            intent = new Intent();
            intent.putExtra("KPublisherId", "custom_menu");
            intent.putExtra("pre_username", this.ehM.field_username);
            intent.putExtra("prePublishId", "custom_menu");
            intent.putExtra("preUsername", this.ehM.field_username);
            intent.putExtra("preChatName", this.ehM.field_username);
            intent.putExtra("preChatTYPE", C32798u.m53583ad(this.ehM.field_username, this.ehM.field_username));
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=wechat_movement_faq/index");
            intent.putExtra("geta8key_username", this.ehM.field_username);
            intent.putExtra("from_scence", 1);
            C25985d.m41467b(this.context, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_top_downloader".equals(str)) {
            if (this.kRl.isChecked()) {
                C1855t.m3967w(this.ehM.field_username, true);
            } else {
                C1855t.m3969x(this.ehM.field_username, true);
            }
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_not_disturb".equals(str)) {
            if (this.kRm.isChecked()) {
                C1855t.m3958o(this.ehM);
            } else {
                C1855t.m3959p(this.ehM);
            }
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_clear_data".equals(str)) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.av9), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C29161(), null);
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_downloader_install".equals(str)) {
            mo7082s(this.context, true);
            AppMethodBeat.m2505o(136323);
            return true;
        } else if ("contact_info_downloader_uninstall".equals(str)) {
            if (((C38855d) C1720g.m3528K(C38855d.class)).bix()) {
                C30379h.m48466d(this.context, this.context.getString(C25738R.string.b7t), this.context.getString(C25738R.string.b7u), this.context.getString(C25738R.string.b7s), this.context.getString(C25738R.string.b7e), new C29112(), new C29133());
            } else {
                C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C29124(), null);
            }
            AppMethodBeat.m2505o(136323);
            return true;
        } else {
            AppMethodBeat.m2505o(136323);
            return false;
        }
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    /* Access modifiers changed, original: final */
    public final void biW() {
        boolean z;
        AppMethodBeat.m2504i(136324);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.b79));
        this.enable = C1853r.m3844YZ();
        helperHeaderPreference.mo74732sd(this.enable ? 1 : 0);
        this.ehK.mo27715ce("contact_info_downloader_install", this.enable);
        C15541f c15541f = this.ehK;
        String str = "contact_info_downloader_uninstall";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_go_to_downloader";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_downloader_manager";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        this.ehK.mo27715ce("contact_info_common_problem", true);
        c15541f = this.ehK;
        str = "contact_info_top_downloader";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_not_disturb";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        c15541f = this.ehK;
        str = "contact_info_clear_data";
        if (this.enable) {
            z = false;
        } else {
            z = true;
        }
        c15541f.mo27715ce(str, z);
        if (this.enable) {
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aph(this.ehM.field_username)) {
                this.kRl.uOT = true;
            } else {
                this.kRl.uOT = false;
            }
            if (this.ehM.mo16673DX()) {
                this.kRm.uOT = true;
                AppMethodBeat.m2505o(136324);
                return;
            }
            this.kRm.uOT = false;
        }
        AppMethodBeat.m2505o(136324);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final void mo7082s(final Context context, final boolean z) {
        AppMethodBeat.m2504i(136325);
        String string = z ? context.getString(C25738R.string.e_c) : context.getString(C25738R.string.e_k);
        context.getString(C25738R.string.f9238tz);
        final C44275p b = C30379h.m48458b(context, string, true, null);
        C1720g.m3539RS().mo10302aa(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.downloader_app.e.a$5$1 */
            class C29151 implements Runnable {
                C29151() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(136320);
                    C2910a.this.biW();
                    b.dismiss();
                    if (z) {
                        ((C38855d) C1720g.m3528K(C38855d.class)).biy();
                        Bundle bundleExtra = ((Activity) context).getIntent().getBundleExtra("download_params");
                        if (bundleExtra != null) {
                            ((C38855d) C1720g.m3528K(C38855d.class)).mo61727a(context, new Intent().putExtras(bundleExtra), null);
                        }
                    }
                    AppMethodBeat.m2505o(136320);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(136321);
                boolean z = z;
                int YK = C1853r.m3829YK();
                if (z) {
                    YK &= -134217729;
                } else {
                    YK |= 134217728;
                }
                C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
                bko bko = new bko();
                bko.vCi = 134217728;
                bko.wNJ = z ? 0 : 1;
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
                if (!z) {
                    C1829bf.m3757oD("downloaderapp");
                    ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("downloaderapp");
                }
                C5004al.m7442n(new C29151(), 1000);
                AppMethodBeat.m2505o(136321);
            }
        });
        AppMethodBeat.m2505o(136325);
    }
}
