package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.o;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.ex;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bf.a;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;

public final class b {
    private static boolean isDeleteCancel = false;
    private static p tipDialog = null;

    public static void a(d dVar, Activity activity, ad adVar, int i) {
        AppMethodBeat.i(34789);
        a(dVar, activity, adVar, false, null, i);
        AppMethodBeat.o(34789);
    }

    public static void a(d dVar, Activity activity, ad adVar, boolean z, Runnable runnable, int i) {
        AppMethodBeat.i(34790);
        if (dVar == null || activity == null || adVar == null) {
            String str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "bizInfo null : %s, context null : %s, ct null : %s";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(dVar == null);
            objArr[1] = Boolean.valueOf(activity == null);
            objArr[2] = Boolean.valueOf(adVar == null);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(34790);
            return;
        }
        String string;
        if (dVar.adQ()) {
            string = activity.getString(R.string.ab_);
        } else {
            string = activity.getString(R.string.aba, new Object[]{adVar.Oj()});
        }
        final d dVar2 = dVar;
        final Activity activity2 = activity;
        final ad adVar2 = adVar;
        final boolean z2 = z;
        final int i2 = i;
        final Runnable runnable2 = runnable;
        h.a((Context) activity, string, "", activity.getString(R.string.azm), activity.getString(R.string.azl), (OnClickListener) new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(34785);
                b.a(dVar2, activity2, adVar2, z2, i2);
                if (runnable2 != null) {
                    runnable2.run();
                }
                AppMethodBeat.o(34785);
            }
        }, null, (int) R.color.xy);
        AppMethodBeat.o(34790);
    }

    public static void c(d dVar, Activity activity, ad adVar) {
        AppMethodBeat.i(34791);
        a(dVar, activity, adVar, false, 0);
        AppMethodBeat.o(34791);
    }

    public static void a(final d dVar, Activity activity, ad adVar, boolean z, int i) {
        boolean z2 = true;
        AppMethodBeat.i(34792);
        String str;
        if (dVar == null || activity == null || adVar == null) {
            boolean z3;
            str = "MicroMsg.BizContactDeleteUtil";
            String str2 = "error args, %b, %b, %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(dVar == null);
            if (activity == null) {
                z3 = true;
            } else {
                z3 = false;
            }
            objArr[1] = Boolean.valueOf(z3);
            if (adVar != null) {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            ab.e(str, str2, objArr);
            AppMethodBeat.o(34792);
            return;
        }
        str = adVar.field_username;
        adVar.NC();
        aw.ZK();
        c.XL().c(new com.tencent.mm.az.c(str, i));
        if (t.mW(str)) {
            ((j) g.K(j.class)).XM().aoU(str);
            aw.ZK();
            c.XV().og(str);
        } else {
            isDeleteCancel = false;
            activity.getString(R.string.tz);
            tipDialog = h.b((Context) activity, activity.getString(R.string.un), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(34786);
                    b.isDeleteCancel = true;
                    AppMethodBeat.o(34786);
                }
            });
            a anonymousClass3 = new a() {
                public final boolean JU() {
                    AppMethodBeat.i(34787);
                    boolean access$000 = b.isDeleteCancel;
                    AppMethodBeat.o(34787);
                    return access$000;
                }

                public final void JV() {
                    AppMethodBeat.i(34788);
                    if (dVar.adN()) {
                        g.K(o.class);
                        com.tencent.mm.storage.p.aok(str);
                        ah ahVar = new ah();
                        ahVar.ctf.userName = str;
                        com.tencent.mm.sdk.b.a.xxA.m(ahVar);
                    }
                    z.aeR().delete(str);
                    if (b.tipDialog != null) {
                        b.tipDialog.dismiss();
                        b.tipDialog = null;
                    }
                    AppMethodBeat.o(34788);
                }
            };
            z.afd();
            com.tencent.mm.aj.a.qz(str);
            ((j) g.K(j.class)).XM().b(str, adVar);
            if (dVar.adP()) {
                f.rf(dVar.field_username);
            } else {
                bf.a(str, anonymousClass3);
                aw.ZK();
                c.XR().aoX(str);
            }
            if (activity != null && z) {
                activity.setResult(-1, activity.getIntent().putExtra("_delete_ok_", true));
            }
        }
        if (com.tencent.mm.app.plugin.a.a.a(dVar)) {
            ex exVar = new ex();
            exVar.cyr.cwz = str;
            com.tencent.mm.sdk.b.a.xxA.m(exVar);
        }
        z.aeQ().ri(str);
        z.aeX().QS(str);
        z.aeY().QS(str);
        if (z) {
            int intExtra = activity.getIntent().getIntExtra("Kdel_from", -1);
            Intent intent;
            if (intExtra == 0) {
                intent = new Intent(activity, LauncherUI.class);
                intent.addFlags(67108864);
                activity.startActivity(intent);
            } else if (intExtra == 2) {
                intent = new Intent();
                intent.addFlags(67108864);
                com.tencent.mm.bp.d.b((Context) activity, "brandservice", ".ui.BrandServiceIndexUI", intent);
            }
            activity.finish();
        }
        AppMethodBeat.o(34792);
    }
}
