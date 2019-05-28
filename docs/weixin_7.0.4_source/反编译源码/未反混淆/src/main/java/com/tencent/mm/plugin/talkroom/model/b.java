package com.tencent.mm.plugin.talkroom.model;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.bg.g;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.network.n;
import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

public final class b implements at {
    private n qbK = new a() {
        public final void gl(int i) {
            AppMethodBeat.i(25756);
            if (i != 4) {
                AppMethodBeat.o(25756);
                return;
            }
            new ak(Looper.getMainLooper()).post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(25755);
                    if (b.this.sxI != null) {
                        b.this.sxI.mb(false);
                    }
                    AppMethodBeat.o(25755);
                }
            });
            AppMethodBeat.o(25756);
        }
    };
    g sxI;
    private d sxJ = new d();
    public c sxK = new c();
    private e sxL;
    f sxM;

    public b() {
        AppMethodBeat.i(25757);
        AppMethodBeat.o(25757);
    }

    public static b cEg() {
        AppMethodBeat.i(25758);
        aw.ZE();
        b bVar = (b) bw.oJ("plugin.talkroom");
        if (bVar == null) {
            bVar = new b();
            aw.ZE().a("plugin.talkroom", bVar);
        }
        AppMethodBeat.o(25758);
        return bVar;
    }

    public static g cEh() {
        AppMethodBeat.i(25759);
        if (cEg().sxI == null) {
            cEg().sxI = new g();
        }
        g gVar = cEg().sxI;
        AppMethodBeat.o(25759);
        return gVar;
    }

    public static e cEi() {
        AppMethodBeat.i(25760);
        if (cEg().sxL == null) {
            cEg().sxL = new e();
        }
        e eVar = cEg().sxL;
        AppMethodBeat.o(25760);
        return eVar;
    }

    public static String cEj() {
        AppMethodBeat.i(25761);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.Rt()).append("talkroom/").toString();
        AppMethodBeat.o(25761);
        return stringBuilder2;
    }

    public static f cEk() {
        AppMethodBeat.i(25762);
        if (cEg().sxM == null) {
            cEg().sxM = new f();
        }
        f fVar = cEg().sxM;
        AppMethodBeat.o(25762);
        return fVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(25763);
        e.d.a(Integer.valueOf(56), this.sxJ);
        aw.a(this.qbK);
        g.fUs = cEi();
        g.fUt = cEh();
        AppMethodBeat.o(25763);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(25764);
        e.d.b(Integer.valueOf(56), this.sxJ);
        aw.b(this.qbK);
        g.fUs = null;
        g.fUt = null;
        if (this.sxI != null) {
            this.sxI.cEw();
            this.sxI = null;
        }
        AppMethodBeat.o(25764);
    }
}
