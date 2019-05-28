package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.az.k;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.ic;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.preference.f;

public final class g extends l implements b {
    public final /* bridge */ /* synthetic */ void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(23531);
        super.a(i, nVar, obj);
        AppMethodBeat.o(23531);
    }

    public final /* bridge */ /* synthetic */ boolean a(f fVar, ad adVar, boolean z, int i) {
        AppMethodBeat.i(23530);
        boolean a = super.a(fVar, adVar, z, i);
        AppMethodBeat.o(23530);
        return a;
    }

    public final /* bridge */ /* synthetic */ boolean biV() {
        AppMethodBeat.i(23529);
        boolean biV = super.biV();
        AppMethodBeat.o(23529);
        return biV;
    }

    public final /* bridge */ /* synthetic */ void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(23528);
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(23528);
    }

    public g(Context context) {
        super(context, new r(context));
        AppMethodBeat.i(23522);
        a.xxA.m(new ic());
        AppMethodBeat.o(23522);
    }

    public static void clearData() {
        AppMethodBeat.i(23523);
        aw.ZK();
        c.XO().Rh("feedsapp");
        aw.ZK();
        c.XR().aoX("feedsapp");
        AppMethodBeat.o(23523);
    }

    /* Access modifiers changed, original: protected|final */
    public final void clear() {
        AppMethodBeat.i(23524);
        clearData();
        AppMethodBeat.o(23524);
    }

    /* Access modifiers changed, original: protected|final */
    public final void jP(final boolean z) {
        AppMethodBeat.i(23525);
        Context context = this.context;
        String string = z ? context.getString(R.string.e_c) : context.getString(R.string.e_k);
        context.getString(R.string.tz);
        final p b = h.b(context, string, true, null);
        new ap(new ap.a() {
            final /* synthetic */ com.tencent.mm.ui.p ooo = null;

            public final boolean BI() {
                int i;
                AppMethodBeat.i(23520);
                int YK = r.YK();
                if (z) {
                    i = YK & -32769;
                } else {
                    i = YK | 32768;
                }
                aw.ZK();
                c.Ry().set(34, Integer.valueOf(i));
                aw.ZK();
                c.XL().c(new k("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    g.clearData();
                }
                if (this.ooo != null) {
                    this.ooo.a(null, null);
                }
                if (b != null) {
                    b.dismiss();
                }
                AppMethodBeat.o(23520);
                return true;
            }
        }, false).ae(1500, 1500);
        AppMethodBeat.o(23525);
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean caZ() {
        AppMethodBeat.i(23526);
        if ((r.YK() & 32768) == 0) {
            AppMethodBeat.o(23526);
            return true;
        }
        AppMethodBeat.o(23526);
        return false;
    }

    public final boolean IO(String str) {
        AppMethodBeat.i(23527);
        Intent intent;
        if ("contact_info_plugin_view".equals(str)) {
            intent = new Intent();
            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
            d.b(this.context, "sns", ".ui.SnsTimeLineUI", intent);
            AppMethodBeat.o(23527);
            return true;
        }
        if ("contact_info_plugin_outsize".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4);
            d.b(this.context, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if ("contact_info_plugin_black".equals(str)) {
            intent = new Intent();
            intent.putExtra("k_sns_tag_id", 5);
            d.b(this.context, "sns", ".ui.SnsTagDetailUI", intent);
        }
        if (str.equals("contact_info_plugin_uninstall")) {
            h.d(this.context, this.context.getString(R.string.e_h), "", this.context.getString(R.string.tw), this.context.getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(23521);
                    g.this.jP(false);
                    AppMethodBeat.o(23521);
                }
            }, null);
            AppMethodBeat.o(23527);
            return true;
        }
        boolean IO = super.IO(str);
        AppMethodBeat.o(23527);
        return IO;
    }
}
