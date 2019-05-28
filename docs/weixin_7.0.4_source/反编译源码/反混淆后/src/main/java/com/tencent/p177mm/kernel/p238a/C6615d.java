package com.tencent.p177mm.kernel.p238a;

import com.tencent.p177mm.blink.C1311a;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.blink.C1314b.C13122;
import com.tencent.p177mm.blink.C1314b.C1313b;
import com.tencent.p177mm.compatible.p221e.C1422n;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1669a;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.api.C1673e;
import com.tencent.p177mm.kernel.api.C1676h;
import com.tencent.p177mm.kernel.p238a.C6610c.C65991;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e.C1660c;
import com.tencent.p177mm.kernel.p238a.p240b.C1661e.C1662b;
import com.tencent.p177mm.kernel.p238a.p240b.C6598g;
import com.tencent.p177mm.kernel.p238a.p715c.C6609b;
import com.tencent.p177mm.kernel.p241b.C1678b;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C1813aj;
import com.tencent.p177mm.p230g.p231a.C6521ml;
import com.tencent.p177mm.p230g.p231a.C6522mm;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.kernel.a.d */
public abstract class C6615d implements C1666b {
    public C1661e<Object> eLv = C1661e.m3357Sr();
    private final HashSet<String> eLw = new HashSet();

    /* renamed from: Bd */
    public void mo5147Bd() {
        C4990ab.m7417i("MicroMsg.ParallelsBootStep", "core num %s for parallels", Integer.valueOf((int) Math.min(Math.floor((((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG() ? 1.5d : 1.0d) * ((double) C1422n.getNumCores())), 6.0d)));
        this.eLv.init(r0);
        C6610c Sa = C6610c.m10890Sa();
        Sa.eKT.mo14815a(C1678b.class);
        Sa.eKS.mo14815a(C6609b.class);
        Sa.eKU.mo14815a(C1676h.class, C1669a.class, C1673e.class, C1813aj.class, C1671c.class);
        C6598g c6598g = Sa.eKU;
        Class[] clsArr = new Class[]{C1671c.class};
        c6598g.eMg = new Class[1];
        System.arraycopy(clsArr, 0, c6598g.eMg, 0, 1);
        ((C6624h) C1720g.m3533RM().mo5224Rn()).eJE.eKM = new C65991();
        C1311a.m2807jD("helloWeChat");
    }

    /* renamed from: Q */
    public static void m10917Q(Class<? extends C7597f> cls) {
        C1720g.m3532RL().mo5212I(cls);
    }

    /* renamed from: lO */
    protected static void m10918lO(String str) {
        C1720g.m3532RL().mo5222lH(str);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: lP */
    public final void mo14831lP(String str) {
        this.eLw.add(str);
    }

    /* renamed from: RY */
    public final void mo5149RY() {
        C1720g.m3532RL().mo5217Rl();
        this.eLv.prepare();
        for (C1660c c1660c : this.eLv.mo5140St()) {
            C6610c.m10890Sa().mo14826d(c1660c.cet.getLooper());
        }
        C1311a.m2807jD("makeDependency");
    }

    /* renamed from: a */
    public void mo5151a(C1681g c1681g) {
        this.eLv.mo5141a(new C1662b(), C6610c.eLc, C6610c.m10890Sa().eKT, "configure-functional plugins");
        C1311a.m2807jD("configurePlugins");
        C4879a.xxA.mo10055m(new C6521ml());
    }

    /* renamed from: RZ */
    public final void mo5150RZ() {
        this.eLv.mo5141a(new C1662b(), C6610c.eLd, C6610c.m10890Sa().eKS, "task-functional plugins");
        C1311a.m2807jD("executeTasks");
    }

    /* renamed from: b */
    public void mo5152b(C1681g c1681g) {
        C1651a.m3339k("startup final step, account initialize... for parallels", new Object[0]);
        if (c1681g.mo5181SG()) {
            C6610c Sa = C6610c.m10890Sa();
            for (C7597f aA : C1720g.m3532RL().mo5218Rm()) {
                Sa.mo14822aA(aA);
            }
            if (C1720g.m3534RN().mo5161QY()) {
                C1720g.m3534RN().mo5156QP();
            }
        }
        C1311a.m2807jD("installPendingPlugins");
        long nanoTime = System.nanoTime();
        if (this.eLw.size() > 0) {
            Iterator it = this.eLw.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                C1720g.m3537RQ();
                C1720g.m3532RL().mo5223u(str, true);
            }
            this.eLw.clear();
            C1311a.m2804h("installPendingPlugins installed", nanoTime);
            C1720g.m3537RQ();
            C1720g.m3532RL().mo5217Rl();
            C1311a.m2807jD("installPendingPlugins dependency made.");
            C4879a.xxA.mo10055m(new C6522mm());
        }
        boolean Bg = mo14830Bg();
        boolean z = c1681g.mo5181SG() && C1720g.m3534RN().mo5161QY();
        if (z && !Bg) {
            C1720g.m3534RN().mo5162QZ();
        }
        C1314b HQ = C1314b.m2812HQ();
        C4990ab.m7417i("MicroMsg.FirstScreenArrangement", "arrangeInitializePendingPlugins now? %s", Boolean.valueOf(Bg));
        if (Bg) {
            HQ.mo4641a(C1313b.Now);
        } else {
            C5004al.m7442n(new C13122(), 1000);
        }
        if (z && Bg) {
            C1720g.m3534RN().mo5162QZ();
        }
        C1311a.m2807jD("afterAccountInit");
    }

    /* renamed from: Bg */
    public boolean mo14830Bg() {
        return true;
    }
}
