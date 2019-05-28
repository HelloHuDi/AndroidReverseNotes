package com.tencent.mm.kernel.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.a.b;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.kernel.j;
import junit.framework.Assert;

public final class a {
    public static long eKO;
    public static long eKP;
    public static long eKQ;
    public b eKM;
    public b eKN;
    private volatile boolean mConfigured = false;

    public final void a(b bVar) {
        AppMethodBeat.i(123273);
        Assert.assertNotNull(bVar);
        h.RT().RM();
        this.eKN = bVar;
        AppMethodBeat.o(123273);
    }

    public final void RX() {
        AppMethodBeat.i(123274);
        Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.eKN);
        AppMethodBeat.o(123274);
    }

    public final void Bd() {
        AppMethodBeat.i(123275);
        eKQ = SystemClock.elapsedRealtime();
        k("hello WeChat.", new Object[0]);
        this.eKN.Bd();
        AppMethodBeat.o(123275);
    }

    public static final void k(String str, Object... objArr) {
        AppMethodBeat.i(123279);
        if (objArr.length == 0) {
            j.i("MMSkeleton.Boot", str, new Object[0]);
            AppMethodBeat.o(123279);
            return;
        }
        j.i("MMSkeleton.Boot", str, objArr);
        AppMethodBeat.o(123279);
    }

    public static String fd(long j) {
        AppMethodBeat.i(123280);
        String str = (System.currentTimeMillis() - j) + "ms";
        AppMethodBeat.o(123280);
        return str;
    }

    public final void Be() {
        AppMethodBeat.i(123276);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot install plugins...", new Object[0]);
        this.eKN.Be();
        this.mConfigured = true;
        k("boot all installed plugins : %s...", h.RT().RL().Rm());
        k("boot install plugins done in [%s].", fd(currentTimeMillis));
        AppMethodBeat.o(123276);
    }

    public final void RY() {
        AppMethodBeat.i(123277);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot make dependency of plugins...", new Object[0]);
        this.eKN.RY();
        k("boot make dependency of done in [%s].", fd(currentTimeMillis));
        AppMethodBeat.o(123277);
    }

    public final void a(g gVar) {
        AppMethodBeat.i(123278);
        long currentTimeMillis = System.currentTimeMillis();
        k("boot configure plugins...", new Object[0]);
        this.eKN.a(gVar);
        k("boot configure plugins done in [%s].", fd(currentTimeMillis));
        AppMethodBeat.o(123278);
    }
}
