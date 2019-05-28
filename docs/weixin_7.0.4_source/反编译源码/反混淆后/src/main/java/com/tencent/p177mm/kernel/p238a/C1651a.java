package com.tencent.p177mm.kernel.p238a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1728h;
import com.tencent.p177mm.kernel.C1736j;
import com.tencent.p177mm.kernel.p238a.p239a.C1650b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.kernel.a.a */
public final class C1651a {
    public static long eKO;
    public static long eKP;
    public static long eKQ;
    public C1650b eKM;
    public C1666b eKN;
    private volatile boolean mConfigured = false;

    /* renamed from: a */
    public final void mo5127a(C1666b c1666b) {
        AppMethodBeat.m2504i(123273);
        Assert.assertNotNull(c1666b);
        C1728h.m3566RT().mo5266RM();
        this.eKN = c1666b;
        AppMethodBeat.m2505o(123273);
    }

    /* renamed from: RX */
    public final void mo5125RX() {
        AppMethodBeat.m2504i(123274);
        Assert.assertNotNull("You must call whichBootStep(BootStep defaultOne, BootStep ... bootSteps) to specify your BootStep instance first!", this.eKN);
        AppMethodBeat.m2505o(123274);
    }

    /* renamed from: Bd */
    public final void mo5123Bd() {
        AppMethodBeat.m2504i(123275);
        eKQ = SystemClock.elapsedRealtime();
        C1651a.m3339k("hello WeChat.", new Object[0]);
        this.eKN.mo5147Bd();
        AppMethodBeat.m2505o(123275);
    }

    /* renamed from: k */
    public static final void m3339k(String str, Object... objArr) {
        AppMethodBeat.m2504i(123279);
        if (objArr.length == 0) {
            C1736j.m3587i("MMSkeleton.Boot", str, new Object[0]);
            AppMethodBeat.m2505o(123279);
            return;
        }
        C1736j.m3587i("MMSkeleton.Boot", str, objArr);
        AppMethodBeat.m2505o(123279);
    }

    /* renamed from: fd */
    public static String m3338fd(long j) {
        AppMethodBeat.m2504i(123280);
        String str = (System.currentTimeMillis() - j) + "ms";
        AppMethodBeat.m2505o(123280);
        return str;
    }

    /* renamed from: Be */
    public final void mo5124Be() {
        AppMethodBeat.m2504i(123276);
        long currentTimeMillis = System.currentTimeMillis();
        C1651a.m3339k("boot install plugins...", new Object[0]);
        this.eKN.mo5148Be();
        this.mConfigured = true;
        C1651a.m3339k("boot all installed plugins : %s...", C1728h.m3566RT().mo5265RL().mo5218Rm());
        C1651a.m3339k("boot install plugins done in [%s].", C1651a.m3338fd(currentTimeMillis));
        AppMethodBeat.m2505o(123276);
    }

    /* renamed from: RY */
    public final void mo5126RY() {
        AppMethodBeat.m2504i(123277);
        long currentTimeMillis = System.currentTimeMillis();
        C1651a.m3339k("boot make dependency of plugins...", new Object[0]);
        this.eKN.mo5149RY();
        C1651a.m3339k("boot make dependency of done in [%s].", C1651a.m3338fd(currentTimeMillis));
        AppMethodBeat.m2505o(123277);
    }

    /* renamed from: a */
    public final void mo5128a(C1681g c1681g) {
        AppMethodBeat.m2504i(123278);
        long currentTimeMillis = System.currentTimeMillis();
        C1651a.m3339k("boot configure plugins...", new Object[0]);
        this.eKN.mo5151a(c1681g);
        C1651a.m3339k("boot configure plugins done in [%s].", C1651a.m3338fd(currentTimeMillis));
        AppMethodBeat.m2505o(123278);
    }
}
