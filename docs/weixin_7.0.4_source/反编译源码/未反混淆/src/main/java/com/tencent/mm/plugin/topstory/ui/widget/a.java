package com.tencent.mm.plugin.topstory.ui.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.topstory.ui.c;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.protocal.protobuf.act;
import com.tencent.mm.protocal.protobuf.bko;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;

public final class a implements com.tencent.mm.pluginsdk.b.a, b {
    private Context context;
    private f ehK;
    private ad ehM;
    private CheckBoxPreference kRm;

    public a(Context context) {
        this.context = context;
    }

    public final boolean a(f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(2220);
        this.ehK = fVar;
        this.ehM = adVar;
        fVar.addPreferencesFromResource(R.xml.ae);
        g.RP().Ry().a(this);
        this.kRm = (CheckBoxPreference) fVar.aqO("contact_info_top_story_not_disturb");
        biW();
        AppMethodBeat.o(2220);
        return true;
    }

    public final boolean biV() {
        AppMethodBeat.i(2221);
        g.RP().Ry().b(this);
        AppMethodBeat.o(2221);
        return true;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(2222);
        if ("contact_info_go_to_top_story".equals(str)) {
            c.W(this.context, 0);
        } else if ("contact_info_top_story_install".equals(str)) {
            jX(true);
        } else if ("contact_info_top_story_uninstall".equals(str)) {
            h.d(this.context, this.context.getString(R.string.e_g), "", this.context.getString(R.string.ou), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(2219);
                    a.this.jX(false);
                    AppMethodBeat.o(2219);
                }
            }, null);
        } else if ("contact_info_top_story_not_disturb".equals(str)) {
            int YF = r.YF();
            if (this.kRm.isChecked()) {
                YF &= -16777217;
            } else {
                YF |= 16777216;
            }
            g.RP().Ry().set(40, Integer.valueOf(YF));
            act act = new act();
            act.wkw = 55;
            if (this.kRm.isChecked()) {
                YF = 2;
            } else {
                YF = 1;
            }
            act.pvD = YF;
            ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(55, act));
        }
        AppMethodBeat.o(2222);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void jX(boolean z) {
        AppMethodBeat.i(2223);
        int YK = r.YK();
        if (z) {
            YK &= -67108865;
        } else {
            YK |= 67108864;
        }
        g.RP().Ry().set(34, Integer.valueOf(YK));
        bko bko = new bko();
        bko.vCi = 67108864;
        bko.wNJ = z ? 0 : 1;
        ((j) g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(39, bko));
        biW();
        if (z) {
            if (((j) g.K(j.class)).XR().aoZ("topstoryapp") == null) {
                ak akVar = new ak();
                akVar.setUsername("topstoryapp");
                akVar.setContent(this.context.getString(R.string.g6o));
                akVar.eD(bo.anU());
                akVar.hO(0);
                akVar.hM(0);
                ((j) g.K(j.class)).XR().d(akVar);
            }
            AppMethodBeat.o(2223);
            return;
        }
        ((j) g.K(j.class)).XR().aoX("topstoryapp");
        AppMethodBeat.o(2223);
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    private void biW() {
        int i;
        AppMethodBeat.i(2224);
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.ehK.aqO("contact_info_header_helper");
        helperHeaderPreference.ay(this.ehM.field_username, this.ehM.Oj(), this.context.getString(R.string.g6o));
        if ((r.YK() & 67108864) == 0) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 != 0) {
            helperHeaderPreference.sd(1);
            this.ehK.ce("contact_info_top_story_install", true);
            this.ehK.ce("contact_info_top_story_uninstall", false);
            this.ehK.ce("contact_info_go_to_top_story", false);
            this.ehK.ce("contact_info_top_story_not_disturb", false);
        } else {
            helperHeaderPreference.sd(0);
            this.ehK.ce("contact_info_top_story_install", false);
            this.ehK.ce("contact_info_top_story_uninstall", true);
            this.ehK.ce("contact_info_go_to_top_story", true);
            this.ehK.ce("contact_info_top_story_not_disturb", true);
        }
        if (cHr()) {
            this.kRm.uOT = true;
            AppMethodBeat.o(2224);
            return;
        }
        this.kRm.uOT = false;
        AppMethodBeat.o(2224);
    }

    public final void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(2225);
        int g = bo.g(obj, 0);
        if (nVar != g.RP().Ry() || g <= 0) {
            AppMethodBeat.o(2225);
        } else if (g == 40 || g == 34 || g == 7) {
            biW();
            AppMethodBeat.o(2225);
        } else {
            AppMethodBeat.o(2225);
        }
    }

    private static boolean cHr() {
        AppMethodBeat.i(2226);
        if ((r.YF() & 16777216) == 0) {
            AppMethodBeat.o(2226);
            return true;
        }
        AppMethodBeat.o(2226);
        return false;
    }
}
