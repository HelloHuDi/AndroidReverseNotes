package com.tencent.p177mm.plugin.topstory.p541ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.CheckBoxPreference;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C3464j.C3465a;
import com.tencent.p177mm.plugin.topstory.p541ui.C4210c;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p597ui.preference.HelperHeaderPreference;
import com.tencent.p177mm.protocal.protobuf.act;
import com.tencent.p177mm.protocal.protobuf.bko;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.C7617ak;

/* renamed from: com.tencent.mm.plugin.topstory.ui.widget.a */
public final class C40001a implements C23233a, C4937b {
    private Context context;
    private C15541f ehK;
    private C7616ad ehM;
    private CheckBoxPreference kRm;

    /* renamed from: com.tencent.mm.plugin.topstory.ui.widget.a$1 */
    class C400021 implements OnClickListener {
        C400021() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(2219);
            C40001a.this.mo63236jX(false);
            AppMethodBeat.m2505o(2219);
        }
    }

    public C40001a(Context context) {
        this.context = context;
    }

    /* renamed from: a */
    public final boolean mo7078a(C15541f c15541f, C7616ad c7616ad, boolean z, int i) {
        AppMethodBeat.m2504i(2220);
        this.ehK = c15541f;
        this.ehM = c7616ad;
        c15541f.addPreferencesFromResource(C25738R.xml.f8496ae);
        C1720g.m3536RP().mo5239Ry().mo10118a(this);
        this.kRm = (CheckBoxPreference) c15541f.aqO("contact_info_top_story_not_disturb");
        biW();
        AppMethodBeat.m2505o(2220);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.m2504i(2221);
        C1720g.m3536RP().mo5239Ry().mo10121b(this);
        AppMethodBeat.m2505o(2221);
        return true;
    }

    /* renamed from: IO */
    public final boolean mo7077IO(String str) {
        AppMethodBeat.m2504i(2222);
        if ("contact_info_go_to_top_story".equals(str)) {
            C4210c.m6554W(this.context, 0);
        } else if ("contact_info_top_story_install".equals(str)) {
            mo63236jX(true);
        } else if ("contact_info_top_story_uninstall".equals(str)) {
            C30379h.m48466d(this.context, this.context.getString(C25738R.string.e_g), "", this.context.getString(C25738R.string.f9078ou), this.context.getString(C25738R.string.f9076or), new C400021(), null);
        } else if ("contact_info_top_story_not_disturb".equals(str)) {
            int YF = C1853r.m3824YF();
            if (this.kRm.isChecked()) {
                YF &= -16777217;
            } else {
                YF |= 16777216;
            }
            C1720g.m3536RP().mo5239Ry().set(40, Integer.valueOf(YF));
            act act = new act();
            act.wkw = 55;
            if (this.kRm.isChecked()) {
                YF = 2;
            } else {
                YF = 1;
            }
            act.pvD = YF;
            ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(55, act));
        }
        AppMethodBeat.m2505o(2222);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jX */
    public final void mo63236jX(boolean z) {
        AppMethodBeat.m2504i(2223);
        int YK = C1853r.m3829YK();
        if (z) {
            YK &= -67108865;
        } else {
            YK |= 67108864;
        }
        C1720g.m3536RP().mo5239Ry().set(34, Integer.valueOf(YK));
        bko bko = new bko();
        bko.vCi = 67108864;
        bko.wNJ = z ? 0 : 1;
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15368XL().mo7920c(new C3465a(39, bko));
        biW();
        if (z) {
            if (((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoZ("topstoryapp") == null) {
                C7617ak c7617ak = new C7617ak();
                c7617ak.setUsername("topstoryapp");
                c7617ak.setContent(this.context.getString(C25738R.string.g6o));
                c7617ak.mo14742eD(C5046bo.anU());
                c7617ak.mo14750hO(0);
                c7617ak.mo14748hM(0);
                ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().mo15807d(c7617ak);
            }
            AppMethodBeat.m2505o(2223);
            return;
        }
        ((C6982j) C1720g.m3528K(C6982j.class)).mo15371XR().aoX("topstoryapp");
        AppMethodBeat.m2505o(2223);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private void biW() {
        int i;
        AppMethodBeat.m2504i(2224);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.mo74731ay(this.ehM.field_username, this.ehM.mo16707Oj(), this.context.getString(C25738R.string.g6o));
        if ((C1853r.m3829YK() & 67108864) == 0) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            helperHeaderPreference.mo74732sd(1);
            this.ehK.mo27715ce("contact_info_top_story_install", true);
            this.ehK.mo27715ce("contact_info_top_story_uninstall", false);
            this.ehK.mo27715ce("contact_info_go_to_top_story", false);
            this.ehK.mo27715ce("contact_info_top_story_not_disturb", false);
        } else {
            helperHeaderPreference.mo74732sd(0);
            this.ehK.mo27715ce("contact_info_top_story_install", false);
            this.ehK.mo27715ce("contact_info_top_story_uninstall", true);
            this.ehK.mo27715ce("contact_info_go_to_top_story", true);
            this.ehK.mo27715ce("contact_info_top_story_not_disturb", true);
        }
        if (C40001a.cHr()) {
            this.kRm.uOT = true;
            AppMethodBeat.m2505o(2224);
            return;
        }
        this.kRm.uOT = false;
        AppMethodBeat.m2505o(2224);
    }

    /* renamed from: a */
    public final void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(2225);
        int g = C5046bo.m7550g(obj, 0);
        if (c7298n != C1720g.m3536RP().mo5239Ry() || g <= 0) {
            AppMethodBeat.m2505o(2225);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.m2505o(2225);
        } else {
            AppMethodBeat.m2505o(2225);
        }
    }

    private static boolean cHr() {
        AppMethodBeat.m2504i(2226);
        if ((C1853r.m3824YF() & 16777216) == 0) {
            AppMethodBeat.m2505o(2226);
            return true;
        }
        AppMethodBeat.m2505o(2226);
        return false;
    }
}
