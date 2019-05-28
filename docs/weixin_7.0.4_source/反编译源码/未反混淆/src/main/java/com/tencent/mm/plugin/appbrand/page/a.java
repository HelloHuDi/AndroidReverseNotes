package com.tencent.mm.plugin.appbrand.page;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.a.f;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class a extends f {
    private static final a iqA = new a() {
        public final Context getContext() {
            AppMethodBeat.i(87022);
            Context context = ah.getContext();
            AppMethodBeat.o(87022);
            return context;
        }

        public final com.tencent.mm.plugin.appbrand.page.a.c.a a(a aVar) {
            return ivi;
        }
    };
    private static final HashMap<i, a> iqB = new HashMap();
    private final i hrt;
    private Drawable iqC;
    private CharSequence iqD;

    public enum a {
        NORMAL(-1, -1),
        LBS(R.string.cu5, R.drawable.avt),
        VOICE(R.string.cu6, R.drawable.avv),
        VIDEO(-1, R.drawable.avu),
        LOADING(-1, -1);
        
        final int iqK;
        final int iqL;

        static {
            AppMethodBeat.o(87026);
        }

        private a(int i, int i2) {
            this.iqK = i;
            this.iqL = i2;
        }
    }

    /* synthetic */ a() {
        this(null);
    }

    static void b(u uVar) {
        AppMethodBeat.i(87027);
        a z = z(uVar.getRuntime());
        a(z.iqC, uVar);
        a(z.iqD, uVar);
        AppMethodBeat.o(87027);
    }

    public static a z(i iVar) {
        AppMethodBeat.i(87028);
        a aVar;
        if (iVar == null || iVar.mFinished) {
            aVar = iqA;
            AppMethodBeat.o(87028);
            return aVar;
        }
        aVar = (a) iqB.get(iVar);
        if (aVar == null) {
            aVar = new a(iVar);
            iqB.put(iVar, aVar);
        }
        AppMethodBeat.o(87028);
        return aVar;
    }

    static {
        AppMethodBeat.i(87036);
        AppMethodBeat.o(87036);
    }

    private a(final i iVar) {
        AppMethodBeat.i(87029);
        this.hrt = iVar;
        if (iVar == null) {
            AppMethodBeat.o(87029);
            return;
        }
        g.a(iVar.mAppId, new c() {
            public final void onDestroy() {
                AppMethodBeat.i(87023);
                a aVar = (a) a.iqB.remove(iVar);
                if (aVar != null) {
                    aVar.ivn.clear();
                }
                AppMethodBeat.o(87023);
            }
        });
        AppMethodBeat.o(87029);
    }

    public Context getContext() {
        AppMethodBeat.i(87030);
        Activity context = this.hrt.getContext();
        AppMethodBeat.o(87030);
        return context;
    }

    public final void q(Drawable drawable) {
        AppMethodBeat.i(87031);
        this.iqC = drawable;
        a(this.iqC, this.hrt.xT().getCurrentPageView());
        AppMethodBeat.o(87031);
    }

    private static void a(Drawable drawable, u uVar) {
        AppMethodBeat.i(87032);
        if (uVar == null) {
            AppMethodBeat.o(87032);
            return;
        }
        uVar.getActionBar().getCapsuleBar().aKh().setLogo(drawable);
        AppMethodBeat.o(87032);
    }

    public final void y(CharSequence charSequence) {
        AppMethodBeat.i(87033);
        this.iqD = charSequence;
        a(this.iqD, this.hrt.xT().getCurrentPageView());
        AppMethodBeat.o(87033);
    }

    private static void a(CharSequence charSequence, u uVar) {
        AppMethodBeat.i(87034);
        if (uVar == null) {
            AppMethodBeat.o(87034);
            return;
        }
        uVar.z(charSequence);
        AppMethodBeat.o(87034);
    }

    public com.tencent.mm.plugin.appbrand.page.a.c.a a(a aVar) {
        AppMethodBeat.i(87035);
        int i = aVar.iqK;
        int i2 = aVar.iqL;
        com.tencent.mm.plugin.appbrand.page.a.c.a aKh = super.aKh();
        aKh.setLogo(i2);
        aKh.pE(i);
        AppMethodBeat.o(87035);
        return aKh;
    }
}
