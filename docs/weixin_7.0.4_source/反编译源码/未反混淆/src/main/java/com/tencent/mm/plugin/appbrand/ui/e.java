package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.weishi.b;
import com.tencent.mm.sdk.platformtools.ah;

public final class e {
    private static final a<i, Bitmap> iGV = new a();

    public static q a(Context context, o oVar) {
        AppMethodBeat.i(132989);
        if (context == null) {
            context = ah.getContext();
        }
        l lVar = new l(context);
        Bitmap bitmap = (Bitmap) iGV.remove(oVar);
        q bVar;
        if (bitmap != null && !bitmap.isRecycled()) {
            g gVar = new g(lVar, oVar, bitmap);
            AppMethodBeat.o(132989);
            return gVar;
        } else if (com.tencent.mm.plugin.appbrand.weishi.e.E(oVar)) {
            bVar = new b(lVar, oVar);
            AppMethodBeat.o(132989);
            return bVar;
        } else if (i.D(oVar)) {
            bVar = new f(lVar, oVar);
            AppMethodBeat.o(132989);
            return bVar;
        } else if (oVar.xy()) {
            bVar = new c(lVar, oVar);
            AppMethodBeat.o(132989);
            return bVar;
        } else {
            bVar = new j(lVar, oVar);
            AppMethodBeat.o(132989);
            return bVar;
        }
    }

    static {
        AppMethodBeat.i(132991);
        AppMethodBeat.o(132991);
    }

    public static void a(i iVar, Bitmap bitmap) {
        AppMethodBeat.i(132990);
        if (iVar == null || bitmap == null || bitmap.isRecycled()) {
            AppMethodBeat.o(132990);
            return;
        }
        iGV.put(iVar, bitmap);
        AppMethodBeat.o(132990);
    }
}
