package com.tencent.p177mm.pluginsdk.p1077c;

import com.tencent.p177mm.p230g.p231a.C42015jp;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.pluginsdk.c.a */
public abstract class C40418a extends C4884c<C42015jp> {
    protected ArrayList<String> vaJ;

    /* renamed from: j */
    public abstract void mo39062j(C4883b c4883b);

    public C40418a() {
        this.vaJ = new ArrayList(3);
        this.xxI = C42015jp.class.getName().hashCode();
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        C42015jp c42015jp = (C42015jp) c4883b;
        if ((c42015jp instanceof C42015jp) && c42015jp.cEP.cEQ != null && this.vaJ.contains(c42015jp.cEP.cEQ.getClass().getName())) {
            mo39062j(c42015jp.cEP.cEQ);
        }
        return false;
    }

    /* renamed from: a */
    public static void m69321a(String str, C40418a c40418a) {
        if (!c40418a.vaJ.contains(str)) {
            c40418a.vaJ.add(str);
        }
        C4879a.xxA.mo10052c(c40418a);
        C14825e.ait(str);
    }

    /* renamed from: b */
    public static void m69322b(String str, C40418a c40418a) {
        C14825e.aiu(str);
        C4879a.xxA.mo10053d(c40418a);
        if (c40418a.vaJ.contains(str)) {
            c40418a.vaJ.remove(str);
        }
    }
}
