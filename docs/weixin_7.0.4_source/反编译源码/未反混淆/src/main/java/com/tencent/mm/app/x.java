package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.i;
import com.tencent.mm.audio.a.a;
import com.tencent.mm.ba.k;
import com.tencent.mm.ba.r;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelmulti.n;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.e.q;
import com.tencent.mm.protocal.protobuf.bbv;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.tools.b;
import com.tencent.mm.ui.u;

final class x implements i, h, j, m {
    x() {
    }

    public final void BS() {
        AppMethodBeat.i(15424);
        n.ahW().lN(7);
        AppMethodBeat.o(15424);
    }

    public final void gk(int i) {
        AppMethodBeat.i(15425);
        ab.d("MicroMsg.WorkerModelCallback", "trigger netscene sync, scene[%d]", Integer.valueOf(i));
        n.ahW().lN(i);
        AppMethodBeat.o(15425);
    }

    public final com.tencent.mm.ai.h BT() {
        AppMethodBeat.i(15426);
        a aVar = new a(ah.getContext());
        AppMethodBeat.o(15426);
        return aVar;
    }

    public final String t(String str, int i) {
        AppMethodBeat.i(15427);
        String str2;
        if (g.dX(str, i) != null) {
            str2 = g.dX(str, i).field_packageName;
            AppMethodBeat.o(15427);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(15427);
        return str2;
    }

    public final String df(String str) {
        AppMethodBeat.i(15428);
        String str2;
        if (g.bT(str, false) != null) {
            str2 = g.bT(str, false).field_packageName;
            AppMethodBeat.o(15428);
            return str2;
        }
        str2 = "";
        AppMethodBeat.o(15428);
        return str2;
    }

    public final String t(Context context, String str) {
        AppMethodBeat.i(15429);
        String t = g.t(context, str);
        AppMethodBeat.o(15429);
        return t;
    }

    public final boolean dg(String str) {
        AppMethodBeat.i(15430);
        boolean dg = g.dg(str);
        AppMethodBeat.o(15430);
        return dg;
    }

    public final boolean u(Context context, String str) {
        AppMethodBeat.i(15431);
        boolean u = g.u(context, str);
        AppMethodBeat.o(15431);
        return u;
    }

    public final String f(Context context, String str, String str2) {
        AppMethodBeat.i(15432);
        String f = p.f(context, str, str2);
        AppMethodBeat.o(15432);
        return f;
    }

    public final String B(String str, String str2) {
        AppMethodBeat.i(15433);
        String B = p.B(str, str2);
        AppMethodBeat.o(15433);
        return B;
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5) {
        AppMethodBeat.i(15434);
        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
        if (bDb != null) {
            bDb.a(context, str, str2, str3, i, i2, i3, str4, str5, "");
        }
        AppMethodBeat.o(15434);
    }

    public final void a(String str, String str2, String str3, long j) {
        AppMethodBeat.i(15435);
        com.tencent.mm.plugin.game.a.a bDb = com.tencent.mm.plugin.game.a.a.a.bDb();
        if (bDb != null) {
            bDb.a(str, str2, 2, 4, str3, j, "");
        }
        AppMethodBeat.o(15435);
    }

    public final void BU() {
        AppMethodBeat.i(15436);
        ta taVar = new ta();
        taVar.cPk.cPm = true;
        com.tencent.mm.sdk.b.a.xxA.m(taVar);
        AppMethodBeat.o(15436);
    }

    public final com.tencent.mm.ai.m bj(boolean z) {
        AppMethodBeat.i(15437);
        if (z) {
            r.aix().lT(4);
        }
        com.tencent.mm.ai.m kVar = new k(4);
        aw.Rg().a(kVar, 0);
        AppMethodBeat.o(15437);
        return kVar;
    }

    public final boolean dk(String str) {
        AppMethodBeat.i(15438);
        boolean dk = g.dk(str);
        AppMethodBeat.o(15438);
        return dk;
    }

    public final boolean a(Context context, int i, int i2, String str) {
        AppMethodBeat.i(15439);
        boolean a = u.a.a(context, i, i2, str, 4);
        AppMethodBeat.o(15439);
        return a;
    }

    public final boolean b(Context context, int i, int i2, String str) {
        AppMethodBeat.i(15440);
        boolean a = u.a.a(context, i, i2, str, 7);
        AppMethodBeat.o(15440);
        return a;
    }

    public final void BV() {
        AppMethodBeat.i(15441);
        MMAppMgr.BV();
        AppMethodBeat.o(15441);
    }

    public final boolean o(Activity activity) {
        AppMethodBeat.i(15442);
        if (f.Mn()) {
            com.tencent.mm.pluginsdk.ui.tools.n.k(activity, 2);
            AppMethodBeat.o(15442);
            return true;
        }
        t.hO(activity);
        AppMethodBeat.o(15442);
        return false;
    }

    public final void bc(Context context) {
        AppMethodBeat.i(15443);
        MMAppMgr.hs(context);
        AppMethodBeat.o(15443);
    }

    public final void p(Activity activity) {
        AppMethodBeat.i(15444);
        MMAppMgr.ar(activity);
        AppMethodBeat.o(15444);
    }

    public final Bitmap a(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.i(15445);
        if (i2 != -1) {
            AppMethodBeat.o(15445);
            return null;
        }
        String h;
        switch (i) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(15445);
                    return null;
                }
                Intent intent2 = new Intent();
                intent2.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_OutputPath", e.euY + "temp.avatar");
                intent2.putExtra("CropImage_ImgPath", null);
                com.tencent.mm.ui.tools.a.a(activity, intent, intent2, e.euY, 4);
                AppMethodBeat.o(15445);
                return null;
            case 3:
                h = com.tencent.mm.pluginsdk.ui.tools.n.h(activity.getApplicationContext(), intent, e.euY);
                if (h == null) {
                    AppMethodBeat.o(15445);
                    return null;
                }
                Intent intent3 = new Intent();
                intent3.setClassName(activity, "com.tencent.mm.ui.tools.CropImageNewUI");
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", e.euY + "temp.avatar");
                intent3.putExtra("CropImage_ImgPath", h);
                activity.startActivityForResult(intent3, 4);
                AppMethodBeat.o(15445);
                return null;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(15445);
                    return null;
                }
                h = intent.getStringExtra("CropImage_OutputPath");
                if (h == null) {
                    ab.e("MicroMsg.WorkerModelCallback", "crop picture failed");
                    break;
                }
                ab.e("MicroMsg.WorkerModelCallback", "crop picture path %s ", h);
                Bitmap aml = d.aml(h);
                AppMethodBeat.o(15445);
                return aml;
        }
        AppMethodBeat.o(15445);
        return null;
    }

    public final Intent BW() {
        AppMethodBeat.i(15446);
        Intent intent = new Intent(ah.getContext(), LauncherUI.class);
        intent.putExtra("nofification_type", "talkroom_notification");
        intent.addFlags(67108864);
        AppMethodBeat.o(15446);
        return intent;
    }

    public final com.tencent.mm.ai.m a(com.tencent.mm.ai.g gVar) {
        AppMethodBeat.i(15447);
        if (com.tencent.mm.modelmulti.k.ahT()) {
            com.tencent.mm.modelmulti.e eVar = new com.tencent.mm.modelmulti.e(gVar);
            AppMethodBeat.o(15447);
            return eVar;
        }
        n.ahW().lN(4);
        AppMethodBeat.o(15447);
        return null;
    }

    public final boolean a(ad adVar) {
        AppMethodBeat.i(15448);
        boolean a = com.tencent.mm.modelmulti.a.a(adVar);
        AppMethodBeat.o(15448);
        return a;
    }

    public final void a(com.tencent.mm.aj.d dVar, Activity activity, ad adVar, boolean z, Runnable runnable) {
        AppMethodBeat.i(15449);
        b.a(dVar, activity, adVar, z, runnable, 0);
        AppMethodBeat.o(15449);
    }

    public final void a(com.tencent.mm.aj.d dVar, Activity activity, ad adVar) {
        AppMethodBeat.i(15450);
        b.c(dVar, activity, adVar);
        AppMethodBeat.o(15450);
    }

    public final boolean BX() {
        AppMethodBeat.i(15451);
        boolean BX = q.BX();
        AppMethodBeat.o(15451);
        return BX;
    }

    public final void BY() {
        AppMethodBeat.i(15453);
        com.tencent.mm.booter.n.BY();
        AppMethodBeat.o(15453);
    }

    public final void a(Context context, bi.a aVar, Bundle bundle) {
        AppMethodBeat.i(15454);
        com.tencent.mm.ui.contact.e.a(context, aVar, true, true, bundle);
        AppMethodBeat.o(15454);
    }

    public final void a(Context context, ad adVar, bi.a aVar, Bundle bundle, String str) {
        AppMethodBeat.i(15455);
        com.tencent.mm.ui.contact.e.a(context, adVar, aVar, true, true, bundle, str);
        AppMethodBeat.o(15455);
    }

    public final void a(Intent intent, String str) {
        AppMethodBeat.i(15456);
        com.tencent.mm.ui.contact.e.a(intent, str);
        AppMethodBeat.o(15456);
    }

    public final void dl(String str) {
        AppMethodBeat.i(15457);
        com.tencent.mm.aq.b.agG();
        com.tencent.mm.aq.b.rX(str);
        AppMethodBeat.o(15457);
    }

    public final void a(bbv bbv, String str) {
        AppMethodBeat.i(15458);
        ((com.tencent.mm.plugin.messenger.foundation.a.d) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.d.class)).a(bbv, str);
        AppMethodBeat.o(15458);
    }

    public final boolean BZ() {
        AppMethodBeat.i(15459);
        boolean ahT = com.tencent.mm.modelmulti.k.ahT();
        AppMethodBeat.o(15459);
        return ahT;
    }

    public final void a(Intent intent, buv buv, int i) {
        AppMethodBeat.i(15452);
        com.tencent.mm.api.b.a(intent, buv, i);
        AppMethodBeat.o(15452);
    }
}
